package caittastic.masonry.datagen.loot;

import caittastic.masonry.MosaicMasonry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import static caittastic.masonry.MosaicMasonry.TYPES;

public class ModBlockLootTables extends BlockLoot {
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MosaicMasonry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    @Override
    protected void addTables() {
        for (String brickType : TYPES) {
            this.dropSelf(MosaicMasonry.BLOCK_MAP.get(brickType).get());

        }
    }
}
