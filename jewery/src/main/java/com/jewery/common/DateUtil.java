package com.jewery.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Period;

import com.jewery.constant.ThaiMonthEnum;

public final class DateUtil {
	private static final String REPORT_DATE_SQL_FORMAT = "yyyy-MM-dd";
	private static final String REPORT_DATE_SHORT_FORMAT = "dd/MM/yyyy";
	private static final String CRITERIA_DATE_FORMAT = "MM/dd/yyyy";
	private static final String THAI_LONG_FORMAT = "EEEE ที่ dd เดือน MMMM พ.ศ. yyyy";
	private static final String THAI_TEXT_FORMAT = "dd MMMM yyyy";
	private static final String THAI_TEXT_WITH_TIME_FORMAT = "dd MMMM yyyy HH:mm:ss";
	private static final String THAI_MONTH_YEAR_FORMAT = "MMMM yyyy";
	private static final String THAI_MONTH_YEAR_SHORT_FORMAT = "MMM yyy";
	private static final String THAI_MONTH_FORMAT = "MMMM";
	private static final String THAI_REGION = "th";
	private static final String THAI_LOCALE = "TH";
	private static final String GFMIS_DATE_REPORT_FORMAT = "yyyyMMdd";
	private static Locale THAI_LOCAL;
	private static final String ZERO = "0";
	private static String THAI_FORMAL_FORMAT = "dd เดือน MMMM พ.ศ. yyyy";
	public static final String THAI_DATE_TIME = "dd/MM/yyyy HH:mm:ss";
	/**
	 * @objective: Thai locale for date format
	 * @return Thai locale
	 */
	public static Locale getThaiLocale(){
		if(THAI_LOCAL == null){
			THAI_LOCAL = new Locale(THAI_REGION, THAI_LOCALE);
		}
		return THAI_LOCAL;
	}
	
	/**
	 * @objective: the string date which having DB2 default date format yyyy-mm-dd (2017-05-01)
	 * @return converted date in type string
	 */
	public static String converDateToSqlDateFormat(Date date) throws Exception{
		if(date == null){
			return null;			
		}
		SimpleDateFormat sdf = new SimpleDateFormat(REPORT_DATE_SQL_FORMAT);
		sdf.setLenient(false);
		String convertedDate = sdf.format(date.getTime());
		return convertedDate;
	}
	
	/**
	 * @objective: get current date
	 * @return current date
	 */
	public static Date getNowDate(){
		return getCalendarInstance().getTime();
	}
	
	/**
	 * @objective: get Date format like 12/05/2560
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getThaiDateShortForm(Date date){
		String convertedDate = null;
		if(date == null){
			return null;			
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(REPORT_DATE_SHORT_FORMAT,getThaiLocale());
			sdf.setLenient(false);
			convertedDate = sdf.format(date.getTime());
		} catch (Exception e) {
			//do nothin
		}
		return convertedDate;
	}
	
	/**
	 * @objective: get Date format like วันอาทิตย์ ที่ 21 เดือน พฤษภาคม พ.ศ. 2560 
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getThaiDateLongForm(Date date) throws Exception{
		if(date == null){
			return null;			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(THAI_LONG_FORMAT, getThaiLocale());
		sdf.setLenient(false);
		String convertedDate = sdf.format(date.getTime());
		return convertedDate;
	}
	
	/**
	 * @objective: get Date format like 21 พฤษภาคม 2560 
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getThaiDateText(Date date) throws Exception{
		if(date == null){
			return null;			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(THAI_TEXT_FORMAT, getThaiLocale());
		sdf.setLenient(false);
		String convertedDate = sdf.format(date.getTime());
		return convertedDate;
	}
	
	/**
	 * @objective: get Date format like 21 พฤษภาคม 2560 17:20:00
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getThaiDateWithTimeText(Date date) throws Exception{
		if(date == null){
			return null;			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(THAI_TEXT_WITH_TIME_FORMAT, getThaiLocale());
		sdf.setLenient(false);
		String convertedDate = sdf.format(date.getTime());
		return convertedDate;
	}
	
	
	/**
	 * @objective: get date format like กุมภาพันธ์ 2560
	 * @param String curMonthYear accept with pattern yyyymm[201705] to be convert.
	 * @return string date after conversion 
	 */
	public static String getThaiMonthAndYearFullForm(String curMonthYear) throws Exception{
		String convertedDate = null;
		if (curMonthYear.isEmpty()) {
			return null;			
		}
		try {
			DateFormat  format = new SimpleDateFormat("yyyyMM");
			Date date = format.parse(curMonthYear);
			SimpleDateFormat sdf = new SimpleDateFormat(THAI_MONTH_YEAR_FORMAT, getThaiLocale());
			sdf.setLenient(false);
			convertedDate = sdf.format(date.getTime());
		} catch (Exception e) {
			//do nothin
		}
		return convertedDate;
	}
	
