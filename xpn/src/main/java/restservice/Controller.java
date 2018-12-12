package restservice;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    // Recibirá los datos del envío y devolverá el código de seguimiento y la fecha
	@RequestMapping("/envio")
	public Envio envio(@RequestParam(value="paquete") String paquete) {
		Envio e = new Envio();
		Random rand = new Random();
		e.setIdentificador(rand.nextLong());
		return e;
	}
	
	@RequestMapping("/factura")
	public Factura factura() {
		Factura f = new Factura();
		Random rand = new Random();
		f.setIdentificador(rand.nextLong());
		// El precio deberíamos recibirlo de bonita
		f.setPrecio(new BigDecimal("75"));
		return f;
	}
}
