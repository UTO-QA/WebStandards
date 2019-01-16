package ASU.Actions;

import ASU.Locators.WebStandardLocator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class WebStandardAction extends WebStandardLocator {
    public void navigate(String url){
        goTo(url);
    }

    public void validateLogo(){
        Assert.assertTrue(logo.getAttribute("src").equals("https://www.asu.edu/asuthemes/4.6/assets/full_logo.png"));
        //logo.getElement().getCssValue()
    }

    public void verifyHeaderBackground(){
        Assert.assertTrue(find(".asu_hdr_white").size()!=0);
    }

    public boolean clickOnLinks(String name){
        boolean find = false;
        for (int i = 0;i<headerList().size();i++) {
            if(headerList().get(i).getText().contains(name)){
                headerList().get(i).click();
                find = true;
            }
        }
        return find;
    }

    public boolean verifySubMenu(String menuName, String[] subMenuList){
        List<FluentWebElement> dropDownList;
        boolean find = false;
        for (int i = 0;i<headerList().size();i++) {
            if(headerList().get(i).getText().contains(menuName)){
                dropDownList =  menu(i+1);
                for (int j = 0;j<dropDownList.size();j++){
                    find = false;
                    if(dropDownList.get(j).getAttribute("title").contains(subMenuList[i].trim()))
                        find = true;
                }
            }
        }
        return find;
    }

    public void navigateToMyAsu(){
        Assert.assertTrue("User was not redirected to myasu login",getDriver().getCurrentUrl().contains("https://weblogin.asu.edu/cas/login"));
        Assert.assertTrue(loginContainer.isDisplayed());
    }

    public void verifyNavigationToSchoolsAndCollege(){
        Assert.assertEquals("User was not redirected to Schools and College page","https://www.asu.edu/about/colleges-and-schools",getDriver().getCurrentUrl());
    }

    public void verifyNavigationToMaps(){
        Assert.assertEquals("User was not redirected to maps page","https://www.asu.edu/map/interactive/",getDriver().getCurrentUrl());
    }

    public void verifyNavigationToDirectory(){
        Assert.assertEquals("User was not redirected to directory page","https://isearch.asu.edu/asu-people/", getDriver().getCurrentUrl());
    }

    public void verifyASULogoPosition(){
        Assert.assertEquals("Asu logo is not positioned at top","_top",asuLogo.getAttribute("target"));
        Assert.assertEquals("Asu logo url is incorrect","https://www.asu.edu/", asuLogo.getAttribute("href"));
        Assert.assertTrue("Asu logo font is not correct",asuLogo.getElement().getCssValue("font-family").contains("sans-serif"));
        Assert.assertTrue("Asu logo height is not correct",asuLogoImage.getElement().getCssValue("height").contains("36px"));
        Assert.assertTrue("Asu logo width is not correct",asuLogoImage.getElement().getCssValue("width").contains("200px"));
    }

    public void enterKeywordforSearch(String keyword){
        click(globalSearchBox);
        globalSearchBox.fill().with(keyword);
        globalSearchBox.getElement().sendKeys(Keys.ENTER);
        Assert.assertTrue(searchResults.getText().contains(keyword));
    }

    public void verifySearchResults(String keyword){
        Assert.assertTrue(searchResultBar.isDisplayed());
        Assert.assertTrue(searchResults.getText().contains(keyword));
    }

    public void clickASULogo(){
        click(asuLogo);
    }

    public void verifyRedirectionToAsuHomePage(){
        Assert.assertEquals("User was not redirected after clicking on logo icon","https://www.asu.edu/",getDriver().getCurrentUrl());
    }

    public void verifyHomeIconStandards(){
        Assert.assertEquals("Font-family of home icon is not correct", "FontAwesome",homeIcon.getElement().getCssValue("font-family"));
        Assert.assertEquals("Font size of home icon is not correct","16px",homeIcon.getElement().getCssValue("font-size"));
        Assert.assertTrue("Home Icon color is not correct",homeIcon.getElement().getCssValue("color").contains("255, 178, 4, 1"));
        Assert.assertEquals("Font-style of home icon is not correct", "normal",homeIcon.getElement().getCssValue("font-style"));
    }

    public void validateButtons(String button){
        if(button.equals("Apply") || button.equals("Request info")){
            Assert.assertTrue(goldButton.isDisplayed());
            Assert.assertTrue(goldButton.getElement().getCssValue("background-color").contains("255, 196, 37"));
        }
        else if(button.equals("Undergraduate")){
            Assert.assertTrue(blueButton.isDisplayed());
            Assert.assertTrue(blueButton.getElement().getCssValue("background-color").contains("0, 142, 214"));
        }
    }

    public void validatePhotoStandards(String tab){
        for(int i =0;i<=tabsOnAsuEdu().size();i++){
            if(tabsOnAsuEdu().get(i).getText().trim().equals(tab)){
                tabsOnAsuEdu().get(i).click();
                String source = imagesOnAsuEdu().get(i).getAttribute("src");
                Assert.assertEquals("Image width is not correct",imagesOnAsuEdu().get(i).getAttribute("width"),"1920");
                Assert.assertEquals("Image height is not correct",imagesOnAsuEdu().get(i).getAttribute("height"),"1080");
            }
        }

    }
}
