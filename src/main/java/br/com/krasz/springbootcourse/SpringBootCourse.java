package br.com.krasz.springbootcourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.krasz.springbootcourse.entities.Category;
import br.com.krasz.springbootcourse.repositories.CategoryRepository;

@SpringBootApplication
public class SpringBootCourse implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCourse.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category();
		cat1.setName("Informatic");

		Category cat2 = new Category();
		cat2.setName("Office");

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
