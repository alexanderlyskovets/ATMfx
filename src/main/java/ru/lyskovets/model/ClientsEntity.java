package ru.lyskovets.model;

import javax.persistence.*;

@Entity
@Table(name = "clients", schema = "public", catalog = "atm")
public class ClientsEntity {
    private String cardinfoId;
    private String name;
    private long id;
    private CardinfoEntity cardinfoByCardinfoId;

    @Basic
    @Column(name = "cardinfo_id", nullable = false, length = 64)
    public String getCardinfoId() {
        return cardinfoId;
    }

    public void setCardinfoId(String cardinfoId) {
        this.cardinfoId = cardinfoId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 150)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (id != that.id) return false;
        if (cardinfoId != null ? !cardinfoId.equals(that.cardinfoId) : that.cardinfoId != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = cardinfoId != null ? cardinfoId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cardinfo_id", referencedColumnName = "account", nullable = false)
    public CardinfoEntity getCardinfoByCardinfoId() {
        return cardinfoByCardinfoId;
    }

    public void setCardinfoByCardinfoId(CardinfoEntity cardinfoByCardinfoId) {
        this.cardinfoByCardinfoId = cardinfoByCardinfoId;
    }
}
