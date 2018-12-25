package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RequestDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequestDetailExample() {
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNull() {
            addCriterion("evaluate is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateEqualTo(BigDecimal value) {
            addCriterion("evaluate =", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("evaluate <>", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThan(BigDecimal value) {
            addCriterion("evaluate >", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("evaluate >=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThan(BigDecimal value) {
            addCriterion("evaluate <", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("evaluate <=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateIn(List<BigDecimal> values) {
            addCriterion("evaluate in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("evaluate not in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("evaluate between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("evaluate not between", value1, value2, "evaluate");
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

        public Criteria andNumindexIsNull() {
            addCriterion("numindex is null");
            return (Criteria) this;
        }

        public Criteria andNumindexIsNotNull() {
            addCriterion("numindex is not null");
            return (Criteria) this;
        }

        public Criteria andNumindexEqualTo(Integer value) {
            addCriterion("numindex =", value, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexNotEqualTo(Integer value) {
            addCriterion("numindex <>", value, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexGreaterThan(Integer value) {
            addCriterion("numindex >", value, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexGreaterThanOrEqualTo(Integer value) {
            addCriterion("numindex >=", value, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexLessThan(Integer value) {
            addCriterion("numindex <", value, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexLessThanOrEqualTo(Integer value) {
            addCriterion("numindex <=", value, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexIn(List<Integer> values) {
            addCriterion("numindex in", values, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexNotIn(List<Integer> values) {
            addCriterion("numindex not in", values, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexBetween(Integer value1, Integer value2) {
            addCriterion("numindex between", value1, value2, "numindex");
            return (Criteria) this;
        }

        public Criteria andNumindexNotBetween(Integer value1, Integer value2) {
            addCriterion("numindex not between", value1, value2, "numindex");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostIsNull() {
            addCriterion("totalreqcost is null");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostIsNotNull() {
            addCriterion("totalreqcost is not null");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostEqualTo(BigDecimal value) {
            addCriterion("totalreqcost =", value, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostNotEqualTo(BigDecimal value) {
            addCriterion("totalreqcost <>", value, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostGreaterThan(BigDecimal value) {
            addCriterion("totalreqcost >", value, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalreqcost >=", value, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostLessThan(BigDecimal value) {
            addCriterion("totalreqcost <", value, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalreqcost <=", value, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostIn(List<BigDecimal> values) {
            addCriterion("totalreqcost in", values, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostNotIn(List<BigDecimal> values) {
            addCriterion("totalreqcost not in", values, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalreqcost between", value1, value2, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalreqcostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalreqcost not between", value1, value2, "totalreqcost");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateIsNull() {
            addCriterion("totalevaluate is null");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateIsNotNull() {
            addCriterion("totalevaluate is not null");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateEqualTo(BigDecimal value) {
            addCriterion("totalevaluate =", value, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateNotEqualTo(BigDecimal value) {
            addCriterion("totalevaluate <>", value, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateGreaterThan(BigDecimal value) {
            addCriterion("totalevaluate >", value, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalevaluate >=", value, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateLessThan(BigDecimal value) {
            addCriterion("totalevaluate <", value, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalevaluate <=", value, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateIn(List<BigDecimal> values) {
            addCriterion("totalevaluate in", values, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateNotIn(List<BigDecimal> values) {
            addCriterion("totalevaluate not in", values, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalevaluate between", value1, value2, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andTotalevaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalevaluate not between", value1, value2, "totalevaluate");
            return (Criteria) this;
        }

        public Criteria andAmountofissueIsNull() {
            addCriterion("amountofissue is null");
            return (Criteria) this;
        }

        public Criteria andAmountofissueIsNotNull() {
            addCriterion("amountofissue is not null");
            return (Criteria) this;
        }

        public Criteria andAmountofissueEqualTo(Integer value) {
            addCriterion("amountofissue =", value, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueNotEqualTo(Integer value) {
            addCriterion("amountofissue <>", value, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueGreaterThan(Integer value) {
            addCriterion("amountofissue >", value, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueGreaterThanOrEqualTo(Integer value) {
            addCriterion("amountofissue >=", value, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueLessThan(Integer value) {
            addCriterion("amountofissue <", value, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueLessThanOrEqualTo(Integer value) {
            addCriterion("amountofissue <=", value, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueIn(List<Integer> values) {
            addCriterion("amountofissue in", values, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueNotIn(List<Integer> values) {
            addCriterion("amountofissue not in", values, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueBetween(Integer value1, Integer value2) {
            addCriterion("amountofissue between", value1, value2, "amountofissue");
            return (Criteria) this;
        }

        public Criteria andAmountofissueNotBetween(Integer value1, Integer value2) {
            addCriterion("amountofissue not between", value1, value2, "amountofissue");
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