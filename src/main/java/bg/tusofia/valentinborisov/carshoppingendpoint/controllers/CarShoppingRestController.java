package bg.tusofia.valentinborisov.carshoppingendpoint.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bg.tusofia.valentinborisov.carshoppingendpoint.dto.BrandDTO;
import bg.tusofia.valentinborisov.carshoppingendpoint.dto.ProductDTO;
import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;
import bg.tusofia.valentinborisov.carshoppingendpoint.services.BrandService;
import bg.tusofia.valentinborisov.carshoppingendpoint.services.ProductService;

@RestController
public class CarShoppingRestController {

	@Autowired
	private BrandService brandService;

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/getBrands")
	public List<Brand> getBrands() {
		return brandService.getBrands();
	}

	@PostMapping("/addBrands")
	public List<Long> createBrands(@Valid @RequestBody List<BrandDTO> brandsDto) {
		return this.brandService.createBrands(brandsDto);
	}

	@PostMapping("/addProduct")
	public Long addProduct(@Valid @RequestBody ProductDTO productDto) {
		return this.productService.addProduct(productDto);
	}

	@PostMapping("/addProductsList")
	public List<Long> addProductsList(@Valid @RequestBody List<ProductDTO> productDtos) {

		return this.productService.addProductsList(productDtos);
	}

	@GetMapping("/getProductsByBrandName/{brandName}")
	public List<ProductDTO> getProductsByBrandName(@PathVariable String brandName) {
		return this.productService.getProductsByBrandName(brandName);
	}
}
