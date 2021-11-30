package demo.publisher;

import demo.Config.ConfigClass ;
import demo.dto.Order;
import demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class MessagePublisher {
	
@Autowired
private RabbitTemplate template;



@GetMapping("/Welcome")
public String Welcome() {
	
	return "Welcome to Messaging with MQ !!" ;

	
}

@PostMapping("/Book")
public String bookOrder(@RequestBody Order order ) {
	
	
	 order.setOrderId(UUID.randomUUID().toString());
     //restaurantservice
     //payment service
	 
	 OrderStatus s = new OrderStatus();
     s.setOrder(order);
     s.setStatus("done");
     s.setMessage("Going on !");
     
     template.convertAndSend(ConfigClass.EXCHANGE, ConfigClass.ROUTING_KEY,"going on ");
     return "Success !!";
 }
}




	
	
	
	
