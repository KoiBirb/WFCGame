package WaveFunctionCollapse.Objects;

import WaveFunctionCollapse.Cell;
import WaveFunctionCollapse.tiles.TileWFCController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class ObjectWFCController {
    public ObjectGrid grid;

    public final int gridSize = 40;
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

    int[]optionBush1 = new int[]{0,0,0,0};
    int[]optionBush2 = new int[]{0,0,0,0};
    int[]optionBush3 = new int[]{0,0,0,0};
    int[]optionBush4 = new int[]{0,0,0,0};
    int[]optionBush5 = new int[]{0,0,0,0};
    int[]optionBush6 = new int[]{0,0,0,0};

    int[]optionCamp1 = new int[]{0,0,0,0};
    int[]optionCamp2 = new int[]{0,0,0,0};

    int[]optionStone1 = new int[]{0,0,0,0};
    int[]optionStone2 = new int[]{0,0,0,0};
    int[]optionStone3 = new int[]{0,0,0,0};
    int[]optionStone4 = new int[]{0,0,0,0};
    int[]optionStone5 = new int[]{0,0,0,0};
    int[]optionStone6 = new int[]{0,0,0,0};
    int[]optionStone7 = new int[]{0,0,0,0};
    int[]optionStone8 = new int[]{0,0,0,0};
    int[]optionStone9 = new int[]{0,0,0,0};
    int[]optionStone10 = new int[]{0,0,0,0};
    int[]optionStone11 = new int[]{0,0,0,0};
    int[]optionStone12 = new int[]{0,0,0,0};
    int[]optionStone13 = new int[]{0,0,0,0};
    int[]optionStone14 = new int[]{0,0,0,0};
    int[]optionStone15 = new int[]{0,0,0,0};
    int[]optionStone16 = new int[]{0,0,0,0};

    int[]optionFlower1 = new int[]{0,0,0,0};
    int[]optionFlower2 = new int[]{0,0,0,0};
    int[]optionFlower3 = new int[]{0,0,0,0};
    int[]optionFlower4 = new int[]{0,0,0,0};
    int[]optionFlower5 = new int[]{0,0,0,0};
    int[]optionFlower6 = new int[]{0,0,0,0};
    int[]optionFlower7 = new int[]{0,0,0,0};
    int[]optionFlower8 = new int[]{0,0,0,0};
    int[]optionFlower9 = new int[]{0,0,0,0};
    int[]optionFlower10 = new int[]{0,0,0,0};
    int[]optionFlower11 = new int[]{0,0,0,0};
    int[]optionFlower12 = new int[]{0,0,0,0};

    int[]optionBox1 = new int[]{0,0,0,0};
    int[]optionBox2 = new int[]{0,0,0,0};
    int[]optionBox3 = new int[]{0,0,0,0};
    int[]optionBox4 = new int[]{0,0,0,0};
    int[]optionLamp1 = new int[]{0,0,0,0};
    int[]optionLamp2 = new int[]{0,0,0,0};
    int[]optionLamp3 = new int[]{0,0,0,0};
    int[]optionLog1 = new int[]{0,0,0,0};
    int[]optionLog2 = new int[]{0,0,0,0};
    int[]optionLog3 = new int[]{0,0,0,0};
    int[]optionLog4 = new int[]{0,0,0,0};
    int[]optionTree1 = new int[]{0,0,0,0};
    int[]optionTree2 = new int[]{0,0,0,0};

    int[]optionCampfireUnlit = new int[]{0,0,0,0};
    int[]optionCampfireLit = new int[]{0,0,0,0};

    ArrayList<int[]> optionsObject = new ArrayList<>(Arrays.asList( optionNull,
            optionGrass1, optionGrass2, optionGrass3, optionGrass4, optionGrass5, optionGrass6,

            optionBush1,optionBush2,optionBush3,optionBush4,optionBush5,optionBush6,

            optionCamp1,optionCamp2,

            optionStone1,optionStone2,optionStone3,optionStone4,optionStone5,optionStone6,optionStone7,
            optionStone8,optionStone9,optionStone10,optionStone11,optionStone12,optionStone13,optionStone14,optionStone15,optionStone16,

            optionFlower1,optionFlower2,optionFlower3,optionFlower4,optionFlower5,optionFlower6,optionFlower7,
            optionFlower8,optionFlower9, optionFlower10,optionFlower11,optionFlower12,

            optionBox1,optionBox2,optionBox3,optionBox4,optionLamp1,optionLamp2,optionLamp3,
            optionLog1,optionLog2,optionLog3,optionLog4,optionTree1,optionTree2,

            optionCampfireUnlit,optionCampfireLit
            ));

    HashMap<int[], Integer> optionMap = new HashMap<>();


    public void initialize(ArrayList<Cell> tileGrid, ArrayList<int[]> options, HashMap<int[], Integer> tileOptionMap) {

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

        grid = new ObjectGrid(tilesAcross, tilesDown, optionsObject, optionMap, tileGrid, tileOptionMap);
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
        while (keepGoing) {
            keepGoing = grid.collapse();
        }
    }
}

