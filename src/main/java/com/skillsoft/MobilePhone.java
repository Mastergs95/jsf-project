package com.skillsoft;

public class MobilePhone {

    int id;
    String brandName;
    String productName;
    String os;
    int storageCapacity;
    int ram;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getBrandName(){
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }
}
