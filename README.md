# Trabajo Práctico N.º 1 — Paradigmas de Programación

**Alumno:** Franco Nicolás Baigorri
**Legajo:** 50730
**Institución:** Universidad Tecnológica Nacional — Facultad Regional Mendoza
**Lenguaje:** Java 21
**Entorno de desarrollo:** IntelliJ IDEA

## Descripción

Sistema de gestión de eventos universitarios desarrollado de forma progresiva en tres ejercicios.

El proyecto permite crear eventos, asignar salas, registrar actividades e inscribir estudiantes. En su última versión incorpora herencia y polimorfismo para trabajar con charlas y talleres.

La entrega comprende los ejercicios 1, 2 y 3. El ejercicio 4 se excluye según la indicación dada en clase.

## Organización del repositorio

Cada carpeta contiene un proyecto independiente de IntelliJ IDEA:

| Carpeta      | Contenido                                                                       |
| ------------ | ------------------------------------------------------------------------------- |
| `ejercicio1` | Clase EventoUniversitario, constructores, copia de objetos y contador estático. |
| `ejercicio2` | Relaciones entre eventos, salas, actividades, estudiantes e inscripciones.      |
| `ejercicio3` | Clase abstracta Actividad, herencia, polimorfismo y métodos finales.            |

Los proyectos deben abrirse y ejecutarse por separado, ya que contienen clases con los mismos nombres.

## Requisitos

* JDK 21.
* IntelliJ IDEA con soporte para Java.
* Git, si se desea clonar el repositorio desde la terminal.

No se requieren bibliotecas externas ni una base de datos.

## Clonar el repositorio

Ejecutar en una terminal:

```bash
git clone https://github.com/Franco-Nicolas-Baigorri/PP_TP1_50730.git
```

## Ejecutar desde IntelliJ IDEA

1. Seleccionar **File → Open**.
2. Abrir la carpeta del ejercicio que se desea ejecutar, por ejemplo `PP_TP1_50730/ejercicio3`.
3. Verificar en **File → Project Structure** que el SDK del proyecto sea JDK 21. Si el SDK guardado no se reconoce, seleccionar el JDK 21 instalado en la computadora.
4. Esperar a que IntelliJ termine de cargar el proyecto.
5. Abrir `src/App.java`.
6. Ejecutar el método `main` mediante **Run 'App.main()'**.

La clase de inicio de los tres ejercicios es `App`.

## Ejercicio 1: clases y objetos

Se implementa la clase `EventoUniversitario` con:

* Atributos privados para encapsular sus datos.
* Identificador declarado como `final`.
* Constructor principal y constructor de copia.
* Contador estático de eventos creados.
* Métodos para calcular el costo estimado y mostrar los datos.
* Método estático `getCantidadEventos()`.

El ejemplo crea dos eventos y una copia de cada uno. El total esperado es de cuatro objetos EventoUniversitario.

## Ejercicio 2: relaciones entre objetos

Se incorporan las clases:

* `Sala`: identifica el espacio asignado a un evento.
* `Actividad`: representa una actividad con cupo e inscripciones.
* `Estudiante`: almacena el legajo y el nombre.
* `Inscripcion`: relaciona un estudiante con una actividad y registra fecha y estado.

Cada evento conserva una sala y una colección de actividades. Cada actividad mantiene una colección `List<Inscripcion>`.

Se valida que una actividad no supere su cupo y que un mismo legajo no se inscriba dos veces en ella.

El ejemplo de App crea tres estudiantes, dos eventos, tres actividades y seis inscripciones.

## Ejercicio 3: herencia y polimorfismo

`Actividad` se transforma en una clase abstracta. Sus subclases concretas son:

* `Charla`: incorpora el nombre del disertante.
* `Taller`: indica si requiere notebook.

Ambas implementan los métodos `calcularCostoMateriales()` y `getTipo()`.

La colección `List<Actividad>` permite almacenar charlas y talleres y operar sobre ellos mediante referencias del tipo común Actividad.

El método `mostrarIdentificacion()` es `final`, por lo que no puede redefinirse en las subclases. Internamente utiliza `getTipo()` para identificar el tipo concreto de actividad.

### Cálculo de costos

| Tipo de actividad   |  Costo |
| ------------------- | -----: |
| Charla              |     $0 |
| Taller con notebook | $5.000 |
| Taller sin notebook | $2.000 |

Si el evento es gratuito, su costo total estimado es cero.

Si no es gratuito, se aplica la fórmula:

```text
Costo total = (costo base + suma de costos de las actividades) × 1,21
```

El costo de cada actividad se suma una vez; no se multiplica por la cantidad de estudiantes inscriptos.

### Resultados esperados del ejemplo

| Evento                      | Actividades | Costo total estimado |
| --------------------------- | ----------: | -------------------: |
| Jornada de Programación     |           3 |              $14.520 |
| Encuentro de Ciberseguridad |           2 |                   $0 |

El ejemplo registra tres estudiantes y ocho inscripciones distribuidas entre cinco actividades.

El contador final de eventos es 2.

## Consideraciones de implementación

* `CUPO_MINIMO` se establece en 1.
* La fecha de inscripción se obtiene mediante `LocalDate.now()`, utilizando la fecha del sistema.
* Las inscripciones se crean con estado `Confirmada`.
* Los datos se mantienen en memoria durante la ejecución.
* En los ejercicios 2 y 3, la copia de un evento crea actividades e inscripciones independientes y comparte las referencias a la sala y los estudiantes.
* Los archivos compilados se generan al construir el proyecto; no es necesario incluirlos en el repositorio.
