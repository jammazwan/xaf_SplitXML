package jammazwan.xaf;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;


public class XafRoutes extends RouteBuilder {

    
    

    @Override
    public void configure() throws Exception {
        from("direct:xaf")
            .process(new Processor() {
                public void process(Exchange exchange) throws Exception {
                    String text = exchange.getIn().getBody(String.class);
                    String newAnswer = "My " + text;
                    exchange.getOut().setBody(newAnswer);
                }
            });
    }
}
