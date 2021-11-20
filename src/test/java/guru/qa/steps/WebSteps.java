package guru.qa.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


public class WebSteps {
    @Step("Открытие главное страницы")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Ищем репозиторий")
    public void searchForRep(String repository){

        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").sendKeys(repository);
        $("[data-test-selector=nav-search-input]").submit();
    }

    @Step("Переход в репозиторий {repository}")
    public void goToRep(String repository){
        $(linkText("eroshenkoam/allure-example")).click();
    }

    @Step("Открытие таблицы Issues")
    public void openIssueTab(){
        $(partialLinkText("Issues")).click();

    }

    @Step("Проверка, что существует Issues с номером {number}")
    public void shouldSeeIssueWithNumber(int number){
        $(withText("#" + number)).should(Condition.visible);
    }
}
