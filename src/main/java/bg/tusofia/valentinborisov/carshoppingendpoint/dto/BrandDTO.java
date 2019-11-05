package bg.tusofia.valentinborisov.carshoppingendpoint.dto;

import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BrandDTO {

	private String name;

	public BrandDTO() {
	};

	public BrandDTO(Brand brand) {
		this(brand.getName());
	}
}
