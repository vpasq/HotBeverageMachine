package vendingmachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import vendingmachine.beverages.Beverage;
import vendingmachine.beverages.Coffee;
import vendingmachine.beverages.Tea;
import vendingmachine.machine.HotBeverageMachine;
import org.junit.Before;
import org.junit.Test;

public class TestHotBeverageMachine {
  private HotBeverageMachine hotBeverageMachine;
  private Beverage americano;
  private Beverage espresso;
  private Beverage latteMacchiato;
  private Beverage blackTea;
  private Beverage greenTea;
  private Beverage yellowTea;

  @Before
  public void setup() {
    americano = new Coffee("Americano");
    espresso = new Coffee("Espresso");
    latteMacchiato = new Coffee("Latte Macchiato");
    blackTea = new Tea("Black Tea");
    greenTea = new Tea("Green Tea");
    yellowTea = new Tea("Yellow Tea");
  }

  @Test
  public void orderAmericanoWithTooMuchMilk() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(americano);

    // try to add 4 units of milk
    try {
      hotBeverageMachine.addMilk(4);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      System.out.println("numUnits > 3 : Too many units of milk requested");
      assertTrue(message.contains("numUnits > 3 : Too many units of milk requested"));
    }
  }

  @Test
  public void orderAmericanoWithTooMuchSugar() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(americano);

    // try to add 4 units of sugar
    try {
      hotBeverageMachine.addSugar(4);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException e) {
      String message = e.getMessage();
      System.out.println("numUnits > 3 : Too many units of sugar  requested");
      assertTrue(message.contains("numUnits > 3 : Too many units of sugar requested"));
    }
  }

  @Test
  public void orderEspressoWithNoMilkAndSugar() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(espresso);
    String expected = "Hot Beverage: Coffee, Espresso";

    // exercise
    String actual = hotBeverageMachine.brewBeverage();

    // verify
    assertEquals(expected, actual);

    // teardown
    hotBeverageMachine = null;
  }

  @Test
  public void orderAmericanoWithOneMilk() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(americano);
    hotBeverageMachine.addMilk(1);
    String expected = "Hot Beverage: Coffee, Americano, Milk";

    // exercise
    String actual = hotBeverageMachine.brewBeverage();

    // verify
    assertEquals(expected, actual);

    // teardown
    hotBeverageMachine = null;
  }

  @Test
  public void orderLatteMacchiatoWithOneSugar() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(latteMacchiato);
    hotBeverageMachine.addSugar(1);
    String expected = "Hot Beverage: Coffee, Latte Macchiato, Sugar";

    // exercise
    String actual = hotBeverageMachine.brewBeverage();

    // verify
    assertEquals(expected, actual);

    // teardown
    hotBeverageMachine = null;
  }

  @Test
  public void orderBlackTeaWithOneMilkAndOneSugar() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(blackTea);
    hotBeverageMachine.addMilk(1);
    hotBeverageMachine.addSugar(1);
    String expected = "Hot Beverage: Tea, Black Tea, Milk, Sugar";

    // exercise
    String actual = hotBeverageMachine.brewBeverage();

    // verify
    assertEquals(expected, actual);

    // teardown
    hotBeverageMachine = null;
  }

  @Test
  public void orderGreenTeaWithTwoMilksAndTwoSugars() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(greenTea);
    hotBeverageMachine.addMilk(2);
    hotBeverageMachine.addSugar(2);
    String expected = "Hot Beverage: Tea, Green Tea, Milk, Milk, Sugar, Sugar";

    // exercise
    String actual = hotBeverageMachine.brewBeverage();

    // verify
    assertEquals(expected, actual);

    // teardown
    hotBeverageMachine = null;
  }

  @Test
  public void orderYellowTeaWithTwoMilksAndOneSugar() {
    // setup
    hotBeverageMachine = HotBeverageMachine.create();
    hotBeverageMachine.selectBeverage(yellowTea);
    hotBeverageMachine.addMilk(2);
    hotBeverageMachine.addSugar(1);
    String expected = "Hot Beverage: Tea, Yellow Tea, Milk, Milk, Sugar";

    // exercise
    String actual = hotBeverageMachine.brewBeverage();

    // verify
    assertEquals(expected, actual);

    // teardown
    hotBeverageMachine = null;
  }



}