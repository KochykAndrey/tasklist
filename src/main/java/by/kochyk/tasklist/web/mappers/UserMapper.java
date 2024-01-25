package by.kochyk.tasklist.web.mappers;

import by.kochyk.tasklist.domain.user.User;
import by.kochyk.tasklist.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
