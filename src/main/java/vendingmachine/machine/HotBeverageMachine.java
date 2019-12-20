package vendingmachine.machine;

import vendingmachine.beverages.Beverage;
import vendingmachine.condiments.Milk;
import vendingmachine.condiments.Sugar;

public class HotBeverageMachine {

  private Beverage beverage;
  private MachineState noPaymentState;
  private MachineState brewingState;
  private MachineState deliveryState;
  private MachineState currentState;

  /**
   * Initialize state and prompt user.
   *
   * @postcondition User prompted and HotBeverageMachine placed into initial state.
   */
  public HotBeverageMachine() {
    noPaymentState = new NoPaymentState();
    brewingState = new BrewingState(this);
    deliveryState = new DeliverBeverageState(this);
    currentState = noPaymentState;
    System.out.println("Vending state: " + currentState);
    System.out.println("Please enter beverage and number of units of each condiment:");
  }

  /**
   * Static Factory Method.
   *
   * @return HotBeverageMachine
   */
  public static HotBeverageMachine create() {
    return new HotBeverageMachine();
  }

  /**
   * No Payment State.
   *
   * @return the noPaymentState
   */
  public MachineState getNoPaymentState() {
    return noPaymentState;
  }

  /**
   * Delivery State.
   *
   * @return the deliveryState
   */
  public MachineState getDeliveryState() {
    return deliveryState;
  }

  /**
   * Modifier method to set state.
   *
   * @param state the state
   */
  public void setState(MachineState state) {
    this.currentState = state;
  }

  /**
   * Select Beverage.
   *
   * @param beverage the ordered beverage.
   */
  public void selectBeverage(Beverage beverage) {
    setBeverage(beverage);
    setState(brewingState);
  }

  /**
   * Concrete Decorator method to add milk.
   *
   * @param numUnits number of units to add.
   */
  public void addMilk(int numUnits) {
    if (numUnits > 3) {
      throw new IllegalArgumentException("numUnits > 3 : Too many units of milk requested");
    }
    if (numUnits > 0) {
      for (int i = 0; i < numUnits; i++) {
        beverage = new Milk(beverage);
      }
    }
  }

  /**
   * Concrete Decorator method to add sugar.
   *
   * @param numUnits number of units to add.
   */
  public void addSugar(int numUnits) {
    if (numUnits > 3) {
      throw new IllegalArgumentException("numUnits > 3 : Too many units of sugar requested");
    }
    if (numUnits > 0) {
      for (int i = 0; i < numUnits; i++) {
        beverage = new Sugar(beverage);
      }
    }
  }

  /**
   * Modifier method that sets the beverage field.
   *
   * @param beverage the selected beverage.
   * @postcondition the beverage field has been set.
   */
  private void setBeverage(Beverage beverage) {
    this.beverage = beverage;
  }

  /**
   * Brew the beverage.
   *
   * @return true if brew is successful, false otherwise.
   */
  public String brewBeverage() {
    currentState.process(beverage);
    return deliverBeverage();
  }

  /**
   * Deliver(vend) the beverage from the vending machine.
   *
   * @postcondion the beverage was delivered from the vending machine
   *              to the customer.
   */
  private String deliverBeverage() {
    String result = currentState.process(beverage);
    System.out.println("\nVending state: " + currentState);
    System.out.println("Please enter beverage and number of units of each condiment:");
    return result;
  }
}

