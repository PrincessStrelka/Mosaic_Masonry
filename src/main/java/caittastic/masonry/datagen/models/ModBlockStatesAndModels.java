package caittastic.masonry.datagen.models;

import caittastic.masonry.MosaicMasonry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static caittastic.masonry.MosaicMasonry.MODID;
import static caittastic.masonry.MosaicMasonry.TYPES;

public class ModBlockStatesAndModels extends BlockStateProvider {
    public ModBlockStatesAndModels(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (String brickType : TYPES) {
            //register block model
            simpleBlock(MosaicMasonry.BLOCK_MAP.get(brickType).get());
        }
    }
}

