package com.base_backend_spring.payload.mapper;

import com.base_backend_spring.payload.OAuthUserInfo;
import com.base_backend_spring.payload.response.auth.GithubResponseUser;
import com.base_backend_spring.payload.response.auth.GoogleResponseUser;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface OAuthUserMapper {

    OAuthUserInfo toUserInfo(GoogleResponseUser user);

    OAuthUserInfo toUserInfo(GithubResponseUser user);
}
