/*
 * 文件名称：SysUserProfileExample.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.gitile.core.mybatis.model.BaseExample;

/**
 * 名称：账号扩展信息
 * 模块描述：数据库表对应实体类查询条件
 */
public class SysUserProfileExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    public SysUserProfileExample() {
        oredCriteria = new ArrayList<Criteria>();
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
    	super.clear();
        oredCriteria.clear();
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

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(Short value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(Short value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(Short value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(Short value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(Short value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(Short value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<Short> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<Short> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(Short value1, Short value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(Short value1, Short value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andDeptIdIsNull() {
			addCriterion("dept_id is null");
			return (Criteria) this;
		}

		public Criteria andDeptIdIsNotNull() {
			addCriterion("dept_id is not null");
			return (Criteria) this;
		}

		public Criteria andDeptIdEqualTo(Long value) {
			addCriterion("dept_id =", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotEqualTo(Long value) {
			addCriterion("dept_id <>", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThan(Long value) {
			addCriterion("dept_id >", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdGreaterThanOrEqualTo(Long value) {
			addCriterion("dept_id >=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThan(Long value) {
			addCriterion("dept_id <", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdLessThanOrEqualTo(Long value) {
			addCriterion("dept_id <=", value, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdIn(List<Long> values) {
			addCriterion("dept_id in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotIn(List<Long> values) {
			addCriterion("dept_id not in", values, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdBetween(Long value1, Long value2) {
			addCriterion("dept_id between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andDeptIdNotBetween(Long value1, Long value2) {
			addCriterion("dept_id not between", value1, value2, "deptId");
			return (Criteria) this;
		}

		public Criteria andPositionIdIsNull() {
			addCriterion("position_id is null");
			return (Criteria) this;
		}

		public Criteria andPositionIdIsNotNull() {
			addCriterion("position_id is not null");
			return (Criteria) this;
		}

		public Criteria andPositionIdEqualTo(Long value) {
			addCriterion("position_id =", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdNotEqualTo(Long value) {
			addCriterion("position_id <>", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdGreaterThan(Long value) {
			addCriterion("position_id >", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdGreaterThanOrEqualTo(Long value) {
			addCriterion("position_id >=", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdLessThan(Long value) {
			addCriterion("position_id <", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdLessThanOrEqualTo(Long value) {
			addCriterion("position_id <=", value, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdIn(List<Long> values) {
			addCriterion("position_id in", values, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdNotIn(List<Long> values) {
			addCriterion("position_id not in", values, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdBetween(Long value1, Long value2) {
			addCriterion("position_id between", value1, value2, "positionId");
			return (Criteria) this;
		}

		public Criteria andPositionIdNotBetween(Long value1, Long value2) {
			addCriterion("position_id not between", value1, value2, "positionId");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNull() {
			addCriterion("id_card is null");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNotNull() {
			addCriterion("id_card is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardEqualTo(String value) {
			addCriterion("id_card =", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotEqualTo(String value) {
			addCriterion("id_card <>", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThan(String value) {
			addCriterion("id_card >", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("id_card >=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThan(String value) {
			addCriterion("id_card <", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThanOrEqualTo(String value) {
			addCriterion("id_card <=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardIn(List<String> values) {
			addCriterion("id_card in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotIn(List<String> values) {
			addCriterion("id_card not in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardBetween(String value1, String value2) {
			addCriterion("id_card between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotBetween(String value1, String value2) {
			addCriterion("id_card not between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLike(String value) {
			addCriterion("id_card like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotLike(String value) {
			addCriterion("id_card not like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitIsNull() {
			addCriterion("head_portrait is null");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitIsNotNull() {
			addCriterion("head_portrait is not null");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitEqualTo(String value) {
			addCriterion("head_portrait =", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitNotEqualTo(String value) {
			addCriterion("head_portrait <>", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitGreaterThan(String value) {
			addCriterion("head_portrait >", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitGreaterThanOrEqualTo(String value) {
			addCriterion("head_portrait >=", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitLessThan(String value) {
			addCriterion("head_portrait <", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitLessThanOrEqualTo(String value) {
			addCriterion("head_portrait <=", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitIn(List<String> values) {
			addCriterion("head_portrait in", values, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitNotIn(List<String> values) {
			addCriterion("head_portrait not in", values, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitBetween(String value1, String value2) {
			addCriterion("head_portrait between", value1, value2, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitNotBetween(String value1, String value2) {
			addCriterion("head_portrait not between", value1, value2, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitLike(String value) {
			addCriterion("head_portrait like", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andHeadPortraitNotLike(String value) {
			addCriterion("head_portrait not like", value, "headPortrait");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIsNull() {
			addCriterion("native_place is null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIsNotNull() {
			addCriterion("native_place is not null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceEqualTo(String value) {
			addCriterion("native_place =", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotEqualTo(String value) {
			addCriterion("native_place <>", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThan(String value) {
			addCriterion("native_place >", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
			addCriterion("native_place >=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThan(String value) {
			addCriterion("native_place <", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThanOrEqualTo(String value) {
			addCriterion("native_place <=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIn(List<String> values) {
			addCriterion("native_place in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotIn(List<String> values) {
			addCriterion("native_place not in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceBetween(String value1, String value2) {
			addCriterion("native_place between", value1, value2, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotBetween(String value1, String value2) {
			addCriterion("native_place not between", value1, value2, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLike(String value) {
			addCriterion("native_place like", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotLike(String value) {
			addCriterion("native_place not like", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNationIsNull() {
			addCriterion("nation is null");
			return (Criteria) this;
		}

		public Criteria andNationIsNotNull() {
			addCriterion("nation is not null");
			return (Criteria) this;
		}

		public Criteria andNationEqualTo(String value) {
			addCriterion("nation =", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotEqualTo(String value) {
			addCriterion("nation <>", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThan(String value) {
			addCriterion("nation >", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThanOrEqualTo(String value) {
			addCriterion("nation >=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThan(String value) {
			addCriterion("nation <", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThanOrEqualTo(String value) {
			addCriterion("nation <=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationIn(List<String> values) {
			addCriterion("nation in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotIn(List<String> values) {
			addCriterion("nation not in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationBetween(String value1, String value2) {
			addCriterion("nation between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotBetween(String value1, String value2) {
			addCriterion("nation not between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLike(String value) {
			addCriterion("nation like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotLike(String value) {
			addCriterion("nation not like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNull() {
			addCriterion("birthday is null");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNotNull() {
			addCriterion("birthday is not null");
			return (Criteria) this;
		}

		public Criteria andBirthdayEqualTo(Date value) {
			addCriterion("birthday =", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotEqualTo(Date value) {
			addCriterion("birthday <>", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThan(Date value) {
			addCriterion("birthday >", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
			addCriterion("birthday >=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThan(Date value) {
			addCriterion("birthday <", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThanOrEqualTo(Date value) {
			addCriterion("birthday <=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayIn(List<Date> values) {
			addCriterion("birthday in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotIn(List<Date> values) {
			addCriterion("birthday not in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayBetween(Date value1, Date value2) {
			addCriterion("birthday between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotBetween(Date value1, Date value2) {
			addCriterion("birthday not between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeIsNull() {
			addCriterion("birthday_type is null");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeIsNotNull() {
			addCriterion("birthday_type is not null");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeEqualTo(Short value) {
			addCriterion("birthday_type =", value, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeNotEqualTo(Short value) {
			addCriterion("birthday_type <>", value, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeGreaterThan(Short value) {
			addCriterion("birthday_type >", value, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeGreaterThanOrEqualTo(Short value) {
			addCriterion("birthday_type >=", value, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeLessThan(Short value) {
			addCriterion("birthday_type <", value, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeLessThanOrEqualTo(Short value) {
			addCriterion("birthday_type <=", value, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeIn(List<Short> values) {
			addCriterion("birthday_type in", values, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeNotIn(List<Short> values) {
			addCriterion("birthday_type not in", values, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeBetween(Short value1, Short value2) {
			addCriterion("birthday_type between", value1, value2, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andBirthdayTypeNotBetween(Short value1, Short value2) {
			addCriterion("birthday_type not between", value1, value2, "birthdayType");
			return (Criteria) this;
		}

		public Criteria andWorkTimeIsNull() {
			addCriterion("work_time is null");
			return (Criteria) this;
		}

		public Criteria andWorkTimeIsNotNull() {
			addCriterion("work_time is not null");
			return (Criteria) this;
		}

		public Criteria andWorkTimeEqualTo(Date value) {
			addCriterion("work_time =", value, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeNotEqualTo(Date value) {
			addCriterion("work_time <>", value, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeGreaterThan(Date value) {
			addCriterion("work_time >", value, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("work_time >=", value, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeLessThan(Date value) {
			addCriterion("work_time <", value, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeLessThanOrEqualTo(Date value) {
			addCriterion("work_time <=", value, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeIn(List<Date> values) {
			addCriterion("work_time in", values, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeNotIn(List<Date> values) {
			addCriterion("work_time not in", values, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeBetween(Date value1, Date value2) {
			addCriterion("work_time between", value1, value2, "workTime");
			return (Criteria) this;
		}

		public Criteria andWorkTimeNotBetween(Date value1, Date value2) {
			addCriterion("work_time not between", value1, value2, "workTime");
			return (Criteria) this;
		}

		public Criteria andEducationIsNull() {
			addCriterion("education is null");
			return (Criteria) this;
		}

		public Criteria andEducationIsNotNull() {
			addCriterion("education is not null");
			return (Criteria) this;
		}

		public Criteria andEducationEqualTo(String value) {
			addCriterion("education =", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotEqualTo(String value) {
			addCriterion("education <>", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationGreaterThan(String value) {
			addCriterion("education >", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationGreaterThanOrEqualTo(String value) {
			addCriterion("education >=", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationLessThan(String value) {
			addCriterion("education <", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationLessThanOrEqualTo(String value) {
			addCriterion("education <=", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationIn(List<String> values) {
			addCriterion("education in", values, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotIn(List<String> values) {
			addCriterion("education not in", values, "education");
			return (Criteria) this;
		}

		public Criteria andEducationBetween(String value1, String value2) {
			addCriterion("education between", value1, value2, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotBetween(String value1, String value2) {
			addCriterion("education not between", value1, value2, "education");
			return (Criteria) this;
		}

		public Criteria andEducationLike(String value) {
			addCriterion("education like", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotLike(String value) {
			addCriterion("education not like", value, "education");
			return (Criteria) this;
		}

		public Criteria andEntryTimeIsNull() {
			addCriterion("entry_time is null");
			return (Criteria) this;
		}

		public Criteria andEntryTimeIsNotNull() {
			addCriterion("entry_time is not null");
			return (Criteria) this;
		}

		public Criteria andEntryTimeEqualTo(Date value) {
			addCriterion("entry_time =", value, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeNotEqualTo(Date value) {
			addCriterion("entry_time <>", value, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeGreaterThan(Date value) {
			addCriterion("entry_time >", value, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("entry_time >=", value, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeLessThan(Date value) {
			addCriterion("entry_time <", value, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeLessThanOrEqualTo(Date value) {
			addCriterion("entry_time <=", value, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeIn(List<Date> values) {
			addCriterion("entry_time in", values, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeNotIn(List<Date> values) {
			addCriterion("entry_time not in", values, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeBetween(Date value1, Date value2) {
			addCriterion("entry_time between", value1, value2, "entryTime");
			return (Criteria) this;
		}

		public Criteria andEntryTimeNotBetween(Date value1, Date value2) {
			addCriterion("entry_time not between", value1, value2, "entryTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeIsNull() {
			addCriterion("quit_time is null");
			return (Criteria) this;
		}

		public Criteria andQuitTimeIsNotNull() {
			addCriterion("quit_time is not null");
			return (Criteria) this;
		}

		public Criteria andQuitTimeEqualTo(Date value) {
			addCriterion("quit_time =", value, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeNotEqualTo(Date value) {
			addCriterion("quit_time <>", value, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeGreaterThan(Date value) {
			addCriterion("quit_time >", value, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("quit_time >=", value, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeLessThan(Date value) {
			addCriterion("quit_time <", value, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeLessThanOrEqualTo(Date value) {
			addCriterion("quit_time <=", value, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeIn(List<Date> values) {
			addCriterion("quit_time in", values, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeNotIn(List<Date> values) {
			addCriterion("quit_time not in", values, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeBetween(Date value1, Date value2) {
			addCriterion("quit_time between", value1, value2, "quitTime");
			return (Criteria) this;
		}

		public Criteria andQuitTimeNotBetween(Date value1, Date value2) {
			addCriterion("quit_time not between", value1, value2, "quitTime");
			return (Criteria) this;
		}

		public Criteria andPropertysIsNull() {
			addCriterion("propertys is null");
			return (Criteria) this;
		}

		public Criteria andPropertysIsNotNull() {
			addCriterion("propertys is not null");
			return (Criteria) this;
		}

		public Criteria andPropertysEqualTo(String value) {
			addCriterion("propertys =", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysNotEqualTo(String value) {
			addCriterion("propertys <>", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysGreaterThan(String value) {
			addCriterion("propertys >", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysGreaterThanOrEqualTo(String value) {
			addCriterion("propertys >=", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysLessThan(String value) {
			addCriterion("propertys <", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysLessThanOrEqualTo(String value) {
			addCriterion("propertys <=", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysIn(List<String> values) {
			addCriterion("propertys in", values, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysNotIn(List<String> values) {
			addCriterion("propertys not in", values, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysBetween(String value1, String value2) {
			addCriterion("propertys between", value1, value2, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysNotBetween(String value1, String value2) {
			addCriterion("propertys not between", value1, value2, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysLike(String value) {
			addCriterion("propertys like", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andPropertysNotLike(String value) {
			addCriterion("propertys not like", value, "propertys");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationIsNull() {
			addCriterion("self_evaluation is null");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationIsNotNull() {
			addCriterion("self_evaluation is not null");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationEqualTo(String value) {
			addCriterion("self_evaluation =", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationNotEqualTo(String value) {
			addCriterion("self_evaluation <>", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationGreaterThan(String value) {
			addCriterion("self_evaluation >", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationGreaterThanOrEqualTo(String value) {
			addCriterion("self_evaluation >=", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationLessThan(String value) {
			addCriterion("self_evaluation <", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationLessThanOrEqualTo(String value) {
			addCriterion("self_evaluation <=", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationIn(List<String> values) {
			addCriterion("self_evaluation in", values, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationNotIn(List<String> values) {
			addCriterion("self_evaluation not in", values, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationBetween(String value1, String value2) {
			addCriterion("self_evaluation between", value1, value2, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationNotBetween(String value1, String value2) {
			addCriterion("self_evaluation not between", value1, value2, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationLike(String value) {
			addCriterion("self_evaluation like", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andSelfEvaluationNotLike(String value) {
			addCriterion("self_evaluation not like", value, "selfEvaluation");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceIsNull() {
			addCriterion("education_experience is null");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceIsNotNull() {
			addCriterion("education_experience is not null");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceEqualTo(String value) {
			addCriterion("education_experience =", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceNotEqualTo(String value) {
			addCriterion("education_experience <>", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceGreaterThan(String value) {
			addCriterion("education_experience >", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceGreaterThanOrEqualTo(String value) {
			addCriterion("education_experience >=", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceLessThan(String value) {
			addCriterion("education_experience <", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceLessThanOrEqualTo(String value) {
			addCriterion("education_experience <=", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceIn(List<String> values) {
			addCriterion("education_experience in", values, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceNotIn(List<String> values) {
			addCriterion("education_experience not in", values, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceBetween(String value1, String value2) {
			addCriterion("education_experience between", value1, value2, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceNotBetween(String value1, String value2) {
			addCriterion("education_experience not between", value1, value2, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceLike(String value) {
			addCriterion("education_experience like", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andEducationExperienceNotLike(String value) {
			addCriterion("education_experience not like", value, "educationExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceIsNull() {
			addCriterion("work_experience is null");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceIsNotNull() {
			addCriterion("work_experience is not null");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceEqualTo(String value) {
			addCriterion("work_experience =", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceNotEqualTo(String value) {
			addCriterion("work_experience <>", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceGreaterThan(String value) {
			addCriterion("work_experience >", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceGreaterThanOrEqualTo(String value) {
			addCriterion("work_experience >=", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceLessThan(String value) {
			addCriterion("work_experience <", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceLessThanOrEqualTo(String value) {
			addCriterion("work_experience <=", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceIn(List<String> values) {
			addCriterion("work_experience in", values, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceNotIn(List<String> values) {
			addCriterion("work_experience not in", values, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceBetween(String value1, String value2) {
			addCriterion("work_experience between", value1, value2, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceNotBetween(String value1, String value2) {
			addCriterion("work_experience not between", value1, value2, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceLike(String value) {
			addCriterion("work_experience like", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andWorkExperienceNotLike(String value) {
			addCriterion("work_experience not like", value, "workExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceIsNull() {
			addCriterion("training_experience is null");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceIsNotNull() {
			addCriterion("training_experience is not null");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceEqualTo(String value) {
			addCriterion("training_experience =", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceNotEqualTo(String value) {
			addCriterion("training_experience <>", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceGreaterThan(String value) {
			addCriterion("training_experience >", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceGreaterThanOrEqualTo(String value) {
			addCriterion("training_experience >=", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceLessThan(String value) {
			addCriterion("training_experience <", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceLessThanOrEqualTo(String value) {
			addCriterion("training_experience <=", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceIn(List<String> values) {
			addCriterion("training_experience in", values, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceNotIn(List<String> values) {
			addCriterion("training_experience not in", values, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceBetween(String value1, String value2) {
			addCriterion("training_experience between", value1, value2, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceNotBetween(String value1, String value2) {
			addCriterion("training_experience not between", value1, value2, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceLike(String value) {
			addCriterion("training_experience like", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andTrainingExperienceNotLike(String value) {
			addCriterion("training_experience not like", value, "trainingExperience");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysIsNull() {
			addCriterion("extend_propertys is null");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysIsNotNull() {
			addCriterion("extend_propertys is not null");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysEqualTo(String value) {
			addCriterion("extend_propertys =", value, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysNotEqualTo(String value) {
			addCriterion("extend_propertys <>", value, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysGreaterThan(String value) {
			addCriterion("extend_propertys >", value, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysGreaterThanOrEqualTo(String value) {
			addCriterion("extend_propertys >=", value, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysLessThan(String value) {
			addCriterion("extend_propertys <", value, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysLessThanOrEqualTo(String value) {
			addCriterion("extend_propertys <=", value, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysIn(List<String> values) {
			addCriterion("extend_propertys in", values, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysNotIn(List<String> values) {
			addCriterion("extend_propertys not in", values, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysBetween(String value1, String value2) {
			addCriterion("extend_propertys between", value1, value2, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysNotBetween(String value1, String value2) {
			addCriterion("extend_propertys not between", value1, value2, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysLike(String value) {
			addCriterion("extend_propertys like", value, "extendPropertys");
			return (Criteria) this;
		}

		public Criteria andExtendPropertysNotLike(String value) {
			addCriterion("extend_propertys not like", value, "extendPropertys");
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