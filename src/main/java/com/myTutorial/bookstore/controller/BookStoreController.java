package com.myTutorial.bookstore.controller;


import com.myTutorial.bookstore.dto.BookOrderRequest;
import com.myTutorial.bookstore.model.Order;
import com.myTutorial.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/bookstore")
public class BookStoreController {

    private final OrderService orderService;

    public BookStoreController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<String> bookStore(){
        return ResponseEntity.ok("Hello Spring For Book Store");
    }
    @PostMapping
    @GetMapping
    public ResponseEntity <Order> putAndOrder(@RequestBody BookOrderRequest bookOrderRequest){

        Order order=orderService.putAndOrder(bookOrderRequest.getBookIdList(),bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }

}
