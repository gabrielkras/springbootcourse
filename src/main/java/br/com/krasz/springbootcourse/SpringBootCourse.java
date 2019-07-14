package br.com.krasz.springbootcourse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.krasz.springbootcourse.entities.Address;
import br.com.krasz.springbootcourse.entities.Category;
import br.com.krasz.springbootcourse.entities.City;
import br.com.krasz.springbootcourse.entities.Client;
import br.com.krasz.springbootcourse.entities.Product;
import br.com.krasz.springbootcourse.entities.State;
import br.com.krasz.springbootcourse.entities.enums.ClientType;
import br.com.krasz.springbootcourse.repositories.AddressRepository;
import br.com.krasz.springbootcourse.repositories.CategoryRepository;
import br.com.krasz.springbootcourse.repositories.CityRepository;
import br.com.krasz.springbootcourse.repositories.ClientRepository;
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

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ClientRepository clientRepository;

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

		Client cli1 = new Client();
		cli1.setName("Maria Silva");
		cli1.setEmail("maria@gmail.com");
		cli1.setNationalIdentification("12345678911");
		cli1.setType(ClientType.PERSON);
		cli1.getPhoneNumbers().addAll(Arrays.asList("1533215285", "15997006464"));

		Address ad1 = new Address();
		ad1.setStreet("Rua Flores");
		ad1.setNumber("3000");
		ad1.setComplement("Apto B34");
		ad1.setNeiborhood("Jardim");
		ad1.setZipcode("18044000");
		ad1.setCity(ct1);
		ad1.setClient(cli1);

		Address ad2 = new Address();
		ad2.setStreet("Avenida Matos");
		ad2.setNumber("105");
		ad2.setComplement("Sala 800");
		ad2.setNeiborhood("Centro");
		ad2.setZipcode("38777012");
		ad2.setClient(cli1);
		ad2.setCity(ct2);

		cli1.getAddresses().addAll(Arrays.asList(ad1,ad2));

		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(ct1,ct2,ct3));
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(ad1,ad2));
	}

}
