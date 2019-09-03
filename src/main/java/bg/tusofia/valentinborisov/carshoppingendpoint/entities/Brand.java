package bg.tusofia.valentinborisov.carshoppingendpoint.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Brands")
@Getter
@Setter
public class Brand {

	@Id
	@GeneratedValue(generator = "brand_generator")
	@SequenceGenerator(name = "brand_generator", sequenceName = "brand_sequence", initialValue = 1)
	private Long id;

	@NotBlank
	@Column
	private String name;
}
