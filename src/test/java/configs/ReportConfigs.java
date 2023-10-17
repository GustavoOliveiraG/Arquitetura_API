package configs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportConfigs {

    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
    public static ExtentTest test;


    public static void criateReport(){
        extent.attachReporter(spark);
    }

    public static void addInfoReport(String nameTeste, String classTest){
        test = extent.createTest(nameTeste).assignCategory(classTest);

    }

    public static void addLogReport(String json){
        test.log(Status.PASS, json);
    }

    public static void resultReport(){
        extent.flush();
    }

}