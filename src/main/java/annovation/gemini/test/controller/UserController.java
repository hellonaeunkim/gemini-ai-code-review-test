package annovation.gemini.test.controller;

import java.util.Optional;

@RestController
@RequestMapping("/{users}")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // C
    @PostMapping
    public ResponseEntity<UserEntity> createUser(
            @RequestBody UserCreateRequest userCreateRequest
    ) {
        String username = userCreateRequest.getUsername();
        String email = userCreateRequest.getEmail();

        UserEntity createdUser = userService.createUser(username, email);

        return ResponseEntity
                .status(HttpStatus.CREATED) // http status code 201
                .body(createdUser);
    }

    // R
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") long id) {
        Optional<UserEntity> user = userService.findById(id);

        return user.map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // http status code= 404
    }
}
