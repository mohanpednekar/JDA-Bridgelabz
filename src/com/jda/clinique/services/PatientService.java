package com.jda.clinique.services;

import java.util.ArrayList;

import com.jda.clinique.models.Patient;

public class PatientService {
  private ArrayList<Patient> patients;
  
  public Patient find(String patientId) {
    for (Patient patient : patients) {
      if (patient.getId().equals(patientId)) { return patient; }
    }
    return null;
  }

  public ArrayList<Patient> findMatchesSkippable(String name, String patientId, long mobile, int age) {
    ArrayList<Patient> matches = new ArrayList<>();
    for (Patient patient : patients) {
      if (!name.equals("x") && !name.equals(patient.getName())) {
        continue;
      }
      if (!patientId.equals("x") && !patientId.equals(patient.getId())) {
        continue;
      }
      if ((mobile != 0) && (mobile != patient.getMobile())) {
        continue;
      }
      if ((age != -1) && (age != patient.getAge())) {
        continue;
      }
      patients.add(patient);

    }
    return matches;
  }
}