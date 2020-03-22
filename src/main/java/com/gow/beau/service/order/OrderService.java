package com.gow.beau.service.order;

import com.auth0.jwt.JWT;
import com.gow.beau.api.login.LoginCustomer;
import com.gow.beau.api.payment.PayMent;
import com.gow.beau.model.data.PageInfo;
import com.gow.beau.model.req.order.*;
import com.gow.beau.model.rsp.order.*;
import com.gow.beau.service.customer.CustomerAddressService;
import com.gow.beau.service.goods.GoodsService;
import com.gow.beau.service.ordergoods.OrderGoodsService;
import com.gow.beau.service.payment.PaymentService;
import com.gow.beau.service.shoppingcart.ShoppingCartService;
import com.gow.beau.storage.auto.mapper.OrderGoodsMapper;
import com.gow.beau.storage.auto.mapper.OrderMapper;
import com.gow.beau.storage.auto.model.*;
import com.gow.beau.storage.ext.mapper.OrderExtMapper;
import com.gow.beau.util.BeanUtil;
import com.gow.beau.util.CodeUtil;
import com.gow.beau.util.SettingValueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lzn on 2019/3/6.
 */
@Service
public class OrderService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private CustomerAddressService customerAddressService;

    @Autowired
    private OrderExtMapper orderExtMapper;

    @Autowired
    private OrderGoodsService orderGoodsService;

    @Autowired
    private PaymentService paymentService;

    /**
     * lzn 2019/3/6 9:00
     * 确认下单信息
     */
    public OrderConfirmPageRsp orderConfirmInfo(OrderConfirmPageReq req) {
        //返回对象
        OrderConfirmPageRsp rsp = new OrderConfirmPageRsp();
        List<OrderConfirmGoodsRsp> orderConfirmGoodsRspList = new ArrayList<>();
        rsp.setOrderConfirmGoodsRspList(orderConfirmGoodsRspList);

        //如果没有商品id 和 购物车信息，则new 一个新的对象，避免前端报错
        if(null == req.getGoodsId() && req.getShoppingCartds().size() == 0){
            OrderConfirmGoodsRsp goodsRsp = new OrderConfirmGoodsRsp();
            orderConfirmGoodsRspList.add(goodsRsp);

            rsp.setExpressPrice(0);
            rsp.setGoodsSumNumber(0);
            rsp.setSumPrice(new BigDecimal(0));
        }

        //立即购买
        if(null != req.getGoodsId()){
            OrderConfirmGoodsRsp goodsRsp = this.getOrderConfirmGoodsRsp(req.getGoodsId(),req.getGoodsNumber());
            orderConfirmGoodsRspList.add(goodsRsp);

            rsp.setExpressPrice(0);
            rsp.setGoodsSumNumber(req.getGoodsNumber());
            rsp.setSumPrice(goodsRsp.getGoodsPrice());
        }

        //购物车购买
        if(null != req.getShoppingCartds() && req.getShoppingCartds().size() >0 ){
            //总数量
            int sumNumber = 0;
            //总金额
            BigDecimal sumPrice = new BigDecimal(0);

            for(Long shoppCartId : req.getShoppingCartds()){
                ShoppingCart shoppingCart = shoppingCartService.getShoppingCart(shoppCartId);
                if(null == shoppingCart){
                    throw new RuntimeException("没有此购物车信息");
                }

                OrderConfirmGoodsRsp goodsRsp = this.getOrderConfirmGoodsRsp(shoppingCart.getGoodsId(),shoppingCart.getGoodsNumber());
                goodsRsp.setShoppingCartId(shoppCartId);
                orderConfirmGoodsRspList.add(goodsRsp);

                sumNumber += shoppingCart.getGoodsNumber();
                sumPrice = sumPrice.add(goodsRsp.getGoodsSumPrice());
            }

            rsp.setExpressPrice(0);
            rsp.setGoodsSumNumber(sumNumber);
            rsp.setSumPrice(sumPrice);
        }

        //收货地址
        OrderConfirmAddressRsp orderConfirmAddressRsp = this.getOrderConfirmAddressRsp(req.getCustomerId());
        rsp.setOrderConfirmAddressRsp(orderConfirmAddressRsp);

        return rsp;
    }

    /**
     * lzn 2019/3/6 12:09
     * 处理确认订单页面的商品信息
     */
    private OrderConfirmGoodsRsp getOrderConfirmGoodsRsp(Long goodsId,int goodsNumber){
        Goods goods = goodsService.selectGoodsInfo(goodsId);
        if(null == goods){
            throw new RuntimeException("没有此商品信息");
        }

        OrderConfirmGoodsRsp goodsRsp = new OrderConfirmGoodsRsp();
        goodsRsp.setId(goods.getId());
        goodsRsp.setGoodsDeno(goods.getGoodsDeno());
        goodsRsp.setGoodsDetailImg(goods.getGoodsDetailImg());
        goodsRsp.setGoodsName(goods.getGoodsName());
        goodsRsp.setGoodsNo(goods.getGoodsNo());
        goodsRsp.setGoodsNumber(goodsNumber);
        goodsRsp.setGoodsSpec(goods.getGoodsSpec());
        goodsRsp.setGoodsImg(goods.getGoodsImg());
        goodsRsp.setGoodsPrice(goods.getGoodsPrice());
        //计算金额
        BigDecimal sumPrice = goods.getGoodsPrice().multiply(new BigDecimal(goodsNumber));
        goodsRsp.setGoodsSumPrice(sumPrice);

        return goodsRsp;
    }

    /**
     * lzn 2019/3/6 20:29
     * 处理收货地址
     */
    private OrderConfirmAddressRsp getOrderConfirmAddressRsp(Long customerId){
        //查询会员的默认收货地址
        OrderConfirmAddressRsp orderConfirmAddressRsp = customerAddressService.selectIsDefaultAddressByCustomerId(customerId);
        if(null != orderConfirmAddressRsp){
            return orderConfirmAddressRsp;
        }else{
            //如果没有默认地址,则从最近的订单里找收货地址
            Long shoppingAddrtId = orderExtMapper.selectShoppingCartIdByCustomerId(customerId);
            if(null != shoppingAddrtId){
                CustomerAddress address = customerAddressService.getCustomerAddress(shoppingAddrtId);
                if(null != address){
                    //组装字段的值
                    orderConfirmAddressRsp = new OrderConfirmAddressRsp();
                    return (OrderConfirmAddressRsp)SettingValueUtil.settingObject2(address,orderConfirmAddressRsp);
                }
            }

            //如果没有订单（没有订单则没有地址）,则找最新添加的地址
            orderConfirmAddressRsp = customerAddressService.selectLatestAddressByCustomerId(customerId);
            return orderConfirmAddressRsp;
        }
    }

    /**
     * lzn 2019/3/12 11:12
     * 提交订单，保存订单
     */
    public SaveOrderRsp saveOrder(HttpServletRequest request,SaveOrderReq req) {
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return null;
        }
        req.setCustomerId(customerId);

        Order order = new Order();

        //创建时间
        Date createDate = new Date();
        order.setCreateTime(createDate);
        //会员id
        order.setCustomerId(req.getCustomerId());
        //订单状态(0:待付款，1:待发货，2:待收货)
        order.setOrderStatus("0");
        //客户留言
        order.setCustomerRemark(req.getOrderMessage());
        //运费
        order.setExpressPrice(req.getExpressPrice());
        //订单编号
        order.setOrderCode(CodeUtil.orderCode(req.getCustomerId()));

        //收货地址
        CustomerAddress address = customerAddressService.getCustomerAddress(req.getAddressId());
        if(null != address){
            order.setShoppingAddrId(address.getId());
            order.setShippingProvince(address.getAddressProvince());
            order.setShippingCity(address.getAddressCity());
            order.setShippingCounty(address.getAddressCounty());
            order.setShippingStreet(address.getAddressStreet());
            order.setShippingAddress(address.getAddressDetail());
            order.setShippingPerson(address.getAddressName());
            order.setShippingPhone(address.getAddressPhone());
            order.setSendMobile(address.getAddressPhone());
            order.setShippingPostcode(address.getAddressEmail());
        }

        //商品信息,订单商品信息处理， 并修改购物车购买标识
        List<OrderGoods> orderGoodsList = this.getOrderGoodsList(req.getGoodsReqs());
        //计算订单小计金额，保存订单 和 保存订单商品信息
        if(null != orderGoodsList){
            BigDecimal orderPrice = new BigDecimal(0);
            //计算订单总金额
            for(OrderGoods orderGoods : orderGoodsList){
                //所有小计金额相加
                orderPrice = orderPrice.add(orderGoods.getGoodsInfoSumPrice());
            }
            //订单金额
            order.setOrderPrice(orderPrice);
            //保存订单
            int count = orderMapper.insertSelective(order);

            if(count > 0) {
                //保存订单商品
                for (OrderGoods orderGoods : orderGoodsList) {
                    orderGoods.setOrderId(order.getId());
                    //保存订单商品
                    orderGoodsMapper.insertSelective(orderGoods);
                }
            }

            //返回信息
            SaveOrderRsp rsp = new SaveOrderRsp();
            rsp.setOrderCode(order.getOrderCode());
            rsp.setOrderPrice(order.getOrderPrice());
            return rsp;
        }
        return null;
    }

    /**
     * lzn 2019/3/12 12:25
     * 查询订单商品信息
     * 并修改购物车购买标识
     */
    private List<OrderGoods> getOrderGoodsList(List<SaveOrderGoodsReq> goodsReqList){
        if(null == goodsReqList || goodsReqList.size() == 0){
            return null;
        }

        List<OrderGoods> orderGoodsList = new ArrayList<>();
        //商品信息
        for(SaveOrderGoodsReq goodsReq : goodsReqList){
            Goods goods = goodsService.selectGoodsInfo(goodsReq.getGoodsId());
            if(null != goods){
                OrderGoods orderGoods = new OrderGoods();
                orderGoodsList.add(orderGoods);

                orderGoods.setGoodsId(goods.getId());
                orderGoods.setGoodsName(goods.getGoodsName());
                orderGoods.setGoodsSpec(goods.getGoodsSpec());
                orderGoods.setGoodsImg(goods.getGoodsImg());
                //单个商品数量
                orderGoods.setGoodsNumber(goodsReq.getGoodsNumber());
                //单价
                orderGoods.setGoodsInfoPrice(goods.getGoodsPrice());
                //小计金额(单价 * 数量)
                orderGoods.setGoodsInfoSumPrice(orderGoods.getGoodsInfoPrice().multiply(new BigDecimal(orderGoods.getGoodsNumber())));

                //修改购物车购买标识
                this.isShop(goodsReq.getShoppingCartId());
            }
        }
        return orderGoodsList;
    }

    /**
     * lzn 2019/3/13 21:04
     * 标识购物车已经购买
     */
    private int isShop(Long shoppingCartId){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartId);
        shoppingCart.setIsShop("1");
        int count = shoppingCartService.updateShoppingCart(shoppingCart);
        return count;
    }

    /**
     * lzn 2019/3/12 16:44
     * 订单列表
     */
    public List<OrderListRsp> orderList(HttpServletRequest request,OrderListReq req) {
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return null;
        }
        req.setCustomerId(customerId);

        if(req.getOrderStatus().equals("-1")){
            //查询待评价的订单状态3：交易完成
            req.setOrderStatus("3");
            req.setEvaluateFlag("0");
        }
        List<Order> orderList = orderExtMapper.orderList(req);
        if(null == orderList || orderList.size() == 0 ){
            return null;
        }
        List<OrderListRsp> orderListRspList = new ArrayList<>();
        for(Order order : orderList){
            OrderListRsp rsp = new OrderListRsp();
            orderListRspList.add(rsp);

            //订单信息
            rsp.setOrderCode(order.getOrderCode());
            rsp.setOrderId(order.getId());
            rsp.setOrderStatus(order.getOrderStatus());
            rsp.setExpressPrice(order.getExpressPrice());
            rsp.setOrderPrice(order.getOrderPrice());

            //订单商品信息
            List<OrderListGoodsRsp> orderListGoodsRspList = orderGoodsService.selectOrderGoodsListByOrderId(order.getId());
            rsp.setOrderListGoodsRsps(orderListGoodsRspList);

            //计算商品的数量
            if(null == orderListGoodsRspList || orderListGoodsRspList.size() ==0 ){
                rsp.setSumGoodsNumber(0);
            }else{
                Integer sumNumber = 0;
                for(OrderListGoodsRsp goodsRsp : orderListGoodsRspList){
                    sumNumber += goodsRsp.getGoodsNumber();
                }
                rsp.setSumGoodsNumber(sumNumber);
            }
        }
        return orderListRspList;
    }

    /**
     * lzn 2019/3/14 15:44
     * 查询订单各个状态的数量
     */
    public OrderStatusNumbersRsp orderStatusNumbers(HttpServletRequest request, OrderStatusNumbersReq req) {
        Long customerId = LoginCustomer.getCustomerIdByToken(request);
        if(null == customerId){
            return null;
        }
        req.setCustomerId(customerId);
        //待付款
        int paymentStatusNumber = this.number(req.getCustomerId(),"0",null);
        //待收货
        int sendGoodsStatusNumber = this.number(req.getCustomerId(),"1",null);
        //代发货
        int theGoodsStatusNumber = this.number(req.getCustomerId(),"2",null);
        //待评价(订单状态3：交易完成)
        int evaluateStatusNumber = this.number(req.getCustomerId(),"3","0");
        OrderStatusNumbersRsp rsp = new OrderStatusNumbersRsp();
        rsp.setPaymentStatusNumber(paymentStatusNumber);
        rsp.setSendGoodsStatusNumber(sendGoodsStatusNumber);
        rsp.setTheGoodsStatusNumber(theGoodsStatusNumber);
        rsp.setEvaluateStatusNumber(evaluateStatusNumber);
        return rsp;
    }

    /**
     * lzn 2019/3/14 15:52
     * 根据会员id 和 订单状态（或评价状态）查询订单数量
     */
    private int number(Long customerId,String orderStatus,String evaluateFlag){
        return orderExtMapper.orderStatusNumbers(customerId,orderStatus,evaluateFlag);
    }

    /**
     * lzn 2019/3/15 11:26
     * 确认收货
     */
    public int confirmReceipt(ConfirmReceiptReq req) {
        Order order = new Order();
        order.setId(req.getOrderId());
        //3：交易成功
        order.setOrderStatus("3");
        //收货时间
        order.setGetGoodsTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        return count;
    }

    /**
     * lzn 2019/3/19 15:28
     * 确认支付，去支付，修改订单状态
     */
    public int paymentOrder(PaymentOrderReq req) {
        if(null == req.getOrderCode()){
            return 0;
        }
        Order order = orderExtMapper.selectOrderByOederCode(req.getOrderCode());
        if(null != order) {
            order.setOrderStatus("1");
            order.setPayTime(new Date());
            order.setOrderCode(req.getOrderCode());
            order.setPayType(req.getPayType() == null ? null : req.getPayType());
            order.setPayPrice(req.getPayPrice() == null ? null : req.getPayPrice());
            order.setPlatformTradeNo(req.getPlatformTradeNo());
            order.setKeyValue(req.getKey());
            int count = orderMapper.updateByPrimaryKeySelective(order);
            return count;
        }
        return 0;
    }

    /**
     * lzn 2019/3/29 12:22
     * 去支付
     */
    public String pay(PaymentOrderReq req) {
        //根据订单编号（orderCode）查询订单信息
        Order order = orderExtMapper.selectOrderByOederCode(req.getOrderCode());
        if(null == order){
            return "没有此订单信息："+req.getOrderCode();
        }
        Payment payment = paymentService.selectFirstPaymentInfo("pufpay");
        if(null == payment){
            return "订单支付信息错误";
        }
        //根据订单id查询商品名称
        String goodsNames = orderGoodsService.selectGoodsNamesByorderId(order.getId());
        String result = PayMent.httpsPost(req.getOrderCode(),req.getPayType(),order.getCustomerId().toString(),order.getOrderPrice(),goodsNames,payment);
        return result;
    }

    /**
     * lzn 2019/3/31 15:31
     * 根据订单编号查询订单金额
     */
    public BigDecimal selectOrderPriceByorderCode(String orderCode) {
        return orderExtMapper.selectOrderPriceByorderCode(orderCode);
    }

    /**
     * 根据订单编号查询订单详情
     * */
    public Order getOrder(String orderCode){
        return orderExtMapper.getOrder(orderCode);
    }


    /**
     * 订单管理页面--订单列表
     * */
    public PageInfo getOrderListPage(OrderListReq req){
        //计算分页信息
        PageInfo pageInfo = new PageInfo(req.getPageNo());
        req.setStartRowNum(pageInfo.getStartRowNum());
        req.setEndRowNum(pageInfo.getEndRowNum());

        //分页数据
        List<Order> orderList = orderExtMapper.getOrderListPage(req);
        if(!CollectionUtils.isEmpty(orderList)) {
            List<OrderListPageRsp> rspList = new ArrayList<>();
            for(Order order : orderList) {
                OrderListPageRsp rsp = new OrderListPageRsp();
                BeanUtil.copyProperties(order, rsp);
                rspList.add(rsp);

                rsp.setGoodsRspList(orderGoodsService.selectOrderGoodsListByOrderId(rsp.getId()));
            }
            pageInfo.setList(rspList);
            pageInfo.setRows(this.getOrderPageRows(req));
        }
        return pageInfo;
    }

    /**
     * 订单管理页面--订单列表总数
     * */
    private int getOrderPageRows(OrderListReq req){
        return orderExtMapper.getOrderPageRows(req);
    }


    /**
     * 订单管理 - 物流发货
     * */
    public int orderExpressSubmit(OrderExpressReq req){
        //根据订单id 查询订单信息
        Order order = orderMapper.selectByPrimaryKey(req.getOrderId());
        if(null == order){
            return -1;
        }
        if(null == order.getOrderStatus() || !order.getOrderStatus().equals("1")){
            return -2;
        }
        //比较订单总金额和支付金额,-1表示小于，0是等于，1是大于
        if(order.getOrderPrice().compareTo(order.getPayPrice()) != 0){
            //return -3;
        }
        if(null != order.getExpressCode()){
            return -4;
        }
        Order saveOrder = new Order();
        saveOrder.setId(order.getId());
        saveOrder.setSendExpressTime(new Date());
        saveOrder.setExpressName(req.getExpressName());
        saveOrder.setExpressCode(req.getExpressCode());
        //订单状态改为'2:待收货'
        saveOrder.setOrderStatus("2");
        //修改保存发货信息
        return orderMapper.updateByPrimaryKeySelective(saveOrder);
    }


    /***/
    public OrderDetailPageRsp getOrderDetailInfo(Long orderId){
        //返回对象
        OrderDetailPageRsp rsp = new OrderDetailPageRsp();
        List<OrderGoodsDetailRsp> orderGoodsDetailRspList = new ArrayList<>();
        rsp.setOrderGoodsDetailRspList(orderGoodsDetailRspList);

        //查询订单信息
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if(null == order){
            return rsp;
        }
        BeanUtil.copyProperties(order, rsp);
        //收货信息处理
        rsp.setShippingPostcode(rsp.getShippingPostcode()==null?"":rsp.getShippingPostcode());
        rsp.setShippingCity(rsp.getShippingCity()==null?"":rsp.getShippingCity());
        rsp.setShippingCounty(rsp.getShippingCounty()==null?"":rsp.getShippingCounty());
        rsp.setShippingStreet(rsp.getShippingStreet()==null?"":rsp.getShippingStreet());
        rsp.setShippingAddress(rsp.getShippingAddress()==null?"":rsp.getShippingAddress());
        rsp.setShippingPerson(rsp.getShippingPerson()==null?"":rsp.getShippingPerson());
        rsp.setShippingPhone(rsp.getShippingPhone()==null?"":rsp.getShippingPhone());
        //查询订单商品列表
        orderGoodsDetailRspList = orderGoodsService.selectOrderGoodsDetailListByOrderId(orderId);
        rsp.setOrderGoodsDetailRspList(orderGoodsDetailRspList);
        return rsp;
    }
}
