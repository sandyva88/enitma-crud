package com.enitma.CRUD.models.response;

import lombok.Data;

import java.util.Date;


@Data
public class AddProductResponse {

    private int idProduct;

    private String name;

    private int price;

    private Date creationDate;

    private Date editDate;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AddProductResponse{");
        sb.append("idProduct=").append(idProduct);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", editDate=").append(editDate);
        sb.append('}');
        return sb.toString();
    }
}


