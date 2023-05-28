package net.warpersan.warpermod.sound;

import net.warpersan.warpermod.WarperMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent KYS_MUSIC = registerSoundEvent("kysnow_music");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(WarperMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}