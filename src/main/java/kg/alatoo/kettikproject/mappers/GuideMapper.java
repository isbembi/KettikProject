package kg.alatoo.kettikproject.mappers;

import kg.alatoo.kettikproject.dto.GuideDTO;
import kg.alatoo.kettikproject.entities.Guide;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GuideMapper {
    GuideMapper INSTANCE = Mappers.getMapper(GuideMapper.class);

    GuideDTO toDto(Guide guide);
    Guide toEntity(GuideDTO guideDTO);
}
