package com.example.backendproject.controller;
import com.example.backendproject.dto.Api;
import com.example.backendproject.dto.RegisterForm;
import com.example.backendproject.model.User;
import com.example.backendproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm) {
         userService.register(registerForm);
        return ResponseEntity.status(201).body("Register done !");
    }


    @GetMapping("/users")
    public ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Api> updateUser(@RequestBody @Valid User user, @PathVariable Integer id){
        userService.updateUser(user, id);
        return ResponseEntity.status(201).body(new Api("User updated",201));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Api> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(201).body(new Api("User deleted !", 201));
    }

}
