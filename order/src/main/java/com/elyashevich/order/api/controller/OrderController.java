package com.elyashevich.order.api.controller;

import com.elyashevich.domain.dto.Order;
import com.elyashevich.domain.dto.OrderEvent;
import com.elyashevich.order.kafka.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody final Order order) {
        order.setOrderId(UUID.randomUUID().toString());

        var orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state.");
        orderEvent.setOrder(order);

        this.orderProducer.sendMessage(orderEvent);

        return "Order placed successfully...";
    }
}
