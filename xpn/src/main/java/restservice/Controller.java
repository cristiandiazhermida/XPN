package restservice;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

 
    // Recibirá los datos del remitente y del destinatario
	// Devolverá el código de seguimiento, cadena alfanumérica de 8 caracteres
	// También devolverá la fecha y la hora en la que el mensajero acudirá al domicilio	
	@RequestMapping("/envio")
	public Envio envio(
			@RequestParam(value="nombreRemitente") String nombreRemitente,
			@RequestParam(value="apellido1Remitente") String apellido1Remitente,
			@RequestParam(value="apellido2Remitente") String apellido2Remitente,
			@RequestParam(value="emailRemitente") String emailRemitente,
			@RequestParam(value = "telfRemitente") String telfRemitente,
			@RequestParam(value = "direccionPostalRemitente") String direccionRemitente,
			@RequestParam(value="nombreDestinatario") String nombreDestinatario,
			@RequestParam(value="apellido1Destinatario") String apellido1Destinatario,
			@RequestParam(value="apellido2Remitente") String apellido2Destinatario,
			@RequestParam(value="emailRemitente") String emailDestinatario,
			@RequestParam(value = "telfRemitente") String telfDestinatario,
			@RequestParam(value = "direccionPostalDestinatario") String direccionDestinatario
			) {
		
		Cliente remitente = crearCliente(nombreRemitente, 
				apellido1Remitente, apellido2Remitente, emailRemitente,
				telfRemitente, direccionRemitente);
		Cliente destinatario = crearCliente(nombreDestinatario, 
				apellido1Destinatario, apellido2Destinatario, emailDestinatario,
				telfDestinatario, direccionDestinatario);
	
		// Imprimimos los datos recibidos
		System.out.println("Datos recibidos en envío. \n");
		System.out.println("Datos remitente: " + remitente.toString());
		System.out.println("Datos destinatario: " + destinatario.toString());
		System.out.println("\n");
		
		// Devolvemos el envío
		Envio e = new Envio();
		Random rand = new Random();
		int leftLimit = 48; // Caracter '0'
	    int rightLimit = 122; // Letra 'z'
	    int targetStringLength = 8; // Cadena final de 8 caracteres
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    while (buffer.length() <= targetStringLength) {
	        int randomLimitedInt = leftLimit + (int) 
	          (rand.nextFloat() * (rightLimit - leftLimit + 1));
	        if  (randomLimitedInt <= 57) {
	        	buffer.append((char) randomLimitedInt);
	        } else if (randomLimitedInt >= 65 && randomLimitedInt <= 90)  {
	        	buffer.append((char) randomLimitedInt);
	        } else if (randomLimitedInt >= 97){
	        	buffer.append((char) randomLimitedInt);
	        }
	    }
	    String generatedString = buffer.toString();
	    // Debe devolver la fecha en la que el técnico irá a recoger el paquete
	    // por lo que la ponemos una semana más tarde de la fecha actual
	    Instant i = Instant.now();
	    Instant inst = i.plus(Period.ofDays(7));
	    
	    e.setIdentificador(generatedString);
	    e.setFecha(inst);
		return e;
	}
	
	// Factura tiene que recibir los datos del cliente y del destinatario
	// Devolverá, el número de factura, la fecha en la que se generó y el precio desglosado (21% IVA)
	@RequestMapping("/factura")
	public Factura factura(
			@RequestParam(value="nombreRemitente") String nombreRemitente,
			@RequestParam(value="apellido1Remitente") String apellido1Remitente,
			@RequestParam(value="apellido2Remitente") String apellido2Remitente,
			@RequestParam(value="emailRemitente") String emailRemitente,
			@RequestParam(value = "telfRemitente") String telfRemitente,
			@RequestParam(value = "direccionPostalRemitente") String direccionRemitente,
			@RequestParam(value="nombreDestinatario") String nombreDestinatario,
			@RequestParam(value="apellido1Destinatario") String apellido1Destinatario,
			@RequestParam(value="apellido2Remitente") String apellido2Destinatario,
			@RequestParam(value="emailRemitente") String emailDestinatario,
			@RequestParam(value = "telfRemitente") String telfDestinatario,
			@RequestParam(value = "direccionPostalDestinatario") String direccionDestinatario
			) {
		
		Cliente remitente = crearCliente(nombreRemitente, 
				apellido1Remitente, apellido2Remitente, emailRemitente,
				telfRemitente, direccionRemitente);
		Cliente destinatario = crearCliente(nombreDestinatario, 
				apellido1Destinatario, apellido2Destinatario, emailDestinatario,
				telfDestinatario, direccionDestinatario);
	
		// Imprimimos los datos recibidos
		System.out.println("Datos recibidos en factura. \n");
		System.out.println("Datos remitente: " + remitente.toString());
		System.out.println("Datos destinatario: " + destinatario.toString());
		System.out.println("\n");
		// Devolvemos la factura
		Factura f = new Factura();
		Random rand = new Random();
		long id = rand.nextLong();
		while (id < 0) {
			id = rand.nextLong();
		}
		f.setIdentificador(id);
		return f;
	}
	
	/**
	 * Método privado para probar clientes
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param email
	 * @param telf
	 * @param direccionPostal
	 * @return
	 */
	private Cliente crearCliente(String nombre, String apellido1, String apellido2, 
			String email, String telf, String direccionPostal) {
		return new Cliente(nombre, apellido1, apellido2, email, telf, direccionPostal);
	}
}
