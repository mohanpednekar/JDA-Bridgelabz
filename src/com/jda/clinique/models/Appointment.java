package com.jda.clinique.models;

import java.util.ArrayList;
import java.util.Date;

import com.jda.clinique.util.Enums.AppointmentSlot;

public class Appointment {
  private String            doctorId;
  private Date              date;
  private AppointmentSlot   slot;
  private ArrayList<String> patientIds;
  
  public String getDoctorId() {
    return doctorId;
  }
  
  public void setDoctorId(String doctorId) {
    this.doctorId = doctorId;
  }
  
  public ArrayList<String> getPatientIds() {
    return patientIds;
  }
  
  public void setPatientIds(ArrayList<String> patientIds) {
    this.patientIds = patientIds;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public AppointmentSlot getSlot() {
    return slot;
  }
  
  public void setSlot(AppointmentSlot slot) {
    this.slot = slot;
  }
}
