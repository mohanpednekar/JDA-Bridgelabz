package com.jda.clinique.models;

import com.jda.clinique.util.Enums.AppointmentSlot;
import com.jda.clinique.util.Reader;

public class Doctor extends Person {
  private String          specialisation;
  private AppointmentSlot availability;
  
  public Doctor(Reader reader, int highestId) {
    id = highestId + 1;
    name = reader.requestInputLine("Enter name : ");
    specialisation = reader.requestInputLine("Enter specialisation : ");
    availability = reader.requestInputEnum("Enter availability slot : ", AppointmentSlot.class);
  }

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
  
  public boolean isAvailable(AppointmentSlot slot) {
    if (AppointmentSlot.BOTH.equals(slot)) { return true; }
    return availability.equals(slot);
  }
}
