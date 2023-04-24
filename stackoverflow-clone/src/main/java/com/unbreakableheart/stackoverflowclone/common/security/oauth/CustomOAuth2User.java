package com.unbreakableheart.stackoverflowclone.common.security.oauth;

import com.unbreakableheart.stackoverflowclone.common.utils.AuthorityUtils;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Getter
public class CustomOAuth2User extends DefaultOAuth2User {

    private String email;
    private List<String> role;

    public CustomOAuth2User(Collection<? extends GrantedAuthority> authorities,
                            Map<String, Object> attributes,
                            String nameAttributeKey,
                            String email,
                            List<String> role) {
        super(authorities, attributes, nameAttributeKey);
        this.email = email;
        this.role = role;
    }

    public static CustomOAuth2User of(User user,
                                      Map<String, Object> attributes,
                                      OAuthAttributes oAuthAttributes) {
        return new CustomOAuth2User(
                AuthorityUtils.getAuthorities(user.getRoles()),
                attributes,
                oAuthAttributes.getProviderId(),
                user.getEmail(),
                user.getRoles()
        );
    }
}
