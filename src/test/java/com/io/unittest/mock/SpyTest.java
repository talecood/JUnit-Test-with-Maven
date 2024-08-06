package com.io.unittest.mock;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import org.junit.Test;

public class SpyTest {

	@Test
	public void testSpy()throws Exception{
		
		IDummyCustomerService service = spy(new DummyCustomerService());
		doNothing().when(service).addCustomer(eq("istanbul")); // Only for istanbul
	//	doThrow(new IllegalArgumentException()).when(service).removeCustomer(anyString());
		
		service.addCustomer("istanbul");
		service.removeCustomer("*****");
		
		doNothing().when(service).removeCustomer("istanbul1");
        doNothing().when(service).removeCustomer("istanbul2");
//        doCallRealMethod().when(service).removeCustomer("istanbul3");  //The real method called bcs of default.

        service.removeCustomer("istanbul1");
        service.removeCustomer("istanbul2");
        service.removeCustomer("istanbul3");  //Expect to Print 
	}
}
