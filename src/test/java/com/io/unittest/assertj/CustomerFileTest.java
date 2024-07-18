package com.io.unittest.assertj;

import com.io.customer.exception.MailServerUnavailableException;
import static org.assertj.core.api.Assertions.*;

import java.io.File;

import org.junit.Test;

public class CustomerFileTest {

	@Test
	public void testFiles() throws Exception{
		
		File file = new File("/User Information/test.txt");
		
		assertThat(file)
			.exists()
			.canRead()
			.canWrite()
			.hasExtension("txt")
			.hasName("test.txt");
			
		assertThat(contentOf(file))
			.startsWith("Lorem");
	}
	@Test
    public void testException() throws Exception {

        Exception exception = new MailServerUnavailableException("this is a test");

        assertThat(exception)
                .hasMessage("this is a test")
                .isInstanceOf(MailServerUnavailableException.class)
                .hasMessageContaining("is a");


    }
}
