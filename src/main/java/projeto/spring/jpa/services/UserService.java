package projeto.spring.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import projeto.spring.jpa.entities.User;
import projeto.spring.jpa.repositories.UserRepository;
import projeto.spring.jpa.services.exceptions.DatabaseException;
import projeto.spring.jpa.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e){
			throw new ResourceNotFoundException(id, " to delete");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}
	
	public User update(Long id, User user) {
		
		try {
			User userToUpdate = userRepository.getReferenceById(id);
			
			userToUpdate.setName(user.getName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setPhone(user.getPhone());
			
			return userRepository.save(userToUpdate);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id," to update");
		}
	}
}