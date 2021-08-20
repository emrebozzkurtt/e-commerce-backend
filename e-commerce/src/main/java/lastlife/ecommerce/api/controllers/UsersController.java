package lastlife.ecommerce.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lastlife.ecommerce.business.abstracts.UserService;
import lastlife.ecommerce.core.entities.User;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.add(user));
	}

}
