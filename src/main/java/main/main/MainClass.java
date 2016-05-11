package main.main;

import graphics.painter.GraphicPainter;
import graphics.service.ProgressBar;
import main.test.ValdTestCheck;

import java.io.IOException;

public class MainClass {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        int quantity = 1000;
        double alpha = 0.01;
        double beta = 0.01;
        double theta0 = 0;
        double theta1 = 1;
        double eps = 0.05;
        int ban = 0;
        double epsBound = 0;
        int[] banArray = {10, 15, 20, 25, 30, 35};
        double[] epsArray = {1, 0.95, 0.9, 0.8, 0.7, 0.6, 0.5};

        ProgressBar bar = ProgressBar.getInstance(banArray.length * epsArray.length);

        ValdTestCheck testCheck;

        for(double epsil : epsArray) {
            for(int bn : banArray) {
                testCheck = new ValdTestCheck(quantity, alpha, beta, theta0, theta1, epsil, bn, epsBound);
                testCheck.test();
                bar.progress();
            }
            GraphicPainter.showChartsMatrix(epsil + "");
        }
        System.out.println();
        System.out.println("Finished OK in " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
