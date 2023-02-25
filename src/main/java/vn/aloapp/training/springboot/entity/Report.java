package vn.aloapp.training.springboot.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Report {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	private String date;
	
	private BigDecimal amountImport;
	private BigDecimal amountExport;
	private BigDecimal profit;
	private BigDecimal inventory;
	
	
}
