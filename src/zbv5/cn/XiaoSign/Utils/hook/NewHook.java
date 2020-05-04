package zbv5.cn.XiaoSign.Utils.hook;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import zbv5.cn.XiaoSign.Main;
import zbv5.cn.XiaoSign.Utils.DateUtil;
import zbv5.cn.XiaoSign.Utils.FileUtils;
import zbv5.cn.XiaoSign.Utils.Util;

public class NewHook extends PlaceholderExpansion
{
    private final Main plugin;

    public NewHook(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor()
    {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier() {
        return "xiaosign";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onPlaceholderRequest(Player p, String s) {

        if (p == null) return "null_player";

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
        return "";
    }
}
