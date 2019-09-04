package com.gow.beau.storage.auto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentExample() {
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

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNull() {
            addCriterion("return_url is null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIsNotNull() {
            addCriterion("return_url is not null");
            return (Criteria) this;
        }

        public Criteria andReturnUrlEqualTo(String value) {
            addCriterion("return_url =", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotEqualTo(String value) {
            addCriterion("return_url <>", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThan(String value) {
            addCriterion("return_url >", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlGreaterThanOrEqualTo(String value) {
            addCriterion("return_url >=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThan(String value) {
            addCriterion("return_url <", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLessThanOrEqualTo(String value) {
            addCriterion("return_url <=", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlLike(String value) {
            addCriterion("return_url like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotLike(String value) {
            addCriterion("return_url not like", value, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlIn(List<String> values) {
            addCriterion("return_url in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotIn(List<String> values) {
            addCriterion("return_url not in", values, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlBetween(String value1, String value2) {
            addCriterion("return_url between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andReturnUrlNotBetween(String value1, String value2) {
            addCriterion("return_url not between", value1, value2, "returnUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNull() {
            addCriterion("api_url is null");
            return (Criteria) this;
        }

        public Criteria andApiUrlIsNotNull() {
            addCriterion("api_url is not null");
            return (Criteria) this;
        }

        public Criteria andApiUrlEqualTo(String value) {
            addCriterion("api_url =", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotEqualTo(String value) {
            addCriterion("api_url <>", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThan(String value) {
            addCriterion("api_url >", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlGreaterThanOrEqualTo(String value) {
            addCriterion("api_url >=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThan(String value) {
            addCriterion("api_url <", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLessThanOrEqualTo(String value) {
            addCriterion("api_url <=", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlLike(String value) {
            addCriterion("api_url like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotLike(String value) {
            addCriterion("api_url not like", value, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlIn(List<String> values) {
            addCriterion("api_url in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotIn(List<String> values) {
            addCriterion("api_url not in", values, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlBetween(String value1, String value2) {
            addCriterion("api_url between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andApiUrlNotBetween(String value1, String value2) {
            addCriterion("api_url not between", value1, value2, "apiUrl");
            return (Criteria) this;
        }

        public Criteria andAppEcretIsNull() {
            addCriterion("app_ecret is null");
            return (Criteria) this;
        }

        public Criteria andAppEcretIsNotNull() {
            addCriterion("app_ecret is not null");
            return (Criteria) this;
        }

        public Criteria andAppEcretEqualTo(String value) {
            addCriterion("app_ecret =", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretNotEqualTo(String value) {
            addCriterion("app_ecret <>", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretGreaterThan(String value) {
            addCriterion("app_ecret >", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretGreaterThanOrEqualTo(String value) {
            addCriterion("app_ecret >=", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretLessThan(String value) {
            addCriterion("app_ecret <", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretLessThanOrEqualTo(String value) {
            addCriterion("app_ecret <=", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretLike(String value) {
            addCriterion("app_ecret like", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretNotLike(String value) {
            addCriterion("app_ecret not like", value, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretIn(List<String> values) {
            addCriterion("app_ecret in", values, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretNotIn(List<String> values) {
            addCriterion("app_ecret not in", values, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretBetween(String value1, String value2) {
            addCriterion("app_ecret between", value1, value2, "appEcret");
            return (Criteria) this;
        }

        public Criteria andAppEcretNotBetween(String value1, String value2) {
            addCriterion("app_ecret not between", value1, value2, "appEcret");
            return (Criteria) this;
        }

        public Criteria andExpireIsNull() {
            addCriterion("expire is null");
            return (Criteria) this;
        }

        public Criteria andExpireIsNotNull() {
            addCriterion("expire is not null");
            return (Criteria) this;
        }

        public Criteria andExpireEqualTo(Integer value) {
            addCriterion("expire =", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotEqualTo(Integer value) {
            addCriterion("expire <>", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireGreaterThan(Integer value) {
            addCriterion("expire >", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireGreaterThanOrEqualTo(Integer value) {
            addCriterion("expire >=", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireLessThan(Integer value) {
            addCriterion("expire <", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireLessThanOrEqualTo(Integer value) {
            addCriterion("expire <=", value, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireIn(List<Integer> values) {
            addCriterion("expire in", values, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotIn(List<Integer> values) {
            addCriterion("expire not in", values, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireBetween(Integer value1, Integer value2) {
            addCriterion("expire between", value1, value2, "expire");
            return (Criteria) this;
        }

        public Criteria andExpireNotBetween(Integer value1, Integer value2) {
            addCriterion("expire not between", value1, value2, "expire");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIsNull() {
            addCriterion("default_price is null");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIsNotNull() {
            addCriterion("default_price is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceEqualTo(BigDecimal value) {
            addCriterion("default_price =", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotEqualTo(BigDecimal value) {
            addCriterion("default_price <>", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceGreaterThan(BigDecimal value) {
            addCriterion("default_price >", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("default_price >=", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceLessThan(BigDecimal value) {
            addCriterion("default_price <", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("default_price <=", value, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceIn(List<BigDecimal> values) {
            addCriterion("default_price in", values, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotIn(List<BigDecimal> values) {
            addCriterion("default_price not in", values, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("default_price between", value1, value2, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andDefaultPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("default_price not between", value1, value2, "defaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceIsNull() {
            addCriterion("is_default_price is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceIsNotNull() {
            addCriterion("is_default_price is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceEqualTo(String value) {
            addCriterion("is_default_price =", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceNotEqualTo(String value) {
            addCriterion("is_default_price <>", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceGreaterThan(String value) {
            addCriterion("is_default_price >", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceGreaterThanOrEqualTo(String value) {
            addCriterion("is_default_price >=", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceLessThan(String value) {
            addCriterion("is_default_price <", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceLessThanOrEqualTo(String value) {
            addCriterion("is_default_price <=", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceLike(String value) {
            addCriterion("is_default_price like", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceNotLike(String value) {
            addCriterion("is_default_price not like", value, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceIn(List<String> values) {
            addCriterion("is_default_price in", values, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceNotIn(List<String> values) {
            addCriterion("is_default_price not in", values, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceBetween(String value1, String value2) {
            addCriterion("is_default_price between", value1, value2, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andIsDefaultPriceNotBetween(String value1, String value2) {
            addCriterion("is_default_price not between", value1, value2, "isDefaultPrice");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNull() {
            addCriterion("use_type is null");
            return (Criteria) this;
        }

        public Criteria andUseTypeIsNotNull() {
            addCriterion("use_type is not null");
            return (Criteria) this;
        }

        public Criteria andUseTypeEqualTo(String value) {
            addCriterion("use_type =", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotEqualTo(String value) {
            addCriterion("use_type <>", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThan(String value) {
            addCriterion("use_type >", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("use_type >=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThan(String value) {
            addCriterion("use_type <", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLessThanOrEqualTo(String value) {
            addCriterion("use_type <=", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeLike(String value) {
            addCriterion("use_type like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotLike(String value) {
            addCriterion("use_type not like", value, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeIn(List<String> values) {
            addCriterion("use_type in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotIn(List<String> values) {
            addCriterion("use_type not in", values, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeBetween(String value1, String value2) {
            addCriterion("use_type between", value1, value2, "useType");
            return (Criteria) this;
        }

        public Criteria andUseTypeNotBetween(String value1, String value2) {
            addCriterion("use_type not between", value1, value2, "useType");
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