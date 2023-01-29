package caittastic.masonry.datagen;

import caittastic.masonry.MosaicMasonry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import static caittastic.masonry.MosaicMasonry.*;

public class ModBlockTags extends BlockTagsProvider {

    public ModBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, MosaicMasonry.MODID, helper);
    }

    @Override
    protected void addTags() {
        for (String brickType : TYPES) {
            //mining tag
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BLOCK_MAP.get(brickType).get());
        }
    }

    @Override
    public String getName() {
        return "Mosaic Masonry Tags";
    }
    //------------------------------------- ===== -------------------------------------//
}