package maven_jetty_test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestCalculatorUnitTest {

    @Mock
    RestHandler restHandler;

    @Test
    public void plusRandom() {
        ArgumentCaptor<String> url = ArgumentCaptor.forClass(String.class);
        when(restHandler.getRandom(url.capture())).thenReturn("1").thenReturn("2").thenReturn("3");
        RestCalculatorImpl restCalculator = new RestCalculatorImpl(url.capture(), restHandler);

        Assert.assertEquals(8, restCalculator.plusRandom(7));
        Assert.assertEquals(10, restCalculator.plusRandom(8));
        Assert.assertEquals(12, restCalculator.plusRandom(9));

    }
}
