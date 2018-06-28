package test;


import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.*;

import codes.Calculator;

@RunWith(PowerMockRunner.class)
public class CalculatorTest {
	@Test
	@PrepareForTest(Calculator.class)
	
	public void testAdd() throws Exception
	{
		Calculator calculator =PowerMockito.mock( Calculator.class);
		
		when(calculator,"ad",2).thenReturn(2);
		
		when(calculator,"add",2,2).thenCallRealMethod();
		assertEquals("error",2, calculator.add(2,2));
	
	}
	
	
	@Test
	@PrepareForTest(Calculator.class)
	
	public void testC() throws Exception
	{
		//Calculator calculator =PowerMockito.mock( Calculator.class);
		Calculator calculator=new Calculator();
		//when(calculator,"ad",2).thenReturn(2);
		
	//	when(calculator,"add",2,2).thenCallRealMethod();
		assertEquals("error","4.0", calculator.calculate("2+2"));
	
	}
	
}
