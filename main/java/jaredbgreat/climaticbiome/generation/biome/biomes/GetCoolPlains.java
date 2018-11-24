package jaredbgreat.climaticbiome.generation.biome.biomes;

import jaredbgreat.climaticbiome.generation.biome.BiomeList;
import jaredbgreat.climaticbiome.generation.biome.IBiomeSpecifier;
import jaredbgreat.climaticbiome.generation.biome.SeedDoubleBiome;
import jaredbgreat.climaticbiome.generation.generator.ChunkTile;

/**
 * This specifer is specifically for words using biome mods that 
 * imply a cool temperate band between the taiga zone and the 
 * basic temperate zone.
 * 
 * @author JaredBGreat (Jared Blackburn)
 */
public class GetCoolPlains implements IBiomeSpecifier  {
	private static GetCoolPlains grassland;
	private GetCoolPlains() {
		super();
	}
	private BiomeList plains;
	private GetAlpine alpine;
	
	
	public void init() {
		plains = new BiomeList();
		alpine = GetAlpine.getAlpine();
		// TODO: Add the biomes when needed.
	}
	
	
	@Override
	public int getBiome(ChunkTile tile) {
		int seed = tile.getBiomeSeed();
		if((seed % 4) == 0) {
			tile.nextBiomeSeed();
			return alpine.getBiome(tile);
		}
		tile.nextBiomeSeed();
		return plains.getBiome(tile);
	}
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public static GetCoolPlains getPlains() {
		if(grassland == null) {
			grassland = new GetCoolPlains();
		}
		return grassland;
	}

}