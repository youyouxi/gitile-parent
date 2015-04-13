package com.gitile.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 */
public class DateUtils {
	
	public final static DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
	public final static DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static DateFormat df3 = new SimpleDateFormat("yyyyMMddHHmmss");
	public final static DateFormat df4 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
	public final static DateFormat df5 = new SimpleDateFormat("yyyy年MM月dd日");
	public final static DateFormat df6 = new SimpleDateFormat("yyyy年");
	public final static DateFormat df7 = new SimpleDateFormat("yyyy年MM月");
	public final static DateFormat df8 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static String dateToString(Date date, int df) {
		switch (df) {
		case 1:
			return df1.format(date);
		case 2:
			return df2.format(date);
		case 3:
			return df3.format(date);
		case 4:
			return df4.format(date);
		case 5:
			return df5.format(date);	
		case 6:
			return df6.format(date);
		case 7:
			return df7.format(date);
		case 8:
			return df8.format(date);
		default:
			return df2.format(date);
		}
	}
	
	public static Date stringToDate(String date, int df){
		try {
			switch (df) {
			case 1:
				return df1.parse(date);
			case 2:
				return df2.parse(date);
			case 3:
				return df3.parse(date);
			case 4:
				return df4.parse(date);
			case 5:
				return df5.parse(date);	
			case 6:
				return df6.parse(date);
			case 7:
				return df7.parse(date);
			case 8:
				return df8.parse(date);
			default:
				return df2.parse(date);
			}
		} catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 时间间隔（分钟）
	 * @param start
	 * @param end
	 * @return
	 */
	public static long minuteBetween(Date start, Date end) {
		long d1 = start.getTime();
        long d2 = end.getTime();
        long interval=(d2-d1)/1000;//秒
        long minute=interval%3600/60;//分钟
        if(minute>0) {
        	return minute;
        }
        return 0;
	}
	
}
