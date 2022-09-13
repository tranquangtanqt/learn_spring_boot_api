package com.learn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.api.entities.Customer;
import com.learn.api.entities.Product;
import com.learn.api.entities.Todo;
import com.learn.api.entities.TodoDetail;
import com.learn.api.repositories.ICustomerRepository;
import com.learn.api.repositories.IProductRepository;
import com.learn.api.repositories.ITodoDetailRepository;
import com.learn.api.repositories.ITodoRepository;

@SpringBootApplication
public class LearnSpringBootApiApplication implements CommandLineRunner {

	@Autowired
	ITodoRepository todoRepository;

	@Autowired
	ITodoDetailRepository todoDetailRepository;

	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBootApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		initTodo();
//		initCustomer();
//		initProduct();
	}

	private void initTodo() {
		// insert data t_todo
		Todo todo1 = new Todo();
		todo1.setId(new Long(1));
		todo1.setName("Java");
		todo1.setSortOrder(new Long(1));
		todoRepository.save(todo1);

		Todo todo2 = new Todo();
		todo2.setId(new Long(2));
		todo2.setName("C#");
		todo2.setSortOrder(new Long(2));
		todoRepository.save(todo2);
		// insert data t_tododetail
		TodoDetail todoDetail1 = new TodoDetail();
		todoDetail1.setId(new Long(1));
		todoDetail1.setName("Task 1");
		todoDetail1.setSortOrder(new Long(1));
		todoDetail1.setTodo(todo1);
		todoDetailRepository.save(todoDetail1);

		TodoDetail todoDetail2 = new TodoDetail();
		todoDetail2.setId(new Long(2));
		todoDetail2.setName("Task 2");
		todoDetail2.setSortOrder(new Long(2));
		todoDetail2.setTodo(todo1);
		todoDetailRepository.save(todoDetail2);

		TodoDetail todoDetail3 = new TodoDetail();
		todoDetail3.setId(new Long(3));
		todoDetail3.setName("Task 3");
		todoDetail3.setSortOrder(new Long(3));
		todoDetail3.setTodo(todo1);
		todoDetailRepository.save(todoDetail3);
	}

	private void initCustomer() {
		// insert data p_custommer
		Customer customer1 = new Customer();
		customer1.setId(new Long(1));
		customer1.setName("Duyên Hải");
		customer1.setEmail("");
		customer1.setAddress("");
		customer1.setPhoneNumber("");
		customer1.setNotes("");
		customerRepository.save(customer1);

		Customer customer2 = new Customer();
		customer2.setId(new Long(2));
		customer2.setName("Khách lẻ");
		customer2.setEmail("");
		customer2.setAddress("");
		customer2.setPhoneNumber("");
		customer2.setNotes("");
		customerRepository.save(customer2);
	}

	private void initProduct() {
		Product product1 = new Product();
		product1.setId(new Long(1));
		product1.setName("30x30 (24 màu)");
		product1.setEntryPrice(1);
		product1.setWholesalePrice(1);
		product1.setRetailPrice(1);
		product1.setQuantityInventory(100);
		product1.setQuantitySold(0);
		product1.setUnit("Cái");
		product1.setNote("");
		productRepository.save(product1);

		Product product2 = new Product();
		product2.setId(new Long(2));
		product2.setName("30x30 (36 màu)");
		product2.setEntryPrice(2);
		product2.setWholesalePrice(2);
		product2.setRetailPrice(2);
		product2.setQuantityInventory(100);
		product2.setQuantitySold(0);
		product2.setUnit("Cái");
		product2.setNote("");
		productRepository.save(product2);

		Product product3 = new Product();
		product3.setId(new Long(3));
		product3.setName("30x40 (24 màu)");
		product3.setEntryPrice(3);
		product3.setWholesalePrice(3);
		product3.setRetailPrice(3);
		product3.setQuantityInventory(100);
		product3.setQuantitySold(0);
		product3.setUnit("Cái");
		product3.setNote("");
		productRepository.save(product3);

		Product product4 = new Product();
		product4.setId(new Long(4));
		product4.setName("30x40 (36 màu)");
		product4.setEntryPrice(4);
		product4.setWholesalePrice(4);
		product4.setRetailPrice(4);
		product4.setQuantityInventory(100);
		product4.setQuantitySold(0);
		product4.setUnit("Cái");
		product4.setNote("");
		productRepository.save(product4);

		Product product5 = new Product();
		product5.setId(new Long(5));
		product5.setName("30x50 (24 màu)");
		product5.setEntryPrice(5);
		product5.setWholesalePrice(5);
		product5.setRetailPrice(5);
		product5.setQuantityInventory(100);
		product5.setQuantitySold(0);
		product5.setUnit("Cái");
		product5.setNote("");
		productRepository.save(product5);

		Product product6 = new Product();
		product6.setId(new Long(6));
		product6.setName("30x50 (36 màu)");
		product6.setEntryPrice(6);
		product6.setWholesalePrice(6);
		product6.setRetailPrice(6);
		product6.setQuantityInventory(100);
		product6.setQuantitySold(0);
		product6.setUnit("Cái");
		product6.setNote("");
		productRepository.save(product6);

		Product product7 = new Product();
		product7.setId(new Long(7));
		product7.setName("40x40 (24 màu)");
		product7.setEntryPrice(7);
		product7.setWholesalePrice(7);
		product7.setRetailPrice(7);
		product7.setQuantityInventory(100);
		product7.setQuantitySold(0);
		product7.setUnit("Cái");
		product7.setNote("");
		productRepository.save(product7);

		Product product8 = new Product();
		product8.setId(new Long(8));
		product8.setName("40x40 (36 màu)");
		product8.setEntryPrice(8);
		product8.setWholesalePrice(8);
		product8.setRetailPrice(8);
		product8.setQuantityInventory(100);
		product8.setQuantitySold(0);
		product8.setUnit("Cái");
		product8.setNote("");
		productRepository.save(product8);

		Product product9 = new Product();
		product9.setId(new Long(9));
		product9.setName("40x50 (24 màu)");
		product9.setEntryPrice(9);
		product9.setWholesalePrice(9);
		product9.setRetailPrice(9);
		product9.setQuantityInventory(100);
		product9.setQuantitySold(0);
		product9.setUnit("Cái");
		product9.setNote("");
		productRepository.save(product9);

		Product product10 = new Product();
		product10.setId(new Long(10));
		product10.setName("40x50 (36 màu)");
		product10.setEntryPrice(10);
		product10.setWholesalePrice(10);
		product10.setRetailPrice(10);
		product10.setQuantityInventory(100);
		product10.setQuantitySold(0);
		product10.setUnit("Cái");
		product10.setNote("");
		productRepository.save(product10);

		Product product11 = new Product();
		product11.setId(new Long(11));
		product11.setName("40x50 (42 màu)");
		product11.setEntryPrice(11);
		product11.setWholesalePrice(11);
		product11.setRetailPrice(11);
		product11.setQuantityInventory(100);
		product11.setQuantitySold(0);
		product11.setUnit("Cái");
		product11.setNote("");
		productRepository.save(product11);

		Product product12 = new Product();
		product12.setId(new Long(12));
		product12.setName("40x50 (48 màu)");
		product12.setEntryPrice(12);
		product12.setWholesalePrice(12);
		product12.setRetailPrice(12);
		product12.setQuantityInventory(100);
		product12.setQuantitySold(0);
		product12.setUnit("Cái");
		product12.setNote("");
		productRepository.save(product12);
	}
}
