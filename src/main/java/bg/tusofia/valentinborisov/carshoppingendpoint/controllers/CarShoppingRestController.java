package bg.tusofia.valentinborisov.carshoppingendpoint.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;
import bg.tusofia.valentinborisov.carshoppingendpoint.repositories.BrandRepository;

@RestController
public class CarShoppingRestController {

	@Autowired
	private BrandRepository brandRepository;

	@GetMapping(path = "/test")
	public String getTest(@RequestParam("word") String word) {
		return "You typed " + word;
	}

	@GetMapping(path = "/countBrands")
	public String countBrands(@RequestParam("brandName") String brandName) {
		Brand b = new Brand();
		b.setName(brandName);

		brandRepository.save(b);
		return String.valueOf(brandRepository.count());
	}
}
