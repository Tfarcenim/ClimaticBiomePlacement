package jaredbgreat.climaticbiomes.util;

import jaredbgreat.climaticbiomes.ClimaticBiomes;
import jaredbgreat.climaticbiomes.Info;
import jaredbgreat.climaticbiomes.blocks.*;
import jaredbgreat.climaticbiomes.features.PineTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;

public final class BlockRegistrar extends Register {

    // Stony Blocks
    public static Block basalt;
    public static Block polished_basalt;
    public static Block basalt_bricks;
    public static Block cracked_basalt_bricks;
    public static Block granite_bricks;
    public static Block cracked_granite_bricks;
    public static Block andesite_bricks;
    public static Block cracked_andesite_bricks;
    public static Block diorite_bricks;
    public static Block cracked_diorite_bricks;

    //Pine Blocks
    public static Block pineLog;
    public static Block stripped_pine_log;

    public static Block pine_wood;
    public static Block stripped_pine_wood;

    public static Block pineNeedles;
    public static Block pineSapling;
    public static Block pine_planks;
    public static Block blockPinePlanksLong;
    public static Block pine_slab;
    public static Block pine_stairs;
    public static Block pineFence;
    public static Block pineGate;
    public static Block pineDoor;
    public static StandingSignBlock pineSign;
    public static WallSignBlock pineWallSign;
    public static Block pine_pressure_plate;
    public static Block pine_trapdoor;
    public static Block pine_button;
    public static RotatedPillarBlock barkPine;
    public static RotatedPillarBlock woodPine;
    public static FlowerPotBlock pinePotted;

    // Misc Blocks
    public static Block volcanic_ash;
    public static Block peat;
    public static Block blockCob;
    public static Block large_mud_bricks;
    public static Block small_mud_bricks;

    // Slabs
    public static Block basalt_slab;
    public static Block polished_basalt_slab;
    public static Block basalt_brick_slab;
    public static SlabBlock slabBasaltBricksCracked;
    public static SlabBlock slabGraniteBricks;
    public static SlabBlock slabGraniteBricksCracked;
    public static SlabBlock slabAndesiteBricks;
    public static SlabBlock slabAndesiteBricksCracked;
    public static SlabBlock slabDioriteBricks;
    public static SlabBlock slabDioriteBricksCracked;
    public static SlabBlock slabCob;
    public static SlabBlock slabMudBrickL;
    public static SlabBlock slabMudBrickS;

    // Stairs
    public static StairsBlock stairBasalt;
    public static StairsBlock stairPolishedBasalt;
    public static StairsBlock stairBasaltBricks;
    public static StairsBlock stairBasaltBricksCracked;
    public static StairsBlock stairGraniteBricks;
    public static StairsBlock stairGraniteBricksCracked;
    public static StairsBlock stairAndesiteBricks;
    public static StairsBlock stairAndesiteBricksCracked;
    public static StairsBlock stairDioriteBricks;
    public static StairsBlock stairDioriteBricksCracked;
    public static StairsBlock stairCob;
    public static StairsBlock stairMudBrickL;
    public static StairsBlock stairMudBrickS;

    // Fence Walls
    public static WallBlock wallBasalt;
    public static WallBlock wallPolishedBasalt;
    public static WallBlock wallBasaltBricks;
    public static WallBlock wallBasaltBricksCracked;
    public static WallBlock wallGraniteBricks;
    public static WallBlock wallGraniteBricksCracked;
    public static WallBlock wallAndesiteBricks;
    public static WallBlock wallAndesiteBricksCracked;
    public static WallBlock wallDioriteBricks;
    public static WallBlock wallDioriteBricksCracked;
    public static WallBlock wallCob;
    public static WallBlock wallMudBrickL;
    public static WallBlock wallMudBrickS;

