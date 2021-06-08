package Runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="featureseamil",glue= {"GmailTest"})
public class ComposeRunner {

}
