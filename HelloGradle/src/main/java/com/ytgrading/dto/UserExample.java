package com.ytgrading.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("usercode is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("usercode is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(Integer value) {
            addCriterion("usercode =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(Integer value) {
            addCriterion("usercode <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(Integer value) {
            addCriterion("usercode >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usercode >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(Integer value) {
            addCriterion("usercode <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(Integer value) {
            addCriterion("usercode <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<Integer> values) {
            addCriterion("usercode in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<Integer> values) {
            addCriterion("usercode not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(Integer value1, Integer value2) {
            addCriterion("usercode between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(Integer value1, Integer value2) {
            addCriterion("usercode not between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNull() {
            addCriterion("registerdate is null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNotNull() {
            addCriterion("registerdate is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateEqualTo(Date value) {
            addCriterion("registerdate =", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotEqualTo(Date value) {
            addCriterion("registerdate <>", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThan(Date value) {
            addCriterion("registerdate >", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThanOrEqualTo(Date value) {
            addCriterion("registerdate >=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThan(Date value) {
            addCriterion("registerdate <", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThanOrEqualTo(Date value) {
            addCriterion("registerdate <=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIn(List<Date> values) {
            addCriterion("registerdate in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotIn(List<Date> values) {
            addCriterion("registerdate not in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateBetween(Date value1, Date value2) {
            addCriterion("registerdate between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotBetween(Date value1, Date value2) {
            addCriterion("registerdate not between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsNull() {
            addCriterion("documenttype is null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIsNotNull() {
            addCriterion("documenttype is not null");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeEqualTo(String value) {
            addCriterion("documenttype =", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotEqualTo(String value) {
            addCriterion("documenttype <>", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeGreaterThan(String value) {
            addCriterion("documenttype >", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeGreaterThanOrEqualTo(String value) {
            addCriterion("documenttype >=", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeLessThan(String value) {
            addCriterion("documenttype <", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeLessThanOrEqualTo(String value) {
            addCriterion("documenttype <=", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeLike(String value) {
            addCriterion("documenttype like", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotLike(String value) {
            addCriterion("documenttype not like", value, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeIn(List<String> values) {
            addCriterion("documenttype in", values, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotIn(List<String> values) {
            addCriterion("documenttype not in", values, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeBetween(String value1, String value2) {
            addCriterion("documenttype between", value1, value2, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumenttypeNotBetween(String value1, String value2) {
            addCriterion("documenttype not between", value1, value2, "documenttype");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeIsNull() {
            addCriterion("documentcode is null");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeIsNotNull() {
            addCriterion("documentcode is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeEqualTo(String value) {
            addCriterion("documentcode =", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeNotEqualTo(String value) {
            addCriterion("documentcode <>", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeGreaterThan(String value) {
            addCriterion("documentcode >", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("documentcode >=", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeLessThan(String value) {
            addCriterion("documentcode <", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeLessThanOrEqualTo(String value) {
            addCriterion("documentcode <=", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeLike(String value) {
            addCriterion("documentcode like", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeNotLike(String value) {
            addCriterion("documentcode not like", value, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeIn(List<String> values) {
            addCriterion("documentcode in", values, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeNotIn(List<String> values) {
            addCriterion("documentcode not in", values, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeBetween(String value1, String value2) {
            addCriterion("documentcode between", value1, value2, "documentcode");
            return (Criteria) this;
        }

        public Criteria andDocumentcodeNotBetween(String value1, String value2) {
            addCriterion("documentcode not between", value1, value2, "documentcode");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("rate like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("rate not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNull() {
            addCriterion("delflag is null");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNotNull() {
            addCriterion("delflag is not null");
            return (Criteria) this;
        }

        public Criteria andDelflagEqualTo(String value) {
            addCriterion("delflag =", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotEqualTo(String value) {
            addCriterion("delflag <>", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThan(String value) {
            addCriterion("delflag >", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThanOrEqualTo(String value) {
            addCriterion("delflag >=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThan(String value) {
            addCriterion("delflag <", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThanOrEqualTo(String value) {
            addCriterion("delflag <=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLike(String value) {
            addCriterion("delflag like", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotLike(String value) {
            addCriterion("delflag not like", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagIn(List<String> values) {
            addCriterion("delflag in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotIn(List<String> values) {
            addCriterion("delflag not in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagBetween(String value1, String value2) {
            addCriterion("delflag between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotBetween(String value1, String value2) {
            addCriterion("delflag not between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDefaultmailIsNull() {
            addCriterion("defaultmail is null");
            return (Criteria) this;
        }

        public Criteria andDefaultmailIsNotNull() {
            addCriterion("defaultmail is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultmailEqualTo(String value) {
            addCriterion("defaultmail =", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailNotEqualTo(String value) {
            addCriterion("defaultmail <>", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailGreaterThan(String value) {
            addCriterion("defaultmail >", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailGreaterThanOrEqualTo(String value) {
            addCriterion("defaultmail >=", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailLessThan(String value) {
            addCriterion("defaultmail <", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailLessThanOrEqualTo(String value) {
            addCriterion("defaultmail <=", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailLike(String value) {
            addCriterion("defaultmail like", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailNotLike(String value) {
            addCriterion("defaultmail not like", value, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailIn(List<String> values) {
            addCriterion("defaultmail in", values, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailNotIn(List<String> values) {
            addCriterion("defaultmail not in", values, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailBetween(String value1, String value2) {
            addCriterion("defaultmail between", value1, value2, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaultmailNotBetween(String value1, String value2) {
            addCriterion("defaultmail not between", value1, value2, "defaultmail");
            return (Criteria) this;
        }

        public Criteria andDefaulttelIsNull() {
            addCriterion("defaulttel is null");
            return (Criteria) this;
        }

        public Criteria andDefaulttelIsNotNull() {
            addCriterion("defaulttel is not null");
            return (Criteria) this;
        }

        public Criteria andDefaulttelEqualTo(String value) {
            addCriterion("defaulttel =", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelNotEqualTo(String value) {
            addCriterion("defaulttel <>", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelGreaterThan(String value) {
            addCriterion("defaulttel >", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelGreaterThanOrEqualTo(String value) {
            addCriterion("defaulttel >=", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelLessThan(String value) {
            addCriterion("defaulttel <", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelLessThanOrEqualTo(String value) {
            addCriterion("defaulttel <=", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelLike(String value) {
            addCriterion("defaulttel like", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelNotLike(String value) {
            addCriterion("defaulttel not like", value, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelIn(List<String> values) {
            addCriterion("defaulttel in", values, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelNotIn(List<String> values) {
            addCriterion("defaulttel not in", values, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelBetween(String value1, String value2) {
            addCriterion("defaulttel between", value1, value2, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaulttelNotBetween(String value1, String value2) {
            addCriterion("defaulttel not between", value1, value2, "defaulttel");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileIsNull() {
            addCriterion("defaultmobile is null");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileIsNotNull() {
            addCriterion("defaultmobile is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileEqualTo(String value) {
            addCriterion("defaultmobile =", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileNotEqualTo(String value) {
            addCriterion("defaultmobile <>", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileGreaterThan(String value) {
            addCriterion("defaultmobile >", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileGreaterThanOrEqualTo(String value) {
            addCriterion("defaultmobile >=", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileLessThan(String value) {
            addCriterion("defaultmobile <", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileLessThanOrEqualTo(String value) {
            addCriterion("defaultmobile <=", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileLike(String value) {
            addCriterion("defaultmobile like", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileNotLike(String value) {
            addCriterion("defaultmobile not like", value, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileIn(List<String> values) {
            addCriterion("defaultmobile in", values, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileNotIn(List<String> values) {
            addCriterion("defaultmobile not in", values, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileBetween(String value1, String value2) {
            addCriterion("defaultmobile between", value1, value2, "defaultmobile");
            return (Criteria) this;
        }

        public Criteria andDefaultmobileNotBetween(String value1, String value2) {
            addCriterion("defaultmobile not between", value1, value2, "defaultmobile");
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