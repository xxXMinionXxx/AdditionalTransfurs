package net.kjentytek303.additional_transfurs.client.renderer.model.armor;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kjentytek303.additional_transfurs.AdditionalTransfurs;
import net.ltxprogrammer.changed.client.renderer.animate.AnimatorPresets;
import net.ltxprogrammer.changed.client.renderer.animate.HumanoidAnimator;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorModelSet;
import net.ltxprogrammer.changed.client.renderer.model.armor.LatexHumanoidArmorModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;


public class PenguinChestFeetArmorModel<T extends ChangedEntity> extends LatexHumanoidArmorModel<T, PenguinChestFeetArmorModel<T>> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(AdditionalTransfurs.modResource(""), "main");
	public static final ArmorModelSet<ChangedEntity, PenguinChestFeetArmorModel<ChangedEntity>> MODEL_SET = ArmorModelSet.of(AdditionalTransfurs.modResource("armor_penguin_chestfeet"), PenguinChestFeetArmorModel::createArmorLayer, PenguinChestFeetArmorModel::new);
	private final ModelPart RightLeg;
	private final ModelPart RightPad;
	private final ModelPart LeftLeg;
	private final ModelPart LeftPad;
	private final ModelPart Head;
	private final ModelPart Torso;
	private final ModelPart Tail;
	private final ModelPart TailPrimary;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final HumanoidAnimator<T, PenguinChestFeetArmorModel<T>> animator;

	public PenguinChestFeetArmorModel(ModelPart root, ArmorModel model) {
		super(root, model);
		this.RightLeg = root.getChild("RightLeg");
		this.RightPad = this.RightLeg.getChild("RightPad");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftPad = this.LeftLeg.getChild("LeftPad");
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.Tail = this.Torso.getChild("Tail");
		this.TailPrimary = this.Tail.getChild("TailPrimary");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		animator = HumanoidAnimator.of(this).hipOffset(-1.5f)
			.legLength(2.0f)
			.torsoLength(17.0f)
			.addPreset(AnimatorPresets.humanLike(
				Head,

				Torso, LeftArm, RightArm,
				/*PERL_ABDOMEN_STUFF*/

				LeftLeg, RightLeg
				/*PERL_WINGED_STUFF*/
			))/*PERL_ADDITIONAL_ANIMATORS*/;
	}
	@Override
	public HumanoidAnimator<T, ?> getAnimator(T t) {
		return this.animator;
	}

	@Override
	public ModelPart getHead() { return this.Head; }

	@Override
	public ModelPart getArm(HumanoidArm humanoidArm) {
		return humanoidArm == HumanoidArm.LEFT ? this.LeftArm : this.RightArm;
	}
	@Override
	public ModelPart getLeg(HumanoidArm humanoidArm) {
		return humanoidArm == HumanoidArm.LEFT ? this.LeftLeg : this.RightLeg;
	}

	public static LayerDefinition createArmorLayer(ArmorModel layer) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.5F, 19.85F, 0.5F));

		PartDefinition RightArch_r1 = RightLeg.addOrReplaceChild("RightArch_r1", CubeListBuilder.create().texOffs(34, 0).mirror().addBox(-2.0F, -0.8F, -1.3628F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, 0.7F, -0.525F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RightPad = RightLeg.addOrReplaceChild("RightPad", CubeListBuilder.create().texOffs(46, 0).addBox(-2.0F, -1.0F, -3.3F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.02F)), PartPose.offset(0.0F, 3.15F, -1.375F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.5F, 19.85F, 0.5F));

		PartDefinition LeftArch_r1 = LeftLeg.addOrReplaceChild("LeftArch_r1", CubeListBuilder.create().texOffs(34, 0).addBox(-1.0F, -0.8F, -1.3628F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.7F, -0.525F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftPad = LeftLeg.addOrReplaceChild("LeftPad", CubeListBuilder.create().texOffs(46, 0).addBox(-2.0F, -1.0F, -3.3F, 4.0F, 2.0F, 5.0F, new CubeDeformation(-0.02F)), PartPose.offset(0.0F, 3.15F, -1.375F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 23).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-4.5F, 1.0F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-5.0F, 2.0F, -3.0F, 10.0F, 13.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-4.5F, 15.0F, -2.5F, 9.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-4.0F, 18.0F, -2.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.001F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Tail = Torso.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 10.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition TailPrimary = Tail.addOrReplaceChild("TailPrimary", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r1 = TailPrimary.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(48, 39).mirror().addBox(-4.0F, 0.75F, -0.5F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9635F, 0.0F, -3.1416F));

		PartDefinition Base_r2 = TailPrimary.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(48, 39).addBox(-4.0F, 0.75F, -0.5F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9635F, 0.0F, 3.1416F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(36, 7).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 6.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(36, 7).mirror().addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	/*
	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	*/

	@Override
	public void renderForSlot(T t, RenderLayerParent<? super T, ?> renderLayerParent, ItemStack itemStack, EquipmentSlot equipmentSlot, PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2, float v3) {
		poseStack.pushPose();
		this.scaleForSlot(renderLayerParent, equipmentSlot, poseStack);

		switch (equipmentSlot) {
			case HEAD -> Head.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3 );
			case CHEST -> {
				Torso.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3 );
				RightArm.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3 );
				LeftArm.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3 );
			}
			case LEGS -> {}
			case FEET -> {
				LeftLeg.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3 );
				RightLeg.render(poseStack, vertexConsumer, i, i1, v, v1, v2, v3 );
			}
		}

		poseStack.popPose();
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	@Override
	public ModelPart getTorso() {
		return this.Torso;
	}
}