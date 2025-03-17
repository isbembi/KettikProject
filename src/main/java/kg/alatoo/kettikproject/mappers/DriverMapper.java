package kg.alatoo.kettikproject.mappers;

import kg.alatoo.kettikproject.dto.DriverDTO;
import kg.alatoo.kettikproject.entities.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);

    DriverDTO toDto(Driver driver);
    Driver toEntity(DriverDTO driverDTO);
}
