# Servicios Web XPN

Comandos para ejecutar el servicio:

	$ cd xpn/
	$ ./mvnw spring-boot:run

Pasos para probarlo:

	- Conectarse a localhost:8080 desde un navegador o hacer petición GET a:
		/factura -> devuelve el identificador y un precio (75 
			    por defecto)
		/envio?paquete= -> Devuelve el identificador y la fecha en la 
				   que se generó, recibe parámetro como 
				   paquete pero de momento no hace nada con él
