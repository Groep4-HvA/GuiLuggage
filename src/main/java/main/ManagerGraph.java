package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.WindowEvent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class ManagerGraph extends ApplicationFrame {

    public ManagerGraph(final String title, boolean beheer) {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setPreferredSize(new Dimension(1366, 768));
        setContentPane(chartPanel);

    }

    private CategoryDataset createDataset() {

        // row keys...
        final String lost = "Lost";
        final String found = "Found";
        final String resolved = "Resolved";

        // column keys...
        final String januari = "Januari";
        final String februari = "Februari";
        final String march = "March";
        final String april = "April";
        final String may = "May";
        final String june = "June";
        final String july = "July";
        final String august = "August";
        final String september = "September";
        final String october = "October";
        final String november = "November";
        final String december = "December";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, lost, januari);
        dataset.addValue(2.0, lost, februari);
        dataset.addValue(3.0, lost, march);
        dataset.addValue(4.0, lost, april);
        dataset.addValue(4.0, lost, may);
        dataset.addValue(5.0, lost, june);
        dataset.addValue(5.0, lost, july);
        dataset.addValue(7.0, lost, august);
        dataset.addValue(7.0, lost, september);
        dataset.addValue(10.0, lost, october);
        dataset.addValue(8.0, lost, november);
        dataset.addValue(8.0, lost, december);

        dataset.addValue(5.0, found, januari);
        dataset.addValue(7.0, found, februari);
        dataset.addValue(6.0, found, march);
        dataset.addValue(8.0, found, april);
        dataset.addValue(4.0, found, may);
        dataset.addValue(4.0, found, june);
        dataset.addValue(2.0, found, july);
        dataset.addValue(1.0, found, august);
        dataset.addValue(1.0, found, september);
        dataset.addValue(1.0, found, october);
        dataset.addValue(1.0, found, november);
        dataset.addValue(1.0, found, december);

        dataset.addValue(4.0, resolved, januari);
        dataset.addValue(3.0, resolved, februari);
        dataset.addValue(2.0, resolved, march);
        dataset.addValue(3.0, resolved, april);
        dataset.addValue(6.0, resolved, may);
        dataset.addValue(3.0, resolved, june);
        dataset.addValue(4.0, resolved, july);
        dataset.addValue(3.0, resolved, august);
        dataset.addValue(3.0, resolved, september);
        dataset.addValue(3.0, resolved, october);
        dataset.addValue(3.0, resolved, november);
        dataset.addValue(3.0, resolved, december);

        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createLineChart(
                "Luggage Statistics", // chart title
                "Months", // domain axis label
                "#", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );

        chart.setBackgroundPaint(Color.white);

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        // customise the renderer...
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        // renderer.setDrawShapes(true);

        renderer.setSeriesStroke(
                0, new BasicStroke(
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                        1.0f, new float[]{1.0f, 0.0f}, 0.0f
                )
        );
        renderer.setSeriesStroke(
                1, new BasicStroke(
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                        1.0f, new float[]{1.0f, 0.0f}, 0.0f
                )
        );
        renderer.setSeriesStroke(
                2, new BasicStroke(
                        2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                        1.0f, new float[]{1.0f, 0.0f}, 0.0f
                )
        );
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;
    }

    @Override
    public void windowClosing(final WindowEvent evt) {
        if (evt.getWindow() == this) {
            dispose();

        }
    }
}
