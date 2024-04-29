package projeto.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.spring.jpa.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
