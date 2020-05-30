package PredlogPojmovaTest;

import PredlogPojmova.PredlogPojmova;
import base.baseTests;
import org.testng.annotations.Test;

public class PredlogPojmovaTest extends baseTests {


    @Test void predlogPojmova() throws InterruptedException {

        PredlogPojmova predlog = new PredlogPojmova(driver);
        String option = "Biljka";
        predlog.selectFromDropDown(option);

        var secectedOption = predlog.getSelectedOption();
        predlog.setUnosPojma("Kaliopi");
        Thread.sleep(5000);
    }

}
