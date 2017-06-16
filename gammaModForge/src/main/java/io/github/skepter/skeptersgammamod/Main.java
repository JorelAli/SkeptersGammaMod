package io.github.skepter.skeptersgammamod;

import org.lwjgl.input.Keyboard;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings.Options;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main {
	
	public static final String MODID = "skeptersgammamod";
	public static final String VERSION = "1.0";

	public static KeyBinding gammaKey = new KeyBinding("Toggle gamma", Keyboard.KEY_G, "Skepter's Gamma Mod");
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		ClientRegistry.registerKeyBinding(gammaKey);
	}

	@SubscribeEvent
	public void onKey(KeyInputEvent event) {
		if (Main.gammaKey.isPressed()) {
			if (Minecraft.getMinecraft().gameSettings.gammaSetting == 1000.0F) {
				Minecraft.getMinecraft().gameSettings.setOptionFloatValue(Options.GAMMA, 1);
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString(ChatFormatting.WHITE + "[" + ChatFormatting.YELLOW + "Skepter's Gamma Mod" + ChatFormatting.WHITE + "] Turned off gamma"));
			} else {
				Minecraft.getMinecraft().gameSettings.setOptionFloatValue(Options.GAMMA, 1000);
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString(ChatFormatting.WHITE + "[" + ChatFormatting.YELLOW + "Skepter's Gamma Mod" + ChatFormatting.WHITE + "] Turned on gamma"));
			}
			Minecraft.getMinecraft().gameSettings.saveOptions();
			Minecraft.getMinecraft().gameSettings.loadOptions();
		}
	}

} 
