package com.base_backend_spring.payload.mapper;

import com.base_backend_spring.entity.User;
import com.base_backend_spring.payload.request.auth.RegRequest;
import com.base_backend_spring.payload.request.user.ProfileRequest;
import com.base_backend_spring.payload.response.user.UserResponse;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    User regRequestToEntity(RegRequest userRequest);

    UserResponse entityToResponse(User user);

    User profileToEntity(ProfileRequest profileRequest, @MappingTarget User user);
}
