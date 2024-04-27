package projeto.spring.jpa.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.spring.jpa.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L,"Itérbio Arantes", "iterbio7@gmail.com","95649879","123456");
		
		return ResponseEntity.ok().body(u);
	}
}
