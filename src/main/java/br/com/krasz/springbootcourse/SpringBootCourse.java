package br.com.krasz.springbootcourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.krasz.springbootcourse.entities.Category;
import br.com.krasz.springbootcourse.entities.Product;
import br.com.krasz.springbootcourse.repositories.CategoryRepository;
import br.com.krasz.springbootcourse.repositories.ProductRepository;

@SpringBootApplication
public class SpringBootCourse implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCourse.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category();
		cat1.setName("Informatic");

		Category cat2 = new Category();
		cat2.setName("Office");

		Product p1 = new Product();
		p1.setName("Computer");
		p1.setPrice(2000.00);

		Product p2 = new Product();
		p2.setName("Printer");
		p2.setPrice(800.00);

		Product p3 = new Product();
		p3.setName("Mouse");
		p3.setPrice(80.00);

		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
