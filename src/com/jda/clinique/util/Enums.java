package com.jda.clinique.util;

public class Enums {
  public enum AppointmentSlot {
    AM, PM, BOTH
  }
  
  public enum MainMenu {
    DOCTOR, PATIENT, INSIGHTS, QUIT;
  }

  public enum PatientMenu {

  }

  public enum DoctorMenu {

  }

  public enum InsightsMenu {

  }

  public static <T extends Enum<T>> String toStringAll(Class<T> menu) {
    return toStringAll(menu, " ");
  }
  
  public static <T extends Enum<T>> String toStringAll(Class<T> menu, String separator) {
    StringBuilder stringBuilder = new StringBuilder();
    for (T menuItem : menu.getEnumConstants()) {
      stringBuilder.append(menuItem).append(separator);
    }
    return stringBuilder.toString();
  }
}
