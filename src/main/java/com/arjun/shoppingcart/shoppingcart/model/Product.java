package com.arjun.shoppingcart.shoppingcart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private @NotNull String name;
    private @NotNull double price;



    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brand;

    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    public Product(String name, double price, Category category, Brand brand, String fileName, String fileType, byte[] data) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
}