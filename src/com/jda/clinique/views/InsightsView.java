package com.jda.clinique.views;

import com.jda.clinique.controllers.InsightsViewController;
import com.jda.clinique.services.FileSystemService;
import com.jda.clinique.util.Enums.InsightsMenu;
import com.jda.clinique.util.Reader;

public class InsightsView {
  InsightsViewController insightsViewController;
  FileSystemService      fileSystemService;
  
  public InsightsView(InsightsViewController insightsViewController, FileSystemService fileSystemService) {
    this.insightsViewController = insightsViewController;
    this.fileSystemService = fileSystemService;
  }
  
  public void show() {
    Reader reader = new Reader();
    InsightsMenu menuItem = reader.requestInputEnum("What do you want to check?", InsightsMenu.class);
    switch (menuItem) {
      case POPULARDOCTOR:
        insightsViewController.showPopularDoctor();
        break;
      case POPULARSPECIALISATION:
        insightsViewController.showPopularSpecialisation();
        break;
    }
  }

}
