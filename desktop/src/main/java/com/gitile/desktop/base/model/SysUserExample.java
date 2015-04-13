/*
 * 文件名称：SysUserExample.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import com.gitile.core.mybatis.model.BaseExample;

/**
 * 名称：账号信息
 * 模块描述：数据库表对应实体类查询条件
 */
public class SysUserExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
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

		public Criteria andRoleIdIsNull() {
			addCriterion("role_id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("role_id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(String value) {
			addCriterion("role_id =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(String value) {
			addCriterion("role_id <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(String value) {
			addCriterion("role_id >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
			addCriterion("role_id >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(String value) {
			addCriterion("role_id <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(String value) {
			addCriterion("role_id <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<String> values) {
			addCriterion("role_id in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<String> values) {
			addCriterion("role_id not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(String value1, String value2) {
			addCriterion("role_id between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(String value1, String value2) {
			addCriterion("role_id not between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLike(String value) {
			addCriterion("role_id like", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotLike(String value) {
			addCriterion("role_id not like", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andSaltIsNull() {
			addCriterion("salt is null");
			return (Criteria) this;
		}

		public Criteria andSaltIsNotNull() {
			addCriterion("salt is not null");
			return (Criteria) this;
		}

		public Criteria andSaltEqualTo(String value) {
			addCriterion("salt =", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotEqualTo(String value) {
			addCriterion("salt <>", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltGreaterThan(String value) {
			addCriterion("salt >", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltGreaterThanOrEqualTo(String value) {
			addCriterion("salt >=", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltLessThan(String value) {
			addCriterion("salt <", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltLessThanOrEqualTo(String value) {
			addCriterion("salt <=", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltIn(List<String> values) {
			addCriterion("salt in", values, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotIn(List<String> values) {
			addCriterion("salt not in", values, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltBetween(String value1, String value2) {
			addCriterion("salt between", value1, value2, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotBetween(String value1, String value2) {
			addCriterion("salt not between", value1, value2, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltLike(String value) {
			addCriterion("salt like", value, "salt");
			return (Criteria) this;
		}

		public Criteria andSaltNotLike(String value) {
			addCriterion("salt not like", value, "salt");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountIsNull() {
			addCriterion("failure_login_count is null");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountIsNotNull() {
			addCriterion("failure_login_count is not null");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountEqualTo(Integer value) {
			addCriterion("failure_login_count =", value, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountNotEqualTo(Integer value) {
			addCriterion("failure_login_count <>", value, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountGreaterThan(Integer value) {
			addCriterion("failure_login_count >", value, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("failure_login_count >=", value, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountLessThan(Integer value) {
			addCriterion("failure_login_count <", value, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountLessThanOrEqualTo(Integer value) {
			addCriterion("failure_login_count <=", value, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountIn(List<Integer> values) {
			addCriterion("failure_login_count in", values, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountNotIn(List<Integer> values) {
			addCriterion("failure_login_count not in", values, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountBetween(Integer value1, Integer value2) {
			addCriterion("failure_login_count between", value1, value2, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andFailureLoginCountNotBetween(Integer value1, Integer value2) {
			addCriterion("failure_login_count not between", value1, value2, "failureLoginCount");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNull() {
			addCriterion("last_login_time is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNotNull() {
			addCriterion("last_login_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeEqualTo(Date value) {
			addCriterion("last_login_time =", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotEqualTo(Date value) {
			addCriterion("last_login_time <>", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThan(Date value) {
			addCriterion("last_login_time >", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("last_login_time >=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThan(Date value) {
			addCriterion("last_login_time <", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
			addCriterion("last_login_time <=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIn(List<Date> values) {
			addCriterion("last_login_time in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotIn(List<Date> values) {
			addCriterion("last_login_time not in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
			addCriterion("last_login_time between", value1, value2, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
			addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
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

		public Criteria andStatusEqualTo(Short value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(Short value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(Short value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(Short value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(Short value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(Short value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<Short> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<Short> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(Short value1, Short value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(Short value1, Short value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andBackgroundIsNull() {
			addCriterion("background is null");
			return (Criteria) this;
		}

		public Criteria andBackgroundIsNotNull() {
			addCriterion("background is not null");
			return (Criteria) this;
		}

		public Criteria andBackgroundEqualTo(String value) {
			addCriterion("background =", value, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundNotEqualTo(String value) {
			addCriterion("background <>", value, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundGreaterThan(String value) {
			addCriterion("background >", value, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundGreaterThanOrEqualTo(String value) {
			addCriterion("background >=", value, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundLessThan(String value) {
			addCriterion("background <", value, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundLessThanOrEqualTo(String value) {
			addCriterion("background <=", value, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundIn(List<String> values) {
			addCriterion("background in", values, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundNotIn(List<String> values) {
			addCriterion("background not in", values, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundBetween(String value1, String value2) {
			addCriterion("background between", value1, value2, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundNotBetween(String value1, String value2) {
			addCriterion("background not between", value1, value2, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundLike(String value) {
			addCriterion("background like", value, "background");
			return (Criteria) this;
		}

		public Criteria andBackgroundNotLike(String value) {
			addCriterion("background not like", value, "background");
			return (Criteria) this;
		}

		public Criteria andFileSizeIsNull() {
			addCriterion("file_size is null");
			return (Criteria) this;
		}

		public Criteria andFileSizeIsNotNull() {
			addCriterion("file_size is not null");
			return (Criteria) this;
		}

		public Criteria andFileSizeEqualTo(Long value) {
			addCriterion("file_size =", value, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeNotEqualTo(Long value) {
			addCriterion("file_size <>", value, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeGreaterThan(Long value) {
			addCriterion("file_size >", value, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
			addCriterion("file_size >=", value, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeLessThan(Long value) {
			addCriterion("file_size <", value, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeLessThanOrEqualTo(Long value) {
			addCriterion("file_size <=", value, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeIn(List<Long> values) {
			addCriterion("file_size in", values, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeNotIn(List<Long> values) {
			addCriterion("file_size not in", values, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeBetween(Long value1, Long value2) {
			addCriterion("file_size between", value1, value2, "fileSize");
			return (Criteria) this;
		}

		public Criteria andFileSizeNotBetween(Long value1, Long value2) {
			addCriterion("file_size not between", value1, value2, "fileSize");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNull() {
			addCriterion("created_time is null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNotNull() {
			addCriterion("created_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeEqualTo(Date value) {
			addCriterion("created_time =", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotEqualTo(Date value) {
			addCriterion("created_time <>", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThan(Date value) {
			addCriterion("created_time >", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("created_time >=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThan(Date value) {
			addCriterion("created_time <", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
			addCriterion("created_time <=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIn(List<Date> values) {
			addCriterion("created_time in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotIn(List<Date> values) {
			addCriterion("created_time not in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeBetween(Date value1, Date value2) {
			addCriterion("created_time between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
			addCriterion("created_time not between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeIsNull() {
			addCriterion("last_modified_time is null");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeIsNotNull() {
			addCriterion("last_modified_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeEqualTo(Date value) {
			addCriterion("last_modified_time =", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeNotEqualTo(Date value) {
			addCriterion("last_modified_time <>", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeGreaterThan(Date value) {
			addCriterion("last_modified_time >", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("last_modified_time >=", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeLessThan(Date value) {
			addCriterion("last_modified_time <", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeLessThanOrEqualTo(Date value) {
			addCriterion("last_modified_time <=", value, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeIn(List<Date> values) {
			addCriterion("last_modified_time in", values, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeNotIn(List<Date> values) {
			addCriterion("last_modified_time not in", values, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeBetween(Date value1, Date value2) {
			addCriterion("last_modified_time between", value1, value2, "lastModifiedTime");
			return (Criteria) this;
		}

		public Criteria andLastModifiedTimeNotBetween(Date value1, Date value2) {
			addCriterion("last_modified_time not between", value1, value2, "lastModifiedTime");
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