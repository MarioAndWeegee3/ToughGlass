package marioandweegee3.toughglass;

import marioandweegee3.toughglass.block.ToughGlassBlock;
import marioandweegee3.toughglass.block.ToughGlassPaneBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public final class ToughGlass implements ModInitializer {
    public static final String modId = "toughglass";

    public static final ToughGlassBlock toughGlassBlock = new ToughGlassBlock(
        FabricBlockSettings.create()
            .pistonBehavior(PistonBehavior.BLOCK)
            .hardness(10)
            .resistance(1200)
            .nonOpaque()
            .mapColor(MapColor.CLEAR)
            .instrument(Instrument.HAT)
            .sounds(BlockSoundGroup.GLASS)
            .requiresTool()
    );

    public static final ToughGlassPaneBlock toughGlassPaneBlock = new ToughGlassPaneBlock(
        FabricBlockSettings.copyOf(toughGlassBlock)
    );

    public static final BlockItem toughGlassItem = new BlockItem(
        toughGlassBlock,
        new FabricItemSettings()
    );

    public static final BlockItem toughGlassPaneItem = new BlockItem(
        toughGlassPaneBlock,
        new FabricItemSettings()
    );

    @Override
    public void onInitialize() {
        Registry.register(
            Registries.BLOCK, new Identifier(modId, "tough_glass"),
            toughGlassBlock
        );
        Registry.register(
            Registries.BLOCK, new Identifier(modId, "tough_glass_pane"),
            toughGlassPaneBlock
        );

        Registry.register(
            Registries.ITEM, new Identifier(modId, "tough_glass"),
            toughGlassItem
        );
        Registry.register(
            Registries.ITEM, new Identifier(modId, "tough_glass_pane"),
            toughGlassPaneItem
        );

        //noinspection UnstableApiUsage
        ItemGroupEvents.modifyEntriesEvent(
            ItemGroups.COLORED_BLOCKS
        ).register(content -> content.addAfter(Items.GLASS_PANE, toughGlassItem, toughGlassPaneItem));
    }
}
