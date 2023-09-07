package WaveFunctionCollapse.Objects;

import java.util.ArrayList;
import java.util.HashMap;

public class ObjectWeights {

    public static final double[] weightNull = {1,1,1,1,1,1,1};
    private final ArrayList<int[]>options;

    String cellBlankCharacter = "0";

    String cellGrass1Character = "1";
    String cellGrass2Character = "2";
    String cellGrass3Character = "3";
    String cellGrass4Character = "4";
    String cellGrass5Character = "5";
    String cellGrass6Character = "6";

    String cellNullCharacter = "n";

    // Weights in percents Order from option index 0 - 6
    double[] weightBlank = {0.14,0.14,0.14,0.14,0.14,0.14,0.14};

    double[] weightGrass1 = {0.14,0.14,0.14,0.14,0.14,0.14,0.14};
    double[] weightGrass2 = {0.14,0.14,0.14,0.14,0.14,0.14,0.14};
    double[] weightGrass3 = {0.14,0.14,0.14,0.14,0.14,0.14,0.14};
    double[] weightGrass4 = {0.14,0.14,0.14,0.14,0.14,0.14,0.14};
    double[] weightGrass5 = {0.14,0.14,0.14,0.14,0.14,0.14,0.14};
    double[] weightGrass6 = {0.14,0.14,0.14,0.14,0.14,0.14,0.14};

    public ObjectWeights(ArrayList<int[]>options){
        this.options = options;
    }

    public static HashMap<String, HashMap> compatibilityMapFinder = new HashMap<>();

    public static HashMap<int[], Boolean> blankTileCompatibilityMap = new HashMap<>();

    public static HashMap<int[], Boolean> grass1TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass2TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass3TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass4TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass5TileCompatibilityMap = new HashMap<>();
    public static HashMap<int[], Boolean> grass6TileCompatibilityMap = new HashMap<>();

    public static HashMap<String, double[]> weightMap = new HashMap<>();

    public void initialize(){

        for (int i = 0; i < options.size(); i++) {
            blankTileCompatibilityMap.put(options.get(i), true);

            if (i == 0) {
                grass1TileCompatibilityMap.put(options.get(0), true);
                grass2TileCompatibilityMap.put(options.get(0), true);
                grass3TileCompatibilityMap.put(options.get(0), true);
                grass4TileCompatibilityMap.put(options.get(0), true);
                grass5TileCompatibilityMap.put(options.get(0), true);
                grass6TileCompatibilityMap.put(options.get(0), true);
            } else {
                grass1TileCompatibilityMap.put(options.get(i), false);
                grass2TileCompatibilityMap.put(options.get(i), false);
                grass3TileCompatibilityMap.put(options.get(i), false);
                grass4TileCompatibilityMap.put(options.get(i), false);
                grass5TileCompatibilityMap.put(options.get(i), false);
                grass6TileCompatibilityMap.put(options.get(i), false);
            }
        }

        compatibilityMapFinder.put(cellBlankCharacter, blankTileCompatibilityMap);

        compatibilityMapFinder.put(cellGrass1Character, grass1TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass2Character, grass2TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass3Character, grass3TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass4Character, grass4TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass5Character, grass5TileCompatibilityMap);
        compatibilityMapFinder.put(cellGrass6Character, grass6TileCompatibilityMap);

        weightMap.put(cellBlankCharacter, weightBlank);

        weightMap.put(cellGrass1Character, weightGrass1);
        weightMap.put(cellGrass2Character, weightGrass2);
        weightMap.put(cellGrass3Character, weightGrass3);
        weightMap.put(cellGrass4Character, weightGrass4);
        weightMap.put(cellGrass5Character, weightGrass5);
        weightMap.put(cellGrass6Character, weightGrass6);

        weightMap.put(cellNullCharacter, weightNull);
    }
}
