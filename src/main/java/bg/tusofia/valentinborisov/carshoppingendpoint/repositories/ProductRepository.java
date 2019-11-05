package bg.tusofia.valentinborisov.carshoppingendpoint.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;
import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByBrand(Brand brand);

}
