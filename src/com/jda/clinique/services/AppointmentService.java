package com.jda.clinique.services;

import com.jda.clinique.models.Appointment;

public class AppointmentService {
  boolean isAvailable(Appointment appointment) {
    return numberOfBookings(appointment) < 5;
  }
  
  private int numberOfBookings(Appointment appointment) {
    return appointment.getPatientIds().size();
  }
}
