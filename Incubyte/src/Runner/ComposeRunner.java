package Runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features="featureseamil",glue= {"Gmailtest1"})
public class ComposeRunner {

}
