package jaredbgreat.climaticbiomes.util;

import jaredbgreat.climaticbiomes.Info;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.HashSet;

public class Register {

	protected static <T extends IForgeRegistryEntry<T>> T register(T obj, String name, IForgeRegistry<T> registry) {
		return register(obj,new ResourceLocation(Info.ID, name),registry);
	}

	protected static <T extends IForgeRegistryEntry<T>> T register(T obj, ResourceLocation name, IForgeRegistry<T> registry) {
		registry.register(obj.setRegistryName(name));
		return obj;
	}

	protected static final HashSet<Block> blocks = new HashSet<>();

	static Block registerBlockandItem(Block obj, String name, IForgeRegistry<Block> registry) {
		register(obj,name,registry);
		blocks.add(obj);
		return obj;
	}

}
