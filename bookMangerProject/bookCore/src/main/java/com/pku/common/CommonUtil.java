package com.pku.common;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 常用工具类
 * Package : com.yixin.cc.common.util
 * 
 * @author YixinCapital -- chenyuan1
 *		   2016年3月4日 上午9:54:41
 *
 */
public class CommonUtil {

    private static ThreadLocal<SimpleDateFormat> sdfThread = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get() {
            // TODO Auto-generated method stub
            return super.get();
        }

        @Override
        public void set(SimpleDateFormat value) {
            super.set(value);
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            super.remove();
        }

    };

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat value = new SimpleDateFormat(pattern);
        sdfThread.set(value);
        SimpleDateFormat format = sdfThread.get();
        return format.format(date);
    }

    public static Date parseDate(String date, String pattern) throws ParseException {
        SimpleDateFormat value = new SimpleDateFormat(pattern);
        sdfThread.set(value);
        SimpleDateFormat format = sdfThread.get();
        return format.parse(date);
    }
    
    /** 
     * 计算两个日期之间相差的天数 (精确到天)
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static int daysBetween1(Date date1,Date date2)  
    {  
    	Calendar cal = Calendar.getInstance();  
    	cal.setTime(date1);  
    	int i = 0;
    	while(cal.getTime().before(date2)){
    		int m = cal.get(Calendar.MONTH) + 1;
    		System.out.println(m);
    		cal.add(Calendar.DAY_OF_YEAR, 1);
    		i++;
    	}
          
       return --i;   
    }  
    
    
    /**
  	 * 转换List为in的字符串('a','b')
  	 * @param flowList
  	 * @return 
  	 * @author YixinCapital -- sfei
  	 *	       2016年4月9日 下午12:21:27
  	 */
  	public static String transferListStringToIn(List<String> strList) {
  		
  		if(strList == null || strList.size() == 0)
  			return "";
  		
  		String Str = "(";
  		for (int i = 0; i < strList.size(); i++) {

  			Str = Str + "'" + strList.get(i) + "'";
  			if (i == strList.size() - 1) {
  				Str = Str + ")";
  			} else {
  				Str = Str + ",";
  			}

  		}

  		return Str;

  	}
}
