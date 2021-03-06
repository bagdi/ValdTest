package main.test_data;

import java.util.*;

public class Evaluation {

    public Evaluation() {
    }

    public static double MNK(List<Double> liambdaForMNK, int count, int ban) {
        double result;
        double a = 0;
        double b = getThetaMNK(liambdaForMNK, ban);
        result = a + b * count;
        return result;
    }

    private static double getKSquare(int ban) {
        double b = 0;
        for(int i = 1; i < ban; i++) {
            b = b + Math.pow(i, 2);
        }
        return b;
    }

    private static double getThetaMNK(List<Double> liambdaForMNK, int ban) {
        double b = 0;
        for(int i = 0; i < ban; i++) {
            b = b + i * liambdaForMNK.get(i);
        }
        b = b / getKSquare(ban);
        return b;
    }

    public static List<Double> getPsiForTrendTest(double t) {
        List<Double> result = new ArrayList<>();
        result.add(1.0);
        result.add(t/10);
        result.add(Math.pow(t, 2)/100);
        result.add(Math.pow(t, 3)/1000);
        return result;
    }

    @Deprecated
    public static double OMP(List<Double> liambdaForOMP, int count, int ban) {
        double omp = 0;
        int size = 0;
        if (size > ban) size = ban;
        else size = liambdaForOMP.size();
        if (count == 1) omp = liambdaForOMP.get(0);
        else {
            for (int i = 0; i < size; i++) {
                omp += liambdaForOMP.get(i);
            }
            omp = omp / count;
        }
        return omp;
    }
}
