package PredlogPojmova;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class PredlogPojmova {
    private WebDriver driver;
    private By dropdown = By.xpath("/html/body/div/form[2]/select");
    private By unosPojma = By.xpath("/html/body/div/form[2]/input");
    private By dugmePotvrdi = By.xpath("/html/body/div/form[2]/button");

    public PredlogPojmova (WebDriver driver){
        this.driver = driver;
    }
    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }
    public List<String> getSelectedOption(){
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream()
                .map(e->e.getText()).collect(Collectors.toList());
    }
    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

    public WebElement getUnosPojma(){
        return driver.findElement(unosPojma);
    }
    public void setUnosPojma(String pojam){
        WebElement pojmovi = this.getUnosPojma();
        pojmovi.clear();
        pojmovi.sendKeys(pojam);
    }
    public WebElement getDugmePotvrdi(){
        return driver.findElement(dugmePotvrdi);
    }
    public void clickDugmePotvrdi(){
        this.getDugmePotvrdi().click();
    }

}
