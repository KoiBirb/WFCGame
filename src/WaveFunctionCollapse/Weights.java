package WaveFunctionCollapse;

import java.util.ArrayList;
import java.util.HashMap;

public class Weights{

    public static final double[] weightNull = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private final ArrayList<int[]>options;

    String cellGrassCharacter = "0";

    String cellPath1Character = "1";
    String cellPath1DownCharacter = "2";
    String cellPath1InvertedCharacter = "3";
    String cellPath1Left1Character = "4";
    String cellPath1Left2Character = "5";
    String cellPath1LeftDownCharacter = "6";
    String cellPath1LeftRightCharacter = "7";
    String cellPath1RightCharacter = "8";
    String cellPath1SurroundCharacter = "9";
    String cellPath1UpCharacter = "10";
    String cellPath1UpDownCharacter = "11";

    String cellPath2Character = "12";
    String cellPath2DownCharacter = "13";
    String cellPath2LeftUpCharacter = "14";
    String cellPath2LeftUpDownCharacter = "15";
    String cellPath2Right1Character = "16";
    String cellPath2Right2Character = "17";
    String cellPath2UpCharacter = "18";
    String cellPath2UpDownCharacter = "19";

    String cellPath3Character = "20";
    String cellPath3DownCharacter = "21";
    String cellPath3LeftCharacter = "22";
    String cellPath3LeftRightCharacter = "23";
    String cellPath3LeftRightUpCharacter = "24";
    String cellPath3RightCharacter = "25";
    String cellPath3RightDownCharacter = "26";

    String cellPath4Character = "27";
    String cellPath4LeftCharacter = "28";
    String cellPath4RightUpCharacter = "29";
    String cellPath4RightUpDownCharacter = "30";
    String cellPath4UpCharacter = "31";
    String cellPath4UpDownCharacter = "32";

    String cellNullCharacter = "n";

    // Weights in percents Order from option index 0 - 32
    double[] weightGrass = {0.5, 0, 0.017, 0, 0.017, 0.017, 0.017, 0.017, 0.017, 0.017, 0.017, 0.017, 0, 0.017, 0.017, 0.017, 0.017, 0.017, 0.017, 0.017, 0, 0.017, 0.017, 0.017, 0.017, 0.017, 0.017, 0, 0.017, 0.017, 0.017, 0.017, 0.017};

