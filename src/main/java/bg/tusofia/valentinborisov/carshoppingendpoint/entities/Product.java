package bg.tusofia.valentinborisov.carshoppingendpoint.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(generator = "product_generator")
	@SequenceGenerator(name = "product_generator", sequenceName = "product_sequence", initialValue = 1)
	private Long id;

	@Column
	private String name;

	@ManyToOne
	private Brand brand;

	@Column
	private String keywords;
}
