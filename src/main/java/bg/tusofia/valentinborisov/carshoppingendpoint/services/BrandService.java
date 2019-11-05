package bg.tusofia.valentinborisov.carshoppingendpoint.services;

import java.util.List;

import bg.tusofia.valentinborisov.carshoppingendpoint.dto.BrandDTO;
import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;

public interface BrandService {

	List<Brand> getBrands();

	List<Long> createBrands(List<BrandDTO> brandsDto);
}
