/*
 * 文件名称：SysApplicationRightExample.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.ArrayList;
import java.util.List;
import com.gitile.core.mybatis.model.BaseExample;

/**
 * 名称：应用菜单权限
 * 模块描述：数据库表对应实体类查询条件
 */
public class SysApplicationRightExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    public SysApplicationRightExample() {
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

		public Criteria andParentIdIsNull() {
			addCriterion("parent_id is null");
			return (Criteria) this;
		}

		public Criteria andParentIdIsNotNull() {
			addCriterion("parent_id is not null");
			return (Criteria) this;
		}

		public Criteria andParentIdEqualTo(Long value) {
			addCriterion("parent_id =", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotEqualTo(Long value) {
			addCriterion("parent_id <>", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThan(Long value) {
			addCriterion("parent_id >", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
			addCriterion("parent_id >=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThan(Long value) {
			addCriterion("parent_id <", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdLessThanOrEqualTo(Long value) {
			addCriterion("parent_id <=", value, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdIn(List<Long> values) {
			addCriterion("parent_id in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotIn(List<Long> values) {
			addCriterion("parent_id not in", values, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdBetween(Long value1, Long value2) {
			addCriterion("parent_id between", value1, value2, "parentId");
			return (Criteria) this;
		}

		public Criteria andParentIdNotBetween(Long value1, Long value2) {
			addCriterion("parent_id not between", value1, value2, "parentId");
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

		public Criteria andRightTypeIsNull() {
			addCriterion("right_type is null");
			return (Criteria) this;
		}

		public Criteria andRightTypeIsNotNull() {
			addCriterion("right_type is not null");
			return (Criteria) this;
		}

		public Criteria andRightTypeEqualTo(Short value) {
			addCriterion("right_type =", value, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeNotEqualTo(Short value) {
			addCriterion("right_type <>", value, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeGreaterThan(Short value) {
			addCriterion("right_type >", value, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeGreaterThanOrEqualTo(Short value) {
			addCriterion("right_type >=", value, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeLessThan(Short value) {
			addCriterion("right_type <", value, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeLessThanOrEqualTo(Short value) {
			addCriterion("right_type <=", value, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeIn(List<Short> values) {
			addCriterion("right_type in", values, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeNotIn(List<Short> values) {
			addCriterion("right_type not in", values, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeBetween(Short value1, Short value2) {
			addCriterion("right_type between", value1, value2, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightTypeNotBetween(Short value1, Short value2) {
			addCriterion("right_type not between", value1, value2, "rightType");
			return (Criteria) this;
		}

		public Criteria andRightUrlIsNull() {
			addCriterion("right_url is null");
			return (Criteria) this;
		}

		public Criteria andRightUrlIsNotNull() {
			addCriterion("right_url is not null");
			return (Criteria) this;
		}

		public Criteria andRightUrlEqualTo(String value) {
			addCriterion("right_url =", value, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlNotEqualTo(String value) {
			addCriterion("right_url <>", value, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlGreaterThan(String value) {
			addCriterion("right_url >", value, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlGreaterThanOrEqualTo(String value) {
			addCriterion("right_url >=", value, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlLessThan(String value) {
			addCriterion("right_url <", value, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlLessThanOrEqualTo(String value) {
			addCriterion("right_url <=", value, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlIn(List<String> values) {
			addCriterion("right_url in", values, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlNotIn(List<String> values) {
			addCriterion("right_url not in", values, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlBetween(String value1, String value2) {
			addCriterion("right_url between", value1, value2, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlNotBetween(String value1, String value2) {
			addCriterion("right_url not between", value1, value2, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlLike(String value) {
			addCriterion("right_url like", value, "rightUrl");
			return (Criteria) this;
		}

		public Criteria andRightUrlNotLike(String value) {
			addCriterion("right_url not like", value, "rightUrl");
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