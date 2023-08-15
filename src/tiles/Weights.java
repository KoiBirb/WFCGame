package tiles;

import java.util.ArrayList;
import java.util.HashMap;

public class Weights{

    public static final double[] weightNull = {1, 1, 1, 1, 1, 1, 1, 1};
    private final ArrayList<int[]>options;

    String cellGrass1Character = "0";
    String cellStoneCharacter = "1";
    String cellWaterCharacter = "2";
    String cellDirtCharacter = "3";
    String cellTreeCharacter = "4";
    String cellSandCharacter = "5";
    String cellGrass2Character = "6";
    String cellFlowersCharacter = "7";
    String cellNullCharacter = "n";

    double[] weightGrass1 = {0.45, 0.10, 0, 0.05, 0.10, 0.05, 0.25, 0};
    double[] weightStone = {0.05, 0.35, 0.05, 0.10, 0, 0.30, 0.15, 0};
    double[] weightWater = {0, 0.15, 0.70, 0, 0.15, 0, 0, 0};
    double[] weightDirt = {0.40, 0.05, 0, 0.30, 0, 0.10, 0.15, 0};
    double[] weightTree = {0.50, 0, 0, 0, 0.20, 0, 0.30, 0};
    double[] weightSand = {0.10, 0.20, 0.05, 0.10, 0, 0.50, 0.05, 0};
    double[] weightGrass2 = {0.20, 0.05, 0, 0.05, 0.10, 0.15, 0.15, 0.20};
    double[] weightFlower = {0, 0, 0, 0, 0, 0, 0.50, 0.50};

    public Weights (ArrayList<int[]>options){
        this.options = options;
    }

    public static HashMap<String, double[]> weightMap = new HashMap<>();
    HashMap<int[], Boolean> grass1CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> stoneCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> waterCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> dirtCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> treeCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> sandCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> grassCompatibility2Map = new HashMap<>();
    HashMap<int[], Boolean> flowerCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> nullCompatibilityMap = new HashMap<>();
    public static HashMap<String, HashMap> tileCompatibilityHashMapFinder = new HashMap<>();

    public void initialize(){
        grass1CompatibilityMap.put(options.get(0), true);
        grass1CompatibilityMap.put(options.get(1), true);
        grass1CompatibilityMap.put(options.get(2), false);
        grass1CompatibilityMap.put(options.get(3), true);
        grass1CompatibilityMap.put(options.get(4), true);
        grass1CompatibilityMap.put(options.get(5), true);
        grass1CompatibilityMap.put(options.get(6), true);
        grass1CompatibilityMap.put(options.get(7), false);

        stoneCompatibilityMap.put(options.get(0), true);
        stoneCompatibilityMap.put(options.get(1), true);
        stoneCompatibilityMap.put(options.get(2), true);
        stoneCompatibilityMap.put(options.get(3), true);
        stoneCompatibilityMap.put(options.get(4), false);
        stoneCompatibilityMap.put(options.get(5), true);
        stoneCompatibilityMap.put(options.get(6), true);
        stoneCompatibilityMap.put(options.get(7), false);

        waterCompatibilityMap.put(options.get(0), false);
        waterCompatibilityMap.put(options.get(1), true);
        waterCompatibilityMap.put(options.get(2), true);
        waterCompatibilityMap.put(options.get(3), false);
        waterCompatibilityMap.put(options.get(4), false);
        waterCompatibilityMap.put(options.get(5), true);
        waterCompatibilityMap.put(options.get(6), false);
        waterCompatibilityMap.put(options.get(7), false);

        dirtCompatibilityMap.put(options.get(0), true);
        dirtCompatibilityMap.put(options.get(1), true);
        dirtCompatibilityMap.put(options.get(2), false);
        dirtCompatibilityMap.put(options.get(3), true);
        dirtCompatibilityMap.put(options.get(4), false);
        dirtCompatibilityMap.put(options.get(5), true);
        dirtCompatibilityMap.put(options.get(6), true);
        dirtCompatibilityMap.put(options.get(7), false);

        treeCompatibilityMap.put(options.get(0), true);
        treeCompatibilityMap.put(options.get(1), false);
        treeCompatibilityMap.put(options.get(2), false);
        treeCompatibilityMap.put(options.get(3), false);
        treeCompatibilityMap.put(options.get(4), true);
        treeCompatibilityMap.put(options.get(5), false);
        treeCompatibilityMap.put(options.get(6), true);
        treeCompatibilityMap.put(options.get(7), false);

        sandCompatibilityMap.put(options.get(0), true);
        sandCompatibilityMap.put(options.get(1), true);
        sandCompatibilityMap.put(options.get(2), true);
        sandCompatibilityMap.put(options.get(3), true);
        sandCompatibilityMap.put(options.get(4), false);
        sandCompatibilityMap.put(options.get(5), true);
        sandCompatibilityMap.put(options.get(6), true);
        sandCompatibilityMap.put(options.get(7), false);

        grassCompatibility2Map.put(options.get(0), true);
        grassCompatibility2Map.put(options.get(1), true);
        grassCompatibility2Map.put(options.get(2), false);
        grassCompatibility2Map.put(options.get(3), true);
        grassCompatibility2Map.put(options.get(4), true);
        grassCompatibility2Map.put(options.get(5), true);
        grassCompatibility2Map.put(options.get(6), true);
        grassCompatibility2Map.put(options.get(7), true);

        flowerCompatibilityMap.put(options.get(0), false);
        flowerCompatibilityMap.put(options.get(1), false);
        flowerCompatibilityMap.put(options.get(2), false);
        flowerCompatibilityMap.put(options.get(3), false);
        flowerCompatibilityMap.put(options.get(4), false);
        flowerCompatibilityMap.put(options.get(5), false);
        flowerCompatibilityMap.put(options.get(6), true);
        flowerCompatibilityMap.put(options.get(7), true);

        nullCompatibilityMap.put(options.get(0), true);
        nullCompatibilityMap.put(options.get(1), true);
        nullCompatibilityMap.put(options.get(2), true);
        nullCompatibilityMap.put(options.get(3), true);
        nullCompatibilityMap.put(options.get(4), true);
        nullCompatibilityMap.put(options.get(5), true);
        nullCompatibilityMap.put(options.get(6), true);
        nullCompatibilityMap.put(options.get(7), true);

        tileCompatibilityHashMapFinder.put(cellGrass1Character,grass1CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellStoneCharacter, stoneCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellWaterCharacter, waterCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellDirtCharacter, dirtCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellTreeCharacter, treeCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellSandCharacter, sandCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellGrass2Character, grassCompatibility2Map);
        tileCompatibilityHashMapFinder.put(cellFlowersCharacter, flowerCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellNullCharacter, nullCompatibilityMap);

        weightMap.put(cellGrass1Character, weightGrass1);
        weightMap.put(cellStoneCharacter, weightStone);
        weightMap.put(cellWaterCharacter, weightWater);
        weightMap.put(cellDirtCharacter, weightDirt);
        weightMap.put(cellTreeCharacter, weightTree);
        weightMap.put(cellSandCharacter, weightSand);
        weightMap.put(cellGrass2Character, weightGrass2);
        weightMap.put(cellFlowersCharacter, weightFlower);
        weightMap.put(cellNullCharacter, weightNull);
    }
}
