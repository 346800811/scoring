package com.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

public class PublicTools {

	public static List<String> getCurrentUser(HttpServletRequest request, Log logger) {
		HttpSession session = request.getSession();
		List<String> scUser = (List<String>) session.getAttribute(Golbal.CURRENT_USER); // 当前用户
		return scUser;
	}
	/**
	 * 向session中添加user信息
	 * @param request
	 */
	public static List<String> setCurrentUser(HttpServletRequest request, com.scoring.model.User user, Log logger) {
		HttpSession session = request.getSession();
		List<String> scUser = (List<String>) session.getAttribute(Golbal.CURRENT_USER); // 当前用户
		// 获得当前时间
		String dbDate = getSysDateTime();
		scUser = new ArrayList<String>();

		scUser.add("" + user.getId());// 0 用户ID
		scUser.add(user.getName());// 1 用户名称
		scUser.add("" + user.getType());// 2 用户类型
		scUser.add(dbDate);// 3 登录时间

		session.setAttribute(Golbal.CURRENT_USER, scUser);
		return scUser;
	}
	
	
	public static String getSysDate(){
		SimpleDateFormat nowDate = new SimpleDateFormat("yyyyMMdd");
		String dbDate = nowDate.format(new Date());
		dbDate = dbDate.substring(0, 4) + "年" + dbDate.substring(4, 6) +"月" + dbDate.substring(6, 8) + "日";
		
		return dbDate;
	}
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getSysDateTime(){
		SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dbDateTime = nowDate.format(new Date());
		return dbDateTime;
	}
	
	/**
	 * @Title: getUUID
	 * @Description: 获取唯一标识（32位）
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().replaceAll("-", "");
		return id;
	}

	/**
	 * <p>Method Name: getCurrentDate  </p>
	 * <p>Description: 获取当前时间</p>
	 * @param format 时间格式,默认yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrentDate(String format){
		if(format == null || "".equals(format)){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		return simpleDateFormat.format(calendar.getTime());
	}
	
	/** 
	* @Title: transfersDateTostr 
	* @Description: 转换日期为格式化字符串
	* @param @param date 日期
	* @param @param format 格式化,默认yyyy-MM-dd HH:mm:ss
	* @param @return
	* @return String
	* @throws 
	*/
	public static String transfersDateTostr(Date date, String format){
		if(format == null || "".equals(format)){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/** 
	* @Title: transfersStrToTimestamp
	* @Description: 转换格式化时间字符串为Timestamp
	* @param @param dateStr
	* @param @param format
	* @param @return
	* @return Timestamp
	* @throws 
	*/
	public static Timestamp transfersStrToTimestamp(String dateStr, String format){
		if(format == null || "".equals(format)){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		java.util.Date date;
		try {
			date = simpleDateFormat.parse(dateStr);
			Timestamp ts = new Timestamp(date.getTime());
			return ts;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 判断字符串的编码
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "";
	}

	/**
	 * 将Object类型转化为Sring 
	 * @param obj Object对象
	 * @return
	 */
	public static String cvToString(Object obj){

		return obj==null?"":obj.toString();
		
	}

	/**
	 * 将Object类型转化为double 
	 * @param obj Object对象
	 * @return
	 */
	public static Double cvToDouble(Object obj){
		
		return obj==null?0:Double.parseDouble(obj.toString());
		
	}

	/**
	 * 将double格式化两位小数
	 * @param num Double对象
	 * @return
	 */
	public static Double cvToDouble2(Double num){
		if(num==null){
			return 0.00;
		}
		num = num*100;
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
		String numStr = df.format(num);

		return Double.parseDouble(numStr);
		
	}

	/**
	 * 将double格式化四位小数
	 * @param num object对象
	 * @return
	 */
	public static Double cvToDouble4(Object num){
		
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.0000");  
		String numStr = df.format(cvToDouble(num));
		
		return Double.parseDouble(numStr);
		
	}

	/**
	 * 将Object转化为int型
	 * @param obj 数字对象
	 * @return int
	 */
	public static int cvToInt(Object obj){
		String numStr = obj==null?"":obj.toString();
		if(numStr.indexOf(".")!=-1){
			numStr = numStr.substring(0, numStr.indexOf("."));
		}
		if("".equals(numStr.trim())){
			numStr = "0";
		}
		int num = Integer.parseInt(numStr);

		return num;
	}

	/**
	 * 将Object转化为Date型
	 * @param dateObj 日期对象
	 * @return Date
	 */
	public static Date cvToDate(Object dateObj){
		if(null!=dateObj&&!"".equals(dateObj)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sdate = PublicTools.cvToString(dateObj);
			try {
				Date date = sdf.parse(sdate);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	/**
	 * 计算完成率
	 * 
	 * @param percentageComplete 完成值。
	 * @param planValue 计划值。
	 * @return
	 */
	public static Double calPerComplete(Object percentageComplete,Object planValue){
		java.text.DecimalFormat df = new DecimalFormat("0.00");
		Double pc = cvToDouble(percentageComplete);
		Double pv = cvToDouble(planValue);
		if(0.0==pv){
			return 0.00;
		}else{
			return Double.parseDouble(df.format(pc*100/pv));
		}
	}

   /**
    * 将字符串转化为日期
    * @param strDate
    * @return
    * @throws Exception
    */
    public static Date ConverToDate(String strDate) throws Exception  
    {  
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
        return df.parse(strDate);  
    }
   
    public static String  parsToNum(String x,String v){
		java.text.DecimalFormat df = null;
		if("4".equals(v)||"4.0".equals(v)){
			df = new java.text.DecimalFormat("0.0000");
			return df.format(Double.parseDouble(x));
		}else if("2".equals(v)||"2.0".equals(v)){
			df = new java.text.DecimalFormat("0.00");
			return df.format(Double.parseDouble(x));
		}else if("5".equals(v)||"5.0".equals(v)){
			df = new java.text.DecimalFormat("0.00000");
			return df.format(Double.parseDouble(x));
		}else if("0".equals(v)||"0.0".equals(v)){
			df = new java.text.DecimalFormat("0");
			return df.format(Double.parseDouble(x));
		}else{
			return x;   
		}
	}

    /** 
	* @Title: dateRise 
	* @Description: 在原有时间基础上，增长riseMillis个毫秒数
	* @param curDate 原时间
	* @param riseMillis 偏移量（毫秒）
	* @return String
	* @throws 
	*/
	public static String dateRise(String curDate,long riseMillis){
		if(curDate == null || "".equals(curDate)){
			return "";
		}else{
			if(riseMillis == 0){
				return curDate;
			}
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String newDate = "";
		try {
			Date s = sf.parse(curDate);
			long new_date = s.getTime()+riseMillis;
			s.setTime(new_date);
			newDate = sf.format(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
	}

	/**
	 * 本周周一
	 * @param date
	 * @return
	 */
	public static Date getMondayOfThisWeek(Date date) {
		Calendar c = Calendar.getInstance();
		if(date != null) {
			c.setTime(date);
		}
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 1);
		return c.getTime();
	}

	/**
	 * 本周周日
	 * @param date
	 * @return
	 */
	public static Date getSundayOfThisWeek(Date date) {
		Calendar c = Calendar.getInstance();
		if(date != null) {
			c.setTime(date);
		}
		int day_of_week = c.get(Calendar.DAY_OF_WEEK);
		if (day_of_week == 0)
			day_of_week = 7;
		c.add(Calendar.DATE, -day_of_week + 8);
		return c.getTime();
	}
}