package com.jewery.config;

import java.util.Locale;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class JewWebMvcConfig extends WebMvcConfigurerAdapter{

	public JewWebMvcConfig() {
		Locale.setDefault(Locale.ENGLISH);
	}
}
