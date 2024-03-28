package WaveFunctionCollapse.Objects;

import WaveFunctionCollapse.Cell;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

public class ObjectGrid {

    private final int width;
    private final int height;
    public final double tilePercentDivider;
    public int tilesCollapsed = 0;
    private final ArrayList<Cell> grid = new ArrayList<>();
    private final ArrayList<int[]> options;
    private final ArrayList<Cell> finishedGrid;
    HashMap<int[], Integer> optionMap;
    HashMap<int[], Integer> tileOptionMap;

    public ObjectGrid(int width, int height, ArrayList<int[]>options, HashMap<int[], Integer> optionMap, ArrayList<Cell> finishedGrid, HashMap<int[], Integer> tileOptionMap) {
        this.width = width;
        this.height = height;
        this.options = options;
        this.optionMap = optionMap;
        this.tileOptionMap = tileOptionMap;
        this.finishedGrid = finishedGrid;
        this.tilePercentDivider = (width * height) / 100.0;
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
        ArrayList<Integer> cellsToCheck = new ArrayList<>();
        Cell cell = getCell();
        int collapsedCellIndex = grid.indexOf(cell);

        int centerIndexUP = collapsedCellIndex - width;
        if (centerIndexUP >= 0) {
            cellsToCheck.add(centerIndexUP);
        }

        int centerIndexDOWN = collapsedCellIndex + width;
        if (centerIndexDOWN < grid.size()) {
            cellsToCheck.add(centerIndexDOWN);
        }

        int centerIndexLEFT = collapsedCellIndex - 1;
        if (collapsedCellIndex % width != 0) {
            cellsToCheck.add(centerIndexLEFT);
        }

        int centerIndexRIGHT = collapsedCellIndex + 1;
        if ((collapsedCellIndex + 1) % width != 0) {
            cellsToCheck.add(centerIndexRIGHT);
        }
        if (cell != null) {
            if (!cell.collapse()) {
                resetAdjacentTiles(cell);
            }
            tilesCollapsed = 0;
            for (int i = 0; i < (width * height); i++) {
                if (grid.get(i).isCollapsed()) {
                    tilesCollapsed++;
                }
            }
        } else {
            return false;
        }

        while (!cellsToCheck.isEmpty()) {
            for (int i = 0; i < cellsToCheck.size(); i++) {
                int index = cellsToCheck.get(i);
                Cell currentCell = grid.get(index);
                if (!currentCell.isCollapsed()) {

                    ArrayList<int[]> originalOptions = currentCell.getOptions();
                    ArrayList<Integer> adjacentObjects = new ArrayList<>();

                    int indexUP = index - width;
                    try {
                        if (grid.get(indexUP).isCollapsed()) {
                            adjacentObjects.add(0, optionMap.get(grid.get(indexUP).getOptions().get(0)));
                        } else {
                            adjacentObjects.add(0, 999);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(0, 999);
                    }

                    int indexDOWN = index + width;
                    try {
                        if (grid.get(indexDOWN).isCollapsed()) {
                            adjacentObjects.add(1, optionMap.get(grid.get(indexDOWN).getOptions().get(0)));
                        } else {
                            adjacentObjects.add(1, 999);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(1, 999);
                    }

                    int indexLEFT = index - 1;
                    try {
                        if (grid.get(indexLEFT).isCollapsed()) {
                            adjacentObjects.add(2, optionMap.get(grid.get(indexLEFT).getOptions().get(0)));
                        } else {
                            adjacentObjects.add(2, 999);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(2, 999);
                    }

                    int indexRIGHT = index + 1;
                    try {
                        if (grid.get(indexRIGHT).isCollapsed()) {
                            adjacentObjects.add(3, optionMap.get(grid.get(indexRIGHT).getOptions().get(0)));
                        } else {
                            adjacentObjects.add(3, 999);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        adjacentObjects.add(3, 999);
                    }

                    ArrayList<int[]> cumulativeValidOptions = findAllowedOptionsObjects(currentCell, finishedGrid.get(index).getOptions().get(0));

                    currentCell.setOptions(cumulativeValidOptions);
                    if (!checkArrayList(originalOptions, cumulativeValidOptions)){

                        if (indexUP >= 0) {
                            if (!cellsToCheck.contains(indexUP)) {
                                cellsToCheck.add(indexUP);
                            }
                        }

                        if (indexDOWN < grid.size()) {
                            if (!cellsToCheck.contains(indexDOWN)) {
                                cellsToCheck.add(indexDOWN);
                            }
                        }

                        if (index % width != 0) {
                            if (!cellsToCheck.contains(indexLEFT)) {
                                cellsToCheck.add(indexLEFT);
                            }
                        }

                        if ((index + 1) % width != 0) {
                            if (!cellsToCheck.contains(indexRIGHT)) {
                                cellsToCheck.add(indexRIGHT);
                            }
                        }
                    } else {
                        cellsToCheck.remove((Integer) index);
                        cellsToCheck.remove((Integer) collapsedCellIndex);
                    }

                    int[] weightTileLeft = ObjectWeights.weightMap.get(adjacentObjects.get(2));
                    int[] weightTileRight = ObjectWeights.weightMap.get(adjacentObjects.get(3));
                    int[] weightTileBottom = ObjectWeights.weightMap.get(adjacentObjects.get(1));
                    int[] weightTileTop = ObjectWeights.weightMap.get(adjacentObjects.get(0));

                    int[] newWeightTile = new int[options.size()];
                    for (int y = 0; y < newWeightTile.length; y++) {
                        newWeightTile[y] = weightTileLeft[y] * weightTileRight[y] * weightTileBottom[y] * weightTileTop[y];
                    }
                    currentCell.setWeight(newWeightTile);
                } else {
                    cellsToCheck.remove((Integer) index);
                }
            }
        }
        return true;
    }
    protected ArrayList<int[]> findAllowedOptionsObjects(Cell currentCell, int[] tile) {
        ArrayList<int[]> cumulativeValidOptions = currentCell.getOptions();
        ArrayList<int[]> newCumulativeValidOptions = new ArrayList<>();
        cumulativeValidOptions.forEach(option -> {
            HashMap tileMap = ObjectWeights.compatibilityMapFinder.get(optionMap.get(option));
            if (tileMap.get(tile) == Boolean.TRUE) {
                newCumulativeValidOptions.add(option);
            }
        });
        return newCumulativeValidOptions;
    }

    public boolean checkArrayList (ArrayList<int[]> originalList, ArrayList<int[]> modifiedList){
        if (originalList.size() == modifiedList.size()){
            int correctOptions = 0;
            for (int[] ints : originalList) {
                if (modifiedList.contains(ints)) {
                    correctOptions++;
                }
            }
            return correctOptions == originalList.size();
        } else {
            return false;
        }
    }

    public void resetAdjacentTiles(Cell cell){

        int index = grid.indexOf(cell);
        resetCell(index);
        try {
            int indexUP = index - width;
            resetCell(indexUP);
        } catch (IndexOutOfBoundsException e){}
        try {
            int indexDOWN = index + width;
            resetCell(indexDOWN);
        } catch (IndexOutOfBoundsException e){}
        try {
            int indexLEFT = index - 1;
            resetCell(indexLEFT);
        } catch (IndexOutOfBoundsException e){}
        try {
            int indexRIGHT = index + 1;
            resetCell(indexRIGHT);
        } catch (IndexOutOfBoundsException e){}
    }

    public void resetCell (int index){
        Cell currentCell = grid.get(index);
        currentCell.setOptions(options);
        currentCell.setState();
        currentCell.setWeight(new int[]{1});
    }

    public ArrayList<Cell> getGrid() {
        return grid;
    }
}


