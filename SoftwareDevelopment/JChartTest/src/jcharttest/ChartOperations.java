package jcharttest;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartOperations {

    String chartTitle,xAxixLabel,yAxisLabel;
    int xSize,ySize;
    JLabel chartLabel;
    long startTime;
    XYSeries series;

    public ChartOperations(String chartTitle, String xAxixLabel, String yAxisLabel, int xSize, int ySize,JLabel chartLabel) {
        this.chartTitle = chartTitle;
        this.xAxixLabel = xAxixLabel;
        this.yAxisLabel = yAxisLabel;
        this.xSize = xSize;
        this.ySize = ySize;
        this.chartLabel=chartLabel;
        startTime=0;
        series = new XYSeries("XY Series");
        series.add(0,0);
    }
    
    public void createChart() {
        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart;
        chart = ChartFactory.createXYLineChart(chartTitle,xAxixLabel,yAxisLabel, xyDataset, PlotOrientation.VERTICAL, false, false, false);
        BufferedImage image = chart.createBufferedImage(xSize, ySize);
        chartLabel.setIcon(new ImageIcon(image));
    }
    
    public void updateSeries(float amplitude) {
        if (series.getItemCount() >= 10) {
            series.remove(0);
        }
        series.add((((System.currentTimeMillis())-(startTime))),amplitude);
    }

    public void startTimer() {
        this.startTime = System.currentTimeMillis();
    }

    
    
    
    
}
