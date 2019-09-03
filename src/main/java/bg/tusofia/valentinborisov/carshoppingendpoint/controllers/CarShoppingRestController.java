package bg.tusofia.valentinborisov.carshoppingendpoint.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarShoppingRestController {

	@GetMapping(path = "/test")
	public String getTest(@RequestParam("word") String word) {
		return "Acho, You typed " + word + " in the query string";
	}
}
