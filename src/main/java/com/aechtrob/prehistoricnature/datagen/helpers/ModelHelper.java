package com.aechtrob.prehistoricnature.datagen.helpers;

import com.google.common.collect.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.registries.*;

import java.util.*;
import java.util.function.*;

public class ModelHelper {

    private static LinkedHashMultimap<RegistryObject<Block>, Consumer> blockModels = LinkedHashMultimap.create();

    public static void addBlockModel(RegistryObject<Block> block, Consumer<RegistryObject<Block>> consumer){
        blockModels.put(block, consumer);
    }

    public static LinkedHashMultimap<RegistryObject<Block>, Consumer>getBlockModels(){
        return  blockModels;
    }
}
