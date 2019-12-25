package common;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


@Data
public abstract class AbstractPage{

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;


    public AbstractPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.actions = new Actions(webDriver);
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, 30);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(webDriver,this);

    }
}