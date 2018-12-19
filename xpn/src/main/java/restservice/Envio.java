package restservice;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class Envio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179225064813742710L;
	private String identificador;
	private Instant fecha = Instant.now();

	public Envio() {
		super();

	}

	public Envio(String identificador, Instant fecha) {
		super();
		this.identificador = identificador;
		this.fecha = fecha;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Instant getFecha() {
		return fecha;
	}

	public void setFecha(Instant fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Envio [identificador=" + identificador + ", fecha=" + fecha + "]";
	}
	
	
}
