package com.jda.clinique.views;

import com.jda.clinique.controllers.PatientViewController;
import com.jda.clinique.services.FileSystemService;

public class PatientView {
  PatientViewController patientViewController;
  FileSystemService     fileSystemService;
  
  public PatientView(PatientViewController patientViewController, FileSystemService fileSystemService) {
    this.patientViewController = patientViewController;
    this.fileSystemService = fileSystemService;
  }
  
  public void show() {
    // TODO Auto-generated method stub

  }
}
