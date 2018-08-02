package com.jda.clinique.util;

public class Enums {
  public enum AppointmentSlot {
    AM, PM, BOTH
  }

  public enum MainMenu {
    DOCTOR, PATIENT, INSIGHTS, QUIT;
  }
  
  public enum PatientMenu {
    SEARCH, ADD, REMOVE, SHOWALL, BACK
  }
  
  public enum DoctorMenu {
    SEARCH, BOOK, ADD, REMOVE, SHOWALL, BACK
  }
  
  public enum InsightsMenu {
    POPULARDOCTOR, POPULARSPECIALISATION, BACK
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
