# UNIVERSIDAD TECNOLÓGICA NACIONAL

## FACULTAD REGIONAL ROSARIO

### *ASIGNATURA: "LENGUAJE DE PROGRAMACIÓN: JAVA"*

#### *TP1* - Curso Lectivo 2017

##### Equipo Docente
- Ing. Ricardo Tabacman
- Ing. Adrián Meca

##### ¿Qué se evalúa?
En función de los objetivos propuestos de la materia de **lenguaje de programación JAVA** se evaluará la **capacidad del alumno para aprender** y profundizar sus conocimientos en el lenguaje Java.

##### Operatoria

Se realizará en equipos de no más de 3 alumnos. En la solución se debe utilizar el concepto de programación en tres capas.

***Regularidad***

El sistema contará de 2 etapas:

1. Aplicación de escritorio con almacenamiento de la información en base de datos.
2. Aplicación web con almacenamiento de la información en base de datos.

La aplicación deberá desarrollarse en equipos utilizando un repositorio git usando un servidor gratuito, por ejemplo github.com, gitlab.com o bitbucket.com. Las entregas se harán enviando el link al repositorio indicando el tag en el repositorio correspondiente a la entrega.


***Promoción***
Inicialmente se expondrán las condiciones de regularidad y a continuación los adicionales de promoción. Cada adicional tiene un puntaje máximo, según la ejecución pueden otorgarse entre 0 y ese máximo.

Para promocionar deberá acumular 6 puntos mediante requerimientos de promoción y realizar una tercer entrega con los adicionales habiendo publicado el sistema en un servidor web gratuito.

##### Fechas de Entrega

- Etapa 1: TBD
- Etapa 2: TBD
- Etapa 3: TBD

##### Enunciado

Realizar el desarrollo del siguiente sistema de reservas. El mismo abarcará:

1. Gestión de personas que podrán realizar las reservas (people).
2. Gestión de tipo de elementos a reservar (bookable types).
3. Gestión de elementos a reservar (bookable items).
4. Gestión de reservas (booking).

Las partes que se explican a continuación son con el alcance del TP para regularizar. Al finalizar se encuantra la lista de adicionales para alcanzar la promoción.

###### Gestión de Personas
La gestión de personas incluye:
- ABMC de Personas con los siguientes datos:
  - id: autoincremental numérico generado por la DB.
  - datos personales: dni, nombre y apellido.
  - datos de usuario: usuario, contraseña y si está habilitado para ingresar al sistema o no.
- Acceso al sistema (login). ***Nota:*** *Ver adicional de promoción*

###### Gestión de tipo de elementos a reservar
La misma comprende ABMC de tipos de elementos con los siguientes datos:
  - id: autoincremental numérico generado por la DB.
  - nombre: texto corto, por ejemplo: proyector, cochera, notebook.
  - cantidad máximas de reservas pendientes: es la cantidad máxima de elementos de este tipo que cada usuario puede tener pendiente a futuro. ***Nota:*** *Ver adicional de promoción.*

###### Gestión de elementos a reservar
Comprende el ABMC de de los elementos a reservar con los siguientes datos:
  - id: autoincremental numérico generado por la DB.
  - nombre (opcional): texto corto para identificarlo de los demás elementos del mismo tipo.
  - tipo de elemento: debe elegirse de uno de los tipos creados

###### Gestión de Resevas
- Reservar un elemento: Para ello, una persona luego de loguearse podrá reservar algún elemento eligiendo el tipo, fecha y hora y podrá ver la lista de elementos disponibles de ese tipo disponibles, en ese horario, seleccionarlo y reservarlo. También podrán ingresar un detalle (texto plano).
- Ver sus reservas y cancelarlas: Una ves logueado una persona debe poder ver sus reservas pendientes (con fecha y hora posterior a la actual) y cancelarlas si lo decide.

###### Adicional para promoción
Para alcanzar la promoción a lo antes requerido se agregan los siguientes requerimientos, cada requerimiento tiene un puntaje que debe sumarse a la nota de regularidad si se lo cumple:
- Req 1: 2 puntos
  - Las personas deben tener una categoría (encargado, admin o usuario).
  - Los tipos de elementos pueden exigir que sólo un encargado pueda reserver elementos de dicho tipo.

- Req 2: 3.5 puntos
  - Los tipos de elementos pueden tener un límite máximo de tiempo de reserva (en horas) que debe controlarse durante la reserva.
  - Los tipos de elementos puden tener una cantidad máxima de días de anticipación para ser reservados.

- Req 3: 2.5 puntos
  - Los administradores son los únicos que pueden crear usuarios y tipos de elementos.
  - Los administradores son quienes pueden habilitar o deshabilitar usuarios.
  - Los administradores pueden anular cualquier reserva pendiente, por lo que deben poder ver todas las reservas disponibles.

- Req 4: 1 punto
  - Usar custom exceptions y log de errores.

- Req 5: 1 punto
  - Enviar emails para confirmar reservas, cancelaciones y anulaci