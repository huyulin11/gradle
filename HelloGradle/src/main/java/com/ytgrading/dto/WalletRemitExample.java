package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WalletRemitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletRemitExample() {
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

        public Criteria andRemitnoIsNull() {
            addCriterion("remitno is null");
            return (Criteria) this;
        }

        public Criteria andRemitnoIsNotNull() {
            addCriterion("remitno is not null");
            return (Criteria) this;
        }

        public Criteria andRemitnoEqualTo(Integer value) {
            addCriterion("remitno =", value, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoNotEqualTo(Integer value) {
            addCriterion("remitno <>", value, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoGreaterThan(Integer value) {
            addCriterion("remitno >", value, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("remitno >=", value, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoLessThan(Integer value) {
            addCriterion("remitno <", value, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoLessThanOrEqualTo(Integer value) {
            addCriterion("remitno <=", value, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoIn(List<Integer> values) {
            addCriterion("remitno in", values, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoNotIn(List<Integer> values) {
            addCriterion("remitno not in", values, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoBetween(Integer value1, Integer value2) {
            addCriterion("remitno between", value1, value2, "remitno");
            return (Criteria) this;
        }

        public Criteria andRemitnoNotBetween(Integer value1, Integer value2) {
            addCriterion("remitno not between", value1, value2, "remitno");
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andRemitdateIsNull() {
            addCriterion("remitdate is null");
            return (Criteria) this;
        }

        public Criteria andRemitdateIsNotNull() {
            addCriterion("remitdate is not null");
            return (Criteria) this;
        }

        public Criteria andRemitdateEqualTo(Date value) {
            addCriterion("remitdate =", value, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateNotEqualTo(Date value) {
            addCriterion("remitdate <>", value, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateGreaterThan(Date value) {
            addCriterion("remitdate >", value, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateGreaterThanOrEqualTo(Date value) {
            addCriterion("remitdate >=", value, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateLessThan(Date value) {
            addCriterion("remitdate <", value, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateLessThanOrEqualTo(Date value) {
            addCriterion("remitdate <=", value, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateIn(List<Date> values) {
            addCriterion("remitdate in", values, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateNotIn(List<Date> values) {
            addCriterion("remitdate not in", values, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateBetween(Date value1, Date value2) {
            addCriterion("remitdate between", value1, value2, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitdateNotBetween(Date value1, Date value2) {
            addCriterion("remitdate not between", value1, value2, "remitdate");
            return (Criteria) this;
        }

        public Criteria andRemitnameIsNull() {
            addCriterion("remitname is null");
            return (Criteria) this;
        }

        public Criteria andRemitnameIsNotNull() {
            addCriterion("remitname is not null");
            return (Criteria) this;
        }

        public Criteria andRemitnameEqualTo(String value) {
            addCriterion("remitname =", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameNotEqualTo(String value) {
            addCriterion("remitname <>", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameGreaterThan(String value) {
            addCriterion("remitname >", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameGreaterThanOrEqualTo(String value) {
            addCriterion("remitname >=", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameLessThan(String value) {
            addCriterion("remitname <", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameLessThanOrEqualTo(String value) {
            addCriterion("remitname <=", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameLike(String value) {
            addCriterion("remitname like", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameNotLike(String value) {
            addCriterion("remitname not like", value, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameIn(List<String> values) {
            addCriterion("remitname in", values, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameNotIn(List<String> values) {
            addCriterion("remitname not in", values, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameBetween(String value1, String value2) {
            addCriterion("remitname between", value1, value2, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitnameNotBetween(String value1, String value2) {
            addCriterion("remitname not between", value1, value2, "remitname");
            return (Criteria) this;
        }

        public Criteria andRemitfromIsNull() {
            addCriterion("remitfrom is null");
            return (Criteria) this;
        }

        public Criteria andRemitfromIsNotNull() {
            addCriterion("remitfrom is not null");
            return (Criteria) this;
        }

        public Criteria andRemitfromEqualTo(String value) {
            addCriterion("remitfrom =", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromNotEqualTo(String value) {
            addCriterion("remitfrom <>", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromGreaterThan(String value) {
            addCriterion("remitfrom >", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromGreaterThanOrEqualTo(String value) {
            addCriterion("remitfrom >=", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromLessThan(String value) {
            addCriterion("remitfrom <", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromLessThanOrEqualTo(String value) {
            addCriterion("remitfrom <=", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromLike(String value) {
            addCriterion("remitfrom like", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromNotLike(String value) {
            addCriterion("remitfrom not like", value, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromIn(List<String> values) {
            addCriterion("remitfrom in", values, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromNotIn(List<String> values) {
            addCriterion("remitfrom not in", values, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromBetween(String value1, String value2) {
            addCriterion("remitfrom between", value1, value2, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitfromNotBetween(String value1, String value2) {
            addCriterion("remitfrom not between", value1, value2, "remitfrom");
            return (Criteria) this;
        }

        public Criteria andRemitcodeIsNull() {
            addCriterion("remitcode is null");
            return (Criteria) this;
        }

        public Criteria andRemitcodeIsNotNull() {
            addCriterion("remitcode is not null");
            return (Criteria) this;
        }

        public Criteria andRemitcodeEqualTo(String value) {
            addCriterion("remitcode =", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeNotEqualTo(String value) {
            addCriterion("remitcode <>", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeGreaterThan(String value) {
            addCriterion("remitcode >", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeGreaterThanOrEqualTo(String value) {
            addCriterion("remitcode >=", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeLessThan(String value) {
            addCriterion("remitcode <", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeLessThanOrEqualTo(String value) {
            addCriterion("remitcode <=", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeLike(String value) {
            addCriterion("remitcode like", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeNotLike(String value) {
            addCriterion("remitcode not like", value, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeIn(List<String> values) {
            addCriterion("remitcode in", values, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeNotIn(List<String> values) {
            addCriterion("remitcode not in", values, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeBetween(String value1, String value2) {
            addCriterion("remitcode between", value1, value2, "remitcode");
            return (Criteria) this;
        }

        public Criteria andRemitcodeNotBetween(String value1, String value2) {
            addCriterion("remitcode not between", value1, value2, "remitcode");
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

        public Criteria andSubmitdateIsNull() {
            addCriterion("submitdate is null");
            return (Criteria) this;
        }

        public Criteria andSubmitdateIsNotNull() {
            addCriterion("submitdate is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitdateEqualTo(Date value) {
            addCriterion("submitdate =", value, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateNotEqualTo(Date value) {
            addCriterion("submitdate <>", value, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateGreaterThan(Date value) {
            addCriterion("submitdate >", value, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateGreaterThanOrEqualTo(Date value) {
            addCriterion("submitdate >=", value, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateLessThan(Date value) {
            addCriterion("submitdate <", value, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateLessThanOrEqualTo(Date value) {
            addCriterion("submitdate <=", value, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateIn(List<Date> values) {
            addCriterion("submitdate in", values, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateNotIn(List<Date> values) {
            addCriterion("submitdate not in", values, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateBetween(Date value1, Date value2) {
            addCriterion("submitdate between", value1, value2, "submitdate");
            return (Criteria) this;
        }

        public Criteria andSubmitdateNotBetween(Date value1, Date value2) {
            addCriterion("submitdate not between", value1, value2, "submitdate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andConfirmdateIsNull() {
            addCriterion("confirmdate is null");
            return (Criteria) this;
        }

        public Criteria andConfirmdateIsNotNull() {
            addCriterion("confirmdate is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmdateEqualTo(Date value) {
            addCriterion("confirmdate =", value, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateNotEqualTo(Date value) {
            addCriterion("confirmdate <>", value, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateGreaterThan(Date value) {
            addCriterion("confirmdate >", value, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateGreaterThanOrEqualTo(Date value) {
            addCriterion("confirmdate >=", value, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateLessThan(Date value) {
            addCriterion("confirmdate <", value, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateLessThanOrEqualTo(Date value) {
            addCriterion("confirmdate <=", value, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateIn(List<Date> values) {
            addCriterion("confirmdate in", values, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateNotIn(List<Date> values) {
            addCriterion("confirmdate not in", values, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateBetween(Date value1, Date value2) {
            addCriterion("confirmdate between", value1, value2, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmdateNotBetween(Date value1, Date value2) {
            addCriterion("confirmdate not between", value1, value2, "confirmdate");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridIsNull() {
            addCriterion("confirmuserid is null");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridIsNotNull() {
            addCriterion("confirmuserid is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridEqualTo(String value) {
            addCriterion("confirmuserid =", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridNotEqualTo(String value) {
            addCriterion("confirmuserid <>", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridGreaterThan(String value) {
            addCriterion("confirmuserid >", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridGreaterThanOrEqualTo(String value) {
            addCriterion("confirmuserid >=", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridLessThan(String value) {
            addCriterion("confirmuserid <", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridLessThanOrEqualTo(String value) {
            addCriterion("confirmuserid <=", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridLike(String value) {
            addCriterion("confirmuserid like", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridNotLike(String value) {
            addCriterion("confirmuserid not like", value, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridIn(List<String> values) {
            addCriterion("confirmuserid in", values, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridNotIn(List<String> values) {
            addCriterion("confirmuserid not in", values, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridBetween(String value1, String value2) {
            addCriterion("confirmuserid between", value1, value2, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmuseridNotBetween(String value1, String value2) {
            addCriterion("confirmuserid not between", value1, value2, "confirmuserid");
            return (Criteria) this;
        }

        public Criteria andConfirmamountIsNull() {
            addCriterion("confirmamount is null");
            return (Criteria) this;
        }

        public Criteria andConfirmamountIsNotNull() {
            addCriterion("confirmamount is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmamountEqualTo(BigDecimal value) {
            addCriterion("confirmamount =", value, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountNotEqualTo(BigDecimal value) {
            addCriterion("confirmamount <>", value, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountGreaterThan(BigDecimal value) {
            addCriterion("confirmamount >", value, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("confirmamount >=", value, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountLessThan(BigDecimal value) {
            addCriterion("confirmamount <", value, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("confirmamount <=", value, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountIn(List<BigDecimal> values) {
            addCriterion("confirmamount in", values, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountNotIn(List<BigDecimal> values) {
            addCriterion("confirmamount not in", values, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("confirmamount between", value1, value2, "confirmamount");
            return (Criteria) this;
        }

        public Criteria andConfirmamountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("confirmamount not between", value1, value2, "confirmamount");
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