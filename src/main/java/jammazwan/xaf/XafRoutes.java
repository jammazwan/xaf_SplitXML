package jammazwan.xaf;

import org.apache.camel.builder.RouteBuilder;

public class XafRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//XPATH
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=menu.xml")
		.split(xpath("/menu/food")).to("mock:assert1");
		
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=catalog.xml")
		.split(xpath("/CATALOG/CD/TITLE")).to("mock:assert2");
		
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=manager.xml")
		.split(xpath("//manager[@city]")).log("${body}").to("mock:assert3");
		
		//TOKENIZEXML
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=shop.xml")
		.split().tokenizeXML("city").to("mock:assert4");
		
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=employee.xml")
		.split().tokenizeXML("city").log("${body}").to("mock:assert5");
	}
}
