package vendingmachine.condiments;

import vendingmachine.beverages.Beverage;

public class Sugar extends CondimentDecorator {

  public Sugar(Beverage beverage) {
    this.beverage = beverage;
  }

  /**
   * Accessor method for the name of the beverage plus sugar added.
   *
   * @return the name of the beverage plus sugar added.
   */
  @Override
  public String getName() {
    return beverage.getName() + ", Sugar";
  }

  /**
   * Accessor method for the type of the beverage.
   *
   * @return the type of the beverage
   */
  @Override
  public String getType() {
    return beverage.getType();
  }
}
