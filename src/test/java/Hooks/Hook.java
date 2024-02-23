package Hooks;


import utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hook {

   /* @Before
    public void before(){
        setUp();
    }

    */

    @Before()
    public void before_ui(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Driver.getDriver().manage().window().maximize();
    }

    @After()
    public void tearDown() {

        // Driver.closeDriver();
    }
}
