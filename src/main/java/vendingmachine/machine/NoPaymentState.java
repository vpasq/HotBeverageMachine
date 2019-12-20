package vendingmachine.machine;

import vendingmachine.beverages.Beverage;

public class NoPaymentState implements MachineState {

  /**
   * Process the beverage.
   *
   * @param beverage the beverage to process.
   * @return a description of the state.
   */
  public String process(Beverage beverage) {
    System.out.println("Please make your selection.");
    return "Please make your selection.";
  }

  /**
   * A string description of the state. (for testing)
   *
   * @return String description of the state.
   */
  @Override
  public String toString() {
    return "noPaymentState";
  }
}
