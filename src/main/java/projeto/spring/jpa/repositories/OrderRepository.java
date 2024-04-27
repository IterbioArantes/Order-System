package projeto.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.spring.jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
