package com.audi.msi.damage.service.mapper;

import com.audi.msi.damage.domain.DamageModel;
import com.audi.msi.damage.service.dto.DamageDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Abderrazak BOUADMA
 * on 26/03/2017.
 */

@Mapper(componentModel = "spring")
public interface DamageMapper {
    DamageDto fromModel(DamageModel model);

    List<DamageDto> fromModels(List<DamageModel> models);
}
