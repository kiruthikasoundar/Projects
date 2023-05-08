package com.skillstorm.projects.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.skillstorm.projects.dtos.InventoryDto;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id")
    private long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "warehouse_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Warehouse warehouse;

    @Column
    private Integer quantity;
    
    

	public Inventory() {
		super();
	}

	public Inventory(long id, Product product, Warehouse warehouse, Integer quantity) {
		super();
		this.id = id;
		this.product = product;
		this.warehouse = warehouse;
		this.quantity = quantity;
	}
	
	public Inventory(Product product, Warehouse warehouse, Integer quantity) {
		super();		
		this.product = product;
		this.warehouse = warehouse;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**

	Converts the Inventory object to a InventoryDto object.
	@return The InventoryDto object.
	*/
	public InventoryDto toDto() {
		return new InventoryDto(id, product.getId(), warehouse.getId(), quantity, product.getName());
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(id, other.id);
	}

     
    


}
