package main.test_data;

import java.util.List;

public class ValdParameters {

    public ValdParameters() {
    }

    public static double liambdaT(double x, double theta0, double theta1) {
        return ((theta1 - theta0) * x + 0.5 * (theta0 * theta0 - theta1 * theta1));
    }

    public static double newLiambdaT(double delta, double theta0, double theta1, List<Double> arr, double x, int count, int ban) {
        return ((1 - delta) * liambdaT(x, theta0, theta1) + delta * Evaluation.MNK(arr, count, ban));
    }

    public static double boundsCheck(double sum, double b) {
        if (sum <= Math.log(b)) return 0;
        else return 1;
    }
}
