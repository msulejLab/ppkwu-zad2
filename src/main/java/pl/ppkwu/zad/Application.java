package pl.ppkwu.zad;

import pl.ppkwu.zad.api.FileLibrary;
import pl.ppkwu.zad.api.RetryCallback;
import pl.ppkwu.zad.impl.FileLibraryImpl;
import pl.ppkwu.zad.impl.IOUtils;
import pl.ppkwu.zad.impl.RetryCallbackImpl;

public class Application {

    private static RetryCallback retryCallback;
    private static FileLibrary fileLibrary;

    public static void main(String[] args) throws Exception {
        retryCallback = new RetryCallbackImpl();
        fileLibrary = new FileLibraryImpl();
        fileLibrary.setRetryCallback(retryCallback);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("Shutdown hook:");
                performFileOperations();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));

        performFileOperations();
    }

    private static void performFileOperations() throws Exception {
        String correctString = IOUtils.getInput("Poprawny string");
        String wrongString = IOUtils.getInput("Zly string");
        String fileName = IOUtils.getInput("Nazwa pliku");

        fileLibrary.writeToFile(fileName, correctString, wrongString);
    }
}