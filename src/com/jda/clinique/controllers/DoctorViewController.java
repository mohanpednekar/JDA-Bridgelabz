package com.jda.clinique.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jda.clinique.app.CliniqueManagerApp;
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
  FileSystemService  fileSystemService;
  
  public DoctorViewController() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
    fileSystemService = new FileSystemService();
    Type appointmentsType = new TypeToken<AppointmentService>() {}.getType();
    appointmentService = fileSystemService.readFile(Path.APPOINTMENTS, appointmentsType);
    Type doctorsType = new TypeToken<DoctorService>() {}.getType();
    doctorService = fileSystemService.readFile(Path.DOCTORS, doctorsType);
  }
  
  public void bookAppointment() {
    Reader reader = new Reader();
    int doctorId = reader.requestInputInt("Enter Doctor ID : ");
    int patientId = reader.requestInputInt("Enter Patient ID : ");
    Date date = reader.requestInputDate("Enter date (" + Constants.DATE_FORMAT.toUpperCase() + ") : ");
    AppointmentSlot slot = reader.requestInputEnum("Choose slot : ", AppointmentSlot.class);
    Appointment seekingAppointment = new Appointment(doctorId, date, slot);
    Appointment existingAppointment = appointmentService.findAppointment(seekingAppointment);
    if (existingAppointment == null) {
      attemptNewAppointment(seekingAppointment, patientId);
    } else {
      attemptExistingAppointment(existingAppointment, patientId);

    }
  }

  private void attemptNewAppointment(Appointment seekingAppointment, int patientId) {
    Doctor seekingDoctor = doctorService.find(seekingAppointment.getDoctorId());
    if ((seekingDoctor != null) && seekingDoctor.isAvailable(seekingAppointment.getSlot())) {
      appointmentService.addNewAppointment(seekingAppointment, patientId);
      try {
        fileSystemService.saveFile(appointmentService, Path.APPOINTMENTS);
        System.out.println(Constants.APPOINTMENT_BOOKED_SUCCESSFULLY);

      } catch (IOException e) {
        System.out.println(Constants.FAILED_TO_SAVE_CHANGES);
        e.printStackTrace();
      }
      
    } else {
      System.out.println(Constants.FAILED_TO_FIND_THE_REQUESTED_DOCTOR_IN_THE_SLOT);
    }
  }

  private void attemptExistingAppointment(Appointment existingAppointment, int patientId) {
    if (existingAppointment.numberOfBookings() < 5) {
      existingAppointment.addPatientId(patientId);

      try {
        fileSystemService.saveFile(appointmentService, Path.APPOINTMENTS);
        System.out.println(Constants.APPOINTMENT_BOOKED_SUCCESSFULLY);

      } catch (IOException e) {
        System.out.println(Constants.FAILED_TO_SAVE_CHANGES);
        e.printStackTrace();
      }

    } else {
      System.out.println(Constants.THIS_SLOT_IS_FULL);
    }
  }

  public void searchDoctors() {
    System.out.println("Enter requested search parameters. Enter x to skip.");
    Reader reader = new Reader();
    String name = reader.requestInputLine("Enter Doctor name : ");
    int doctorId = reader.requestInputInt("Enter Doctor ID : ");
    String specialisation = reader.requestInputLine("Enter Specialisation : ");
    AppointmentSlot availabilty = reader.requestInputEnum("Enter availability needed : ", AppointmentSlot.class);
    ArrayList<Doctor> doctorsFound = doctorService.findMatchesSkippable(name, doctorId, availabilty, specialisation);
    System.out.println("\nWe found following doctors");
    doctorsFound.forEach(System.out::println);
  }
  
  public void openMainMenu() {
    CliniqueManagerApp app = new CliniqueManagerApp();
    app.execute();
  }
  
  public void addDoctor() {
    Reader reader = new Reader();
    int highestId = doctorService.findHighestId();
    Doctor doctor = new Doctor(reader, highestId);
    doctorService.addDoctor(doctor);
    
    try {
      fileSystemService.saveFile(doctorService, Path.DOCTORS);
      System.out.println("Doctor Added");
    } catch (IOException e) {
      System.out.println(Constants.FAILED_TO_SAVE_CHANGES);
      e.printStackTrace();
    }
    
  }

  public void removeDoctor() {
    Reader reader = new Reader();
    int doctorId = reader.requestInputInt("Enter Doctor ID : ");
    Doctor doctor = doctorService.find(doctorId);
    if (doctor == null) {
      System.out.println("No such doctor found.");
    } else {
      boolean confirmDelete = reader.requestConfirmation("Confirm remove Dr. " + doctor.getName() + "?");
      if (confirmDelete) {
        doctorService.removeDoctor(doctor);
        try {
          fileSystemService.saveFile(doctorService, Path.DOCTORS);
          System.out.println("Doctor removed");
        } catch (IOException e) {
          System.out.println(Constants.FAILED_TO_SAVE_CHANGES);
          e.printStackTrace();
        }
      } else {
        System.out.println("Doctor not removed");
      }
    }
  }
  
}
