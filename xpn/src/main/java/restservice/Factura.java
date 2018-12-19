package restservice;

import java.io.Serializable;
import java.math.BigDecimal;

public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6007478114846834193L;

	private String identificador;

	private BigDecimal precioTotal;
	
	public Factura() {
		super();
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "Factura [identificador=" + identificador + ", precioTotal=" + precioTotal + "]";
	}
		
	
}
