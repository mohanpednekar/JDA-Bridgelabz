package com.jda.clinique.views;

import com.jda.clinique.controllers.DoctorViewController;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.util.Enums.DoctorMenu;
import com.jda.clinique.util.Reader;

public class DoctorView {
  DoctorViewController doctorViewController;
  FileSystemService    fileSystemService;
  
  public DoctorView(DoctorViewController doctorViewController, FileSystemService fileSystemService) {
    this.doctorViewController = doctorViewController;
    this.fileSystemService = fileSystemService;
  }
  
  public void show() {
    Reader reader = new Reader();
    while (true) {
      boolean done = false;
      DoctorMenu menuItem = reader.requestInputEnum("What do you want to do?", DoctorMenu.class);
      switch (menuItem) {
        case BOOK:
          doctorViewController.bookAppointment();
          break;
        case SEARCH:
          doctorViewController.searchDoctors();
          break;
        case ADD:
          doctorViewController.addDoctor();
          break;
        case BACK:
          done = true;
          doctorViewController.openMainMenu();
          break;
        case REMOVE:
          doctorViewController.removeDoctor();
          break;
      }
      if (done) {
        break;
      }
    }
  }

}
