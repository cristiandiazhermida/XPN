package restservice;

import java.io.Serializable;
import java.math.BigDecimal;

public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6007478114846834193L;

	private long identificador;

	private BigDecimal precioTotal;
	
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
		return precioTotal;
	}

	public void setPrecio(BigDecimal precio) {
		this.precioTotal = precio;
	}

	public BigDecimal getPrecioDesglosado() {
		BigDecimal precio = new BigDecimal(0);
		final BigDecimal IVA = new BigDecimal(1.21);
		//precio = this.getPrecio().divide(IVA);
		precio = new BigDecimal(this.getPrecio().longValueExact()/IVA.longValue());
		return precio;
		
	}

	@Override
	public String toString() {
		return "Factura [identificador=" + identificador + ", precioTotal=" + precioTotal + ", IVA = 21%, precioDesglosado="
				+ getPrecioDesglosado() + "]";
	}
	
	
}
