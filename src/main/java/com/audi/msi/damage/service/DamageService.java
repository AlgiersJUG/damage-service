package com.audi.msi.damage.service;

import com.audi.msi.damage.repository.DamageModelRepository;
import com.audi.msi.damage.service.dto.DamageDto;
import com.audi.msi.damage.service.mapper.DamageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Abderrazak BOUADMA
 * on 26/03/2017.
 */
@Service
public class DamageService {

    @Autowired
    private DamageModelRepository damageModelRepository;

    private DamageMapper mapper;

    public DamageDto findById(Long id) {
       return mapper.fromModel(damageModelRepository.findOne(id));
    }
}
