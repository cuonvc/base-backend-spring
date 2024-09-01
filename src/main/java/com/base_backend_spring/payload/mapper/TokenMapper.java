package com.base_backend_spring.payload.mapper;

import com.base_backend_spring.entity.RefreshToken;
import com.base_backend_spring.payload.dto.RefreshTokenDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public interface TokenMapper {

    RefreshTokenDto mapToDto(RefreshToken refreshToken);
}
