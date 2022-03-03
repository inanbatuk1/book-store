package com.myTutorial.bookstore.service;

import com.myTutorial.bookstore.model.Book;
import com.myTutorial.bookstore.model.Order;

import com.myTutorial.bookstore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderService {


    private final Logger logger= (Logger) LoggerFactory.getLogger(OrderService.class);
    private final BookService bookService;
    private  OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public Order putAndOrder(List<Integer> bookIdList ,String userName){

        List <Optional<Book>> bookList= bookIdList.stream().map(bookService::findBookById)
                .collect(Collectors.toList());
        Double totaPrice = bookList.stream()
                .map(optinalBook -> optinalBook.map(Book::getPrice).orElse(0.00)).
                reduce(0.00,Double::sum);
        Order order =  Order.builder()
                .bookList(bookIdList)
                .totalPrice(totaPrice)
                .userName(userName).
                build();
        return orderRepository.save(order);
    }
}
