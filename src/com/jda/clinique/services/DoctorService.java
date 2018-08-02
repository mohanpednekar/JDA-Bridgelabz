package com.jda.clinique.services;

import java.util.ArrayList;

import com.jda.clinique.models.Doctor;
import com.jda.clinique.util.Enums.AppointmentSlot;

public class DoctorService {
  private ArrayList<Doctor> doctors = new ArrayList<>();
  
  public Doctor find(int doctorId) {
    for (Doctor doctor : doctors) {
      if (doctor.getId() == doctorId) { return doctor; }
    }
    return null;
  }
  
  public ArrayList<Doctor> findMatchesSkippable(String name, int doctorId, AppointmentSlot availabilty,
      String specialisation) {
    ArrayList<Doctor> matches = new ArrayList<>();
    for (Doctor doctor : doctors) {
      if (!name.equals("x") && !name.equals(doctor.getName())) {
        continue;
      }
      if ((doctorId != 0) && (doctorId != doctor.getId())) {
        continue;
      }
      if ((availabilty != null) && !availabilty.equals(AppointmentSlot.BOTH) && !doctor.isAvailable(availabilty)) {
        continue;
      }
      if (!specialisation.equals("x") && !specialisation.equals(doctor.getSpecialisation())) {
        continue;
      }
      doctors.add(doctor);
    }
    return matches;
  }

  public void addDoctor(Doctor doctor) {
    doctors.add(doctor);
  }
  
  public int findHighestId() {
    int highest = 0;
    for (Doctor doctor : doctors) {
      if (doctor.getId() > highest) {
        highest = doctor.getId();
      }
    }
    return highest;
  }

  public void removeDoctor(Doctor doctor) {
    doctors.remove(doctor);
  }
}
