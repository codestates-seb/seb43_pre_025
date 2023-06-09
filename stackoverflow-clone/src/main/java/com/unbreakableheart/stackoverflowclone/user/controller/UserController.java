package com.unbreakableheart.stackoverflowclone.user.controller;

import com.unbreakableheart.stackoverflowclone.common.response.MultiResponse;
import com.unbreakableheart.stackoverflowclone.common.response.SingleResponse;
import com.unbreakableheart.stackoverflowclone.common.utils.UriCreator;
import com.unbreakableheart.stackoverflowclone.user.dto.UserDto;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.mapper.UserMapper;
import com.unbreakableheart.stackoverflowclone.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

import static com.unbreakableheart.stackoverflowclone.common.utils.Constant.USER_DEFAULT_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping(value = "/signup")
    public ResponseEntity<UserDto.Post> signUp(@RequestBody UserDto.Post post) {
        User user = userService.createUser(userMapper.postToUser(post));
        return ResponseEntity.created(UriCreator.createURI(USER_DEFAULT_URL, user.getId())).build();
    }

    @PatchMapping("user/{user-id}")
    public ResponseEntity<SingleResponse<UserDto.Response>> patchUser(@PathVariable("user-id") @Valid @Positive Long id,
                                                                      @RequestBody UserDto.Patch patch) {
        patch.addId(id);
        User user = userService.updateUser(userMapper.patchToUser(patch));
        return ResponseEntity.ok(new SingleResponse<>(userMapper.userToUserDtoResponse(user)));
    }

    @GetMapping("user/{user-id}")
    public ResponseEntity<SingleResponse<UserDto.Response>> getUser(@PathVariable("user-id") @Valid @Positive Long id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(new SingleResponse<>(userMapper.userToUserDtoResponse(user)));
    }

    @GetMapping
    public ResponseEntity<MultiResponse<UserDto.Response>> getUsers(@RequestParam @Valid @Positive int page,
                                                                    @RequestParam @Valid @Positive int size) {
        Page<User> userPage = userService.findUsers(page - 1, size);
        List<User> users = userPage.getContent();
        return ResponseEntity.ok(new MultiResponse<>(userPage, userMapper.usersToUserDtoResponses(users)));
    }

    @DeleteMapping("user/{user-id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("user-id") @Valid @Positive Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
