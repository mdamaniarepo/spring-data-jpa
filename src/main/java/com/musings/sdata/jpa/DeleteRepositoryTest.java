package com.musings.sdata.jpa;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.musings.sdata.repository.BookRepository;

public class DeleteRepositoryTest {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")) {
			BookRepository repository = context.getBean(BookRepository.class);
			
			repository.delete(repository.findOne(1L));
			
			repository.delete(2L);
			
			repository.delete(repository.findAll(new ArrayList<Long>() {{
				add(3L);
				add(4L);
			}}));
			
			repository.deleteInBatch(repository.findAll(new ArrayList<Long>() {{
				add(6L);
				add(7L);
			}}));
			
			repository.deleteAllInBatch();
			
			// first select and then delete all one by one will have performance issues.
			repository.deleteAll();

		}
	}

}
