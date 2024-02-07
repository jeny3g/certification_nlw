package com.rocketseat.certification_nlw.modules.students.usecases;

import org.springframework.stereotype.Service;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;

@Service
public class VerifyIfHasCertificationUseCase {

  public boolean execute(VerifyHasCertificationDTO dto) {
    String targetEmail = "mirandajean2009@outlook.com";
    String targetTechnology = "JAVA";

    boolean isTargetEmail = dto.getEmail().equals(targetEmail);
    boolean isTargetTechnology = dto.getTechnology().equals(targetTechnology);

    return isTargetEmail && isTargetTechnology;
  }
}
