package com.ytgrading.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestLogisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequestLogisticsExample() {
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

        public Criteria andRequestcodeIsNull() {
            addCriterion("requestcode is null");
            return (Criteria) this;
        }

        public Criteria andRequestcodeIsNotNull() {
            addCriterion("requestcode is not null");
            return (Criteria) this;
        }

        public Criteria andRequestcodeEqualTo(String value) {
            addCriterion("requestcode =", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotEqualTo(String value) {
            addCriterion("requestcode <>", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeGreaterThan(String value) {
            addCriterion("requestcode >", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeGreaterThanOrEqualTo(String value) {
            addCriterion("requestcode >=", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLessThan(String value) {
            addCriterion("requestcode <", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLessThanOrEqualTo(String value) {
            addCriterion("requestcode <=", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLike(String value) {
            addCriterion("requestcode like", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotLike(String value) {
            addCriterion("requestcode not like", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeIn(List<String> values) {
            addCriterion("requestcode in", values, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotIn(List<String> values) {
            addCriterion("requestcode not in", values, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeBetween(String value1, String value2) {
            addCriterion("requestcode between", value1, value2, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotBetween(String value1, String value2) {
            addCriterion("requestcode not between", value1, value2, "requestcode");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoIsNull() {
            addCriterion("logisticsno is null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoIsNotNull() {
            addCriterion("logisticsno is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoEqualTo(String value) {
            addCriterion("logisticsno =", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotEqualTo(String value) {
            addCriterion("logisticsno <>", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoGreaterThan(String value) {
            addCriterion("logisticsno >", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoGreaterThanOrEqualTo(String value) {
            addCriterion("logisticsno >=", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoLessThan(String value) {
            addCriterion("logisticsno <", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoLessThanOrEqualTo(String value) {
            addCriterion("logisticsno <=", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoLike(String value) {
            addCriterion("logisticsno like", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotLike(String value) {
            addCriterion("logisticsno not like", value, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoIn(List<String> values) {
            addCriterion("logisticsno in", values, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotIn(List<String> values) {
            addCriterion("logisticsno not in", values, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoBetween(String value1, String value2) {
            addCriterion("logisticsno between", value1, value2, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andLogisticsnoNotBetween(String value1, String value2) {
            addCriterion("logisticsno not between", value1, value2, "logisticsno");
            return (Criteria) this;
        }

        public Criteria andPacklengthIsNull() {
            addCriterion("packlength is null");
            return (Criteria) this;
        }

        public Criteria andPacklengthIsNotNull() {
            addCriterion("packlength is not null");
            return (Criteria) this;
        }

        public Criteria andPacklengthEqualTo(Integer value) {
            addCriterion("packlength =", value, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthNotEqualTo(Integer value) {
            addCriterion("packlength <>", value, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthGreaterThan(Integer value) {
            addCriterion("packlength >", value, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("packlength >=", value, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthLessThan(Integer value) {
            addCriterion("packlength <", value, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthLessThanOrEqualTo(Integer value) {
            addCriterion("packlength <=", value, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthIn(List<Integer> values) {
            addCriterion("packlength in", values, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthNotIn(List<Integer> values) {
            addCriterion("packlength not in", values, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthBetween(Integer value1, Integer value2) {
            addCriterion("packlength between", value1, value2, "packlength");
            return (Criteria) this;
        }

        public Criteria andPacklengthNotBetween(Integer value1, Integer value2) {
            addCriterion("packlength not between", value1, value2, "packlength");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andPackwidthIsNull() {
            addCriterion("packwidth is null");
            return (Criteria) this;
        }

        public Criteria andPackwidthIsNotNull() {
            addCriterion("packwidth is not null");
            return (Criteria) this;
        }

        public Criteria andPackwidthEqualTo(Integer value) {
            addCriterion("packwidth =", value, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthNotEqualTo(Integer value) {
            addCriterion("packwidth <>", value, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthGreaterThan(Integer value) {
            addCriterion("packwidth >", value, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("packwidth >=", value, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthLessThan(Integer value) {
            addCriterion("packwidth <", value, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthLessThanOrEqualTo(Integer value) {
            addCriterion("packwidth <=", value, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthIn(List<Integer> values) {
            addCriterion("packwidth in", values, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthNotIn(List<Integer> values) {
            addCriterion("packwidth not in", values, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthBetween(Integer value1, Integer value2) {
            addCriterion("packwidth between", value1, value2, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackwidthNotBetween(Integer value1, Integer value2) {
            addCriterion("packwidth not between", value1, value2, "packwidth");
            return (Criteria) this;
        }

        public Criteria andPackheightIsNull() {
            addCriterion("packheight is null");
            return (Criteria) this;
        }

        public Criteria andPackheightIsNotNull() {
            addCriterion("packheight is not null");
            return (Criteria) this;
        }

        public Criteria andPackheightEqualTo(Integer value) {
            addCriterion("packheight =", value, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightNotEqualTo(Integer value) {
            addCriterion("packheight <>", value, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightGreaterThan(Integer value) {
            addCriterion("packheight >", value, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightGreaterThanOrEqualTo(Integer value) {
            addCriterion("packheight >=", value, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightLessThan(Integer value) {
            addCriterion("packheight <", value, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightLessThanOrEqualTo(Integer value) {
            addCriterion("packheight <=", value, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightIn(List<Integer> values) {
            addCriterion("packheight in", values, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightNotIn(List<Integer> values) {
            addCriterion("packheight not in", values, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightBetween(Integer value1, Integer value2) {
            addCriterion("packheight between", value1, value2, "packheight");
            return (Criteria) this;
        }

        public Criteria andPackheightNotBetween(Integer value1, Integer value2) {
            addCriterion("packheight not between", value1, value2, "packheight");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNull() {
            addCriterion("createby is null");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNotNull() {
            addCriterion("createby is not null");
            return (Criteria) this;
        }

        public Criteria andCreatebyEqualTo(Integer value) {
            addCriterion("createby =", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotEqualTo(Integer value) {
            addCriterion("createby <>", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThan(Integer value) {
            addCriterion("createby >", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThanOrEqualTo(Integer value) {
            addCriterion("createby >=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThan(Integer value) {
            addCriterion("createby <", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThanOrEqualTo(Integer value) {
            addCriterion("createby <=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyIn(List<Integer> values) {
            addCriterion("createby in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotIn(List<Integer> values) {
            addCriterion("createby not in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyBetween(Integer value1, Integer value2) {
            addCriterion("createby between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotBetween(Integer value1, Integer value2) {
            addCriterion("createby not between", value1, value2, "createby");
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