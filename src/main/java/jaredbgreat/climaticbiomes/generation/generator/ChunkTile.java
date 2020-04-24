/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaredbgreat.climaticbiomes.generation.generator;

import jaredbgreat.climaticbiomes.generation.cache.AbstractCachable;
import jaredbgreat.climaticbiomes.generation.cache.Coords;

/**
 *
 * @author Jared Blackburn
 */
public class ChunkTile extends AbstractCachable {
    static final int size = 16;
    final int x, z, tx, tz;
    int val = 0;
    int rlBiome;
    int temp = 0, wet = 0;
    int biomeSeed = 0;
    int noiseVal = 0;
    int river;
    double height;
    boolean coastal = false, beach = false;


    public ChunkTile(int x, int z, int xoff, int zoff) {
        super(x, z);
        this.x = x;
        this.z = z;
        tx = x + xoff;
        tz = z + zoff;
    }

    public static int getSize() {
        return size;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public int getTX() {
        return tx;
    }

    public int getTZ() {
        return tz;
    }

    public int getVal() {
        return val;
    }

    public int getRlBiome() {
        return rlBiome;
    }

    public int getTemp() {
        return temp;
    }

    public int getWet() {
        return wet;
    }

    public double getHeight() {
        return height;
    }

    public int getBiomeSeed() {
        return biomeSeed;
    }

    public int getNoise() {
        return noiseVal;
    }

    public boolean isRiver() {
        return river > 0;
    }

    public boolean isBeach() {
        return beach;
    }

    public boolean isCoastal() {
        return coastal;
    }


    public ChunkTile nextBiomeSeed() {
        biomeSeed ^= biomeSeed << 13;
        biomeSeed ^= biomeSeed >> 19;
        biomeSeed ^= biomeSeed << 7;
        biomeSeed &= 0x7fffffff;
        return this;
    }

}