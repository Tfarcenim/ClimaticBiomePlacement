package jaredbgreat.climaticbiomes.features;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import jaredbgreat.climaticbiomes.util.BlockRegistrar;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;

import static net.minecraft.world.biome.DefaultBiomeFeatures.*;


public class ClimaticBiomesFeatures {
    public static final PineTreeFeature PINE
            = new PineTreeFeature(TreeFeatureConfig::deserializeJungle);

    public static final Feature<BaseTreeFeatureConfig> SCRUB_BUSH1
            = new ShrubFeature(BaseTreeFeatureConfig::deserializeJungle);

    public static final Feature<BaseTreeFeatureConfig> SCRUB_BUSH2
            = new ShrubFeature(BaseTreeFeatureConfig::deserializeJungle); //Blocks.SPRUCE_LOG.getDefaultState(),
                    //Blocks.SPRUCE_LEAVES.getDefaultState());

    /*public static final Feature<NoFeatureConfig> BIG_ROCK_PILE
            = new ShrubFeature(NoFeatureConfig::deserialize, Blocks.COBBLESTONE.getDefaultState(),
            Blocks.COBBLESTONE.getDefaultState());

    public static final Feature<NoFeatureConfig> BOULDER
            = new ShrubFeature(NoFeatureConfig::deserialize, Blocks.STONE.getDefaultState(),
            Blocks.STONE.getDefaultState());*/


