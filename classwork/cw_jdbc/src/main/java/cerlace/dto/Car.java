package cerlace.dto;

import cerlace.orm.annotations.Column;
import cerlace.orm.annotations.Id;
import cerlace.orm.annotations.Table;

@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "engine")
    private double engine;
    @Column(name = "color")
    private String color;
    @Column(name = "brand_id")
    private int brandId;
    @Column(name = "price")
    private int price;
    @Column(name = "shop_id")
    private int shopId;

    public Car() {
    }

    public Car(int id, String name, double engine, String color,
               int brandId, int price, int shopId) {
        this.id = id;
        this.name = name;
        this.engine = engine;
        this.color = color;
        this.brandId = brandId;
        this.price = price;
        this.shopId = shopId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
