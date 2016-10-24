package pl.ppkwu.zad.api;

import java.util.concurrent.Callable;

public interface RetryCallback extends Callable<Boolean> {

    Boolean call() throws Exception;

    void setResult(boolean result);
}
