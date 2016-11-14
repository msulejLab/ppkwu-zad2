package pl.ppkwu.zad.impl;

import pl.ppkwu.zad.api.ExitCallback;

public class ExitCallbackImpl implements ExitCallback {

    public Boolean call() {
        String input = IOUtils.getInput("Czy napewno chcesz zamknac aplikacje? [y/n]");
        return input.equalsIgnoreCase("y");
    }
}
