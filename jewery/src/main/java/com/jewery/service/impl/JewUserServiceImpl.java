package com.jewery.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.jewery.bean.JewUserBean;
import com.jewery.entity.JewUser;
import com.jewery.entity.JewUserProfile;
import com.jewery.repository.JewUserProfileRepository;
import com.jewery.repository.JewUserRepository;
import com.jewery.service.JewUserService;

@Service
@Transactional
public class JewUserServiceImpl implements JewUserService{
	@Autowired
	private JewUserRepository jewUserRepository;
	
	@Autowired
	private JewUserProfileRepository jewUserProfileRepository;
	
	@Override
	public void saveJewUser(JewUserBean userBean) throws Exception{
		if(userBean != null) {
			//insert user.
			JewUser user = new JewUser();
			
			//encrypt password for user
			user.setUserName(userBean.getUserName());
			user.setPassword(BCrypt.hashpw(userBean.getPassword(), BCrypt.gensalt()));
			JewUser userEntity = jewUserRepository.save(user);
			
			//insert user profile
			JewUserProfile profile = new JewUserProfile();
			profile.setFirstName(userBean.getFirstName());
			profile.setLastName(userBean.getLastName());
			profile.setBirthDate(userBean.getBirthDate());
			profile.setUserId(userEntity.getUserId());
			
			jewUserProfileRepository.save(profile);
		}
	}

	@Override
	public JewUser findByUserName(String userName) throws Exception {
		return jewUserRepository.findByUserName(userName);
	}

}
