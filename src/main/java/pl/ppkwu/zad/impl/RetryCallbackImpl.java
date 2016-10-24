package pl.ppkwu.zad.impl;

import pl.ppkwu.zad.api.RetryCallback;

public class RetryCallbackImpl {

    private Boolean result = false;

    public Boolean call() {
        if (result) {
            String input = IOUtils.getInput("Sprobowac jeszcze raz? [y/n]");
            return input.equalsIgnoreCase("y");
        }

        return false;
    }
}
