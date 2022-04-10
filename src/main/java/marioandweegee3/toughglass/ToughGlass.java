package marioandweegee3.toughglass;

import marioandweegee3.toughglass.block.ToughGlassBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricMaterialBuilder;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ToughGlass implements ModInitializer {
    public static final String modId = "toughglass";

    public static final Material toughGlassMaterial =
        new FabricMaterialBuilder(MapColor.CLEAR)
            .blocksPistons()
            .notSolid()
            .build();

    public static final ToughGlassBlock toughGlassBlock = new ToughGlassBlock(
        FabricBlockSettings.of(toughGlassMaterial)
            .hardness(10)
            .resistance(1200)
            .nonOpaque()
    );

    @Override
    public void onInitialize() {
        Registry.register(
            Registry.BLOCK, new Identifier(modId, "tough_glass"),
            toughGlassBlock
        );
        Registry.register(
            Registry.ITEM, new Identifier(modId, "tough_glass"),
            new BlockItem(
                toughGlassBlock,
                new FabricItemSettings()
                    .group(ItemGroup.BUILDING_BLOCKS)
            )
        );
    }
}
