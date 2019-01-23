package ASU.Locators;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class WebStandardLocator extends FluentPage {



    public List<FluentWebElement> headerList() {

        return find("#asu_nav_menu #asu_universal_nav ul:first-child>li");
    }

    @FindBy(css="#asu_logo a img")
    public FluentWebElement logo;

    @FindBy(css="#asu_logo a")
    public FluentWebElement asuLogo;

    @FindBy(css="#asu_logo a img")
    public FluentWebElement asuLogoImage;

    @FindBy(css = ".asu_hdr_white")
    public FluentWebElement whiteHeader;

    public List<FluentWebElement> menu(int i){
        return find("#asu_nav_menu #asu_universal_nav ul:first-child>li:nth-of-type("+i+")>ul>li a");
    }

    @FindBy(css="#login_container")
    public FluentWebElement loginContainer;

    @FindBy(css = "#asu_search_module .asu_search_box")
    public FluentWebElement globalSearchBox;

    @FindBy(css=".results-table td")
    public FluentWebElement searchResults;

    @FindBy(css=".search-header")
    public FluentWebElement searchResultBar;

    @FindBy(css=".fa.fa-home")
    public FluentWebElement homeIcon;

    @FindBy(css=".btn.btn-gold")
    public FluentWebElement goldButton;

    @FindBy(css=".btn-programs")
    public FluentWebElement blueButton;

    @FindBy(css="#ASUNavMenu")
    public FluentWebElement globalNavBar;

    public List<FluentWebElement> imagesOnAsuEdu(){
        return find(".field-item span img");
    }

    public List<FluentWebElement> tabsOnAsuEdu(){
        return find(".block-tb-megamenu .tb-megamenu-main-menu .tb-megamenu-nav>li a");
    }




}
