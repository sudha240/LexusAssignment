package starter.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.core.Serenity;
import starter.pages.TestDriveBookingHomePage;
import java.io.IOException;
import io.cucumber.datatable.DataTable;
import java.util.*;

public class FillFormStepDefinitions {
    TestDriveBookingHomePage testDriveBookingHomePage;
    public FillFormStepDefinitions() throws Exception {
        testDriveBookingHomePage = new TestDriveBookingHomePage();
    }

    @Given("Navigate to HomePage")
    public void navigateToHomePage() throws IOException {
        testDriveBookingHomePage.navigateToHomePage();
    }

    @Then("Fill up the personal details in the form")
    public void fillPersonalDetails(DataTable Table) throws IOException {
        testDriveBookingHomePage.personalInfo(Table);
    }
    @And("Select the following booking details")
    public void selectBookingDetails(DataTable Table) throws IOException {
        testDriveBookingHomePage.bookingDetails(Table);
    }
    @And("Verify the default Preferred model")
    public void validatePreferredModel(DataTable Table) throws IOException {
        testDriveBookingHomePage.validateInfo(Table);
    }
    @And("Check the Driving license")
    public void selectDLCheckbox() throws IOException {
        testDriveBookingHomePage.selectDLCheckbox();
    }
    @And("Check the Privacy policy")
    public void selectPPCheckbox() throws IOException {
        testDriveBookingHomePage.selectPPCheckbox();
    }
    @And("Check the Terms and services")
    public void selectTCCheckbox() throws IOException {
            testDriveBookingHomePage.selectTCCheckbox();
    }
    @And("Check the Marketing consent")
    public void selectMCCheckbox() throws IOException {
        testDriveBookingHomePage.selectMCCheckbox();
    }
    @And("Check whether the Submit button is Disabled")
    public void checkButtonDisabled() throws IOException {
        testDriveBookingHomePage.checkButtonStatusDisabled();
    }
    @And("Check whether the Submit button is Enabled")
    public void checkButtonEnabled() throws IOException {
        testDriveBookingHomePage.checkButtonStatusEnabled();
    }
}