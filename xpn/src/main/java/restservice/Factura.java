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
	
	private Instant fechaCreacion;
	
	public Factura() {
		super();
		this.fechaCreacion = Instant.now();
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public Instant getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Instant fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Factura [identificador=" + identificador + ", fechaCreacion=" + fechaCreacion + "]";
	}
}
