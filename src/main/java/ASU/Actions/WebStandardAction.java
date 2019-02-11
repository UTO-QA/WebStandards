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

    public void verifyNavigationBarStandards(){
        Assert.assertTrue("Global Nav Bar is missing", globalNavBar.isDisplayed());
        Assert.assertEquals("Height of the nav bar is not correct","57px",globalNavBar.getElement().getCssValue("height"));
//        Assert.assertEquals("Width of the nav bar is not correct","57px",globalNavBar.getElement().getCssValue("width"));
        Assert.assertEquals("Display of the nav bar is not correct","block",globalNavBar.getElement().getCssValue("display"));
    }

    public void verifyTabItemsOnNavigationBar(String tab){
        for(int i =0;i<=tabsOnAsuEdu().size();i++) {
            if (tabsOnAsuEdu().get(i).getText().trim().equals(tab)) {

                Assert.assertEquals("tab font-size is not correct","16px",tabsOnAsuEdu().get(i).getElement().getCssValue("font-size"));
                Assert.assertEquals("tab font-family is not correct","Roboto",tabsOnAsuEdu().get(i).getElement().getCssValue("font-family"));
                Assert.assertTrue("tab color without hover is not correct",tabsOnAsuEdu().get(i).getElement().getCssValue("color").contains("237, 237, 237, 1"));
                break;
            }
        }

    }


    //region Global Footer Actions
    public void validateInnovationBarIsGold()
    {
        Assert.assertTrue("Innovation bar is not gold" + innovationBar.getElement().getCssValue("background-color"),innovationBar.getElement().getCssValue("background-color").contains("255, 198, 39, 1"));
    }

    public void validateInnovationBarTextFormat()
    {
        Assert.assertTrue("Innovation bar text color is not black; it's "+ innovationRankingStatus.getElement().getCssValue("color"), innovationRankingStatus.getElement().getCssValue("color").contains("0, 0, 0"));
        Assert.assertTrue("Innovation bar font text is not the correct font family; it's " + innovationRankingStatus.getElement().getCssValue("font-family"), innovationRankingStatus.getElement().getCssValue("font-family").contains("Roboto,\"Helvetica Neue\",Helvetica,Arial,sans-serif"));
    }

    public void validateGlobalFooterIsDisplayed()
    {
        Assert.assertTrue("The footer is not displayed",globalFooter.isDisplayed());
        Assert.assertTrue("The U.S. News Best Colleges Logo is not displayed", usNewsBestCollegesLogo.isDisplayed());
    }

    public void validateUSNewsBestCollegesLogoIsDisplayed() throws Exception
    {
        Thread.sleep(5000);
        Assert.assertTrue("The U.S. News Best Colleges Logo is not displayed", usNewsBestCollegesLogo.isDisplayed());
    }

    public void validateASUInnovationRankingStatus() throws Exception
    {
        Assert.assertTrue("ASU's Ranking Status is not displayed", innovationRankingStatus.isDisplayed());
    }

    public void validateFooterMenuBackgroundColor()
    {
        Assert.assertTrue("Footer Menu Background color is not #E5E5E5, it's " + footerMenu.getElement().getCssValue("background-color"), footerMenu.getElement().getCssValue("background-color").contains("229, 229, 229, 1"));
    }

    public void validateFooterMenuHeight(String heightPx)
    {
        Assert.assertTrue("Footer Menu height is not 56px; it's "+ footerMenu.getElement().getCssValue("height"),footerMenu.getElement().getCssValue("height").contains(heightPx));
    }

    public void validateFooterMenuFontSize(String fontPx)
    {
        Assert.assertTrue("Footer menu font size is not 16px; it's " + footerMenuLocator.getElement().getCssValue("font-size"), footerMenuLocator.getElement().getCssValue("font-size").contains(fontPx));
    }

    public void validateFooterMenuFontWeight(String fontWeight)
    {
        Assert.assertTrue("Footer menu font weight is not 200; it's " + footerMenuLocator.getElement().getCssValue("font-weight"),footerMenuLocator.getElement().getCssValue("font-weight").contains(fontWeight));
    }

    public void validateInnovationBarHeight(String innovationBarHeight)
    {
        Assert.assertTrue("The innovation bar height is not 56px; it's " + innovationBar.getElement().getCssValue("height"), innovationBar.getElement().getCssValue("height").contains(innovationBarHeight));
    }

    //endregion
    public void verifySuperFooterStandards(){
       Assert.assertTrue("Super footer background-color is not black",superFooter.getElement().getCssValue("background-color").contains("30, 30, 30, 1"));
       Assert.assertEquals("Super footer font size is not correct","16px",superFooter.getElement().getCssValue("font-size"));

    }

    public void verifyContentStandardsofSuperFooter(){
        Assert.assertEquals("Super footer font size is not correct","16px",superFooterContent.getElement().getCssValue("font-size"));
        Assert.assertTrue("Super footer background-color is not black",superFooterContent.getElement().getCssValue("color").contains("255, 255, 255, 1"));
        Assert.assertEquals("Super footer font size is not correct","Roboto",superFooterContent.getElement().getCssValue("font-family"));
    }

    public void verifySocialMediaStandards(){
       for(int i =0;i<socialMediaIconList().size();i++){
           Assert.assertEquals("Social media icon font size is not correct","38px",socialMediaIconList().get(i).getElement().getCssValue("font-size"));
           Assert.assertTrue("Social media icon color is not grey",socialMediaIconList().get(i).getElement().getCssValue("color").contains("204, 204, 204, 1"));
           Assert.assertEquals("Social media icon font size is not correct","FontAwesome",socialMediaIconList().get(i).getElement().getCssValue("font-family"));
       }
    }

}
