package com.audi.msi.damage.web.rest;

import com.audi.msi.damage.domain.DamageModel;
import com.audi.msi.damage.repository.DamageModelRepository;
import com.audi.msi.damage.service.DamageService;
import com.audi.msi.damage.service.dto.DamageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Abderrazak BOUADMA
 * on 26/03/2017.
 */

@RestController
@RequestMapping("/api/v1/damage")
public class DamageResource {

    @Autowired
    private DamageModelRepository damageModelRepository;

    @Autowired
    private DamageService damageService;

    @GetMapping("/{id}")
    public ResponseEntity<DamageDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(damageService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Long> insertDamage(@RequestBody @Valid DamageModel model) {
        DamageModel saved = damageModelRepository.save(model);
        return ResponseEntity.accepted().body(saved.getId());
    }
}
