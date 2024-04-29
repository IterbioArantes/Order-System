package projeto.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.spring.jpa.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
