package guru.qa;

import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;


public class TestBase {

    @BeforeAll
    public static void beforeAll() {
        Configuration.startMaximized=true;
    }
    public static final String REPOSITORY = "eroshenkoam/allure-example";

}

