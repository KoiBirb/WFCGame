package WaveFunctionCollapse.tiles;

import WaveFunctionCollapse.Cell;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TileGrid {

    private final int width;
    private final int height;
    private final int tilePercentDivider;
    private final ArrayList<Cell> grid = new ArrayList<>();
    private ArrayList<int[]> options;
    HashMap<Integer, HashMap<Integer, Boolean>> optionCompatibilityMap;
    HashMap<int[], Integer> optionMap;

    public TileGrid(int width, int height, ArrayList<int[]>options, HashMap<int[], Integer> optionMap, HashMap<Integer, HashMap<Integer, Boolean>> optionCompatibilityMap) {
        this.width = width;
        this.height = height;
        this.options = options;
        this.optionMap = optionMap;
        this.optionCompatibilityMap = optionCompatibilityMap;
        this.tilePercentDivider = (int) Math.ceil(width * height / 100);
        setupGrid();
    }


    private void setupGrid() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid.add(new Cell(options, optionMap));
            }
        }
    }

    private Cell getCell() {
        ArrayList<Cell> mapOrdered = (ArrayList<Cell>) grid.clone();
        mapOrdered.removeIf(Cell::isCollapsed);
        if (mapOrdered.isEmpty()) {
            return null;
        }
        mapOrdered.sort(Cell::compareTo);
        Cell leastEntropyCell = mapOrdered.get(0);
        mapOrdered.removeIf(cell -> cell.entropy() != leastEntropyCell.entropy());
        return mapOrdered.get(new SecureRandom().nextInt(mapOrdered.size()));
    }

    public boolean collapse(boolean cleanUp) {
        Cell cell = getCell();
        if (cell != null) {
            if (cell.collapse()) {
                int tilesCollapsed = 0;
                for (int i = 0; i < (width * height); i++) {
                    if (grid.get(i).isCollapsed()) {
                        tilesCollapsed++;
                    }
                }
                if (cleanUp) {
                    System.out.println("Cleaning up" + " (" + tilesCollapsed / tilePercentDivider + "%)");
                } else {
                    System.out.println("Creating Map" + " (" + tilesCollapsed / tilePercentDivider + "%)");
                }
            } else {
                smallResetAdjacentTiles(cell);
            }
        } else {
            return false;
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                Cell currentCell = grid.get(index);
                if (!currentCell.isCollapsed()) {

                    ArrayList<String> adjacentTiles = new ArrayList<>();
                    ArrayList<int[]> cumulativeValidOptions = currentCell.getOptions();

                    int indexUP = index - width;
                    try {
                        if (grid.get(indexUP).isCollapsed()) {
                            adjacentTiles.add(0, String.valueOf(optionMap.get(grid.get(indexUP).getOptions().get(0))));
                        } else {
                            adjacentTiles.add(0, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(0, "n");
                    }
                    if (indexUP >= 0) {
                        grid.get(indexUP).getOptions();
                        if (!Objects.equals(adjacentTiles.get(0), "n")) {
                            cumulativeValidOptions =
                                    findAllowedOptions(cumulativeValidOptions, grid.get(indexUP).getOptions(), 0, adjacentTiles.get(0));
                        }
                    }

                    int indexDOWN = index + width;
                    try {
                        if (grid.get(indexDOWN).isCollapsed()) {
                            adjacentTiles.add(1, String.valueOf(optionMap.get(grid.get(indexDOWN).getOptions().get(0))));
                        } else {
                            adjacentTiles.add(1, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(1, "n");
                    }
                    if (indexDOWN < grid.size()) {
                        if (!Objects.equals(adjacentTiles.get(1), "n")) {
                            cumulativeValidOptions =
                                    findAllowedOptions(cumulativeValidOptions, grid.get(indexDOWN).getOptions(), 2, adjacentTiles.get(1));
                        }
                    }

                    int indexLEFT = index - 1;
                    try {
                        if (grid.get(indexLEFT).isCollapsed()) {
                            adjacentTiles.add(2, String.valueOf(optionMap.get(grid.get(indexLEFT).getOptions().get(0))));
                        } else {
                            adjacentTiles.add(2, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(2, "n");
                    }
                    if (index % width != 0) {
                        if (!Objects.equals(adjacentTiles.get(2), "n")) {
                            cumulativeValidOptions =
                                    findAllowedOptions(cumulativeValidOptions, grid.get(indexLEFT).getOptions(), 3, adjacentTiles.get(2));
                        }
                    }
                    int indexRIGHT = index + 1;
                    try {
                        if (grid.get(indexRIGHT).isCollapsed()) {
                            adjacentTiles.add(3, String.valueOf(optionMap.get(grid.get(indexRIGHT).getOptions().get(0))));
                        } else {
                            adjacentTiles.add(3, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(3, "n");
                    }
                    if ((index + 1) % width != 0) {
                        if (!Objects.equals(adjacentTiles.get(3), "n")) {
                            cumulativeValidOptions =
                                    findAllowedOptions(cumulativeValidOptions, grid.get(indexRIGHT).getOptions(), 1, adjacentTiles.get(3));
                        }
                    }
                    currentCell.setOptions(cumulativeValidOptions);

                    double[] weightTileLeft = TilesWeights.weightMap.get(adjacentTiles.get(2));
                    double[] weightTileRight = TilesWeights.weightMap.get(adjacentTiles.get(3));
                    double[] weightTileBottom = TilesWeights.weightMap.get(adjacentTiles.get(1));
                    double[] weightTileTop = TilesWeights.weightMap.get(adjacentTiles.get(0));

                    double[] newWeightTile = new double[33];

                    for (int i = 0; i < newWeightTile.length; i++) {
                        newWeightTile[i] = weightTileLeft[i] * weightTileRight[i] * weightTileBottom[i] * weightTileTop[i];
                    }
                    currentCell.setWeight(newWeightTile);
                }
            }
        }
        return true;
    }

    protected ArrayList<int[]> findAllowedOptions(ArrayList<int[]> cumulativeValidOptions, ArrayList<int[]> comparativeCellOptions, int position, String tile) {
        ArrayList<int[]> newCumulativeValidOptions = new ArrayList<>();
        HashMap tileMap = TilesWeights.tileCompatibilityHashMapFinder.get(tile);
        cumulativeValidOptions.forEach(option -> {
            if (tileMap.get(option) == Boolean.TRUE) {
                for (int[] comparativeCellOption : comparativeCellOptions) {
                    HashMap<Integer, Boolean> correctOptionCompatibilityMap = optionCompatibilityMap.get(option[position]);
                    if (correctOptionCompatibilityMap.get(comparativeCellOption[(position + 2) % 4]) == Boolean.TRUE) {
                        newCumulativeValidOptions.add(option);
                        break;
                    }
                }
            }
        });
        return newCumulativeValidOptions;
    }

    public boolean cleanUp(ArrayList<Integer> similarAdjacentTileRequirements){
        boolean tilesReset = false;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int index = y * width + x;
                Cell currentCell = grid.get(index);

                if (currentCell.isCollapsed()) {

                    int[] tileOption = currentCell.getOptions().get(0);
                    int tileType = optionMap.get(tileOption);
                    int similarAdjacentTileRequirement = similarAdjacentTileRequirements.get(tileType);
                    int similarTileTypeOccurrences = 0;

                    ArrayList<String> adjacentTiles = new ArrayList<>();

                    int indexUP = index - width;
                    try {
                        adjacentTiles.add(0, String.valueOf(optionMap.get(grid.get(indexUP).getOptions().get(0))));
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(0, "n");
                    }

                    int indexDOWN = index + width;
                    try {
                        adjacentTiles.add(1, String.valueOf(optionMap.get(grid.get(indexDOWN).getOptions().get(0))));
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(1, "n");
                    }

                    int indexLEFT = index - 1;
                    try {
                        adjacentTiles.add(2, String.valueOf(optionMap.get(grid.get(indexLEFT).getOptions().get(0))));
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(2, "n");
                    }

                    int indexRIGHT = index + 1;
                    try {
                        adjacentTiles.add(3, String.valueOf(optionMap.get(grid.get(indexRIGHT).getOptions().get(0))));
                    } catch (IndexOutOfBoundsException e) {
                        adjacentTiles.add(3, "n");
                    }

                    for (int i = 0; i < adjacentTiles.size(); i++) {
                        if (adjacentTiles.get(i).equals(String.valueOf(tileType))) {
                            similarTileTypeOccurrences++;
                        }
                    }
                    if (similarTileTypeOccurrences < similarAdjacentTileRequirement) {
                        smallResetAdjacentTiles(currentCell);
                        tilesReset = true;
                    }
                }
            }
        }
        return tilesReset;
    }

    public void smallResetAdjacentTiles(Cell cell){
        int index = grid.indexOf(cell);
        grid.set(index, new Cell(options, optionMap));
        try {
            int indexUP = index - width;
            grid.set(indexUP, new Cell(options, optionMap));
        } catch (IndexOutOfBoundsException e){}
        try {
            int indexDOWN = index + width;
            grid.set(indexDOWN, new Cell(options, optionMap));
        } catch (IndexOutOfBoundsException e){}
        try {
            int indexLEFT = index - 1;
            grid.set(indexLEFT, new Cell(options, optionMap));
        } catch (IndexOutOfBoundsException e){}
        try {
            int indexRIGHT = index + 1;
            grid.set(indexRIGHT, new Cell(options, optionMap));
        } catch (IndexOutOfBoundsException e){}
    }

    public ArrayList<Cell> getGrid() {
        return grid;
    }
}