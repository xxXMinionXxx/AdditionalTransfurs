package net.kjentytek303.additional_transfurs.init;

import net.foxyas.changedaddon.init.ChangedAddonAbilities;
import net.kjentytek303.additional_transfurs.AdditionalTransfurs;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber( bus= Mod.EventBusSubscriber.Bus.MOD, modid=AdditionalTransfurs.MODID)
public class QuickAndDirtyAbilityAdder {

	@SubscribeEvent
	public static void addAbilitiesFromOtherMods(TransfurVariant.UniversalAbilitiesEvent event) {
		if ( ModList.get().isLoaded("changed_addon")) {
			event.addAbility( (entityType) -> entityType.equals(InitEntities.LATEX_PLANT_DRAGON.get()), ChangedAddonAbilities.WING_FLAP_ABILITY );
		}
	}
}