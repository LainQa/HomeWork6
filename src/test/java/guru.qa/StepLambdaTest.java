package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest extends TestBase {

    @Test
    public void stepsWithLambda() {
        step("Открытие главное страницы", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + REPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").click();
            $("[data-test-selector=nav-search-input]").sendKeys(REPOSITORY);
            $("[data-test-selector=nav-search-input]").submit();
        });
        step("Переход в репозиторий" + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Открытие таблицы Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверка, что существует Issues с номером 68", () -> {
            $(withText("68")).should(Condition.visible);
        });

    }
}
