package guru.qa;


import guru.qa.steps.WebSteps;
import org.junit.jupiter.api.Test;


public class StepAnnotated extends TestBase {

    private WebSteps steps = new WebSteps();

    @Test
    public void annotatedSteps(){
        steps.openMainPage();
        steps.searchForRep(REPOSITORY);
        steps.goToRep(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
