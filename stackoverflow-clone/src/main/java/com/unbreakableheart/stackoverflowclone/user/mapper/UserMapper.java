package com.unbreakableheart.stackoverflowclone.user.mapper;

import com.unbreakableheart.stackoverflowclone.user.dto.UserDto;
import com.unbreakableheart.stackoverflowclone.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User postToUser(UserDto.Post post);
    User patchToUser(UserDto.Patch patch);
    UserDto.Response userToUserDtoResponse(User user);
    List<UserDto.Response> usersToUserDtoResponses(List<User> user);
}
