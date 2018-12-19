package restservice;

import java.math.BigDecimal;
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
	public Envio envio() {//@RequestParam(value="remitente") Cliente remitente, 
			//@RequestParam(value="destinatario") Cliente destinatario) {
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
	 
	    e.setIdentificador(generatedString); 
		return e;
	}
	
	// Factura tiene que recibir los datos del cliente y del destinatario
	// Devolverá, el número de factura, la fecha en la que se generó y el precio desglosado (21% IVA)
	@RequestMapping("/factura")
	public Factura factura() {
		Factura f = new Factura();
		Random rand = new Random();
		long id = rand.nextLong();
		while (id < 0) {
			id = rand.nextLong();
		}
		f.setIdentificador("333");
		// El precio deberíamos recibirlo de bonita
		f.setPrecioTotal(new BigDecimal("75"));
		return f;
	}
}
