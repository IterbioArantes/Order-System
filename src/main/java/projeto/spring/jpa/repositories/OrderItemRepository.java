package projeto.spring.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.spring.jpa.entities.OrderItem;
import projeto.spring.jpa.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
