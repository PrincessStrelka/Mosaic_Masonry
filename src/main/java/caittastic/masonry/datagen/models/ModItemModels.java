package caittastic.masonry.datagen.models;

import caittastic.masonry.MosaicMasonry;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import static caittastic.masonry.MosaicMasonry.MODID;
import static caittastic.masonry.MosaicMasonry.TYPES;

public class ModItemModels extends ItemModelProvider {

    public ModItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (String brickType : TYPES) {
            simpleExistingBlockParent(MosaicMasonry.BLOCK_MAP.get(brickType));
        }
    }

    private ItemModelBuilder simpleExistingBlockParent(RegistryObject<Block> blockToModel) {
        return withExistingParent(blockToModel.getId().getPath(), modLoc("block/" + blockToModel.getId().getPath()));
    }
}

