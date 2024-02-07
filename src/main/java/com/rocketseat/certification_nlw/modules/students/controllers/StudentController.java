package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;

@RestController
@RequestMapping("/students")
public class StudentController {

  // Preciso usar o meu USECASE
  @Autowired
  private com.rocketseat.certification_nlw.modules.students.usecases.VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

  @PostMapping("/verifyIfHasCertification")
  public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
    var isUserCertified = this.verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);

    if (isUserCertified) {
      return "Usuário já fez a prova";
    }

    return "Usuário pode fazer a prova";
  }
}
