package com.base_backend_spring.payload.response.user;

import com.base_backend_spring.payload.common.PageResponse;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
public class PageResponseUsers extends PageResponse<UserResponse> {

}
