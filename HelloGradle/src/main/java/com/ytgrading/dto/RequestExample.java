package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequestExample() {
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

        public Criteria andRequestcodeEqualTo(Integer value) {
            addCriterion("requestcode =", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotEqualTo(Integer value) {
            addCriterion("requestcode <>", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeGreaterThan(Integer value) {
            addCriterion("requestcode >", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("requestcode >=", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLessThan(Integer value) {
            addCriterion("requestcode <", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeLessThanOrEqualTo(Integer value) {
            addCriterion("requestcode <=", value, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeIn(List<Integer> values) {
            addCriterion("requestcode in", values, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotIn(List<Integer> values) {
            addCriterion("requestcode not in", values, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeBetween(Integer value1, Integer value2) {
            addCriterion("requestcode between", value1, value2, "requestcode");
            return (Criteria) this;
        }

        public Criteria andRequestcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("requestcode not between", value1, value2, "requestcode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeIsNull() {
            addCriterion("packagecode is null");
            return (Criteria) this;
        }

        public Criteria andPackagecodeIsNotNull() {
            addCriterion("packagecode is not null");
            return (Criteria) this;
        }

        public Criteria andPackagecodeEqualTo(String value) {
            addCriterion("packagecode =", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeNotEqualTo(String value) {
            addCriterion("packagecode <>", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeGreaterThan(String value) {
            addCriterion("packagecode >", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeGreaterThanOrEqualTo(String value) {
            addCriterion("packagecode >=", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeLessThan(String value) {
            addCriterion("packagecode <", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeLessThanOrEqualTo(String value) {
            addCriterion("packagecode <=", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeLike(String value) {
            addCriterion("packagecode like", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeNotLike(String value) {
            addCriterion("packagecode not like", value, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeIn(List<String> values) {
            addCriterion("packagecode in", values, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeNotIn(List<String> values) {
            addCriterion("packagecode not in", values, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeBetween(String value1, String value2) {
            addCriterion("packagecode between", value1, value2, "packagecode");
            return (Criteria) this;
        }

        public Criteria andPackagecodeNotBetween(String value1, String value2) {
            addCriterion("packagecode not between", value1, value2, "packagecode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNull() {
            addCriterion("usercode is null");
            return (Criteria) this;
        }

        public Criteria andUsercodeIsNotNull() {
            addCriterion("usercode is not null");
            return (Criteria) this;
        }

        public Criteria andUsercodeEqualTo(Integer value) {
            addCriterion("usercode =", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotEqualTo(Integer value) {
            addCriterion("usercode <>", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThan(Integer value) {
            addCriterion("usercode >", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("usercode >=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThan(Integer value) {
            addCriterion("usercode <", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeLessThanOrEqualTo(Integer value) {
            addCriterion("usercode <=", value, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeIn(List<Integer> values) {
            addCriterion("usercode in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotIn(List<Integer> values) {
            addCriterion("usercode not in", values, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeBetween(Integer value1, Integer value2) {
            addCriterion("usercode between", value1, value2, "usercode");
            return (Criteria) this;
        }

        public Criteria andUsercodeNotBetween(Integer value1, Integer value2) {
            addCriterion("usercode not between", value1, value2, "usercode");
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

        public Criteria andBoxcodeIsNull() {
            addCriterion("boxcode is null");
            return (Criteria) this;
        }

        public Criteria andBoxcodeIsNotNull() {
            addCriterion("boxcode is not null");
            return (Criteria) this;
        }

        public Criteria andBoxcodeEqualTo(String value) {
            addCriterion("boxcode =", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeNotEqualTo(String value) {
            addCriterion("boxcode <>", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeGreaterThan(String value) {
            addCriterion("boxcode >", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeGreaterThanOrEqualTo(String value) {
            addCriterion("boxcode >=", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeLessThan(String value) {
            addCriterion("boxcode <", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeLessThanOrEqualTo(String value) {
            addCriterion("boxcode <=", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeLike(String value) {
            addCriterion("boxcode like", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeNotLike(String value) {
            addCriterion("boxcode not like", value, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeIn(List<String> values) {
            addCriterion("boxcode in", values, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeNotIn(List<String> values) {
            addCriterion("boxcode not in", values, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeBetween(String value1, String value2) {
            addCriterion("boxcode between", value1, value2, "boxcode");
            return (Criteria) this;
        }

        public Criteria andBoxcodeNotBetween(String value1, String value2) {
            addCriterion("boxcode not between", value1, value2, "boxcode");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNull() {
            addCriterion("customer is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIsNotNull() {
            addCriterion("customer is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerEqualTo(String value) {
            addCriterion("customer =", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotEqualTo(String value) {
            addCriterion("customer <>", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThan(String value) {
            addCriterion("customer >", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("customer >=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThan(String value) {
            addCriterion("customer <", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLessThanOrEqualTo(String value) {
            addCriterion("customer <=", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerLike(String value) {
            addCriterion("customer like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotLike(String value) {
            addCriterion("customer not like", value, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerIn(List<String> values) {
            addCriterion("customer in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotIn(List<String> values) {
            addCriterion("customer not in", values, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerBetween(String value1, String value2) {
            addCriterion("customer between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andCustomerNotBetween(String value1, String value2) {
            addCriterion("customer not between", value1, value2, "customer");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNull() {
            addCriterion("serviceid is null");
            return (Criteria) this;
        }

        public Criteria andServiceidIsNotNull() {
            addCriterion("serviceid is not null");
            return (Criteria) this;
        }

        public Criteria andServiceidEqualTo(String value) {
            addCriterion("serviceid =", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotEqualTo(String value) {
            addCriterion("serviceid <>", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThan(String value) {
            addCriterion("serviceid >", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidGreaterThanOrEqualTo(String value) {
            addCriterion("serviceid >=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThan(String value) {
            addCriterion("serviceid <", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLessThanOrEqualTo(String value) {
            addCriterion("serviceid <=", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidLike(String value) {
            addCriterion("serviceid like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotLike(String value) {
            addCriterion("serviceid not like", value, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidIn(List<String> values) {
            addCriterion("serviceid in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotIn(List<String> values) {
            addCriterion("serviceid not in", values, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidBetween(String value1, String value2) {
            addCriterion("serviceid between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andServiceidNotBetween(String value1, String value2) {
            addCriterion("serviceid not between", value1, value2, "serviceid");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNull() {
            addCriterion("speed is null");
            return (Criteria) this;
        }

        public Criteria andSpeedIsNotNull() {
            addCriterion("speed is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedEqualTo(String value) {
            addCriterion("speed =", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotEqualTo(String value) {
            addCriterion("speed <>", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThan(String value) {
            addCriterion("speed >", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedGreaterThanOrEqualTo(String value) {
            addCriterion("speed >=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThan(String value) {
            addCriterion("speed <", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLessThanOrEqualTo(String value) {
            addCriterion("speed <=", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedLike(String value) {
            addCriterion("speed like", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotLike(String value) {
            addCriterion("speed not like", value, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedIn(List<String> values) {
            addCriterion("speed in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotIn(List<String> values) {
            addCriterion("speed not in", values, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedBetween(String value1, String value2) {
            addCriterion("speed between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedNotBetween(String value1, String value2) {
            addCriterion("speed not between", value1, value2, "speed");
            return (Criteria) this;
        }

        public Criteria andSpeedextIsNull() {
            addCriterion("speedext is null");
            return (Criteria) this;
        }

        public Criteria andSpeedextIsNotNull() {
            addCriterion("speedext is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedextEqualTo(Integer value) {
            addCriterion("speedext =", value, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextNotEqualTo(Integer value) {
            addCriterion("speedext <>", value, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextGreaterThan(Integer value) {
            addCriterion("speedext >", value, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextGreaterThanOrEqualTo(Integer value) {
            addCriterion("speedext >=", value, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextLessThan(Integer value) {
            addCriterion("speedext <", value, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextLessThanOrEqualTo(Integer value) {
            addCriterion("speedext <=", value, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextIn(List<Integer> values) {
            addCriterion("speedext in", values, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextNotIn(List<Integer> values) {
            addCriterion("speedext not in", values, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextBetween(Integer value1, Integer value2) {
            addCriterion("speedext between", value1, value2, "speedext");
            return (Criteria) this;
        }

        public Criteria andSpeedextNotBetween(Integer value1, Integer value2) {
            addCriterion("speedext not between", value1, value2, "speedext");
            return (Criteria) this;
        }

        public Criteria andWapperIsNull() {
            addCriterion("wapper is null");
            return (Criteria) this;
        }

        public Criteria andWapperIsNotNull() {
            addCriterion("wapper is not null");
            return (Criteria) this;
        }

        public Criteria andWapperEqualTo(String value) {
            addCriterion("wapper =", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperNotEqualTo(String value) {
            addCriterion("wapper <>", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperGreaterThan(String value) {
            addCriterion("wapper >", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperGreaterThanOrEqualTo(String value) {
            addCriterion("wapper >=", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperLessThan(String value) {
            addCriterion("wapper <", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperLessThanOrEqualTo(String value) {
            addCriterion("wapper <=", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperLike(String value) {
            addCriterion("wapper like", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperNotLike(String value) {
            addCriterion("wapper not like", value, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperIn(List<String> values) {
            addCriterion("wapper in", values, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperNotIn(List<String> values) {
            addCriterion("wapper not in", values, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperBetween(String value1, String value2) {
            addCriterion("wapper between", value1, value2, "wapper");
            return (Criteria) this;
        }

        public Criteria andWapperNotBetween(String value1, String value2) {
            addCriterion("wapper not between", value1, value2, "wapper");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNull() {
            addCriterion("sendtype is null");
            return (Criteria) this;
        }

        public Criteria andSendtypeIsNotNull() {
            addCriterion("sendtype is not null");
            return (Criteria) this;
        }

        public Criteria andSendtypeEqualTo(String value) {
            addCriterion("sendtype =", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotEqualTo(String value) {
            addCriterion("sendtype <>", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThan(String value) {
            addCriterion("sendtype >", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeGreaterThanOrEqualTo(String value) {
            addCriterion("sendtype >=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThan(String value) {
            addCriterion("sendtype <", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLessThanOrEqualTo(String value) {
            addCriterion("sendtype <=", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeLike(String value) {
            addCriterion("sendtype like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotLike(String value) {
            addCriterion("sendtype not like", value, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeIn(List<String> values) {
            addCriterion("sendtype in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotIn(List<String> values) {
            addCriterion("sendtype not in", values, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeBetween(String value1, String value2) {
            addCriterion("sendtype between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendtypeNotBetween(String value1, String value2) {
            addCriterion("sendtype not between", value1, value2, "sendtype");
            return (Criteria) this;
        }

        public Criteria andSendmethodIsNull() {
            addCriterion("sendmethod is null");
            return (Criteria) this;
        }

        public Criteria andSendmethodIsNotNull() {
            addCriterion("sendmethod is not null");
            return (Criteria) this;
        }

        public Criteria andSendmethodEqualTo(String value) {
            addCriterion("sendmethod =", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodNotEqualTo(String value) {
            addCriterion("sendmethod <>", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodGreaterThan(String value) {
            addCriterion("sendmethod >", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodGreaterThanOrEqualTo(String value) {
            addCriterion("sendmethod >=", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodLessThan(String value) {
            addCriterion("sendmethod <", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodLessThanOrEqualTo(String value) {
            addCriterion("sendmethod <=", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodLike(String value) {
            addCriterion("sendmethod like", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodNotLike(String value) {
            addCriterion("sendmethod not like", value, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodIn(List<String> values) {
            addCriterion("sendmethod in", values, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodNotIn(List<String> values) {
            addCriterion("sendmethod not in", values, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodBetween(String value1, String value2) {
            addCriterion("sendmethod between", value1, value2, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andSendmethodNotBetween(String value1, String value2) {
            addCriterion("sendmethod not between", value1, value2, "sendmethod");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceivertelIsNull() {
            addCriterion("receivertel is null");
            return (Criteria) this;
        }

        public Criteria andReceivertelIsNotNull() {
            addCriterion("receivertel is not null");
            return (Criteria) this;
        }

        public Criteria andReceivertelEqualTo(String value) {
            addCriterion("receivertel =", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelNotEqualTo(String value) {
            addCriterion("receivertel <>", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelGreaterThan(String value) {
            addCriterion("receivertel >", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelGreaterThanOrEqualTo(String value) {
            addCriterion("receivertel >=", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelLessThan(String value) {
            addCriterion("receivertel <", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelLessThanOrEqualTo(String value) {
            addCriterion("receivertel <=", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelLike(String value) {
            addCriterion("receivertel like", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelNotLike(String value) {
            addCriterion("receivertel not like", value, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelIn(List<String> values) {
            addCriterion("receivertel in", values, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelNotIn(List<String> values) {
            addCriterion("receivertel not in", values, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelBetween(String value1, String value2) {
            addCriterion("receivertel between", value1, value2, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivertelNotBetween(String value1, String value2) {
            addCriterion("receivertel not between", value1, value2, "receivertel");
            return (Criteria) this;
        }

        public Criteria andReceivermobileIsNull() {
            addCriterion("receivermobile is null");
            return (Criteria) this;
        }

        public Criteria andReceivermobileIsNotNull() {
            addCriterion("receivermobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceivermobileEqualTo(String value) {
            addCriterion("receivermobile =", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotEqualTo(String value) {
            addCriterion("receivermobile <>", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileGreaterThan(String value) {
            addCriterion("receivermobile >", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileGreaterThanOrEqualTo(String value) {
            addCriterion("receivermobile >=", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileLessThan(String value) {
            addCriterion("receivermobile <", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileLessThanOrEqualTo(String value) {
            addCriterion("receivermobile <=", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileLike(String value) {
            addCriterion("receivermobile like", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotLike(String value) {
            addCriterion("receivermobile not like", value, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileIn(List<String> values) {
            addCriterion("receivermobile in", values, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotIn(List<String> values) {
            addCriterion("receivermobile not in", values, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileBetween(String value1, String value2) {
            addCriterion("receivermobile between", value1, value2, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermobileNotBetween(String value1, String value2) {
            addCriterion("receivermobile not between", value1, value2, "receivermobile");
            return (Criteria) this;
        }

        public Criteria andReceivermailIsNull() {
            addCriterion("receivermail is null");
            return (Criteria) this;
        }

        public Criteria andReceivermailIsNotNull() {
            addCriterion("receivermail is not null");
            return (Criteria) this;
        }

        public Criteria andReceivermailEqualTo(String value) {
            addCriterion("receivermail =", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailNotEqualTo(String value) {
            addCriterion("receivermail <>", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailGreaterThan(String value) {
            addCriterion("receivermail >", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailGreaterThanOrEqualTo(String value) {
            addCriterion("receivermail >=", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailLessThan(String value) {
            addCriterion("receivermail <", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailLessThanOrEqualTo(String value) {
            addCriterion("receivermail <=", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailLike(String value) {
            addCriterion("receivermail like", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailNotLike(String value) {
            addCriterion("receivermail not like", value, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailIn(List<String> values) {
            addCriterion("receivermail in", values, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailNotIn(List<String> values) {
            addCriterion("receivermail not in", values, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailBetween(String value1, String value2) {
            addCriterion("receivermail between", value1, value2, "receivermail");
            return (Criteria) this;
        }

        public Criteria andReceivermailNotBetween(String value1, String value2) {
            addCriterion("receivermail not between", value1, value2, "receivermail");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(Integer value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(Integer value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(Integer value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(Integer value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(Integer value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(Integer value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<Integer> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<Integer> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(Integer value1, Integer value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(Integer value1, Integer value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(Integer value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(Integer value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(Integer value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(Integer value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<Integer> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<Integer> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Integer value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Integer value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Integer value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Integer value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Integer> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Integer> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Integer value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Integer value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Integer value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Integer value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Integer value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Integer> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Integer> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Integer value1, Integer value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(String value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(String value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(String value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(String value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(String value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLike(String value) {
            addCriterion("payment like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotLike(String value) {
            addCriterion("payment not like", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<String> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<String> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(String value1, String value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(String value1, String value2) {
            addCriterion("payment not between", value1, value2, "payment");
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

        public Criteria andTotalpremiumIsNull() {
            addCriterion("totalpremium is null");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumIsNotNull() {
            addCriterion("totalpremium is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumEqualTo(BigDecimal value) {
            addCriterion("totalpremium =", value, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumNotEqualTo(BigDecimal value) {
            addCriterion("totalpremium <>", value, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumGreaterThan(BigDecimal value) {
            addCriterion("totalpremium >", value, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalpremium >=", value, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumLessThan(BigDecimal value) {
            addCriterion("totalpremium <", value, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalpremium <=", value, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumIn(List<BigDecimal> values) {
            addCriterion("totalpremium in", values, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumNotIn(List<BigDecimal> values) {
            addCriterion("totalpremium not in", values, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalpremium between", value1, value2, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotalpremiumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalpremium not between", value1, value2, "totalpremium");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationIsNull() {
            addCriterion("totaltransportation is null");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationIsNotNull() {
            addCriterion("totaltransportation is not null");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationEqualTo(BigDecimal value) {
            addCriterion("totaltransportation =", value, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationNotEqualTo(BigDecimal value) {
            addCriterion("totaltransportation <>", value, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationGreaterThan(BigDecimal value) {
            addCriterion("totaltransportation >", value, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totaltransportation >=", value, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationLessThan(BigDecimal value) {
            addCriterion("totaltransportation <", value, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totaltransportation <=", value, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationIn(List<BigDecimal> values) {
            addCriterion("totaltransportation in", values, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationNotIn(List<BigDecimal> values) {
            addCriterion("totaltransportation not in", values, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totaltransportation between", value1, value2, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotaltransportationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totaltransportation not between", value1, value2, "totaltransportation");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceIsNull() {
            addCriterion("totalinsurance is null");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceIsNotNull() {
            addCriterion("totalinsurance is not null");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceEqualTo(BigDecimal value) {
            addCriterion("totalinsurance =", value, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceNotEqualTo(BigDecimal value) {
            addCriterion("totalinsurance <>", value, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceGreaterThan(BigDecimal value) {
            addCriterion("totalinsurance >", value, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalinsurance >=", value, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceLessThan(BigDecimal value) {
            addCriterion("totalinsurance <", value, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalinsurance <=", value, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceIn(List<BigDecimal> values) {
            addCriterion("totalinsurance in", values, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceNotIn(List<BigDecimal> values) {
            addCriterion("totalinsurance not in", values, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalinsurance between", value1, value2, "totalinsurance");
            return (Criteria) this;
        }

        public Criteria andTotalinsuranceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalinsurance not between", value1, value2, "totalinsurance");
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

        public Criteria andTotalcostIsNull() {
            addCriterion("totalcost is null");
            return (Criteria) this;
        }

        public Criteria andTotalcostIsNotNull() {
            addCriterion("totalcost is not null");
            return (Criteria) this;
        }

        public Criteria andTotalcostEqualTo(BigDecimal value) {
            addCriterion("totalcost =", value, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostNotEqualTo(BigDecimal value) {
            addCriterion("totalcost <>", value, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostGreaterThan(BigDecimal value) {
            addCriterion("totalcost >", value, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalcost >=", value, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostLessThan(BigDecimal value) {
            addCriterion("totalcost <", value, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalcost <=", value, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostIn(List<BigDecimal> values) {
            addCriterion("totalcost in", values, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostNotIn(List<BigDecimal> values) {
            addCriterion("totalcost not in", values, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalcost between", value1, value2, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalcostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalcost not between", value1, value2, "totalcost");
            return (Criteria) this;
        }

        public Criteria andTotalweightIsNull() {
            addCriterion("totalweight is null");
            return (Criteria) this;
        }

        public Criteria andTotalweightIsNotNull() {
            addCriterion("totalweight is not null");
            return (Criteria) this;
        }

        public Criteria andTotalweightEqualTo(BigDecimal value) {
            addCriterion("totalweight =", value, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightNotEqualTo(BigDecimal value) {
            addCriterion("totalweight <>", value, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightGreaterThan(BigDecimal value) {
            addCriterion("totalweight >", value, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalweight >=", value, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightLessThan(BigDecimal value) {
            addCriterion("totalweight <", value, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalweight <=", value, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightIn(List<BigDecimal> values) {
            addCriterion("totalweight in", values, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightNotIn(List<BigDecimal> values) {
            addCriterion("totalweight not in", values, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalweight between", value1, value2, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalweightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalweight not between", value1, value2, "totalweight");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNull() {
            addCriterion("totalamount is null");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNotNull() {
            addCriterion("totalamount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalamountEqualTo(Integer value) {
            addCriterion("totalamount =", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotEqualTo(Integer value) {
            addCriterion("totalamount <>", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThan(Integer value) {
            addCriterion("totalamount >", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("totalamount >=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThan(Integer value) {
            addCriterion("totalamount <", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThanOrEqualTo(Integer value) {
            addCriterion("totalamount <=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountIn(List<Integer> values) {
            addCriterion("totalamount in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotIn(List<Integer> values) {
            addCriterion("totalamount not in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountBetween(Integer value1, Integer value2) {
            addCriterion("totalamount between", value1, value2, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotBetween(Integer value1, Integer value2) {
            addCriterion("totalamount not between", value1, value2, "totalamount");
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

        public Criteria andZipIsNull() {
            addCriterion("zip is null");
            return (Criteria) this;
        }

        public Criteria andZipIsNotNull() {
            addCriterion("zip is not null");
            return (Criteria) this;
        }

        public Criteria andZipEqualTo(String value) {
            addCriterion("zip =", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotEqualTo(String value) {
            addCriterion("zip <>", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThan(String value) {
            addCriterion("zip >", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThanOrEqualTo(String value) {
            addCriterion("zip >=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThan(String value) {
            addCriterion("zip <", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThanOrEqualTo(String value) {
            addCriterion("zip <=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLike(String value) {
            addCriterion("zip like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotLike(String value) {
            addCriterion("zip not like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipIn(List<String> values) {
            addCriterion("zip in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotIn(List<String> values) {
            addCriterion("zip not in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipBetween(String value1, String value2) {
            addCriterion("zip between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotBetween(String value1, String value2) {
            addCriterion("zip not between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNull() {
            addCriterion("requesttime is null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIsNotNull() {
            addCriterion("requesttime is not null");
            return (Criteria) this;
        }

        public Criteria andRequesttimeEqualTo(Date value) {
            addCriterion("requesttime =", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotEqualTo(Date value) {
            addCriterion("requesttime <>", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThan(Date value) {
            addCriterion("requesttime >", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("requesttime >=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThan(Date value) {
            addCriterion("requesttime <", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeLessThanOrEqualTo(Date value) {
            addCriterion("requesttime <=", value, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeIn(List<Date> values) {
            addCriterion("requesttime in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotIn(List<Date> values) {
            addCriterion("requesttime not in", values, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeBetween(Date value1, Date value2) {
            addCriterion("requesttime between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequesttimeNotBetween(Date value1, Date value2) {
            addCriterion("requesttime not between", value1, value2, "requesttime");
            return (Criteria) this;
        }

        public Criteria andRequeststatusIsNull() {
            addCriterion("requeststatus is null");
            return (Criteria) this;
        }

        public Criteria andRequeststatusIsNotNull() {
            addCriterion("requeststatus is not null");
            return (Criteria) this;
        }

        public Criteria andRequeststatusEqualTo(String value) {
            addCriterion("requeststatus =", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusNotEqualTo(String value) {
            addCriterion("requeststatus <>", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusGreaterThan(String value) {
            addCriterion("requeststatus >", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusGreaterThanOrEqualTo(String value) {
            addCriterion("requeststatus >=", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusLessThan(String value) {
            addCriterion("requeststatus <", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusLessThanOrEqualTo(String value) {
            addCriterion("requeststatus <=", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusLike(String value) {
            addCriterion("requeststatus like", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusNotLike(String value) {
            addCriterion("requeststatus not like", value, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusIn(List<String> values) {
            addCriterion("requeststatus in", values, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusNotIn(List<String> values) {
            addCriterion("requeststatus not in", values, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusBetween(String value1, String value2) {
            addCriterion("requeststatus between", value1, value2, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andRequeststatusNotBetween(String value1, String value2) {
            addCriterion("requeststatus not between", value1, value2, "requeststatus");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
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

        public Criteria andInternalstatesIsNull() {
            addCriterion("internalstates is null");
            return (Criteria) this;
        }

        public Criteria andInternalstatesIsNotNull() {
            addCriterion("internalstates is not null");
            return (Criteria) this;
        }

        public Criteria andInternalstatesEqualTo(String value) {
            addCriterion("internalstates =", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesNotEqualTo(String value) {
            addCriterion("internalstates <>", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesGreaterThan(String value) {
            addCriterion("internalstates >", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesGreaterThanOrEqualTo(String value) {
            addCriterion("internalstates >=", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesLessThan(String value) {
            addCriterion("internalstates <", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesLessThanOrEqualTo(String value) {
            addCriterion("internalstates <=", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesLike(String value) {
            addCriterion("internalstates like", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesNotLike(String value) {
            addCriterion("internalstates not like", value, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesIn(List<String> values) {
            addCriterion("internalstates in", values, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesNotIn(List<String> values) {
            addCriterion("internalstates not in", values, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesBetween(String value1, String value2) {
            addCriterion("internalstates between", value1, value2, "internalstates");
            return (Criteria) this;
        }

        public Criteria andInternalstatesNotBetween(String value1, String value2) {
            addCriterion("internalstates not between", value1, value2, "internalstates");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNull() {
            addCriterion("imgpath is null");
            return (Criteria) this;
        }

        public Criteria andImgpathIsNotNull() {
            addCriterion("imgpath is not null");
            return (Criteria) this;
        }

        public Criteria andImgpathEqualTo(String value) {
            addCriterion("imgpath =", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotEqualTo(String value) {
            addCriterion("imgpath <>", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThan(String value) {
            addCriterion("imgpath >", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathGreaterThanOrEqualTo(String value) {
            addCriterion("imgpath >=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThan(String value) {
            addCriterion("imgpath <", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLessThanOrEqualTo(String value) {
            addCriterion("imgpath <=", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathLike(String value) {
            addCriterion("imgpath like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotLike(String value) {
            addCriterion("imgpath not like", value, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathIn(List<String> values) {
            addCriterion("imgpath in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotIn(List<String> values) {
            addCriterion("imgpath not in", values, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathBetween(String value1, String value2) {
            addCriterion("imgpath between", value1, value2, "imgpath");
            return (Criteria) this;
        }

        public Criteria andImgpathNotBetween(String value1, String value2) {
            addCriterion("imgpath not between", value1, value2, "imgpath");
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

        public Criteria andDeliverynoIsNull() {
            addCriterion("deliveryno is null");
            return (Criteria) this;
        }

        public Criteria andDeliverynoIsNotNull() {
            addCriterion("deliveryno is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverynoEqualTo(String value) {
            addCriterion("deliveryno =", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotEqualTo(String value) {
            addCriterion("deliveryno <>", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoGreaterThan(String value) {
            addCriterion("deliveryno >", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryno >=", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoLessThan(String value) {
            addCriterion("deliveryno <", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoLessThanOrEqualTo(String value) {
            addCriterion("deliveryno <=", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoLike(String value) {
            addCriterion("deliveryno like", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotLike(String value) {
            addCriterion("deliveryno not like", value, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoIn(List<String> values) {
            addCriterion("deliveryno in", values, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotIn(List<String> values) {
            addCriterion("deliveryno not in", values, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoBetween(String value1, String value2) {
            addCriterion("deliveryno between", value1, value2, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andDeliverynoNotBetween(String value1, String value2) {
            addCriterion("deliveryno not between", value1, value2, "deliveryno");
            return (Criteria) this;
        }

        public Criteria andPaystatusIsNull() {
            addCriterion("paystatus is null");
            return (Criteria) this;
        }

        public Criteria andPaystatusIsNotNull() {
            addCriterion("paystatus is not null");
            return (Criteria) this;
        }

        public Criteria andPaystatusEqualTo(String value) {
            addCriterion("paystatus =", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotEqualTo(String value) {
            addCriterion("paystatus <>", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThan(String value) {
            addCriterion("paystatus >", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusGreaterThanOrEqualTo(String value) {
            addCriterion("paystatus >=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThan(String value) {
            addCriterion("paystatus <", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLessThanOrEqualTo(String value) {
            addCriterion("paystatus <=", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusLike(String value) {
            addCriterion("paystatus like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotLike(String value) {
            addCriterion("paystatus not like", value, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusIn(List<String> values) {
            addCriterion("paystatus in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotIn(List<String> values) {
            addCriterion("paystatus not in", values, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusBetween(String value1, String value2) {
            addCriterion("paystatus between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andPaystatusNotBetween(String value1, String value2) {
            addCriterion("paystatus not between", value1, value2, "paystatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusIsNull() {
            addCriterion("confirmstatus is null");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusIsNotNull() {
            addCriterion("confirmstatus is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusEqualTo(String value) {
            addCriterion("confirmstatus =", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusNotEqualTo(String value) {
            addCriterion("confirmstatus <>", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusGreaterThan(String value) {
            addCriterion("confirmstatus >", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusGreaterThanOrEqualTo(String value) {
            addCriterion("confirmstatus >=", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusLessThan(String value) {
            addCriterion("confirmstatus <", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusLessThanOrEqualTo(String value) {
            addCriterion("confirmstatus <=", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusLike(String value) {
            addCriterion("confirmstatus like", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusNotLike(String value) {
            addCriterion("confirmstatus not like", value, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusIn(List<String> values) {
            addCriterion("confirmstatus in", values, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusNotIn(List<String> values) {
            addCriterion("confirmstatus not in", values, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusBetween(String value1, String value2) {
            addCriterion("confirmstatus between", value1, value2, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andConfirmstatusNotBetween(String value1, String value2) {
            addCriterion("confirmstatus not between", value1, value2, "confirmstatus");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNull() {
            addCriterion("notice is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIsNotNull() {
            addCriterion("notice is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEqualTo(String value) {
            addCriterion("notice =", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotEqualTo(String value) {
            addCriterion("notice <>", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThan(String value) {
            addCriterion("notice >", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeGreaterThanOrEqualTo(String value) {
            addCriterion("notice >=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThan(String value) {
            addCriterion("notice <", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLessThanOrEqualTo(String value) {
            addCriterion("notice <=", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeLike(String value) {
            addCriterion("notice like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotLike(String value) {
            addCriterion("notice not like", value, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeIn(List<String> values) {
            addCriterion("notice in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotIn(List<String> values) {
            addCriterion("notice not in", values, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeBetween(String value1, String value2) {
            addCriterion("notice between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andNoticeNotBetween(String value1, String value2) {
            addCriterion("notice not between", value1, value2, "notice");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNull() {
            addCriterion("applytime is null");
            return (Criteria) this;
        }

        public Criteria andApplytimeIsNotNull() {
            addCriterion("applytime is not null");
            return (Criteria) this;
        }

        public Criteria andApplytimeEqualTo(Date value) {
            addCriterion("applytime =", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotEqualTo(Date value) {
            addCriterion("applytime <>", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThan(Date value) {
            addCriterion("applytime >", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("applytime >=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThan(Date value) {
            addCriterion("applytime <", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeLessThanOrEqualTo(Date value) {
            addCriterion("applytime <=", value, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeIn(List<Date> values) {
            addCriterion("applytime in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotIn(List<Date> values) {
            addCriterion("applytime not in", values, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeBetween(Date value1, Date value2) {
            addCriterion("applytime between", value1, value2, "applytime");
            return (Criteria) this;
        }

        public Criteria andApplytimeNotBetween(Date value1, Date value2) {
            addCriterion("applytime not between", value1, value2, "applytime");
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