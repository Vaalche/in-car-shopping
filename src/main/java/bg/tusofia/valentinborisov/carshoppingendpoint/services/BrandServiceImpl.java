package bg.tusofia.valentinborisov.carshoppingendpoint.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.tusofia.valentinborisov.carshoppingendpoint.dto.BrandDTO;
import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;
import bg.tusofia.valentinborisov.carshoppingendpoint.repositories.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<Brand> getBrands() {

		return brandRepository.findAll();
	}

	@Override
	public List<Long> createBrands(List<BrandDTO> brandsDto) {
		List<Brand> brands = new ArrayList<>();
		List<Long> ids = new ArrayList<>();
		brandsDto.forEach(brandDto -> {
			Brand brand = new Brand();
			brand.setName(brandDto.getName());
			brands.add(brand);
		});

		brandRepository.saveAll(brands).forEach(b -> ids.add(b.getId()));
		return ids;
	}
}
