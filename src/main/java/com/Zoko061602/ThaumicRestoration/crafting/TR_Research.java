package com.Zoko061602.ThaumicRestoration.crafting;

import com.Zoko061602.ThaumicRestoration.blocks.TR_Blocks;
import com.Zoko061602.ThaumicRestoration.items.TR_Items;
import com.Zoko061602.ThaumicRestoration.lib.research.AidBase;
import com.Zoko061602.ThaumicRestoration.lib.research.ResearchHelper;
import com.Zoko061602.ThaumicRestoration.main.ThaumicRestoration;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.api.research.ResearchAddendum;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchEntry.EnumResearchMeta;
import thaumcraft.api.research.ResearchStage;
import thaumcraft.api.research.ResearchStage.Knowledge;
import thaumcraft.api.research.theorycraft.TheorycraftCard;

public class TR_Research {

	public static final ResourceLocation backoverlay = new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png");

	public static final ResourceLocation iconRestoration = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_restoration.png");
	public static final ResourceLocation iconWither = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_wither.png");
	public static final ResourceLocation iconAlchemy = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_alchemy.png");
	public static final ResourceLocation iconTrans = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_trans.png");
	public static final ResourceLocation iconFire = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/icon_fire.png");
	public static final ResourceLocation backRestoration = new ResourceLocation(ThaumicRestoration.ModID, "textures/research/tab_restoration.jpg");

    private static ResearchCategory catRestoration;


    private static final EnumKnowledgeType OBSERVATION = EnumKnowledgeType.OBSERVATION;
    private static final EnumKnowledgeType THEORY = EnumKnowledgeType.THEORY;


