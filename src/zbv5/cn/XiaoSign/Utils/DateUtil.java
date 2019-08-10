package zbv5.cn.XiaoSign.Utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil
{
    public static HashMap<String, String> WeekDate = new HashMap<String, String>();
    public static List<String> WeekDateList = new ArrayList<String>();

    public static void  getWeekDate()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();

        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
        {
            cal.add(Calendar.DATE, -1);
        }
        for (int i = 1; i < 8; i++)
        {
            WeekDate.put(Integer.toString(i), dateFormat.format(cal.getTime()));
            WeekDateList.add(dateFormat.format(cal.getTime()));
            Util.Print("&e"+i+": "+dateFormat.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
        }
    }

    public static String getNowTime()
    {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }

    public static int getNowWeek()
    {
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if(dayWeek==1)
        {
            dayWeek = 8;
        }
        return dayWeek-1;
    }
    public static String getDate(String s)
    {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(s);
        return dateFormat.format(date);
    }

    public static String getToNextDayTime()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        double s = (cal.getTimeInMillis() - System.currentTimeMillis())/1000;
        int hh= (int)s/3600;
        int mm=(int)(s%3600)/60;
        int ss=(int)(s%3600)%60;
        return hh+":"+mm+":"+ss;
    }
}
