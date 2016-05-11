package graphics.painter;

import graphics.output.format.IFormat;
import graphics.service.Coordinate;
import org.knowm.xchart.Chart;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphicPainter {

    private static Chart chart = null;
    private static List<Chart> chartList = new ArrayList();
    private IFormat format;
    private Coordinate coordinate;
    private double[] xData;
    private double[] yData;
    private String name;

    public GraphicPainter() {
    }

    public GraphicPainter(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.xData = this.coordinate.getXData();
        this.yData = this.coordinate.getYData();
        this.name = coordinate.getName();
    }

    public void paint() {
        char delta = 0x03B4;
        chart = QuickChart.getChart(name, delta + "", "error", "test", xData, yData);
    }

    public void show() {
        new SwingWrapper(chart).displayChart();
    }

    public static void showChartsMatrix(String name) {
        new SwingWrapper(chartList).displayChartMatrix();
        //saveMatrix(new SwingWrapper(chartList).displayChartMatrix(), name);
        chartList = new ArrayList();
    }

    public static void saveMatrix(JFrame frame, String name) {
        try
        {
            BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            frame.paint(graphics2D);
            ImageIO.write(image,"jpeg", new File("E:\\" + name + ".jpeg"));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void save(IFormat format, String name, GraphicPainter painter) throws IOException {
        format.save(name, painter);
        chartList.add(chart);
    }

    public Chart getChart() {
        return chart;
    }

    public double[] getxData() {
        return xData;
    }

    public double[] getyData() {
        return yData;
    }

    public String getName() {
        return name;
    }


}
