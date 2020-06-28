package akinalex;

import java.util.*;

public class SockLaundry {

    Map<String, Integer> annaMemory = new HashMap<String, Integer>();

    // Do not delete or edit this method, you can only modify the block
    public int getMaximumPairOfSocks(int noOfWashes, int[] cleanPile, int[] dirtyPile) {
        if (cleanPile.length > 50 || dirtyPile.length > 50 || noOfWashes > 50 || cleanPile.length < 1
                || dirtyPile.length < 1) {
            return -1;
        }
        commitToMemory(cleanPile);
        int[] washedSocks = wash(dirtyPile, noOfWashes);
        commitToMemory(washedSocks);
        int result = collectResult(annaMemory);
        return result;
    }

    public void commitToMemory(int[] socks) {
        for (int i = 0; i < socks.length; i++) {
            int index = socks[i];
            if (annaMemory.containsKey(String.valueOf(index))) {
                annaMemory.put(String.valueOf(index), annaMemory.get(String.valueOf(index)) + 1);
            } else {
                annaMemory.put(String.valueOf(index), 1);
            }
        }

    }

    public static int[] wash(int[] dirtySocks, int noOfPairs) {
        int noOfWashes = noOfPairs;
        int noOfPairsToWash = (noOfWashes >= dirtySocks.length) ? dirtySocks.length : noOfWashes;
        int[] clean = new int[noOfPairsToWash];
        for (int i = 0; i < clean.length; i++) {
            clean[i] = dirtySocks[i];
        }

        return clean;
    }

    public int collectResult(Map<String, Integer> memory) {
        int accumulator = 0;
        for (String key : annaMemory.keySet()) {
            accumulator += annaMemory.get(key) / 2;
        }

        return accumulator;
    }

    public static void main(String[] args) {
        int[] two = { 40, 40, 40, 40, 40, 40, 40, 50, 50, 50, 50, 5 };
        int[] one = { 40, 40, 45, 45, 30, 35, 50, 50, 25, 25, 20, 20 };
        SockLaundry sockLaundry = new SockLaundry();

        System.out.println(sockLaundry.getMaximumPairOfSocks(50, two, one));

    }

    /**
     * You can create various helper methods
     */
}
