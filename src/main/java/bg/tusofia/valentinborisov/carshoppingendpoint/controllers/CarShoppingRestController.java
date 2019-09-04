package bg.tusofia.valentinborisov.carshoppingendpoint.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;
import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Product;
import bg.tusofia.valentinborisov.carshoppingendpoint.repositories.BrandRepository;
import bg.tusofia.valentinborisov.carshoppingendpoint.repositories.ProductRepository;

@RestController
public class CarShoppingRestController {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(path = "/getBrands")
	public List<Brand> getBrands() {

		return brandRepository.findAll();
	}

	@PostMapping("/addBrands")
	public List<Brand> createBrand(@Valid @RequestBody List<Brand> brands) {
		return brandRepository.saveAll(brands);
	}

	@PostMapping("/addProduct")
	public Product addProduct(@Valid @RequestBody Product product) {
		return brandRepository.findByName(product.getBrand().getName()).map(brand -> {
			product.setBrand(brand);
			return productRepository.save(product);
		}).orElseThrow(RuntimeException::new);
	}

	@PostMapping("/addProductsList")
	public List<Product> addProductsList(@Valid @RequestBody List<Product> products) {

		products.forEach(product -> brandRepository.findByName(product.getBrand().getName()).map(brand -> {
			product.setBrand(brand);
			return product;
		}).orElseThrow(RuntimeException::new));

		return productRepository.saveAll(products);
	}
}
