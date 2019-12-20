package vendingmachine.beverages;

public abstract class Beverage {
  String name;
  String type;

  /**
   * Accessor method for the name of the beverage.
   *
   * @return the name of the beverage.
   */
  public String getName() {
    return name;
  }

  /**
   * Accessor method for the type of the beverage.
   *
   * @return the type of the beverage.
   */
  public String getType() {
    return type;
  }

}
