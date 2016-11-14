package pl.ppkwu.zad.api;

public interface FileLibrary {

    void writeToFile(String fileName, String correctString, String wrongString);

    void setRetryCallback(RetryCallback retryCallback);
}
