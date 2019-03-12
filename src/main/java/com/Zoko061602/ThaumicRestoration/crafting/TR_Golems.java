package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import static thaumcraft.api.golems.EnumGolemTrait.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.golems.EnumGolemTrait;
import thaumcraft.api.golems.parts.GolemMaterial;
import thaumcraft.api.items.ItemsTC;

public class TR_Golems {

	public static GolemMaterial materialTallow;
	public static GolemMaterial materialSilverwood;
	public static GolemMaterial materialAer;
	public static GolemMaterial materialIgnis;
	public static GolemMaterial materialAqua;
	public static GolemMaterial materialTerra;
	public static GolemMaterial materialOrdo;
	public static GolemMaterial materialPerditio;

	public static void addGolems() {

	   String[] res = new String[]{"MATSTUD_TALLOW"};
	   ResourceLocation tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_tallow.png");
	   EnumGolemTrait[] tags = new EnumGolemTrait[]{CLUMSY,LIGHT};
       materialTallow = new GolemMaterial("tr_tallow", res, tex, 0xDEA340, 20, 6, 2, new ItemStack(ItemsTC.tallow,3), new ItemStack(ItemsTC.mechanismSimple), tags);

       res = new String[]{"MATSTUD_SILVERWOOD"};
	   tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_silverwood.png");
	   tags = new EnumGolemTrait[]{LIGHT, DEFT};
       materialSilverwood = new GolemMaterial("tr_silverwood", res, tex, 0xE7DBC4, 20, 9, 1, new ItemStack(BlocksTC.plankSilverwood), new ItemStack(ItemsTC.mechanismSimple), tags);

       res = new String[]{"MATSTUD_INFUSEDTHAUMIUM"};
	   tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_thaumium_aer.png");
	   tags = new EnumGolemTrait[]{LIGHT,BLASTPROOF,FIREPROOF,FLYER};
       materialAer = new GolemMaterial("tr_thaumium_aer", res, tex, 0xF3F45F, 30, 10, 5, new ItemStack(TR_Items.itemPlate,1,0), new ItemStack(ItemsTC.mechanismComplex), tags);

       tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_thaumium_ignis.png");
	   tags = new EnumGolemTrait[]{HEAVY, BLASTPROOF, FIREPROOF, BRUTAL};
       materialIgnis = new GolemMaterial("tr_thaumium_ignis", res, tex, 0xF45000, 30, 10, 5, new ItemStack(TR_Items.itemPlate,1,1), new ItemStack(ItemsTC.mechanismComplex), tags);

       tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_thaumium_aqua.png");
	   tags = new EnumGolemTrait[]{HEAVY, BLASTPROOF, FIREPROOF, REPAIR};
       materialAqua = new GolemMaterial("tr_thaumium_aqua", res, tex, 0x31CAE0, 30, 10, 5, new ItemStack(TR_Items.itemPlate,1,2), new ItemStack(ItemsTC.mechanismComplex), tags);

       tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_thaumium_terra.png");
	   tags = new EnumGolemTrait[]{HEAVY, BLASTPROOF, FIREPROOF, ARMORED};
       materialTerra = new GolemMaterial("tr_thaumium_terra", res, tex, 0x4BB600, 30, 10, 5, new ItemStack(TR_Items.itemPlate,1,3), new ItemStack(ItemsTC.mechanismComplex), tags);

       tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_thaumium_ordo.png");
	   tags = new EnumGolemTrait[]{HEAVY, BLASTPROOF, FIREPROOF, SCOUT};
       materialOrdo = new GolemMaterial("tr_thaumium_ordo", res, tex, 0xEBECFF, 30, 10, 5, new ItemStack(TR_Items.itemPlate,1,4), new ItemStack(ItemsTC.mechanismComplex), tags);

       tex = new ResourceLocation(ThaumicRestoration.ModID, "textures/entity/golems/mat_thaumium_perditio.png");
	   tags = new EnumGolemTrait[]{HEAVY, BLASTPROOF, FIREPROOF};
       materialPerditio = new GolemMaterial("tr_thaumium_perditio", res, tex, 0x5A5A5A, 30, 10, 5, new ItemStack(TR_Items.itemPlate,1,5), new ItemStack(ItemsTC.mechanismComplex), tags);

       GolemMaterial.register(materialTallow);
       GolemMaterial.register(materialSilverwood);
       GolemMaterial.register(materialAer);
       GolemMaterial.register(materialIgnis);
       GolemMaterial.register(materialAqua);
       GolemMaterial.register(materialTerra);
       GolemMaterial.register(materialOrdo);
       GolemMaterial.register(materialPerditio);

	}

}