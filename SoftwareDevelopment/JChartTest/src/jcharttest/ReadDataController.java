package jcharttest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ReadDataController {

    private NavigationController navigationController;

    //MVC
    private ReadDataModel model;
    private ReadDataView view;
    
    int countY = 20;
    
    //Time Control
    long startTime = System.currentTimeMillis();
    
    //AL
    private ActionListener actionListenerUpdateBT;

    //Constructor
    public ReadDataController() {
        model = new ReadDataModel();
        view = new ReadDataView();
        createView();
    }

    XYSeries series = new XYSeries("Average Size");

    //CRIAR TELA INICIAL E ADCIONAR EVENTOS
    public void createView() {
        series.add(0,0);
        createChart();
        view.setVisible(true);
        addListeners();
    }

    //addListeners for controlling view and triggers events
    public void addListeners() {
        actionListenerUpdateBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
               updateSeries();
               createChart();
            }
        };
        view.getUpdateBT().addActionListener(actionListenerUpdateBT);
    }
    
    public void createChart() {
        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart;
        chart = ChartFactory.createXYLineChart("Sample XY Chart","Time (s)" , "Height", xyDataset, PlotOrientation.VERTICAL, false, false, false);
        BufferedImage image = chart.createBufferedImage(500, 300);
        view.getLblChart().setIcon(new ImageIcon(image));
    }
    

    public void updateSeries() {
        if (series.getItemCount() >= 10) {
            series.remove(0);
        }
        series.add((((System.currentTimeMillis())-(startTime))),countY);
        countY+=5;
    }

public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

}
