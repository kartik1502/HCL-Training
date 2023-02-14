package org.hcltraining.bankapplication.repository;

import org.hcltraining.bankapplication.entity.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscationRepository extends JpaRepository<Transcation, Long> {

}
