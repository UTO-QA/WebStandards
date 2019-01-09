package ASU.Actions;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.cucumber.adapter.FluentCucumberTest;

public class PageInjector extends FluentCucumberTest {

    @Page
    public WebStandardAction webStandardAction;

}
