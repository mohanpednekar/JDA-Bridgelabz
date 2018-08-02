package com.jda.clinique.controllers;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jda.clinique.models.Appointment;
import com.jda.clinique.models.Doctor;
import com.jda.clinique.services.AppointmentService;
import com.jda.clinique.services.DoctorService;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.util.Constants.Path;

public class InsightsViewController {
  AppointmentService appointmentService;
  DoctorService      doctorService;

  public InsightsViewController() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
    FileSystemService fileSystemService = new FileSystemService();
    Type appointmentsType = new TypeToken<AppointmentService>() {}.getType();
    appointmentService = fileSystemService.readFile(Path.APPOINTMENTS, appointmentsType);
    Type doctorsType = new TypeToken<DoctorService>() {}.getType();
    doctorService = fileSystemService.readFile(Path.DOCTORS, doctorsType);
  }

  public void showPopularDoctor() {
    HashMap<String, Integer> bookingsCount = new HashMap<>();
    String mostPopular = null;
    int maxBookings = 0;
    for (Appointment appointment : appointmentService.getAppointments()) {
      String id = appointment.getDoctorId();
      bookingsCount.putIfAbsent(id, 0);
      bookingsCount.put(id, bookingsCount.get(id) + appointment.numberOfBookings());
      if (bookingsCount.get(id) > maxBookings) {
        maxBookings = bookingsCount.get(id);
        mostPopular = id;
      }
    }
    
    Doctor popularDoctor = doctorService.find(mostPopular);
    System.out.println(popularDoctor);
  }
  
  public void showPopularSpecialisation() {
    HashMap<String, Integer> bookingsCount = new HashMap<>();
    String mostPopular = null;
    int maxBookings = 0;
    for (Appointment appointment : appointmentService.getAppointments()) {
      String specialisation = doctorService.find(appointment.getDoctorId()).getSpecialisation();
      bookingsCount.putIfAbsent(specialisation, 0);
      bookingsCount.put(specialisation, bookingsCount.get(specialisation) + appointment.numberOfBookings());
      if (bookingsCount.get(specialisation) > maxBookings) {
        maxBookings = bookingsCount.get(specialisation);
        mostPopular = specialisation;
      }
    }
    System.out.println(mostPopular);

  }

}
