package com.t1.class06.task01;

import java.io.IOException;
import java.util.UUID;

public class Buyer extends User implements Comparable<Buyer> {
    String id, fio, phoneNumber;

    private void checkFio(String fio) throws IOException {
        String fioRegex = "[А-яЁё\\-]+\\s+[А-яЁё\\-]+\\s+[А-яЁё\\-]+";
        if (!fio.matches(fioRegex)) {
            throw new IOException("Некорректный формат ФИО");
        }
    }

    private void checkPhoneNumber(String phoneNumber) throws IOException {
        String phoneNumberRegex = "^(\\s*)?(\\+)?([- _():=+]?\\d[- _():=+]?){10,14}(\\s*)?$";
        if (!phoneNumber.matches(phoneNumberRegex)) {
            throw new IOException("Некорректный формат номера телефона");
        }
    }

    private void checkLogin(String login) throws IOException {
        String loginRegex = "[A-Za-z\\d\\_]{4,32}";
        if (!login.matches(loginRegex)) {
            throw new IOException("Некорректный формат логина");
        }
    }

    private void checkPassword(String password) throws IOException {
        String passwordRegex = "[A-Za-z\\d_*.!@#$%^&(){}\\[\\]:;<>,.?/~_+\\-=|]{8,32}";
        if (!password.matches(passwordRegex)) {
            throw new IOException("Некорректный формат пароля");
        }
    }

    public Buyer(String fio, String login, String password, String phoneNumber) throws IOException {
        checkFio(fio);
        checkPhoneNumber(phoneNumber);
        checkLogin(login);
        checkPassword(password);
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        super.login = login;
        super.setPassword(password);
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }

    @Override
    public int compareTo(Buyer buyer) {
        return this.fio.compareToIgnoreCase(buyer.fio);
    }

    @Override
    public String toString() {
        return id + ";" + fio + ";" + login + ";" + phoneNumber;
    }
}
