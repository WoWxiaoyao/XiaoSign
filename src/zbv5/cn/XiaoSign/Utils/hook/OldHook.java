package zbv5.cn.XiaoSign.Utils.hook;

import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;
import zbv5.cn.XiaoSign.Main;
import zbv5.cn.XiaoSign.Utils.DateUtil;
import zbv5.cn.XiaoSign.Utils.FileUtils;
import zbv5.cn.XiaoSign.Utils.Util;

public class OldHook extends EZPlaceholderHook
{
    public OldHook(Main xiaosign)
    {
        super(xiaosign, "xiaosign");
    }

    public String onPlaceholderRequest(Player p, String s)
    {
        if (s.equalsIgnoreCase("today"))
        {
            return DateUtil.getNowTime();
        }
        if (s.equalsIgnoreCase("ex"))
        {
            return Integer.toString(Util.getPlayerSignEx(p,"All"));
        }
        if (s.equalsIgnoreCase("monthex"))
        {
            return Integer.toString(Util.getPlayerSignEx(p,"Month"));
        }
        if (s.equalsIgnoreCase("weekex"))
        {
            return Integer.toString(Util.getPlayerSignEx(p,"Week"));
        }
        if (s.equalsIgnoreCase("tonextdaytime"))
        {
            return DateUtil.getToNextDayTime();
        }
        if (s.equalsIgnoreCase("info"))
        {
            return FileUtils.lang.getString("Sign."+Util.CheckPlayerSign(p,DateUtil.WeekDate.get(Integer.toString(DateUtil.getNowWeek()))));
        }
        return null;
    }
}
