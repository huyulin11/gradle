package com.ytgrading.dto;

import java.util.ArrayList;
import java.util.List;

public class SysCoinMaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCoinMaterialExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andContentunitIsNull() {
            addCriterion("contentunit is null");
            return (Criteria) this;
        }

        public Criteria andContentunitIsNotNull() {
            addCriterion("contentunit is not null");
            return (Criteria) this;
        }

        public Criteria andContentunitEqualTo(Integer value) {
            addCriterion("contentunit =", value, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitNotEqualTo(Integer value) {
            addCriterion("contentunit <>", value, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitGreaterThan(Integer value) {
            addCriterion("contentunit >", value, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitGreaterThanOrEqualTo(Integer value) {
            addCriterion("contentunit >=", value, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitLessThan(Integer value) {
            addCriterion("contentunit <", value, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitLessThanOrEqualTo(Integer value) {
            addCriterion("contentunit <=", value, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitIn(List<Integer> values) {
            addCriterion("contentunit in", values, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitNotIn(List<Integer> values) {
            addCriterion("contentunit not in", values, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitBetween(Integer value1, Integer value2) {
            addCriterion("contentunit between", value1, value2, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentunitNotBetween(Integer value1, Integer value2) {
            addCriterion("contentunit not between", value1, value2, "contentunit");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(Integer value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(Integer value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(Integer value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(Integer value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(Integer value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(Integer value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<Integer> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<Integer> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(Integer value1, Integer value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(Integer value1, Integer value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andMeasurementIsNull() {
            addCriterion("measurement is null");
            return (Criteria) this;
        }

        public Criteria andMeasurementIsNotNull() {
            addCriterion("measurement is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurementEqualTo(Integer value) {
            addCriterion("measurement =", value, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementNotEqualTo(Integer value) {
            addCriterion("measurement <>", value, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementGreaterThan(Integer value) {
            addCriterion("measurement >", value, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementGreaterThanOrEqualTo(Integer value) {
            addCriterion("measurement >=", value, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementLessThan(Integer value) {
            addCriterion("measurement <", value, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementLessThanOrEqualTo(Integer value) {
            addCriterion("measurement <=", value, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementIn(List<Integer> values) {
            addCriterion("measurement in", values, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementNotIn(List<Integer> values) {
            addCriterion("measurement not in", values, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementBetween(Integer value1, Integer value2) {
            addCriterion("measurement between", value1, value2, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementNotBetween(Integer value1, Integer value2) {
            addCriterion("measurement not between", value1, value2, "measurement");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitIsNull() {
            addCriterion("measurementunit is null");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitIsNotNull() {
            addCriterion("measurementunit is not null");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitEqualTo(Integer value) {
            addCriterion("measurementunit =", value, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitNotEqualTo(Integer value) {
            addCriterion("measurementunit <>", value, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitGreaterThan(Integer value) {
            addCriterion("measurementunit >", value, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitGreaterThanOrEqualTo(Integer value) {
            addCriterion("measurementunit >=", value, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitLessThan(Integer value) {
            addCriterion("measurementunit <", value, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitLessThanOrEqualTo(Integer value) {
            addCriterion("measurementunit <=", value, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitIn(List<Integer> values) {
            addCriterion("measurementunit in", values, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitNotIn(List<Integer> values) {
            addCriterion("measurementunit not in", values, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitBetween(Integer value1, Integer value2) {
            addCriterion("measurementunit between", value1, value2, "measurementunit");
            return (Criteria) this;
        }

        public Criteria andMeasurementunitNotBetween(Integer value1, Integer value2) {
            addCriterion("measurementunit not between", value1, value2, "measurementunit");
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