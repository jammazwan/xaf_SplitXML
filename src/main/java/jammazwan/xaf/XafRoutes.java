package jammazwan.xaf;

import org.apache.camel.builder.RouteBuilder;

public class XafRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=menu.xml")
		.split(xpath("/menu/food")).to("mock:assert1");
		
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=catalog.xml")
		.split(xpath("/CATALOG/CD/TITLE")).to("mock:assert2");
		
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=manager.xml")
		.split(xpath("//manager[@city]")).to("mock:assert3");
		
		from("file://../jammazwan.shared/src/main/resources/data/xml/?noop=true&fileName=shop.xml")
		.split(xpath("//*/employees/city")).log("${body}").to("mock:assert4");
	}
}
