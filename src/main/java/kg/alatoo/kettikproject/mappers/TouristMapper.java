package kg.alatoo.kettikproject.mappers;

import kg.alatoo.kettikproject.dto.TouristDTO;
import kg.alatoo.kettikproject.entities.Tourist;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TouristMapper {
    TouristMapper INSTANCE = Mappers.getMapper(TouristMapper.class);

    TouristDTO toDto(Tourist tourist);
    Tourist toEntity(TouristDTO touristDTO);
}
