package graphics.service;

public class Coordinate {
    private int size = 0;
    private double[] xData;
    private double[] yData;
    private String name;

    public Coordinate(PackageToArray packageToArray) {
        this.size = packageToArray.getX().size();
        xData = new double[size];
        yData = new double[size];
        this.name = packageToArray.getName();
    }

    public int getSize() {
        return size;
    }

    public double[] getXData() {
        return xData;
    }

    public double[] getYData() {
        return yData;
    }

    public String getName() {
        return name;
    }
}
