package com.aechtrob.prehistoricnature.block.trees;

import net.minecraft.world.level.block.state.properties.*;
import org.checkerframework.checker.units.qual.*;

import java.util.*;

public class WoodTypeHelper {
    private static ArrayList<WoodType> woodTypes = new ArrayList<>();

    public static WoodType putWoodType(WoodType woodType){
        woodTypes.add(woodType);
        return woodType;
    }

    public static ArrayList<WoodType> getWoodTypes(){
        return woodTypes;
    }
}
