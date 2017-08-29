package java.maven_jetty_test;

import maven_jetty_test.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResourceTest {

    @Mock
    Resource mResource;

    @Test
    public void calcOnline(){
        when(mResource.restHandler.winAction()).thenReturn("2+3");
        Resource mResourceSpy = spy(new Resource());
        assertEquals("Result = 6", mResourceSpy.calcOnline("+", "1", "5"));
//
//        System.out.println(mResourceSpy.method1());
//        verify(mResourceSpy).method2("Maria");
    }

    @Test
    public void app(){
//        Resource mResourceSpy = spy(new Resource());
//        SomeData someData = new SomeData("lalala");
//        mResourceSpy.foo(someData);
//
//        ArgumentCaptor<SomeData> argument = ArgumentCaptor.forClass(SomeData.class);
//        verify(mResourceSpy).foo(argument.capture());
//     //   verify(mResourceSpy).foo(someData);
//
//        String name = argument.getValue().getName();
//        System.out.println(name);

      //  assertEquals("lalala", argument.getValue().getName());
    }
}