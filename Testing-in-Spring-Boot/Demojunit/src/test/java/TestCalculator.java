import com.sagar.Demojunit.Calculator;
import com.sagar.Demojunit.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestCalculator {

    Calculator cal = null;

    CalculatorService calculatorService = Mockito.mock(CalculatorService.class);

    @BeforeEach
    public void setup() {
        cal = new Calculator(calculatorService);
    }

    @Test
    public void perform() {
        when(calculatorService.add(3, 2)).thenReturn(5);
        assertEquals(15, cal.perform(3, 2));
        verify(calculatorService).add(3,2);
    }
}