package configs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestsConfigs {

    @BeforeMethod
    public void beforeTest(Method method){

        ReportConfigs.criateReport();
        ReportConfigs.addInfoReport(method.getName(),method.getDeclaringClass().getSimpleName());

    }

    @AfterMethod
    public void afterTest(){
        ReportConfigs.resultReport();
    }

}
