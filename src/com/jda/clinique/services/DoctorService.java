package com.jda.clinique.services;

import java.util.ArrayList;

import com.jda.clinique.models.Doctor;
import com.jda.clinique.util.Enums.AppointmentSlot;

public class DoctorService {
  private ArrayList<Doctor> doctors;
  
  public Doctor find(String doctorId) {
    for (Doctor doctor : doctors) {
      if (doctor.getId().equals(doctorId)) { return doctor; }
    }
    return null;
  }
  
  public ArrayList<Doctor> findMatchesSkippable(String name, String doctorId, AppointmentSlot availabilty,
      String specialisation) {
    ArrayList<Doctor> matches = new ArrayList<>();
    for (Doctor doctor : doctors) {
      if (!name.equals("x") && !name.equals(doctor.getName())) {
        continue;
      }
      if (!doctorId.equals("x") && !doctorId.equals(doctor.getId())) {
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
}
