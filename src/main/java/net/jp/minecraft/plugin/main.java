package net.jp.minecraft.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 額縁の管理をパーミッションで制御するプラグイン
 * デバッグ用
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

        //もし左クリック先が額縁なら
        if (event.getEntity() instanceof ItemFrame) {

        	//設置者を取得
        	Player player =(Player)event.getPlayer();

        	//もしgakubuchi.entity.placeのパーミッション名を持っているのなら破壊
        	if(player.hasPermission("gakubuchi.entity.place")){
        		player.sendMessage(
        				ChatColor.AQUA
        				+"[情報]額縁を設置しました。(パーミッション：gakubuchi.entity.place)"
        				);
        	}


        	//gakubuchi.entity.placeを持っていないなら破壊イベントをキャンセル
        	else{
        		event.setCancelled(true);
        		player.sendMessage(
        				ChatColor.AQUA
        				+"[情報]gakubuchi.entity.placeのパーミッションが無い為キャンセルしました。"
        				);
        	}
        }
	}


	@EventHandler
	public void onEntityDamageByEntityEvent(EntityDamageByEntityEvent event) {

        //もし左クリック先が額縁なら
        if (event.getEntity() instanceof ItemFrame) {

        	//ダメージを与えたプレイヤーを取得
        	Player player =(Player)event.getDamager();

        	//もしgakubuchi.entity.damageのパーミッション名を持っているのなら破壊
        	if(player.hasPermission("gakubuchi.entity.damage")){
        		player.sendMessage(
        				ChatColor.AQUA
        				+"[情報]額縁にダメージを与えました。(パーミッション：gakubuchi.entity.damage)"
        				);
        	}


        	//gakubuchi.entity.damageを持っていないなら破壊イベントをキャンセル
        	else{
        		event.setCancelled(true);
        		player.sendMessage(
        				ChatColor.AQUA
        				+"[情報]gakubuchi.entity.damageのパーミッションが無い為キャンセルしました。"
        				);
        	}
        }
	}


	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {

        //もし左クリック先が額縁なら
        if (event.getRightClicked() instanceof ItemFrame) {

        	//ダメージを与えたプレイヤーを取得
        	Player player =(Player)event.getPlayer();

        	//もしgakubuchi.entity.interactのパーミッション名を持っているのなら破壊
        	if(player.hasPermission("gakubuchi.entity.interact")){
        		player.sendMessage(
        				ChatColor.AQUA
        				+"[情報]額縁に影響を与えました。(パーミッション：gakubuchi.entity.interact)"
        				);
        	}


        	//gakubuchi.entity.interactを持っていないなら破壊イベントをキャンセル
        	else{
        		event.setCancelled(true);
        		player.sendMessage(
        				ChatColor.AQUA
        				+"[情報]gakubuchi.entity.interactのパーミッションが無い為キャンセルしました。"
        				);
        	}
        }
	}


	@EventHandler
	public void onHangingBreakByEntityEvent(HangingBreakByEntityEvent event) {

	        //もし左クリック先が額縁なら
	        if (event.getEntity() instanceof ItemFrame) {

	        	//破壊者を取得
	        	Player player =(Player)event.getRemover();

	        	//もしgakubuchi.entity.breakのパーミッション名を持っているのなら破壊
	        	if(player.hasPermission("gakubuchi.entity.break")){
	        		player.sendMessage(
	        				ChatColor.AQUA
	        				+"[情報]額縁を破壊しました。(パーミッション：gakubuchi.entity.break)"
	        				);
	        	}


	        	//gakubuchi.entity.breakを持っていないなら破壊イベントをキャンセル
	        	else{
	        		event.setCancelled(true);
	        		player.sendMessage(
	        				ChatColor.AQUA
	        				+"[情報]gakubuchi.entity.breakのパーミッションが無い為キャンセルしました。"
	        				);
	        	}
	        }

	}
}