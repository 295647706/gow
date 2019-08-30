package com.gow.beau.storage.auto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIsNull() {
            addCriterion("goods_spec is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIsNotNull() {
            addCriterion("goods_spec is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecEqualTo(String value) {
            addCriterion("goods_spec =", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotEqualTo(String value) {
            addCriterion("goods_spec <>", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecGreaterThan(String value) {
            addCriterion("goods_spec >", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecGreaterThanOrEqualTo(String value) {
            addCriterion("goods_spec >=", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecLessThan(String value) {
            addCriterion("goods_spec <", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecLessThanOrEqualTo(String value) {
            addCriterion("goods_spec <=", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecLike(String value) {
            addCriterion("goods_spec like", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotLike(String value) {
            addCriterion("goods_spec not like", value, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecIn(List<String> values) {
            addCriterion("goods_spec in", values, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotIn(List<String> values) {
            addCriterion("goods_spec not in", values, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecBetween(String value1, String value2) {
            addCriterion("goods_spec between", value1, value2, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSpecNotBetween(String value1, String value2) {
            addCriterion("goods_spec not between", value1, value2, "goodsSpec");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleIsNull() {
            addCriterion("goods_subtitle is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleIsNotNull() {
            addCriterion("goods_subtitle is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleEqualTo(String value) {
            addCriterion("goods_subtitle =", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleNotEqualTo(String value) {
            addCriterion("goods_subtitle <>", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleGreaterThan(String value) {
            addCriterion("goods_subtitle >", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleGreaterThanOrEqualTo(String value) {
            addCriterion("goods_subtitle >=", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleLessThan(String value) {
            addCriterion("goods_subtitle <", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleLessThanOrEqualTo(String value) {
            addCriterion("goods_subtitle <=", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleLike(String value) {
            addCriterion("goods_subtitle like", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleNotLike(String value) {
            addCriterion("goods_subtitle not like", value, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleIn(List<String> values) {
            addCriterion("goods_subtitle in", values, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleNotIn(List<String> values) {
            addCriterion("goods_subtitle not in", values, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleBetween(String value1, String value2) {
            addCriterion("goods_subtitle between", value1, value2, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsSubtitleNotBetween(String value1, String value2) {
            addCriterion("goods_subtitle not between", value1, value2, "goodsSubtitle");
            return (Criteria) this;
        }

        public Criteria andGoodsNoIsNull() {
            addCriterion("goods_no is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNoIsNotNull() {
            addCriterion("goods_no is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNoEqualTo(String value) {
            addCriterion("goods_no =", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoNotEqualTo(String value) {
            addCriterion("goods_no <>", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoGreaterThan(String value) {
            addCriterion("goods_no >", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            addCriterion("goods_no >=", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoLessThan(String value) {
            addCriterion("goods_no <", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoLessThanOrEqualTo(String value) {
            addCriterion("goods_no <=", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoLike(String value) {
            addCriterion("goods_no like", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoNotLike(String value) {
            addCriterion("goods_no not like", value, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoIn(List<String> values) {
            addCriterion("goods_no in", values, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoNotIn(List<String> values) {
            addCriterion("goods_no not in", values, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoBetween(String value1, String value2) {
            addCriterion("goods_no between", value1, value2, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsNoNotBetween(String value1, String value2) {
            addCriterion("goods_no not between", value1, value2, "goodsNo");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsIsNull() {
            addCriterion("goods_keywords is null");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsIsNotNull() {
            addCriterion("goods_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsEqualTo(String value) {
            addCriterion("goods_keywords =", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsNotEqualTo(String value) {
            addCriterion("goods_keywords <>", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsGreaterThan(String value) {
            addCriterion("goods_keywords >", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("goods_keywords >=", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsLessThan(String value) {
            addCriterion("goods_keywords <", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsLessThanOrEqualTo(String value) {
            addCriterion("goods_keywords <=", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsLike(String value) {
            addCriterion("goods_keywords like", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsNotLike(String value) {
            addCriterion("goods_keywords not like", value, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsIn(List<String> values) {
            addCriterion("goods_keywords in", values, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsNotIn(List<String> values) {
            addCriterion("goods_keywords not in", values, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsBetween(String value1, String value2) {
            addCriterion("goods_keywords between", value1, value2, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsKeywordsNotBetween(String value1, String value2) {
            addCriterion("goods_keywords not between", value1, value2, "goodsKeywords");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefIsNull() {
            addCriterion("goods_brief is null");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefIsNotNull() {
            addCriterion("goods_brief is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefEqualTo(String value) {
            addCriterion("goods_brief =", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotEqualTo(String value) {
            addCriterion("goods_brief <>", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefGreaterThan(String value) {
            addCriterion("goods_brief >", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefGreaterThanOrEqualTo(String value) {
            addCriterion("goods_brief >=", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefLessThan(String value) {
            addCriterion("goods_brief <", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefLessThanOrEqualTo(String value) {
            addCriterion("goods_brief <=", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefLike(String value) {
            addCriterion("goods_brief like", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotLike(String value) {
            addCriterion("goods_brief not like", value, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefIn(List<String> values) {
            addCriterion("goods_brief in", values, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotIn(List<String> values) {
            addCriterion("goods_brief not in", values, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefBetween(String value1, String value2) {
            addCriterion("goods_brief between", value1, value2, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsBriefNotBetween(String value1, String value2) {
            addCriterion("goods_brief not between", value1, value2, "goodsBrief");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIsNull() {
            addCriterion("goods_old_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIsNotNull() {
            addCriterion("goods_old_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceEqualTo(BigDecimal value) {
            addCriterion("goods_old_price =", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_old_price <>", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_old_price >", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_old_price >=", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceLessThan(BigDecimal value) {
            addCriterion("goods_old_price <", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_old_price <=", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIn(List<BigDecimal> values) {
            addCriterion("goods_old_price in", values, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_old_price not in", values, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_old_price between", value1, value2, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_old_price not between", value1, value2, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNull() {
            addCriterion("goods_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIsNotNull() {
            addCriterion("goods_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgEqualTo(String value) {
            addCriterion("goods_img =", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotEqualTo(String value) {
            addCriterion("goods_img <>", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThan(String value) {
            addCriterion("goods_img >", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_img >=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThan(String value) {
            addCriterion("goods_img <", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLessThanOrEqualTo(String value) {
            addCriterion("goods_img <=", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgLike(String value) {
            addCriterion("goods_img like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotLike(String value) {
            addCriterion("goods_img not like", value, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIn(List<String> values) {
            addCriterion("goods_img in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotIn(List<String> values) {
            addCriterion("goods_img not in", values, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgBetween(String value1, String value2) {
            addCriterion("goods_img between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsImgNotBetween(String value1, String value2) {
            addCriterion("goods_img not between", value1, value2, "goodsImg");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreIsNull() {
            addCriterion("goods_score is null");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreIsNotNull() {
            addCriterion("goods_score is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreEqualTo(BigDecimal value) {
            addCriterion("goods_score =", value, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreNotEqualTo(BigDecimal value) {
            addCriterion("goods_score <>", value, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreGreaterThan(BigDecimal value) {
            addCriterion("goods_score >", value, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_score >=", value, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreLessThan(BigDecimal value) {
            addCriterion("goods_score <", value, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_score <=", value, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreIn(List<BigDecimal> values) {
            addCriterion("goods_score in", values, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreNotIn(List<BigDecimal> values) {
            addCriterion("goods_score not in", values, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_score between", value1, value2, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_score not between", value1, value2, "goodsScore");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoIsNull() {
            addCriterion("goods_deno is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoIsNotNull() {
            addCriterion("goods_deno is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoEqualTo(String value) {
            addCriterion("goods_deno =", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoNotEqualTo(String value) {
            addCriterion("goods_deno <>", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoGreaterThan(String value) {
            addCriterion("goods_deno >", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoGreaterThanOrEqualTo(String value) {
            addCriterion("goods_deno >=", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoLessThan(String value) {
            addCriterion("goods_deno <", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoLessThanOrEqualTo(String value) {
            addCriterion("goods_deno <=", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoLike(String value) {
            addCriterion("goods_deno like", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoNotLike(String value) {
            addCriterion("goods_deno not like", value, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoIn(List<String> values) {
            addCriterion("goods_deno in", values, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoNotIn(List<String> values) {
            addCriterion("goods_deno not in", values, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoBetween(String value1, String value2) {
            addCriterion("goods_deno between", value1, value2, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDenoNotBetween(String value1, String value2) {
            addCriterion("goods_deno not between", value1, value2, "goodsDeno");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgIsNull() {
            addCriterion("goods_detail_img is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgIsNotNull() {
            addCriterion("goods_detail_img is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgEqualTo(String value) {
            addCriterion("goods_detail_img =", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgNotEqualTo(String value) {
            addCriterion("goods_detail_img <>", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgGreaterThan(String value) {
            addCriterion("goods_detail_img >", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgGreaterThanOrEqualTo(String value) {
            addCriterion("goods_detail_img >=", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgLessThan(String value) {
            addCriterion("goods_detail_img <", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgLessThanOrEqualTo(String value) {
            addCriterion("goods_detail_img <=", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgLike(String value) {
            addCriterion("goods_detail_img like", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgNotLike(String value) {
            addCriterion("goods_detail_img not like", value, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgIn(List<String> values) {
            addCriterion("goods_detail_img in", values, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgNotIn(List<String> values) {
            addCriterion("goods_detail_img not in", values, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgBetween(String value1, String value2) {
            addCriterion("goods_detail_img between", value1, value2, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsDetailImgNotBetween(String value1, String value2) {
            addCriterion("goods_detail_img not between", value1, value2, "goodsDetailImg");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNull() {
            addCriterion("goods_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNotNull() {
            addCriterion("goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberEqualTo(Integer value) {
            addCriterion("goods_number =", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotEqualTo(Integer value) {
            addCriterion("goods_number <>", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThan(Integer value) {
            addCriterion("goods_number >", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_number >=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThan(Integer value) {
            addCriterion("goods_number <", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_number <=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIn(List<Integer> values) {
            addCriterion("goods_number in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotIn(List<Integer> values) {
            addCriterion("goods_number not in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_number between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_number not between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksIsNull() {
            addCriterion("is_upper_lower_racks is null");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksIsNotNull() {
            addCriterion("is_upper_lower_racks is not null");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksEqualTo(String value) {
            addCriterion("is_upper_lower_racks =", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksNotEqualTo(String value) {
            addCriterion("is_upper_lower_racks <>", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksGreaterThan(String value) {
            addCriterion("is_upper_lower_racks >", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksGreaterThanOrEqualTo(String value) {
            addCriterion("is_upper_lower_racks >=", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksLessThan(String value) {
            addCriterion("is_upper_lower_racks <", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksLessThanOrEqualTo(String value) {
            addCriterion("is_upper_lower_racks <=", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksLike(String value) {
            addCriterion("is_upper_lower_racks like", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksNotLike(String value) {
            addCriterion("is_upper_lower_racks not like", value, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksIn(List<String> values) {
            addCriterion("is_upper_lower_racks in", values, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksNotIn(List<String> values) {
            addCriterion("is_upper_lower_racks not in", values, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksBetween(String value1, String value2) {
            addCriterion("is_upper_lower_racks between", value1, value2, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsUpperLowerRacksNotBetween(String value1, String value2) {
            addCriterion("is_upper_lower_racks not between", value1, value2, "isUpperLowerRacks");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNull() {
            addCriterion("is_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIsNotNull() {
            addCriterion("is_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIsRecommendEqualTo(String value) {
            addCriterion("is_recommend =", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotEqualTo(String value) {
            addCriterion("is_recommend <>", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThan(String value) {
            addCriterion("is_recommend >", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendGreaterThanOrEqualTo(String value) {
            addCriterion("is_recommend >=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThan(String value) {
            addCriterion("is_recommend <", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLessThanOrEqualTo(String value) {
            addCriterion("is_recommend <=", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendLike(String value) {
            addCriterion("is_recommend like", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotLike(String value) {
            addCriterion("is_recommend not like", value, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendIn(List<String> values) {
            addCriterion("is_recommend in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotIn(List<String> values) {
            addCriterion("is_recommend not in", values, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendBetween(String value1, String value2) {
            addCriterion("is_recommend between", value1, value2, "isRecommend");
            return (Criteria) this;
        }

        public Criteria andIsRecommendNotBetween(String value1, String value2) {
            addCriterion("is_recommend not between", value1, value2, "isRecommend");
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