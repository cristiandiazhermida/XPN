package restservice;

import java.io.Serializable;
import java.time.Instant;

public class Envio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179225064813742710L;
	private long identificador;
	private Instant fecha = Instant.now();

	public Envio() {
		super();

	}

	public Envio(long identificador, Instant instant) {
		super();
		this.identificador = identificador;
		this.fecha = instant;
	}

	public long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(long identificador) {
		this.identificador = identificador;
	}

	public Instant getFecha() {
		return fecha;
	}

	public void setFecha(Instant instant) {
		this.fecha = instant;
	}

	@Override
	public String toString() {
		return "Envio [identificador=" + identificador + ", fecha=" + fecha + "]";
	}


}
