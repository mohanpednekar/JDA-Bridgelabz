package com.jda.clinique.views;

import com.jda.clinique.controllers.PatientViewController;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.util.Enums.PatientMenu;
import com.jda.clinique.util.Reader;

public class PatientView {
  PatientViewController patientViewController;
  FileSystemService     fileSystemService;

  public PatientView(PatientViewController patientViewController, FileSystemService fileSystemService) {
    this.patientViewController = patientViewController;
    this.fileSystemService = fileSystemService;
  }

  public void show() {
    Reader reader = new Reader();
    PatientMenu menuItem = reader.requestInputEnum("What do you want to do?", PatientMenu.class);
    switch (menuItem) {
      case SEARCH:
        patientViewController.searchPatients();
        break;
    }
  }
}