package Sample.Locators;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WebStandardLocator extends FluentPage {



    public List<FluentWebElement> headerList() {
        return find("#asu_nav_menu #asu_universal_nav ul:first-child>li");
    }

    @FindBy(css="#asu_logo a img")
    public FluentWebElement logo;




}
