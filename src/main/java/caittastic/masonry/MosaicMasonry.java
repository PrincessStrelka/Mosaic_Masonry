package caittastic.masonry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MosaicMasonry.MODID)
public class MosaicMasonry {
    public static final String MODID = "mosaic_masonry"; // Define mod id in a common place for everything to reference
    public static final String[] TYPES = {
            "prismarine",
            "quartz",
            "mud",
            "stone",
            "common",
            "english",
            "header",
            "flemish",
            "stack"
    };

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID); // Create a Deferred Register to hold Blocks which will all be registered under our namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID); // Create a Deferred Register to hold Items which will all be registered under our namespace
    //method to register block and block item
    private static <T extends Block> RegistryObject<T> registerBlockWithBlockItem(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().tab(tab)));
        return toReturn;
    }

    //a creative tab for the stuff in our mod
    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(BLOCK_MAP.get(TYPES[8]).get());
        }
    };

    public static final Map<String,RegistryObject<Block>> BLOCK_MAP = new HashMap<>(); //map to hold our bricks
    //make a map containing all our blocks
    static{
        for (String brickType: TYPES){
            BLOCK_MAP.put(brickType, registerBlockWithBlockItem(brickType + "_bond", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS)), TAB));
        }
    }

    public MosaicMasonry() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);// Register the Deferred Register to the mod event bus so blocks get registered
        ITEMS.register(modEventBus);// Register the Deferred Register to the mod event bus so items get registered
        MinecraftForge.EVENT_BUS.register(this);// Register ourselves for server and other game events we are interested in
    }

}
