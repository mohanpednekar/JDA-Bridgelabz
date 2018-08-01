package com.jda.clinique.views;

import com.jda.clinique.controllers.InsightsViewController;
import com.jda.clinique.services.FileSystemService;

public class InsightsView {
  InsightsViewController insightsViewController;
  FileSystemService      fileSystemService;
  
  public InsightsView(InsightsViewController insightsViewController, FileSystemService fileSystemService) {
    this.insightsViewController = insightsViewController;
    this.fileSystemService = fileSystemService;
  }
  
  public void show() {
    // TODO Auto-generated method stub

  }

}
