### Concepto
La aplicación es un juego tic-tac-toe utilizando el patrón MVC con Spring, controlado manualmente mediante el click izquierdo de un ratón. Este se muestra con ayuda de un navegador de internet.

### Entorno de desarrollo
La aplicación se realizó exitosamente con:
- GNU/Linux Manjaro 16.06.1 bajo 64 bits
- Java OpenJDK 8
- Firefox 47

### Ejecución
Una vez que se esté en la carpeta del proyecto, realice lo siguiente.

Permiso de ejecución del script de Gradle:
``` shell
$ chmod 777 gradlew
```

Para tener todas las dependencias:
```shell
$ ./gradlew build
```

Se activa el servidor basado en Spring:
```shell
$ ./gradlew bootRun
```
 y finalmente
abra el navegador en [http://localhost:8080](http://localhost:8080).
