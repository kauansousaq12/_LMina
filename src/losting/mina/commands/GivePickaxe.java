package losting.mina.commands;

import losting.mina.events.Item;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class GivePickaxe implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("pegarpicareta")){
            PlayerInventory inv = p.getInventory();
            ItemStack ITEM = new Item(Material.DIAMOND_PICKAXE).setDisplayName("§aPicareta Global §7(#1)").setLore(
                    "§7", " §7Essa picareta é do servidor", " §7Ela é upavel e isso favorece", " §7muito a sua jogatina"
            ).build();
            inv.addItem(ITEM);
        }
        return false;
    }
}
