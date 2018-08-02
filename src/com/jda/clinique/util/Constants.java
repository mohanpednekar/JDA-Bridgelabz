package com.jda.clinique.util;

public class Constants {
  
  public class Path {
    public static final String DATA         = "data/";
    public static final String DOCTORS      = DATA + "doctors.json";
    public static final String PATIENTS     = DATA + "patients.json";
    public static final String APPOINTMENTS = DATA + "appointments.json";
  }
  
  public static final String DATE_FORMAT                                     = "dd-MM-yyyy";
  public static final String APPOINTMENT_BOOKED_SUCCESSFULLY                 = "Appointment booked successfully";
  public static final String FAILED_TO_FIND_THE_REQUESTED_DOCTOR_IN_THE_SLOT = "Failed to find the requested doctor in the slot";
  public static final String THIS_SLOT_IS_FULL                               = "This slot is full.";
  public static final String FAILED_TO_SAVE_CHANGES = "Failed to save changes";

}
