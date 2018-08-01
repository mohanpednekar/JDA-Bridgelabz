package com.jda.clinique.models;

import com.jda.clinique.util.Enums.AppointmentSlot;

public class Doctor {
  private String                 specialisation;
  private AppointmentSlot availability;
  
  public String getSpecialisation() {
    return specialisation;
  }
  
  public void setSpecialisation(String specialisation) {
    this.specialisation = specialisation;
  }
  
  public AppointmentSlot getAvailability() {
    return availability;
  }
  
  public void setAvailability(AppointmentSlot availability) {
    this.availability = availability;
  }
}
