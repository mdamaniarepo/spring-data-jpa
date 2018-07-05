package com.musings.sdata.jpa;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.musings.sdata.entities.Book;
import com.musings.sdata.repository.BookRepository;

public class UpdateRepositoryTest {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
			
			BookRepository bookRepository = context.getBean(BookRepository.class);
			Book book = bookRepository.findOne(1L);
			System.out.println("######################### RETRIEVED ####################################### : " + book.toString());
			
			book.setId(200L);
			System.out.println("######################### UPDATING #######################################");
			bookRepository.save(book);

			System.out.println("************ Printing Book ****************** " + book.toString());
			
		}

	}

}
