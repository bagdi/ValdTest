package main.distributions;

public class NormalDistribution {

    private static double normSum;

    public NormalDistribution() {
    }

    public static double normalDistribution(double theta) {
        normSum = 0;
        double x;
        for (int i = 0; i < 12; i++) {
            normSum += Math.random();
        }
        x = theta + normSum - 6;
        return x;
    }

    public static double changedNormalDistribution(double theta0, double theta1, double eps) {
        normSum = 0;
        double x;
        double currentRandNumber;
        for (int i = 0; i < 12; i++) {
            normSum += Math.random();
        }
        currentRandNumber = Math.random();
        if(currentRandNumber < eps) {
            x = theta1 + normSum - 6;
        } else {
            x = theta0 + normSum - 6;
        }
        return x;
    }

    public double probabilityDensityFunc(double mean, double variance, double x) {
        return (1 / (Math.sqrt(variance) * Math.sqrt(2 * Math.PI))) * Math.exp(-Math.pow(x - mean, 2) / (2 * variance));
    }

    public static double getNormSum() {
        return normSum;
    }
}
