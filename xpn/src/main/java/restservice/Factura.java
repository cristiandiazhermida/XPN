package restservice;

import java.io.Serializable;
import java.math.BigDecimal;

public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6007478114846834193L;

	private long identificador;

	private BigDecimal precio;
	
	public Factura() {
		super();
	}
	
	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Factura [identificador=" + identificador + ", precio=" + precio + "]";
	}
}
