package caittastic.masonry.datagen;

import caittastic.masonry.MosaicMasonry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static caittastic.masonry.MosaicMasonry.TAB;
import static caittastic.masonry.MosaicMasonry.TYPES;
import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

public class ModEnUsLanguageProvider extends LanguageProvider{
  public ModEnUsLanguageProvider(DataGenerator gen, String locale){
    super(gen, MosaicMasonry.MODID, locale);
  }

  @Override
  protected void addTranslations(){
    for(String brickType: TYPES){
      //lang entries
      add(MosaicMasonry.BLOCK_MAP.get(brickType).get(), capitalizeFully(brickType) + " Bond Bricks");//planks
    }

    add("itemGroup." + TAB.getRecipeFolderName(), "Mosaic Masonry");
  }
}
