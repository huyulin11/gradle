package com.ytgrading.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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

        public Criteria andPostionIsNull() {
            addCriterion("postion is null");
            return (Criteria) this;
        }

        public Criteria andPostionIsNotNull() {
            addCriterion("postion is not null");
            return (Criteria) this;
        }

        public Criteria andPostionEqualTo(String value) {
            addCriterion("postion =", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionNotEqualTo(String value) {
            addCriterion("postion <>", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionGreaterThan(String value) {
            addCriterion("postion >", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionGreaterThanOrEqualTo(String value) {
            addCriterion("postion >=", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionLessThan(String value) {
            addCriterion("postion <", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionLessThanOrEqualTo(String value) {
            addCriterion("postion <=", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionLike(String value) {
            addCriterion("postion like", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionNotLike(String value) {
            addCriterion("postion not like", value, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionIn(List<String> values) {
            addCriterion("postion in", values, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionNotIn(List<String> values) {
            addCriterion("postion not in", values, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionBetween(String value1, String value2) {
            addCriterion("postion between", value1, value2, "postion");
            return (Criteria) this;
        }

        public Criteria andPostionNotBetween(String value1, String value2) {
            addCriterion("postion not between", value1, value2, "postion");
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

        public Criteria andAcceptidIsNull() {
            addCriterion("acceptid is null");
            return (Criteria) this;
        }

        public Criteria andAcceptidIsNotNull() {
            addCriterion("acceptid is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptidEqualTo(Integer value) {
            addCriterion("acceptid =", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotEqualTo(Integer value) {
            addCriterion("acceptid <>", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThan(Integer value) {
            addCriterion("acceptid >", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidGreaterThanOrEqualTo(Integer value) {
            addCriterion("acceptid >=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThan(Integer value) {
            addCriterion("acceptid <", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidLessThanOrEqualTo(Integer value) {
            addCriterion("acceptid <=", value, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidIn(List<Integer> values) {
            addCriterion("acceptid in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotIn(List<Integer> values) {
            addCriterion("acceptid not in", values, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidBetween(Integer value1, Integer value2) {
            addCriterion("acceptid between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAcceptidNotBetween(Integer value1, Integer value2) {
            addCriterion("acceptid not between", value1, value2, "acceptid");
            return (Criteria) this;
        }

        public Criteria andAccepttimeIsNull() {
            addCriterion("accepttime is null");
            return (Criteria) this;
        }

        public Criteria andAccepttimeIsNotNull() {
            addCriterion("accepttime is not null");
            return (Criteria) this;
        }

        public Criteria andAccepttimeEqualTo(Date value) {
            addCriterion("accepttime =", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeNotEqualTo(Date value) {
            addCriterion("accepttime <>", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeGreaterThan(Date value) {
            addCriterion("accepttime >", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("accepttime >=", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeLessThan(Date value) {
            addCriterion("accepttime <", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeLessThanOrEqualTo(Date value) {
            addCriterion("accepttime <=", value, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeIn(List<Date> values) {
            addCriterion("accepttime in", values, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeNotIn(List<Date> values) {
            addCriterion("accepttime not in", values, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeBetween(Date value1, Date value2) {
            addCriterion("accepttime between", value1, value2, "accepttime");
            return (Criteria) this;
        }

        public Criteria andAccepttimeNotBetween(Date value1, Date value2) {
            addCriterion("accepttime not between", value1, value2, "accepttime");
            return (Criteria) this;
        }

        public Criteria andSendidIsNull() {
            addCriterion("sendid is null");
            return (Criteria) this;
        }

        public Criteria andSendidIsNotNull() {
            addCriterion("sendid is not null");
            return (Criteria) this;
        }

        public Criteria andSendidEqualTo(Integer value) {
            addCriterion("sendid =", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotEqualTo(Integer value) {
            addCriterion("sendid <>", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidGreaterThan(Integer value) {
            addCriterion("sendid >", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendid >=", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidLessThan(Integer value) {
            addCriterion("sendid <", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidLessThanOrEqualTo(Integer value) {
            addCriterion("sendid <=", value, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidIn(List<Integer> values) {
            addCriterion("sendid in", values, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotIn(List<Integer> values) {
            addCriterion("sendid not in", values, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidBetween(Integer value1, Integer value2) {
            addCriterion("sendid between", value1, value2, "sendid");
            return (Criteria) this;
        }

        public Criteria andSendidNotBetween(Integer value1, Integer value2) {
            addCriterion("sendid not between", value1, value2, "sendid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStocknoIsNull() {
            addCriterion("stockno is null");
            return (Criteria) this;
        }

        public Criteria andStocknoIsNotNull() {
            addCriterion("stockno is not null");
            return (Criteria) this;
        }

        public Criteria andStocknoEqualTo(String value) {
            addCriterion("stockno =", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoNotEqualTo(String value) {
            addCriterion("stockno <>", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoGreaterThan(String value) {
            addCriterion("stockno >", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoGreaterThanOrEqualTo(String value) {
            addCriterion("stockno >=", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoLessThan(String value) {
            addCriterion("stockno <", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoLessThanOrEqualTo(String value) {
            addCriterion("stockno <=", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoLike(String value) {
            addCriterion("stockno like", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoNotLike(String value) {
            addCriterion("stockno not like", value, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoIn(List<String> values) {
            addCriterion("stockno in", values, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoNotIn(List<String> values) {
            addCriterion("stockno not in", values, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoBetween(String value1, String value2) {
            addCriterion("stockno between", value1, value2, "stockno");
            return (Criteria) this;
        }

        public Criteria andStocknoNotBetween(String value1, String value2) {
            addCriterion("stockno not between", value1, value2, "stockno");
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