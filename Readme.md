Este es un proyecto realizado con Java 21 y Spring Boot 3
Consiste en una API CRUD que contiene los siguientes Endpoints:
- [POST] /products/add - Agrega un nuevo producto mediante un body request
- [DELETE] /products/delete - Elimina el producto si existe
- [GET] /products/get/{id} - Obtiene el producto por id
- [GET] /products  -  Obtiene todos los productos
- [PUT] /products/put/{id} - Actualiza un producto existente mediante el id y un body request con los campos a actualizar

<img src="https://raw.githubusercontent.com/sandyva88/enITmaCrud/refs/heads/main/assets/enITma%20Flowchart.png"> 

Requerido:
- Maven
- Java 21
- Repositorio : https://github.com/sandyva88/enITmaCrud.git

¿Còmo inicializarlo?

1.- Ejecutar el siguiente comando para instalar dependencias :

`mvn clean install`

2.- Usar el siguiente comando para inicializar Spring

`mvnw spring-boot:run      ` # En Windows

3.- De igual forma puedes ejecutar el Dockerfile encontrado en la carpeta raiz:

`docker build -t enitma-crud . `

`docker run -p 8080:8080 enitma-crud`



