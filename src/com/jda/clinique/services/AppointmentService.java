package com.jda.clinique.services;

import java.util.ArrayList;

import com.jda.clinique.models.Appointment;

public class AppointmentService {
  private ArrayList<Appointment> appointments;
  
  public ArrayList<Appointment> getAppointments() {
    return appointments;
  }

  public Appointment findAppointment(Appointment seekingAppointment) {
    for (Appointment appointment : appointments) {
      boolean match = appointment.checkMatch(seekingAppointment);
      if (match) { return appointment; }
    }
    return null;
  }

  public void addNewAppointment(Appointment seekingAppointment, String patientId) {
    seekingAppointment.addPatientId(patientId);
    appointments.add(seekingAppointment);
  }
}
