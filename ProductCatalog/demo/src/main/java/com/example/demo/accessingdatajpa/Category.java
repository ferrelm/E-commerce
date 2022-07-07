package com.example.demo.accessingdatajpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {

  @Id
  // @GeneratedValue(strategy = GenerationType.AUTO)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
  @SequenceGenerator(name = "category_generator", sequenceName = "category_seq", allocationSize = 50)
  private Long categoryId;

  // @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
  // private List<Product> product;

  // public Category(Long categoryId, List<Product> product, String name) {
  // this.categoryId = categoryId;
  // this.product = product;
  // this.name = name;
  // }

  // public List<Product> getProduct() {
  // return product;
  // }

  // public void setProduct(List<Product> product) {
  // this.product = product;
  // }

  @Column
  private String name;

  protected Category() {
  }

  // Constructor
  public Category(String name) {
    this.name = name;
  }

  public Long getId() {
    return categoryId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}