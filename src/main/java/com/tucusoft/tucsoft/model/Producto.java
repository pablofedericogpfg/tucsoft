package com.tucusoft.tucsoft.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "productos")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "usuario")
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private double precioCosto;
    private double precio;
    private double cantidad;
    private String estado;
    private Integer idproducto; 
    private double descuento;
    private Integer idrubro;
    private Integer idmarca;
    private Integer idproveedo;
    //private Integer usuario_id;
    

   @ManyToOne
	private Usuario usuario;
    public double getPrecioFinal() {
        return precio - (precio * descuento / 100.0);
    }
    
}
