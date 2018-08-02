package com.jda.clinique.controllers;

import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.jda.clinique.models.Patient;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.services.PatientService;
import com.jda.clinique.util.Constants.Path;
import com.jda.clinique.util.Reader;

public class PatientViewController {
  
  PatientService patientService;
  
  public PatientViewController() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
    FileSystemService fileSystemService = new FileSystemService();
    Type patientsType = new TypeToken<PatientService>() {}.getType();
    
    patientService = fileSystemService.readFile(Path.PATIENTS, patientsType);
  }
  
  public void searchPatients() {
    System.out.println("Enter requested search parameters. Enter x to skip.");
    Reader reader = new Reader();
    String name = reader.requestInputLine("Enter Patient aame : ");
    String patientId = reader.requestInputLine("Enter Patient ID : ");
    long phone = reader.requestInputLong("Enter phone : ");
    int age = reader.requestInputInt("Enter age : ");
    ArrayList<Patient> patientsFound = patientService.findMatchesSkippable(name, patientId, phone, age);
    System.out.println("\nWe found following patients");
    patientsFound.forEach(System.out::println);
  }
  
}
