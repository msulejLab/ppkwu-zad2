package pl.ppkwu.zad.impl;

import pl.ppkwu.zad.api.FileLibrary;
import pl.ppkwu.zad.api.RetryCallback;

import java.io.File;
import java.io.IOException;

public class FileLibraryImpl implements FileLibrary {

    private static final String FORMAT = ".txt";
    private static final String HELLO_WORLD = "Hello world!";

    private RetryCallback retryCallback;

    public void writeToFile(String fileName, String correctString, String wrongString) {
        File file = new File(fileName + "." + FORMAT);

        try {
            file.createNewFile();
            IOUtils.writeToFile(file, HELLO_WORLD);
            System.out.println(correctString);

            retryCallback.setResult(true);
        } catch (IOException e) {
            retryCallback.setResult(false);
            System.out.println(wrongString);
        }
    }

    private void performFileOperations() {
        String fileName = IOUtils.getInput("Nazwa pliku");
        String correctString = IOUtils.getInput("Poprawny string");
        String wrongString = IOUtils.getInput("Niepoprawny string");

        try {
            writeToFile(fileName, correctString, wrongString);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void setRetryCallback(RetryCallback retryCallback) {
        this.retryCallback = retryCallback;
    }
}
