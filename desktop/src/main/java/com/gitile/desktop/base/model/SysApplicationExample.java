/*
 * 文件名称：SysApplicationExample.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.ArrayList;
import java.util.List;
import com.gitile.core.mybatis.model.BaseExample;

/**
 * 名称：应用信息
 * 模块描述：数据库表对应实体类查询条件
 */
public class SysApplicationExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    public SysApplicationExample() {
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

		public Criteria andIconIsNull() {
			addCriterion("icon is null");
			return (Criteria) this;
		}

		public Criteria andIconIsNotNull() {
			addCriterion("icon is not null");
			return (Criteria) this;
		}

		public Criteria andIconEqualTo(String value) {
			addCriterion("icon =", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotEqualTo(String value) {
			addCriterion("icon <>", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconGreaterThan(String value) {
			addCriterion("icon >", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconGreaterThanOrEqualTo(String value) {
			addCriterion("icon >=", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLessThan(String value) {
			addCriterion("icon <", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLessThanOrEqualTo(String value) {
			addCriterion("icon <=", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconIn(List<String> values) {
			addCriterion("icon in", values, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotIn(List<String> values) {
			addCriterion("icon not in", values, "icon");
			return (Criteria) this;
		}

		public Criteria andIconBetween(String value1, String value2) {
			addCriterion("icon between", value1, value2, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotBetween(String value1, String value2) {
			addCriterion("icon not between", value1, value2, "icon");
			return (Criteria) this;
		}

		public Criteria andIconLike(String value) {
			addCriterion("icon like", value, "icon");
			return (Criteria) this;
		}

		public Criteria andIconNotLike(String value) {
			addCriterion("icon not like", value, "icon");
			return (Criteria) this;
		}

		public Criteria andSimpleIsNull() {
			addCriterion("simple is null");
			return (Criteria) this;
		}

		public Criteria andSimpleIsNotNull() {
			addCriterion("simple is not null");
			return (Criteria) this;
		}

		public Criteria andSimpleEqualTo(Short value) {
			addCriterion("simple =", value, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleNotEqualTo(Short value) {
			addCriterion("simple <>", value, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleGreaterThan(Short value) {
			addCriterion("simple >", value, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleGreaterThanOrEqualTo(Short value) {
			addCriterion("simple >=", value, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleLessThan(Short value) {
			addCriterion("simple <", value, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleLessThanOrEqualTo(Short value) {
			addCriterion("simple <=", value, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleIn(List<Short> values) {
			addCriterion("simple in", values, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleNotIn(List<Short> values) {
			addCriterion("simple not in", values, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleBetween(Short value1, Short value2) {
			addCriterion("simple between", value1, value2, "simple");
			return (Criteria) this;
		}

		public Criteria andSimpleNotBetween(Short value1, Short value2) {
			addCriterion("simple not between", value1, value2, "simple");
			return (Criteria) this;
		}

		public Criteria andResizeIsNull() {
			addCriterion("resize is null");
			return (Criteria) this;
		}

		public Criteria andResizeIsNotNull() {
			addCriterion("resize is not null");
			return (Criteria) this;
		}

		public Criteria andResizeEqualTo(Short value) {
			addCriterion("resize =", value, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeNotEqualTo(Short value) {
			addCriterion("resize <>", value, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeGreaterThan(Short value) {
			addCriterion("resize >", value, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeGreaterThanOrEqualTo(Short value) {
			addCriterion("resize >=", value, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeLessThan(Short value) {
			addCriterion("resize <", value, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeLessThanOrEqualTo(Short value) {
			addCriterion("resize <=", value, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeIn(List<Short> values) {
			addCriterion("resize in", values, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeNotIn(List<Short> values) {
			addCriterion("resize not in", values, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeBetween(Short value1, Short value2) {
			addCriterion("resize between", value1, value2, "resize");
			return (Criteria) this;
		}

		public Criteria andResizeNotBetween(Short value1, Short value2) {
			addCriterion("resize not between", value1, value2, "resize");
			return (Criteria) this;
		}

		public Criteria andHeightIsNull() {
			addCriterion("height is null");
			return (Criteria) this;
		}

		public Criteria andHeightIsNotNull() {
			addCriterion("height is not null");
			return (Criteria) this;
		}

		public Criteria andHeightEqualTo(String value) {
			addCriterion("height =", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotEqualTo(String value) {
			addCriterion("height <>", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThan(String value) {
			addCriterion("height >", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightGreaterThanOrEqualTo(String value) {
			addCriterion("height >=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThan(String value) {
			addCriterion("height <", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLessThanOrEqualTo(String value) {
			addCriterion("height <=", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightIn(List<String> values) {
			addCriterion("height in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotIn(List<String> values) {
			addCriterion("height not in", values, "height");
			return (Criteria) this;
		}

		public Criteria andHeightBetween(String value1, String value2) {
			addCriterion("height between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotBetween(String value1, String value2) {
			addCriterion("height not between", value1, value2, "height");
			return (Criteria) this;
		}

		public Criteria andHeightLike(String value) {
			addCriterion("height like", value, "height");
			return (Criteria) this;
		}

		public Criteria andHeightNotLike(String value) {
			addCriterion("height not like", value, "height");
			return (Criteria) this;
		}

		public Criteria andWidthIsNull() {
			addCriterion("width is null");
			return (Criteria) this;
		}

		public Criteria andWidthIsNotNull() {
			addCriterion("width is not null");
			return (Criteria) this;
		}

		public Criteria andWidthEqualTo(String value) {
			addCriterion("width =", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotEqualTo(String value) {
			addCriterion("width <>", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThan(String value) {
			addCriterion("width >", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthGreaterThanOrEqualTo(String value) {
			addCriterion("width >=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThan(String value) {
			addCriterion("width <", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLessThanOrEqualTo(String value) {
			addCriterion("width <=", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthIn(List<String> values) {
			addCriterion("width in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotIn(List<String> values) {
			addCriterion("width not in", values, "width");
			return (Criteria) this;
		}

		public Criteria andWidthBetween(String value1, String value2) {
			addCriterion("width between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotBetween(String value1, String value2) {
			addCriterion("width not between", value1, value2, "width");
			return (Criteria) this;
		}

		public Criteria andWidthLike(String value) {
			addCriterion("width like", value, "width");
			return (Criteria) this;
		}

		public Criteria andWidthNotLike(String value) {
			addCriterion("width not like", value, "width");
			return (Criteria) this;
		}

		public Criteria andAppUrlIsNull() {
			addCriterion("app_url is null");
			return (Criteria) this;
		}

		public Criteria andAppUrlIsNotNull() {
			addCriterion("app_url is not null");
			return (Criteria) this;
		}

		public Criteria andAppUrlEqualTo(String value) {
			addCriterion("app_url =", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlNotEqualTo(String value) {
			addCriterion("app_url <>", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlGreaterThan(String value) {
			addCriterion("app_url >", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlGreaterThanOrEqualTo(String value) {
			addCriterion("app_url >=", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlLessThan(String value) {
			addCriterion("app_url <", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlLessThanOrEqualTo(String value) {
			addCriterion("app_url <=", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlIn(List<String> values) {
			addCriterion("app_url in", values, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlNotIn(List<String> values) {
			addCriterion("app_url not in", values, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlBetween(String value1, String value2) {
			addCriterion("app_url between", value1, value2, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlNotBetween(String value1, String value2) {
			addCriterion("app_url not between", value1, value2, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlLike(String value) {
			addCriterion("app_url like", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAppUrlNotLike(String value) {
			addCriterion("app_url not like", value, "appUrl");
			return (Criteria) this;
		}

		public Criteria andAuthorizeIsNull() {
			addCriterion("authorize is null");
			return (Criteria) this;
		}

		public Criteria andAuthorizeIsNotNull() {
			addCriterion("authorize is not null");
			return (Criteria) this;
		}

		public Criteria andAuthorizeEqualTo(Short value) {
			addCriterion("authorize =", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeNotEqualTo(Short value) {
			addCriterion("authorize <>", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeGreaterThan(Short value) {
			addCriterion("authorize >", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeGreaterThanOrEqualTo(Short value) {
			addCriterion("authorize >=", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeLessThan(Short value) {
			addCriterion("authorize <", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeLessThanOrEqualTo(Short value) {
			addCriterion("authorize <=", value, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeIn(List<Short> values) {
			addCriterion("authorize in", values, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeNotIn(List<Short> values) {
			addCriterion("authorize not in", values, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeBetween(Short value1, Short value2) {
			addCriterion("authorize between", value1, value2, "authorize");
			return (Criteria) this;
		}

		public Criteria andAuthorizeNotBetween(Short value1, Short value2) {
			addCriterion("authorize not between", value1, value2, "authorize");
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

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
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