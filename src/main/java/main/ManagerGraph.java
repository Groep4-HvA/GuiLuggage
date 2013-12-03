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
import DBUtil.ConnectionMySQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ManagerGraph extends ApplicationFrame {

    ConnectionMySQL conn = new ConnectionMySQL();
    
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String dateString = dateFormat.format(date);

    public ManagerGraph(final String title, boolean beheer) throws SQLException {
        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setPreferredSize(new Dimension(1366, 768));
        setContentPane(chartPanel);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        /*january();
         february();
         march();
         april();
         may();
         june();
         july();
         august();
         september();
         october();
         november();
         december();*/
    }

    public double januari() throws SQLException {
        conn.startConnection();

        String sql = "SELECT * FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN ? AND ? ";
        

        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        prdstmt = conn.getConnection().prepareStatement(sql);
        rs = conn.performSelect(prdstmt);

        int xGaySeanx = 0;

        while (rs.next()) {
            xGaySeanx++;
        }
        System.out.println(xGaySeanx);

        return xGaySeanx;
    }

    public double shit() throws SQLException {

        conn.startConnection();

        String sql = "SELECT * FROM `cases` WHERE `resolveDate` IS NOT NULL";
        //String sql2 = "SELECT * FROM `cases` WHERE `resolveDate` IS NULL";

        ResultSet rs = null;
        PreparedStatement prdstmt = null;

        prdstmt = conn.getConnection().prepareStatement(sql);
        rs = conn.performSelect(prdstmt);

        int xGaySeanx = 0;

        while (rs.next()) {
            xGaySeanx++;
        }
        System.out.println(xGaySeanx);

        return xGaySeanx;

    }

    private CategoryDataset createDataset() throws SQLException {

        // row keys...
        final String lost = "Lost";
        final String found = "Found";
        final String total = "Total";

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

        dataset.addValue(0, lost, januari);
        dataset.addValue(0, lost, februari);
        dataset.addValue(0, lost, march);
        dataset.addValue(0, lost, april);
        dataset.addValue(0, lost, may);
        dataset.addValue(0, lost, june);
        dataset.addValue(0, lost, july);
        dataset.addValue(0, lost, august);
        dataset.addValue(0, lost, september);
        dataset.addValue(0, lost, october);
        dataset.addValue(0, lost, november);
        dataset.addValue(shit(), lost, december);

        dataset.addValue(0, found, januari);
        dataset.addValue(0, found, februari);
        dataset.addValue(0, found, march);
        dataset.addValue(0, found, april);
        dataset.addValue(0, found, may);
        dataset.addValue(0, found, june);
        dataset.addValue(0, found, july);
        dataset.addValue(0, found, august);
        dataset.addValue(0, found, september);
        dataset.addValue(0, found, october);
        dataset.addValue(0, found, november);
        dataset.addValue(0, found, december);

        dataset.addValue(0, total, januari);
        dataset.addValue(0, total, februari);
        dataset.addValue(0, total, march);
        dataset.addValue(0, total, april);
        dataset.addValue(0, total, may);
        dataset.addValue(0, total, june);
        dataset.addValue(0, total, july);
        dataset.addValue(0, total, august);
        dataset.addValue(0, total, september);
        dataset.addValue(0, total, october);
        dataset.addValue(0, total, november);
        dataset.addValue(0, total, december);

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
