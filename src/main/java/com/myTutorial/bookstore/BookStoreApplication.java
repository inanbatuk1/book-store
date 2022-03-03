package com.myTutorial.bookstore;

import com.myTutorial.bookstore.model.Book;
import com.myTutorial.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public BookStoreApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = Book.builder()
				.name("Yuzuklerin Efendisi")
				.author("J.R.R Tolkier")
				.price(10.0)
				.stock(15)
				.build();
		Book book2 = Book.builder()
				.name("Harry Potter")
				.author("Unknow")
				.price(12.0)
				.stock(13)
				.build();
		Book book3 = Book.builder()
				.name("Şeker Portakalı")
				.author("Ss.xx")
				.price(123.0)
				.stock(13)
				.build();
		bookRepository.saveAll(Arrays.asList(book1,book2,book3));
	}
}
