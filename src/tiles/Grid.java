package tiles;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

public class Grid{

    private final int width;
    private final int height;
    private final ArrayList<Cell> grid = new ArrayList<>();
    public ArrayList<int[]> options;

    HashMap<int[], Integer> optionMap = new HashMap<>();

    public Grid(int width, int height, ArrayList<int[]>options) {
        this.width = width;
        this.height = height;
        this.options = options;
        optionMap.put(options.get(0), 0);
        optionMap.put(options.get(1), 1);
        optionMap.put(options.get(2), 2);
        optionMap.put(options.get(3), 3);
        optionMap.put(options.get(4), 4);
        optionMap.put(options.get(5), 5);
        optionMap.put(options.get(6), 6);
        optionMap.put(options.get(7), 7);
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
            cell.collapse();
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
                        cumulativeValidOptions =
                                findAllowedOptions(cumulativeValidOptions, grid.get(indexUP).getOptions(), 0, adjacentTiles.get(0));
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
                        cumulativeValidOptions =
                                findAllowedOptions(cumulativeValidOptions, grid.get(indexDOWN).getOptions(), 2, adjacentTiles.get(1));
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
                        cumulativeValidOptions =
                                findAllowedOptions(cumulativeValidOptions, grid.get(indexLEFT).getOptions(), 3, adjacentTiles.get(2));
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
                        cumulativeValidOptions =
                                findAllowedOptions(cumulativeValidOptions, grid.get(indexRIGHT).getOptions(), 1, adjacentTiles.get(3));
                    }
                    currentCell.setOptions(cumulativeValidOptions);

                    double[] weightTileLeft = Weights.weightMap.get(adjacentTiles.get(2));
                    double[] weightTileRight = Weights.weightMap.get(adjacentTiles.get(3));
                    double[] weightTileBottom = Weights.weightMap.get(adjacentTiles.get(1));
                    double[] weightTileTop = Weights.weightMap.get(adjacentTiles.get(0));

                    double[] newWeightTile;

                        newWeightTile = new double[]{
                                weightTileLeft[0] * weightTileRight[0] * weightTileBottom[0] * weightTileTop[0],
                                weightTileLeft[1] * weightTileRight[1] * weightTileBottom[1] * weightTileTop[1],
                                weightTileLeft[2] * weightTileRight[2] * weightTileBottom[2] * weightTileTop[2],
                                weightTileLeft[3] * weightTileRight[3] * weightTileBottom[3] * weightTileTop[3],
                                weightTileLeft[4] * weightTileRight[4] * weightTileBottom[4] * weightTileTop[4],
                                weightTileLeft[5] * weightTileRight[5] * weightTileBottom[5] * weightTileTop[5],
                                weightTileLeft[6] * weightTileRight[6] * weightTileBottom[6] * weightTileTop[6],
                                weightTileLeft[7] * weightTileRight[7] * weightTileBottom[7] * weightTileTop[7]
                        };
                    currentCell.setWeight(newWeightTile);
                }
            }
        }
        return true;
    }

        protected ArrayList<int[]> findAllowedOptions(ArrayList<int[]> cumulativeValidOptions, ArrayList<int[]> comparativeCellOptions, int position, String tile) {
            ArrayList<int[]> newCumulativeValidOptions = new ArrayList<>();
            HashMap tileMap = Weights.tileCompatibilityHashMapFinder.get(tile);

            cumulativeValidOptions.forEach(option -> {
                for (int[] comparativeCellOption : comparativeCellOptions) {
                    if (option[position] == comparativeCellOption[(position + 2) % 4] && (tileMap.get(option) == Boolean.TRUE)) {
                        newCumulativeValidOptions.add(option);
                        break;
                    }
                }
            });
            return newCumulativeValidOptions;
        }

        public ArrayList<Cell> getGrid() {
            return grid;
        }
}


