package restservice;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Instant;

public class Factura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6007478114846834193L;

	private long identificador;

	private BigDecimal precioTotal;

	private BigDecimal precioDesglosado;
	
	private Instant fechaCreacion;
	
	public Factura() {
		super();
		this.fechaCreacion = Instant.now();
	}
	
	public Factura(long identificador, BigDecimal precioTotal, Instant fechaCreacion) {
		super();
		this.identificador = identificador;
		this.precioTotal = precioTotal;
		this.precioDesglosado = precioTotal.divide(new BigDecimal(1.21));
		this.fechaCreacion = fechaCreacion;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public Instant getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Instant fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public BigDecimal getPrecioDesglosado() {
	
		double IVA = 1.21;
		double precio = precioTotal.doubleValue();
		double calculo = precio/IVA;
		
		precioDesglosado = new BigDecimal(calculo);
		
		return precioDesglosado.setScale(2, BigDecimal.ROUND_UP);
	}

	public void setPrecioDesglosado(BigDecimal precioDesglosado) {
		this.precioDesglosado = precioDesglosado;
	}

	@Override
	public String toString() {
		return "Factura [identificador=" + identificador + ", precioTotal=" + precioTotal + ", precioDesglosado="
				+ precioDesglosado + ", fechaCreacion=" + fechaCreacion + "]";
	}
}
