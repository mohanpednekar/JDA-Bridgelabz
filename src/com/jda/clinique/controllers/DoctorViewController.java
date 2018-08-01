package com.jda.clinique.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.jda.clinique.models.Appointment;
import com.jda.clinique.models.Doctor;
import com.jda.clinique.services.AppointmentService;
import com.jda.clinique.services.DoctorService;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.util.Constants;
import com.jda.clinique.util.Constants.Path;
import com.jda.clinique.util.Enums.AppointmentSlot;
import com.jda.clinique.util.Reader;

public class DoctorViewController {
  AppointmentService appointmentService;
  DoctorService      doctorService;
  
  public DoctorViewController() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
    FileSystemService fileSystemService = new FileSystemService();
    appointmentService = fileSystemService.readFile(Path.APPOINTMENTS);
    doctorService = fileSystemService.readFile(Path.DOCTORS);
  }
  
  public void bookAppointment() {
    Reader reader = new Reader();
    String doctorId = reader.requestInputLine("Enter Doctor ID : ");
    Date date = reader.requestInputDate("Enter date (" + Constants.DATE_FORMAT.toUpperCase() + ") : ");
    AppointmentSlot slot = reader.requestInputEnum("Choose slot : ", AppointmentSlot.class);
    String patientId = reader.requestInputLine("Enter Patient ID : ");
    Appointment seekingAppointment = new Appointment(doctorId, date, slot);
    Appointment existingAppointment = appointmentService.findAppointment(seekingAppointment);
    if (existingAppointment == null) {
      attemptNewAppointment(seekingAppointment, patientId);
    } else {
      attemptExistingAppointment(existingAppointment, patientId);

    }
  }

  private void attemptNewAppointment(Appointment seekingAppointment, String patientId) {
    Doctor seekingDoctor = doctorService.find(seekingAppointment.getDoctorId());
    if ((seekingDoctor != null) && seekingDoctor.isAvailable(seekingAppointment.getSlot())) {
      appointmentService.addNewAppointment(seekingAppointment, patientId);
      System.out.println(Constants.APPOINTMENT_BOOKED_SUCCESSFULLY);
    } else {
      System.out.println(Constants.FAILED_TO_FIND_THE_REQUESTED_DOCTOR_IN_THE_SLOT);
    }
  }

  private void attemptExistingAppointment(Appointment existingAppointment, String patientId) {
    if (existingAppointment.numberOfBookings() < 5) {
      existingAppointment.addPatientId(patientId);
      System.out.println(Constants.APPOINTMENT_BOOKED_SUCCESSFULLY);
    } else {
      System.out.println(Constants.THIS_SLOT_IS_FULL);
    }
  }

  public void searchDoctors() {
    System.out.println("Enter requested search parameters. Enter x to skip.");
    Reader reader = new Reader();
    String name = reader.requestInputLine("Enter Doctor aame : ");
    String doctorId = reader.requestInputLine("Enter Doctor ID : ");
    AppointmentSlot availabilty = reader.requestInputEnum("Enter availability needed : ", AppointmentSlot.class);
    String specialisation = reader.requestInputLine("Enter Specialisation : ");
    ArrayList<Doctor> doctorsFound = doctorService.findMatchesSkippable(name, doctorId, availabilty, specialisation);
    System.out.println("\nWe found following doctors");
    doctorsFound.forEach(System.out::println);
  }
  
}
