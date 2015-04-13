/*
 * 文件名称：SysUserProfile.java
 * 项目名称：虚拟桌面
 * 创建时间：2015年04月13日 11:55
 */
package com.gitile.desktop.base.model;

import java.util.Date;

/**
 * 名称：账号扩展信息
 * 模块描述：数据库表对应实体类
 */
public class SysUserProfile implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**构造函数**/
	public SysUserProfile() {}
	public SysUserProfile(Long id,String name,Short sex,Long deptId,Long positionId,String idCard,String headPortrait,String nativePlace,String nation,Date birthday,Short birthdayType,Date workTime,String education,Date entryTime,Date quitTime,String propertys,String selfEvaluation,String educationExperience,String workExperience,String trainingExperience,String extendPropertys) {
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.deptId=deptId;
		this.positionId=positionId;
		this.idCard=idCard;
		this.headPortrait=headPortrait;
		this.nativePlace=nativePlace;
		this.nation=nation;
		this.birthday=birthday;
		this.birthdayType=birthdayType;
		this.workTime=workTime;
		this.education=education;
		this.entryTime=entryTime;
		this.quitTime=quitTime;
		this.propertys=propertys;
		this.selfEvaluation=selfEvaluation;
		this.educationExperience=educationExperience;
		this.workExperience=workExperience;
		this.trainingExperience=trainingExperience;
		this.extendPropertys=extendPropertys;
	}
	public SysUserProfile setNotNull(Long id,String name,Short sex,Long deptId,Long positionId) {
		this.id=id;
		this.name=name;
		this.sex=sex;
		this.deptId=deptId;
		this.positionId=positionId;
		return this;
	}
	/**属性**/
	private Long id;// 用户编号（非空） 
	private String name;// 姓名（非空） 
	private Short sex;// 性别（非空） 
	private Long deptId;// 所属部门（非空） 
	private Long positionId;// 当前职位（非空） 
	private String idCard;// 身份证号
	private String headPortrait;// 头像
	private String nativePlace;// 籍贯
	private String nation;// 民族
	private Date birthday;// 出生日期
	private Short birthdayType;// 阳历/阴历
	private Date workTime;// 参加工作时间
	private String education;// 学历
	private Date entryTime;// 入职时间
	private Date quitTime;// 离职时间
	private String propertys;// 扩展小字段
	private String selfEvaluation;// 自我评价
	private String educationExperience;// 教育经历
	private String workExperience;// 工作经历
	private String trainingExperience;// 培训经历
	private String extendPropertys;// 扩展大字段

	/**属性Get、Set函数**/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getSex() {
		return sex;
	}
	public void setSex(Short sex) {
		this.sex = sex;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Long getPositionId() {
		return positionId;
	}
	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getHeadPortrait() {
		return headPortrait;
	}
	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Short getBirthdayType() {
		return birthdayType;
	}
	public void setBirthdayType(Short birthdayType) {
		this.birthdayType = birthdayType;
	}
	public Date getWorkTime() {
		return workTime;
	}
	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getQuitTime() {
		return quitTime;
	}
	public void setQuitTime(Date quitTime) {
		this.quitTime = quitTime;
	}
	public String getPropertys() {
		return propertys;
	}
	public void setPropertys(String propertys) {
		this.propertys = propertys;
	}
	public String getSelfEvaluation() {
		return selfEvaluation;
	}
	public void setSelfEvaluation(String selfEvaluation) {
		this.selfEvaluation = selfEvaluation;
	}
	public String getEducationExperience() {
		return educationExperience;
	}
	public void setEducationExperience(String educationExperience) {
		this.educationExperience = educationExperience;
	}
	public String getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(String workExperience) {
		this.workExperience = workExperience;
	}
	public String getTrainingExperience() {
		return trainingExperience;
	}
	public void setTrainingExperience(String trainingExperience) {
		this.trainingExperience = trainingExperience;
	}
	public String getExtendPropertys() {
		return extendPropertys;
	}
	public void setExtendPropertys(String extendPropertys) {
		this.extendPropertys = extendPropertys;
	}

}