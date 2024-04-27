package projeto.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.spring.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
