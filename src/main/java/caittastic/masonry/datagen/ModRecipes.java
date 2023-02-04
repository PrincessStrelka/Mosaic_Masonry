package caittastic.masonry.datagen;

import caittastic.masonry.MosaicMasonry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

import static caittastic.masonry.MosaicMasonry.TYPES;

public class ModRecipes extends RecipeProvider{
  public ModRecipes(DataGenerator generator){
    super(generator);
  }

  @Override
  protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer){
    for(String brickType: TYPES){
      Block mosaic = MosaicMasonry.BLOCK_MAP.get(brickType).get();
      Block bricks = Blocks.BRICKS;
      SingleItemRecipeBuilder.stonecutting(
              Ingredient.of(bricks),
              mosaic)
              .unlockedBy("has_bricks", has(bricks))
              .save(consumer, brickType + "_bricks_from_stonecutting");
    }
  }
}

