package WaveFunctionCollapse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class WFCController{
    Grid grid;
    int gridSize = 50;
    int tilesAcross = gridSize;
    int tilesDown = gridSize;
    int tileAmount = gridSize * gridSize;

    ArrayList<String> cellChoice = new ArrayList<>();

    // Top Right Bottom Left
    int[]optionGrass = new int[]{1,1,1,1};

    int[]optionPath1 = new int[]{0,0,0,0};
    int[]optionPath1Down = new int[]{0,0,2,0};
    int[]optionPath1Inverted = new int[]{0,0,0,0};
    int[]optionPath1Left1 = new int[]{0,0,0,2};
    int[]optionPath1Left2 = new int[]{0,0,0,2};
    int[]optionPath1LeftDown = new int[]{0,0,2,2};
    int[]optionPath1LeftRight = new int[]{0,2,0,2};
    int[]optionPath1Right = new int[]{0,2,0,0};
    int[]optionPath1Surround = new int[]{2,2,2,2};
    int[]optionPath1Up = new int[]{2,0,0,0};
    int[]optionPath1UpDown = new int[]{2,0,2,0};

    int[]optionPath2 = new int[]{0,0,0,0};
    int[]optionPath2Down = new int[]{0,0,2,0};
    int[]optionPath2LeftUp = new int[]{2,0,0,2};
    int[]optionPath2LeftUpDown = new int[]{2,0,2,2};
    int[]optionPath2Right1 = new int[]{0,2,0,0};
    int[]optionPath2Right2 = new int[]{0,2,0,0};
    int[]optionPath2Up = new int[]{2,0,0,0};
    int[]optionPath2UpDown = new int[]{2,0,2,0};

    int[]optionPath3 = new int[]{0,0,0,0};
    int[]optionPath3Down = new int[]{0,0,2,0};
    int[]optionPath3Left = new int[]{0,0,0,2};
    int[]optionPath3LeftRight = new int[]{0,2,0,2};
    int[]optionPath3LeftRightUp = new int[]{2,2,0,2};
    int[]optionPath3Right = new int[]{0,2,0,0};
    int[]optionPath3RightDown = new int[]{0,2,2,0};

    int[]optionPath4 = new int[]{0,0,0,0};
    int[]optionPath4Left = new int[]{0,0,0,2};
    int[]optionPath4RightUp = new int[]{2,2,0,0};
    int[]optionPath4RightUpDown = new int[]{2,2,2,0};
    int[]optionPath4Up = new int[]{2,0,0,0};
    int[]optionPath4UpDown = new int[]{2,0,2,0};

    ArrayList<int[]> options = new ArrayList<>(Arrays.asList(
            optionGrass,

            optionPath1, optionPath1Down, optionPath1Inverted, optionPath1Left1,
            optionPath1Left2, optionPath1LeftDown, optionPath1LeftRight, optionPath1Right, optionPath1Surround,
            optionPath1Up, optionPath1UpDown,

            optionPath2, optionPath2Down, optionPath2LeftUp, optionPath2LeftUpDown,
            optionPath2Right1, optionPath2Right2, optionPath2Up, optionPath2UpDown,

            optionPath3, optionPath3Down, optionPath3Left, optionPath3LeftRight,
            optionPath3LeftRightUp, optionPath3Right, optionPath3RightDown,

            optionPath4, optionPath4Left, optionPath4RightUp, optionPath4RightUpDown,
            optionPath4Up, optionPath4UpDown));

    int similarAdjacentTileRequirementGrass = 1;

    int similarAdjacentTileRequirementPath1 = 0;
    int similarAdjacentTileRequirementPath1Down = 0;
    int similarAdjacentTileRequirementPath1Inverted = 0;
    int similarAdjacentTileRequirementPath1Left1 = 0;
    int similarAdjacentTileRequirementPath1Left2 = 0;
    int similarAdjacentTileRequirementPath1LeftDown = 0;
    int similarAdjacentTileRequirementPath1LeftRight = 0;
    int similarAdjacentTileRequirementPath1Right = 0;
    int similarAdjacentTileRequirementPath1Surround = 0;
    int similarAdjacentTileRequirementPath1Up = 0;
    int similarAdjacentTileRequirementPath1UpDown = 0;

    int similarAdjacentTileRequirementPath2 = 0;
    int similarAdjacentTileRequirementPath2Down = 0;
    int similarAdjacentTileRequirementPath2LeftUp = 0;
    int similarAdjacentTileRequirementPath2LeftUpDown = 0;
    int similarAdjacentTileRequirementPath2Right1 = 0;
    int similarAdjacentTileRequirementPath2Right2 = 0;
    int similarAdjacentTileRequirementPath2Up = 0;
    int similarAdjacentTileRequirementPath2UpDown = 0;

    int similarAdjacentTileRequirementPath3 = 0;
    int similarAdjacentTileRequirementPath3Down = 0;
    int similarAdjacentTileRequirementPath3Left = 0;
    int similarAdjacentTileRequirementPath3LeftRight = 0;
    int similarAdjacentTileRequirementPath3LeftRightUp = 0;
    int similarAdjacentTileRequirementPath3Right = 0;
    int similarAdjacentTileRequirementPath3RightDown = 0;

    int similarAdjacentTileRequirementPath4 = 0;
    int similarAdjacentTileRequirementPath4Left = 0;
    int similarAdjacentTileRequirementPath4RightUp = 0;
    int similarAdjacentTileRequirementPath4RightUpDown = 0;
    int similarAdjacentTileRequirementPath4Up = 0;
    int similarAdjacentTileRequirementPath4UpDown = 0;

    ArrayList<Integer> similarAdjacentTileRequirements = new ArrayList<>(Arrays.asList(
            similarAdjacentTileRequirementGrass,

            similarAdjacentTileRequirementPath1,
            similarAdjacentTileRequirementPath1Down,
            similarAdjacentTileRequirementPath1Inverted,
            similarAdjacentTileRequirementPath1Left1,
            similarAdjacentTileRequirementPath1Left2,
            similarAdjacentTileRequirementPath1LeftDown,
            similarAdjacentTileRequirementPath1LeftRight,
            similarAdjacentTileRequirementPath1Right,
            similarAdjacentTileRequirementPath1Surround,
            similarAdjacentTileRequirementPath1Up,
            similarAdjacentTileRequirementPath1UpDown,

            similarAdjacentTileRequirementPath2,
            similarAdjacentTileRequirementPath2Down,
            similarAdjacentTileRequirementPath2LeftUp,
            similarAdjacentTileRequirementPath2LeftUpDown,
            similarAdjacentTileRequirementPath2Right1,
            similarAdjacentTileRequirementPath2Right2,
            similarAdjacentTileRequirementPath2Up,
            similarAdjacentTileRequirementPath2UpDown,

            similarAdjacentTileRequirementPath3,
            similarAdjacentTileRequirementPath3Down,
            similarAdjacentTileRequirementPath3Left,
            similarAdjacentTileRequirementPath3LeftRight,
            similarAdjacentTileRequirementPath3LeftRightUp,
            similarAdjacentTileRequirementPath3Right,
            similarAdjacentTileRequirementPath3RightDown,

            similarAdjacentTileRequirementPath4,
            similarAdjacentTileRequirementPath4Left,
            similarAdjacentTileRequirementPath4RightUp,
            similarAdjacentTileRequirementPath4RightUpDown,
            similarAdjacentTileRequirementPath4Up,
            similarAdjacentTileRequirementPath4UpDown
    ));

    HashMap<Integer, HashMap<Integer, Boolean>> optionCompatibilityMap = new HashMap<>();
    HashMap<Integer, Boolean> optionCompatibilityMapKey0 = new HashMap<>();
    HashMap<Integer, Boolean> optionCompatibilityMapKey1 = new HashMap<>();
    HashMap<Integer, Boolean> optionCompatibilityMapKey2 = new HashMap<>();
    HashMap<int[], Integer> optionMap = new HashMap<>();

    Weights weight  = new Weights(options);

    public void initialize() {
        optionCompatibilityMap.put(0, optionCompatibilityMapKey0);
        optionCompatibilityMap.put(1, optionCompatibilityMapKey1);
        optionCompatibilityMap.put(2, optionCompatibilityMapKey2);

        optionCompatibilityMapKey0.put(0, true);
        optionCompatibilityMapKey0.put(1, false);
        optionCompatibilityMapKey0.put(2, false);

        optionCompatibilityMapKey1.put(0, false);
        optionCompatibilityMapKey1.put(1, true);
        optionCompatibilityMapKey1.put(2, true);

        optionCompatibilityMapKey2.put(0, false);
        optionCompatibilityMapKey2.put(1, true);
        optionCompatibilityMapKey2.put(2, false);

       for (int i = 0; i < options.size(); i++) {
           optionMap.put(options.get(i), i);
       }
        weight.initialize();
        setupFile();
        updateFile();
    }

    private void setupFile(){
        try{
            File directory = new File ("src/Assets/Map");
            File newMap = new File(directory, "map.txt");
            newMap.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        grid = new Grid(tilesAcross, tilesDown, options, optionMap, optionCompatibilityMap, similarAdjacentTileRequirements);
        waveFunctionCollapse(false);
        grid.cleanUp();
        waveFunctionCollapse(true);
    }

    private void updateFile() {
        for (int i = 0; i < tileAmount; i++) {

            ArrayList<int[]> cellOptions = grid.getGrid().get(i).getOptions();

            if (cellOptions.size() == 1) {
                cellChoice.add(i, String.valueOf(optionMap.get(cellOptions.get(0))));
            }
        }
        try {
            FileWriter mapWriter = new FileWriter("src/Assets/Map/map.txt");

            for (int i = 0; i < tileAmount; i++){
                if (i % gridSize != 0 || i == 0) {
                    mapWriter.write(cellChoice.get(i) + " ");
                } else {
                    mapWriter.write("\n" + cellChoice.get(i) + " ");
                }
            }
            mapWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void waveFunctionCollapse(boolean cleanUp){
        boolean keepGoing = true;
        while (keepGoing){
            keepGoing = grid.collapse(cleanUp);
        }
    }
}

