package lastlife.ecommerce.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_header")
	private String productHeader;
	
	@Column(name="unit_price")
	private int unitPrice;
	
	@Column(name="units_in_stock")
	private int unitsInStock;
	
	@Column(name="product_comment")
	private String productComment;
	
	@ManyToOne
	@JoinColumn(name = "subcategories_subcategory_id")
	private SubCategory subCategory;
	
	@Column(name="product_brand")
	private String productBrand;
	
}
