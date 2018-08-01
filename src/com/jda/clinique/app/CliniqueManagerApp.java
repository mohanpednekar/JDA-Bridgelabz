package com.jda.clinique.app;

import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.jda.clinique.controllers.DoctorViewController;
import com.jda.clinique.controllers.InsightsViewController;
import com.jda.clinique.controllers.PatientViewController;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.util.Enums.MainMenu;
import com.jda.clinique.util.Reader;
import com.jda.clinique.views.DoctorView;
import com.jda.clinique.views.InsightsView;
import com.jda.clinique.views.PatientView;

public class CliniqueManagerApp {
  private FileSystemService      fileSystemService;
  private DoctorView             doctorView;
  private InsightsView           insightsView;
  private PatientView            patientView;
  private DoctorViewController   doctorViewController;
  private InsightsViewController insightsViewController;
  private PatientViewController  patientViewController;
  
  public CliniqueManagerApp() {
    fileSystemService = new FileSystemService();
  }
  
  public static void main(String[] args) {
    CliniqueManagerApp app = new CliniqueManagerApp();
    app.execute();
  }
  
  private void execute() {
    System.out.println("Welcome to JDA Clinique");
    Reader reader = new Reader();
    MainMenu menuItem = reader.requestInputEnum("Enter screen name : ", MainMenu.class);
    switch (menuItem) {
      case DOCTOR:
        if (doctorViewController == null) {
          try {
            doctorViewController = new DoctorViewController();
            doctorView = new DoctorView(doctorViewController, fileSystemService);
            doctorView.show();
          } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.println("Something went wrong. Did you check whether Doctors data file is readable?");
          }
        } else {
          doctorView.show();
        }
        break;
      case INSIGHTS:
        if (insightsViewController == null) {
          try {
            insightsViewController = new InsightsViewController();
            insightsView = new InsightsView(insightsViewController, fileSystemService);
            insightsView.show();
          } catch (Exception e) {
            System.out.println("Something went wrong. Did you check whether the Appointments data is readable?");
          }
        } else {
          insightsView.show();
        }
        break;
      case PATIENT:
        if (patientViewController == null) {
          try {
            patientViewController = new PatientViewController();
            patientView = new PatientView(patientViewController, fileSystemService);
            patientView.show();
          } catch (Exception e) {
            System.out.println("Something went wrong. Did you check whether Patients data file is readable?");
          }
        } else {
          patientView.show();
        }
        break;
      case QUIT:
        quit();
        break;

    }

  }

  private void quit() {
    System.out.println("Housekeeping...");
    // GUI housekeeping work... Nothing here..
    System.out.println("done.");
    System.out.println("Bye..");
  }

}
