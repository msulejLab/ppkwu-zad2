package pl.ppkwu.zad.api;


public interface FileLibraryAPI {

    void writeToFile(String fileName, String correctString, String wrongString);

    void setExitCallback(ExitCallback exitCallback);
}
