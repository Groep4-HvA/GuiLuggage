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

public class ManagerGraph extends ApplicationFrame {

    ConnectionMySQL conn = new ConnectionMySQL();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Date date = new Date();
    private String dateString = dateFormat.format(date);
    private PreparedStatement prdstmt = null;

    public ManagerGraph(final String title, boolean beheer) throws SQLException {
	super(title);
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

	    ResultSet rs = null;

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

    private CategoryDataset createDataset() {

	// row keys...
	final String lost = "Pending";
	final String found = "Resolved";
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

	dataset.addValue(getMonthCount("2013-01-01", "2013-01-31", "pending"), lost, januari);
	dataset.addValue(getMonthCount("2013-02-01", "2013-02-31", "pending"), lost, februari);
	dataset.addValue(getMonthCount("2013-03-01", "2013-03-31", "pending"), lost, march);
	dataset.addValue(getMonthCount("2013-04-01", "2013-04-31", "pending"), lost, april);
	dataset.addValue(getMonthCount("2013-05-01", "2013-05-31", "pending"), lost, may);
	dataset.addValue(getMonthCount("2013-06-01", "2013-06-31", "pending"), lost, june);
	dataset.addValue(getMonthCount("2013-07-01", "2013-07-31", "pending"), lost, july);
	dataset.addValue(getMonthCount("2013-08-01", "2013-08-31", "pending"), lost, august);
	dataset.addValue(getMonthCount("2013-09-01", "2013-09-31", "pending"), lost, september);
	dataset.addValue(getMonthCount("2013-10-01", "2013-10-31", "pending"), lost, october);
	dataset.addValue(getMonthCount("2013-11-01", "2013-11-31", "pending"), lost, november);
	dataset.addValue(getMonthCount("2013-12-01", "2013-12-31", "pending"), lost, december);

	dataset.addValue(getMonthCount("2013-01-01", "2013-01-31", "none"), found, januari);
	dataset.addValue(getMonthCount("2013-02-01", "2013-02-31", "none"), found, februari);
	dataset.addValue(getMonthCount("2013-03-01", "2013-03-31", "none"), found, march);
	dataset.addValue(getMonthCount("2013-04-01", "2013-04-31", "none"), found, april);
	dataset.addValue(getMonthCount("2013-05-01", "2013-05-31", "none"), found, may);
	dataset.addValue(getMonthCount("2013-06-01", "2013-06-31", "none"), found, june);
	dataset.addValue(getMonthCount("2013-07-01", "2013-07-31", "none"), found, july);
	dataset.addValue(getMonthCount("2013-08-01", "2013-08-31", "none"), found, august);
	dataset.addValue(getMonthCount("2013-09-01", "2013-09-31", "none"), found, september);
	dataset.addValue(getMonthCount("2013-10-01", "2013-10-31", "none"), found, october);
	dataset.addValue(getMonthCount("2013-11-01", "2013-11-31", "none"), found, november);
	dataset.addValue(getMonthCount("2013-12-01", "2013-12-31", "none"), found, december);

	dataset.addValue(getMonthCount("2013-01-01", "2013-01-31", "total"), total, januari);
	dataset.addValue(getMonthCount("2013-02-01", "2013-02-31", "total"), total, februari);
	dataset.addValue(getMonthCount("2013-03-01", "2013-03-31", "total"), total, march);
	dataset.addValue(getMonthCount("2013-04-01", "2013-04-31", "total"), total, april);
	dataset.addValue(getMonthCount("2013-05-01", "2013-05-31", "total"), total, may);
	dataset.addValue(getMonthCount("2013-06-01", "2013-06-31", "total"), total, june);
	dataset.addValue(getMonthCount("2013-07-01", "2013-07-31", "total"), total, july);
	dataset.addValue(getMonthCount("2013-08-01", "2013-08-31", "total"), total, august);
	dataset.addValue(getMonthCount("2013-09-01", "2013-09-31", "total"), total, september);
	dataset.addValue(getMonthCount("2013-10-01", "2013-10-31", "total"), total, october);
	dataset.addValue(getMonthCount("2013-11-01", "2013-11-31", "total"), total, november);
	dataset.addValue(getMonthCount("2013-12-01", "2013-12-31", "total"), total, december);

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

    @Override
    public void windowClosing(final WindowEvent evt) {
	if (evt.getWindow() == this) {
	    dispose();

	}
    }
}