package com.gow.beau.storage.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationOperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InformationOperationExample() {
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

        public Criteria andInformationIdIsNull() {
            addCriterion("information_id is null");
            return (Criteria) this;
        }

        public Criteria andInformationIdIsNotNull() {
            addCriterion("information_id is not null");
            return (Criteria) this;
        }

        public Criteria andInformationIdEqualTo(Long value) {
            addCriterion("information_id =", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdNotEqualTo(Long value) {
            addCriterion("information_id <>", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdGreaterThan(Long value) {
            addCriterion("information_id >", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("information_id >=", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdLessThan(Long value) {
            addCriterion("information_id <", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdLessThanOrEqualTo(Long value) {
            addCriterion("information_id <=", value, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdIn(List<Long> values) {
            addCriterion("information_id in", values, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdNotIn(List<Long> values) {
            addCriterion("information_id not in", values, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdBetween(Long value1, Long value2) {
            addCriterion("information_id between", value1, value2, "informationId");
            return (Criteria) this;
        }

        public Criteria andInformationIdNotBetween(Long value1, Long value2) {
            addCriterion("information_id not between", value1, value2, "informationId");
            return (Criteria) this;
        }

        public Criteria andIsFocusIsNull() {
            addCriterion("is_focus is null");
            return (Criteria) this;
        }

        public Criteria andIsFocusIsNotNull() {
            addCriterion("is_focus is not null");
            return (Criteria) this;
        }

        public Criteria andIsFocusEqualTo(String value) {
            addCriterion("is_focus =", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusNotEqualTo(String value) {
            addCriterion("is_focus <>", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusGreaterThan(String value) {
            addCriterion("is_focus >", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusGreaterThanOrEqualTo(String value) {
            addCriterion("is_focus >=", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusLessThan(String value) {
            addCriterion("is_focus <", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusLessThanOrEqualTo(String value) {
            addCriterion("is_focus <=", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusLike(String value) {
            addCriterion("is_focus like", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusNotLike(String value) {
            addCriterion("is_focus not like", value, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusIn(List<String> values) {
            addCriterion("is_focus in", values, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusNotIn(List<String> values) {
            addCriterion("is_focus not in", values, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusBetween(String value1, String value2) {
            addCriterion("is_focus between", value1, value2, "isFocus");
            return (Criteria) this;
        }

        public Criteria andIsFocusNotBetween(String value1, String value2) {
            addCriterion("is_focus not between", value1, value2, "isFocus");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIsNull() {
            addCriterion("focus_time is null");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIsNotNull() {
            addCriterion("focus_time is not null");
            return (Criteria) this;
        }

        public Criteria andFocusTimeEqualTo(Date value) {
            addCriterion("focus_time =", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotEqualTo(Date value) {
            addCriterion("focus_time <>", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeGreaterThan(Date value) {
            addCriterion("focus_time >", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("focus_time >=", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeLessThan(Date value) {
            addCriterion("focus_time <", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeLessThanOrEqualTo(Date value) {
            addCriterion("focus_time <=", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIn(List<Date> values) {
            addCriterion("focus_time in", values, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotIn(List<Date> values) {
            addCriterion("focus_time not in", values, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeBetween(Date value1, Date value2) {
            addCriterion("focus_time between", value1, value2, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotBetween(Date value1, Date value2) {
            addCriterion("focus_time not between", value1, value2, "focusTime");
            return (Criteria) this;
        }

        public Criteria andIsPraiseIsNull() {
            addCriterion("is_praise is null");
            return (Criteria) this;
        }

        public Criteria andIsPraiseIsNotNull() {
            addCriterion("is_praise is not null");
            return (Criteria) this;
        }

        public Criteria andIsPraiseEqualTo(String value) {
            addCriterion("is_praise =", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseNotEqualTo(String value) {
            addCriterion("is_praise <>", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseGreaterThan(String value) {
            addCriterion("is_praise >", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseGreaterThanOrEqualTo(String value) {
            addCriterion("is_praise >=", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseLessThan(String value) {
            addCriterion("is_praise <", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseLessThanOrEqualTo(String value) {
            addCriterion("is_praise <=", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseLike(String value) {
            addCriterion("is_praise like", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseNotLike(String value) {
            addCriterion("is_praise not like", value, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseIn(List<String> values) {
            addCriterion("is_praise in", values, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseNotIn(List<String> values) {
            addCriterion("is_praise not in", values, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseBetween(String value1, String value2) {
            addCriterion("is_praise between", value1, value2, "isPraise");
            return (Criteria) this;
        }

        public Criteria andIsPraiseNotBetween(String value1, String value2) {
            addCriterion("is_praise not between", value1, value2, "isPraise");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIsNull() {
            addCriterion("praise_time is null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIsNotNull() {
            addCriterion("praise_time is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeEqualTo(Date value) {
            addCriterion("praise_time =", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotEqualTo(Date value) {
            addCriterion("praise_time <>", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeGreaterThan(Date value) {
            addCriterion("praise_time >", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("praise_time >=", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeLessThan(Date value) {
            addCriterion("praise_time <", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeLessThanOrEqualTo(Date value) {
            addCriterion("praise_time <=", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIn(List<Date> values) {
            addCriterion("praise_time in", values, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotIn(List<Date> values) {
            addCriterion("praise_time not in", values, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeBetween(Date value1, Date value2) {
            addCriterion("praise_time between", value1, value2, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotBetween(Date value1, Date value2) {
            addCriterion("praise_time not between", value1, value2, "praiseTime");
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