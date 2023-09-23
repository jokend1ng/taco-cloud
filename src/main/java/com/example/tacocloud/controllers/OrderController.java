package com.example.tacocloud.controllers;

import com.example.tacocloud.model.TacoOrder;
import com.example.tacocloud.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private OrderRepository orderRepos;

    public OrderController(OrderRepository orderRepos) {
        this.orderRepos = orderRepos;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
    @PostMapping()
    public String processOrder(@Valid TacoOrder order, Errors errors, SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }

        orderRepos.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
