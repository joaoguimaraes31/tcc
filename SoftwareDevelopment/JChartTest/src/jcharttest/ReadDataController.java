package jcharttest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ReadDataController {

    private NavigationController navigationController;

    //MVC
    private ReadDataModel model;
    private ReadDataView view;

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
        createChart();

        view.setVisible(true);
        addListeners();
    }

    //addListeners for controlling view and triggers events
    public void addListeners() {
        actionListenerUpdateBT = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
               updateChart();
               createChart();
            }
        };
        view.getUpdateBT().addActionListener(actionListenerUpdateBT);
    }

    public void createChart() {

        series.add(20.0, 10.0);
        series.add(40.0, 20.0);
        series.add(70.0, 50.0);
        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart;
        chart = ChartFactory.createXYAreaChart("Sample XY Chart", "Height", "Weight", xyDataset);

        BufferedImage image = chart.createBufferedImage(500, 300);
        view.getLblChart().setIcon(new ImageIcon(image));
    }
    int countX = 20;
    int countY = 20;

    public void updateChart() {
        if (series.getItemCount() >= 10) {
            series.remove(0);
        }
        series.add(countX, countY);
        countX+=5;
        countY+=5;
    }

public void setNavigationController(NavigationController navigationController) {
        this.navigationController = navigationController;
    }

}
