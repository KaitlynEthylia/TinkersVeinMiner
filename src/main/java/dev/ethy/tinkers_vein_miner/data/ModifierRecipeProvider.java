package dev.ethy.tinkers_vein_miner.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;
import slimeknights.mantle.recipe.data.IRecipeHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import java.util.function.Consumer;

import static dev.ethy.tinkers_vein_miner.TinkersVeinMiner.MODID;
import static dev.ethy.tinkers_vein_miner.TinkersVeinMiner.MODIFIER;

public class ModifierRecipeProvider extends RecipeProvider implements IRecipeHelper, IConditionBuilder {
	public ModifierRecipeProvider(PackOutput packOutput) {
		super(packOutput);
	}

	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
		var folder = "tools/modifiers/ability/";
		ModifierRecipeBuilder.modifier(MODIFIER.getId())
			.setTools(TinkerTags.Items.HARVEST)
			.addInput(Ingredient.of(Items.NETHER_BRICK))
			.setMaxLevel(1)
			.setSlots(SlotType.ABILITY, 1)
			.save(consumer, prefix(MODIFIER.getId(), folder));
	}

	@Override
	public @NotNull String getModId() {
		return MODID;
	}
}
