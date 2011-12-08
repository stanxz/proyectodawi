package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="distrito")
public class Distrito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="iddistrito")
	private int intIdDistrito;
	
	@Column(name="nomDis")
	private String strNombreDistrito;
	
	
	
	
	

}
