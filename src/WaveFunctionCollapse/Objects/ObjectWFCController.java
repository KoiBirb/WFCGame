package WaveFunctionCollapse.Objects;

import WaveFunctionCollapse.Cell;
import WaveFunctionCollapse.tiles.TileGrid;
import WaveFunctionCollapse.tiles.TileWFCController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class ObjectWFCController {
    ObjectGrid grid;

    public final int gridSize = 25;
    public final int tilesAcross = gridSize;
    public final int tilesDown = gridSize;
    public final int tileAmount = gridSize * gridSize;

    ArrayList<String> cellChoice = new ArrayList<>();


    // Top Right Bottom Left
    int[]optionNull = new int[]{0,0,0,0};
    int[]optionGrass1 = new int[]{0,0,0,0};
    int[]optionGrass2 = new int[]{0,0,0,0};
    int[]optionGrass3 = new int[]{0,0,0,0};
    int[]optionGrass4 = new int[]{0,0,0,0};
    int[]optionGrass5 = new int[]{0,0,0,0};
    int[]optionGrass6 = new int[]{0,0,0,0};

    ArrayList<int[]> optionsObject = new ArrayList<>(Arrays.asList( optionNull,
            optionGrass1, optionGrass2, optionGrass3, optionGrass4, optionGrass5, optionGrass6
            ));

    HashMap<Integer, HashMap<Integer, Boolean>> optionCompatibilityMap = new HashMap<>();
    HashMap<Integer, Boolean> optionCompatibilityMapKey0 = new HashMap<>();

    HashMap<int[], Integer> optionMap = new HashMap<>();


    public void initialize(ArrayList<Cell> tileGrid, ArrayList<int[]> options, HashMap<int[], Integer> tileOptionMap) {

        optionCompatibilityMap.put(0, optionCompatibilityMapKey0);

        optionCompatibilityMapKey0.put(0, true);

        for (int i = 0; i < optionsObject.size(); i++) {
            optionMap.put(optionsObject.get(i), i);
        }
        ObjectWeights weight  = new ObjectWeights (options);
        weight.initialize();
        setupFile(tileGrid, tileOptionMap);
        updateFile();
    }

    private void setupFile(ArrayList<Cell> tileGrid, HashMap<int[], Integer> tileOptionMap){
        try{
            File directory = new File ("src/Assets/Maps");
            File newMap = new File(directory, "objectMap.txt");
            newMap.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(tileGrid.get(0).isCollapsed());
        grid = new ObjectGrid(tilesAcross, tilesDown, optionsObject, optionMap, optionCompatibilityMap, tileGrid, tileOptionMap);
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
            FileWriter mapWriter = new FileWriter("src/Assets/Maps/objectMap.txt");

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

