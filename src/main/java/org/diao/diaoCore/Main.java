package org.diao.diaoCore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.diao.diaoCore.command.DiaoCommand;
import org.diao.diaoCore.listener.DiaoCoreListener;

// 不再需要直接导入 PacketSender，因为它不再在 Main 类中直接使用
// import yslelf.cloudpick.bukkit.api.PacketSender;

/**
 * 大貂核心 (DiaoCore) 插件的主类
 * 负责插件的加载、卸载、初始化各个模块以及提供核心对象的访问。
 * 该插件的用处是处理频繁任务，减少插件编写时的重复任务。
 *
 * 作者: 止
 * 团队: 大貂team
 */
public final class Main extends JavaPlugin {

    // 单例模式，方便其他插件获取 DiaoCore 的实例
    private static Main instance;

    /**
     * 获取 DiaoCore 插件的实例。
     * @return DiaoCore 插件实例
     */
    public static Main getInstance() {
        return instance;
    }

    /**
     * 当插件被启用时调用。
     * 这是插件所有功能的入口点。
     */
    @Override
    public void onEnable() {
        instance = this; // 设置单例实例

        // --- 狂拽酷炫的加载提示 ---
        ConsoleCommandSender console = Bukkit.getConsoleSender();

        console.sendMessage(ChatColor.YELLOW + "************************************************************");
        console.sendMessage(ChatColor.YELLOW + "*");
        console.sendMessage(ChatColor.YELLOW + "*    " + ChatColor.AQUA + "██████╗   ██╗   █████╗   ██████╗    " + ChatColor.GOLD + "大貂核心");
        console.sendMessage(ChatColor.YELLOW + "*    " + ChatColor.AQUA + "██╔══██╗  ██║  ██╔══██╗ ██╔═══██╗   " + ChatColor.GRAY + "(DiaoCore)");
        console.sendMessage(ChatColor.YELLOW + "*    " + ChatColor.AQUA + "██║  ██║  ██║  ███████║ ██║   ██║");
        console.sendMessage(ChatColor.YELLOW + "*    " + ChatColor.AQUA + "██║  ██║  ██║  ██╔══██║ ██║   ██║   " + ChatColor.GREEN + "作者: 止");
        console.sendMessage(ChatColor.YELLOW + "*    " + ChatColor.AQUA + "██████╔╝  ██║  ██║  ██║ ╚██████╔╝   " + ChatColor.GREEN + "团队: 大貂team");
        console.sendMessage(ChatColor.YELLOW + "*    " + ChatColor.AQUA + "╚═════╝   ╚═╝  ╚═╝  ╚═╝  ╚═════╝ ");
        console.sendMessage(ChatColor.YELLOW + "*");
        console.sendMessage(ChatColor.YELLOW + "*      " + ChatColor.WHITE + "正在启动, 请稍候...");
        console.sendMessage(ChatColor.YELLOW + "*");
        console.sendMessage(ChatColor.YELLOW + "************************************************************");

        // --- 前置插件检测 ---
        if (getServer().getPluginManager().getPlugin("CloudPick") == null) {
            getLogger().warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            getLogger().warning("! [警告] 未找到前置插件: CloudPick !");
            getLogger().warning("! 大貂核心插件依赖 CloudPick 插件进行客户端通信。");
            getLogger().warning("! 部分功能 (例如客户端通信) 将无法使用。");
            getLogger().warning("! 请确保您已将 CloudPick-Bukkit.jar 放入 plugins 文件夹。");
            getLogger().warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            getLogger().info("[DiaoCore] 成功挂钩到前置插件 CloudPick, 客户端通信功能已启用。");
        }

        // 1. 保存默认配置文件 (如果未来需要配置文件)
        // saveDefaultConfig();

        // 2. 注册命令处理器
        getCommand("diao").setExecutor(new DiaoCommand());

        // 3. 注册事件监听器
        getServer().getPluginManager().registerEvents(new DiaoCoreListener(this), this);

        getLogger().info("[DiaoCore] 插件已成功启用！");
    }

    /**
     * 当插件被禁用时调用。
     */
    @Override
    public void onDisable() {
        instance = null; // 清除单例实例

        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(ChatColor.RED + "************************************************************");
        console.sendMessage(ChatColor.RED + "*");
        console.sendMessage(ChatColor.RED + "*      " + ChatColor.AQUA + "大貂核心 (DiaoCore)");
        console.sendMessage(ChatColor.RED + "*");
        console.sendMessage(ChatColor.RED + "*      " + ChatColor.WHITE + "插件已成功卸载。");
        console.sendMessage(ChatColor.RED + "*      " + ChatColor.GRAY + "感谢您的使用, 后会有期!");
        console.sendMessage(ChatColor.RED + "*");
        console.sendMessage(ChatColor.RED + "************************************************************");

        getLogger().info("[DiaoCore] 插件已成功禁用！");
    }
}