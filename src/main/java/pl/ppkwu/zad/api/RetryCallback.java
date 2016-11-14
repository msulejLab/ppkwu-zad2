package pl.ppkwu.zad.api;

import java.util.concurrent.Callable;

public interface RetryCallback extends Callable<Boolean> {

    Boolean call();

    void setResult(boolean result);
}
