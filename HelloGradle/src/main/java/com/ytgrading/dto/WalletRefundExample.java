package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WalletRefundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WalletRefundExample() {
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

        public Criteria andRefundnoIsNull() {
            addCriterion("refundno is null");
            return (Criteria) this;
        }

        public Criteria andRefundnoIsNotNull() {
            addCriterion("refundno is not null");
            return (Criteria) this;
        }

        public Criteria andRefundnoEqualTo(Integer value) {
            addCriterion("refundno =", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoNotEqualTo(Integer value) {
            addCriterion("refundno <>", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoGreaterThan(Integer value) {
            addCriterion("refundno >", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("refundno >=", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoLessThan(Integer value) {
            addCriterion("refundno <", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoLessThanOrEqualTo(Integer value) {
            addCriterion("refundno <=", value, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoIn(List<Integer> values) {
            addCriterion("refundno in", values, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoNotIn(List<Integer> values) {
            addCriterion("refundno not in", values, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoBetween(Integer value1, Integer value2) {
            addCriterion("refundno between", value1, value2, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefundnoNotBetween(Integer value1, Integer value2) {
            addCriterion("refundno not between", value1, value2, "refundno");
            return (Criteria) this;
        }

        public Criteria andRefunddateIsNull() {
            addCriterion("refunddate is null");
            return (Criteria) this;
        }

        public Criteria andRefunddateIsNotNull() {
            addCriterion("refunddate is not null");
            return (Criteria) this;
        }

        public Criteria andRefunddateEqualTo(Date value) {
            addCriterion("refunddate =", value, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateNotEqualTo(Date value) {
            addCriterion("refunddate <>", value, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateGreaterThan(Date value) {
            addCriterion("refunddate >", value, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateGreaterThanOrEqualTo(Date value) {
            addCriterion("refunddate >=", value, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateLessThan(Date value) {
            addCriterion("refunddate <", value, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateLessThanOrEqualTo(Date value) {
            addCriterion("refunddate <=", value, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateIn(List<Date> values) {
            addCriterion("refunddate in", values, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateNotIn(List<Date> values) {
            addCriterion("refunddate not in", values, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateBetween(Date value1, Date value2) {
            addCriterion("refunddate between", value1, value2, "refunddate");
            return (Criteria) this;
        }

        public Criteria andRefunddateNotBetween(Date value1, Date value2) {
            addCriterion("refunddate not between", value1, value2, "refunddate");
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

        public Criteria andWalletidIsNull() {
            addCriterion("walletid is null");
            return (Criteria) this;
        }

        public Criteria andWalletidIsNotNull() {
            addCriterion("walletid is not null");
            return (Criteria) this;
        }

        public Criteria andWalletidEqualTo(String value) {
            addCriterion("walletid =", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidNotEqualTo(String value) {
            addCriterion("walletid <>", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidGreaterThan(String value) {
            addCriterion("walletid >", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidGreaterThanOrEqualTo(String value) {
            addCriterion("walletid >=", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidLessThan(String value) {
            addCriterion("walletid <", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidLessThanOrEqualTo(String value) {
            addCriterion("walletid <=", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidLike(String value) {
            addCriterion("walletid like", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidNotLike(String value) {
            addCriterion("walletid not like", value, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidIn(List<String> values) {
            addCriterion("walletid in", values, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidNotIn(List<String> values) {
            addCriterion("walletid not in", values, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidBetween(String value1, String value2) {
            addCriterion("walletid between", value1, value2, "walletid");
            return (Criteria) this;
        }

        public Criteria andWalletidNotBetween(String value1, String value2) {
            addCriterion("walletid not between", value1, value2, "walletid");
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

        public Criteria andCapitalidIsNull() {
            addCriterion("capitalid is null");
            return (Criteria) this;
        }

        public Criteria andCapitalidIsNotNull() {
            addCriterion("capitalid is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalidEqualTo(String value) {
            addCriterion("capitalid =", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidNotEqualTo(String value) {
            addCriterion("capitalid <>", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidGreaterThan(String value) {
            addCriterion("capitalid >", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidGreaterThanOrEqualTo(String value) {
            addCriterion("capitalid >=", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidLessThan(String value) {
            addCriterion("capitalid <", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidLessThanOrEqualTo(String value) {
            addCriterion("capitalid <=", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidLike(String value) {
            addCriterion("capitalid like", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidNotLike(String value) {
            addCriterion("capitalid not like", value, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidIn(List<String> values) {
            addCriterion("capitalid in", values, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidNotIn(List<String> values) {
            addCriterion("capitalid not in", values, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidBetween(String value1, String value2) {
            addCriterion("capitalid between", value1, value2, "capitalid");
            return (Criteria) this;
        }

        public Criteria andCapitalidNotBetween(String value1, String value2) {
            addCriterion("capitalid not between", value1, value2, "capitalid");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNull() {
            addCriterion("orderdate is null");
            return (Criteria) this;
        }

        public Criteria andOrderdateIsNotNull() {
            addCriterion("orderdate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderdateEqualTo(Date value) {
            addCriterion("orderdate =", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotEqualTo(Date value) {
            addCriterion("orderdate <>", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThan(Date value) {
            addCriterion("orderdate >", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateGreaterThanOrEqualTo(Date value) {
            addCriterion("orderdate >=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThan(Date value) {
            addCriterion("orderdate <", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateLessThanOrEqualTo(Date value) {
            addCriterion("orderdate <=", value, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateIn(List<Date> values) {
            addCriterion("orderdate in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotIn(List<Date> values) {
            addCriterion("orderdate not in", values, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateBetween(Date value1, Date value2) {
            addCriterion("orderdate between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andOrderdateNotBetween(Date value1, Date value2) {
            addCriterion("orderdate not between", value1, value2, "orderdate");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueIsNull() {
            addCriterion("capitalvalue is null");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueIsNotNull() {
            addCriterion("capitalvalue is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueEqualTo(String value) {
            addCriterion("capitalvalue =", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueNotEqualTo(String value) {
            addCriterion("capitalvalue <>", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueGreaterThan(String value) {
            addCriterion("capitalvalue >", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueGreaterThanOrEqualTo(String value) {
            addCriterion("capitalvalue >=", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueLessThan(String value) {
            addCriterion("capitalvalue <", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueLessThanOrEqualTo(String value) {
            addCriterion("capitalvalue <=", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueLike(String value) {
            addCriterion("capitalvalue like", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueNotLike(String value) {
            addCriterion("capitalvalue not like", value, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueIn(List<String> values) {
            addCriterion("capitalvalue in", values, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueNotIn(List<String> values) {
            addCriterion("capitalvalue not in", values, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueBetween(String value1, String value2) {
            addCriterion("capitalvalue between", value1, value2, "capitalvalue");
            return (Criteria) this;
        }

        public Criteria andCapitalvalueNotBetween(String value1, String value2) {
            addCriterion("capitalvalue not between", value1, value2, "capitalvalue");
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