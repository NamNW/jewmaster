package com.jewery.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class JewEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5221815867599412198L;
	private Long createBy;
	private Long updateBy;
	private Date createTime;
	private Date updateTime;
	
	@Column(name = "create_by", nullable = false)
	public Long getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	
	@Column(name = "update_by", nullable = false)
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time", nullable = false)
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
