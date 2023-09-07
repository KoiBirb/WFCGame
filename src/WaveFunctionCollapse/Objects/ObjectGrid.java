package WaveFunctionCollapse.Objects;

import WaveFunctionCollapse.Cell;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ObjectGrid {

    private final int width;
    private final int height;
    private final int tilePercentDivider;
    private final ArrayList<Cell> grid = new ArrayList<>();
    private ArrayList<int[]> options;
    private ArrayList<Cell> finishedGrid;
    HashMap<Integer, HashMap<Integer, Boolean>> optionCompatibilityMap;
    HashMap<int[], Integer> optionMap;
    HashMap<int[], Integer> tileOptionMap;

    public ObjectGrid(int width, int height, ArrayList<int[]>options, HashMap<int[], Integer> optionMap, HashMap<Integer, HashMap<Integer, Boolean>> optionCompatibilityMap, ArrayList<Cell> finishedGrid, HashMap<int[], Integer> tileOptionMap) {
        this.width = width;
        this.height = height;
        this.options = options;
        this.optionMap = optionMap;
        this.tileOptionMap = tileOptionMap;
        this.finishedGrid = finishedGrid;
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

    public boolean collapse() {
        Cell cell = getCell();
        if (cell != null) {
            if (cell.collapse()) {
                int tilesCollapsed = 0;
                for (int i = 0; i < (width * height); i++) {
                    if (grid.get(i).isCollapsed()) {
                        tilesCollapsed++;
                    }
                }
                System.out.println("Placing Objects" + " (" + tilesCollapsed / tilePercentDivider + "%)");
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

                    ArrayList<String> adjacentObjects = new ArrayList<>();
                    ArrayList<int[]> adjacentTiles = new ArrayList<>();
                    ArrayList<int[]> cumulativeValidOptions = currentCell.getOptions();

                    int indexUP = index - width;
                    try {
                        adjacentTiles.add(0, finishedGrid.get(indexUP).getOptions().get(0));
                        if (grid.get(indexUP).isCollapsed()) {
                            adjacentObjects.add(0, String.valueOf(optionMap.get(grid.get(indexUP).getOptions().get(0))));
                        } else {
                            adjacentObjects.add(0, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(0, "n");
                        adjacentTiles.add(0, null);
                    }
                    if (indexUP >= 0) {
                        grid.get(indexUP).getOptions();
                        if (!Objects.equals(adjacentObjects.get(0), "n")) {
                            cumulativeValidOptions =
                                findAllowedOptionsObjects(cumulativeValidOptions, grid.get(indexUP).getOptions(), 0, adjacentObjects.get(0), adjacentTiles.get(0));
                            }
                        }

                    int indexDOWN = index + width;
                    try {
                        adjacentTiles.add(1, finishedGrid.get(indexDOWN).getOptions().get(0));
                        if (grid.get(indexDOWN).isCollapsed()) {
                            adjacentObjects.add(1, String.valueOf(optionMap.get(grid.get(indexDOWN).getOptions().get(0))));
                        } else {
                            adjacentObjects.add(1, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(1, "n");
                        adjacentTiles.add(1, null);
                    }
                    if (indexDOWN < grid.size()) {
                        if (!Objects.equals(adjacentObjects.get(1), "n")) {
                                cumulativeValidOptions =
                                        findAllowedOptionsObjects(cumulativeValidOptions, grid.get(indexDOWN).getOptions(), 2, adjacentObjects.get(1), adjacentTiles.get(1));
                            }
                        }

                    int indexLEFT = index - 1;
                    try {
                        adjacentTiles.add(2, finishedGrid.get(indexLEFT).getOptions().get(0));
                        if (grid.get(indexLEFT).isCollapsed()) {
                            adjacentObjects.add(2, String.valueOf(optionMap.get(grid.get(indexLEFT).getOptions().get(0))));
                        } else {
                            adjacentObjects.add(2, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(2, "n");
                        adjacentTiles.add(2, null);
                    }
                    if (index % width != 0) {
                        if (!Objects.equals(adjacentObjects.get(2), "n")) {
                                cumulativeValidOptions =
                                        findAllowedOptionsObjects(cumulativeValidOptions, grid.get(indexLEFT).getOptions(), 3, adjacentObjects.get(2), adjacentTiles.get(2));
                            }
                        }

                    int indexRIGHT = index + 1;
                    try {
                        adjacentTiles.add(3, finishedGrid.get(indexRIGHT).getOptions().get(0));
                        if (grid.get(indexRIGHT).isCollapsed()) {
                            adjacentObjects.add(3, String.valueOf(optionMap.get(grid.get(indexRIGHT).getOptions().get(0))));
                        } else {
                            adjacentObjects.add(3, "n");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(3, "n");
                        adjacentTiles.add(3, null);
                    }
                    if ((index + 1) % width != 0) {
                        if (!Objects.equals(adjacentObjects.get(3), "n")) {
                                cumulativeValidOptions =
                                        findAllowedOptionsObjects(cumulativeValidOptions, grid.get(indexRIGHT).getOptions(), 1, adjacentObjects.get(3), adjacentTiles.get(3));
                        }
                    }
                    currentCell.setOptions(cumulativeValidOptions);

                    double[] weightTileLeft = ObjectWeights.weightMap.get(adjacentObjects.get(2));
                    double[] weightTileRight = ObjectWeights.weightMap.get(adjacentObjects.get(3));
                    double[] weightTileBottom = ObjectWeights.weightMap.get(adjacentObjects.get(1));
                    double[] weightTileTop = ObjectWeights.weightMap.get(adjacentObjects.get(0));

                    double[] newWeightTile = new double[options.size()];
                    for (int i = 0; i < newWeightTile.length; i++) {
                        newWeightTile[i] = weightTileLeft[i] * weightTileRight[i] * weightTileBottom[i] * weightTileTop[i];
                    }
                    currentCell.setWeight(newWeightTile);
                }
            }
        }
        return true;
    }
    protected ArrayList<int[]> findAllowedOptionsObjects(ArrayList<int[]> cumulativeValidOptions, ArrayList<int[]> comparativeCellOptions, int position, String object, int[] tile) {
        ArrayList<int[]> newCumulativeValidOptions = new ArrayList<>();
        HashMap tileMap = ObjectWeights.compatibilityMapFinder.get(object);
        cumulativeValidOptions.forEach(option -> {
            if (tileMap.get(tile) == Boolean.TRUE) {
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


