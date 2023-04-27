package com.unbreakableheart.stackoverflowclone.common.security.oauth;

import com.unbreakableheart.stackoverflowclone.common.exception.CustomException;
import com.unbreakableheart.stackoverflowclone.common.exception.ExceptionCode;
import com.unbreakableheart.stackoverflowclone.common.security.oauth.userinfo.GoogleUserInfo;
import com.unbreakableheart.stackoverflowclone.common.security.oauth.userinfo.NaverUserInfo;
import com.unbreakableheart.stackoverflowclone.common.security.oauth.userinfo.OAuth2UserInfo;
import com.unbreakableheart.stackoverflowclone.common.security.oauth.userinfo.ProviderType;
import com.unbreakableheart.stackoverflowclone.user.entity.Role;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Getter
public class OAuthAttributes {

    private String providerId;
    private OAuth2UserInfo oAuth2UserInfo;

    @Builder
    public OAuthAttributes(String providerId, OAuth2UserInfo oAuth2UserInfo) {
        this.providerId = providerId;
        this.oAuth2UserInfo = oAuth2UserInfo;
    }

    public static OAuthAttributes of(ProviderType providerType,
                                     String providerId,
                                     Map<String, Object> attributes) {
        if (providerType == ProviderType.GOOGLE) {
            return ofGoogle(providerId, attributes);
        }
        if (providerType == ProviderType.KAKAO) {
            return ofKakao(providerId, attributes);
        }
        if (providerType == ProviderType.NAVER) {
            return ofNaver(providerId, attributes);
        }

        throw new CustomException(ExceptionCode.PROVIDER_NOT_FOUND);
    }

    private static OAuthAttributes ofGoogle(String providerId, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .providerId(providerId)
                .oAuth2UserInfo(new GoogleUserInfo(attributes))
                .build();
    }

    private static OAuthAttributes ofKakao(String providerId, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .providerId(providerId)
                //.oAuth2UserInfo(new KakaoUserInfo(attributes))
                .build();
    }

    private static OAuthAttributes ofNaver(String providerId, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .providerId(providerId)
                .oAuth2UserInfo(new NaverUserInfo(attributes))
                .build();
    }

    public User toEntity(ProviderType providerType, OAuth2UserInfo oAuth2UserInfo, PasswordEncoder passwordEncoder) {
        return User.builder()
                .provider(providerType.getProvider())
                .providerId(oAuth2UserInfo.getProviderId())
                .email(oAuth2UserInfo.getEmail())
                .username(oAuth2UserInfo.getName())
                .roles(Collections.singletonList(Role.USER.getRole()))
                .password(passwordEncoder.encode("NO_PASS" + UUID.randomUUID()))
                .build();
    }
}
