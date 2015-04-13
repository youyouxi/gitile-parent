/*
 * 文件名称：SysCustomFormProperty.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;


/**
 * 名称：自定义表单属性
 * 模块描述：数据库表对应实体类
 */
public class SysCustomFormProperty implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysCustomFormProperty() {}
	public SysCustomFormProperty(Long id,String formId,Integer sort,String lable,String formType,Short required,Short inputLength,String inputRegular,String optionValues) {
		this.id=id;
		this.formId=formId;
		this.sort=sort;
		this.lable=lable;
		this.formType=formType;
		this.required=required;
		this.inputLength=inputLength;
		this.inputRegular=inputRegular;
		this.optionValues=optionValues;
	}
	public SysCustomFormProperty setNotNull(Long id,String formId,Integer sort,String lable,String formType,Short required) {
		this.id=id;
		this.formId=formId;
		this.sort=sort;
		this.lable=lable;
		this.formType=formType;
		this.required=required;
		return this;
	}
	/**属性**/
	private Long id;// 编号（非空） 
	private String formId;// 表单编号（非空） 
	private Integer sort;// 排序（非空） 
	private String lable;// 标题（非空） 
	private String formType;// 类型（非空） 
	private Short required;// 是否必填（非空） 
	private Short inputLength;// 最大长度
	private String inputRegular;// 验证规则
	private String optionValues;// 选项内容

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFormId() {
		return formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public Short getRequired() {
		return required;
	}
	public void setRequired(Short required) {
		this.required = required;
	}
	public Short getInputLength() {
		return inputLength;
	}
	public void setInputLength(Short inputLength) {
		this.inputLength = inputLength;
	}
	public String getInputRegular() {
		return inputRegular;
	}
	public void setInputRegular(String inputRegular) {
		this.inputRegular = inputRegular;
	}
	public String getOptionValues() {
		return optionValues;
	}
	public void setOptionValues(String optionValues) {
		this.optionValues = optionValues;
	}

}