package org.diao.diaoCore.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * 处理 /diao 命令的执行器。
 * 当玩家输入 /diao 时，将返回一个 "oIo" 艺术字。
 */
public class DiaoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 检查命令是否是 "diao"
        if (command.getName().equalsIgnoreCase("diao")) {
            // 发送 oIo 艺术字给命令发送者
            sender.sendMessage(ChatColor.AQUA + " _   _  ");
            sender.sendMessage(ChatColor.AQUA + "| | | | ");
            sender.sendMessage(ChatColor.AQUA + "| |_| | ");
            sender.sendMessage(ChatColor.AQUA + " \\__, | ");
            sender.sendMessage(ChatColor.AQUA + "    |_| ");
            return true; // 命令已成功处理
        }
        return false; // 命令未被处理 (理论上不会到达这里，因为 plugin.yml 已经注册了)
    }
}