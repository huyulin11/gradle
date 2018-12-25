package com.ytgrading.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogisticsPackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogisticsPackExample() {
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

        public Criteria andShippernameIsNull() {
            addCriterion("shippername is null");
            return (Criteria) this;
        }

        public Criteria andShippernameIsNotNull() {
            addCriterion("shippername is not null");
            return (Criteria) this;
        }

        public Criteria andShippernameEqualTo(String value) {
            addCriterion("shippername =", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotEqualTo(String value) {
            addCriterion("shippername <>", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameGreaterThan(String value) {
            addCriterion("shippername >", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameGreaterThanOrEqualTo(String value) {
            addCriterion("shippername >=", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameLessThan(String value) {
            addCriterion("shippername <", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameLessThanOrEqualTo(String value) {
            addCriterion("shippername <=", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameLike(String value) {
            addCriterion("shippername like", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotLike(String value) {
            addCriterion("shippername not like", value, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameIn(List<String> values) {
            addCriterion("shippername in", values, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotIn(List<String> values) {
            addCriterion("shippername not in", values, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameBetween(String value1, String value2) {
            addCriterion("shippername between", value1, value2, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippernameNotBetween(String value1, String value2) {
            addCriterion("shippername not between", value1, value2, "shippername");
            return (Criteria) this;
        }

        public Criteria andShippertelIsNull() {
            addCriterion("shippertel is null");
            return (Criteria) this;
        }

        public Criteria andShippertelIsNotNull() {
            addCriterion("shippertel is not null");
            return (Criteria) this;
        }

        public Criteria andShippertelEqualTo(String value) {
            addCriterion("shippertel =", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelNotEqualTo(String value) {
            addCriterion("shippertel <>", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelGreaterThan(String value) {
            addCriterion("shippertel >", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelGreaterThanOrEqualTo(String value) {
            addCriterion("shippertel >=", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelLessThan(String value) {
            addCriterion("shippertel <", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelLessThanOrEqualTo(String value) {
            addCriterion("shippertel <=", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelLike(String value) {
            addCriterion("shippertel like", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelNotLike(String value) {
            addCriterion("shippertel not like", value, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelIn(List<String> values) {
            addCriterion("shippertel in", values, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelNotIn(List<String> values) {
            addCriterion("shippertel not in", values, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelBetween(String value1, String value2) {
            addCriterion("shippertel between", value1, value2, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShippertelNotBetween(String value1, String value2) {
            addCriterion("shippertel not between", value1, value2, "shippertel");
            return (Criteria) this;
        }

        public Criteria andShipperaddressIsNull() {
            addCriterion("shipperaddress is null");
            return (Criteria) this;
        }

        public Criteria andShipperaddressIsNotNull() {
            addCriterion("shipperaddress is not null");
            return (Criteria) this;
        }

        public Criteria andShipperaddressEqualTo(String value) {
            addCriterion("shipperaddress =", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressNotEqualTo(String value) {
            addCriterion("shipperaddress <>", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressGreaterThan(String value) {
            addCriterion("shipperaddress >", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressGreaterThanOrEqualTo(String value) {
            addCriterion("shipperaddress >=", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressLessThan(String value) {
            addCriterion("shipperaddress <", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressLessThanOrEqualTo(String value) {
            addCriterion("shipperaddress <=", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressLike(String value) {
            addCriterion("shipperaddress like", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressNotLike(String value) {
            addCriterion("shipperaddress not like", value, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressIn(List<String> values) {
            addCriterion("shipperaddress in", values, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressNotIn(List<String> values) {
            addCriterion("shipperaddress not in", values, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressBetween(String value1, String value2) {
            addCriterion("shipperaddress between", value1, value2, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andShipperaddressNotBetween(String value1, String value2) {
            addCriterion("shipperaddress not between", value1, value2, "shipperaddress");
            return (Criteria) this;
        }

        public Criteria andPackstatusIsNull() {
            addCriterion("packstatus is null");
            return (Criteria) this;
        }

        public Criteria andPackstatusIsNotNull() {
            addCriterion("packstatus is not null");
            return (Criteria) this;
        }

        public Criteria andPackstatusEqualTo(String value) {
            addCriterion("packstatus =", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusNotEqualTo(String value) {
            addCriterion("packstatus <>", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusGreaterThan(String value) {
            addCriterion("packstatus >", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusGreaterThanOrEqualTo(String value) {
            addCriterion("packstatus >=", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusLessThan(String value) {
            addCriterion("packstatus <", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusLessThanOrEqualTo(String value) {
            addCriterion("packstatus <=", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusLike(String value) {
            addCriterion("packstatus like", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusNotLike(String value) {
            addCriterion("packstatus not like", value, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusIn(List<String> values) {
            addCriterion("packstatus in", values, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusNotIn(List<String> values) {
            addCriterion("packstatus not in", values, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusBetween(String value1, String value2) {
            addCriterion("packstatus between", value1, value2, "packstatus");
            return (Criteria) this;
        }

        public Criteria andPackstatusNotBetween(String value1, String value2) {
            addCriterion("packstatus not between", value1, value2, "packstatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusIsNull() {
            addCriterion("receivestatus is null");
            return (Criteria) this;
        }

        public Criteria andReceivestatusIsNotNull() {
            addCriterion("receivestatus is not null");
            return (Criteria) this;
        }

        public Criteria andReceivestatusEqualTo(String value) {
            addCriterion("receivestatus =", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusNotEqualTo(String value) {
            addCriterion("receivestatus <>", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusGreaterThan(String value) {
            addCriterion("receivestatus >", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusGreaterThanOrEqualTo(String value) {
            addCriterion("receivestatus >=", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusLessThan(String value) {
            addCriterion("receivestatus <", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusLessThanOrEqualTo(String value) {
            addCriterion("receivestatus <=", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusLike(String value) {
            addCriterion("receivestatus like", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusNotLike(String value) {
            addCriterion("receivestatus not like", value, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusIn(List<String> values) {
            addCriterion("receivestatus in", values, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusNotIn(List<String> values) {
            addCriterion("receivestatus not in", values, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusBetween(String value1, String value2) {
            addCriterion("receivestatus between", value1, value2, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andReceivestatusNotBetween(String value1, String value2) {
            addCriterion("receivestatus not between", value1, value2, "receivestatus");
            return (Criteria) this;
        }

        public Criteria andRequestcodesIsNull() {
            addCriterion("requestcodes is null");
            return (Criteria) this;
        }

        public Criteria andRequestcodesIsNotNull() {
            addCriterion("requestcodes is not null");
            return (Criteria) this;
        }

        public Criteria andRequestcodesEqualTo(String value) {
            addCriterion("requestcodes =", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesNotEqualTo(String value) {
            addCriterion("requestcodes <>", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesGreaterThan(String value) {
            addCriterion("requestcodes >", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesGreaterThanOrEqualTo(String value) {
            addCriterion("requestcodes >=", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesLessThan(String value) {
            addCriterion("requestcodes <", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesLessThanOrEqualTo(String value) {
            addCriterion("requestcodes <=", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesLike(String value) {
            addCriterion("requestcodes like", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesNotLike(String value) {
            addCriterion("requestcodes not like", value, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesIn(List<String> values) {
            addCriterion("requestcodes in", values, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesNotIn(List<String> values) {
            addCriterion("requestcodes not in", values, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesBetween(String value1, String value2) {
            addCriterion("requestcodes between", value1, value2, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andRequestcodesNotBetween(String value1, String value2) {
            addCriterion("requestcodes not between", value1, value2, "requestcodes");
            return (Criteria) this;
        }

        public Criteria andPacknoIsNull() {
            addCriterion("packno is null");
            return (Criteria) this;
        }

        public Criteria andPacknoIsNotNull() {
            addCriterion("packno is not null");
            return (Criteria) this;
        }

        public Criteria andPacknoEqualTo(Integer value) {
            addCriterion("packno =", value, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoNotEqualTo(Integer value) {
            addCriterion("packno <>", value, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoGreaterThan(Integer value) {
            addCriterion("packno >", value, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoGreaterThanOrEqualTo(Integer value) {
            addCriterion("packno >=", value, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoLessThan(Integer value) {
            addCriterion("packno <", value, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoLessThanOrEqualTo(Integer value) {
            addCriterion("packno <=", value, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoIn(List<Integer> values) {
            addCriterion("packno in", values, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoNotIn(List<Integer> values) {
            addCriterion("packno not in", values, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoBetween(Integer value1, Integer value2) {
            addCriterion("packno between", value1, value2, "packno");
            return (Criteria) this;
        }

        public Criteria andPacknoNotBetween(Integer value1, Integer value2) {
            addCriterion("packno not between", value1, value2, "packno");
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

        public Criteria andCustomertelIsNull() {
            addCriterion("customertel is null");
            return (Criteria) this;
        }

        public Criteria andCustomertelIsNotNull() {
            addCriterion("customertel is not null");
            return (Criteria) this;
        }

        public Criteria andCustomertelEqualTo(String value) {
            addCriterion("customertel =", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelNotEqualTo(String value) {
            addCriterion("customertel <>", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelGreaterThan(String value) {
            addCriterion("customertel >", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelGreaterThanOrEqualTo(String value) {
            addCriterion("customertel >=", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelLessThan(String value) {
            addCriterion("customertel <", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelLessThanOrEqualTo(String value) {
            addCriterion("customertel <=", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelLike(String value) {
            addCriterion("customertel like", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelNotLike(String value) {
            addCriterion("customertel not like", value, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelIn(List<String> values) {
            addCriterion("customertel in", values, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelNotIn(List<String> values) {
            addCriterion("customertel not in", values, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelBetween(String value1, String value2) {
            addCriterion("customertel between", value1, value2, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomertelNotBetween(String value1, String value2) {
            addCriterion("customertel not between", value1, value2, "customertel");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNull() {
            addCriterion("customername is null");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNotNull() {
            addCriterion("customername is not null");
            return (Criteria) this;
        }

        public Criteria andCustomernameEqualTo(String value) {
            addCriterion("customername =", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotEqualTo(String value) {
            addCriterion("customername <>", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThan(String value) {
            addCriterion("customername >", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThanOrEqualTo(String value) {
            addCriterion("customername >=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThan(String value) {
            addCriterion("customername <", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThanOrEqualTo(String value) {
            addCriterion("customername <=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLike(String value) {
            addCriterion("customername like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotLike(String value) {
            addCriterion("customername not like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameIn(List<String> values) {
            addCriterion("customername in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotIn(List<String> values) {
            addCriterion("customername not in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameBetween(String value1, String value2) {
            addCriterion("customername between", value1, value2, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotBetween(String value1, String value2) {
            addCriterion("customername not between", value1, value2, "customername");
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

        public Criteria andCustomernoIsNull() {
            addCriterion("customerno is null");
            return (Criteria) this;
        }

        public Criteria andCustomernoIsNotNull() {
            addCriterion("customerno is not null");
            return (Criteria) this;
        }

        public Criteria andCustomernoEqualTo(Integer value) {
            addCriterion("customerno =", value, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoNotEqualTo(Integer value) {
            addCriterion("customerno <>", value, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoGreaterThan(Integer value) {
            addCriterion("customerno >", value, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoGreaterThanOrEqualTo(Integer value) {
            addCriterion("customerno >=", value, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoLessThan(Integer value) {
            addCriterion("customerno <", value, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoLessThanOrEqualTo(Integer value) {
            addCriterion("customerno <=", value, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoIn(List<Integer> values) {
            addCriterion("customerno in", values, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoNotIn(List<Integer> values) {
            addCriterion("customerno not in", values, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoBetween(Integer value1, Integer value2) {
            addCriterion("customerno between", value1, value2, "customerno");
            return (Criteria) this;
        }

        public Criteria andCustomernoNotBetween(Integer value1, Integer value2) {
            addCriterion("customerno not between", value1, value2, "customerno");
            return (Criteria) this;
        }

        public Criteria andOwnidIsNull() {
            addCriterion("ownid is null");
            return (Criteria) this;
        }

        public Criteria andOwnidIsNotNull() {
            addCriterion("ownid is not null");
            return (Criteria) this;
        }

        public Criteria andOwnidEqualTo(String value) {
            addCriterion("ownid =", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidNotEqualTo(String value) {
            addCriterion("ownid <>", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidGreaterThan(String value) {
            addCriterion("ownid >", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidGreaterThanOrEqualTo(String value) {
            addCriterion("ownid >=", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidLessThan(String value) {
            addCriterion("ownid <", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidLessThanOrEqualTo(String value) {
            addCriterion("ownid <=", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidLike(String value) {
            addCriterion("ownid like", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidNotLike(String value) {
            addCriterion("ownid not like", value, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidIn(List<String> values) {
            addCriterion("ownid in", values, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidNotIn(List<String> values) {
            addCriterion("ownid not in", values, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidBetween(String value1, String value2) {
            addCriterion("ownid between", value1, value2, "ownid");
            return (Criteria) this;
        }

        public Criteria andOwnidNotBetween(String value1, String value2) {
            addCriterion("ownid not between", value1, value2, "ownid");
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

        public Criteria andCuttimeIsNull() {
            addCriterion("cuttime is null");
            return (Criteria) this;
        }

        public Criteria andCuttimeIsNotNull() {
            addCriterion("cuttime is not null");
            return (Criteria) this;
        }

        public Criteria andCuttimeEqualTo(Date value) {
            addCriterion("cuttime =", value, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeNotEqualTo(Date value) {
            addCriterion("cuttime <>", value, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeGreaterThan(Date value) {
            addCriterion("cuttime >", value, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cuttime >=", value, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeLessThan(Date value) {
            addCriterion("cuttime <", value, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeLessThanOrEqualTo(Date value) {
            addCriterion("cuttime <=", value, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeIn(List<Date> values) {
            addCriterion("cuttime in", values, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeNotIn(List<Date> values) {
            addCriterion("cuttime not in", values, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeBetween(Date value1, Date value2) {
            addCriterion("cuttime between", value1, value2, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCuttimeNotBetween(Date value1, Date value2) {
            addCriterion("cuttime not between", value1, value2, "cuttime");
            return (Criteria) this;
        }

        public Criteria andCutstatusIsNull() {
            addCriterion("cutstatus is null");
            return (Criteria) this;
        }

        public Criteria andCutstatusIsNotNull() {
            addCriterion("cutstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCutstatusEqualTo(String value) {
            addCriterion("cutstatus =", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusNotEqualTo(String value) {
            addCriterion("cutstatus <>", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusGreaterThan(String value) {
            addCriterion("cutstatus >", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusGreaterThanOrEqualTo(String value) {
            addCriterion("cutstatus >=", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusLessThan(String value) {
            addCriterion("cutstatus <", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusLessThanOrEqualTo(String value) {
            addCriterion("cutstatus <=", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusLike(String value) {
            addCriterion("cutstatus like", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusNotLike(String value) {
            addCriterion("cutstatus not like", value, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusIn(List<String> values) {
            addCriterion("cutstatus in", values, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusNotIn(List<String> values) {
            addCriterion("cutstatus not in", values, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusBetween(String value1, String value2) {
            addCriterion("cutstatus between", value1, value2, "cutstatus");
            return (Criteria) this;
        }

        public Criteria andCutstatusNotBetween(String value1, String value2) {
            addCriterion("cutstatus not between", value1, value2, "cutstatus");
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