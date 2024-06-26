package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

public class Cucumber_Tests {
    private int a;
    private int b;
    private int sum;
    private AdditionInt add;

    @Given("I have two integers {int} and {int}")
    public void i_have_two_integers_and(int a, int b) {
        this.a = a;
        this.b = b;
        this.add = new AdditionInt();
    }

    @When("I add them using AdditionInt")
    public void i_add_them_using_AdditionInt() {
        this.sum = add.add(a, b);
    }

    @Then("The result should be {int}")
    public void the_result_should_be(int expectedSum) {
        assertEquals(expectedSum, sum);
    }

}
