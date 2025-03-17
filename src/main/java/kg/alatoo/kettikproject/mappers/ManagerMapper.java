package kg.alatoo.kettikproject.mappers;

import kg.alatoo.kettikproject.dto.ManagerDTO;
import kg.alatoo.kettikproject.entities.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    ManagerDTO toDto(Manager manager);
    Manager toEntity(ManagerDTO managerDTO);
}
