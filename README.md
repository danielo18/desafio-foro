<h1 align="center"> Challenge Foro  </h1>

<p>Este proyecto es realizado por un servidor Daniel Lopez con el propocito de poner en practica los conocimientos adquiridos en los cursos de Alura Practicando Spring Framework: Challenge Foro Hub </p>

<p>Se trata de un API REST para un foro con funcionalidades como Autenticación de usuarios, crear topicos mostrar los topicos ya sea todos o uno en especifico, modificar los topicos y eliminar los topicos.
Las funcionalidades se describen a continuacion utilizando la herramiente INSOMNIA para generar los ENDPOINTS para simular las peticiones de usuarios</p>


## :hammer:Funcionalidades del proyecto

- `AUTENTICACION DE USUARIOS`: Con la generación de JWT tokens y con sesion STATLESS se hace la autenticacion de los usuarios.
  <img width="935" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/bcc0c88d-d0d5-48b2-bac0-32e1cb60059e">

  - `VALIDACIONES`:Debe de estar el usuario en la base de datos para poder autenticarnos .

- `INGRESAR UN TOPICO`:Se obtiene la información del topico para ingresarlo a la base de datos.
  <img width="938" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/992b162c-d600-4b57-bfe2-d817fd1bfbfc">

    - `VALIDACIONES`:Se valida que todos los campos son obligatorios y que ni el titulo ni el mensaje pueden ser igual a uno ya registrado en la base de datos.
      <img width="935" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/166b060d-3e08-4b6d-9cdc-73da1e9accef">
      <img width="936" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/5d13275b-d2a7-484f-a1cb-279750ac6ee9">

- `MOSTRAR TOPICOS`: Se muestra la información de todos los topicos con status activo. Se muestran con paginacion de 10 elementos.
    <img width="938" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/23a0c059-f79a-4ff8-b5ec-a9c9691ffed9">

- `MOSTRAR TOPICOS EN ESPECIFICO`: Se muestra la información del topico solicitado por el id.
    <img width="936" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/548732a2-7ab1-4329-b67a-79bce78517ce">

    - `VALIDACIONES`:Se valida que el id que se proporciona este en la base de datos.
      <img width="934" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/db950b43-e1a3-4947-b2cf-241369c0e22c">

- `ACTUALIZAR TOPICOS`: Se obtiene la informacion del topico a actualizar
  <img width="928" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/e650d9b4-fb76-460a-aa78-f80100356f1b">

    - `VALIDACIONES`:Se valida que id del topico a actualizar exista en la base de datos
      <img width="937" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/d3c4fd4b-42e6-4369-8dc9-e1cd27d686fc">

 - `ELIMINAR TOPICOS`: Se procede a eliminiar (logico) el topico por el id que se proporciona.
  <img width="939" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/e8000f79-adce-4651-a28d-8a1b971c181c">

   - `VALIDACIONES`:Se valida que id del topico a eliminiar exista en la base de datos
    <img width="934" alt="image" src="https://github.com/danielo18/desafio-foro/assets/163361063/8128dfc3-100e-478b-ba74-5cf09aace60f">


