package pl.ppkwu.zad.api;

import java.util.concurrent.Callable;

public interface ExitCallback extends Callable<Void> {

    Void call();
}
