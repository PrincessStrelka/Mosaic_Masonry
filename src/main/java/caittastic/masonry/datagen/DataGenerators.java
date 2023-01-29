package caittastic.masonry.datagen;

import caittastic.masonry.datagen.loot.ModLootTableProvider;
import caittastic.masonry.datagen.models.ModBlockStatesAndModels;
import caittastic.masonry.datagen.models.ModItemModels;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static caittastic.masonry.MosaicMasonry.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper helper = event.getExistingFileHelper();
        DataGenerator generator = event.getGenerator();

        /*     client     */
        boolean isClient = event.includeClient();
        generator.addProvider(isClient, new ModBlockStatesAndModels(generator, helper));
        generator.addProvider(isClient, new ModItemModels(generator, helper));
        generator.addProvider(isClient, new ModEnUsLanguageProvider(generator, "en_us"));

        /*     server     */
        boolean isServer = event.includeServer();
        //generator.addProvider(isServer, new ModRecipes(generator));
        generator.addProvider(isServer, new ModLootTableProvider(generator));
        generator.addProvider(isServer, new ModBlockTags(generator, helper));


    }
}
