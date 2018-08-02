package com.jda.clinique.services;

import java.util.ArrayList;

import com.jda.clinique.models.Patient;

public class PatientService {
  private ArrayList<Patient> patients = new ArrayList<>();
  
  public Patient find(int patientId) {
    for (Patient patient : patients) {
      if (patient.getId() == patientId) { return patient; }
    }
    return null;
  }

  public ArrayList<Patient> findMatchesSkippable(String name, int patientId, long mobile, int age) {
    ArrayList<Patient> matches = new ArrayList<>();
    for (Patient patient : patients) {
      if (!name.equals("x") && !name.equals(patient.getName())) {
        continue;
      }
      if ((patientId != 0) && (patientId != patient.getId())) {
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
  
  public int findHighestId() {
    int highest = 0;
    for (Patient patient : patients) {
      if (patient.getId() > highest) {
        highest = patient.getId();
      }
    }
    return highest;
  }

  public void addPatient(Patient patient) {
    patients.add(patient);
  }
  
  public void removePatient(Patient patient) {
    patients.remove(patient);
  }
}