	public static void createResearch(){

		catRestoration = ResearchCategories.registerCategory("RESTORATION", "FIRSTSTEPS", null, iconRestoration, backRestoration, backoverlay);

		ResearchStage[] stages;
		String[] parents;
		ResearchAddendum[] addenda;

		// Thaumic Readoption
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":restoration.0")
				   .setKnow(new Knowledge(OBSERVATION, catRestoration, 1))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":restoration.1")
				   .build()
			 };

		 parents = new String[] {"FIRSTSTEPS"};

		ResearchHelper.makeReadoptionResearch("RESTORATION", "Thaumic Restoration", 0, 0, iconRestoration, stages, parents, EnumResearchMeta.ROUND);

		// Deco
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":trdeco.0")
				   .setRecipes(TR_Recipes.recipes.get("TR_DECO.1"))
				   .build()
		 };

		 addenda = new ResearchAddendum[] {
				   new ResearchHelper.RAB()
				   .setText("research_addendum."+ThaumicRestoration.ModID+":trdeco.0")
				   .setRecipes(TR_Recipes.recipes.get("TR_DECO.2"),TR_Recipes.recipes.get("TR_DECO.3"))
				   .setResearch("METALLURGY@3")
				   .build()
		 };

		 parents = new String[] {"RESTORATION","!PLANTWOOD"};


		ResearchHelper.makeReadoptionResearch("TR_DECO", "Decorative Blocks", 2, -1, new ItemStack(TR_Blocks.blockGreatwoodFramed), stages, parents, addenda,EnumResearchMeta.HEX);


		// Novice Wand
		 stages = new ResearchStage[]{
			      new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":novicewand.0")
				   .setKnow(new Knowledge(THEORY, ResearchCategories.getResearchCategory("AUROMANCY"), 1),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 1))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":novicewand.1")
				   .setRecipes(TR_Recipes.recipes.get("NOVICEWAND.1"),TR_Recipes.recipes.get("NOVICEWAND.2"),TR_Recipes.recipes.get("NOVICEWAND.3"))
		           .build()
		 };

		 parents = new String[] {"RESTORATION","!PLANTWOOD","METALLURGY@2"};

		ResearchHelper.makeReadoptionResearch("NOVICEWAND", "Novice Wand", -1, -2, new ItemStack(TR_Items.itemWand,1,0), stages, parents);

		// Wand Transmutation
		 stages = new ResearchStage[]{
			      new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":transmutation.0")
				   .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1),new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 1),new Knowledge(OBSERVATION,catRestoration,2))
				   .build(),
				  new ResearchHelper.RSB()
				   .setText("research_stage."+ThaumicRestoration.ModID+":transmutation.1")
		           .build()
		 };

		 parents = new String[] {"NOVICEWAND"};

		ResearchHelper.makeReadoptionResearch("WANDTRANS", "Magic Transmutations", -3, -4, iconTrans, stages, parents,EnumResearchMeta.HIDDEN);


		// Adept Wand
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":adeptwand.0")
				  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3))
				  .setRequiredCraft(new ItemStack(ItemsTC.visResonator))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":adeptwand.1")
				  .setRecipes(TR_Recipes.recipes.get("ADEPTWAND.1"))
	          	  .build(),
		};

		 parents = new String[] {"NOVICEWAND"};

		ResearchHelper.makeReadoptionResearch("ADEPTWAND", "Adept Wand", -4, -2, new ItemStack(TR_Items.itemWand,1,1), stages, parents);

		// Master Wand
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":masterwand.0")
				  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3),new Knowledge(THEORY, catRestoration, 3))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":masterwand.1")
				  .setRecipes(TR_Recipes.recipes.get("MASTERWAND.1"))
	              .build()

		};

		 parents = new String[] {"ADEPTWAND","~INFUSEDTHAUMIUM"};

		ResearchHelper.makeReadoptionResearch("MASTERWAND", "Grandmasters Wand", -7, -2, new ItemStack(TR_Items.itemWand,1,2), stages, parents);

		// Recharge Pedestal
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":recharger.0")
				  .setKnow(new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 2))
				  .setRequiredCraft(new ItemStack(BlocksTC.rechargePedestal))
				  .setWarp(2)
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":recharger.1")
				  .setRecipes(TR_Recipes.recipes.get("RECHARGER.1"))
	              .build()

		};

		 parents = new String[] {"ADEPTWAND","RECHARGEPEDESTAL","METALLURGY@3","BASEINFUSION"};

		ResearchHelper.makeReadoptionResearch("RECHARGER", "Advanced Recharge Pedestal", -5, 0, new ItemStack(TR_Blocks.blockAdvRechargePed), stages, parents);

		//Crystal Infusion
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":crystalinfusion.0")
				  .setKnow(new Knowledge(OBSERVATION,getCategory("AUROMANCY"),3),new Knowledge(THEORY, catRestoration, 2))
				  .setConsumedItems(new ItemStack(BlocksTC.metalBlockThaumium))
				  .setWarp(3)
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":crystalinfusion.1")
				  .setRecipes(TR_Recipes.recipes.get("CRYSTALINFUSION.1"))
	              .build()

		};

		 parents = new String[] {"METALLURGY@3","BASEINFUSION","BASICWAND","READOPTION"};

		ResearchHelper.makeReadoptionResearch("CRYSTALINFUSION", "Crystal Infuser", -2, 2, new ItemStack(TR_Blocks.blockInfuser), stages, parents);

		//Infused Thaumium
		 stages = new ResearchStage[]{
				  new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":infusedthaumium.0")
				  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 2))
				  .build(),
				 new ResearchHelper.RSB()
				  .setText("research_stage."+ThaumicRestoration.ModID+":infusedthaumium.1")
	              .build()

		};

		 parents = new String[] {"METALLURGY@3","CRYSTALINFUSION"};

		ResearchHelper.makeReadoptionResearch("INFUSEDTHAUMIUM", "Infused Thaumium", 1, 2, new ItemStack(TR_Items.itemIngot,1,2), stages, parents);



	//Terra Obsidian
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":terraobsidian.0")
			  .setWarp(1)
			  .setKnow(new Knowledge(THEORY, getCategory("ARTIFICE"), 1))
			  .setConsumedItems(new ItemStack(Blocks.OBSIDIAN,4))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":terraobsidian.1")
			  .setRecipes(TR_Recipes.recipes.get("TERRAOBSIDIAN.1"))
             .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM"};

	ResearchHelper.makeReadoptionResearch("TERRAOBSIDIAN", "Terra Infused Obsidian", 2, 4, new ItemStack(TR_Blocks.blockObsidian), stages, parents);

	//Edged Crystals
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":potioncrystals.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("AUROMANCY"), 3),new Knowledge(OBSERVATION, getCategory("ARTIFICE"), 3),new Knowledge(OBSERVATION, catRestoration, 3))
			  .setWarp(4)
			  .setConsumedItems(new ItemStack(TR_Blocks.blockObsidian,8))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":potioncrystals.1")
           .build()

	};

	 parents = new String[] {"TERRAOBSIDIAN"};


	ResearchHelper.makeReadoptionResearch("POTIONCRYSTALS", "Edged Crystals [WIP]", 2, 6, new ItemStack(TR_Blocks.blockCrystal), stages, parents);

	//Aqua Bucket
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":aquabucket.0")
			  .setKnow(new Knowledge(THEORY, getCategory("ALCHEMY"), 1))
			  .setConsumedItems(new ItemStack(Items.WATER_BUCKET))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":aquabucket.1")
			  .setRecipes(TR_Recipes.recipes.get("AQUABUCKET.1"))
              .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM"};

	ResearchHelper.makeReadoptionResearch("AQUABUCKET", "Aqua Infused Water Bucket", 0, 4, new ItemStack(TR_Items.itemTRBucket), stages, parents);


	/*/Storage Unit
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":storageunit.0")
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":storageunit.1")
           .build()

	};

	 parents = new String[] {"INFUSEDTHAUMIUM","TR_DECO"};

	ResearchHelper.makeReadoptionResearch("STORAGEUNIT", "StorageUnit", 6, 2, new ItemStack(ReadoptedItems.itemTRBucket), stages, parents);
	*/


	//Alchemy
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_alchemy.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1))
			  .build(),
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_alchemy.1")
			  .build()

	};

	 parents = new String[] {"RESTORATION"};

	ResearchHelper.makeReadoptionResearch("TR_ALCHEMY", "Restored Alchemy", 1, -4, iconAlchemy, stages, parents);



	/*/Steel
	if(OreDictionary.doesOreNameExist("nuggetSteel")){
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":steeltrans.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 1))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicReadoption.ModID+":steeltrans.1")
              .build()

	};

	 parents = new String[] {"TR_ALCHEMY"};


	ResearchHelper.makeReadoptionResearch("TR_STEEL", "Steel Transmutation", 4, -3, OreDictionary.getOres("nuggetSteel").get(1), stages, parents);
	}
	*/

	//Ender Pearl
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_ender.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 2),new Knowledge(THEORY, getCategory("AUROMANCY"), 1))
			  .build(),
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_ender.1")
			  .setRecipes(TR_Recipes.recipes.get("TR_ENDER.1"))
              .build()

	};

	 parents = new String[] {"TR_ALCHEMY"};

	ResearchHelper.makeReadoptionResearch("TR_ENDER", "Ender Pearl Duplication", 4, -5, new ItemStack(Items.ENDER_PEARL), stages, parents);

	//Alchemy
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_wither.0")
			  .setKnow(new Knowledge(OBSERVATION, getCategory("ALCHEMY"), 3),new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setWarp(3)
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":tr_wither.1")
			  .setRecipes(TR_Recipes.recipes.get("TR_WITHER.1"))
              .build(),

	};

	 parents = new String[] {"TR_ALCHEMY"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("TR_WITHER", "Skull Corruption", 0, -5, iconWither, stages, parents);

	//Wither Ring
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wither_ring.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Blocks.SKULL,1,1))
			  .setWarp(2)
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wither_ring.1")
			  .setRecipes(TR_Recipes.recipes.get("WITHERRING.1"))
             .build(),

	};

	 parents = new String[] {"READOPTION","INFUSION","METALLURGY@2"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("WITHERRING", "Ring of Wither Protection", -4, 3, new ItemStack(TR_Items.itemWitherRing), stages, parents);

	//Wand Fire
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wandfire.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Items.FLINT_AND_STEEL,1,0))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":wandfire.1")
              .build(),

	};

	 parents = new String[] {"NOVICEWAND"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("WANDFIRE", "Hellfire Overlord", -2, -1, iconFire, stages, parents,EnumResearchMeta.HEX);


	//Toast
	 stages = new ResearchStage[]{
			  new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":toast.0")
			  .setKnow(new Knowledge(THEORY, getCategory("AUROMANCY"), 2))
			  .setConsumedItems(new ItemStack(Items.BREAD,1,64))
			  .build(),
			 new ResearchHelper.RSB()
			  .setText("research_stage."+ThaumicRestoration.ModID+":toast.1")
			  .setRecipes(TR_Recipes.recipes.get("THAUMICTOAST.1"))
             .build(),

	};

	 parents = new String[] {"TR_ALCHEMY"};
	 new ResearchHelper.RAB();

	ResearchHelper.makeReadoptionResearch("THAUMICTOAST", "Thaumic Toast", 3, -3, new ItemStack(TR_Items.itemToast), stages, parents);

   }

	/*private static void createAid() {
	 TheorycraftCard[] cards = new TheorycraftCard[]{
      Card
	 };
		new AidBase(ReadoptedBlocks.blockInfuser, cards);
	}*/

	public static ResearchCategory getCategory(String cat) {
		return ResearchCategories.getResearchCategory(cat);
	}



}