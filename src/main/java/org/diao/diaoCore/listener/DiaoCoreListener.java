package org.diao.diaoCore.listener;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.diao.diaoCore.Main; // 仍然需要 Main 实例来获取 Logger
import yslelf.cloudpick.bukkit.api.PacketSender; // 导入 CloudPick API 的 PacketSender
import yslelf.cloudpick.bukkit.api.event.CustomPacketEvent; // 导入 CloudPick API 的 CustomPacketEvent

import java.util.Arrays;

/**
 * DiaoCore 插件的事件监听器。
 * 负责监听和处理各种游戏事件。
 */
public class DiaoCoreListener implements Listener {

    private final Main plugin;

    public DiaoCoreListener(Main plugin) {
        this.plugin = plugin;
    }

    /**
     * 监听玩家击杀生物事件。
     * 当玩家击杀生物时，通过 CloudPick API 发送击杀信息给客户端。
     * @param event 实体死亡事件
     */
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        // 获取死亡的实体
        LivingEntity killedEntity = event.getEntity();
        // 获取杀死了实体的玩家
        Player killer = killedEntity.getKiller();

        // 如果有玩家击杀了生物
        if (killer != null) {
            // 检查 CloudPick 插件是否启用，因为 PacketSender 依赖于它
            if (plugin.getServer().getPluginManager().getPlugin("CloudPick") != null && plugin.getServer().getPluginManager().getPlugin("CloudPick").isEnabled()) {
                // 获取被击杀实体的显示名称
                String entityName = killedEntity.getName();
                // 获取击杀玩家的名称
                String killerName = killer.getName();

                // 直接通过 CloudPick API 发送数据给客户端
                // 标识符: diaocore_kill
                // 数据: 被击杀实体名称, 击杀玩家名称
                PacketSender.sendCustomData(killer, "diaocore_kill", entityName, killerName);

                // 插件日志输出，方便调试
                plugin.getLogger().info(String.format("玩家 %s 击杀了 %s, 已通过 diaocore_kill 发送至客户端。", killerName, entityName));
            } else {
                plugin.getLogger().warning("尝试发送击杀信息到客户端，但 CloudPick 插件未启用或未安装！");
            }
        }
    }
}