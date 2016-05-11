package main.test;

import graphics.output.format.JPG;
import graphics.service.PackageToArray;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ValdTestCheck {

    private final char DELTA = 0x03B4;
    private final char EPSILON = 0x03B5;
    private final char RHO = 0x03C1;
    private int quantity;
    private double alpha;
    private double beta;
    private double theta0;
    private double theta1;
    private double eps;
    private int ban;
    double epsBound;

    public ValdTestCheck(int quantity, double alpha, double beta, double theta0,
                         double theta1, double eps, int ban, double epsBound) {
        this.quantity = quantity;
        this.alpha = alpha;
        this.beta = beta;
        this.theta0 = theta0;
        this.theta1 = theta1;
        this.eps = eps;
        this.ban = ban;
        this.epsBound = epsBound;
    }

    public void test() throws IOException {

        String fileName = EPSILON + " = " + eps + ", " + RHO +  " = " + ban;
        PackageToArray packageToArray = new PackageToArray(fileName);
        PrintWriter out = new PrintWriter(new File(fileName + ".txt"));
        double deltaPickBound = 1;
        double deltaAddPart = 0.1;
        for (double delta = 0; delta < deltaPickBound; delta += deltaAddPart) { // спросить
            double test[] = new double[quantity];
            for (int k = 0; k < quantity; k++) {
                test[k] = ValdTest.test(alpha, beta, theta0, theta1, eps, delta, ban);
            }
            int f = 0;
            int g = 0;
            for (int l = 0; l < quantity; l++) {
                if (test[l] == 1) f++;
                else g++;
            }
            double err1 = (double) f / quantity;
            //System.out.println("For delta = " + delta + " and eps = " + eps);
            //System.out.println("Get gypotez H1 for theta0(error first type) / " + quantity + " = " + err1);
            //System.out.println("{" + delta + "," + err1 + "}" + ",");
            /*double err2 = (double) g / quantity;
            System.out.println("Get gypotez H0 for theta0 / " + quantity + " = " + err2);*/
            out.print("{" + delta + "," + err1 + "}" + ",");
            packageToArray.addDeltaAndError(delta, err1);
            eps = eps + epsBound;
        }
        packageToArray.packageDrawAndSave(new JPG());
        //packageToArray.getPainter().show();
        out.close();
    }
}
