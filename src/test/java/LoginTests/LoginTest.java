package LoginTests;

import PocetnaStrana.LogIn;
import base.baseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends baseTests {

    @Test
    public void testPostojecegKorisnika() throws InterruptedException {
        driver.get("https://zgeografija-cefd4.web.app/");
        SoftAssert sa = new SoftAssert();
        LogIn postojeci = new LogIn(driver);
        Thread.sleep(5000);
        postojeci.setUnosImena("miljanarancic");
        Thread.sleep(5000);
        postojeci.clickPotvrdi();

        sa.assertAll();


    }
}
