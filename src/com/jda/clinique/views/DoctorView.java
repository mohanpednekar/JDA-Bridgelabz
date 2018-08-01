package com.jda.clinique.views;

import com.jda.clinique.controllers.DoctorViewController;
import com.jda.clinique.services.FileSystemService;

public class DoctorView {
  DoctorViewController doctorViewController;
  FileSystemService    fileSystemService;
  
  public DoctorView(DoctorViewController doctorViewController, FileSystemService fileSystemService) {
    this.doctorViewController = doctorViewController;
    this.fileSystemService = fileSystemService;
  }
  
  public void show() {
    // TODO Auto-generated method stub

  }

}
