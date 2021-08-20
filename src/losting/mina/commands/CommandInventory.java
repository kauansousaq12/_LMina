package losting.mina.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandInventory implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof  Player){
            Player p = (Player)sender;
            if(cmd.getName().equalsIgnoreCase("picareta")){
                Inventory picareta = Bukkit.createInventory(p.getPlayer(), 4*9, "§7Picareta Status");
                p.openInventory(picareta);
            }
        }

        return false;
    }
}
