package vendingmachine.machine;

import vendingmachine.beverages.Beverage;

public class BrewingState implements MachineState {
  private HotBeverageMachine hotBeverageMachine;

  /**
   * Initialize BrewingState.
   *
   * @param hotBeverageMachine an instance of the vending machine.
   */
  public BrewingState(HotBeverageMachine hotBeverageMachine) {
    this.hotBeverageMachine = hotBeverageMachine;
  }

  /**
   * Process the beverage.
   *
   * @param beverage the beverage to process.
   * @return a description of the state.
   */
  public String process(Beverage beverage) {
    hotBeverageMachine.setState(hotBeverageMachine.getDeliveryState());
    return "Brewing";
  }

  /**
   * A string description of the state. (for testing)
   *
   * @return String description of the state.
   */
  @Override
  public String toString() {
    return "brewingState";
  }
}
