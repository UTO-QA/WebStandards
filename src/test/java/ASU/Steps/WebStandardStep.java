package ASU.Steps;

import ASU.Actions.PageInjector;
import ASU.Locators.WebStandardLocator;
import ASU.Actions.WebStandardAction;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebStandardStep extends PageInjector {



    WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Before tag");
        System.setProperty("webdriver.chrome.driver", "/Users/ehender2/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        initFluent(driver);
        initTest();

    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void I_navigate_to_url(String url) throws Throwable  {

        webStandardAction.navigate(url);
    }

    @Then("^I verify the \"([^\"]*)\" logo$")
    public void iVerifyTheLogo(String logo) throws Throwable {
        webStandardAction.validateLogo();

    }

    @Then("^I verify the elements:$")
    public void iVerifyTheElements(List<String> elements) throws Throwable {
        WebStandardLocator webStandardLocator = new WebStandardLocator();
        for(int i =0;i<elements.size();i++) {
            List<FluentWebElement> subList = new ArrayList<FluentWebElement>();
            for (FluentWebElement element : webStandardLocator.headerList()) {
                subList = element.find("a");
                Assert.assertTrue(subList.get(0).getText().contains(elements.get(i)));
            }
        }

        throw new PendingException();
    }


    @Then("^Verify the header has white backgrounnd$")
    public void verifyTheHeaderHasWhiteBackgrounnd() throws Throwable {
        webStandardAction.verifyHeaderBackground();
    }

    @Then("^User clicks on \"([^\"]*)\" link$")
    public void userClicksOnLink(String linkName) throws Throwable {
        Assert.assertTrue(webStandardAction.clickOnLinks(linkName));
    }

    @Then("^Drop-down appears for \"([^\"]*)\" with following options \"([^\"]*)\"$")
    public void dropDownAppearsForWithFollowingOptions(String menu, String subMenuOptions) throws Throwable {
        String[] subMenuList = subMenuOptions.split(",");
        webStandardAction.verifySubMenu(menu,subMenuList);

    }

    @Then("^User should be navigated to MyASU login page$")
    public void userShouldBeNavigatedToMyASULoginPage() throws Throwable {

        webStandardAction.navigateToMyAsu();
    }

    @Then("^User should be navigate to Colleges and Schools home page$")
    public void userShouldBeNavigateToCollegesAndSchoolsHomePage() throws Throwable {
        webStandardAction.verifyNavigationToSchoolsAndCollege();
    }

    @Then("^User should be navigated to the Maps page$")
    public void userShouldBeNavigatedToTheMapsPage() throws Throwable {
        webStandardAction.verifyNavigationToMaps();

    }

    @Then("^User should be navigated to the Directory page$")
    public void userShouldBeNavigatedToTheDirectoryPage() throws Throwable {
        webStandardAction.verifyNavigationToDirectory();
    }

    @Then("^I verify the asu logo is placed at Top$")
    public void iVerifyTheAsuLogoIsPlacedAtTop() throws Throwable {
        webStandardAction.verifyASULogoPosition();
    }

    @Then("^I enter \"([^\"]*)\" to search$")
    public void iEnterToSearch(String keyword) throws Throwable {
        webStandardAction.enterKeywordforSearch(keyword);
    }

    @Then("^The user should see a list of results for the keyword \"([^\"]*)\"$")
    public void userShouldSeeListOfResults(String keyword) throws Throwable {
        webStandardAction.verifySearchResults(keyword);
    }

    @Then("^I click on ASU logo$")
    public void iClickOnASULogo() throws Throwable {
        webStandardAction.clickASULogo();
    }

    @Then("^I should be redirected to \"([^\"]*)\"$")
    public void iShouldBeRedirectedTo(String arg0) throws Throwable {
        webStandardAction.verifyRedirectionToAsuHomePage();
    }

    @Then("^I verify the home icon standards$")
    public void iVerifyTheHomeIconStandards() throws Throwable {
        webStandardAction.verifyHomeIconStandards();
    }

    @Then("^I validate the \"([^\"]*)\" button$")
    public void iValidateTheButton(String button) throws Throwable {
        webStandardAction.validateButtons(button);
    }

    @Then("^I verify the first photo on the page$")
    public void iVerifyTheFirstPhotoOnThePage() throws Throwable {
        //  webStandardAction.validatePhotoStandards();
    }

    @Then("^I go to the \"([^\"]*)\" tab verify the first photo on the page$")
    public void iGoToTheTabVerifyTheFirstPhotoOnThePage(String tab) throws Throwable {
        webStandardAction.validatePhotoStandards(tab);
    }

    @Then("^I verify the navigation bar standards$")
    public void iVerifyTheNavigationBarStandards() throws Throwable {
        webStandardAction.verifyNavigationBarStandards();

    }

    @Then("^I go to the \"([^\"]*)\" tab and verify the tab standards$")
    public void iGoToTheTabAndVerifyTheTabStandards(String tab) throws Throwable {
        webStandardAction.verifyTabItemsOnNavigationBar(tab);
    }

    @When("^I validate the footer is displayed$")
    public void iValidateTheFooterIsDisplayed() throws Throwable{
        webStandardAction.validateGlobalFooterIsDisplayed();
    }

    @Then("^Verify the following options are listed in the footer \"([^\"]*)\"$")
    public void verifyTheFollowingOptionsAreListedInTheFooter(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^Verify the 2017 U.S. News & World Report logo is displayed in the footer$")
    public void verifyThe2017USNewsAndWorldReportLogoIsDisplayedInTheFooter() throws Throwable {
        webStandardAction.validateUSNewsBestCollegesLogoIsDisplayed();

    }

    @Then("^Verify the \"([^\"]*)\" is displayed in the footer$")
    public void verifyTheIsDisplayedInTheFooter(List<String> elements) throws Throwable {
            WebStandardLocator webStandardLocator = new WebStandardLocator();
            for(int i =0;i<elements.size();i++) {
                List<FluentWebElement> subList = new ArrayList<FluentWebElement>();
                for (FluentWebElement element : webStandardLocator.headerList()) {
                    subList = element.find("a");
                    Assert.assertTrue(subList.get(0).getText().contains(elements.get(i)));
                }
            }

            throw new PendingException();
        }


    @Then("^Verify \"([^\"]*)\" is displayed in the footer$")
    public void verifyIsDisplayedInTheFooter(String arg0) throws Throwable {
        webStandardAction.validateASUInnovationRankingStatus();
    }

//    @Then("^Verify the background color for the footer menu is \"([^\"]*)\"$")
//    public void verifyTheBackgroundColorForTheFooterMenuIs() throws Throwable {
//        webStandardAction.validateFooterMenuBackgroundColor();
//
//    }
//
//    @Then("^Verify the background color for the footer menu is #E(\\d+)E(\\d+)E(\\d+)$")
//    public void verifyTheBackgroundColorForTheFooterMenuIsEEE(int arg0, int arg1, int arg2) {
//        webStandardAction.validateFooterMenuBackgroundColor();
//    }

    @Then("^Verify the background color for the footer menu is gray$")
    public void verifyTheBackgroundColorForTheFooterMenuIsGray() {
        webStandardAction.validateFooterMenuBackgroundColor();
    }


    @Then("^the gray bar on the universal footer should have a height of \"([^\"]*)\"$")
    public void theGrayBarOnTheUniversalFooterShouldHaveAHeightOf(String heightPx) throws Throwable {
        webStandardAction.validateFooterMenuHeight(heightPx);
    }

    @Then("^the universal footer's font size should be \"([^\"]*)\"$")
    public void theUniversalFooterSFontSizeShouldBe(String footerFontSize) throws Throwable {
        webStandardAction.validateFooterMenuFontSize(footerFontSize);
    }

    @Then("^the universal footer's font weight should be \"([^\"]*)\"$")
    public void theUniversalFooterSFontWeightShouldBe(String fontWeight) throws Throwable {
        webStandardAction.validateFooterMenuFontWeight(fontWeight);

    }

    @Then("^the innovation gold bar in the footer should have a height of \"([^\"]*)\"$")
    public void theInnovationGoldBarInTheFooterShouldHaveAHeightOf(String goldBarHeightSize) throws Throwable {
        webStandardAction.validateInnovationBarHeight(goldBarHeightSize);
    }

    @Then("^the innovation bar background color should be gold$")
    public void theInnovationBarBackgroundColorShouldBeGold()
    {
        webStandardAction.validateInnovationBarIsGold();
    }

    @Then("^the innovation ranking status font family should be the correct font family and in black$")
    public void theInnovationRankingStatusFontFamilyShouldBeTheCorrectFontFamilyAndInBlack()
    {
        webStandardAction.validateInnovationBarTextFormat();
    }


    @Then("^I verify the link typography standards for the first link in the carousel bar$")
    public void verifyLinkTypography() throws Throwable {
        webStandardAction.verifyLinkTypographyStandards();

    }

    @Then("^I verify the standard for super footer$")
    public void iVerifyTheStandardForSuperFooter() {
        webStandardAction.verifySuperFooterStandards();
    }

    @Then("^I verify the content style standard for super footer$")
    public void iVerifyTheContentStyleStandardForSuperFooter() {
        webStandardAction.verifyContentStandardsofSuperFooter();
    }

    @Then("^I verify the style standards for the the social  media icons$")
    public void iVerifyTheStyleStandardsForTheTheSocialMediaIcons() {
        webStandardAction.verifySocialMediaStandards();
    }


    
    
/*    @After
    public void TearDown(){
        driver.close();
        driver.quit();
    }*/


}
