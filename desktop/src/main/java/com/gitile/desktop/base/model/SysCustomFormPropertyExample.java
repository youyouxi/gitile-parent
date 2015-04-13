/*
 * 文件名称：SysCustomFormPropertyExample.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.ArrayList;
import java.util.List;
import com.gitile.core.mybatis.model.BaseExample;

/**
 * 名称：自定义表单属性
 * 模块描述：数据库表对应实体类查询条件
 */
public class SysCustomFormPropertyExample extends BaseExample {

    protected List<Criteria> oredCriteria;

    public SysCustomFormPropertyExample() {
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

		public Criteria andFormIdIsNull() {
			addCriterion("form_id is null");
			return (Criteria) this;
		}

		public Criteria andFormIdIsNotNull() {
			addCriterion("form_id is not null");
			return (Criteria) this;
		}

		public Criteria andFormIdEqualTo(String value) {
			addCriterion("form_id =", value, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdNotEqualTo(String value) {
			addCriterion("form_id <>", value, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdGreaterThan(String value) {
			addCriterion("form_id >", value, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdGreaterThanOrEqualTo(String value) {
			addCriterion("form_id >=", value, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdLessThan(String value) {
			addCriterion("form_id <", value, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdLessThanOrEqualTo(String value) {
			addCriterion("form_id <=", value, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdIn(List<String> values) {
			addCriterion("form_id in", values, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdNotIn(List<String> values) {
			addCriterion("form_id not in", values, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdBetween(String value1, String value2) {
			addCriterion("form_id between", value1, value2, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdNotBetween(String value1, String value2) {
			addCriterion("form_id not between", value1, value2, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdLike(String value) {
			addCriterion("form_id like", value, "formId");
			return (Criteria) this;
		}

		public Criteria andFormIdNotLike(String value) {
			addCriterion("form_id not like", value, "formId");
			return (Criteria) this;
		}

		public Criteria andSortIsNull() {
			addCriterion("sort is null");
			return (Criteria) this;
		}

		public Criteria andSortIsNotNull() {
			addCriterion("sort is not null");
			return (Criteria) this;
		}

		public Criteria andSortEqualTo(Integer value) {
			addCriterion("sort =", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortNotEqualTo(Integer value) {
			addCriterion("sort <>", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortGreaterThan(Integer value) {
			addCriterion("sort >", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortGreaterThanOrEqualTo(Integer value) {
			addCriterion("sort >=", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortLessThan(Integer value) {
			addCriterion("sort <", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortLessThanOrEqualTo(Integer value) {
			addCriterion("sort <=", value, "sort");
			return (Criteria) this;
		}

		public Criteria andSortIn(List<Integer> values) {
			addCriterion("sort in", values, "sort");
			return (Criteria) this;
		}

		public Criteria andSortNotIn(List<Integer> values) {
			addCriterion("sort not in", values, "sort");
			return (Criteria) this;
		}

		public Criteria andSortBetween(Integer value1, Integer value2) {
			addCriterion("sort between", value1, value2, "sort");
			return (Criteria) this;
		}

		public Criteria andSortNotBetween(Integer value1, Integer value2) {
			addCriterion("sort not between", value1, value2, "sort");
			return (Criteria) this;
		}

		public Criteria andLableIsNull() {
			addCriterion("lable is null");
			return (Criteria) this;
		}

		public Criteria andLableIsNotNull() {
			addCriterion("lable is not null");
			return (Criteria) this;
		}

		public Criteria andLableEqualTo(String value) {
			addCriterion("lable =", value, "lable");
			return (Criteria) this;
		}

		public Criteria andLableNotEqualTo(String value) {
			addCriterion("lable <>", value, "lable");
			return (Criteria) this;
		}

		public Criteria andLableGreaterThan(String value) {
			addCriterion("lable >", value, "lable");
			return (Criteria) this;
		}

		public Criteria andLableGreaterThanOrEqualTo(String value) {
			addCriterion("lable >=", value, "lable");
			return (Criteria) this;
		}

		public Criteria andLableLessThan(String value) {
			addCriterion("lable <", value, "lable");
			return (Criteria) this;
		}

		public Criteria andLableLessThanOrEqualTo(String value) {
			addCriterion("lable <=", value, "lable");
			return (Criteria) this;
		}

		public Criteria andLableIn(List<String> values) {
			addCriterion("lable in", values, "lable");
			return (Criteria) this;
		}

		public Criteria andLableNotIn(List<String> values) {
			addCriterion("lable not in", values, "lable");
			return (Criteria) this;
		}

		public Criteria andLableBetween(String value1, String value2) {
			addCriterion("lable between", value1, value2, "lable");
			return (Criteria) this;
		}

		public Criteria andLableNotBetween(String value1, String value2) {
			addCriterion("lable not between", value1, value2, "lable");
			return (Criteria) this;
		}

		public Criteria andLableLike(String value) {
			addCriterion("lable like", value, "lable");
			return (Criteria) this;
		}

		public Criteria andLableNotLike(String value) {
			addCriterion("lable not like", value, "lable");
			return (Criteria) this;
		}

		public Criteria andFormTypeIsNull() {
			addCriterion("form_type is null");
			return (Criteria) this;
		}

		public Criteria andFormTypeIsNotNull() {
			addCriterion("form_type is not null");
			return (Criteria) this;
		}

		public Criteria andFormTypeEqualTo(String value) {
			addCriterion("form_type =", value, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeNotEqualTo(String value) {
			addCriterion("form_type <>", value, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeGreaterThan(String value) {
			addCriterion("form_type >", value, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeGreaterThanOrEqualTo(String value) {
			addCriterion("form_type >=", value, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeLessThan(String value) {
			addCriterion("form_type <", value, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeLessThanOrEqualTo(String value) {
			addCriterion("form_type <=", value, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeIn(List<String> values) {
			addCriterion("form_type in", values, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeNotIn(List<String> values) {
			addCriterion("form_type not in", values, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeBetween(String value1, String value2) {
			addCriterion("form_type between", value1, value2, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeNotBetween(String value1, String value2) {
			addCriterion("form_type not between", value1, value2, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeLike(String value) {
			addCriterion("form_type like", value, "formType");
			return (Criteria) this;
		}

		public Criteria andFormTypeNotLike(String value) {
			addCriterion("form_type not like", value, "formType");
			return (Criteria) this;
		}

		public Criteria andRequiredIsNull() {
			addCriterion("required is null");
			return (Criteria) this;
		}

		public Criteria andRequiredIsNotNull() {
			addCriterion("required is not null");
			return (Criteria) this;
		}

		public Criteria andRequiredEqualTo(Short value) {
			addCriterion("required =", value, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredNotEqualTo(Short value) {
			addCriterion("required <>", value, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredGreaterThan(Short value) {
			addCriterion("required >", value, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredGreaterThanOrEqualTo(Short value) {
			addCriterion("required >=", value, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredLessThan(Short value) {
			addCriterion("required <", value, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredLessThanOrEqualTo(Short value) {
			addCriterion("required <=", value, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredIn(List<Short> values) {
			addCriterion("required in", values, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredNotIn(List<Short> values) {
			addCriterion("required not in", values, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredBetween(Short value1, Short value2) {
			addCriterion("required between", value1, value2, "required");
			return (Criteria) this;
		}

		public Criteria andRequiredNotBetween(Short value1, Short value2) {
			addCriterion("required not between", value1, value2, "required");
			return (Criteria) this;
		}

		public Criteria andInputLengthIsNull() {
			addCriterion("input_length is null");
			return (Criteria) this;
		}

		public Criteria andInputLengthIsNotNull() {
			addCriterion("input_length is not null");
			return (Criteria) this;
		}

		public Criteria andInputLengthEqualTo(Short value) {
			addCriterion("input_length =", value, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthNotEqualTo(Short value) {
			addCriterion("input_length <>", value, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthGreaterThan(Short value) {
			addCriterion("input_length >", value, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthGreaterThanOrEqualTo(Short value) {
			addCriterion("input_length >=", value, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthLessThan(Short value) {
			addCriterion("input_length <", value, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthLessThanOrEqualTo(Short value) {
			addCriterion("input_length <=", value, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthIn(List<Short> values) {
			addCriterion("input_length in", values, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthNotIn(List<Short> values) {
			addCriterion("input_length not in", values, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthBetween(Short value1, Short value2) {
			addCriterion("input_length between", value1, value2, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputLengthNotBetween(Short value1, Short value2) {
			addCriterion("input_length not between", value1, value2, "inputLength");
			return (Criteria) this;
		}

		public Criteria andInputRegularIsNull() {
			addCriterion("input_regular is null");
			return (Criteria) this;
		}

		public Criteria andInputRegularIsNotNull() {
			addCriterion("input_regular is not null");
			return (Criteria) this;
		}

		public Criteria andInputRegularEqualTo(String value) {
			addCriterion("input_regular =", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularNotEqualTo(String value) {
			addCriterion("input_regular <>", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularGreaterThan(String value) {
			addCriterion("input_regular >", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularGreaterThanOrEqualTo(String value) {
			addCriterion("input_regular >=", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularLessThan(String value) {
			addCriterion("input_regular <", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularLessThanOrEqualTo(String value) {
			addCriterion("input_regular <=", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularIn(List<String> values) {
			addCriterion("input_regular in", values, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularNotIn(List<String> values) {
			addCriterion("input_regular not in", values, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularBetween(String value1, String value2) {
			addCriterion("input_regular between", value1, value2, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularNotBetween(String value1, String value2) {
			addCriterion("input_regular not between", value1, value2, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularLike(String value) {
			addCriterion("input_regular like", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andInputRegularNotLike(String value) {
			addCriterion("input_regular not like", value, "inputRegular");
			return (Criteria) this;
		}

		public Criteria andOptionValuesIsNull() {
			addCriterion("option_values is null");
			return (Criteria) this;
		}

		public Criteria andOptionValuesIsNotNull() {
			addCriterion("option_values is not null");
			return (Criteria) this;
		}

		public Criteria andOptionValuesEqualTo(String value) {
			addCriterion("option_values =", value, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesNotEqualTo(String value) {
			addCriterion("option_values <>", value, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesGreaterThan(String value) {
			addCriterion("option_values >", value, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesGreaterThanOrEqualTo(String value) {
			addCriterion("option_values >=", value, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesLessThan(String value) {
			addCriterion("option_values <", value, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesLessThanOrEqualTo(String value) {
			addCriterion("option_values <=", value, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesIn(List<String> values) {
			addCriterion("option_values in", values, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesNotIn(List<String> values) {
			addCriterion("option_values not in", values, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesBetween(String value1, String value2) {
			addCriterion("option_values between", value1, value2, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesNotBetween(String value1, String value2) {
			addCriterion("option_values not between", value1, value2, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesLike(String value) {
			addCriterion("option_values like", value, "optionValues");
			return (Criteria) this;
		}

		public Criteria andOptionValuesNotLike(String value) {
			addCriterion("option_values not like", value, "optionValues");
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