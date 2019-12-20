package vendingmachine.machine;

import vendingmachine.beverages.Beverage;

public class DeliverBeverageState implements MachineState {
  private HotBeverageMachine hotBeverageMachine;

  /**
   * Initialize DeliverBeverageState.
   *
   * @param hotBeverageMachine an instance of the vending machine.
   */
  public DeliverBeverageState(HotBeverageMachine hotBeverageMachine) {
    this.hotBeverageMachine = hotBeverageMachine;
  }

  /**
   * Process the beverage.
   *
   * @param beverage the beverage to process.
   * @return a description of the beverage that was processed.
   */
  public String process(Beverage beverage) {
    System.out.println("Hot Beverage: " + beverage.getType() + ", " + beverage.getName());
    hotBeverageMachine.setState(hotBeverageMachine.getNoPaymentState());
    return "Hot Beverage: " + beverage.getType() + ", " + beverage.getName();
  }

  /**
   * A string description of the state. (for testing)
   *
   * @return String description of the state.
   */
  @Override
  public String toString() {
    return "deliveryState";
  }
}
