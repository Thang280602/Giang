package com.project.sportstore.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "productName")
	private String productName;
	@Column(name = "size")
	private String size;
	@Column(name = "material")
	private String material;
	@Column(name = "price")
	private Double price;
	@Column(name = "image")
	private String image;
	
	@Column(name = "description",length=4000)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "categoryId",referencedColumnName = "id")
	private Category category;
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	private Set<ImageProduct> imageProduct;

	public Product() {
		super();
	}

	public Product(Integer id, String productName, String size, String material, Double price, String image, String description, Category category, Set<ImageProduct> imageProduct) {
		this.id = id;
		this.productName = productName;
		this.size = size;
		this.material = material;
		this.price = price;
		this.image = image;
		this.description = description;
		this.category = category;
		this.imageProduct = imageProduct;
	}

	public Product(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<ImageProduct> getImageProduct() {
		return imageProduct;
	}



	public void setImageProduct(Set<ImageProduct> imageProduct) {
		this.imageProduct = imageProduct;
	}


	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", productName='" + productName + '\'' +
				", size='" + size + '\'' +
				", material='" + material + '\'' +
				", price=" + price +
				", image='" + image + '\'' +
				", description='" + description + '\'' +
				", category=" + category +
				", imageProduct=" + imageProduct +
				'}';
	}
}
