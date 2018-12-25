package com.ytgrading.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogisticsTransferExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogisticsTransferExample() {
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

        public Criteria andTransferfromIsNull() {
            addCriterion("transferfrom is null");
            return (Criteria) this;
        }

        public Criteria andTransferfromIsNotNull() {
            addCriterion("transferfrom is not null");
            return (Criteria) this;
        }

        public Criteria andTransferfromEqualTo(Integer value) {
            addCriterion("transferfrom =", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromNotEqualTo(Integer value) {
            addCriterion("transferfrom <>", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromGreaterThan(Integer value) {
            addCriterion("transferfrom >", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromGreaterThanOrEqualTo(Integer value) {
            addCriterion("transferfrom >=", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromLessThan(Integer value) {
            addCriterion("transferfrom <", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromLessThanOrEqualTo(Integer value) {
            addCriterion("transferfrom <=", value, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromIn(List<Integer> values) {
            addCriterion("transferfrom in", values, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromNotIn(List<Integer> values) {
            addCriterion("transferfrom not in", values, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromBetween(Integer value1, Integer value2) {
            addCriterion("transferfrom between", value1, value2, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransferfromNotBetween(Integer value1, Integer value2) {
            addCriterion("transferfrom not between", value1, value2, "transferfrom");
            return (Criteria) this;
        }

        public Criteria andTransfertoIsNull() {
            addCriterion("transferto is null");
            return (Criteria) this;
        }

        public Criteria andTransfertoIsNotNull() {
            addCriterion("transferto is not null");
            return (Criteria) this;
        }

        public Criteria andTransfertoEqualTo(Integer value) {
            addCriterion("transferto =", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoNotEqualTo(Integer value) {
            addCriterion("transferto <>", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoGreaterThan(Integer value) {
            addCriterion("transferto >", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoGreaterThanOrEqualTo(Integer value) {
            addCriterion("transferto >=", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoLessThan(Integer value) {
            addCriterion("transferto <", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoLessThanOrEqualTo(Integer value) {
            addCriterion("transferto <=", value, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoIn(List<Integer> values) {
            addCriterion("transferto in", values, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoNotIn(List<Integer> values) {
            addCriterion("transferto not in", values, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoBetween(Integer value1, Integer value2) {
            addCriterion("transferto between", value1, value2, "transferto");
            return (Criteria) this;
        }

        public Criteria andTransfertoNotBetween(Integer value1, Integer value2) {
            addCriterion("transferto not between", value1, value2, "transferto");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeIsNull() {
            addCriterion("occurrencetime is null");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeIsNotNull() {
            addCriterion("occurrencetime is not null");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeEqualTo(Date value) {
            addCriterion("occurrencetime =", value, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeNotEqualTo(Date value) {
            addCriterion("occurrencetime <>", value, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeGreaterThan(Date value) {
            addCriterion("occurrencetime >", value, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("occurrencetime >=", value, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeLessThan(Date value) {
            addCriterion("occurrencetime <", value, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeLessThanOrEqualTo(Date value) {
            addCriterion("occurrencetime <=", value, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeIn(List<Date> values) {
            addCriterion("occurrencetime in", values, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeNotIn(List<Date> values) {
            addCriterion("occurrencetime not in", values, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeBetween(Date value1, Date value2) {
            addCriterion("occurrencetime between", value1, value2, "occurrencetime");
            return (Criteria) this;
        }

        public Criteria andOccurrencetimeNotBetween(Date value1, Date value2) {
            addCriterion("occurrencetime not between", value1, value2, "occurrencetime");
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(Integer value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(Integer value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(Integer value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(Integer value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(Integer value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<Integer> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<Integer> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(Integer value1, Integer value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
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