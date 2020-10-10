package c1812m.happyfeet.controller;

import c1812m.happyfeet.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

}
