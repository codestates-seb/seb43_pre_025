package com.unbreakableheart.stackoverflowclone.user.service;

import com.unbreakableheart.stackoverflowclone.common.exception.CustomException;
import com.unbreakableheart.stackoverflowclone.common.exception.ExceptionCode;
import com.unbreakableheart.stackoverflowclone.common.utils.AuthorityUtils;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import com.unbreakableheart.stackoverflowclone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityUtils authorityUtils;

    public User createUser(User user) {
        verifyExistUser(user.getEmail());
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        user.addRoles(authorityUtils.createRoles(user.getEmail()));

        return userRepository.save(user);
    }

    public User updateUser(User user) {
        User findUser = findVerifyUser(user.getId());
        Optional.ofNullable(user.getUsername())
                .ifPresent(findUser::setUsername);
        Optional.ofNullable(user.getPassword())
                .ifPresent(findUser::setPassword);
        return userRepository.save(findUser);
    }

    public User findUserByEmail(String email) {
        return findVerifyUser(email);
    }

    public User findUserById(long id) {
        return findVerifyUser(id);
    }

    public Page<User> findUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    public void deleteUser(Long id) {
        findVerifyUser(id);
        userRepository.deleteById(id);
    }

    private void verifyExistUser(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new CustomException(ExceptionCode.MEMBER_EMAIL_EXISTS);
        }
    }

    private User findVerifyUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    protected User findVerifyUser(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    public boolean isMatchUser(User writing, User authentication) {
        if(writing.getEmail().equals(authentication.getEmail())){
            return true;
        }
        throw new CustomException(ExceptionCode.MEMBER_NOT_MATCH);
    }
}
