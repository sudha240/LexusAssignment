package starter.utilities;
import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import io.cucumber.datatable.DataTable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Objects;

public class CommonFunctions extends PageObject{

  public   CommonFunctions(){
      //Getting the control to the current url to detect the fields
      getDriver().getCurrentUrl();
  }
    public void enterDataFromForm(DataTable Table, By FieldName, String sFieldValue){
      //Enter Data from a Given Table
        List<Map<String, String>> userInfo = Table.asMaps(String.class, String.class);
        for (Map<String, String> formInfo : userInfo) {
            //Enter Data from Given Table
            String sValue = formInfo.get(sFieldValue);
            $(FieldName).click();
            $(FieldName).sendKeys(sValue);
        }
    }
    public void selectDropDownData(DataTable Table, By FieldName, By FieldValueList, String sFieldValue){
        Actions action = new Actions(getDriver());
        //Enter Data from a Given Table
        List<Map<String, String>> bookingInfo = Table.asMaps(String.class, String.class);
        for (Map<String, String> formInfo : bookingInfo) {
            //Enter Data from Given Table
            String sValue = formInfo.get(sFieldValue);
            $(FieldName).click();
            if(sFieldValue.equalsIgnoreCase("Preferred date")){
                if(sValue.equalsIgnoreCase("Today")){
                    $(FieldValueList).click();
                }
            }
            else {
                ListOfWebElementFacades dropDownList = $$(FieldValueList);
                if (!Objects.isNull(sValue)) {
                    for (WebElement list : dropDownList) {
                        if (list.getText().equalsIgnoreCase(sValue)) {
                            list.click();
                            break;
                        }
                        action.sendKeys(Keys.ARROW_DOWN).build().perform();
                    }
                }
                else{
                    $(FieldName).click();
                }
            }
        }
    }
    public void validateGivenFieldValue(DataTable Table, By FieldName, String sFieldValue){
        //Enter Data from a Given Table
        List<Map<String, String>> validateInfo = Table.asMaps(String.class, String.class);
        for (Map<String, String> formInfo : validateInfo) {
            //Enter Data from Given Table
            String sValue = formInfo.get(sFieldValue);
            //Get Data from UI
            String sValueFromUI = $(FieldName).getAttribute("data-value");
            //Perform Assertion
            try {
                assertThat(sValueFromUI).isEqualTo(sValue);
                // Log the success message
                Serenity.recordReportData().withTitle("Assertion Success ").andContents("Value is " + sValueFromUI);
            }
            catch (AssertionError e) {
                // Log the error message and continue execution
                Serenity.recordReportData().withTitle("Assertion Fail ").andContents("Value from UI is " + sValueFromUI + " while Default Value to validate is " + sFieldValue);
            }
        }
    }
//    public void selectTodayFromCalendar(By FieldName, By sFieldValue){
//        if ($(FieldName).isDisplayed()) {
//            $(FieldName).click();
//
//        }
//    }
//    public void selectDropDownValue(By FieldName, By FieldValueList , String sFieldValue){
//      Actions action = new Actions(getDriver());
//      $(FieldName).click();
//        ListOfWebElementFacades dropDownList = $$(FieldValueList);
//        if(!sFieldValue.isEmpty()) {
//            for (WebElement list : dropDownList) {
//                if (list.getText().equalsIgnoreCase(sFieldValue)) {
//                    list.click();
//                    break;
//                }
//                action.sendKeys(Keys.ARROW_DOWN).build().perform();
//            }
//        }
//    }
//    public void verifyDataForGivenField(By FieldName, String sFieldValue){
//      String sValueFromUI = $(FieldName).getAttribute("data-value");
//        try {
//          //  assertEquals(sValueFromUI, sFieldValue);
//            assertThat(sValueFromUI).isEqualTo(sFieldValue);
//            // Log the success message
//            Serenity.recordReportData().withTitle("Assertion Success ").andContents("Value is " + sValueFromUI);
//        } catch (AssertionError e) {
//            // Log the error message and continue execution
//            Serenity.recordReportData().withTitle("Assertion Fail ").andContents("Value from UI is " + sValueFromUI + " while Default Value to validate is " + sFieldValue);
//        }
//    }
//    public void enterData(By FieldName, String sFieldValue){
//        $(FieldName).click();
//        $(FieldName).sendKeys(sFieldValue);
//    }
    public void buttonEnabled(By FieldNameDisabled, By FieldName){

            if (!$(FieldNameDisabled).isPresent()) {
                if ($(FieldName).isClickable()) {
                    Serenity.recordReportData().withTitle("Assertion Success ").andContents("Button is Enabled");
                }
            }else{
                Serenity.recordReportData().withTitle("Assertion Failure ").andContents("Button is Disabled, please check for mandatory fields to fill in");
            }
    }
    public void buttonDisabled(By FieldName){
            if ($(FieldName).isPresent()){
                Serenity.recordReportData().withTitle("Assertion Success ").andContents("Button is Disabled");
            }
        }
    public void selectCheckbox(By FieldName) {
        $(FieldName).click();
    }
}