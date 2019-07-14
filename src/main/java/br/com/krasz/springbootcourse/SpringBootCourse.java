package br.com.krasz.springbootcourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.krasz.springbootcourse.entities.Category;
import br.com.krasz.springbootcourse.entities.City;
import br.com.krasz.springbootcourse.entities.Product;
import br.com.krasz.springbootcourse.entities.State;
import br.com.krasz.springbootcourse.repositories.CategoryRepository;
import br.com.krasz.springbootcourse.repositories.CityRepository;
import br.com.krasz.springbootcourse.repositories.ProductRepository;
import br.com.krasz.springbootcourse.repositories.StateRepository;

@SpringBootApplication
public class SpringBootCourse implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

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

		State st1 = new State();
		st1.setName("Minas Gerais");
		st1.setInitials("MG");

		State st2 = new State();
		st2.setName("São Paulo");
		st2.setInitials("SP");

		City ct1 = new City();
		ct1.setName("Uberlandia");
		ct1.setState(st1);

		City ct2 = new City();
		ct2.setName("São Paulo");
		ct2.setState(st2);

		City ct3 = new City();
		ct3.setName("Campinas");
		ct3.setState(st2);

		st1.getCities().addAll(Arrays.asList(ct1));
		st2.getCities().addAll(Arrays.asList(ct2,ct3));

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(ct1,ct2,ct3));
	}

}
