package ru.lyskovets.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cardinfo", schema = "public", catalog = "atm")
public class CardinfoEntity {
    private String account;
    private String pin;
    private String balance;
    private Collection<ClientsEntity> clientsByAccount;

    @Id
    @Column(name = "account", nullable = false, length = 64)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "pin", nullable = false, length = 64)
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Basic
    @Column(name = "balance", nullable = false, length = 30)
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardinfoEntity that = (CardinfoEntity) o;

        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (pin != null ? !pin.equals(that.pin) : that.pin != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + (pin != null ? pin.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cardinfoByCardinfoId")
    public Collection<ClientsEntity> getClientsByAccount() {
        return clientsByAccount;
    }

    public void setClientsByAccount(Collection<ClientsEntity> clientsByAccount) {
        this.clientsByAccount = clientsByAccount;
    }
}
