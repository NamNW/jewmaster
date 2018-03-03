package com.jewery.service;

import com.jewery.bean.JewUserBean;
import com.jewery.entity.JewUser;

public interface JewUserService {
	
	public void saveJewUser(JewUserBean user) throws Exception;
	
	public JewUser findByUserName(String userName) throws Exception; 
}
