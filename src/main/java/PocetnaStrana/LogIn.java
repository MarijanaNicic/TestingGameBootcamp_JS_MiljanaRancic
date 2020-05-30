package PocetnaStrana;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class LogIn {

    public Properties locators;
    public WebDriverWait waiter;
    public WebDriver driver;
    private By korisnickoIme = By.cssSelector("input.username.form-input");
    private By potrdiDugme = By.cssSelector("button.form-submit");

    public LogIn(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

    public WebElement getUnosImena(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",korisnickoIme);
        return driver.findElement(korisnickoIme);
    }
    public void setUnosImena(String postojeceIme){
        WebElement korisnik = this.getUnosImena();
        korisnik.clear();
        korisnik.sendKeys(postojeceIme);
    }

    public WebElement getPotvrdi (){
        return driver.findElement(potrdiDugme);
    }
    public void clickPotvrdi(){
        this.getPotvrdi().click();
    }



}