    public static void setupBlocks(final RegistryEvent.Register<Block> event) {
        ClimaticBiomes.getLogger().info("Registering Blocks for Climatic Biomes");
        Block.Properties igneous = makeProperties();
        basalt = registerBlockandItem(new Block(igneous),"basalt",event.getRegistry());
        basalt_bricks = registerBlockandItem(new Block(igneous),"basalt_bricks",event.getRegistry());
        cracked_basalt_bricks = registerBlockandItem(new Block(igneous),"cracked_basalt_bricks",event.getRegistry());
        polished_basalt = registerBlockandItem(new Block(igneous),"polished_basalt",event.getRegistry());

        basalt_slab = registerBlockandItem(new SlabBlock(igneous),"basalt_slab",event.getRegistry());
        basalt_brick_slab = registerBlockandItem(new SlabBlock(igneous),"basalt_brick_slab",event.getRegistry());
        polished_basalt_slab = registerBlockandItem(new SlabBlock(igneous),"polished_basalt_slab",event.getRegistry());

        granite_bricks = registerBlockandItem(new Block(igneous),"granite_bricks",event.getRegistry());
        andesite_bricks = registerBlockandItem(new Block(igneous),"andesite_bricks",event.getRegistry());
        diorite_bricks = registerBlockandItem(new Block(igneous),"diorite_bricks",event.getRegistry());

        cracked_andesite_bricks = registerBlockandItem(new Block(igneous),"cracked_andesite_bricks",event.getRegistry());
        cracked_granite_bricks = registerBlockandItem(new Block(igneous),"cracked_granite_bricks",event.getRegistry());
        cracked_diorite_bricks = registerBlockandItem(new Block(igneous),"cracked_diorite_bricks",event.getRegistry());

        Block.Properties ash = makeAshProperties();
        volcanic_ash = registerBlockandItem(new FallingBlock(ash),"volcanic_ash", event.getRegistry());

        //woods
        Block.Properties log = makeLogProperties();
        Block.Properties leaves = makeLeavesProperties();
        pineLog = registerBlockandItem(new LogBlock(MaterialColor.WOOD,log),"pine_log", event.getRegistry());
        stripped_pine_log = registerBlockandItem(new LogBlock(MaterialColor.WOOD,log),"stripped_pine_log",event.getRegistry());

        pine_wood = registerBlockandItem(new RotatedPillarBlock(log),"pine_wood", event.getRegistry());
        stripped_pine_wood = registerBlockandItem(new RotatedPillarBlock(log),"stripped_pine_wood",event.getRegistry());

        pineNeedles = registerBlockandItem(new LeavesBlock(leaves),"pine_leaves",event.getRegistry());

        Block.Properties planks = makePlanksProperties();
        pine_planks = registerBlockandItem(new Block(planks),"pine_planks",event.getRegistry());

        Block.Properties sapling = makeSaplingProperties();

        pineSapling = registerBlockandItem(new SaplingBlock(new PineTree(),sapling){}, "pine_sapling", event.getRegistry());

        pine_slab = registerBlockandItem(new SlabBlock(planks),"pine_slab",event.getRegistry());

        pine_stairs = registerBlockandItem(new StairsBlock(()-> pine_planks.getDefaultState(), planks),"pine_stairs",event.getRegistry());

        pineFence = registerBlockandItem(new FenceBlock(planks),"pine_fence",event.getRegistry());

        pine_pressure_plate = registerBlockandItem(new BlockWoodenPressurePlate(PressurePlateBlock.Sensitivity.EVERYTHING,Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), "pine_pressure_plate", event.getRegistry());

        Block.Properties cob = makeCobProperties();

        blockCob = registerBlockandItem(new Block(cob),"cob", event.getRegistry());

        small_mud_bricks = registerBlockandItem(new Block(cob),"small_mud_bricks", event.getRegistry());
        large_mud_bricks = registerBlockandItem(new Block(cob),"large_mud_bricks", event.getRegistry());

        pineDoor = register(new DoorBlock(Block.Properties.from(Blocks.OAK_DOOR)){},"pine_door",event.getRegistry());

        pine_trapdoor = registerBlockandItem(new TrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)){},"pine_trapdoor",event.getRegistry());

        pine_button = registerBlockandItem(new WoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)){},"pine_button",event.getRegistry());

        pineGate = registerBlockandItem(new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)),"pine_fence_gate",event.getRegistry());

                Block.Properties peat = makePeatProperties();
        BlockRegistrar.peat = registerBlockandItem(new Block(peat),"peat",event.getRegistry());

    }

    private static Block.Properties makeCobProperties() {
        Block.Properties out = Block.Properties.create(Material.EARTH, MaterialColor.ADOBE);
        out.hardnessAndResistance(2.0f);
        out.sound(SoundType.STONE);
        return out;
    }

    private static Block.Properties makeSaplingProperties() {
        Block.Properties out = Block.Properties.create(Material.PLANTS);
        out.doesNotBlockMovement();
        out.tickRandomly();
        out.sound(SoundType.PLANT);
        out.hardnessAndResistance(0f);
        return out;
    }

    private static Block.Properties makePlanksProperties() {
        Block.Properties out = Block.Properties.create(Material.WOOD, MaterialColor.WOOD);
        out.hardnessAndResistance(2.0F, 3.0F);
        out.harvestLevel(0);
        out.harvestTool(ToolType.AXE);
        out.sound(SoundType.WOOD);
        return out;
    }

    private static Block.Properties makePeatProperties() {
        Block.Properties out = Block.Properties.create(Material.EARTH, MaterialColor.DIRT);
        out.hardnessAndResistance(0.8f); // Dense and waterlogged (not in the MC sense)
        out.harvestLevel(0);
        out.harvestTool(ToolType.SHOVEL);
        out.sound(SoundType.GROUND);
        return out;
    }

    private static Block.Properties makeAshProperties() {
        Block.Properties out = Block.Properties.create(Material.SAND, MaterialColor.STONE);
        out.hardnessAndResistance(0.6f);
        out.harvestLevel(0);
        out.harvestTool(ToolType.SHOVEL);
        out.sound(SoundType.SAND);
        return out;
    }

    private static Block.Properties makeLogProperties() {
        Block.Properties out = Block.Properties.create(Material.WOOD, MaterialColor.QUARTZ);
        out.sound(SoundType.WOOD);
        out.hardnessAndResistance(2.0f);
        return out;
    }

    private static Block.Properties makeLeavesProperties() {
        Block.Properties out = Block.Properties.create(Material.LEAVES);
        out.hardnessAndResistance(0.2f);
        out.tickRandomly();
        out.sound(SoundType.PLANT);
        return out;
    }

    private static void makeBlocks() {
        ClimaticBiomes.getLogger().info("Creating Blocks for Climatic Biomes");
        // Basalt, plus variants on vanilla igneus intrusive blocks


        // Pine related blocks

       /* ItemRegistrar.addItem(new ItemFuelBlock(barkPine
                = makePillar(pineLog, "pine_bark"), 300));
        ItemRegistrar.addItem(new ItemFuelBlock(woodPine
                = makePillar(stripped_pine_log, "pine_wood"), 300));

        ItemRegistrar.addItem(new ItemFuelBlock(pine_slab
                = makeSlab(pine_planks, "pine_slab"), 300));
        ItemRegistrar.addItem(new ItemFuelBlock(pine_stairs
                = makeStairs(pine_planks, "pine_stairs"), 300));

        ItemRegistrar.addItem(new ItemFuelBlock(pineGate =
                makeWoodenGate(pine_planks, "pine_gate"), 300, ItemGroup.REDSTONE));
        ItemRegistrar.addItem(new ItemFuelBlock(pineDoor =
                new BlockDoor(pine_planks, "pine_door"), 300, ItemGroup.REDSTONE));
        ItemRegistrar.addItem(new ItemFuelBlock(pine_trapdoor =
                new BlockTrapDoor(pine_planks, "pine_trapdoor"), 300, ItemGroup.REDSTONE));
        ItemRegistrar.addItem(new ItemFuelBlock(pine_pressure_plate =
                new BlockWoodenPressurePlate(pine_planks, "pine_pressure_plate"),
                300, ItemGroup.REDSTONE));
        ItemRegistrar.addItem(new ItemFuelBlock(pine_button =
                new BlockWoodenButton("pine_button"), 100, ItemGroup.REDSTONE));
        ItemRegistrar.addItem(new ItemFuelBlock(pineSapling =
                new BlockSapling(new PineTree(), "pine_sapling"), 100, ItemGroup.DECORATIONS));*/


        // Misc Blocks
//        ItemRegistrar.addItemBlock(blockCob = new BlockCob("cob"), ItemGroup.BUILDING_BLOCKS);
//        ItemRegistrar.addItemBlock(large_mud_bricks = new BlockCob("mud_bricks_large"), ItemGroup.BUILDING_BLOCKS);
//        ItemRegistrar.addItemBlock(small_mud_bricks = new BlockCob("mud_bricks_small"), ItemGroup.BUILDING_BLOCKS);

    }

    private static Block.Properties makeProperties() {
        Block.Properties out = Block.Properties.create(Material.ROCK, MaterialColor.STONE);
        out.hardnessAndResistance(1.75f, 6.4f);
        out.harvestLevel(0);
        out.harvestTool(ToolType.PICKAXE);
        out.sound(SoundType.STONE);
        return out;
    }

    private static SlabBlock makeSlab(Block whole, String name) {
        SlabBlock out = new SlabBlock(Block.Properties.from(whole));
        out.setRegistryName(Info.ID, name);
        return out;
    }


    private static RotatedPillarBlock makePillar(Block whole, String name) {
        RotatedPillarBlock out = new RotatedPillarBlock(Block.Properties.from(whole));
        out.setRegistryName(Info.ID, name);
        return out;
    }


    private static StairsBlock makeStairs(Block whole, String name) {
        BlockStairs out = new BlockStairs(whole.getDefaultState(), Block.Properties.from(whole));
        out.setRegistryName(Info.ID, name);
        return out;
    }


    private static FenceBlock makeWoodenFence(Block whole, String name) {
        FenceBlock out = new FenceBlock(Block.Properties.from(whole)
                .hardnessAndResistance(2.0f, 3.0f));
        out.setRegistryName(Info.ID, name);
        return out;
    }


    private static FenceGateBlock makeWoodenGate(Block whole, String name) {
        FenceGateBlock out = new FenceGateBlock(Block.Properties.from(whole)
                .hardnessAndResistance(2.0f, 3.0f));
        out.setRegistryName(Info.ID, name);
        return out;
    }


}
