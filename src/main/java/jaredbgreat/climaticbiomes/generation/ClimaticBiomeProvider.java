package jaredbgreat.climaticbiomes.generation;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import jaredbgreat.climaticbiomes.Info;
import jaredbgreat.climaticbiomes.generation.map.MapRegistry;
import jaredbgreat.climaticbiomes.util.BiomeRegistrar;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class ClimaticBiomeProvider extends OverworldBiomeProvider {
    private static Set<Biome> possibleBiomes = new HashSet<>();

    private static final Set<Biome> field_226847_e_ = ImmutableSet.of(Biomes.OCEAN, Biomes.PLAINS, Biomes.DESERT, Biomes.MOUNTAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.SWAMP, Biomes.RIVER, Biomes.FROZEN_OCEAN, Biomes.FROZEN_RIVER, Biomes.SNOWY_TUNDRA, Biomes.SNOWY_MOUNTAINS, Biomes.MUSHROOM_FIELDS, Biomes.MUSHROOM_FIELD_SHORE, Biomes.BEACH, Biomes.DESERT_HILLS, Biomes.WOODED_HILLS, Biomes.TAIGA_HILLS, Biomes.MOUNTAIN_EDGE, Biomes.JUNGLE, Biomes.JUNGLE_HILLS, Biomes.JUNGLE_EDGE, Biomes.DEEP_OCEAN, Biomes.STONE_SHORE, Biomes.SNOWY_BEACH, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.DARK_FOREST, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS, Biomes.WOODED_MOUNTAINS, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.BADLANDS, Biomes.WOODED_BADLANDS_PLATEAU, Biomes.BADLANDS_PLATEAU, Biomes.WARM_OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.SUNFLOWER_PLAINS, Biomes.DESERT_LAKES, Biomes.GRAVELLY_MOUNTAINS, Biomes.FLOWER_FOREST, Biomes.TAIGA_MOUNTAINS, Biomes.SWAMP_HILLS, Biomes.ICE_SPIKES, Biomes.MODIFIED_JUNGLE, Biomes.MODIFIED_JUNGLE_EDGE, Biomes.TALL_BIRCH_FOREST, Biomes.TALL_BIRCH_HILLS, Biomes.DARK_FOREST_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.MODIFIED_GRAVELLY_MOUNTAINS, Biomes.SHATTERED_SAVANNA, Biomes.SHATTERED_SAVANNA_PLATEAU, Biomes.ERODED_BADLANDS, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.MODIFIED_BADLANDS_PLATEAU);


    private MapRegistry finder;

    private final Layer noiseBiomeLayer;


    public ClimaticBiomeProvider(OverworldBiomeProviderSettings settingsProvider){
        super(settingsProvider);

        possibleBiomes = Sets.newHashSet(field_226847_e_);
        ForgeRegistries.BIOMES.forEach(biome -> {
            if (biome.getRegistryName().getNamespace().equals(Info.ID))possibleBiomes.add(biome);
        });
        this.noiseBiomeLayer = LayerUtil.func_227474_a_(settingsProvider.getSeed(), settingsProvider.getWorldType(), settingsProvider.getGeneratorSettings());

        // finder = new MapRegistry(world.getSeed(), world);

    }

    public static Set<Biome> getPossibleBiomes() {
        if (possibleBiomes.isEmpty()) {
            for (Biome biome : Registry.BIOME) {
                possibleBiomes.add(biome);
            }
        }
        return possibleBiomes;
    }



    /*-------------------------------------------------------------------------------------------------*/
    /*                              NEW METHOD FOR THE CURRENT API                                     */
    /*-------------------------------------------------------------------------------------------------*/


    //@Override
    public Biome getBiome(int x, int z) {
        return finder.getBiomeAt(x, z);
    }


    //@Override
    public Biome[] getBiomes(int x, int z, int width, int length, boolean cacheFlag) {
        Biome[] biomes = new Biome[width * length];
        finder.getUnalignedBiomeGrid(x, z, width, length, biomes);
        return biomes;
    }


    public Biome[] getChunkBiomes(int x, int z, boolean cacheFlag) {
        Biome[] biomes = new Biome[256];
        return finder.getChunkBiomeGrid(x, z, biomes);
    }


    //@Override
    public Set<Biome> getBiomesInSquare(int centerX, int centerZ, int side) {
        Set<Biome> out = new HashSet<>();
        int r = side / 2;
        Biome[] biomes = getBiomes(centerX - r, centerZ - r, side, side, false);
        for(int i = 0; i < biomes.length; i++) {
            out.add(biomes[i]);
        }
        return out;
    }



    //@Override
    @Nullable
    public BlockPos findBiomePosition(int x, int z, int range, List<Biome> biomes, Random random) {
        int i = x - range >> 2;
        int j = z - range >> 2;
        int k = x + range >> 2;
        int l = z + range >> 2;
        int i1 = k - i + 1;
        int j1 = l - j + 1;
        Biome[] abiome = getBiomes(i, j, i1, j1, false);
        BlockPos blockpos = null;
        int k1 = 0;

        for(int l1 = 0; l1 < i1 * j1; ++l1) {
            int i2 = i + l1 % i1 << 2;
            int j2 = j + l1 / i1 << 2;
            if (biomes.contains(abiome[l1])) {
                if (blockpos == null || random.nextInt(k1 + 1) == 0) {
                    blockpos = new BlockPos(i2, 0, j2);
                }

                ++k1;
            }
        }

        return blockpos;
    }


    @Override
    public boolean hasStructure(Structure<?> structureIn) {
        return hasStructureCache.computeIfAbsent(structureIn, (structure) -> {
            for(Biome biome : possibleBiomes) {
                if(biome.hasStructure(structure)) {
                    return true;
                }
            }
            return false;
        });
    }


    // What does this even do?!
    @Override
    public Set<BlockState> getSurfaceBlocks() {
        if (this.topBlocksCache.isEmpty()) {
            for(Biome biome : possibleBiomes) {
                this.topBlocksCache.add(biome.getSurfaceBuilderConfig().getTop());
            }
        }

        return this.topBlocksCache;
    }



    /*-------------------------------------------------------------------------------------------------*/
    /*                            OLD PIECES FROM THE 1.12.2 VERSION                                   */
    /*-------------------------------------------------------------------------------------------------*/


    private int chunkModulus(int in) {
        return in & 0xf;
    }


    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return noiseBiomeLayer.func_215738_a(x,z);//todo
    }
}
