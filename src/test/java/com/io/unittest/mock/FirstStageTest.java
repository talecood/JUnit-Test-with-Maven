package com.io.unittest.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class FirstStageTest {
	
	@Test
    public void testWhen() throws Exception {

        IDummyCustomerService service = mock(IDummyCustomerService.class);
        when(service.getCustomer(eq("istanbul"))).thenReturn("customerIstanbul"); //if the parameter is "ankara" it works

        String customer = service.getCustomer("istanbul");

        assertThat(customer).isEqualTo("customerIstanbul");

    }

    @Test
    public void testWhen2() throws Exception {

        IDummyCustomerService service = mock(IDummyCustomerService.class);
        when(service.getCustomer(eq("istanbul"))).thenThrow(new RuntimeException()); //if the parameter "ankara" throws an exception

        String customer = service.getCustomer("istanbul");

    }

    @Test
    public void testWhen3() throws Exception {

        //How to use void methods

        IDummyCustomerService service = mock(IDummyCustomerService.class);

        // Methods starts with "do"

        doNothing().when(service).addCustomer(anyString());
        doThrow(new RuntimeException()).when(service).addCustomer(anyString());


        //Same return-when can be use here.
        doReturn("ankara").when(service).getCustomer("istanbul");

    }
	
}
