package WaveFunctionCollapse;

import java.security.SecureRandom;
import java.util.*;

public class Cell implements Comparable<Cell> {
    private ArrayList<int[]> options;
    private double[] weight = {1};
    private boolean collapsed;
    private final int originalWeightSize;
    private final SecureRandom random = new SecureRandom();
    private final HashMap<int[], Integer> optionMap;
    private Map<Double, Double> logCache;
    private double scale = 1;

    public Cell(ArrayList<int[]> options, HashMap<int[], Integer> optionMap, int originalWeightSize) {
        this.options = options;
        this.optionMap = optionMap;
        this.originalWeightSize = originalWeightSize;
        collapsed = false;
        logCache = new HashMap<>();
    }

    public double entropy() {
        double entropy = 0;
        for (double probability : weight) {
            if (probability > 0) {
                entropy -= probability * log2(probability);
            }
        }

        if (entropy == 0) {
            entropy = 999;
        }

        return entropy;
    }

    private double log2(double x) {
        if (logCache.containsKey(x)) {
            return logCache.get(x);
        }
        double result = Math.log(x) / Math.log(2);
        logCache.put(x, result);
        return result;
    }

    private double minWeightSize(double[] weight){
        double min = weight[0];
        for (double v : weight) {
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    public boolean collapse(){
        try {
            try {
                if (weight[0] != 1) {
                    int[] tileChoice = null;
                    double randomDouble = random.nextDouble(minWeightSize(weight), 1);
                    for (int[] option : options) {
                        if (randomDouble <= (weight[optionMap.get(option)]) * scale) {
                            tileChoice = option;
                            break;
                        }
                    }
                    if (tileChoice != null) {
                        options = new ArrayList<>(Collections.singletonList(tileChoice));
                    } else {
                        options = new ArrayList<>(Collections.singletonList(options.get(random.nextInt(options.size()))));
                    }
                } else {
                    options = new ArrayList<>(Collections.singletonList(options.get(random.nextInt(options.size()))));
                }
            } catch (IndexOutOfBoundsException e) {
                return collapsed;
            }
        } catch (IllegalArgumentException e){
            return collapsed;
        }
        collapsed = true;
        return collapsed;
    }

    public boolean isCollapsed(){
        return collapsed;
    }

    public void setOptions(ArrayList<int[]> options){
        scale = ((double) originalWeightSize) / options.size();
        this.options = options;
    }

    public void setWeight(double[] weight){
        this.weight = weight;
    }

    public ArrayList<int[]> getOptions() {
        return options;
    }

    @Override
    public int compareTo(Cell o) {
        return Double.compare(entropy(), o.entropy());
    }
}
