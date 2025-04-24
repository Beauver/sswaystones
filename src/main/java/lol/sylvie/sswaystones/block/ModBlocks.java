/*
  This file is licensed under the MIT License!
  https://github.com/sylvxa/sswaystones/blob/main/LICENSE
*/
package lol.sylvie.sswaystones.block;

import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import lol.sylvie.sswaystones.Waystones;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModBlocks {
    // This is considered the "default" waystone for backwards compatibility;
    public static final WaystoneBlock WAYSTONE = registerWaystoneStyle(WaystoneStyle.STONE);

    // Other styles
    public static final WaystoneBlock DEEPSLATE_WAYSTONE = registerWaystoneStyle(WaystoneStyle.DEEPSLATE);
    public static final WaystoneBlock TUFF_WAYSTONE = registerWaystoneStyle(WaystoneStyle.TUFF);
    public static final WaystoneBlock MUD_WAYSTONE = registerWaystoneStyle(WaystoneStyle.MUD);
    public static final WaystoneBlock RESIN_WAYSTONE = registerWaystoneStyle(WaystoneStyle.RESIN);
    public static final WaystoneBlock SANDSTONE_WAYSTONE = registerWaystoneStyle(WaystoneStyle.SANDSTONE);
    public static final WaystoneBlock RED_SANDSTONE_WAYSTONE = registerWaystoneStyle(WaystoneStyle.RED_SANDSTONE);
    public static final WaystoneBlock PRISMARINE_WAYSTONE = registerWaystoneStyle(WaystoneStyle.PRISMARINE);
    public static final WaystoneBlock NETHER_BRICK_WAYSTONE = registerWaystoneStyle(WaystoneStyle.NETHER_BRICK);
    public static final WaystoneBlock RED_NETHER_BRICK_WAYSTONE = registerWaystoneStyle(WaystoneStyle.RED_NETHER_BRICK);
    public static final WaystoneBlock BLACKSTONE_WAYSTONE = registerWaystoneStyle(WaystoneStyle.BLACKSTONE);
    public static final WaystoneBlock END_STONE_WAYSTONE = registerWaystoneStyle(WaystoneStyle.END_STONE);

    public static final List<WaystoneBlock> WAYSTONES = List.of(WAYSTONE, DEEPSLATE_WAYSTONE, TUFF_WAYSTONE,
            MUD_WAYSTONE, RESIN_WAYSTONE, SANDSTONE_WAYSTONE, RED_SANDSTONE_WAYSTONE, PRISMARINE_WAYSTONE,
            NETHER_BRICK_WAYSTONE, RED_NETHER_BRICK_WAYSTONE, BLACKSTONE_WAYSTONE, END_STONE_WAYSTONE);

    public static final BlockEntityType<WaystoneBlockEntity> WAYSTONE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE, Identifier.of(Waystones.MOD_ID, "waystone_block_entity"),
            FabricBlockEntityTypeBuilder.create(WaystoneBlockEntity::new).addBlocks(WAYSTONES).build());

    public static Block register(Block block, Identifier identifier) {
        return Registry.register(Registries.BLOCK, identifier, block);
    }

    public static WaystoneBlock registerWaystoneStyle(WaystoneStyle style) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create().registryKey(style.getBlockRegistryKey())
                .hardness(1.5f)
                .resistance(3600000);
        return (WaystoneBlock) register(new WaystoneBlock(style, settings), style.getId());
    }


    public static void initialize() {
        PolymerBlockUtils.registerBlockEntity(WAYSTONE_BLOCK_ENTITY);
    }
}
