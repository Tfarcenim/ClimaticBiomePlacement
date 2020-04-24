package jaredbgreat.climaticbiomes.features;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.*;

import javax.annotation.Nullable;
import java.util.Random;

public class PineTree extends Tree {

    /**
     * Get a {@link ConfiguredFeature} of tree
     *
     * @param randomIn
     * @param p_225546_2_
     */
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return ClimaticBiomesFeatures.PINE.withConfiguration(DefaultBiomeFeatures.PINE_TREE_CONFIG);
    }
}
