package losting.mina.events;

import losting.mina.vaultapi.VaultAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClickPickaxeEvent implements Listener {

    @EventHandler
    public void pickaxeClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        ItemStack ITEM = new Item(Material.DIAMOND_PICKAXE).setDisplayName("§aPicareta Global §7(#1)").setLore(
                "§7", " §7Essa picareta é do servidor", " §7Ela é upavel e isso favorece", " §7muito a sua jogatina"
        ).build();
        int chance1 = new Chance().nextInt(0,100);
        double chance = 20;
        Action a = e.getAction();
            if(p.getItemInHand().getType() == Material.DIAMOND_PICKAXE && p.getItemInHand().hasItemMeta()){
                if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                        Inventory status = Bukkit.createInventory(p.getPlayer(), 4 * 9, "Upamento...");
                        ItemStack ENCHANT_ONE = new Item(SkullAPI.getByUrl(
                                "http://textures.minecraft.net/texture/93a69c3caa31304e9952328c72cee0b57b2a2bd46ce9c5cb88c07d1266277d6a"
                        )).setDisplayName(
                                "§aEficiência"
                        ).build();
                        ItemStack ENCHANT_TWO = new Item(SkullAPI.getByUrl(
                                "http://textures.minecraft.net/texture/1c030cc35fde0218ded5ba5d557cca9e03dcbc84f9e672911da54fe07c5fdbbb"
                        )).setDisplayName(
                                "§aFortuna §7➥ §f" + e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS)
                        ).build();
                        ItemStack NO2 = new Item(SkullAPI.getByUrl(
                                "http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"
                        )).setDisplayName(
                                "§cEm Breve"
                        ).build();
                        ItemStack NO3 = new Item(SkullAPI.getByUrl(
                                "http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"
                        )).setDisplayName(
                                "§cEm Breve"
                        ).build();
                        ItemStack NO4 = new Item(SkullAPI.getByUrl(
                                "http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025"
                        )).setDisplayName(
                                "§cEm Breve"
                        ).build();
                        ItemStack ITEM_PICKAXE = new Item(Material.DIAMOND_PICKAXE).setDisplayName("§aPicareta Global §7(#1)").setLore(
                                "§7", " §7Essa picareta é do servidor", " §7Ela é upavel e isso favorece", " §7muito a sua jogatina"
                        ).build();
                        status.setItem(11, ENCHANT_ONE);
                        status.setItem(12, ENCHANT_TWO);
                        status.setItem(13, NO2);
                        status.setItem(14, NO3);
                        status.setItem(15, NO4);


                        p.openInventory(status);
                }
        }

    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {//exporta
        if(e.getInventory().getTitle().equalsIgnoreCase("Upamento...")) {
            e.setCancelled(true);//qual a slot
            if (e.getRawSlot() == 11){

                if (e.getWhoClicked().getInventory().getItemInHand().getType() != Material.DIAMOND_PICKAXE) {
                    e.getWhoClicked().sendMessage("§cVocê precisa estar segurando uma picareta de diamante para usar o upgrade!");
                    return;
                }

                if(e.getWhoClicked().getInventory().getItemInHand().getEnchantmentLevel(Enchantment.DIG_SPEED) >= 5) {
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage("§cNível máximo atingido!");
                    return;
                }

                int level = e.getWhoClicked().getItemInHand().getEnchantmentLevel(Enchantment.DIG_SPEED);
                double price = level * 1500;



                if(!VaultAPI.getEconomy().has((Player) e.getWhoClicked(), price)) {
                    e.getWhoClicked().sendMessage("§cVocê não possui dinheiro suficiente para isso!");
                    return;
                }

                if (!e.getWhoClicked().getInventory().getItemInHand().containsEnchantment(Enchantment.DIG_SPEED)) {
                    e.getWhoClicked().getInventory().getItemInHand().addEnchantment(Enchantment.DIG_SPEED, 1);

                } else {
                    int old = e.getWhoClicked().getItemInHand().getEnchantmentLevel(Enchantment.DIG_SPEED);
                    int newE = old + 1;
                    e.getWhoClicked().getInventory().getItemInHand().removeEnchantment(Enchantment.DIG_SPEED);
                    e.getWhoClicked().getInventory().getItemInHand().addEnchantment(Enchantment.DIG_SPEED, newE);
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage("§f" + "§aVocê deu um upgrade de eficiência em sua picareta com sucesso! §7Nível antigo: §f" + old + " §7Novo nível: §f" + newE + "§f");
                }

            }

            if(e.getRawSlot() == 12){
                if(e.getWhoClicked().getInventory().getItemInHand().getType() != Material.DIAMOND_PICKAXE){
                    e.getWhoClicked().sendMessage("§cVocê precisa estar segurando uma picareta de diamante para usar o upgrade!");
                    return;
                }
                if(e.getWhoClicked().getInventory().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) >= 3) {
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage("§cNivel máximo atigido!");
                    return;
                }
                if(!e.getWhoClicked().getInventory().getItemInHand().containsEnchantment(Enchantment.LOOT_BONUS_BLOCKS)){
                    e.getWhoClicked().getInventory().getItemInHand().addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1);
                } else {
                    int old2 = e.getWhoClicked().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                    int newF = old2 + 1;
                    e.getWhoClicked().getInventory().getItemInHand().removeEnchantment(Enchantment.LOOT_BONUS_BLOCKS);
                    e.getWhoClicked().getInventory().getItemInHand().addEnchantment(Enchantment.LOOT_BONUS_BLOCKS, newF);
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage("§aVocê deu um upgrade de fortuna em sua picareta com sucesso! §7Nível antigo: §f" + old2 + " §7Novo nível: §f" + newF);
                }
            }
        }
        }
    }



