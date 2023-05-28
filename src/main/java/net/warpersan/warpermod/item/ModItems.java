package net.warpersan.warpermod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.warpersan.warpermod.WarperMod;
import net.warpersan.warpermod.sound.ModSounds;

public class ModItems {
    public static final Item CITRINE = registerItem("citrine",
            new Item(new FabricItemSettings()));

    public static final SpringGun SPRING_GUN = new SpringGun(new FabricItemSettings().maxCount(1).maxDamage(520));

    public static final Item KYS_MUSIC = registerItem("kys_music",
            new MusicDiscItem(6, ModSounds.KYS_MUSIC, new FabricItemSettings().maxCount(1), 16));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(WarperMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.COMBAT, SPRING_GUN);
        addToItemGroup(ItemGroups.INGREDIENTS, CITRINE);
        addToItemGroup(ModItemGroup.CITRINE, CITRINE);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerModItems() {
        WarperMod.LOGGER.info("Registering Mod Items for " + WarperMod.MOD_ID);

        addItemsToItemGroup();
    }
}