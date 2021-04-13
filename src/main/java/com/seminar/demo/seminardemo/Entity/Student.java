package com.seminar.demo.seminardemo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  private String firstName;
  private String lastName;
  private String major;
  private double gpa;

}

