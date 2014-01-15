package main;

import DBUtil.ConnectionMySQL;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import models.Check;
import models.Debug;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Jeroen en Yorick
 */
public class ManagerGraph extends ApplicationFrame {

    ConnectionMySQL conn = new ConnectionMySQL();
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final java.util.ResourceBundle BUNDLE = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
    private final Date date = new Date();
    private final String dateString = dateFormat.format(date);
    private PreparedStatement prdstmt = null;
    private Date firstDate;
    private Date lastDate;
    private String graphTitle;
    private  JFreeChart chart = null;
    private Cursor waiting = new Cursor(Cursor.WAIT_CURSOR);
    private Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);

    /**
     * Constructor
     *
     * @param title
     * @param beheer
     */
    public ManagerGraph(final String title, boolean beheer) {

        super(title);
        if (!Check.verifyLogin()) {
            Runtime.getRuntime().exit(1);
        } else {

	    final CategoryDataset dataset = createDefaultDataset();
	    chart = createChart(dataset);
	    final ChartPanel chartPanel = new ChartPanel(chart);
	    //chartPanel.setPreferredSize(new Dimension(1366, 768));
	    setContentPane(chartPanel);
	    chartPanel.setLocation(getRootPane().getWidth() / 2, getRootPane().getHeight() / 2);
	}
    }

    /**
     * Constructor
     *
     * @param title
     * @param beheer
     * @param firstDate
     * @param lastDate
     */
    public ManagerGraph(String title, boolean beheer, Date firstDate, Date lastDate) {
	super(title);
	this.firstDate = firstDate;
	this.lastDate = lastDate;
	if (!Check.verifyLogin()) {
	    Runtime.getRuntime().exit(1);
	} else {
	    final CategoryDataset dataset = createDataset();
	    chart = createChart(dataset);
	    final ChartPanel chartPanel = new ChartPanel(chart);
	    //chartPanel.setPreferredSize(new Dimension(1366, 768));
	    setContentPane(chartPanel);
	    chartPanel.setLocation(getRootPane().getWidth() / 2, getRootPane().getHeight() / 2);
	}
    }

    /**
     * Get the data from the database
     *
     * @param firstDate
     * @param lastDate
     * @param type
     * @return
     */
    public int getMonthCount(String firstDate, String lastDate, String type) {
        int rowAmmount = 0;
        try {
            String sql = null;
            if (type.equals("none")) {
                sql = "SELECT count(*) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  ? AND ?;";
            } else if (type.equals("pending")) {
                sql = "SELECT count(*) FROM `cases` WHERE `resolveDate` IS NULL AND `addDate` BETWEEN  ? AND ?;";
            } else if (type.equals("total")) {
                sql = "SELECT count(*) FROM `cases` WHERE `AddDate` BETWEEN ? AND ?;";
            }

            conn.startConnection(); //2013-12-09
            prdstmt = conn.getConnection().prepareStatement(sql);
            prdstmt.setString(1, firstDate);
            prdstmt.setString(2, lastDate);

            ResultSet rs;
            rs = conn.performSelect(prdstmt);

            while (rs.next()) {
                rowAmmount = rs.getInt(1);
            }
            Debug.println("Between: " + firstDate + " and " + lastDate + ". . . " + rowAmmount + " records of type " + type);
        } catch (SQLException e) {
            Debug.printError(e.toString());
        }
        return rowAmmount;
    }

    /**
     * Create a dataset to feed to the graph constructor
     *
     * @return
     */
    private CategoryDataset createDefaultDataset() {

        // row keys...
        final String lost = "Pending";
        final String found = "Resolved";
        final String total = "Total";

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        month++;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);

	String[] months = {BUNDLE.getString("jan"),
	    BUNDLE.getString("feb"),
	    BUNDLE.getString("march"),
	    BUNDLE.getString("april"),
	    BUNDLE.getString("may"),
	    BUNDLE.getString("juni"),
	    BUNDLE.getString("juli"),
	    BUNDLE.getString("aug"),
	    BUNDLE.getString("sept"),
	    BUNDLE.getString("okt"),
	    BUNDLE.getString("nov"),
	    BUNDLE.getString("dec")};

        graphTitle = months[month - 1];
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 1; i <= day; i++) {
            dataset.addValue(getMonthCount(year + "-" + month + "-" + i, year + "-" + month + "-" + i, "pending"), lost, i + "");
            dataset.addValue(getMonthCount(year + "-" + month + "-" + i, year + "-" + month + "-" + i, "none"), found, i + "");
            dataset.addValue(getMonthCount(year + "-" + month + "-" + i, year + "-" + month + "-" + i, "total"), total, i + "");
        }
        return dataset;

    }

    private CategoryDataset createDataset() {

        // row keys...
        final String lost = "Pending";
        final String found = "Resolved";
        final String total = "Total";

        Calendar firstCal = Calendar.getInstance();
        Calendar secondCal = Calendar.getInstance();
        firstCal.setTime(firstDate);
        secondCal.setTime(lastDate);
        int firstMonth = firstCal.get(Calendar.MONTH);
        firstMonth++;
        int secondMonth = secondCal.get(Calendar.MONTH);
        secondMonth++;
        String[] months = {
            BUNDLE.getString("jan"),
            BUNDLE.getString("feb"),
            BUNDLE.getString("march"),
            BUNDLE.getString("april"),
            BUNDLE.getString("may"),
            BUNDLE.getString("juni"),
            BUNDLE.getString("juli"),
            BUNDLE.getString("aug"),
            BUNDLE.getString("sept"),
            BUNDLE.getString("okt"),
            BUNDLE.getString("nov"),
            BUNDLE.getString("dec")};
        if (firstMonth != secondMonth) {
            graphTitle = months[firstMonth - 1] + " " + BUNDLE.getString("till") + " " + months[secondMonth - 1];
        } else {
            graphTitle = months[firstMonth - 1];
        }
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String firstMY;
        String lastMY;
        if (Check.dateDiff(firstDate, lastDate) <= 31) {
            graphTitle += " (" + BUNDLE.getString("days") + ")";
            while (!firstCal.after(secondCal)) {
                int year = firstCal.get(Calendar.YEAR);
                int month = firstCal.get(Calendar.MONTH) + 1;
                int day = firstCal.get(Calendar.DAY_OF_MONTH);
                firstMY = String.format("%d-%d-%d\n", year, month, day);
                lastMY = String.format("%d-%d-%d\n", year, month, day);
                dataset.addValue(getMonthCount(firstMY, lastMY, "pending"), lost, firstCal.get(Calendar.DAY_OF_MONTH) + "");
                dataset.addValue(getMonthCount(firstMY, lastMY, "none"), found, firstCal.get(Calendar.DAY_OF_MONTH) + "");
                dataset.addValue(getMonthCount(firstMY, lastMY, "total"), total, firstCal.get(Calendar.DAY_OF_MONTH) + "");
                firstCal.add(Calendar.DATE, 1);
            }
        } else if (Check.dateDiff(firstDate, lastDate) > 31 && Check.dateDiff(firstDate, lastDate) <= 123) {
            graphTitle += " (" + BUNDLE.getString("weeks") + ")";
            while (!firstCal.after(secondCal)) {
                int year = firstCal.get(Calendar.YEAR);
                int month = firstCal.get(Calendar.MONTH) + 1;
                int day = firstCal.get(Calendar.DAY_OF_MONTH);
                firstMY = String.format("%d-%d-%d\n", year, month, day);
                lastMY = String.format("%d-%d-%d\n", year, month, day + 7);
                dataset.addValue(getMonthCount(firstMY, lastMY, "pending"), lost, firstCal.get(Calendar.WEEK_OF_YEAR) + "");
                dataset.addValue(getMonthCount(firstMY, lastMY, "none"), found, firstCal.get(Calendar.WEEK_OF_YEAR) + "");
                dataset.addValue(getMonthCount(firstMY, lastMY, "total"), total, firstCal.get(Calendar.WEEK_OF_YEAR) + "");
                firstCal.add(Calendar.DATE, 7);
            }
        } else {
            int i = 0;
            graphTitle += " (" + BUNDLE.getString("months") + ")";
            while (!firstCal.after(secondCal)) {
                int day;
                if (i > 0) {
                    day = 1;
                }else {
                day = firstCal.get(Calendar.DAY_OF_MONTH);
                }
                int year = firstCal.get(Calendar.YEAR);
                int month = firstCal.get(Calendar.MONTH) + 1;
                
                firstMY = String.format("%d-%d-%d\n", year, month, day);
                lastMY = String.format("%d-%d-%d\n", year, month, firstCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                dataset.addValue(getMonthCount(firstMY, lastMY, "pending"), lost, months[month - 1]);
                dataset.addValue(getMonthCount(firstMY, lastMY, "none"), found, months[month - 1]);
                dataset.addValue(getMonthCount(firstMY, lastMY, "total"), total, months[month - 1]);
                firstCal.add(Calendar.DATE, firstCal.getActualMaximum(Calendar.DAY_OF_MONTH));
                i++;

            }
        }
        return dataset;

    }

    /**
     * Construct the actual chart
     *
     * @param dataset
     * @return
     */
    private JFreeChart createChart(final CategoryDataset dataset) {

	// create the chart...
	chart = ChartFactory.createLineChart(
		"Luggage Statistics", // chart title
		graphTitle, // domain axis label
		"#", // range axis label
		dataset, // data
		PlotOrientation.VERTICAL, // orientation
		true, // include legend
		true, // tooltips
		false // urls
		);

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
                1.0f, new float[]{1.0f, 0.0f}, 0.0f));
        renderer.setSeriesStroke(
                1, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[]{1.0f, 0.0f}, 0.0f));
        renderer.setSeriesStroke(
                2, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[]{1.0f, 0.0f}, 0.0f));
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;
    }

    /**
     * Override the close options
     *
     * @param evt
     */
    @Override
    public void windowClosing(final WindowEvent evt) {
        if (evt.getWindow() == this) {
            dispose();

        }
    }

    File imageStream() {
        try {
            File temp = File.createTempFile("tempfile", ".tmp");
            ChartUtilities.saveChartAsJPEG(temp, chart, 500, 300);
            return temp;
        } catch (IOException e) {
            Debug.printError(e.toString());
            return null;
        }
    }
}
