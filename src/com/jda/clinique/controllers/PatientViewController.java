package com.jda.clinique.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jda.clinique.app.CliniqueManagerApp;
import com.jda.clinique.models.Patient;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.services.PatientService;
import com.jda.clinique.util.Constants;
import com.jda.clinique.util.Constants.Path;
import com.jda.clinique.util.Reader;

public class PatientViewController {
  
  PatientService    patientService;
  FileSystemService fileSystemService;
  
  public PatientViewController() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
    fileSystemService = new FileSystemService();
    Type patientsType = new TypeToken<PatientService>() {}.getType();
    patientService = fileSystemService.readFile(Path.PATIENTS, patientsType);
  }
  
  public void searchPatients() {
    System.out.println("Enter requested search parameters. Enter x to skip.");
    Reader reader = new Reader();
    String name = reader.requestInputLine("Enter Patient aame : ");
    int patientId = 0;
    try {
      patientId = reader.requestInputInt("Enter Patient ID : ");
    } catch (Exception ignored) {}
    long phone = 0L;
    try {
      phone = reader.requestInputLong("Enter phone : ");
    } catch (Exception ignored) {}
    int age = -1;
    try {
      age = reader.requestInputInt("Enter age : ");
    } catch (Exception ignored) {}
    ArrayList<Patient> patientsFound = patientService.findMatchesSkippable(name, patientId, phone, age);
    System.out.println("\nWe found following patients");
    patientsFound.forEach(System.out::println);
  }

  public void openMainMenu() {
    CliniqueManagerApp app = new CliniqueManagerApp();
    app.execute();
  }
  
  public void addPatient() {
    Reader reader = new Reader();
    int highestId = patientService.findHighestId();
    Patient patient = new Patient(reader, highestId);
    patientService.addPatient(patient);

    try {
      fileSystemService.saveFile(patientService, Path.PATIENTS);
      System.out.println("Patient added");
    } catch (IOException e) {
      System.out.println(Constants.FAILED_TO_SAVE_CHANGES);
      e.printStackTrace();
    }
  }
  
  public void removePatient() {
    Reader reader = new Reader();
    int patientId = reader.requestInputInt("Enter Patient ID : ");
    Patient patient = patientService.find(patientId);
    if (patient == null) {
      System.out.println("No such patient found.");
    } else {
      boolean confirmDelete = reader.requestConfirmation("Confirm remove Patient : " + patient.getName() + "?");
      if (confirmDelete) {
        patientService.removePatient(patient);
        try {
          fileSystemService.saveFile(patientService, Path.PATIENTS);
          System.out.println("Patient removed");
        } catch (IOException e) {
          System.out.println(Constants.FAILED_TO_SAVE_CHANGES);
          e.printStackTrace();
        }
      } else {
        System.out.println("Patient not removed");
      }
    }
  }
  
}
