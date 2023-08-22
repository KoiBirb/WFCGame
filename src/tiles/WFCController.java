package tiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class WFCController{
    Grid grid;
    int gridSize = 25;
    int tilesAcross = gridSize;
    int tilesDown = gridSize;
    int tileAmount = gridSize * gridSize;

    ArrayList<String> cellChoice = new ArrayList<>(tileAmount - 1);

    // Top Right Bottom Left
    int[]optionGrass = new int[]{1,1,1,1};

    int[]optionPath1 = new int[]{0,0,0,0};
    int[]optionPath1Down = new int[]{0,0,1,0};
    int[]optionPath1Inverted = new int[]{0,0,0,0};
    int[]optionPath1Left1 = new int[]{0,0,0,1};
    int[]optionPath1Left2 = new int[]{0,0,0,1};
    int[]optionPath1LeftDown = new int[]{0,0,1,1};
    int[]optionPath1LeftRight = new int[]{0,1,0,1};
    int[]optionPath1Right = new int[]{0,1,0,0};
    int[]optionPath1Surround = new int[]{1,1,1,1};
    int[]optionPath1Up = new int[]{1,0,0,0};
    int[]optionPath1UpDown = new int[]{1,0,1,0};

    int[]optionPath2 = new int[]{0,0,0,0};
    int[]optionPath2Down = new int[]{0,0,1,0};
    int[]optionPath2LeftUp = new int[]{1,0,0,1};
    int[]optionPath2LeftUpDown = new int[]{1,0,1,1};
    int[]optionPath2Right1 = new int[]{0,1,0,0};
    int[]optionPath2Right2 = new int[]{0,1,0,0};
    int[]optionPath2Up = new int[]{1,0,0,0};
    int[]optionPath2UpDown = new int[]{1,0,1,0};

    int[]optionPath3 = new int[]{0,0,0,0};
    int[]optionPath3Down = new int[]{0,0,1,0};
    int[]optionPath3Left = new int[]{0,0,0,1};
    int[]optionPath3LeftRight = new int[]{0,1,0,1};
    int[]optionPath3LeftRightUp = new int[]{1,1,0,1};
    int[]optionPath3Right = new int[]{0,1,0,0};
    int[]optionPath3RightDown = new int[]{0,1,1,0};

    int[]optionPath4 = new int[]{0,0,0,0};
    int[]optionPath4Left = new int[]{0,0,0,1};
    int[]optionPath4RightUp = new int[]{1,1,0,0};
    int[]optionPath4RightUpDown = new int[]{1,1,1,0};
    int[]optionPath4Up = new int[]{1,0,0,0};
    int[]optionPath4UpDown = new int[]{1,0,1,0};

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


    HashMap<int[], Integer> optionMap = new HashMap<>();

    Weights weight  = new Weights(options);

    public void initialize() {
        optionMap.put(options.get(0), 0);

        optionMap.put(options.get(1), 1);
        optionMap.put(options.get(2), 2);
        optionMap.put(options.get(3), 3);
        optionMap.put(options.get(4), 4);
        optionMap.put(options.get(5), 5);
        optionMap.put(options.get(6), 6);
        optionMap.put(options.get(7), 7);
        optionMap.put(options.get(8), 8);
        optionMap.put(options.get(9), 9);
        optionMap.put(options.get(10), 10);
        optionMap.put(options.get(11), 11);

        optionMap.put(options.get(12), 12);
        optionMap.put(options.get(13), 13);
        optionMap.put(options.get(14), 14);
        optionMap.put(options.get(15), 15);
        optionMap.put(options.get(16), 16);
        optionMap.put(options.get(17), 17);
        optionMap.put(options.get(18), 18);
        optionMap.put(options.get(19), 19);

        optionMap.put(options.get(20), 20);
        optionMap.put(options.get(21), 21);
        optionMap.put(options.get(22), 22);
        optionMap.put(options.get(23), 23);
        optionMap.put(options.get(24), 24);
        optionMap.put(options.get(25), 25);
        optionMap.put(options.get(26), 26);

        optionMap.put(options.get(27), 27);
        optionMap.put(options.get(28), 28);
        optionMap.put(options.get(29), 29);
        optionMap.put(options.get(30), 30);
        optionMap.put(options.get(31), 31);
        optionMap.put(options.get(32), 32);
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
        grid = new Grid(tilesAcross, tilesDown, options);
        waveFunctionCollapse();
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
    private void waveFunctionCollapse(){
        boolean keepGoing = true;
        while (keepGoing){
            keepGoing = grid.collapse();
        }
    }
}

