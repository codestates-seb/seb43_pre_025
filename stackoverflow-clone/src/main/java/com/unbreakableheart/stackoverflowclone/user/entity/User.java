package com.unbreakableheart.stackoverflowclone.user.entity;

import com.unbreakableheart.stackoverflowclone.common.entity.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "member")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @NotBlank
    @Column(nullable = false)
    private String password;
    @NotBlank
    @Column(nullable = false)
    private String username;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
    private String provider;
    private String providerId;

    public void addRoles(List<String> roles) {
        this.roles = roles;
    }

    @Builder
    public User(String email, String password, String username, List<String> roles, String provider, String providerId) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
        this.provider = provider;
        this.providerId = providerId;
    }
}
