package bg.tusofia.valentinborisov.carshoppingendpoint.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.tusofia.valentinborisov.carshoppingendpoint.dto.ProductDTO;
import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Product;
import bg.tusofia.valentinborisov.carshoppingendpoint.repositories.BrandRepository;
import bg.tusofia.valentinborisov.carshoppingendpoint.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Long addProduct(ProductDTO productDto) {
		Product product = convertProductFromDto(productDto);
		return brandRepository.findByName(productDto.getBrand().getName()).map(brand -> {
			product.setBrand(brand);
			return productRepository.save(product);
		}).orElseThrow(RuntimeException::new).getId();
	}

	@Override
	public List<Long> addProductsList(List<ProductDTO> productDtos) {

		List<Product> products = new ArrayList<>();
		List<Long> ids = new ArrayList<>();
		productDtos.forEach(productDto -> brandRepository.findByName(productDto.getBrand().getName()).map(brand -> {
			Product product = convertProductFromDto(productDto);
			product.setBrand(brand);
			products.add(product);
			return product;
		}).orElseThrow(RuntimeException::new));

		productRepository.saveAll(products).forEach(p -> ids.add(p.getId()));
		return ids;
	}

	@Override
	public List<ProductDTO> getProductsByBrandName(String brandName) {

		List<ProductDTO> dtoList = new ArrayList<>();
		productRepository.findByBrand(brandRepository.findByName(brandName).get()).forEach(product -> {
			dtoList.add(new ProductDTO(product));
		});
		return dtoList;
	}

	private Product convertProductFromDto(ProductDTO dto) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setKeywords(dto.getKeywords());
		product.setBlobImg(ArrayUtils.toObject(Base64.decodeBase64(dto.getEncodedImg())));
		return product;
	}
}
