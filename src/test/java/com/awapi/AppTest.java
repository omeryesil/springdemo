package com.awapi;

import com.awapi.controller.HomeController;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by yesiome on 9/1/2016.
 */
public class AppTest {

    @Test
    public void homeController_Test() {
        HomeController home = new HomeController();
        String result = home.home();

        assertEquals(result, "Das Boot, reporting for duty!");
    }


}
