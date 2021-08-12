package riyaya1528.paper.clientcrasher;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClientCrasher extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        registerCommands();

        System.out.println("[ClientCrasher]The plugin has been enable.");
    }

    @Override
    public void onDisable() {
        System.out.println("[ClientCrasher]The plugin has been disable.");
    }

    public void registerCommands() {
        getCommand("crash").setExecutor(new Commands());
    }


}
