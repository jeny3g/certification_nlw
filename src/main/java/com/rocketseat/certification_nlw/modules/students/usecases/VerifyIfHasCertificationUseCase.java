package com.rocketseat.certification_nlw.modules.students.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.rocketseat.certification_nlw.modules.students.repositories.CertificationStudentRepository;

@Service
public class VerifyIfHasCertificationUseCase {

  @Autowired
  private CertificationStudentRepository certificationStudentRepository;

  public boolean execute(VerifyHasCertificationDTO dto) {
    // String targetEmail = "mirandajean2009@outlook.com";
    // String targetTechnology = "JAVA";

    // boolean isTargetEmail = dto.getEmail().equals(targetEmail);
    // boolean isTargetTechnology = dto.getTechnology().equals(targetTechnology);

    var query = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(),
        dto.getTechnology());

    if (query.isEmpty()) {
      return false;
    }

    return true;
  }
}
