package main.test;

import main.distributions.NormalDistribution;
import main.test_data.ValdParameters;
import java.util.ArrayList;
import java.util.List;

public class ValdTest {

    public ValdTest() {
    }

    public static double test(double alpha, double beta, double theta0, double theta1, double eps, double delta, int ban) {
        List<Double> arr = new ArrayList();
        List<Double> liambdaForMNK = new ArrayList();
        double a = (1 - beta) / alpha;
        double b = beta / (1 - alpha);
        double sum = 0;
        double x;
        int count = 0;
        double currentSummand;
        if ((sum > Math.log(b)) && (sum < Math.log(a))) {
            while (((sum > Math.log(b)) && (sum < Math.log(a))) || (sum == 0)) {

                count++;
                // parameter
                if (count <= ban) {
                    x = NormalDistribution.normalDistribution(theta0);
                    currentSummand = ValdParameters.liambdaT(x, theta0, theta1);
                    liambdaForMNK.add(currentSummand);
                    sum = sum + currentSummand;
                } else {
                    x = NormalDistribution.changedNormalDistribution(theta0, theta1, eps);
                    currentSummand = ValdParameters.newLiambdaT(delta, theta0, theta1, liambdaForMNK, x, count, ban);
                    sum = sum + currentSummand;
                }

            }
        }
        return ValdParameters.boundsCheck(sum, b);
    }

}
