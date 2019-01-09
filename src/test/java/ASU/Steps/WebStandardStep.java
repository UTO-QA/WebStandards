package Sample.Steps;

import Sample.Actions.PageInjector;
import Sample.Locators.WebStandardLocator;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebStandardStep extends PageInjector {


    WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Before tag");
        System.setProperty("webdriver.chrome.driver", "C:/Users/jrai4/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        initFluent(driver);
        initTest();


//        driver = new FirefoxDriver();
//        initFluent(driver);
//        initTest();
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

    @After
    public void TearDown(){
        driver.close();
        driver.quit();
    }


}
