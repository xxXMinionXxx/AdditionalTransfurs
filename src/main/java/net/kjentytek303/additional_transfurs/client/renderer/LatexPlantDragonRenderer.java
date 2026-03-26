package net.kjentytek303.additional_transfurs.client.renderer;

import net.kjentytek303.additional_transfurs.AdditionalTransfurs;
import net.kjentytek303.additional_transfurs.client.renderer.model.LatexPlantDragonModel;
import net.kjentytek303.additional_transfurs.entity.LatexPlantDragon;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.LatexParticlesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class LatexPlantDragonRenderer extends AdvancedHumanoidRenderer<LatexPlantDragon, LatexPlantDragonModel>
{
	
	public static final ResourceLocation DEFAULT_SKIN_LOCATION = AdditionalTransfurs.modResource("textures/entity/latex_plant_dragon.png");
	
	public LatexPlantDragonRenderer(EntityRendererProvider.Context context) {
		super(context, new LatexPlantDragonModel(context.bakeLayer(LatexPlantDragonModel.LAYER_LOCATION)), ArmorLatexMaleWolfModel.MODEL_SET, 0.5f);
		this.addLayer(new LatexParticlesLayer<>(this, getModel()));
		this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
		this.addLayer(CustomEyesLayer.builder(this, context.getModelSet()).build());
		this.addLayer(GasMaskLayer.forLargeSnouted(this, context.getModelSet()));
	}
	
	@Override
	public ResourceLocation getTextureLocation(LatexPlantDragon entity) {
		return DEFAULT_SKIN_LOCATION;
	}
}