package annovation.gemini.test.controller;

@RestController
@RequestMapping("/{userId}")
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


}
