package task1;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

public class Main {
    public static void main(String[] args) {
        double[] x = {1, 2, 4, 8};
        double[] y = {2, 4, 8, 16};
        double corr = new PearsonsCorrelation().correlation(x, y);

        System.out.println(corr);
    }
}
