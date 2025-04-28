package com.thegreendino.gaymarmod.item;

import com.thegreendino.gaymarmod.GaymarMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GaymarMod.MODID);
    public static final DeferredItem<Item> VOIDIUM = ITEMS.register("voidium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_VOIDIUM = ITEMS.register("raw_voidium",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}


