package com.audi.msi.damage.repository;

import com.audi.msi.damage.domain.DamageModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Abderrazak BOUADMA
 * on 26/03/2017.
 */
public interface DamageModelRepository extends JpaRepository<DamageModel, Long> {
}
