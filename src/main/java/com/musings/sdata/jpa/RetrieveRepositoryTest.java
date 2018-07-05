package com.musings.sdata.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.musings.sdata.entities.Book;
import com.musings.sdata.repository.BookRepository;

public class RetrieveRepositoryTest {

	@SuppressWarnings("serial")
	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {

			BookRepository bookRepository = context.getBean(BookRepository.class);

			Book book = bookRepository.findOne(1L);
			System.out.println("###################### Retrieve ################################");
			System.out.println("RETRIVED : " + book.toString());

			List<Book> bookList = bookRepository.findAll();
			System.out.println("###################### Retrieve ################################");
			printList(bookList, System.out::println);
			
			bookList = bookRepository.findAll(new ArrayList<Long>() {{
				add(1L);
				add(2L);
				add(7L);
			}});
			System.out.println("###################### Retrieve ################################");
			printList(bookList, System.out::println);
			
		}

	}

	public static <T> void printList(List<T> ts, Consumer<T> consumer) {
		for (T t : ts) {
			consumer.accept(t);
		}
	}

}
