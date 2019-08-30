package com.gow.beau.storage.auto.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCustomerUsernameIsNull() {
            addCriterion("customer_username is null");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameIsNotNull() {
            addCriterion("customer_username is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameEqualTo(String value) {
            addCriterion("customer_username =", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameNotEqualTo(String value) {
            addCriterion("customer_username <>", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameGreaterThan(String value) {
            addCriterion("customer_username >", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_username >=", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameLessThan(String value) {
            addCriterion("customer_username <", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameLessThanOrEqualTo(String value) {
            addCriterion("customer_username <=", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameLike(String value) {
            addCriterion("customer_username like", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameNotLike(String value) {
            addCriterion("customer_username not like", value, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameIn(List<String> values) {
            addCriterion("customer_username in", values, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameNotIn(List<String> values) {
            addCriterion("customer_username not in", values, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameBetween(String value1, String value2) {
            addCriterion("customer_username between", value1, value2, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andCustomerUsernameNotBetween(String value1, String value2) {
            addCriterion("customer_username not between", value1, value2, "customerUsername");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordIsNull() {
            addCriterion("customer_password is null");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordIsNotNull() {
            addCriterion("customer_password is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordEqualTo(String value) {
            addCriterion("customer_password =", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotEqualTo(String value) {
            addCriterion("customer_password <>", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordGreaterThan(String value) {
            addCriterion("customer_password >", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("customer_password >=", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordLessThan(String value) {
            addCriterion("customer_password <", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordLessThanOrEqualTo(String value) {
            addCriterion("customer_password <=", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordLike(String value) {
            addCriterion("customer_password like", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotLike(String value) {
            addCriterion("customer_password not like", value, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordIn(List<String> values) {
            addCriterion("customer_password in", values, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotIn(List<String> values) {
            addCriterion("customer_password not in", values, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordBetween(String value1, String value2) {
            addCriterion("customer_password between", value1, value2, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerPasswordNotBetween(String value1, String value2) {
            addCriterion("customer_password not between", value1, value2, "customerPassword");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameIsNull() {
            addCriterion("customer_nickname is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameIsNotNull() {
            addCriterion("customer_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameEqualTo(String value) {
            addCriterion("customer_nickname =", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameNotEqualTo(String value) {
            addCriterion("customer_nickname <>", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameGreaterThan(String value) {
            addCriterion("customer_nickname >", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_nickname >=", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameLessThan(String value) {
            addCriterion("customer_nickname <", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameLessThanOrEqualTo(String value) {
            addCriterion("customer_nickname <=", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameLike(String value) {
            addCriterion("customer_nickname like", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameNotLike(String value) {
            addCriterion("customer_nickname not like", value, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameIn(List<String> values) {
            addCriterion("customer_nickname in", values, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameNotIn(List<String> values) {
            addCriterion("customer_nickname not in", values, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameBetween(String value1, String value2) {
            addCriterion("customer_nickname between", value1, value2, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andCustomerNicknameNotBetween(String value1, String value2) {
            addCriterion("customer_nickname not between", value1, value2, "customerNickname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameIsNull() {
            addCriterion("customer_realname is null");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameIsNotNull() {
            addCriterion("customer_realname is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameEqualTo(String value) {
            addCriterion("customer_realname =", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameNotEqualTo(String value) {
            addCriterion("customer_realname <>", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameGreaterThan(String value) {
            addCriterion("customer_realname >", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_realname >=", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameLessThan(String value) {
            addCriterion("customer_realname <", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameLessThanOrEqualTo(String value) {
            addCriterion("customer_realname <=", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameLike(String value) {
            addCriterion("customer_realname like", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameNotLike(String value) {
            addCriterion("customer_realname not like", value, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameIn(List<String> values) {
            addCriterion("customer_realname in", values, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameNotIn(List<String> values) {
            addCriterion("customer_realname not in", values, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameBetween(String value1, String value2) {
            addCriterion("customer_realname between", value1, value2, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andCustomerRealnameNotBetween(String value1, String value2) {
            addCriterion("customer_realname not between", value1, value2, "customerRealname");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("login_ip =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("login_ip <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("login_ip >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("login_ip >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("login_ip <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("login_ip <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("login_ip like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("login_ip not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("login_ip in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("login_ip not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("login_ip between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("login_ip not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andCustomerImgIsNull() {
            addCriterion("customer_img is null");
            return (Criteria) this;
        }

        public Criteria andCustomerImgIsNotNull() {
            addCriterion("customer_img is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerImgEqualTo(String value) {
            addCriterion("customer_img =", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgNotEqualTo(String value) {
            addCriterion("customer_img <>", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgGreaterThan(String value) {
            addCriterion("customer_img >", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgGreaterThanOrEqualTo(String value) {
            addCriterion("customer_img >=", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgLessThan(String value) {
            addCriterion("customer_img <", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgLessThanOrEqualTo(String value) {
            addCriterion("customer_img <=", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgLike(String value) {
            addCriterion("customer_img like", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgNotLike(String value) {
            addCriterion("customer_img not like", value, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgIn(List<String> values) {
            addCriterion("customer_img in", values, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgNotIn(List<String> values) {
            addCriterion("customer_img not in", values, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgBetween(String value1, String value2) {
            addCriterion("customer_img between", value1, value2, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCustomerImgNotBetween(String value1, String value2) {
            addCriterion("customer_img not between", value1, value2, "customerImg");
            return (Criteria) this;
        }

        public Criteria andCaptchaIsNull() {
            addCriterion("captcha is null");
            return (Criteria) this;
        }

        public Criteria andCaptchaIsNotNull() {
            addCriterion("captcha is not null");
            return (Criteria) this;
        }

        public Criteria andCaptchaEqualTo(String value) {
            addCriterion("captcha =", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotEqualTo(String value) {
            addCriterion("captcha <>", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaGreaterThan(String value) {
            addCriterion("captcha >", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaGreaterThanOrEqualTo(String value) {
            addCriterion("captcha >=", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLessThan(String value) {
            addCriterion("captcha <", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLessThanOrEqualTo(String value) {
            addCriterion("captcha <=", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLike(String value) {
            addCriterion("captcha like", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotLike(String value) {
            addCriterion("captcha not like", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaIn(List<String> values) {
            addCriterion("captcha in", values, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotIn(List<String> values) {
            addCriterion("captcha not in", values, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaBetween(String value1, String value2) {
            addCriterion("captcha between", value1, value2, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotBetween(String value1, String value2) {
            addCriterion("captcha not between", value1, value2, "captcha");
            return (Criteria) this;
        }

        public Criteria andAeadTimeIsNull() {
            addCriterion("aead_time is null");
            return (Criteria) this;
        }

        public Criteria andAeadTimeIsNotNull() {
            addCriterion("aead_time is not null");
            return (Criteria) this;
        }

        public Criteria andAeadTimeEqualTo(Date value) {
            addCriterion("aead_time =", value, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeNotEqualTo(Date value) {
            addCriterion("aead_time <>", value, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeGreaterThan(Date value) {
            addCriterion("aead_time >", value, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("aead_time >=", value, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeLessThan(Date value) {
            addCriterion("aead_time <", value, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeLessThanOrEqualTo(Date value) {
            addCriterion("aead_time <=", value, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeIn(List<Date> values) {
            addCriterion("aead_time in", values, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeNotIn(List<Date> values) {
            addCriterion("aead_time not in", values, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeBetween(Date value1, Date value2) {
            addCriterion("aead_time between", value1, value2, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andAeadTimeNotBetween(Date value1, Date value2) {
            addCriterion("aead_time not between", value1, value2, "aeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaIsNull() {
            addCriterion("pwd_captcha is null");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaIsNotNull() {
            addCriterion("pwd_captcha is not null");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaEqualTo(String value) {
            addCriterion("pwd_captcha =", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaNotEqualTo(String value) {
            addCriterion("pwd_captcha <>", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaGreaterThan(String value) {
            addCriterion("pwd_captcha >", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaGreaterThanOrEqualTo(String value) {
            addCriterion("pwd_captcha >=", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaLessThan(String value) {
            addCriterion("pwd_captcha <", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaLessThanOrEqualTo(String value) {
            addCriterion("pwd_captcha <=", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaLike(String value) {
            addCriterion("pwd_captcha like", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaNotLike(String value) {
            addCriterion("pwd_captcha not like", value, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaIn(List<String> values) {
            addCriterion("pwd_captcha in", values, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaNotIn(List<String> values) {
            addCriterion("pwd_captcha not in", values, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaBetween(String value1, String value2) {
            addCriterion("pwd_captcha between", value1, value2, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdCaptchaNotBetween(String value1, String value2) {
            addCriterion("pwd_captcha not between", value1, value2, "pwdCaptcha");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeIsNull() {
            addCriterion("pwd_aead_time is null");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeIsNotNull() {
            addCriterion("pwd_aead_time is not null");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeEqualTo(Date value) {
            addCriterion("pwd_aead_time =", value, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeNotEqualTo(Date value) {
            addCriterion("pwd_aead_time <>", value, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeGreaterThan(Date value) {
            addCriterion("pwd_aead_time >", value, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pwd_aead_time >=", value, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeLessThan(Date value) {
            addCriterion("pwd_aead_time <", value, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeLessThanOrEqualTo(Date value) {
            addCriterion("pwd_aead_time <=", value, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeIn(List<Date> values) {
            addCriterion("pwd_aead_time in", values, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeNotIn(List<Date> values) {
            addCriterion("pwd_aead_time not in", values, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeBetween(Date value1, Date value2) {
            addCriterion("pwd_aead_time between", value1, value2, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andPwdAeadTimeNotBetween(Date value1, Date value2) {
            addCriterion("pwd_aead_time not between", value1, value2, "pwdAeadTime");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountIsNull() {
            addCriterion("login_error_count is null");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountIsNotNull() {
            addCriterion("login_error_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountEqualTo(Long value) {
            addCriterion("login_error_count =", value, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountNotEqualTo(Long value) {
            addCriterion("login_error_count <>", value, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountGreaterThan(Long value) {
            addCriterion("login_error_count >", value, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountGreaterThanOrEqualTo(Long value) {
            addCriterion("login_error_count >=", value, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountLessThan(Long value) {
            addCriterion("login_error_count <", value, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountLessThanOrEqualTo(Long value) {
            addCriterion("login_error_count <=", value, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountIn(List<Long> values) {
            addCriterion("login_error_count in", values, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountNotIn(List<Long> values) {
            addCriterion("login_error_count not in", values, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountBetween(Long value1, Long value2) {
            addCriterion("login_error_count between", value1, value2, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andLoginErrorCountNotBetween(Long value1, Long value2) {
            addCriterion("login_error_count not between", value1, value2, "loginErrorCount");
            return (Criteria) this;
        }

        public Criteria andUserSaltValIsNull() {
            addCriterion("user_salt_val is null");
            return (Criteria) this;
        }

        public Criteria andUserSaltValIsNotNull() {
            addCriterion("user_salt_val is not null");
            return (Criteria) this;
        }

        public Criteria andUserSaltValEqualTo(String value) {
            addCriterion("user_salt_val =", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValNotEqualTo(String value) {
            addCriterion("user_salt_val <>", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValGreaterThan(String value) {
            addCriterion("user_salt_val >", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValGreaterThanOrEqualTo(String value) {
            addCriterion("user_salt_val >=", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValLessThan(String value) {
            addCriterion("user_salt_val <", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValLessThanOrEqualTo(String value) {
            addCriterion("user_salt_val <=", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValLike(String value) {
            addCriterion("user_salt_val like", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValNotLike(String value) {
            addCriterion("user_salt_val not like", value, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValIn(List<String> values) {
            addCriterion("user_salt_val in", values, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValNotIn(List<String> values) {
            addCriterion("user_salt_val not in", values, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValBetween(String value1, String value2) {
            addCriterion("user_salt_val between", value1, value2, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andUserSaltValNotBetween(String value1, String value2) {
            addCriterion("user_salt_val not between", value1, value2, "userSaltVal");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeIsNull() {
            addCriterion("customer_referee is null");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeIsNotNull() {
            addCriterion("customer_referee is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeEqualTo(String value) {
            addCriterion("customer_referee =", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeNotEqualTo(String value) {
            addCriterion("customer_referee <>", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeGreaterThan(String value) {
            addCriterion("customer_referee >", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeGreaterThanOrEqualTo(String value) {
            addCriterion("customer_referee >=", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeLessThan(String value) {
            addCriterion("customer_referee <", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeLessThanOrEqualTo(String value) {
            addCriterion("customer_referee <=", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeLike(String value) {
            addCriterion("customer_referee like", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeNotLike(String value) {
            addCriterion("customer_referee not like", value, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeIn(List<String> values) {
            addCriterion("customer_referee in", values, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeNotIn(List<String> values) {
            addCriterion("customer_referee not in", values, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeBetween(String value1, String value2) {
            addCriterion("customer_referee between", value1, value2, "customerReferee");
            return (Criteria) this;
        }

        public Criteria andCustomerRefereeNotBetween(String value1, String value2) {
            addCriterion("customer_referee not between", value1, value2, "customerReferee");
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

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
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

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Integer value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Integer value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Integer value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Integer value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Integer> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Integer> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Integer value1, Integer value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNull() {
            addCriterion("is_use is null");
            return (Criteria) this;
        }

        public Criteria andIsUseIsNotNull() {
            addCriterion("is_use is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseEqualTo(String value) {
            addCriterion("is_use =", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotEqualTo(String value) {
            addCriterion("is_use <>", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThan(String value) {
            addCriterion("is_use >", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseGreaterThanOrEqualTo(String value) {
            addCriterion("is_use >=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThan(String value) {
            addCriterion("is_use <", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLessThanOrEqualTo(String value) {
            addCriterion("is_use <=", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseLike(String value) {
            addCriterion("is_use like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotLike(String value) {
            addCriterion("is_use not like", value, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseIn(List<String> values) {
            addCriterion("is_use in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotIn(List<String> values) {
            addCriterion("is_use not in", values, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseBetween(String value1, String value2) {
            addCriterion("is_use between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseNotBetween(String value1, String value2) {
            addCriterion("is_use not between", value1, value2, "isUse");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeIsNull() {
            addCriterion("is_use_time is null");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeIsNotNull() {
            addCriterion("is_use_time is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeEqualTo(Date value) {
            addCriterion("is_use_time =", value, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeNotEqualTo(Date value) {
            addCriterion("is_use_time <>", value, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeGreaterThan(Date value) {
            addCriterion("is_use_time >", value, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("is_use_time >=", value, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeLessThan(Date value) {
            addCriterion("is_use_time <", value, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeLessThanOrEqualTo(Date value) {
            addCriterion("is_use_time <=", value, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeIn(List<Date> values) {
            addCriterion("is_use_time in", values, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeNotIn(List<Date> values) {
            addCriterion("is_use_time not in", values, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeBetween(Date value1, Date value2) {
            addCriterion("is_use_time between", value1, value2, "isUseTime");
            return (Criteria) this;
        }

        public Criteria andIsUseTimeNotBetween(Date value1, Date value2) {
            addCriterion("is_use_time not between", value1, value2, "isUseTime");
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