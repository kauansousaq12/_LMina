package losting.mina;

import losting.mina.actionbarapi.ActionBarAPI;
import losting.mina.actionbarapi.ActionBarMessageEvent;
import losting.mina.actionbarapi.CLUpdate;
import losting.mina.commands.CommandInventory;
import losting.mina.commands.GivePickaxe;
import losting.mina.events.CellBlockEvent;
import losting.mina.events.ClickPickaxeEvent;
import losting.mina.events.Reflections;
import losting.mina.events.SkullAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void getPlugin(Main plugin){
        plugin.getPlugin(plugin);
    }


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aSeu plugin de mina foi ativado com sucesso");
        getCommand("picareta").setExecutor(new CommandInventory());
        getCommand("pegarpicareta").setExecutor(new GivePickaxe());
        SkullAPI.load();
        Reflections.loadUtils();
        Bukkit.getServer().getPluginManager().registerEvents(new ClickPickaxeEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CellBlockEvent(), this);
    }
}
