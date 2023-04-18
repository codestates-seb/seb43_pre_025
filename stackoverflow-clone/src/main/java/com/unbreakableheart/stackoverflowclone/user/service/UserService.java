package com.unbreakableheart.stackoverflowclone.user.service;

import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.repository.UserRepository;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        verifyExistUser(user.getEmail());
        return userRepository.save(user);
    }

    private void verifyExistUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new IllegalArgumentException();
        }
    }

    public User updateUser(User user) {
        User findUser = findVerifyUser(user.getId());
        Optional.ofNullable(user.getUsername())
                .ifPresent(findUser::setUsername);
        Optional.ofNullable(user.getPassword())
                .ifPresent(findUser::setPassword);
        return userRepository.save(findUser);
    }

    public User findUser(Long id) {
        return findVerifyUser(id);
    }

    public Page<User> findUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteUser(Long id) {
        findVerifyUser(id);
        userRepository.deleteById(id);
    }

    private User findVerifyUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
