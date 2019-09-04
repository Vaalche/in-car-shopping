package bg.tusofia.valentinborisov.carshoppingendpoint.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.tusofia.valentinborisov.carshoppingendpoint.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	Optional<Brand> findByName(String name);
}
