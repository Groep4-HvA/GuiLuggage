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

    public double january() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-01-01' AND '2013-01-31'";


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

    public double february() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-02-01' AND '2013-02-31'";


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

    public double march() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-03-01' AND '2013-03-31'";


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

    public double april() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-04-01' AND '2013-04-31'";


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

    public double may() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-05-01' AND '2013-05-31'";


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

    public double june() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-06-01' AND '2013-06-31'";


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

    public double july() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-07-01' AND '2013-07-31'";


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

    public double august() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-08-01' AND '2013-08-31'";


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
    
    public double september() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-09-01' AND '2013-09-31'";


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
    
    public double october() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-10-01' AND '2013-10-31'";


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
    
    public double november() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-11-01' AND '2013-11-31'";


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
    
    public double december() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NOT NULL AND `addDate` BETWEEN  '2013-12-01' AND '2013-12-31'";


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
    
        public double januaryPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS NULL AND `addDate` BETWEEN  '2013-01-01' AND '2013-01-31'";


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

    public double februaryPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-02-01' AND '2013-02-31'";


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

    public double marchPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-03-01' AND '2013-03-31'";


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

    public double aprilPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-04-01' AND '2013-04-31'";


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

    public double mayPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-05-01' AND '2013-05-31'";


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

    public double junePending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-06-01' AND '2013-06-31'";


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

    public double julyPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-07-01' AND '2013-07-31'";


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

    public double augustPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-08-01' AND '2013-08-31'";


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
    
    public double septemberPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-09-01' AND '2013-09-31'";


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
    
    public double octoberPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-10-01' AND '2013-10-31'";


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
    
    public double novemberPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-11-01' AND '2013-11-31'";


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
    
    public double decemberPending() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases` WHERE `resolveDate` IS  NULL AND `addDate` BETWEEN  '2013-12-01' AND '2013-12-31'";


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
    
        public double januaryTotal() throws SQLException {
        conn.startConnection();

        String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-01-01' AND '2013-01-31'";


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

    public double februaryTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-02-01' AND '2013-02-31'";

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

    public double marchTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-03-01' AND '2013-03-31'";

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

    public double aprilTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-04-01' AND '2013-04-31'";

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

    public double mayTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-05-01' AND '2013-05-31'";

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

    public double juneTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-06-01' AND '2013-06-31'";

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

    public double julyTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-07-01' AND '2013-07-31'";

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

    public double augustTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-08-01' AND '2013-08-31'";

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
    
    public double septemberTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-09-01' AND '2013-09-31'";

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
    
    public double octoberTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-10-01' AND '2013-10-31'";

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
    
    public double novemberTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-11-01' AND '2013-11-31'";

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
    
    public double decemberTotal() throws SQLException {
        conn.startConnection();

     String sql = "SELECT `LuggageNumber`, LEFT(AddDate ,10) FROM `cases`WHERE `AddDate` BETWEEN '2013-12-01' AND '2013-12-31'";

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

        dataset.addValue(januaryPending(), lost, januari);
        dataset.addValue(februaryPending(), lost, februari);
        dataset.addValue(marchPending(), lost, march);
        dataset.addValue(aprilPending(), lost, april);
        dataset.addValue(mayPending(), lost, may);
        dataset.addValue(junePending(), lost, june);
        dataset.addValue(julyPending(), lost, july);
        dataset.addValue(augustPending(), lost, august);
        dataset.addValue(septemberPending(), lost, september);
        dataset.addValue(octoberPending(), lost, october);
        dataset.addValue(novemberPending(), lost, november);
        dataset.addValue(decemberPending(), lost, december);

        dataset.addValue(january(), found, januari);
        dataset.addValue(february(), found, februari);
        dataset.addValue(march(), found, march);
        dataset.addValue(april(), found, april);
        dataset.addValue(may(), found, may);
        dataset.addValue(june(), found, june);
        dataset.addValue(july(), found, july);
        dataset.addValue(august(), found, august);
        dataset.addValue(september(), found, september);
        dataset.addValue(october(), found, october);
        dataset.addValue(november(), found, november);
        dataset.addValue(december(), found, december);

        dataset.addValue(januaryTotal(), total, januari);
        dataset.addValue(februaryTotal(), total, februari);
        dataset.addValue(marchTotal(), total, march);
        dataset.addValue(aprilTotal(), total, april);
        dataset.addValue(mayTotal(), total, may);
        dataset.addValue(juneTotal(), total, june);
        dataset.addValue(julyTotal(), total, july);
        dataset.addValue(augustTotal(), total, august);
        dataset.addValue(septemberTotal(), total, september);
        dataset.addValue(octoberTotal(), total, october);
        dataset.addValue(novemberTotal(), total, november);
        dataset.addValue(decemberTotal(), total, december);

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