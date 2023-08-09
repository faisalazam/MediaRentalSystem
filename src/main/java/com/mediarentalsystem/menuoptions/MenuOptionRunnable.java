package com.mediarentalsystem.menuoptions;

import com.mediarentalsystem.service.MediaService;
import com.mediarentalsystem.service.MediaServiceImpl;
import com.mediarentalsystem.utils.InputScanner;

import java.util.Scanner;

public interface MenuOptionRunnable {
    final Scanner inputScanner = InputScanner.getInstance();
    final MediaService mediaService = new MediaServiceImpl();

    public void run();
}
