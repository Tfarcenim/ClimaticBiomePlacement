package jaredbgreat.climaticbiomes.biomes;

import jaredbgreat.climaticbiomes.Info;
import jaredbgreat.climaticbiomes.features.ClimaticBiomesFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Carr extends Biome {

    public Carr(String name) {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.SWAMP,
                SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.SWAMP)
                .depth(-0.2F).scale(0.1F)
                .temperature(0.6F)
                .downfall(0.9F)
                .waterColor(6388580)
                .waterFogColor(2302743)
                .parent(null));
        setRegistryName(Info.ID, name);
        this.addStructure(Feature.SWAMP_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
                this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSwampClayDisks(this);
        ClimaticBiomesFeatures.addCarrPlants(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addExtraReedsAndPumpkins(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addFossils(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(32, 0.6D))
                        .withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(
                        IPlacementConfig.NO_PLACEMENT_CONFIG)));
        this.addSpawn(EntityClassification.CREATURE,
                new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.CREATURE,
                new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE,
                new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
        this.addSpawn(EntityClassification.CREATURE,
                new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT,
                new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER,
                new Biome.SpawnListEntry(EntityType.SLIME, 1, 1, 1));
    }


    public int getGrassColor(BlockPos pos) {
        double d0 = INFO_NOISE.noiseAt((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D,false);
        return d0 < -0.1D ? 0x4C763C : 0x6A7039;
    }


    public int getFoliageColor(BlockPos pos) {
        return 0x4C863C;
    }
}
