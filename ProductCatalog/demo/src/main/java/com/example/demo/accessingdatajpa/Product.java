package com.example.demo.accessingdatajpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {

  @Id
  // @GeneratedValue(strategy = GenerationType.AUTO)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
  @SequenceGenerator(name = "product_generator", sequenceName = "product_seq", allocationSize = 50)
  private Long productId;

  // @JsonProperty("categoryId")
  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "categoryId", nullable = false, updatable = false,
  // insertable = false)
  // @NotNull
  // @JsonUnwrapped
  // @JsonIgnoreProperties("name")
  // private Category category;

  // public Category getCategory() {
  // return category;
  // }

  // public void setCategory(Category category) {
  // this.category = category;
  // }

  // @Column(nullable = true)
  // private Long categoryId;

  // public Product(String name, String description, Category category, Long
  // stock, Float price,
  // Boolean active) {
  // // this.productId = productId;
  // this.name = name;
  // this.description = description;
  // this.category = category;
  // this.stock = stock;
  // this.price = price;
  // this.active = active;
  // }

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private Long categoryId;

  @Column
  private Long stock;

  @Column
  private Float price;

  @Column
  private Boolean active;

  protected Product() {
  }

  public Product(String name, String description, Long categoryId, Long stock, float price, boolean active) {
    this.name = name;
    this.description = description;
    this.categoryId = categoryId;
    this.stock = stock;
    this.price = price;
    this.active = active;
  }

  public Long getId() {
    return productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getStock() {
    return stock;
  }

  public void setStock(Long stock) {
    this.stock = stock;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

}