package com.jewery.constant;

public enum ThaiMonthEnum {
		THAI_JANUARY (1,"มกราคม","ม.ค."),
		THAI_FEBUARY 	(2,"กุมภาพันธ์","ก.พ."),
		THAI_MARCH	 	(3,"มีนาคม","มี.ค."),
		THAI_APRIL (4,"เมษายน","เม.ย."),
		THAI_MAY (5,"พฤษภาคม","พ.ค."),
		THAI_JUNE	 	(6,"มิถุนายน","มิ.ย."),
		THAI_JULY	 	(7,"กรกฎาคม","ก.ค."),
		THAI_AUGUST	 	(8,"สิงหาคม","ส.ค."),
		THAI_SEPTEMBER	 	(9,"กันยายน","ก.ย."),
		THAI_OCTOBER	 	(10,"ตุลาคม","ต.ค."),
		THAI_NOVEMBER	 	(11,"พฤศจิกายน","พ.ย."),
		THAI_DECEMBER	 	(12,"ธันวาคม","ธ.ค.");
	
	private Integer id;
    private String fullMonth;
    private String abrevMonth;
	
	private ThaiMonthEnum(Integer id, String fullMonth, String abrevMonth) {
		this.id = id;
		this.fullMonth = fullMonth;
		this.abrevMonth = abrevMonth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullMonth() {
		return fullMonth;
	}

	public void setFullMonth(String fullMonth) {
		this.fullMonth = fullMonth;
	}

	public String getAbrevMonth() {
		return abrevMonth;
	}

	public void setAbrevMonth(String abrevMonth) {
		this.abrevMonth = abrevMonth;
	}

	public static String getFullMonthById(Integer id){
        for(ThaiMonthEnum e : ThaiMonthEnum.values()){
            if(e.id.equals(id)) 
            	return e.fullMonth;
        }
        return "";
    }
	
	public static String getAbrevMonthById(Integer id){
        for(ThaiMonthEnum e : ThaiMonthEnum.values()){
            if(e.id.equals(id)) 
            	return e.abrevMonth;
        }
        return "";
    }
}
