package main;

import DBUtil.ConnectionMySQL;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.WindowEvent;
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
    private java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
    private final Date date = new Date();
    private final String dateString = dateFormat.format(date);
    private PreparedStatement prdstmt = null;
    private Date firstDate;
    private Date lastDate;
    private String graphTitle;

    /**
     * Constructor
     *
     * @param title
     * @param beheer
     * @throws SQLException
     */
    public ManagerGraph(final String title, boolean beheer) {

	super(title);
	if (!Check.verifyLogin()) {
	    Runtime.getRuntime().exit(1);
	} else {

	    final CategoryDataset dataset = createDefaultDataset();
	    final JFreeChart chart = createChart(dataset);
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
     * @throws SQLException
     */
    public ManagerGraph(String title, boolean beheer, Date firstDate, Date lastDate) {
	super(title);
	this.firstDate = firstDate;
	this.lastDate = lastDate;
	if (!Check.verifyLogin()) {
	    Runtime.getRuntime().exit(1);
	} else {
	    final CategoryDataset dataset = createDataset();
	    final JFreeChart chart = createChart(dataset);
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

	String[] months = {bundle.getString("jan"),
	    bundle.getString("feb"),
	    bundle.getString("march"),
	    bundle.getString("april"),
	    bundle.getString("may"),
	    bundle.getString("juni"),
	    bundle.getString("juli"),
	    bundle.getString("aug"),
	    bundle.getString("sept"),
	    bundle.getString("okt"),
	    bundle.getString("nov"),
	    bundle.getString("dec")};

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
	    bundle.getString("jan"),
	    bundle.getString("feb"),
	    bundle.getString("march"),
	    bundle.getString("april"),
	    bundle.getString("may"),
	    bundle.getString("juni"),
	    bundle.getString("juli"),
	    bundle.getString("aug"),
	    bundle.getString("sept"),
	    bundle.getString("okt"),
	    bundle.getString("nov"),
	    bundle.getString("dec")};
	if (firstMonth != secondMonth) {
	    graphTitle = months[firstMonth - 1] + " " + bundle.getString("till") + " " + months[secondMonth - 1];
	} else {
	    graphTitle = months[firstMonth - 1];
	}
	// create the dataset...
	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	String firstMY;
	String lastMY;
	if (dateDiff(firstDate, lastDate) <= 31) {
	    graphTitle += " (" + bundle.getString("days") + ")";
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
	} else if (dateDiff(firstDate, lastDate) > 31 && dateDiff(firstDate, lastDate) <= 123) {
	    graphTitle += " (" + bundle.getString("weeks") + ")";
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
	    graphTitle += " (" + bundle.getString("months") + ")";

	    while (!firstCal.after(secondCal)) {
		int year = firstCal.get(Calendar.YEAR);
		int month = firstCal.get(Calendar.MONTH) +1;
		int day = firstCal.get(Calendar.DAY_OF_MONTH);
		firstMY = String.format("%d-%d-%d\n", year, month, day);
		lastMY = String.format("%d-%d-%d\n", year, month, firstCal.getActualMaximum(Calendar.DAY_OF_MONTH));
		dataset.addValue(getMonthCount(firstMY, lastMY, "pending"), lost, months[month - 1]);
		dataset.addValue(getMonthCount(firstMY, lastMY, "none"), found, months[month - 1]);
		dataset.addValue(getMonthCount(firstMY, lastMY, "total"), total, months[month - 1]);
		firstCal.add(Calendar.DATE, firstCal.getActualMaximum(Calendar.DAY_OF_MONTH));
	    }
	}
	return dataset;

    }

    private int dateDiff(Date d1, Date d2) {
	long diff = d2.getTime() - d1.getTime();
	int diffDays = (int) (diff / (24 * 60 * 60 * 1000));

	return diffDays;

    }

    /**
     * Construct the actual chart
     *
     * @param dataset
     * @return
     */
    private JFreeChart createChart(final CategoryDataset dataset) {

	// create the chart...
	final JFreeChart chart = ChartFactory.createLineChart(
		"Luggage Statistics", // chart title
		graphTitle, // domain axis label
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
}