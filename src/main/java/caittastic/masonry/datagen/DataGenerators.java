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
public class DataGenerators{
  @SubscribeEvent
  public static void gatherData(GatherDataEvent event){
    ExistingFileHelper helper = event.getExistingFileHelper();
    DataGenerator gen = event.getGenerator();

    /*     client     */
    boolean isClient = event.includeClient();
    gen.addProvider(isClient, new ModBlockStatesAndModels(gen, helper));
    gen.addProvider(isClient, new ModItemModels(gen, helper));
    gen.addProvider(isClient, new ModEnUsLanguageProvider(gen, "en_us"));

    /*     server     */
    boolean isServer = event.includeServer();
    gen.addProvider(isServer, new ModRecipes(gen));
    gen.addProvider(isServer, new ModLootTableProvider(gen));
    gen.addProvider(isServer, new ModBlockTags(gen, helper));


  }
}
