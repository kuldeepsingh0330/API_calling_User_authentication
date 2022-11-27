package com.ransankul.apicalling.ModelResponse;


public class LoginResponse {

    Form form;
    String error;
    String message;

    public LoginResponse(Form form, String error, String message) {
        this.form = form;
        this.error = error;
        this.message = message;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
