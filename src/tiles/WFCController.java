package tiles;

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

    ArrayList<String> cellChoice = new ArrayList<>(tileAmount - 1);

    int cellGrass1Number = 0;
    int cellStoneNumber = 1;
    int cellWaterNumber = 2;
    int cellDirtNumber = 3;
    int cellTreeNumber = 4;
    int cellSandNumber = 5;
    int cellGrass2Number = 6;
    int cellFlowersNumber = 7;

    int[]optionGrass1 = new int[]{0,0,0,0};
    int[]optionStone = new int[]{0,0,0,0};
    int[]optionWater = new int[]{0,0,0,0};
    int[]optionDirt = new int[]{0,0,0,0};
    int[]optionTree = new int[]{0,0,0,0};
    int[]optionSand = new int[]{0,0,0,0};
    int[]optionGrass2 = new int[]{0,0,0,0};
    int[]optionFlower = new int[]{0,0,0,0};

    ArrayList<int[]> options = new ArrayList<>(Arrays.asList(optionGrass1, optionStone, optionWater,
            optionDirt, optionTree, optionSand, optionGrass2, optionFlower));
    HashMap<int[], Integer> optionMap = new HashMap<>();

    Weights weight  = new Weights(options);

    public void initialize() {
        optionMap.put(optionGrass1, cellGrass1Number);
        optionMap.put(optionStone, cellStoneNumber);
        optionMap.put(optionWater, cellWaterNumber);
        optionMap.put(optionDirt, cellDirtNumber);
        optionMap.put(optionTree, cellTreeNumber);
        optionMap.put(optionSand, cellSandNumber);
        optionMap.put(optionGrass2, cellGrass2Number);
        optionMap.put(optionFlower, cellFlowersNumber);
        weight.initialize();
        setupFile();
        updateFile();
    }

    private void setupFile(){
        try{
            File directory = new File ("src/Assets/maps");
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
            FileWriter mapWriter = new FileWriter("src/Assets/maps/map.txt");

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

