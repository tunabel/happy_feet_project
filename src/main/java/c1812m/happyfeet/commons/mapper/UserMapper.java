package c1812m.happyfeet.commons.mapper;

import c1812m.happyfeet.dto.UserDto;
import c1812m.happyfeet.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User entity);
    User toEntity(UserDto dto);
}
