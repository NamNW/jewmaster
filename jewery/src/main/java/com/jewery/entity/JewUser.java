package com.jewery.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jewery.common.DateUtil;

@Entity
@Table(name = "jew_user", catalog = "jewerydb")
public class JewUser extends JewEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8996146528405627934L;
	private Long userId;
	private String token;
	private String salt;
	private String userName;
	private String password;
	private Date lastUpdatePassword;
	
	public JewUser(Long createBy,Long updateBy,Timestamp createTime,Timestamp updateTime) {
		setCreateBy(createBy);
		setCreateTime(createTime);
		setUpdateBy(updateBy);
		setUpdateTime(updateTime);
	}
	
	public JewUser() {
		setCreateTime(DateUtil.getNowDate());
		setUpdateTime(DateUtil.getNowDate());
	}

	@Id
	@Column(name = "user_id", nullable = false, unique = true)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "token", unique = true, nullable = false)
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name = "salt", unique = true, nullable = false)
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Column(name = "user_name", unique = true, nullable = false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_password", nullable = false)
	public Date getLastUpdatePassword() {
		return lastUpdatePassword;
	}
	public void setLastUpdatePassword(Date lastUpdatePassword) {
		this.lastUpdatePassword = lastUpdatePassword;
	}
}
