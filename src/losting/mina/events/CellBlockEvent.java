package losting.mina.events;

import losting.mina.actionbarapi.ActionBarAPI;
import losting.mina.vaultapi.VaultAPI;
import net.milkbowl.vault.Vault;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class CellBlockEvent implements Listener {


    @EventHandler
    public void breakblockCell(BlockBreakEvent e){
        Block b = e.getBlock();
        Player p = e.getPlayer();
        double lapis_ore = 125;
        if(e.getBlock().getType() == Material.LAPIS_ORE) { // quando a fortuna ser upada o preço ali do bloco aumentar '-'
               double price = e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) * lapis_ore;
                VaultAPI.getEconomy().depositPlayer((OfflinePlayer) p, price);
                ActionBarAPI.sendActionbar(p, "§2$§a" + price + " §7➥ §e+1 §fBloco");
                e.getBlock().setType(Material.AIR);

            }
        }
    }
