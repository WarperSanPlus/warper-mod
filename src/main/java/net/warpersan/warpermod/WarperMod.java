package net.warpersan.warpermod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.warpersan.warpermod.item.ModItemGroup;
import net.warpersan.warpermod.item.ModItems;
import net.warpersan.warpermod.item.SpringGun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WarperMod implements ModInitializer {
    public static final String MOD_ID = "warpermod";

    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("warpermod");


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");
        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();
        Registry.register(Registries.ITEM, new Identifier("warpermod", "spring_gun"), ModItems.SPRING_GUN);
    }
}