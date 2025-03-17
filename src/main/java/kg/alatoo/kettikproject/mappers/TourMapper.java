package kg.alatoo.kettikproject.mappers;

import kg.alatoo.kettikproject.dto.TourDTO;
import kg.alatoo.kettikproject.entities.Tour;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TourMapper {
    TourMapper INSTANCE = Mappers.getMapper(TourMapper.class);

    TourDTO toDto(Tour tour);
    Tour toEntity(TourDTO tourDTO);
}
