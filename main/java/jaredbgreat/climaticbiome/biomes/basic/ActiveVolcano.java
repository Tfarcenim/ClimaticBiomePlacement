package jaredbgreat.climaticbiome.biomes.basic;

import jaredbgreat.climaticbiome.util.BlockRegistrar;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class ActiveVolcano extends Biome  {
    protected static final IBlockState BASALT = BlockRegistrar.blockBasalt.getDefaultState();
    protected static final IBlockState ASH = BlockRegistrar.blockAsh.getDefaultState();
    protected static final WorldGenLakes LAVA = new WorldGenLakes(Blocks.LAVA);

	public ActiveVolcano(BiomeProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
        decorator.cactiPerChunk = -999;
		decorator.treesPerChunk = -999;
        decorator.grassPerChunk = -999;
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
	}
	

    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, 
    			int x, int z, double noise) { 
    	/*if(noise < -1.95) {
        	topBlock = fillerBlock = Blocks.LAVA.getDefaultState();    		
    	} else*/ {
	    	fillerBlock = BASALT;
	        if(noise > 1.25) {
	        	this.topBlock = ASH;
	        } else if(rand.nextInt(196) == 0){
	        	topBlock = Blocks.OBSIDIAN.getDefaultState();
	        } else {
	        	topBlock = BASALT;
	        }
    	}
        generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noise);
        
        int k1 = x & 15;
        int l1 = z & 15;
        int ty = 64 + (int)(noise * 4);
        for (int j1 = 255; j1 >= ty; --j1) {
        	if((chunkPrimerIn.getBlockState(l1, j1, k1).getBlock() == Blocks.STONE)) {
        		chunkPrimerIn.setBlockState(l1, j1, k1, BASALT);
        	}
        	if(noise < -1.95) {
        		worldIn.notifyNeighborsOfStateChange(new BlockPos(l1, j1, k1), Blocks.STONE, true);
        	}
        }
    }
    
    
    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {    
    	//System.out.println("BlockPos pos " + pos);
    	super.decorate(worldIn, rand, pos);
    }
    
    
    
    
    

}
