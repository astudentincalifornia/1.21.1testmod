package com.thegreendino.gaymarmod.block;

import com.thegreendino.gaymarmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import java.util.function.Supplier;
import com.thegreendino.gaymarmod.GaymarMod;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Modblocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GaymarMod.MODID);

    public static final DeferredBlock<Block> VOIDIUM_BLOCK = registerBlock("voidium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(10.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> VOIDIUM_ORE = registerBlock("voidium_ore",
            () -> new DropExperienceBlock(UniformInt.of(5, 10),
                    BlockBehaviour.Properties.of()
                            .strength(6.0f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.HEAVY_CORE)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void  registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
