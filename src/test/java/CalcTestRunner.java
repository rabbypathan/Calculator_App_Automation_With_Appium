import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CalcTestRunner extends Setup{
    CalcScreen screen;

    @Test(description = "Series Calculation")
    public void Calc() {
        CalcScreen screen = new CalcScreen(driver);
        String value = screen.doSeries("100/10*5-10+60");
        System.out.println(value);
        Assert.assertEquals(value, "100");


    }

}