    public static void addSubtropicalForestTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(
                                ImmutableList.of(
                                 Feature.FANCY_TREE.withConfiguration(OAK_TREE_CONFIG).withChance(.2f),
                                        PINE.withConfiguration(PINE_TREE_CONFIG).withChance(.2f)),
                                Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(

                                        new AtSurfaceWithExtraConfig(10, 0.1F, 1))))));
    }


    public static void addTropicalForestTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
               Feature.RANDOM_SELECTOR.withConfiguration(
                       new MultipleRandomFeatureConfig(ImmutableList.of(
                               Feature.NORMAL_TREE.withConfiguration(JUNGLE_TREE_CONFIG).withChance(.1f),
                               Feature.FANCY_TREE.withConfiguration(OAK_TREE_CONFIG).withChance(.2f)),
                                Feature.ACACIA_TREE.withConfiguration(ACACIA_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(10, 0.1F, 1))))));
    }


    public static void addPinewoodsTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                Feature.NORMAL_TREE.withConfiguration(SWAMP_TREE_CONFIG).withChance(.1f)),
                        PINE.withConfiguration(OAK_TREE_CONFIG)
                                .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(10, 0.1F, 1))))));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
               Feature.NORMAL_TREE.withConfiguration(SWAMP_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32
                        .configure( new FrequencyConfig(1))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
                        .configure( new FrequencyConfig(10))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(
                        Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.25F))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.125F))));

    }


    public static void addDenseScrubBushes(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                SCRUB_BUSH1.withConfiguration(OAK_TREE_CONFIG).withChance(.4f)
                                , SCRUB_BUSH2.withConfiguration(OAK_TREE_CONFIG).withChance(.4f)
                        ), Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(3, 0.1F, 1))))));
    }


    public static void addDryScrubBushes(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                SCRUB_BUSH1.withConfiguration(OAK_TREE_CONFIG).withChance(.5f))
                                ,SCRUB_BUSH2.withConfiguration(OAK_TREE_CONFIG)
                                .withPlacement( Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                                        new AtSurfaceWithExtraConfig(1, 0.1F, 1))))));
    }


    public static void addScrubRocks(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
                Feature.FOREST_ROCK.withConfiguration(new BlockBlobConfig(Blocks.COBBLESTONE.getDefaultState(), 0))
                        .withPlacement(Placement.FOREST_ROCK.configure( new FrequencyConfig(3))));
    }


    public static void addVolcanoOres(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                Blocks.IRON_ORE.getDefaultState(), 12)).withPlacement(
                        Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(20, 0, 0, 56))));

        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                Blocks.GOLD_ORE.getDefaultState(), 12)).withPlacement(Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(4, 0, 0, 48))));

        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                Blocks.LAVA.getDefaultState(), 9)).withPlacement(
                        Placement.COUNT_RANGE.configure(
                        new CountRangeConfig(4, 0, 0, 128))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.SPRING_FEATURE.withConfiguration(LAVA_SPRING_CONFIG).withPlacement(
                        Placement.COUNT_VERY_BIASED_RANGE.configure(
                        new CountRangeConfig(256, 8, 16, 256))));

        biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
                Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(Blocks.LAVA.getDefaultState())).withPlacement(
                        Placement.LAVA_LAKE.configure(new ChanceConfig(20))));

    }


    public static void addBambooForestPlants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.25F)).withPlacement(
                        Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(
                        new TopSolidWithNoiseConfig(160, 80.0D, 0.3D,
                                Heightmap.Type.WORLD_SURFACE_WG))));
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                SCRUB_BUSH1.withConfiguration(OAK_TREE_CONFIG).withChance(.01f),
                                Feature.JUNGLE_GROUND_BUSH.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(.04f),
                                Feature.RANDOM_PATCH.withConfiguration(LUSH_GRASS_CONFIG).withChance(.14f),
                                Feature.FANCY_TREE.withConfiguration(OAK_TREE_CONFIG).withChance(.02f)),
                                Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.25F)).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(32, 0.1F, 1))))));
    }


    public static void addWindsweptPlainsPlants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(PLAINS_FLOWER_CONFIG)
                        .withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(
                        new NoiseDependant(-0.8D, 15, 4))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(
                        Placement.NOISE_HEIGHTMAP_DOUBLE.configure(
                        new NoiseDependant(-0.8D, 5, 10))));
    }


    public static void addCoolPlainsPlants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(.25f),
                                Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(.25f)
                                ), Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(0, 0.05F, 1))))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(PLAINS_FLOWER_CONFIG).withPlacement(
                        Placement.NOISE_HEIGHTMAP_32.configure(
                        new NoiseDependant(-0.8D, 15, 4))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(
                        Placement.NOISE_HEIGHTMAP_DOUBLE.configure(new NoiseDependant(-0.8D, 5, 10))));
    }


    public static void addColdPlainsPlants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
                        ImmutableList.of(
                                SCRUB_BUSH1.withConfiguration(OAK_TREE_CONFIG).withChance(.5f)),
                                SCRUB_BUSH2.withConfiguration(OAK_TREE_CONFIG).withPlacement(
                                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(0, 0.5F, 1))))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(PLAINS_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(
                        new NoiseDependant(-0.8D, 15, 4))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(
                        Placement.NOISE_HEIGHTMAP_DOUBLE.configure(
                        new NoiseDependant(-0.8D, 5, 10))));
    }


    public static void addBogPlants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
                        ImmutableList.of(SCRUB_BUSH1.withConfiguration(OAK_TREE_CONFIG).withChance(.1f),
                                SCRUB_BUSH2.withConfiguration(OAK_TREE_CONFIG).withChance(.1f)
                                ), Feature.RANDOM_PATCH.withConfiguration(LUSH_GRASS_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(12, 0.5F, 1))))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32
                        .configure( new FrequencyConfig(1))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
                        .configure( new FrequencyConfig(10))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(
                        new FrequencyConfig(1))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(
                        Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.25F))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.125F))));
    }


    public static void addCarrPlants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
                        ImmutableList.of(
                                Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(.25f),
                                Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(.25f))
                                , Feature.NORMAL_TREE.withConfiguration(BIRCH_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(8, 0.5F, 1))))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32
                        .configure( new FrequencyConfig(1))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
                        .configure( new FrequencyConfig(10))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(
                        Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(16))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.25F))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.125F))));
    }

    public static void addMarshPlants(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32
                        .configure( new FrequencyConfig(1))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
                        .configure( new FrequencyConfig(12))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(
                        Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(12))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.25F))));

        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(RED_MUSHROOM_CONFIG).withPlacement(
                        Placement.COUNT_CHANCE_HEIGHTMAP.configure( new HeightWithChanceConfig(8, 0.25F))));
    }


    public static void addPeatDisks(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.DISK.withConfiguration(new SphereReplaceConfig(BlockRegistrar.peat.getDefaultState(),
                                6, 2, Lists.newArrayList(Blocks.DIRT.getDefaultState(),
                                BlockRegistrar.peat.getDefaultState())))
                        .withPlacement(Placement.COUNT_TOP_SOLID.configure( new FrequencyConfig(3))));
    }


    public static void addWarmMTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
                        ImmutableList.of(
                                Feature.NORMAL_TREE.withConfiguration(field_230129_h_).withChance(.2f),
                                Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(.1f),
                                Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(.1f),
                                Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG).withChance(.2f)
            ), Feature.FANCY_TREE.withConfiguration(OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(3, 0.1F, 1))))));
    }


    public static void addHotMTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                PINE.withConfiguration(PINE_TREE_CONFIG).withChance(.2f),
                                Feature.NORMAL_TREE.withConfiguration(JUNGLE_TREE_CONFIG).withChance(.1f)
                                ), Feature.FANCY_TREE.withConfiguration(OAK_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.
                                configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))))));
    }


    public static void addMFWTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                PINE.withConfiguration(PINE_TREE_CONFIG).withChance(.2f),
                                Feature.NORMAL_TREE.withConfiguration(OAK_TREE_CONFIG).withChance(.2f),
                                        Feature.NORMAL_TREE.withConfiguration(BIRCH_TREE_CONFIG).withChance(.2f),
                                Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(.1f),
                                Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(.1f)
                                ), Feature.FANCY_TREE.withConfiguration(OAK_TREE_CONFIG)
                                .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                                        new AtSurfaceWithExtraConfig(7, 0.1F, 1))))));
    }


    public static void addMFCTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                Feature.FANCY_TREE.withConfiguration(OAK_TREE_CONFIG).withChance(.2f),
                                Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG).withChance(.25f),
                                Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(.25f)
                                ), Feature.NORMAL_TREE.withConfiguration(BIRCH_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(7, 0.1F, 1))))));
    }


    public static void addMFHTrees(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,

                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(
                                ImmutableList.of(
                                        PINE.withConfiguration(OAK_TREE_CONFIG).withChance(.1f),
                                        Feature.FANCY_TREE.withConfiguration(JUNGLE_TREE_CONFIG).withChance(.3f),
                                        Feature.ACACIA_TREE.withConfiguration(ACACIA_TREE_CONFIG).withChance(.1f)),
                                Feature.JUNGLE_GROUND_BUSH.withConfiguration(JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(
                        new AtSurfaceWithExtraConfig(20, 0.1F, 1))));
    }

    public static void addJungleTreeForest(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(ImmutableList.of(
                                Feature.FANCY_TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.1F),
                                Feature.JUNGLE_GROUND_BUSH.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.5F),
                                Feature.MEGA_JUNGLE_TREE.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.33333334F)),
                                Feature.NORMAL_TREE.withConfiguration(JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(50, 0.1F, 1))));
    }


}
