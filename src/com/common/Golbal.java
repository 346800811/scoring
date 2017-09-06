package com.common;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * 全局常量
 * @author 李英吉
 * @date 2016-04-08
 *
 */
public class Golbal {

	/**当前用户在session中的变量名*/
	public static final String CURRENT_USER = "scUser";
	
	/**标准编码缓存中“全部”的value值*/
	public static final String CACHE_ALL_VALUE = "all";
	
	/**日期格式 yyyy-MM-dd HH:mm:ss*/
	public static final SimpleDateFormat FORMAT_DATE_1 =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**数字格式 0.0000*/
	public static final DecimalFormat FORMAT_DOUBLE_1 = new DecimalFormat("0.0000");
	
	/**Excel文件导出控制类地址*/
	public static final String REQUESTMAPPING_EXCELEXPORT = "/excelExport";
}
