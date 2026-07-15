import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  void addNumbers() {
    assertEquals(10, Calculator.add(5, 5));
  }
}
