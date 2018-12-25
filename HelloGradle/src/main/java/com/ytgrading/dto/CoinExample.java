package com.ytgrading.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoinExample() {
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

        public Criteria andYearsIsNull() {
            addCriterion("years is null");
            return (Criteria) this;
        }

        public Criteria andYearsIsNotNull() {
            addCriterion("years is not null");
            return (Criteria) this;
        }

        public Criteria andYearsEqualTo(String value) {
            addCriterion("years =", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotEqualTo(String value) {
            addCriterion("years <>", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThan(String value) {
            addCriterion("years >", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsGreaterThanOrEqualTo(String value) {
            addCriterion("years >=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThan(String value) {
            addCriterion("years <", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLessThanOrEqualTo(String value) {
            addCriterion("years <=", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsLike(String value) {
            addCriterion("years like", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotLike(String value) {
            addCriterion("years not like", value, "years");
            return (Criteria) this;
        }

        public Criteria andYearsIn(List<String> values) {
            addCriterion("years in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotIn(List<String> values) {
            addCriterion("years not in", values, "years");
            return (Criteria) this;
        }

        public Criteria andYearsBetween(String value1, String value2) {
            addCriterion("years between", value1, value2, "years");
            return (Criteria) this;
        }

        public Criteria andYearsNotBetween(String value1, String value2) {
            addCriterion("years not between", value1, value2, "years");
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

        public Criteria andUnitofmeasurementIsNull() {
            addCriterion("unitofmeasurement is null");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementIsNotNull() {
            addCriterion("unitofmeasurement is not null");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementEqualTo(Integer value) {
            addCriterion("unitofmeasurement =", value, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementNotEqualTo(Integer value) {
            addCriterion("unitofmeasurement <>", value, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementGreaterThan(Integer value) {
            addCriterion("unitofmeasurement >", value, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementGreaterThanOrEqualTo(Integer value) {
            addCriterion("unitofmeasurement >=", value, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementLessThan(Integer value) {
            addCriterion("unitofmeasurement <", value, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementLessThanOrEqualTo(Integer value) {
            addCriterion("unitofmeasurement <=", value, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementIn(List<Integer> values) {
            addCriterion("unitofmeasurement in", values, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementNotIn(List<Integer> values) {
            addCriterion("unitofmeasurement not in", values, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementBetween(Integer value1, Integer value2) {
            addCriterion("unitofmeasurement between", value1, value2, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andUnitofmeasurementNotBetween(Integer value1, Integer value2) {
            addCriterion("unitofmeasurement not between", value1, value2, "unitofmeasurement");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(Integer value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(Integer value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(Integer value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(Integer value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(Integer value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(Integer value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<Integer> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<Integer> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(Integer value1, Integer value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(Integer value1, Integer value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andFacevalueIsNull() {
            addCriterion("facevalue is null");
            return (Criteria) this;
        }

        public Criteria andFacevalueIsNotNull() {
            addCriterion("facevalue is not null");
            return (Criteria) this;
        }

        public Criteria andFacevalueEqualTo(BigDecimal value) {
            addCriterion("facevalue =", value, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueNotEqualTo(BigDecimal value) {
            addCriterion("facevalue <>", value, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueGreaterThan(BigDecimal value) {
            addCriterion("facevalue >", value, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("facevalue >=", value, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueLessThan(BigDecimal value) {
            addCriterion("facevalue <", value, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueLessThanOrEqualTo(BigDecimal value) {
            addCriterion("facevalue <=", value, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueIn(List<BigDecimal> values) {
            addCriterion("facevalue in", values, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueNotIn(List<BigDecimal> values) {
            addCriterion("facevalue not in", values, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("facevalue between", value1, value2, "facevalue");
            return (Criteria) this;
        }

        public Criteria andFacevalueNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("facevalue not between", value1, value2, "facevalue");
            return (Criteria) this;
        }

        public Criteria andCatalogueIsNull() {
            addCriterion("catalogue is null");
            return (Criteria) this;
        }

        public Criteria andCatalogueIsNotNull() {
            addCriterion("catalogue is not null");
            return (Criteria) this;
        }

        public Criteria andCatalogueEqualTo(String value) {
            addCriterion("catalogue =", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueNotEqualTo(String value) {
            addCriterion("catalogue <>", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueGreaterThan(String value) {
            addCriterion("catalogue >", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueGreaterThanOrEqualTo(String value) {
            addCriterion("catalogue >=", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueLessThan(String value) {
            addCriterion("catalogue <", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueLessThanOrEqualTo(String value) {
            addCriterion("catalogue <=", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueLike(String value) {
            addCriterion("catalogue like", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueNotLike(String value) {
            addCriterion("catalogue not like", value, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueIn(List<String> values) {
            addCriterion("catalogue in", values, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueNotIn(List<String> values) {
            addCriterion("catalogue not in", values, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueBetween(String value1, String value2) {
            addCriterion("catalogue between", value1, value2, "catalogue");
            return (Criteria) this;
        }

        public Criteria andCatalogueNotBetween(String value1, String value2) {
            addCriterion("catalogue not between", value1, value2, "catalogue");
            return (Criteria) this;
        }

        public Criteria andIssuecodeIsNull() {
            addCriterion("issuecode is null");
            return (Criteria) this;
        }

        public Criteria andIssuecodeIsNotNull() {
            addCriterion("issuecode is not null");
            return (Criteria) this;
        }

        public Criteria andIssuecodeEqualTo(Integer value) {
            addCriterion("issuecode =", value, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeNotEqualTo(Integer value) {
            addCriterion("issuecode <>", value, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeGreaterThan(Integer value) {
            addCriterion("issuecode >", value, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("issuecode >=", value, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeLessThan(Integer value) {
            addCriterion("issuecode <", value, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeLessThanOrEqualTo(Integer value) {
            addCriterion("issuecode <=", value, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeIn(List<Integer> values) {
            addCriterion("issuecode in", values, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeNotIn(List<Integer> values) {
            addCriterion("issuecode not in", values, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeBetween(Integer value1, Integer value2) {
            addCriterion("issuecode between", value1, value2, "issuecode");
            return (Criteria) this;
        }

        public Criteria andIssuecodeNotBetween(Integer value1, Integer value2) {
            addCriterion("issuecode not between", value1, value2, "issuecode");
            return (Criteria) this;
        }

        public Criteria andAmountofplanIsNull() {
            addCriterion("amountofplan is null");
            return (Criteria) this;
        }

        public Criteria andAmountofplanIsNotNull() {
            addCriterion("amountofplan is not null");
            return (Criteria) this;
        }

        public Criteria andAmountofplanEqualTo(Integer value) {
            addCriterion("amountofplan =", value, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanNotEqualTo(Integer value) {
            addCriterion("amountofplan <>", value, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanGreaterThan(Integer value) {
            addCriterion("amountofplan >", value, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanGreaterThanOrEqualTo(Integer value) {
            addCriterion("amountofplan >=", value, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanLessThan(Integer value) {
            addCriterion("amountofplan <", value, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanLessThanOrEqualTo(Integer value) {
            addCriterion("amountofplan <=", value, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanIn(List<Integer> values) {
            addCriterion("amountofplan in", values, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanNotIn(List<Integer> values) {
            addCriterion("amountofplan not in", values, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanBetween(Integer value1, Integer value2) {
            addCriterion("amountofplan between", value1, value2, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofplanNotBetween(Integer value1, Integer value2) {
            addCriterion("amountofplan not between", value1, value2, "amountofplan");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingIsNull() {
            addCriterion("amountofcasting is null");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingIsNotNull() {
            addCriterion("amountofcasting is not null");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingEqualTo(Integer value) {
            addCriterion("amountofcasting =", value, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingNotEqualTo(Integer value) {
            addCriterion("amountofcasting <>", value, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingGreaterThan(Integer value) {
            addCriterion("amountofcasting >", value, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingGreaterThanOrEqualTo(Integer value) {
            addCriterion("amountofcasting >=", value, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingLessThan(Integer value) {
            addCriterion("amountofcasting <", value, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingLessThanOrEqualTo(Integer value) {
            addCriterion("amountofcasting <=", value, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingIn(List<Integer> values) {
            addCriterion("amountofcasting in", values, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingNotIn(List<Integer> values) {
            addCriterion("amountofcasting not in", values, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingBetween(Integer value1, Integer value2) {
            addCriterion("amountofcasting between", value1, value2, "amountofcasting");
            return (Criteria) this;
        }

        public Criteria andAmountofcastingNotBetween(Integer value1, Integer value2) {
            addCriterion("amountofcasting not between", value1, value2, "amountofcasting");
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

        public Criteria andPublisherIsNull() {
            addCriterion("publisher is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIsNotNull() {
            addCriterion("publisher is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherEqualTo(Integer value) {
            addCriterion("publisher =", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotEqualTo(Integer value) {
            addCriterion("publisher <>", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThan(Integer value) {
            addCriterion("publisher >", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisher >=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThan(Integer value) {
            addCriterion("publisher <", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherLessThanOrEqualTo(Integer value) {
            addCriterion("publisher <=", value, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherIn(List<Integer> values) {
            addCriterion("publisher in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotIn(List<Integer> values) {
            addCriterion("publisher not in", values, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherBetween(Integer value1, Integer value2) {
            addCriterion("publisher between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andPublisherNotBetween(Integer value1, Integer value2) {
            addCriterion("publisher not between", value1, value2, "publisher");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(Integer value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(Integer value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(Integer value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(Integer value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(Integer value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(Integer value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<Integer> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<Integer> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(Integer value1, Integer value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(Integer value1, Integer value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNull() {
            addCriterion("issuedate is null");
            return (Criteria) this;
        }

        public Criteria andIssuedateIsNotNull() {
            addCriterion("issuedate is not null");
            return (Criteria) this;
        }

        public Criteria andIssuedateEqualTo(Date value) {
            addCriterion("issuedate =", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotEqualTo(Date value) {
            addCriterion("issuedate <>", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThan(Date value) {
            addCriterion("issuedate >", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateGreaterThanOrEqualTo(Date value) {
            addCriterion("issuedate >=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThan(Date value) {
            addCriterion("issuedate <", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateLessThanOrEqualTo(Date value) {
            addCriterion("issuedate <=", value, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateIn(List<Date> values) {
            addCriterion("issuedate in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotIn(List<Date> values) {
            addCriterion("issuedate not in", values, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateBetween(Date value1, Date value2) {
            addCriterion("issuedate between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssuedateNotBetween(Date value1, Date value2) {
            addCriterion("issuedate not between", value1, value2, "issuedate");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeIsNull() {
            addCriterion("issueendtime is null");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeIsNotNull() {
            addCriterion("issueendtime is not null");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeEqualTo(Date value) {
            addCriterion("issueendtime =", value, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeNotEqualTo(Date value) {
            addCriterion("issueendtime <>", value, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeGreaterThan(Date value) {
            addCriterion("issueendtime >", value, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("issueendtime >=", value, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeLessThan(Date value) {
            addCriterion("issueendtime <", value, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeLessThanOrEqualTo(Date value) {
            addCriterion("issueendtime <=", value, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeIn(List<Date> values) {
            addCriterion("issueendtime in", values, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeNotIn(List<Date> values) {
            addCriterion("issueendtime not in", values, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeBetween(Date value1, Date value2) {
            addCriterion("issueendtime between", value1, value2, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andIssueendtimeNotBetween(Date value1, Date value2) {
            addCriterion("issueendtime not between", value1, value2, "issueendtime");
            return (Criteria) this;
        }

        public Criteria andShapecodeIsNull() {
            addCriterion("shapecode is null");
            return (Criteria) this;
        }

        public Criteria andShapecodeIsNotNull() {
            addCriterion("shapecode is not null");
            return (Criteria) this;
        }

        public Criteria andShapecodeEqualTo(Integer value) {
            addCriterion("shapecode =", value, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeNotEqualTo(Integer value) {
            addCriterion("shapecode <>", value, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeGreaterThan(Integer value) {
            addCriterion("shapecode >", value, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shapecode >=", value, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeLessThan(Integer value) {
            addCriterion("shapecode <", value, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeLessThanOrEqualTo(Integer value) {
            addCriterion("shapecode <=", value, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeIn(List<Integer> values) {
            addCriterion("shapecode in", values, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeNotIn(List<Integer> values) {
            addCriterion("shapecode not in", values, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeBetween(Integer value1, Integer value2) {
            addCriterion("shapecode between", value1, value2, "shapecode");
            return (Criteria) this;
        }

        public Criteria andShapecodeNotBetween(Integer value1, Integer value2) {
            addCriterion("shapecode not between", value1, value2, "shapecode");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Integer value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Integer value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Integer value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Integer value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Integer value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Integer> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Integer> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Integer value1, Integer value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Integer value1, Integer value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andMqualityIsNull() {
            addCriterion("mquality is null");
            return (Criteria) this;
        }

        public Criteria andMqualityIsNotNull() {
            addCriterion("mquality is not null");
            return (Criteria) this;
        }

        public Criteria andMqualityEqualTo(Integer value) {
            addCriterion("mquality =", value, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityNotEqualTo(Integer value) {
            addCriterion("mquality <>", value, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityGreaterThan(Integer value) {
            addCriterion("mquality >", value, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityGreaterThanOrEqualTo(Integer value) {
            addCriterion("mquality >=", value, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityLessThan(Integer value) {
            addCriterion("mquality <", value, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityLessThanOrEqualTo(Integer value) {
            addCriterion("mquality <=", value, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityIn(List<Integer> values) {
            addCriterion("mquality in", values, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityNotIn(List<Integer> values) {
            addCriterion("mquality not in", values, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityBetween(Integer value1, Integer value2) {
            addCriterion("mquality between", value1, value2, "mquality");
            return (Criteria) this;
        }

        public Criteria andMqualityNotBetween(Integer value1, Integer value2) {
            addCriterion("mquality not between", value1, value2, "mquality");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectIsNull() {
            addCriterion("artisticeffect is null");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectIsNotNull() {
            addCriterion("artisticeffect is not null");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectEqualTo(Integer value) {
            addCriterion("artisticeffect =", value, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectNotEqualTo(Integer value) {
            addCriterion("artisticeffect <>", value, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectGreaterThan(Integer value) {
            addCriterion("artisticeffect >", value, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectGreaterThanOrEqualTo(Integer value) {
            addCriterion("artisticeffect >=", value, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectLessThan(Integer value) {
            addCriterion("artisticeffect <", value, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectLessThanOrEqualTo(Integer value) {
            addCriterion("artisticeffect <=", value, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectIn(List<Integer> values) {
            addCriterion("artisticeffect in", values, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectNotIn(List<Integer> values) {
            addCriterion("artisticeffect not in", values, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectBetween(Integer value1, Integer value2) {
            addCriterion("artisticeffect between", value1, value2, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andArtisticeffectNotBetween(Integer value1, Integer value2) {
            addCriterion("artisticeffect not between", value1, value2, "artisticeffect");
            return (Criteria) this;
        }

        public Criteria andMprocessIsNull() {
            addCriterion("mprocess is null");
            return (Criteria) this;
        }

        public Criteria andMprocessIsNotNull() {
            addCriterion("mprocess is not null");
            return (Criteria) this;
        }

        public Criteria andMprocessEqualTo(Integer value) {
            addCriterion("mprocess =", value, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessNotEqualTo(Integer value) {
            addCriterion("mprocess <>", value, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessGreaterThan(Integer value) {
            addCriterion("mprocess >", value, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessGreaterThanOrEqualTo(Integer value) {
            addCriterion("mprocess >=", value, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessLessThan(Integer value) {
            addCriterion("mprocess <", value, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessLessThanOrEqualTo(Integer value) {
            addCriterion("mprocess <=", value, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessIn(List<Integer> values) {
            addCriterion("mprocess in", values, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessNotIn(List<Integer> values) {
            addCriterion("mprocess not in", values, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessBetween(Integer value1, Integer value2) {
            addCriterion("mprocess between", value1, value2, "mprocess");
            return (Criteria) this;
        }

        public Criteria andMprocessNotBetween(Integer value1, Integer value2) {
            addCriterion("mprocess not between", value1, value2, "mprocess");
            return (Criteria) this;
        }

        public Criteria andToothingIsNull() {
            addCriterion("toothing is null");
            return (Criteria) this;
        }

        public Criteria andToothingIsNotNull() {
            addCriterion("toothing is not null");
            return (Criteria) this;
        }

        public Criteria andToothingEqualTo(Integer value) {
            addCriterion("toothing =", value, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingNotEqualTo(Integer value) {
            addCriterion("toothing <>", value, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingGreaterThan(Integer value) {
            addCriterion("toothing >", value, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingGreaterThanOrEqualTo(Integer value) {
            addCriterion("toothing >=", value, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingLessThan(Integer value) {
            addCriterion("toothing <", value, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingLessThanOrEqualTo(Integer value) {
            addCriterion("toothing <=", value, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingIn(List<Integer> values) {
            addCriterion("toothing in", values, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingNotIn(List<Integer> values) {
            addCriterion("toothing not in", values, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingBetween(Integer value1, Integer value2) {
            addCriterion("toothing between", value1, value2, "toothing");
            return (Criteria) this;
        }

        public Criteria andToothingNotBetween(Integer value1, Integer value2) {
            addCriterion("toothing not between", value1, value2, "toothing");
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