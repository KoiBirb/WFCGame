package tiles;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Grid{

    private final int width;
    private final int height;
    private int tilesCollapsed = 0;
    private final int tilePercentDivider;
    private final ArrayList<Cell> grid = new ArrayList<>();
    public ArrayList<int[]> options;

    HashMap<int[], Integer> optionMap = new HashMap<>();

    public Grid(int width, int height, ArrayList<int[]>options) {
        this.width = width;
        this.height = height;
        this.options = options;
        this.tilePercentDivider = (int) Math.ceil(width * height / 100);

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
            tilesCollapsed++;
            System.out.println("Tiles collapsed: " + tilesCollapsed + " (" + tilesCollapsed/tilePercentDivider + "%)");
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

                    double[] weightTileLeft = Weights.weightMap.get(adjacentTiles.get(2));
                    double[] weightTileRight = Weights.weightMap.get(adjacentTiles.get(3));
                    double[] weightTileBottom = Weights.weightMap.get(adjacentTiles.get(1));
                    double[] weightTileTop = Weights.weightMap.get(adjacentTiles.get(0));

                    double[] newWeightTile = new double[]{
                                weightTileLeft[0] * weightTileRight[0] * weightTileBottom[0] * weightTileTop[0],
                                weightTileLeft[1] * weightTileRight[1] * weightTileBottom[1] * weightTileTop[1],
                                weightTileLeft[2] * weightTileRight[2] * weightTileBottom[2] * weightTileTop[2],
                                weightTileLeft[3] * weightTileRight[3] * weightTileBottom[3] * weightTileTop[3],
                                weightTileLeft[4] * weightTileRight[4] * weightTileBottom[4] * weightTileTop[4],
                                weightTileLeft[5] * weightTileRight[5] * weightTileBottom[5] * weightTileTop[5],
                                weightTileLeft[6] * weightTileRight[6] * weightTileBottom[6] * weightTileTop[6],
                                weightTileLeft[7] * weightTileRight[7] * weightTileBottom[7] * weightTileTop[7],
                                weightTileLeft[8] * weightTileRight[8] * weightTileBottom[8] * weightTileTop[8],
                                weightTileLeft[9] * weightTileRight[9] * weightTileBottom[9] * weightTileTop[9],
                                weightTileLeft[10] * weightTileRight[10] * weightTileBottom[10] * weightTileTop[10],
                                weightTileLeft[11] * weightTileRight[11] * weightTileBottom[11] * weightTileTop[11],
                                weightTileLeft[12] * weightTileRight[12] * weightTileBottom[12] * weightTileTop[12],
                                weightTileLeft[13] * weightTileRight[13] * weightTileBottom[13] * weightTileTop[13],
                                weightTileLeft[14] * weightTileRight[14] * weightTileBottom[14] * weightTileTop[14],
                                weightTileLeft[15] * weightTileRight[15] * weightTileBottom[15] * weightTileTop[15],
                                weightTileLeft[16] * weightTileRight[16] * weightTileBottom[16] * weightTileTop[16],
                                weightTileLeft[17] * weightTileRight[17] * weightTileBottom[17] * weightTileTop[17],
                                weightTileLeft[18] * weightTileRight[18] * weightTileBottom[18] * weightTileTop[18],
                                weightTileLeft[19] * weightTileRight[19] * weightTileBottom[19] * weightTileTop[19],
                                weightTileLeft[20] * weightTileRight[20] * weightTileBottom[20] * weightTileTop[20],
                                weightTileLeft[21] * weightTileRight[21] * weightTileBottom[21] * weightTileTop[21],
                                weightTileLeft[22] * weightTileRight[22] * weightTileBottom[22] * weightTileTop[22],
                                weightTileLeft[23] * weightTileRight[23] * weightTileBottom[23] * weightTileTop[23],
                                weightTileLeft[24] * weightTileRight[24] * weightTileBottom[24] * weightTileTop[24],
                                weightTileLeft[25] * weightTileRight[25] * weightTileBottom[25] * weightTileTop[25],
                                weightTileLeft[26] * weightTileRight[26] * weightTileBottom[26] * weightTileTop[26],
                                weightTileLeft[27] * weightTileRight[27] * weightTileBottom[27] * weightTileTop[27],
                                weightTileLeft[28] * weightTileRight[28] * weightTileBottom[28] * weightTileTop[28],
                                weightTileLeft[29] * weightTileRight[29] * weightTileBottom[29] * weightTileTop[29],
                                weightTileLeft[30] * weightTileRight[30] * weightTileBottom[30] * weightTileTop[30],
                                weightTileLeft[31] * weightTileRight[31] * weightTileBottom[31] * weightTileTop[31],
                                weightTileLeft[32] * weightTileRight[32] * weightTileBottom[32] * weightTileTop[32]
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
                            if (option[position] == comparativeCellOption[(position + 2) % 4] && tileMap.get(option) == Boolean.TRUE) {
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


