import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  void addNumbers() {
    assertEquals(10, Calculator.add(5, 5));
  }

  @Test
  void subtractNumbers() {
    assertEquals(5, Calculator.sub(10, 5));
  }

  @Test
  void multiplyNumbers() {
    assertEquals(50, Calculator.mul(10, 5));
  }

  @Test
  void divideNumbers() {
    assertEquals(2, Calculator.div(10, 5));
  }

  @Test
  void modulusNumbers() {
    assertEquals(0, Calculator.mod(10, 5));
  }

  @Test
  void testMultiple(){
      assertEquals(0,Calculator.mod(Calculator.add(1,2),Calculator.sub(2,1)));
  }
}
