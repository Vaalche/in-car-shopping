package bg.tusofia.valentinborisov.carshoppingendpoint.dto;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {

	private String name;
	private BrandDTO brand;
	private String keywords;
	private String encodedImg;

	public ProductDTO() {
	};

	public ProductDTO(Product product) {
		this(product.getName(), new BrandDTO(product.getBrand()), product.getKeywords(),
				Base64.encodeBase64String(ArrayUtils.toPrimitive(product.getBlobImg())));
	}
}
