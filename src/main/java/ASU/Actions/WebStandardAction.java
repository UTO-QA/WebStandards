package ASU.Actions;

import ASU.Locators.WebStandardLocator;
import org.junit.Assert;

public class WebStandardAction extends WebStandardLocator {

    public void navigate(String url){
        goTo(url);
    }

    public void validateLogo(){
        Assert.assertTrue(logo.getAttribute("src").equals("https://www.asu.edu/asuthemes/4.6/assets/full_logo.png"));
    }
}
