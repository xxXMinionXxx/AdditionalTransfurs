package net.brown_bakers.bakers_transfurs.init;

import net.brown_bakers.bakers_transfurs.client.renderer.LatexFoxRenderer;

import net.ltxprogrammer.changed.entity.ChangedEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

import static net.brown_bakers.bakers_transfurs.init.InitUtils.registerHumanoid;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InitRenderers {
	
	public static final List<EntityType<? extends ChangedEntity>> copyPlayerLayers = new ArrayList<>();
	
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		registerHumanoid(event, InitEntities.LATEX_FOX.get(), LatexFoxRenderer::new );
	}
}
