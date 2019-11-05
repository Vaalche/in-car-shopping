package bg.tusofia.valentinborisov.carshoppingendpoint.services;

import java.util.List;

import bg.tusofia.valentinborisov.carshoppingendpoint.dto.ProductDTO;

public interface ProductService {

	Long addProduct(ProductDTO productDto);

	List<Long> addProductsList(List<ProductDTO> productDtos);

	List<ProductDTO> getProductsByBrandName(String brandName);
}
