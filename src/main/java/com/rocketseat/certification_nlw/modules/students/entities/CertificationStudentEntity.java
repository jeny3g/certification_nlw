package com.rocketseat.certification_nlw.modules.students.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifications")
public class CertificationStudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @JoinColumn(name = "student_id")
  private UUID studentID;

  @Column(length = 100, nullable = false)
  private String technology;

  @Column(length = 10, nullable = false)
  private int grade;

  @OneToMany
  @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
  List<AnswersCertificationsEntity> answersCertificationsEntities;

  @ManyToOne
  @JoinColumn(name = "student_id", insertable = false, updatable = false)
  private StudentEntity studentEntity;
}
