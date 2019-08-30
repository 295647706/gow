package com.gow.beau.storage.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategoryExample() {
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

        public Criteria andCatNameIsNull() {
            addCriterion("cat_name is null");
            return (Criteria) this;
        }

        public Criteria andCatNameIsNotNull() {
            addCriterion("cat_name is not null");
            return (Criteria) this;
        }

        public Criteria andCatNameEqualTo(String value) {
            addCriterion("cat_name =", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameNotEqualTo(String value) {
            addCriterion("cat_name <>", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameGreaterThan(String value) {
            addCriterion("cat_name >", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameGreaterThanOrEqualTo(String value) {
            addCriterion("cat_name >=", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameLessThan(String value) {
            addCriterion("cat_name <", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameLessThanOrEqualTo(String value) {
            addCriterion("cat_name <=", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameLike(String value) {
            addCriterion("cat_name like", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameNotLike(String value) {
            addCriterion("cat_name not like", value, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameIn(List<String> values) {
            addCriterion("cat_name in", values, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameNotIn(List<String> values) {
            addCriterion("cat_name not in", values, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameBetween(String value1, String value2) {
            addCriterion("cat_name between", value1, value2, "catName");
            return (Criteria) this;
        }

        public Criteria andCatNameNotBetween(String value1, String value2) {
            addCriterion("cat_name not between", value1, value2, "catName");
            return (Criteria) this;
        }

        public Criteria andCatParentIdIsNull() {
            addCriterion("cat_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andCatParentIdIsNotNull() {
            addCriterion("cat_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andCatParentIdEqualTo(Long value) {
            addCriterion("cat_parent_id =", value, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdNotEqualTo(Long value) {
            addCriterion("cat_parent_id <>", value, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdGreaterThan(Long value) {
            addCriterion("cat_parent_id >", value, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cat_parent_id >=", value, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdLessThan(Long value) {
            addCriterion("cat_parent_id <", value, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdLessThanOrEqualTo(Long value) {
            addCriterion("cat_parent_id <=", value, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdIn(List<Long> values) {
            addCriterion("cat_parent_id in", values, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdNotIn(List<Long> values) {
            addCriterion("cat_parent_id not in", values, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdBetween(Long value1, Long value2) {
            addCriterion("cat_parent_id between", value1, value2, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatParentIdNotBetween(Long value1, Long value2) {
            addCriterion("cat_parent_id not between", value1, value2, "catParentId");
            return (Criteria) this;
        }

        public Criteria andCatSortIsNull() {
            addCriterion("cat_sort is null");
            return (Criteria) this;
        }

        public Criteria andCatSortIsNotNull() {
            addCriterion("cat_sort is not null");
            return (Criteria) this;
        }

        public Criteria andCatSortEqualTo(Integer value) {
            addCriterion("cat_sort =", value, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortNotEqualTo(Integer value) {
            addCriterion("cat_sort <>", value, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortGreaterThan(Integer value) {
            addCriterion("cat_sort >", value, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("cat_sort >=", value, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortLessThan(Integer value) {
            addCriterion("cat_sort <", value, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortLessThanOrEqualTo(Integer value) {
            addCriterion("cat_sort <=", value, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortIn(List<Integer> values) {
            addCriterion("cat_sort in", values, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortNotIn(List<Integer> values) {
            addCriterion("cat_sort not in", values, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortBetween(Integer value1, Integer value2) {
            addCriterion("cat_sort between", value1, value2, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatSortNotBetween(Integer value1, Integer value2) {
            addCriterion("cat_sort not between", value1, value2, "catSort");
            return (Criteria) this;
        }

        public Criteria andCatIsShowIsNull() {
            addCriterion("cat_is_show is null");
            return (Criteria) this;
        }

        public Criteria andCatIsShowIsNotNull() {
            addCriterion("cat_is_show is not null");
            return (Criteria) this;
        }

        public Criteria andCatIsShowEqualTo(String value) {
            addCriterion("cat_is_show =", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowNotEqualTo(String value) {
            addCriterion("cat_is_show <>", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowGreaterThan(String value) {
            addCriterion("cat_is_show >", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowGreaterThanOrEqualTo(String value) {
            addCriterion("cat_is_show >=", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowLessThan(String value) {
            addCriterion("cat_is_show <", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowLessThanOrEqualTo(String value) {
            addCriterion("cat_is_show <=", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowLike(String value) {
            addCriterion("cat_is_show like", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowNotLike(String value) {
            addCriterion("cat_is_show not like", value, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowIn(List<String> values) {
            addCriterion("cat_is_show in", values, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowNotIn(List<String> values) {
            addCriterion("cat_is_show not in", values, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowBetween(String value1, String value2) {
            addCriterion("cat_is_show between", value1, value2, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatIsShowNotBetween(String value1, String value2) {
            addCriterion("cat_is_show not between", value1, value2, "catIsShow");
            return (Criteria) this;
        }

        public Criteria andCatDelflagIsNull() {
            addCriterion("cat_delflag is null");
            return (Criteria) this;
        }

        public Criteria andCatDelflagIsNotNull() {
            addCriterion("cat_delflag is not null");
            return (Criteria) this;
        }

        public Criteria andCatDelflagEqualTo(String value) {
            addCriterion("cat_delflag =", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagNotEqualTo(String value) {
            addCriterion("cat_delflag <>", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagGreaterThan(String value) {
            addCriterion("cat_delflag >", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagGreaterThanOrEqualTo(String value) {
            addCriterion("cat_delflag >=", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagLessThan(String value) {
            addCriterion("cat_delflag <", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagLessThanOrEqualTo(String value) {
            addCriterion("cat_delflag <=", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagLike(String value) {
            addCriterion("cat_delflag like", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagNotLike(String value) {
            addCriterion("cat_delflag not like", value, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagIn(List<String> values) {
            addCriterion("cat_delflag in", values, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagNotIn(List<String> values) {
            addCriterion("cat_delflag not in", values, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagBetween(String value1, String value2) {
            addCriterion("cat_delflag between", value1, value2, "catDelflag");
            return (Criteria) this;
        }

        public Criteria andCatDelflagNotBetween(String value1, String value2) {
            addCriterion("cat_delflag not between", value1, value2, "catDelflag");
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