package pl.ppkwu.zad.api;

public interface FileLibrary {

    void writeToFile(String correctString, String wrongString, String fileName);

    void setRetryCallback(RetryCallback retryCallback);
}
