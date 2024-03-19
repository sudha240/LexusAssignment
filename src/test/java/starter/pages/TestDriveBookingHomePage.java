package starter.pages;
import starter.utilities.PropLocation;
import starter.utilities.ReadPropertiesValues;
import starter.utilities.CommonFunctions;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import java.io.IOException;
import org.openqa.selenium.By;
import io.cucumber.datatable.DataTable;
import java.util.*;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class TestDriveBookingHomePage extends PageObject {
    static PropLocation propFile = new PropLocation();
    static ReadPropertiesValues eleLocated = new ReadPropertiesValues(propFile.elementLocation());
    CommonFunctions commonFunctions= new CommonFunctions();

    //Data
    String sSiteUrl;

    //Locators
    By Lexus_AcceptCookies;
    By Lexus_FirstName;
    By Lexus_LastName;
    By Lexus_EmailAddress;
    By Lexus_PhoneNumber;
    By Lexus_CalendarIcon;
    By Lexus_PreferredDate;
    By Lexus_PreferredTimeInput;
    By Lexus_PreferredTimeList;
    By Lexus_SalesConsultantInput;
    By Lexus_SalesConsultantList;
    By Lexus_SalesConsultantListClose;
    By Lexus_NumberOfPaxInput;
    By Lexus_NumberOfPaxList;
    By Lexus_PreferredModel;
    By Lexus_TestDriveOptionInput;
    By Lexus_TestDriveOptionList;
    By Lexus_YearOfVehicle;
    By Lexus_SubmitButton;
    By Lexus_SubmitButtonDisabled;
    By Lexus_TermsAndConditions;
    By Lexus_MarketingConsent;
    By Lexus_DrivingLicense;
    By Lexus_PrivacyPolicy;
    WebElement ele;

    public TestDriveBookingHomePage() throws Exception {
        //Data
        sSiteUrl = eleLocated.readProperty("lexus_sAppURL");

        //Elements
        Lexus_AcceptCookies = By.xpath(eleLocated.readProperty("lexus_acceptCookies"));
        Lexus_FirstName = By.xpath(eleLocated.readProperty("lexus_firstName"));
        Lexus_LastName = By.xpath(eleLocated.readProperty("lexus_lastName"));
        Lexus_EmailAddress = By.xpath(eleLocated.readProperty("lexus_emailAddress"));
        Lexus_PhoneNumber = By.xpath(eleLocated.readProperty("lexus_phoneNumber"));
        Lexus_CalendarIcon = By.xpath(eleLocated.readProperty("lexus_calendarIcon"));
        Lexus_PreferredDate = By.xpath(eleLocated.readProperty("lexus_preferredDate"));
        Lexus_PreferredTimeInput = By.xpath(eleLocated.readProperty("lexus_preferredTimeInput"));
        Lexus_PreferredTimeList = By.xpath(eleLocated.readProperty("lexus_preferredTimeList"));
        Lexus_SalesConsultantInput = By.xpath(eleLocated.readProperty("lexus_salesConsultantInput"));
        Lexus_SalesConsultantList = By.xpath(eleLocated.readProperty("lexus_salesConsultantList"));
        Lexus_SalesConsultantListClose = By.xpath(eleLocated.readProperty("lexus_salesConsultantListClose"));
        Lexus_NumberOfPaxInput = By.xpath(eleLocated.readProperty("lexus_numberOfPaxInput"));
        Lexus_NumberOfPaxList = By.xpath(eleLocated.readProperty("lexus_numberOfPaxList"));
        Lexus_PreferredModel = By.xpath(eleLocated.readProperty("lexus_preferredModel"));
        Lexus_TestDriveOptionInput = By.xpath(eleLocated.readProperty("lexus_testDriveOptionInput"));
        Lexus_TestDriveOptionList = By.xpath(eleLocated.readProperty("lexus_testDriveOptionList"));
        Lexus_YearOfVehicle = By.xpath(eleLocated.readProperty("lexus_yearOfVehicle"));
        Lexus_SubmitButton = By.xpath(eleLocated.readProperty("lexus_submitButton"));
        Lexus_SubmitButtonDisabled = By.xpath(eleLocated.readProperty("lexus_submitButtonDisabled"));
        Lexus_TermsAndConditions = By.xpath(eleLocated.readProperty("lexus_termsAndConditions"));
        Lexus_MarketingConsent = By.xpath(eleLocated.readProperty("lexus_marketingConsent"));
        Lexus_DrivingLicense = By.xpath(eleLocated.readProperty("lexus_drivingLicense"));
        Lexus_PrivacyPolicy = By.xpath(eleLocated.readProperty("lexus_privacyPolicy"));
    }
   public void acceptcookies() throws IOException {
       //Accept cookies if present
       if ($(Lexus_AcceptCookies).isPresent() && $(Lexus_AcceptCookies).isClickable()) {
           $(Lexus_AcceptCookies).click();
       }
    }
    public void navigateToHomePage() throws IOException {
        //HomePage navigation
        //Accept cookies if present and maximise the browser
        openUrl(sSiteUrl);
        acceptcookies();
        getDriver().manage().window().maximize();
    }
    public void personalInfo(DataTable PersonalInfo) throws IOException {
        //Enter Personal Info
        commonFunctions.enterDataFromForm(PersonalInfo,Lexus_FirstName,"First Name");
        commonFunctions.enterDataFromForm(PersonalInfo,Lexus_LastName,"Last Name");
        commonFunctions.enterDataFromForm(PersonalInfo,Lexus_EmailAddress,"Email Address");
        commonFunctions.enterDataFromForm(PersonalInfo,Lexus_PhoneNumber,"Phone Number");
    }
    public void bookingDetails(DataTable BookingDetails) throws IOException {
        //Setting a scroll element to view the other details
        ele = $(Lexus_PhoneNumber);
        //To Scroll down to this element
        (getJavascriptExecutorFacade()).executeScript("arguments[0].scrollIntoView(true);", ele);
        commonFunctions.selectDropDownData(BookingDetails,Lexus_CalendarIcon,Lexus_PreferredDate,"Preferred date");
        commonFunctions.selectDropDownData(BookingDetails,Lexus_PreferredTimeInput,Lexus_PreferredTimeList,"Preferred time");
        commonFunctions.selectDropDownData(BookingDetails,Lexus_SalesConsultantInput,Lexus_SalesConsultantListClose,"Preferred sales consultant");
        commonFunctions.selectDropDownData(BookingDetails,Lexus_NumberOfPaxInput,Lexus_NumberOfPaxList,"Number of pax");
        commonFunctions.selectDropDownData(BookingDetails,Lexus_TestDriveOptionInput,Lexus_TestDriveOptionList,"Test drive option");
    }
    public void validateInfo(DataTable PreferredModel) throws IOException {
        commonFunctions.validateGivenFieldValue(PreferredModel,Lexus_PreferredModel,"Preferred models");
    }
    public void checkButtonStatusEnabled() throws IOException {
        //Check Button is enabled or disabled
        commonFunctions.buttonEnabled(Lexus_SubmitButtonDisabled,Lexus_SubmitButton);
    }
    public void checkButtonStatusDisabled() throws IOException {
        //Check Button is enabled or disabled
        commonFunctions.buttonDisabled(Lexus_SubmitButtonDisabled);
    }
    public void selectTCCheckbox() throws IOException {
        //Select Terms And Conditions checkbox
        commonFunctions.selectCheckbox(Lexus_TermsAndConditions);
    }
    public void selectMCCheckbox() throws IOException {
        //Select Marketing consent checkbox
        commonFunctions.selectCheckbox(Lexus_MarketingConsent);
    }
    public void selectDLCheckbox() throws IOException {
        ele = $(Lexus_YearOfVehicle);
        (getJavascriptExecutorFacade()).executeScript("arguments[0].scrollIntoView(true);", ele);
        //Select Driving License checkbox
        commonFunctions.selectCheckbox(Lexus_DrivingLicense);
    }
    public void selectPPCheckbox() throws IOException {
        //Select Privacy Policy checkbox
        commonFunctions.selectCheckbox(Lexus_PrivacyPolicy);
    }
}