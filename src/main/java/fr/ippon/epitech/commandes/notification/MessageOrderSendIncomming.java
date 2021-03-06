package fr.ippon.epitech.commandes.notification;

import java.io.Serializable;

public class MessageOrderSendIncomming implements Serializable {

    private String number;

    private String numeroColis;

    public MessageOrderSendIncomming(String number, String numeroColis) {
        this.number = number;
        this.numeroColis = numeroColis;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumeroColis() {
        return numeroColis;
    }

    public void setNumeroColis(String numeroColis) {
        this.numeroColis = numeroColis;
    }
}
