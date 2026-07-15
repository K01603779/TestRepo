
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculatorTest {

    @Test
    void addNumbers(){
        assertEquals(10, Calculator.add(5, 5));
    }
}