	public static String getThaiMonthFullForm(String curMonth) throws Exception{
		String convertedDate = null;
		if (curMonth.isEmpty()) {
			return null;			
		}
		try {
			DateFormat  format = new SimpleDateFormat("MM");
			Date date = format.parse(curMonth);
			SimpleDateFormat sdf = new SimpleDateFormat(THAI_MONTH_FORMAT, getThaiLocale());
			sdf.setLenient(false);
			convertedDate = sdf.format(date.getTime());
		} catch (Exception e) {
			//do nothin
		}
		return convertedDate;
	}
	
	/**
	 * @objective: get buddhist year
	 * @param year us year
	 * @return string date after conversion 
	 */
	public static String getThaiYear(String year){
		if(year == null || "".equals(year)){
			return null;
		}
		
		int thaiYear = Integer.parseInt(year) + 543;
		return String.valueOf(thaiYear);
	}
	
	/**
	 * @objective: get the period of year between 2 dates
	 * @param startDate begin date like birth date
	 * @param endDate end date like current date
	 * @return number of year
	 */
	public static Integer subtractYear(Date startDate, Date endDate) throws Exception {
		if(startDate == null || endDate == null){
			return null;
		}
		
		DateTime dateTime1 = new DateTime(startDate);
		DateTime dateTime2 = new DateTime(endDate);
		Period period = new Period(dateTime1, dateTime2);
		return period.getYears();
	}
	
	/**
	 * @objective: get the period of year between 2 dates
	 * @param birthDate begin date like birth date
	 * @return number of year
	 */
	public static Integer calculateAgeWithCurrentDate(Date birthDate){
		if(birthDate == null){
			return null;
		}
		DateTime dateTime1 = new DateTime(birthDate);
		DateTime dateTime2 = new DateTime(Calendar.getInstance().getTime());
		Period period = new Period(dateTime1, dateTime2);
		return period.getYears();
	}
	
