package com.musings.sdata.app;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.musings.sdata.entities.Book;
import com.musings.sdata.repository.ReadOnlyBookRepository;
import com.musings.sdata.repository.ReadOnlyRepository;
import com.musings.sdata.services.BookService;

public class Application {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		BookService bookService = context.getBean(BookService.class);
		Book book = new Book();
		book.setTitle("Kite Runner");
		book.setPublishDate(new Date());
		book.setPrice(new BigDecimal("30.0"));

		bookService.save(book);

		ReadOnlyRepository<Book, Long> repository = context.getBean(ReadOnlyBookRepository.class);

		repository.findAll();

		context.close();
	}

}