    double[] weightPath1 = {0, 0.03, 0.03, 0.001, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03};
    double[] weightPath1Down = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1Inverted = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1Left1 = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1Left2 = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1LeftDown = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1LeftRight = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1Right = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1Surround = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1Up = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath1UpDown = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};

    double[] weightPath2 = {0, 0.03, 0.03, 0.001, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03};
    double[] weightPath2Down = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath2LeftUp = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath2LeftUpDown = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath2Right1 = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath2Right2 = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath2Up = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath2UpDown = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};

    double[] weightPath3 = {0, 0.03, 0.03, 0.001, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03};
    double[] weightPath3Down = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath3Left = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath3LeftRight = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath3LeftRightUp = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath3Right = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath3RightDown = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};

    double[] weightPath4 = {0, 0.03, 0.03, 0.001, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03, 0.03};
    double[] weightPath4Left = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath4RightUp = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath4RightUpDown = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath4Up = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};
    double[] weightPath4UpDown = {0.5, 0.016, 0.016, 0.001, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016, 0.016,  0.016};

    public Weights (ArrayList<int[]>options){
        this.options = options;
    }

    public static HashMap<String, double[]> weightMap = new HashMap<>();

    HashMap<int[], Boolean> grassCompatibilityMap = new HashMap<>();

    HashMap<int[], Boolean> path1CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1DownCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> Path1InvertedCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1Left1CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1Left2CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1LeftDownCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1LeftRightCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1RightCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1SurroundCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1UpCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path1UpDownCompatibilityMap = new HashMap<>();

    HashMap<int[], Boolean> path2CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path2DownCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path2LeftUpCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path2LeftUpDownCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path2Right1CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path2Right2CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path2UpCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path2UpDownCompatibilityMap = new HashMap<>();

    HashMap<int[], Boolean> path3CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path3DownCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path3LeftCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path3LeftRightCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path3LeftRightUpCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path3RightCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path3RightDownCompatibilityMap = new HashMap<>();

    HashMap<int[], Boolean> path4CompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path4LeftCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path4RightUpCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path4RightUpDownCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path4UpCompatibilityMap = new HashMap<>();
    HashMap<int[], Boolean> path4UpDownCompatibilityMap = new HashMap<>();

    HashMap<int[], Boolean> nullCompatibilityMap = new HashMap<>();

    public static HashMap<String, HashMap> tileCompatibilityHashMapFinder = new HashMap<>();

    public void initialize(){

        for (int i = 0; i < options.size(); i++) {

            if (i != 1 || i != 12 || i != 20 || i != 27) {
                grassCompatibilityMap.put(options.get(i), true);
            } else {
                grassCompatibilityMap.put(options.get(i), false);
            }

            if (i == 0){
                path1CompatibilityMap.put(options.get(i), false);
                path2CompatibilityMap.put(options.get(i), false);
                path3CompatibilityMap.put(options.get(i), false);
                path4CompatibilityMap.put(options.get(i), false);
            } else {
                path1CompatibilityMap.put(options.get(i), true);
                path2CompatibilityMap.put(options.get(i), true);
                path3CompatibilityMap.put(options.get(i), true);
                path4CompatibilityMap.put(options.get(i), true);
            }


            path1DownCompatibilityMap.put(options.get(i), true);
            Path1InvertedCompatibilityMap.put(options.get(i), true);
            Path1InvertedCompatibilityMap.put(options.get(i), true);
            path1Left1CompatibilityMap.put(options.get(i), true);
            path1Left2CompatibilityMap.put(options.get(i), true);
            path1LeftDownCompatibilityMap.put(options.get(i), true);
            path1LeftRightCompatibilityMap.put(options.get(i), true);
            path1LeftRightCompatibilityMap.put(options.get(i), true);
            path1RightCompatibilityMap.put(options.get(i), true);
            path1SurroundCompatibilityMap.put(options.get(i), true);
            path1UpCompatibilityMap.put(options.get(i), true);
            path1UpCompatibilityMap.put(options.get(i), true);
            path1UpDownCompatibilityMap.put(options.get(i), true);

            path2DownCompatibilityMap.put(options.get(i), true);
            path2LeftUpCompatibilityMap.put(options.get(i), true);
            path2LeftUpDownCompatibilityMap.put(options.get(i), true);
            path2Right1CompatibilityMap.put(options.get(i), true);
            path2Right2CompatibilityMap.put(options.get(i), true);
            path2UpCompatibilityMap.put(options.get(i), true);
            path2UpDownCompatibilityMap.put(options.get(i), true);

            path3DownCompatibilityMap.put(options.get(i), true);
            path3LeftCompatibilityMap.put(options.get(i), true);
            path3LeftRightCompatibilityMap.put(options.get(i), true);
            path3LeftRightUpCompatibilityMap.put(options.get(i), true);
            path3RightCompatibilityMap.put(options.get(i), true);
            path3RightDownCompatibilityMap.put(options.get(i), true);

            path4LeftCompatibilityMap.put(options.get(i), true);
            path4RightUpCompatibilityMap.put(options.get(i), true);
            path4RightUpDownCompatibilityMap.put(options.get(i), true);
            path4UpCompatibilityMap.put(options.get(i), true);
            path4UpDownCompatibilityMap.put(options.get(i), true);

            nullCompatibilityMap.put(options.get(i), false);
        }

        tileCompatibilityHashMapFinder.put(cellGrassCharacter,grassCompatibilityMap);

        tileCompatibilityHashMapFinder.put(cellPath1Character,path1CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1DownCharacter,path1DownCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1InvertedCharacter,Path1InvertedCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1Left1Character,path1Left1CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1Left2Character,path1Left2CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1LeftDownCharacter,path1LeftDownCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1LeftRightCharacter,path1LeftRightCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1RightCharacter,path1RightCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1SurroundCharacter,path1SurroundCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1UpCharacter,path1UpCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath1UpDownCharacter,path1UpDownCompatibilityMap);

        tileCompatibilityHashMapFinder.put(cellPath2Character,path2CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath2DownCharacter,path2DownCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath2LeftUpCharacter,path2LeftUpCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath2LeftUpDownCharacter,path2LeftUpDownCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath2Right1Character,path2Right1CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath2Right2Character,path2Right2CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath2UpCharacter,path2UpCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath2UpDownCharacter,path2UpDownCompatibilityMap);

        tileCompatibilityHashMapFinder.put(cellPath3Character,path3CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath3DownCharacter,path3DownCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath3LeftCharacter,path3LeftCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath3LeftRightCharacter,path3LeftRightCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath3LeftRightUpCharacter,path3LeftRightUpCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath3RightCharacter,path3RightCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath3RightDownCharacter,path3RightDownCompatibilityMap);

        tileCompatibilityHashMapFinder.put(cellPath4Character,path4CompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath4LeftCharacter,path4LeftCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath4RightUpCharacter,path4RightUpCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath4RightUpDownCharacter,path4RightUpDownCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath4UpCharacter,path4UpCompatibilityMap);
        tileCompatibilityHashMapFinder.put(cellPath4UpDownCharacter,path4UpDownCompatibilityMap);

        tileCompatibilityHashMapFinder.put(cellNullCharacter,nullCompatibilityMap);

        weightMap.put(cellGrassCharacter, weightGrass);

        weightMap.put(cellPath1Character, weightPath1);
        weightMap.put(cellPath1DownCharacter, weightPath1Down);
        weightMap.put(cellPath1InvertedCharacter, weightPath1Inverted);
        weightMap.put(cellPath1Left1Character, weightPath1Left1);
        weightMap.put(cellPath1Left2Character, weightPath1Left2);
        weightMap.put(cellPath1LeftDownCharacter, weightPath1LeftDown);
        weightMap.put(cellPath1LeftRightCharacter, weightPath1LeftRight);
        weightMap.put(cellPath1RightCharacter, weightPath1Right);
        weightMap.put(cellPath1SurroundCharacter, weightPath1Surround);
        weightMap.put(cellPath1UpCharacter, weightPath1Up);
        weightMap.put(cellPath1UpDownCharacter, weightPath1UpDown);

        weightMap.put(cellPath2Character, weightPath2);
        weightMap.put(cellPath2DownCharacter, weightPath2Down);
        weightMap.put(cellPath2LeftUpCharacter, weightPath2LeftUp);
        weightMap.put(cellPath2LeftUpDownCharacter, weightPath2LeftUpDown);
        weightMap.put(cellPath2Right1Character, weightPath2Right1);
        weightMap.put(cellPath2Right2Character, weightPath2Right2);
        weightMap.put(cellPath2UpCharacter, weightPath2Up);
        weightMap.put(cellPath2UpDownCharacter, weightPath2UpDown);

        weightMap.put(cellPath3Character, weightPath3);
        weightMap.put(cellPath3DownCharacter, weightPath3Down);
        weightMap.put(cellPath3LeftCharacter, weightPath3Left);
        weightMap.put(cellPath3LeftRightCharacter, weightPath3LeftRight);
        weightMap.put(cellPath3LeftRightUpCharacter, weightPath3LeftRightUp);
        weightMap.put(cellPath3RightCharacter, weightPath3Right);
        weightMap.put(cellPath3RightDownCharacter, weightPath3RightDown);

        weightMap.put(cellPath4Character, weightPath4);
        weightMap.put(cellPath4LeftCharacter, weightPath4Left);
        weightMap.put(cellPath4RightUpCharacter, weightPath4RightUp);
        weightMap.put(cellPath4RightUpDownCharacter, weightPath4RightUpDown);
        weightMap.put(cellPath4UpCharacter, weightPath4Up);
        weightMap.put(cellPath4UpDownCharacter, weightPath4UpDown);

        weightMap.put(cellNullCharacter, weightNull);
    }
}
