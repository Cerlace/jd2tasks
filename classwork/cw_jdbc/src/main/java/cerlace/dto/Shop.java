package cerlace.dto;

import cerlace.orm.annotations.Column;
import cerlace.orm.annotations.Id;
import cerlace.orm.annotations.Table;

@Table(name = "shops")
public class Shop {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "address")
    private String address;

    public Shop() {
    }

    public Shop(int id, String address) {
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
