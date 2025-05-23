package com.alertadose.demo.repository;

import com.alertadose.demo.entity.PrescricaoMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescricaoMedicamentoRepository extends JpaRepository<PrescricaoMedicamento, Long> {
}
