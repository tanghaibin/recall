/* 
 * author : lihongliang
 * mail   : 425631071@qq.com
 * phone  : 13558730300
 */
package top.tanghaibin.utils;


import top.tanghaibin.cons.Constants;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Description: 日期时间工具类<br>
 * @author lihonglaing 
 * @date 2015年7月31日 下午2:01:06
 */
public final class DateUtils {

	public static void main(String[] args) {

	}
	
	/**
	 * @Title: DATE_TIME_PATTERN_STR
	 * @Description: 时分表字符串 yyyyMMddHHmmss
	 * @param @return 参数说明
	 * @return String 返回类型 yyyyMMddHHmmss
	 */
	public static String DATE_TIME_PATTERN_STR() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_TIME_PATTERN_STR);
		String dateStr = sf.format(date);
		return dateStr;
	}

	/**cdsds
	 *
	 * @Title: DATE_TIME_PATTERN
	 * @Description: 时分表字符串 yyyy-MM-dd HH:mm:ss
	 * @param @return 参数说明
	 * @return String 返回类型 yyyy-MM-dd HH:mm:ss
	 */
	public static String DATE_TIME_PATTERN() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_TIME_PATTERN);
		String dateStr = sf.format(date);
		return dateStr;
	}

	public static Date DATE_TIME_PATTERN(Date date) throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_TIME_PATTERN);
		String date2 = sf.format(date);
		return sf.parse(date2);
	}
	/**
	 * @Title: DATE_PATTERN
	 * @Description: 年月日时分秒 yyyy-MM-dd
	 * @param @return 参数说明
	 * @return String 返回类型 yyyy-MM-dd
	 */
	public static String DATE_PATTERN() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_PATTERN);
		String dateStr = sf.format(date);
		return dateStr;
	}

	/**
	 * @Title: DATE_PATTERN1
	 * @Description: 年月日时分秒 yyyyMMdd
	 * @param @return 参数说明
	 * @return String 返回类型 yyyyMMdd
	 */
	public static String DATE_PATTERN1() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(Constants.DATE_PATTERN1);
		String dateStr = sf.format(date);
		return dateStr;
	}

	/**
	 * @Title: getNewDates
	 * @Description: 获取现在时间 yyyy-MM-dd HH:mm:ss
	 * @param @return 参数说明
	 * @return Date 返回类型 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNewDates() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
    * 利用SimpleDateFormat 将Str格式转换成Date
    * @param str
    * @return
    */
   public Date formatByString(String str) {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       sdf.setLenient(false); // 是否是严格的匹配
       Date date = null;
       try {
           date = sdf.parse(str);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return date;
   }
}
