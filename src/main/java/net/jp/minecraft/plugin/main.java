package net.jp.minecraft.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * entityの破壊をパーミッションで制御するプラグイン
 * @author syokkendesuyo
 */

public class main extends JavaPlugin implements Listener {






	/**
     * プラグインが有効になったときに呼び出されるメソッド
     * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
     */
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }



	@EventHandler
	public void onHangingPlaceEvent(HangingPlaceEvent event) {

		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
		    if (player.hasPermission("gakubuchi.entity.place")) {
		        player.sendMessage(
		        		ChatColor.AQUA
		        		+"[情報]Entityを設置しました。"
		        		);
		    }

		    else{
		    	event.setCancelled(true);
		    	player.sendMessage(
		                ChatColor.AQUA
		                + "[情報]gakubuchi.entity.placeのパーミッションが無い為キャンセルしました。"
		                );
            return;
		    }
		}
		return;
	}

	@EventHandler
	public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {

		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
		    if (player.hasPermission("gakubuchi.entity.break")) {
		        player.sendMessage(
		        		ChatColor.AQUA
		        		+"[情報]Entityを破壊しました。"
		        		);
		    }

		    else{
		    	event.setCancelled(true);
		    	player.sendMessage(
		                ChatColor.AQUA
		                + "[情報]gakubuchi.entity.breakのパーミッションが無い為キャンセルしました。"
		                );
            return;
		    }
		}
		return;
	}

	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {

		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
		    if (player.hasPermission("gakubuchi.entity.damage")) {
		        player.sendMessage(
		        		ChatColor.AQUA
		        		+"[情報]Entityにダメージを与えました。"
		        		);
		    }

		    else{
		    	event.setCancelled(true);
		    	player.sendMessage(
		                ChatColor.AQUA
		                + "[情報]gakubuchi.entity.damageのパーミッションが無い為キャンセルしました。"
		                );
            return;
		    }
		}
		return;
	}

	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {

		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
		    if (player.hasPermission("gakubuchi.entity.interact")) {
		        player.sendMessage(
		        		ChatColor.AQUA
		        		+"[情報]Entityに何かしらの影響を与えました。"
		        		);
		    }

		    else{
		    	event.setCancelled(true);
		    	player.sendMessage(
		                ChatColor.AQUA
		                + "[情報]gakubuchi.entity.interactのパーミッションが無い為キャンセルしました。"
		                );
            return;
		    }
		}
		return;
	}

	@EventHandler
	public void onHangingBreakEvent(HangingBreakEvent event) {

		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
		    if (player.hasPermission("gakubuchi.entity.hanging")) {
		        player.sendMessage(
		        		ChatColor.AQUA
		        		+"[情報]Entityが依存しているブロックを破壊しました。"
		        		);
		    }

		    else{
		    	event.setCancelled(true);
		    	player.sendMessage(
		                ChatColor.AQUA
		                + "[情報]gakubuchi.entity.hangingのパーミッションが無い為キャンセルしました。"
		                );
            return;
		    }
		}
		return;
	}

}