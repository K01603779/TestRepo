import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotImportantClassTest {
  private IDoSomething doSomething;

  @BeforeEach
  public void beforeEach() {
    doSomething = new NotImportantClass();
  }

  @Test
  public void testDoSomething() {
    Assertions.assertEquals("Doing something...", doSomething.doSomething());
  }

  @Test
  public void testFailingDoSomething() {
    Assertions.assertEquals("", doSomething.doSomething());
  }
}
