package zbv5.cn.XiaoSign;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import zbv5.cn.XiaoSign.Command.MainCommand;
import zbv5.cn.XiaoSign.Listener.PlayerListener;
import zbv5.cn.XiaoSign.Utils.DateUtil;
import zbv5.cn.XiaoSign.Utils.FileUtils;
import zbv5.cn.XiaoSign.Utils.Util;
import zbv5.cn.XiaoSign.bStats.Metrics;

/**
 * @author wow_xiaoyao
 */

public class Main extends JavaPlugin
{
    private static Main instance;
    public static boolean PlaceholderAPI = false;
    public static boolean VexView = false;

    public static Main getInstance()
    {
        return instance;
    }

    @Override
    public void onEnable()
    {
        instance = this;
        FileUtils.LoadConfig();
        FileUtils.LoadData();
        Util.CheckPlugin();
        DateUtil.getWeekDate();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("XiaoSign").setExecutor(new MainCommand());

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
        {
            public void run()
            {
                if(DateUtil.getDate("HH:mm:ss").equals("00:00:00"))
                {
                    DateUtil.getWeekDate();
                }
            }
        }, 20L, 20L);

        int pluginId = 7410;
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        Util.Print("&a插件加载完成");
    }
    @Override
    public void onDisable()
    {
        Util.Print("&c插件卸载");
    }
}
