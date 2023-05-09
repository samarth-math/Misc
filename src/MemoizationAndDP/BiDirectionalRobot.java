package MemoizationAndDP;


import CustomDataStructures.Pair;

import java.util.HashSet;
import java.util.Set;

public class BiDirectionalRobot {

    public static void main(String args[]) {
        BiDirectionalRobot bdr = new BiDirectionalRobot();
        int[][] countWaysMatrix = new int[3][3];
        System.out.println(bdr.countWays(1,1, countWaysMatrix));
    }

    private int countWays(int X, int Y, int[][] countWaysMatrix) {
        return countWays(X, Y, countWaysMatrix, new HashSet<Pair<Integer, Integer>>());
    }

        private int countWays(int X, int Y, int[][] countWaysMatrix, Set<Pair<Integer, Integer>> blocked){
        if (X==-1 || Y==-1) {
            return 0;
        }
        if(countWaysMatrix[X][Y]!=0) {
            return countWaysMatrix[X][Y];
        }
        if(X==0 && Y==1) {
            countWaysMatrix[X][Y] = 1;
            return 1;
        }
        if(X==1 && Y==0) {
            countWaysMatrix[X][Y] = 1;
            return 1;
        }
        if (X==0 && Y==0) {
            return 0;
        }

        int count = countWays(X-1, Y, countWaysMatrix) + countWays(X, Y-1, countWaysMatrix);
        countWaysMatrix[X][Y] = count;
        return count;
    }
}
