package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestCoinScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequestCoinScoreExample() {
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

        public Criteria andRequestcoinidIsNull() {
            addCriterion("requestcoinid is null");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidIsNotNull() {
            addCriterion("requestcoinid is not null");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidEqualTo(String value) {
            addCriterion("requestcoinid =", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidNotEqualTo(String value) {
            addCriterion("requestcoinid <>", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidGreaterThan(String value) {
            addCriterion("requestcoinid >", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidGreaterThanOrEqualTo(String value) {
            addCriterion("requestcoinid >=", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidLessThan(String value) {
            addCriterion("requestcoinid <", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidLessThanOrEqualTo(String value) {
            addCriterion("requestcoinid <=", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidLike(String value) {
            addCriterion("requestcoinid like", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidNotLike(String value) {
            addCriterion("requestcoinid not like", value, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidIn(List<String> values) {
            addCriterion("requestcoinid in", values, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidNotIn(List<String> values) {
            addCriterion("requestcoinid not in", values, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidBetween(String value1, String value2) {
            addCriterion("requestcoinid between", value1, value2, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andRequestcoinidNotBetween(String value1, String value2) {
            addCriterion("requestcoinid not between", value1, value2, "requestcoinid");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
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

        public Criteria andScorebyIsNull() {
            addCriterion("scoreby is null");
            return (Criteria) this;
        }

        public Criteria andScorebyIsNotNull() {
            addCriterion("scoreby is not null");
            return (Criteria) this;
        }

        public Criteria andScorebyEqualTo(Integer value) {
            addCriterion("scoreby =", value, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyNotEqualTo(Integer value) {
            addCriterion("scoreby <>", value, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyGreaterThan(Integer value) {
            addCriterion("scoreby >", value, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyGreaterThanOrEqualTo(Integer value) {
            addCriterion("scoreby >=", value, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyLessThan(Integer value) {
            addCriterion("scoreby <", value, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyLessThanOrEqualTo(Integer value) {
            addCriterion("scoreby <=", value, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyIn(List<Integer> values) {
            addCriterion("scoreby in", values, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyNotIn(List<Integer> values) {
            addCriterion("scoreby not in", values, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyBetween(Integer value1, Integer value2) {
            addCriterion("scoreby between", value1, value2, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScorebyNotBetween(Integer value1, Integer value2) {
            addCriterion("scoreby not between", value1, value2, "scoreby");
            return (Criteria) this;
        }

        public Criteria andScoretimeIsNull() {
            addCriterion("scoretime is null");
            return (Criteria) this;
        }

        public Criteria andScoretimeIsNotNull() {
            addCriterion("scoretime is not null");
            return (Criteria) this;
        }

        public Criteria andScoretimeEqualTo(Date value) {
            addCriterion("scoretime =", value, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeNotEqualTo(Date value) {
            addCriterion("scoretime <>", value, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeGreaterThan(Date value) {
            addCriterion("scoretime >", value, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scoretime >=", value, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeLessThan(Date value) {
            addCriterion("scoretime <", value, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeLessThanOrEqualTo(Date value) {
            addCriterion("scoretime <=", value, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeIn(List<Date> values) {
            addCriterion("scoretime in", values, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeNotIn(List<Date> values) {
            addCriterion("scoretime not in", values, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeBetween(Date value1, Date value2) {
            addCriterion("scoretime between", value1, value2, "scoretime");
            return (Criteria) this;
        }

        public Criteria andScoretimeNotBetween(Date value1, Date value2) {
            addCriterion("scoretime not between", value1, value2, "scoretime");
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