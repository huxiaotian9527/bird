package com.hu.boot.bird.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AwsAsinRankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AwsAsinRankExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAsinIsNull() {
            addCriterion("asin is null");
            return (Criteria) this;
        }

        public Criteria andAsinIsNotNull() {
            addCriterion("asin is not null");
            return (Criteria) this;
        }

        public Criteria andAsinEqualTo(String value) {
            addCriterion("asin =", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotEqualTo(String value) {
            addCriterion("asin <>", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThan(String value) {
            addCriterion("asin >", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinGreaterThanOrEqualTo(String value) {
            addCriterion("asin >=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThan(String value) {
            addCriterion("asin <", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLessThanOrEqualTo(String value) {
            addCriterion("asin <=", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinLike(String value) {
            addCriterion("asin like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotLike(String value) {
            addCriterion("asin not like", value, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinIn(List<String> values) {
            addCriterion("asin in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotIn(List<String> values) {
            addCriterion("asin not in", values, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinBetween(String value1, String value2) {
            addCriterion("asin between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andAsinNotBetween(String value1, String value2) {
            addCriterion("asin not between", value1, value2, "asin");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNull() {
            addCriterion("rank_name is null");
            return (Criteria) this;
        }

        public Criteria andRankNameIsNotNull() {
            addCriterion("rank_name is not null");
            return (Criteria) this;
        }

        public Criteria andRankNameEqualTo(String value) {
            addCriterion("rank_name =", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotEqualTo(String value) {
            addCriterion("rank_name <>", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThan(String value) {
            addCriterion("rank_name >", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameGreaterThanOrEqualTo(String value) {
            addCriterion("rank_name >=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThan(String value) {
            addCriterion("rank_name <", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLessThanOrEqualTo(String value) {
            addCriterion("rank_name <=", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameLike(String value) {
            addCriterion("rank_name like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotLike(String value) {
            addCriterion("rank_name not like", value, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameIn(List<String> values) {
            addCriterion("rank_name in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotIn(List<String> values) {
            addCriterion("rank_name not in", values, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameBetween(String value1, String value2) {
            addCriterion("rank_name between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankNameNotBetween(String value1, String value2) {
            addCriterion("rank_name not between", value1, value2, "rankName");
            return (Criteria) this;
        }

        public Criteria andRankScoreIsNull() {
            addCriterion("rank_score is null");
            return (Criteria) this;
        }

        public Criteria andRankScoreIsNotNull() {
            addCriterion("rank_score is not null");
            return (Criteria) this;
        }

        public Criteria andRankScoreEqualTo(String value) {
            addCriterion("rank_score =", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreNotEqualTo(String value) {
            addCriterion("rank_score <>", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreGreaterThan(String value) {
            addCriterion("rank_score >", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreGreaterThanOrEqualTo(String value) {
            addCriterion("rank_score >=", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreLessThan(String value) {
            addCriterion("rank_score <", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreLessThanOrEqualTo(String value) {
            addCriterion("rank_score <=", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreLike(String value) {
            addCriterion("rank_score like", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreNotLike(String value) {
            addCriterion("rank_score not like", value, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreIn(List<String> values) {
            addCriterion("rank_score in", values, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreNotIn(List<String> values) {
            addCriterion("rank_score not in", values, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreBetween(String value1, String value2) {
            addCriterion("rank_score between", value1, value2, "rankScore");
            return (Criteria) this;
        }

        public Criteria andRankScoreNotBetween(String value1, String value2) {
            addCriterion("rank_score not between", value1, value2, "rankScore");
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

        public Criteria andTypeEqualTo(Boolean value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Boolean value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Boolean value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Boolean value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Boolean> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Boolean> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andGrabDayIsNull() {
            addCriterion("grab_day is null");
            return (Criteria) this;
        }

        public Criteria andGrabDayIsNotNull() {
            addCriterion("grab_day is not null");
            return (Criteria) this;
        }

        public Criteria andGrabDayEqualTo(Date value) {
            addCriterionForJDBCDate("grab_day =", value, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("grab_day <>", value, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayGreaterThan(Date value) {
            addCriterionForJDBCDate("grab_day >", value, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("grab_day >=", value, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayLessThan(Date value) {
            addCriterionForJDBCDate("grab_day <", value, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("grab_day <=", value, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayIn(List<Date> values) {
            addCriterionForJDBCDate("grab_day in", values, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("grab_day not in", values, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("grab_day between", value1, value2, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("grab_day not between", value1, value2, "grabDay");
            return (Criteria) this;
        }

        public Criteria andGrabHourIsNull() {
            addCriterion("grab_hour is null");
            return (Criteria) this;
        }

        public Criteria andGrabHourIsNotNull() {
            addCriterion("grab_hour is not null");
            return (Criteria) this;
        }

        public Criteria andGrabHourEqualTo(Byte value) {
            addCriterion("grab_hour =", value, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourNotEqualTo(Byte value) {
            addCriterion("grab_hour <>", value, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourGreaterThan(Byte value) {
            addCriterion("grab_hour >", value, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourGreaterThanOrEqualTo(Byte value) {
            addCriterion("grab_hour >=", value, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourLessThan(Byte value) {
            addCriterion("grab_hour <", value, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourLessThanOrEqualTo(Byte value) {
            addCriterion("grab_hour <=", value, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourIn(List<Byte> values) {
            addCriterion("grab_hour in", values, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourNotIn(List<Byte> values) {
            addCriterion("grab_hour not in", values, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourBetween(Byte value1, Byte value2) {
            addCriterion("grab_hour between", value1, value2, "grabHour");
            return (Criteria) this;
        }

        public Criteria andGrabHourNotBetween(Byte value1, Byte value2) {
            addCriterion("grab_hour not between", value1, value2, "grabHour");
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