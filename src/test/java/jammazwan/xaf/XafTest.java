package jammazwan.xaf;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.util.HoldContextOpenUntilDone;

public class XafTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testXPath() throws Exception {
		MockEndpoint mock1 = getMockEndpoint("mock:assert1");
		mock1.expectedMessageCount(5);
		
		MockEndpoint mock2 = getMockEndpoint("mock:assert2");
		mock2.expectedMessageCount(26);
		
		MockEndpoint mock3 = getMockEndpoint("mock:assert3");
		mock3.expectedMessageCount(1);
		
		mock1.assertIsSatisfied();
		mock2.assertIsSatisfied();
		mock3.assertIsSatisfied();
	}


	@Test
	public void testTokenizeXML() throws Exception {
		
		MockEndpoint mock4 = getMockEndpoint("mock:assert4");
		mock4.expectedMessageCount(25);
		
		MockEndpoint mock5 = getMockEndpoint("mock:assert5");
		mock5.expectedMessageCount(1);

		mock4.assertIsSatisfied();
		mock5.assertIsSatisfied();
	}

}
