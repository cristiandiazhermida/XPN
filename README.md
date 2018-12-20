# Servicios Web XPN

Comandos para ejecutar el servicio:

	$ cd xpn/
	$ ./mvnw spring-boot:run

Pasos para probarlo:

	- Conectarse a localhost:8080 desde un navegador o hacer petición GET a:
		/factura -> devuelve el identificador y a fecha de creación
		/envio -> Devuelve el identificador y la fecha en la 
				   que se recibirá el envío, por defecto una 
				   semana después de la de creación.

Ambos mappings reciben como parámetro todos los datos del remitente y
del destinatario:
	- nombreX
	- apellido1X
	- apellido2X
	- emailX
	- telfX
	- direccionPostalX

donde X = remitente, destinatario
