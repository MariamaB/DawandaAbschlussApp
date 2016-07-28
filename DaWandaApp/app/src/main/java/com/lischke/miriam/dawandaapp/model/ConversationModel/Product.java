package com.lischke.miriam.dawandaapp.model.ConversationModel;

import com.lischke.miriam.dawandaapp.model.Price;

/**
 * Created by Miriam on 13.07.2016.
 */
public class Product {

    private int id;
    Price price;
    private String title;
    private String image;



    public Product() {
    }


    public int getProductId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price.toString() +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
