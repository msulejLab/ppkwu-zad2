package pl.ppkwu.zad;

import pl.ppkwu.zad.api.ExitCallback;
import pl.ppkwu.zad.api.FileLibrary;
import pl.ppkwu.zad.api.RetryCallback;
import pl.ppkwu.zad.impl.ExitCallbackImpl;
import pl.ppkwu.zad.impl.FileLibraryImpl;
import pl.ppkwu.zad.impl.IOUtils;
import pl.ppkwu.zad.impl.RetryCallbackImpl;

public class Application {

    private static FileLibrary fileLibrary;
    private static RetryCallback retryCallback;
    private static ExitCallback exitCallback;

    public static void main(String[] args) {
        fileLibrary = new FileLibraryImpl();
        retryCallback = new RetryCallbackImpl();
        exitCallback = new ExitCallbackImpl();
        fileLibrary.setRetryCallback(retryCallback);

        initializeShutdownHook();

        performFileOperations();
    }

    private static void initializeShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("\nWykryto zdarzenie zamkniecia aplikacji");
                Boolean confirmExit = exitCallback.call();
                if (!confirmExit) {
                    System.out.println("Aplikacja zostanie kontynuowana");
                    performFileOperations();
                } else {
                    System.out.println("Aplikacja zostala zakonczona");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }

    private static void performFileOperations() {
        String correctMessage = IOUtils.getInput("Poprawny string");
        String wrongMessage = IOUtils.getInput("Niepoprawny string");
        String fileName = IOUtils.getInput("Nazwa pliku: ");

        fileLibrary.writeToFile(fileName, correctMessage, wrongMessage);

        boolean performAgain = retryCallback.call();
        if (performAgain) {
            performFileOperations();
        }
    }
}