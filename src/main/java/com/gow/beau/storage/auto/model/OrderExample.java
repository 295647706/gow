package com.gow.beau.storage.auto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(BigDecimal value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(BigDecimal value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<BigDecimal> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNull() {
            addCriterion("pay_price is null");
            return (Criteria) this;
        }

        public Criteria andPayPriceIsNotNull() {
            addCriterion("pay_price is not null");
            return (Criteria) this;
        }

        public Criteria andPayPriceEqualTo(BigDecimal value) {
            addCriterion("pay_price =", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotEqualTo(BigDecimal value) {
            addCriterion("pay_price <>", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThan(BigDecimal value) {
            addCriterion("pay_price >", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price >=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThan(BigDecimal value) {
            addCriterion("pay_price <", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_price <=", value, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceIn(List<BigDecimal> values) {
            addCriterion("pay_price in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotIn(List<BigDecimal> values) {
            addCriterion("pay_price not in", values, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andPayPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_price not between", value1, value2, "payPrice");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeIsNull() {
            addCriterion("send_express_time is null");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeIsNotNull() {
            addCriterion("send_express_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeEqualTo(Date value) {
            addCriterion("send_express_time =", value, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeNotEqualTo(Date value) {
            addCriterion("send_express_time <>", value, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeGreaterThan(Date value) {
            addCriterion("send_express_time >", value, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_express_time >=", value, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeLessThan(Date value) {
            addCriterion("send_express_time <", value, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_express_time <=", value, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeIn(List<Date> values) {
            addCriterion("send_express_time in", values, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeNotIn(List<Date> values) {
            addCriterion("send_express_time not in", values, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeBetween(Date value1, Date value2) {
            addCriterion("send_express_time between", value1, value2, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andSendExpressTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_express_time not between", value1, value2, "sendExpressTime");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNull() {
            addCriterion("express_name is null");
            return (Criteria) this;
        }

        public Criteria andExpressNameIsNotNull() {
            addCriterion("express_name is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNameEqualTo(String value) {
            addCriterion("express_name =", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            addCriterion("express_name <>", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThan(String value) {
            addCriterion("express_name >", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            addCriterion("express_name >=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThan(String value) {
            addCriterion("express_name <", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            addCriterion("express_name <=", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameLike(String value) {
            addCriterion("express_name like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotLike(String value) {
            addCriterion("express_name not like", value, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameIn(List<String> values) {
            addCriterion("express_name in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            addCriterion("express_name not in", values, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            addCriterion("express_name between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            addCriterion("express_name not between", value1, value2, "expressName");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNull() {
            addCriterion("express_code is null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIsNotNull() {
            addCriterion("express_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCodeEqualTo(String value) {
            addCriterion("express_code =", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            addCriterion("express_code <>", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            addCriterion("express_code >", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            addCriterion("express_code >=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThan(String value) {
            addCriterion("express_code <", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            addCriterion("express_code <=", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeLike(String value) {
            addCriterion("express_code like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotLike(String value) {
            addCriterion("express_code not like", value, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeIn(List<String> values) {
            addCriterion("express_code in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            addCriterion("express_code not in", values, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            addCriterion("express_code between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            addCriterion("express_code not between", value1, value2, "expressCode");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeIsNull() {
            addCriterion("get_goods_time is null");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeIsNotNull() {
            addCriterion("get_goods_time is not null");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeEqualTo(Date value) {
            addCriterion("get_goods_time =", value, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeNotEqualTo(Date value) {
            addCriterion("get_goods_time <>", value, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeGreaterThan(Date value) {
            addCriterion("get_goods_time >", value, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("get_goods_time >=", value, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeLessThan(Date value) {
            addCriterion("get_goods_time <", value, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeLessThanOrEqualTo(Date value) {
            addCriterion("get_goods_time <=", value, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeIn(List<Date> values) {
            addCriterion("get_goods_time in", values, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeNotIn(List<Date> values) {
            addCriterion("get_goods_time not in", values, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeBetween(Date value1, Date value2) {
            addCriterion("get_goods_time between", value1, value2, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andGetGoodsTimeNotBetween(Date value1, Date value2) {
            addCriterion("get_goods_time not between", value1, value2, "getGoodsTime");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdIsNull() {
            addCriterion("shopping_addr_id is null");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdIsNotNull() {
            addCriterion("shopping_addr_id is not null");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdEqualTo(Long value) {
            addCriterion("shopping_addr_id =", value, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdNotEqualTo(Long value) {
            addCriterion("shopping_addr_id <>", value, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdGreaterThan(Long value) {
            addCriterion("shopping_addr_id >", value, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shopping_addr_id >=", value, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdLessThan(Long value) {
            addCriterion("shopping_addr_id <", value, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdLessThanOrEqualTo(Long value) {
            addCriterion("shopping_addr_id <=", value, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdIn(List<Long> values) {
            addCriterion("shopping_addr_id in", values, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdNotIn(List<Long> values) {
            addCriterion("shopping_addr_id not in", values, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdBetween(Long value1, Long value2) {
            addCriterion("shopping_addr_id between", value1, value2, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShoppingAddrIdNotBetween(Long value1, Long value2) {
            addCriterion("shopping_addr_id not between", value1, value2, "shoppingAddrId");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceIsNull() {
            addCriterion("shipping_province is null");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceIsNotNull() {
            addCriterion("shipping_province is not null");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceEqualTo(String value) {
            addCriterion("shipping_province =", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceNotEqualTo(String value) {
            addCriterion("shipping_province <>", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceGreaterThan(String value) {
            addCriterion("shipping_province >", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_province >=", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceLessThan(String value) {
            addCriterion("shipping_province <", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceLessThanOrEqualTo(String value) {
            addCriterion("shipping_province <=", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceLike(String value) {
            addCriterion("shipping_province like", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceNotLike(String value) {
            addCriterion("shipping_province not like", value, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceIn(List<String> values) {
            addCriterion("shipping_province in", values, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceNotIn(List<String> values) {
            addCriterion("shipping_province not in", values, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceBetween(String value1, String value2) {
            addCriterion("shipping_province between", value1, value2, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingProvinceNotBetween(String value1, String value2) {
            addCriterion("shipping_province not between", value1, value2, "shippingProvince");
            return (Criteria) this;
        }

        public Criteria andShippingCityIsNull() {
            addCriterion("shipping_city is null");
            return (Criteria) this;
        }

        public Criteria andShippingCityIsNotNull() {
            addCriterion("shipping_city is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCityEqualTo(String value) {
            addCriterion("shipping_city =", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityNotEqualTo(String value) {
            addCriterion("shipping_city <>", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityGreaterThan(String value) {
            addCriterion("shipping_city >", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_city >=", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityLessThan(String value) {
            addCriterion("shipping_city <", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityLessThanOrEqualTo(String value) {
            addCriterion("shipping_city <=", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityLike(String value) {
            addCriterion("shipping_city like", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityNotLike(String value) {
            addCriterion("shipping_city not like", value, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityIn(List<String> values) {
            addCriterion("shipping_city in", values, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityNotIn(List<String> values) {
            addCriterion("shipping_city not in", values, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityBetween(String value1, String value2) {
            addCriterion("shipping_city between", value1, value2, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCityNotBetween(String value1, String value2) {
            addCriterion("shipping_city not between", value1, value2, "shippingCity");
            return (Criteria) this;
        }

        public Criteria andShippingCountyIsNull() {
            addCriterion("shipping_county is null");
            return (Criteria) this;
        }

        public Criteria andShippingCountyIsNotNull() {
            addCriterion("shipping_county is not null");
            return (Criteria) this;
        }

        public Criteria andShippingCountyEqualTo(String value) {
            addCriterion("shipping_county =", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyNotEqualTo(String value) {
            addCriterion("shipping_county <>", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyGreaterThan(String value) {
            addCriterion("shipping_county >", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_county >=", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyLessThan(String value) {
            addCriterion("shipping_county <", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyLessThanOrEqualTo(String value) {
            addCriterion("shipping_county <=", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyLike(String value) {
            addCriterion("shipping_county like", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyNotLike(String value) {
            addCriterion("shipping_county not like", value, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyIn(List<String> values) {
            addCriterion("shipping_county in", values, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyNotIn(List<String> values) {
            addCriterion("shipping_county not in", values, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyBetween(String value1, String value2) {
            addCriterion("shipping_county between", value1, value2, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingCountyNotBetween(String value1, String value2) {
            addCriterion("shipping_county not between", value1, value2, "shippingCounty");
            return (Criteria) this;
        }

        public Criteria andShippingStreetIsNull() {
            addCriterion("shipping_street is null");
            return (Criteria) this;
        }

        public Criteria andShippingStreetIsNotNull() {
            addCriterion("shipping_street is not null");
            return (Criteria) this;
        }

        public Criteria andShippingStreetEqualTo(String value) {
            addCriterion("shipping_street =", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetNotEqualTo(String value) {
            addCriterion("shipping_street <>", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetGreaterThan(String value) {
            addCriterion("shipping_street >", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_street >=", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetLessThan(String value) {
            addCriterion("shipping_street <", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetLessThanOrEqualTo(String value) {
            addCriterion("shipping_street <=", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetLike(String value) {
            addCriterion("shipping_street like", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetNotLike(String value) {
            addCriterion("shipping_street not like", value, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetIn(List<String> values) {
            addCriterion("shipping_street in", values, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetNotIn(List<String> values) {
            addCriterion("shipping_street not in", values, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetBetween(String value1, String value2) {
            addCriterion("shipping_street between", value1, value2, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingStreetNotBetween(String value1, String value2) {
            addCriterion("shipping_street not between", value1, value2, "shippingStreet");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNull() {
            addCriterion("shipping_address is null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIsNotNull() {
            addCriterion("shipping_address is not null");
            return (Criteria) this;
        }

        public Criteria andShippingAddressEqualTo(String value) {
            addCriterion("shipping_address =", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotEqualTo(String value) {
            addCriterion("shipping_address <>", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThan(String value) {
            addCriterion("shipping_address >", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_address >=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThan(String value) {
            addCriterion("shipping_address <", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLessThanOrEqualTo(String value) {
            addCriterion("shipping_address <=", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressLike(String value) {
            addCriterion("shipping_address like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotLike(String value) {
            addCriterion("shipping_address not like", value, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressIn(List<String> values) {
            addCriterion("shipping_address in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotIn(List<String> values) {
            addCriterion("shipping_address not in", values, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressBetween(String value1, String value2) {
            addCriterion("shipping_address between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingAddressNotBetween(String value1, String value2) {
            addCriterion("shipping_address not between", value1, value2, "shippingAddress");
            return (Criteria) this;
        }

        public Criteria andShippingPersonIsNull() {
            addCriterion("shipping_person is null");
            return (Criteria) this;
        }

        public Criteria andShippingPersonIsNotNull() {
            addCriterion("shipping_person is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPersonEqualTo(String value) {
            addCriterion("shipping_person =", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonNotEqualTo(String value) {
            addCriterion("shipping_person <>", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonGreaterThan(String value) {
            addCriterion("shipping_person >", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_person >=", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonLessThan(String value) {
            addCriterion("shipping_person <", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonLessThanOrEqualTo(String value) {
            addCriterion("shipping_person <=", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonLike(String value) {
            addCriterion("shipping_person like", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonNotLike(String value) {
            addCriterion("shipping_person not like", value, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonIn(List<String> values) {
            addCriterion("shipping_person in", values, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonNotIn(List<String> values) {
            addCriterion("shipping_person not in", values, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonBetween(String value1, String value2) {
            addCriterion("shipping_person between", value1, value2, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPersonNotBetween(String value1, String value2) {
            addCriterion("shipping_person not between", value1, value2, "shippingPerson");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneIsNull() {
            addCriterion("shipping_phone is null");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneIsNotNull() {
            addCriterion("shipping_phone is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneEqualTo(String value) {
            addCriterion("shipping_phone =", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotEqualTo(String value) {
            addCriterion("shipping_phone <>", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneGreaterThan(String value) {
            addCriterion("shipping_phone >", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_phone >=", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneLessThan(String value) {
            addCriterion("shipping_phone <", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneLessThanOrEqualTo(String value) {
            addCriterion("shipping_phone <=", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneLike(String value) {
            addCriterion("shipping_phone like", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotLike(String value) {
            addCriterion("shipping_phone not like", value, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneIn(List<String> values) {
            addCriterion("shipping_phone in", values, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotIn(List<String> values) {
            addCriterion("shipping_phone not in", values, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneBetween(String value1, String value2) {
            addCriterion("shipping_phone between", value1, value2, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingPhoneNotBetween(String value1, String value2) {
            addCriterion("shipping_phone not between", value1, value2, "shippingPhone");
            return (Criteria) this;
        }

        public Criteria andShippingMobileIsNull() {
            addCriterion("shipping_mobile is null");
            return (Criteria) this;
        }

        public Criteria andShippingMobileIsNotNull() {
            addCriterion("shipping_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andShippingMobileEqualTo(String value) {
            addCriterion("shipping_mobile =", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileNotEqualTo(String value) {
            addCriterion("shipping_mobile <>", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileGreaterThan(String value) {
            addCriterion("shipping_mobile >", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_mobile >=", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileLessThan(String value) {
            addCriterion("shipping_mobile <", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileLessThanOrEqualTo(String value) {
            addCriterion("shipping_mobile <=", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileLike(String value) {
            addCriterion("shipping_mobile like", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileNotLike(String value) {
            addCriterion("shipping_mobile not like", value, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileIn(List<String> values) {
            addCriterion("shipping_mobile in", values, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileNotIn(List<String> values) {
            addCriterion("shipping_mobile not in", values, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileBetween(String value1, String value2) {
            addCriterion("shipping_mobile between", value1, value2, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andShippingMobileNotBetween(String value1, String value2) {
            addCriterion("shipping_mobile not between", value1, value2, "shippingMobile");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentIsNull() {
            addCriterion("invoice_content is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentIsNotNull() {
            addCriterion("invoice_content is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentEqualTo(String value) {
            addCriterion("invoice_content =", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentNotEqualTo(String value) {
            addCriterion("invoice_content <>", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentGreaterThan(String value) {
            addCriterion("invoice_content >", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_content >=", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentLessThan(String value) {
            addCriterion("invoice_content <", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentLessThanOrEqualTo(String value) {
            addCriterion("invoice_content <=", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentLike(String value) {
            addCriterion("invoice_content like", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentNotLike(String value) {
            addCriterion("invoice_content not like", value, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentIn(List<String> values) {
            addCriterion("invoice_content in", values, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentNotIn(List<String> values) {
            addCriterion("invoice_content not in", values, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentBetween(String value1, String value2) {
            addCriterion("invoice_content between", value1, value2, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andInvoiceContentNotBetween(String value1, String value2) {
            addCriterion("invoice_content not between", value1, value2, "invoiceContent");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("invoice_type like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("invoice_type not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkIsNull() {
            addCriterion("customer_remark is null");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkIsNotNull() {
            addCriterion("customer_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkEqualTo(String value) {
            addCriterion("customer_remark =", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotEqualTo(String value) {
            addCriterion("customer_remark <>", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkGreaterThan(String value) {
            addCriterion("customer_remark >", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("customer_remark >=", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkLessThan(String value) {
            addCriterion("customer_remark <", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkLessThanOrEqualTo(String value) {
            addCriterion("customer_remark <=", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkLike(String value) {
            addCriterion("customer_remark like", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotLike(String value) {
            addCriterion("customer_remark not like", value, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkIn(List<String> values) {
            addCriterion("customer_remark in", values, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotIn(List<String> values) {
            addCriterion("customer_remark not in", values, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkBetween(String value1, String value2) {
            addCriterion("customer_remark between", value1, value2, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andCustomerRemarkNotBetween(String value1, String value2) {
            addCriterion("customer_remark not between", value1, value2, "customerRemark");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralIsNull() {
            addCriterion("order_integral is null");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralIsNotNull() {
            addCriterion("order_integral is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralEqualTo(Long value) {
            addCriterion("order_integral =", value, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralNotEqualTo(Long value) {
            addCriterion("order_integral <>", value, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralGreaterThan(Long value) {
            addCriterion("order_integral >", value, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralGreaterThanOrEqualTo(Long value) {
            addCriterion("order_integral >=", value, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralLessThan(Long value) {
            addCriterion("order_integral <", value, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralLessThanOrEqualTo(Long value) {
            addCriterion("order_integral <=", value, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralIn(List<Long> values) {
            addCriterion("order_integral in", values, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralNotIn(List<Long> values) {
            addCriterion("order_integral not in", values, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralBetween(Long value1, Long value2) {
            addCriterion("order_integral between", value1, value2, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andOrderIntegralNotBetween(Long value1, Long value2) {
            addCriterion("order_integral not between", value1, value2, "orderIntegral");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagIsNull() {
            addCriterion("evaluate_flag is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagIsNotNull() {
            addCriterion("evaluate_flag is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagEqualTo(String value) {
            addCriterion("evaluate_flag =", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagNotEqualTo(String value) {
            addCriterion("evaluate_flag <>", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagGreaterThan(String value) {
            addCriterion("evaluate_flag >", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_flag >=", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagLessThan(String value) {
            addCriterion("evaluate_flag <", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagLessThanOrEqualTo(String value) {
            addCriterion("evaluate_flag <=", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagLike(String value) {
            addCriterion("evaluate_flag like", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagNotLike(String value) {
            addCriterion("evaluate_flag not like", value, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagIn(List<String> values) {
            addCriterion("evaluate_flag in", values, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagNotIn(List<String> values) {
            addCriterion("evaluate_flag not in", values, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagBetween(String value1, String value2) {
            addCriterion("evaluate_flag between", value1, value2, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andEvaluateFlagNotBetween(String value1, String value2) {
            addCriterion("evaluate_flag not between", value1, value2, "evaluateFlag");
            return (Criteria) this;
        }

        public Criteria andExpressPriceIsNull() {
            addCriterion("express_price is null");
            return (Criteria) this;
        }

        public Criteria andExpressPriceIsNotNull() {
            addCriterion("express_price is not null");
            return (Criteria) this;
        }

        public Criteria andExpressPriceEqualTo(BigDecimal value) {
            addCriterion("express_price =", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceNotEqualTo(BigDecimal value) {
            addCriterion("express_price <>", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceGreaterThan(BigDecimal value) {
            addCriterion("express_price >", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("express_price >=", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceLessThan(BigDecimal value) {
            addCriterion("express_price <", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("express_price <=", value, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceIn(List<BigDecimal> values) {
            addCriterion("express_price in", values, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceNotIn(List<BigDecimal> values) {
            addCriterion("express_price not in", values, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("express_price between", value1, value2, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andExpressPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("express_price not between", value1, value2, "expressPrice");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeIsNull() {
            addCriterion("shipping_postcode is null");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeIsNotNull() {
            addCriterion("shipping_postcode is not null");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeEqualTo(String value) {
            addCriterion("shipping_postcode =", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeNotEqualTo(String value) {
            addCriterion("shipping_postcode <>", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeGreaterThan(String value) {
            addCriterion("shipping_postcode >", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("shipping_postcode >=", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeLessThan(String value) {
            addCriterion("shipping_postcode <", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeLessThanOrEqualTo(String value) {
            addCriterion("shipping_postcode <=", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeLike(String value) {
            addCriterion("shipping_postcode like", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeNotLike(String value) {
            addCriterion("shipping_postcode not like", value, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeIn(List<String> values) {
            addCriterion("shipping_postcode in", values, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeNotIn(List<String> values) {
            addCriterion("shipping_postcode not in", values, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeBetween(String value1, String value2) {
            addCriterion("shipping_postcode between", value1, value2, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andShippingPostcodeNotBetween(String value1, String value2) {
            addCriterion("shipping_postcode not between", value1, value2, "shippingPostcode");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeIsNull() {
            addCriterion("order_cancel_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeIsNotNull() {
            addCriterion("order_cancel_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeEqualTo(Date value) {
            addCriterion("order_cancel_time =", value, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeNotEqualTo(Date value) {
            addCriterion("order_cancel_time <>", value, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeGreaterThan(Date value) {
            addCriterion("order_cancel_time >", value, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_cancel_time >=", value, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeLessThan(Date value) {
            addCriterion("order_cancel_time <", value, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_cancel_time <=", value, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeIn(List<Date> values) {
            addCriterion("order_cancel_time in", values, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeNotIn(List<Date> values) {
            addCriterion("order_cancel_time not in", values, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeBetween(Date value1, Date value2) {
            addCriterion("order_cancel_time between", value1, value2, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_cancel_time not between", value1, value2, "orderCancelTime");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkIsNull() {
            addCriterion("order_cancel_remark is null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkIsNotNull() {
            addCriterion("order_cancel_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkEqualTo(String value) {
            addCriterion("order_cancel_remark =", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkNotEqualTo(String value) {
            addCriterion("order_cancel_remark <>", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkGreaterThan(String value) {
            addCriterion("order_cancel_remark >", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("order_cancel_remark >=", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkLessThan(String value) {
            addCriterion("order_cancel_remark <", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkLessThanOrEqualTo(String value) {
            addCriterion("order_cancel_remark <=", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkLike(String value) {
            addCriterion("order_cancel_remark like", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkNotLike(String value) {
            addCriterion("order_cancel_remark not like", value, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkIn(List<String> values) {
            addCriterion("order_cancel_remark in", values, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkNotIn(List<String> values) {
            addCriterion("order_cancel_remark not in", values, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkBetween(String value1, String value2) {
            addCriterion("order_cancel_remark between", value1, value2, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andOrderCancelRemarkNotBetween(String value1, String value2) {
            addCriterion("order_cancel_remark not between", value1, value2, "orderCancelRemark");
            return (Criteria) this;
        }

        public Criteria andBackPriceIsNull() {
            addCriterion("back_price is null");
            return (Criteria) this;
        }

        public Criteria andBackPriceIsNotNull() {
            addCriterion("back_price is not null");
            return (Criteria) this;
        }

        public Criteria andBackPriceEqualTo(BigDecimal value) {
            addCriterion("back_price =", value, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceNotEqualTo(BigDecimal value) {
            addCriterion("back_price <>", value, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceGreaterThan(BigDecimal value) {
            addCriterion("back_price >", value, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("back_price >=", value, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceLessThan(BigDecimal value) {
            addCriterion("back_price <", value, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("back_price <=", value, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceIn(List<BigDecimal> values) {
            addCriterion("back_price in", values, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceNotIn(List<BigDecimal> values) {
            addCriterion("back_price not in", values, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("back_price between", value1, value2, "backPrice");
            return (Criteria) this;
        }

        public Criteria andBackPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("back_price not between", value1, value2, "backPrice");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andSendPersonIsNull() {
            addCriterion("send_person is null");
            return (Criteria) this;
        }

        public Criteria andSendPersonIsNotNull() {
            addCriterion("send_person is not null");
            return (Criteria) this;
        }

        public Criteria andSendPersonEqualTo(String value) {
            addCriterion("send_person =", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonNotEqualTo(String value) {
            addCriterion("send_person <>", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonGreaterThan(String value) {
            addCriterion("send_person >", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonGreaterThanOrEqualTo(String value) {
            addCriterion("send_person >=", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonLessThan(String value) {
            addCriterion("send_person <", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonLessThanOrEqualTo(String value) {
            addCriterion("send_person <=", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonLike(String value) {
            addCriterion("send_person like", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonNotLike(String value) {
            addCriterion("send_person not like", value, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonIn(List<String> values) {
            addCriterion("send_person in", values, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonNotIn(List<String> values) {
            addCriterion("send_person not in", values, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonBetween(String value1, String value2) {
            addCriterion("send_person between", value1, value2, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendPersonNotBetween(String value1, String value2) {
            addCriterion("send_person not between", value1, value2, "sendPerson");
            return (Criteria) this;
        }

        public Criteria andSendMobileIsNull() {
            addCriterion("send_mobile is null");
            return (Criteria) this;
        }

        public Criteria andSendMobileIsNotNull() {
            addCriterion("send_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andSendMobileEqualTo(String value) {
            addCriterion("send_mobile =", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileNotEqualTo(String value) {
            addCriterion("send_mobile <>", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileGreaterThan(String value) {
            addCriterion("send_mobile >", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileGreaterThanOrEqualTo(String value) {
            addCriterion("send_mobile >=", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileLessThan(String value) {
            addCriterion("send_mobile <", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileLessThanOrEqualTo(String value) {
            addCriterion("send_mobile <=", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileLike(String value) {
            addCriterion("send_mobile like", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileNotLike(String value) {
            addCriterion("send_mobile not like", value, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileIn(List<String> values) {
            addCriterion("send_mobile in", values, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileNotIn(List<String> values) {
            addCriterion("send_mobile not in", values, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileBetween(String value1, String value2) {
            addCriterion("send_mobile between", value1, value2, "sendMobile");
            return (Criteria) this;
        }

        public Criteria andSendMobileNotBetween(String value1, String value2) {
            addCriterion("send_mobile not between", value1, value2, "sendMobile");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}