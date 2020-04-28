package jaredbgreat.climaticbiomes.util;

import jaredbgreat.climaticbiomes.ClimaticBiomes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;
import net.minecraftforge.event.RegistryEvent;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.item.ItemGroup.*;

public final class ItemRegistrar extends Register {

    public static void registerItems(final RegistryEvent.Register<Item> event) {
        ClimaticBiomes.getLogger().info("Registering Items for Climatic Biomes");
        for(Block block : blocks ) {
            register(new BlockItem(block, new Item.Properties().group(FOOD)),block.getRegistryName(), event.getRegistry());
        }
        register(new TallBlockItem(BlockRegistrar.pineDoor, new Item.Properties().group(DECORATIONS)){},"pine_door",event.getRegistry());
    }
}
