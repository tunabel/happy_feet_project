package c1812m.happyfeet.commons.mapper;

import c1812m.happyfeet.dto.OrderDto;
import c1812m.happyfeet.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order entity);
    Order toEntity(OrderDto dto);
}
