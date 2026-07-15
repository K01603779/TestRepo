import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  void addNumbers() {
    assertEquals(10, Calculator.add(5, 5));
  }

  @Test
  void subtractNumbers(){
    assertEquals(10,Calculator.sub(10,5));}

  @Test
  void multiplyNumbers(){
    assertEquals(10,Calculator.mul(10,5));}
}
