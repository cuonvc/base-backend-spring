package com.base_backend_spring.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessTokenDto {
    private String token;
    private String tokenType;
    private Date expireDate;
}
