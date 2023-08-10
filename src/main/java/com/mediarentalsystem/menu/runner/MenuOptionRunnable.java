package com.mediarentalsystem.menu.runner;

import com.mediarentalsystem.service.MediaService;
import com.mediarentalsystem.service.MediaServiceImpl;
import com.mediarentalsystem.utils.InputScanner;

import java.util.Scanner;

public interface MenuOptionRunnable {
    Scanner inputScanner = InputScanner.getInstance();
    MediaService mediaService = new MediaServiceImpl();

    void run();
}
