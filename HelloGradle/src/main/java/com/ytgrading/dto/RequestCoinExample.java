package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RequestCoinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequestCoinExample() {
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

        public Criteria andCoinidIsNull() {
            addCriterion("coinid is null");
            return (Criteria) this;
        }

        public Criteria andCoinidIsNotNull() {
            addCriterion("coinid is not null");
            return (Criteria) this;
        }

        public Criteria andCoinidEqualTo(Integer value) {
            addCriterion("coinid =", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidNotEqualTo(Integer value) {
            addCriterion("coinid <>", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidGreaterThan(Integer value) {
            addCriterion("coinid >", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coinid >=", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidLessThan(Integer value) {
            addCriterion("coinid <", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidLessThanOrEqualTo(Integer value) {
            addCriterion("coinid <=", value, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidIn(List<Integer> values) {
            addCriterion("coinid in", values, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidNotIn(List<Integer> values) {
            addCriterion("coinid not in", values, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidBetween(Integer value1, Integer value2) {
            addCriterion("coinid between", value1, value2, "coinid");
            return (Criteria) this;
        }

        public Criteria andCoinidNotBetween(Integer value1, Integer value2) {
            addCriterion("coinid not between", value1, value2, "coinid");
            return (Criteria) this;
        }

        public Criteria andRequestidIsNull() {
            addCriterion("requestid is null");
            return (Criteria) this;
        }

        public Criteria andRequestidIsNotNull() {
            addCriterion("requestid is not null");
            return (Criteria) this;
        }

        public Criteria andRequestidEqualTo(String value) {
            addCriterion("requestid =", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotEqualTo(String value) {
            addCriterion("requestid <>", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThan(String value) {
            addCriterion("requestid >", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidGreaterThanOrEqualTo(String value) {
            addCriterion("requestid >=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThan(String value) {
            addCriterion("requestid <", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLessThanOrEqualTo(String value) {
            addCriterion("requestid <=", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidLike(String value) {
            addCriterion("requestid like", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotLike(String value) {
            addCriterion("requestid not like", value, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidIn(List<String> values) {
            addCriterion("requestid in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotIn(List<String> values) {
            addCriterion("requestid not in", values, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidBetween(String value1, String value2) {
            addCriterion("requestid between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestidNotBetween(String value1, String value2) {
            addCriterion("requestid not between", value1, value2, "requestid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidIsNull() {
            addCriterion("requestdetailid is null");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidIsNotNull() {
            addCriterion("requestdetailid is not null");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidEqualTo(String value) {
            addCriterion("requestdetailid =", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidNotEqualTo(String value) {
            addCriterion("requestdetailid <>", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidGreaterThan(String value) {
            addCriterion("requestdetailid >", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidGreaterThanOrEqualTo(String value) {
            addCriterion("requestdetailid >=", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidLessThan(String value) {
            addCriterion("requestdetailid <", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidLessThanOrEqualTo(String value) {
            addCriterion("requestdetailid <=", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidLike(String value) {
            addCriterion("requestdetailid like", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidNotLike(String value) {
            addCriterion("requestdetailid not like", value, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidIn(List<String> values) {
            addCriterion("requestdetailid in", values, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidNotIn(List<String> values) {
            addCriterion("requestdetailid not in", values, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidBetween(String value1, String value2) {
            addCriterion("requestdetailid between", value1, value2, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andRequestdetailidNotBetween(String value1, String value2) {
            addCriterion("requestdetailid not between", value1, value2, "requestdetailid");
            return (Criteria) this;
        }

        public Criteria andCoincodeIsNull() {
            addCriterion("coincode is null");
            return (Criteria) this;
        }

        public Criteria andCoincodeIsNotNull() {
            addCriterion("coincode is not null");
            return (Criteria) this;
        }

        public Criteria andCoincodeEqualTo(String value) {
            addCriterion("coincode =", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeNotEqualTo(String value) {
            addCriterion("coincode <>", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeGreaterThan(String value) {
            addCriterion("coincode >", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeGreaterThanOrEqualTo(String value) {
            addCriterion("coincode >=", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeLessThan(String value) {
            addCriterion("coincode <", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeLessThanOrEqualTo(String value) {
            addCriterion("coincode <=", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeLike(String value) {
            addCriterion("coincode like", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeNotLike(String value) {
            addCriterion("coincode not like", value, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeIn(List<String> values) {
            addCriterion("coincode in", values, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeNotIn(List<String> values) {
            addCriterion("coincode not in", values, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeBetween(String value1, String value2) {
            addCriterion("coincode between", value1, value2, "coincode");
            return (Criteria) this;
        }

        public Criteria andCoincodeNotBetween(String value1, String value2) {
            addCriterion("coincode not between", value1, value2, "coincode");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreIsNull() {
            addCriterion("customerscore is null");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreIsNotNull() {
            addCriterion("customerscore is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreEqualTo(BigDecimal value) {
            addCriterion("customerscore =", value, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreNotEqualTo(BigDecimal value) {
            addCriterion("customerscore <>", value, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreGreaterThan(BigDecimal value) {
            addCriterion("customerscore >", value, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("customerscore >=", value, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreLessThan(BigDecimal value) {
            addCriterion("customerscore <", value, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("customerscore <=", value, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreIn(List<BigDecimal> values) {
            addCriterion("customerscore in", values, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreNotIn(List<BigDecimal> values) {
            addCriterion("customerscore not in", values, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("customerscore between", value1, value2, "customerscore");
            return (Criteria) this;
        }

        public Criteria andCustomerscoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("customerscore not between", value1, value2, "customerscore");
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