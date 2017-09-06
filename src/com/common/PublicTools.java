package com.common;

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
import org.springframework.util.StringUtils;

public class PublicTools {

	public static List<String> getCurrentUser(HttpServletRequest request, Log logger) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<String> scUser = (List<String>) session.getAttribute(Golbal.CURRENT_USER); // 当前用户
		return scUser;
	}
	/**
	 * 向session中添加user信息
	 * @param request
	 */
	public static List<String> setCurrentUser(HttpServletRequest request, com.scoring.model.User user, Log logger) {
		HttpSession session = request.getSession();
		List<String> scUser = new ArrayList<String>();
		// 获得当前时间
		String dbDate = getCurrentDate(null);

		scUser.add("" + user.getId()); // 0 用户ID
		scUser.add(user.getName()); // 1 用户名称
		scUser.add("" + user.getType()); // 2 用户类型
		scUser.add(dbDate); // 3 登录时间

		session.setAttribute(Golbal.CURRENT_USER, scUser);
		return scUser;
	}

	/**
	 * 获取唯一标识（32位）
	 * @return String
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString().replaceAll("-", "");
		return id;
	}

	/**
	 * 获取当前时间
	 * @param format 时间格式,默认yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurrentDate(String format){
		SimpleDateFormat simpleDateFormat = Golbal.FORMAT_DATE_1;
		if(!isEmpty(format)){
			simpleDateFormat = new SimpleDateFormat(format);
		}
		Calendar calendar = Calendar.getInstance();
		return simpleDateFormat.format(calendar.getTime());
	}

	/** 
	* 转换日期为格式化字符串
	* @param date 日期
	* @param format 格式化,默认yyyy-MM-dd HH:mm:ss
	*/
	public static String transfersDateTostr(Date date, String format){
		if(format == null || "".equals(format)){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	/**
	 * 判断字符串的编码
	 */
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				return encode;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				return encode;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				return encode;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				return encode;
			}
		} catch (Exception exception3) {
		}
		return "";
	}

	/**
	 * 将Object类型转化为Sring 
	 */
	public static String cvToString(Object obj) {
		return obj == null ? "" : obj.toString();
	}

	/**
	 * 将Object类型转化为double 
	 */
	public static Double cvToDouble(Object obj) {
		return obj == null ? 0 : Double.parseDouble(obj.toString());
	}

	/**
	 * 将double格式化四位小数
	 */
	public static Double cvToDouble4(Object num) {
		java.text.DecimalFormat df = Golbal.FORMAT_DOUBLE_1;
		String numStr = df.format(cvToDouble(num));
		return Double.parseDouble(numStr);
	}

	/**
	 * 将Object转化为Date型
	 * @param dateObj 日期对象
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date cvToDate(Object dateObj) throws ParseException{
		if(isEmpty(dateObj))
			return null;
		SimpleDateFormat sdf = Golbal.FORMAT_DATE_1;
		Date date = sdf.parse(cvToString(dateObj));
		return date;
	}

	public static boolean isEmpty(Object str){
		return StringUtils.isEmpty(str);
	}

	public static boolean isEmpty(String str) {
		return (str == null || str.length() <= 0);
	}

}