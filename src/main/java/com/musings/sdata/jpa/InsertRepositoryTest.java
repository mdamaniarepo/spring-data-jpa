package com.musings.sdata.jpa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.musings.sdata.entities.Book;
import com.musings.sdata.repository.BookRepository;

public class InsertRepositoryTest {

	public static void main(String[] args) {

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
			BookRepository repository = context.getBean(BookRepository.class);

			// Insert 1 entity
			Book book = repository.save(create());
			System.out.printf(" ########################################### INSERT: %s", book);

			List<Book> books = repository.save(create(5));
			System.out.println("INSERT All #######################################");
			printList(books, System.out::println);
		}

	}

	private static String[] titles = { "Don Quixote", "1984", "Adventures of Huckleberry Finn", "Ulysses",
			"The Great Gatsby", "On The Road", "Catch 22", "To Kill A Mockingbird", "Brave New World",
			"The Scarlet Letter" };

	public static List<Book> create(int size) {
		List<Book> books = new LinkedList<Book>();
		for (int x = 0; x < size; x++) {
			books.add(create());
		}
		return books;
	}

	public static Book create() {
		Book book = new Book();
		book.setTitle(titles[ThreadLocalRandom.current().nextInt(1, titles.length)]);
		book.setPublishDate(new Date());
		book.setPageCount(150);
		book.setPrice(new BigDecimal("15.00"));
		return book;
	}

	public static <T> void printList(List<T> ts, Consumer<T> consumer) {
		for (T t : ts) {
			consumer.accept(t);
		}
	}

}
