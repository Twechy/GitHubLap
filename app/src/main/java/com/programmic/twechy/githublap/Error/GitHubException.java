package com.programmic.twechy.githublap.Error;

import java.io.IOException;

class GitHubException extends IOException {

    private int responseCode;
    private String message;

    public GitHubException(int code, String message) {
        this.responseCode = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getResponseCode() {
        return responseCode;
    }
}
