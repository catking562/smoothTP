package taewookim.smoothTP;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class SmoothTP extends JavaPlugin {

    private void startUpdate() {
        BukkitRunnable brunasy = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    p.sendMessage("비동기");
                }
            }
        };brunasy.runTaskTimerAsynchronously(this, 0, 0);
        BukkitRunnable brun = new BukkitRunnable() {
            @Override
            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    p.sendMessage("동기");
                }
            }
        };brun.runTaskTimer(this, 0, 0);
    }

    @Override
    public void onEnable() {
        startUpdate();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
