package annovation.gemini.test.controller;

@RestController
@RequestMapping("/{users}")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    // C
    @PostMapping
    public ResponseEntity<UsersEntity> createUser(
            @RequestBody UsersCreateRequest usersCreateRequest
    ) {
        String username = userCreateRequest.getUsername();
        String email = userCreateRequest.getEmail();

        UserEntity createdUser = userService.createUser(username, email);

        return ResponseEntity
                .status(HttpStatus.CREATED) // http status code 201
                .body(createdUser);
    }


}
