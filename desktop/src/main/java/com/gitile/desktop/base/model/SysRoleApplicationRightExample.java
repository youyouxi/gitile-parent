/*
 * 文件名称：SysRoleApplicationRightExample.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.ArrayList;
import java.util.List;
import com.gitile.core.mybatis.model.BaseExample;

/**
 * 名称：角色可访问权限
 * 模块描述：数据库表对应实体类查询条件
 */
public class SysRoleApplicationRightExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    public SysRoleApplicationRightExample() {
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

		public Criteria andAppIdIsNull() {
			addCriterion("app_id is null");
			return (Criteria) this;
		}

		public Criteria andAppIdIsNotNull() {
			addCriterion("app_id is not null");
			return (Criteria) this;
		}

		public Criteria andAppIdEqualTo(Long value) {
			addCriterion("app_id =", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdNotEqualTo(Long value) {
			addCriterion("app_id <>", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdGreaterThan(Long value) {
			addCriterion("app_id >", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdGreaterThanOrEqualTo(Long value) {
			addCriterion("app_id >=", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdLessThan(Long value) {
			addCriterion("app_id <", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdLessThanOrEqualTo(Long value) {
			addCriterion("app_id <=", value, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdIn(List<Long> values) {
			addCriterion("app_id in", values, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdNotIn(List<Long> values) {
			addCriterion("app_id not in", values, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdBetween(Long value1, Long value2) {
			addCriterion("app_id between", value1, value2, "appId");
			return (Criteria) this;
		}

		public Criteria andAppIdNotBetween(Long value1, Long value2) {
			addCriterion("app_id not between", value1, value2, "appId");
			return (Criteria) this;
		}

		public Criteria andRightIdIsNull() {
			addCriterion("right_id is null");
			return (Criteria) this;
		}

		public Criteria andRightIdIsNotNull() {
			addCriterion("right_id is not null");
			return (Criteria) this;
		}

		public Criteria andRightIdEqualTo(Long value) {
			addCriterion("right_id =", value, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdNotEqualTo(Long value) {
			addCriterion("right_id <>", value, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdGreaterThan(Long value) {
			addCriterion("right_id >", value, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdGreaterThanOrEqualTo(Long value) {
			addCriterion("right_id >=", value, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdLessThan(Long value) {
			addCriterion("right_id <", value, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdLessThanOrEqualTo(Long value) {
			addCriterion("right_id <=", value, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdIn(List<Long> values) {
			addCriterion("right_id in", values, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdNotIn(List<Long> values) {
			addCriterion("right_id not in", values, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdBetween(Long value1, Long value2) {
			addCriterion("right_id between", value1, value2, "rightId");
			return (Criteria) this;
		}

		public Criteria andRightIdNotBetween(Long value1, Long value2) {
			addCriterion("right_id not between", value1, value2, "rightId");
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