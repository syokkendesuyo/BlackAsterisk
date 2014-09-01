package net.jp.minecraft.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * パーミッションを与えるとチャットの前に黒いアスタリスクが付くプラグイン
 * BlackAsterisk
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



    //チャット時のイベント
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event){

		//プレイヤーを取得
		Player player=event.getPlayer();
		if(player.isOp()){
			//OPなら[OP]と付ける
			event.setFormat(ChatColor.GOLD + "[OP]" + ChatColor.RESET  + "<%1$s> %2$s");
		}
		else{
			//パーミッションがあればアスタリスクを付ける
				if(player.hasPermission("blackasterisk.*")){
					//無視する
				}

				else if(player.hasPermission("blackasterisk.lv1")){
					event.setFormat("<" + ChatColor.BLACK + "*" + ChatColor.RESET + "%1$s>: %2$s");
				}
				else if(player.hasPermission("blackasterisk.lv2")){
					event.setFormat("<" + ChatColor.BLACK + "**" + ChatColor.RESET + "%1$s>: %2$s");
				}
				else if(player.hasPermission("blackasterisk.lv3")){
					event.setFormat("<" + ChatColor.BLACK + "***" + ChatColor.RESET + "%1$s>: %2$s");
				}
		}



	}

}