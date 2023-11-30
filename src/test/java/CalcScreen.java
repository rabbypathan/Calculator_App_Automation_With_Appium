import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnPlus;

    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnSub;

    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement btnMul;

    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement btnDiv;



    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btnEqual;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement txtResult;


    AndroidDriver driver;

    public CalcScreen(AndroidDriver driver){
        this.driver =driver;
        PageFactory.initElements( new AppiumFieldDecorator(driver) ,this);
    }

    public String doSeries(String series){

        for (int i =0; i<series.length();i++) {
            if(Character.isDigit(series.charAt(i))){
                driver.findElement(By.id("com.google.android.calculator:id/digit_"+series.charAt(i))).click();
            } else if (series.charAt(i)=='+') {
                btnPlus.click();
            }else if (series.charAt(i)=='-') {
                btnSub.click();
            }else if (series.charAt(i)=='*') {
                btnMul.click();
            }else if (series.charAt(i)=='/') {
                btnDiv.click();
            }
        }
        btnEqual.click();

        return txtResult.getText();
    }

}