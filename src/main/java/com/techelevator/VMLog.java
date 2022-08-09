package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class VMLog {
    private static String LOG_FILE = "log.txt";

    public static void log(String message) {
        File file = new File(LOG_FILE);
        try(PrintWriter out = new PrintWriter(new FileOutputStream(file, true))) {
            out.printf("%tD %tr %s%n", LocalDate.now(), LocalTime.now(), message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
