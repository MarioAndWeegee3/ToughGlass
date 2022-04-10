package marioandweegee3.toughglass.client;

import marioandweegee3.toughglass.ToughGlass;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public final class ToughGlassClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        var map = BlockRenderLayerMap.INSTANCE;

        map.putBlock(ToughGlass.toughGlassBlock, RenderLayer.getTranslucent());
    }
}
