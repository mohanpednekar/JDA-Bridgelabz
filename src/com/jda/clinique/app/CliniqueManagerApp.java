package com.jda.clinique.app;

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
    doctorViewController = new DoctorViewController();
    insightsViewController = new InsightsViewController();
    patientViewController = new PatientViewController();
    doctorView = new DoctorView(doctorViewController, fileSystemService);
    insightsView = new InsightsView(insightsViewController, fileSystemService);
    patientView = new PatientView(patientViewController, fileSystemService);
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
        doctorView.show();
        break;
      case INSIGHTS:
        insightsView.show();
        break;
      case PATIENT:
        patientView.show();
        break;
      case QUIT:
        quit();
        break;

    }
  }

  private void quit() {
    System.out.println("Housekeeping...");
    System.out.println("done.");
    System.out.println("Bye..");
  }

}