	/**
	 * @objective: get Date format like 20160819
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getGfmisDateFormat(Date date) throws Exception{
		if(date == null){
			return null;			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(GFMIS_DATE_REPORT_FORMAT);
		sdf.setLenient(false);
		String convertedDate = sdf.format(date.getTime());
		return convertedDate;
	}

	/**
	Add a comment to this line
	 * @objective: get the current month and year as String like 201705.
	 * @param -
	 * @return String of current month and year.
	 */
	public static String getCurMonthYear(){
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) +1;
		String monthStr = month < 10 ? "0"+month : month+"";
		return year + "" + monthStr;
	}
	
	/**
	 * @objective: convert gfmis string date to be date for screnn
	 * @param gfmisDate gfmis string date 
	 * @return converted gfmis date
	 */
	public static Date convertGfmisDate(String gfmisDate) throws Exception{
		if(gfmisDate == null){
			return null;			
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(GFMIS_DATE_REPORT_FORMAT);
		sdf.setLenient(false);
		Date convertedDate = sdf.parse(gfmisDate);
		return convertedDate;
	}
	
	/**
	 * @objective: get current month
	 * @return current month in 2 digits
	 */
	public static String getCurrentMonthPaddingZero() throws Exception{
		Calendar calendar = getCalendarInstance();
		int month = calendar.get(Calendar.MONTH);
		return StringUtils.leftPad(String.valueOf(month+1), 2, ZERO) ;
	}
	
	/**
	 * @objective: get Calendar
	 * @return Calendar
	 */
	private static Calendar getCalendarInstance(){
		return Calendar.getInstance();
	}
	
	/**
	 * @objective: get current year
	 * @return current thai year
	 */
	public static String getCurrentThaiYear() throws Exception{
		Calendar calendar = getCalendarInstance();
		int year = calendar.get(Calendar.YEAR);
		return getThaiYear(String.valueOf(year));
	}
	
	/**
	 * @objective: get abbreviation of thai month by number of month 
	 * @param number of month
	 * @return abbreviation thai month
	 */
	public static String getThaiAbrevMonthByNumberOfMonth(String numberOfMonth){
		if(StringUtils.isEmpty(numberOfMonth)){
			return null;
		}
		return ThaiMonthEnum.getAbrevMonthById(Integer.parseInt(numberOfMonth));
	}
	
	/**
	 * @objective: get full of thai month by number of month 
	 * @param number of month
	 * @return full thai month
	 */
	public static String getThaiFullMonthByNumberOfMonth(String numberOfMonth){
		if(StringUtils.isEmpty(numberOfMonth)){
			return null;
		}
		return ThaiMonthEnum.getFullMonthById(Integer.parseInt(numberOfMonth));
	}
	
	/**
	 * @objective: compare two date 
	 * @param date1 
	 * @param date2 
	 * @return 0 if equal, -1 if date1 is lesser, and 1 if date1 is greater.
	 */
	public static Integer compareDate(Date date1, Date date2){ 
		DateTime dateTime1 = new DateTime(date1);
		DateTime dateTime2 = new DateTime(date2);
		return DateTimeComparator.getDateOnlyInstance().compare(dateTime1, dateTime2);
	}
	
	/**
	 * @objective: add month to given date
	 * @param requestDate date that will be added
	 * @param number of month adding
	 * @return date after adding month
	 */
	public static Date addMonthToDate(Date requestDate, Integer requestMonth) throws Exception {
		if(requestDate == null || requestMonth == null){
			return null;
		}
		
		DateTime dateResult = new DateTime(requestDate).plusMonths(requestMonth);
		return dateResult.toDate();
	}
	
	/**
	 * @objective: get thai fiscal year
	 * @return only fiscal year in text
	 */
	public static String getThaiFiscalYearText(){
		Calendar now = getCalendarInstance();
		int year = now.get(Calendar.YEAR) + (now.get(Calendar.MONTH) > 9 ? 1:0);
		return getThaiYear(String.valueOf(year));
	}
	
	/**
	 * @objective: get Date format in thai like ๒๑ พฤษภาคม ๒๕๖๐
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getThaiDateFormalFormatReport(Date date){
		if(date == null){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat (THAI_FORMAL_FORMAT, new Locale(THAI_REGION, THAI_LOCALE));
		formatter.setLenient(false);
		return formatter.format(date);
	}

	/**
	 * @objective: get eng year
	 * @param thai year
	 * @return eng year
	 */
	public static String getEngYear(String year){
		if(year == null || "".equals(year)){
			return null;
		}
		
		int thaiYear = Integer.parseInt(year) - 543;
		return String.valueOf(thaiYear);
	}
	
	/**
	 * @objective: get date format like ก.พ. 60
	 * @param String curMonthYear accept with pattern yyyymm[201705] to be convert.
	 * @return string date after conversion 
	 */
	public static String getThaiMonthAndYearShortForm(String curMonthYear) throws Exception{
		String convertedDate = null;
		if (curMonthYear.isEmpty()) {
			return null;			
		}
		try {
			DateFormat  format = new SimpleDateFormat("yyyyMM");
			Date date = format.parse(curMonthYear);
			SimpleDateFormat sdf = new SimpleDateFormat(THAI_MONTH_YEAR_SHORT_FORMAT, getThaiLocale());
			sdf.setLenient(false);
			convertedDate = sdf.format(date.getTime());
		} catch (Exception e) {
			//do nothin
		}
		return convertedDate;
	}
	
	/**
	 * @objective: get the current year as String like 2017.
	 * @param -
	 * @return String of current year in AD.
	 */
	public static String getCurYearAD(){
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		return String.valueOf(year);
	}
	
	/**
	 * @objective: get date format like 31/12/2560
	 * @param String with pattern yyyyMMdd[25601231] to be convert.
	 * @return string date after conversion 
	 */
	public static String getThaiDateShortForm(String yearMonthDay) throws Exception{
		String convertedDate = null;
		if (yearMonthDay.isEmpty()) {
			return null;			
		}
		try {
			DateFormat  format = new SimpleDateFormat("yyyyMMdd");
			Date date = format.parse(yearMonthDay);
			SimpleDateFormat sdf = new SimpleDateFormat(REPORT_DATE_SHORT_FORMAT);
			sdf.setLenient(false);
			convertedDate = sdf.format(date.getTime());
		} catch (Exception e) {
			//do nothin
		}
		return convertedDate;
	}
	
	
	
	/**
	 * @objective: get Date format like 20160819
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getThaiDateGfmisFileName(Date date) throws Exception{
		String convertedDate = null;
		if(date == null){
			return null;			
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(GFMIS_DATE_REPORT_FORMAT,getThaiLocale());
			convertedDate = sdf.format(date.getTime());
		} catch (Exception e) {
			//do nothin
		}
		return convertedDate;
	}
	
	/**
	 * @objective: get Date format like 10/01/2017 (MM/dd/yyyy)
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String getCriteriaDateFormat(Date date) throws Exception{
		String convertedDate = null;
		if(date == null){
			return null;			
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(CRITERIA_DATE_FORMAT);
			convertedDate = sdf.format(date.getTime());
		} catch (Exception e) {
			//do nothin
		}
		return convertedDate;
	}
	
	/**
	 * @objective: convert date with given format
	 * @param date date that will be converted
	 * @return string date after conversion 
	 */
	public static String convertDateWithFormat(Date date, String format) throws Exception{
		String convertedDate = null;
		if(date == null || StringUtils.isEmpty(format)){
			return null;			
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		convertedDate = sdf.format(date.getTime());
		return convertedDate;
	}
	
	/**
	 * @objective: get thai fiscal year from given curYear and curMonth in pattern 201705
	 * @return only fiscal year in text
	 */
	public static String getThaiFiscalYearFromCurYearMonth(String curYearMonth) throws Exception{
		if(StringUtils.isEmpty(curYearMonth)){
			return null;
		}
		
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM", Locale.ENGLISH);
		now.setTime(sdf.parse(curYearMonth));// all done
		int year = now.get(Calendar.YEAR) + ((now.get(Calendar.MONTH)+1) > 9 ? 1:0);
		return getThaiYear(String.valueOf(year));
	}
	
	/**
	 * @objective: get Day of the current month
	 * @return number of day
	 */
	public static Integer getDayOfCurrentMonth() throws Exception{
		Calendar now = getCalendarInstance();
		Integer dayOfMonth = now.getActualMaximum(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}
	
	/**
	 * @objective: get Day of the current month
	 * @return number of day
	 */
	public static Integer getDayOfMonth(int year, int month) throws Exception{
		Calendar calendar = getCalendarInstance();
		calendar.clear();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		Integer dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}
	
	/**
	 * @objective: add days to given date
	 * @param requestDate date that will be added
	 * @param number of days adding
	 * @return date after adding days
	 */
	public static Date addDaysToDate(Date requestDate, Integer requestDay) throws Exception {
		if(requestDate == null || requestDay == null){
			return null;
		}
		
		DateTime dateResult = new DateTime(requestDate).plusDays(requestDay);
		return dateResult.toDate();
	}
	
	public static Timestamp getNowTimestamp() {
	   Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
}
