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
@Table(name = "jew_user_profile", catalog = "jewerydb")
public class JewUserProfile extends JewEntity{
	/**09
	 * 
	 */
	private static final long serialVersionUID = 4391622144946726306L;
	private Long profileId;
	private Long userId;
	private String firstName;
	private String lastName;
	private Date birthDate;
	
	public JewUserProfile(Long createBy,Long updateBy,Timestamp createTime,Timestamp updateTime) {
//		setCreateBy(createBy);
		setCreateTime(createTime);
//		setUpdateBy(updateBy);
		setUpdateTime(updateTime);
	}
	
	public JewUserProfile() {
		setCreateTime(DateUtil.getNowDate());
		setUpdateTime(DateUtil.getNowDate());
	}
	
	@Id
	@Column(name = "profile_id", nullable = false, unique = true)
	public Long getProfileId() {
		return profileId;
	}
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	
	@Column(name = "user_id", nullable = false, unique = true)
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
