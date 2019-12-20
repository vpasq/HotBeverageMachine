![Readme image](readme.png)

# HotBeverageMachine ([UML Diagram](https://github.com/vpasq/HotBeverageMachine/blob/master/UML_HotBeverageMachine.pdf)) 
In the first version of HotBeverageMachine I used the Strategy Design Pattern, and since then I have decided to 
restructure it with the following refactoring:
- Replace Constructors With Creation Methods
- Replace State-Altering Conditionals with State
- Collapse Hierarchy
- Move Embellishment to Decorator

# Replace Constructors With Creation Methods
The client that calls the constructor is in the TestHotBeverageMachine class.
I replaced the constructor with an intention-revealing Creation Method, and I used the 
following refactorings to accomplish this task:
- Apply Extract Method [F] on the constructor call in the TestHotBeverageMachine class to produce 
a public, static creation method.
- Move Method [F] on this new method to move the extracted creation method to the 
HotBeverageMachine class.
- Updated all callers of the constructor.

# Collapse Hierarchy
In the first version I used different classes for all the coffee and tea beverages. In this
new version I am using only one class for coffee, and only one class for tea. I used the 
following refactorings to accomplish this task:
- Pull Up Field [F] from all Beverage subclasses.
- Pull Up Method [F] from all Beverage subclasses.

# Replace State-Altering Conditionals with State
I had initially used the Strategy Pattern with enums. However, I have since decided
that refactoring to a State Pattern with concrete state objects would be more of an appropriate 
design for this application, and I used the following refactorings to accomplish this task:
- Replace Type Code with Class (but I first replaced the enums with string fields in the 
HotBeverageMachine context class before applying this refactoring to the type code in this context 
class). Also, I realize that an enum can be used with the State Pattern but I just decided 
against it.
- Extract SubClass [F] to produce the concrete MachineState classes.
- Updated delegation methods in the HotBeverageMachine context class

# Move Embellishment to Decorator
I implemented a new pattern, The Decorator Pattern, in this second version of HotBeverageMachine.
I initially worked the feature request of adding condiments into the Strategy Pattern classes.
However, I have since decided that the Decorator Pattern would be more appropriate.

# Install and run jUnit tests
```bash
1. Clone this repository
2. mvn clean compile test

```

# Version
1.0.0

# License

The MIT License (MIT)

Copyright (c) 2019 Vincent Pasquariello

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


