# Laboratorio 9:
## Arquitectura
### MVVM: 
Abreviación del termino, Model-View-ViewModel, es un patrón de diseño, que, como cualquier otro, separa el manejo de datos, la lógica de negocio e interfaz de usuario en secciones diferentes. Con esto logramos un mejor control de errores. Sin embargo en el caso de kotlin tiene el aspecto especial que, usando una tecnología denominada LiveData, la vista esta chequeando constantemente la vistamodelo para determinar si debe realizar algún cambio. A esta funcionalidad al que agregar que los datos solo viajan de la vista a la vistamodelo para terminar en el modelo, donde comienza su procesamiento. Luego de su procesamiento, la información viaja de regreso a la vista por medio de la vistamodelo y el constante chequear de la vista con ayuda de LiveData. Creando un flujo unidireccional que nos permite reducir la probabilidad de alteraciones inesperadas de los datos. En programas a gran escala, el tener un programa predecible y ordenado, que nos permita saber de donde provienen los errores, es la diferencia entre una aplicación escalable fácil de mantener y un completo desastre.

En nuestro caso lo implementamos de la siguiente manera:

### UiState: 
Concepto utilizado en MVVM para representar los "estados" en los que se puede encontrar una interfaz de usuario. Esto se logra por medio de la definición de una clase sellada donde incluimos todos los estados que planeamos para nuestra aplicación. Por ejemplo, si calculamos que nuestra UI en base a la validación del input del usuario luego de pasar a un estado de loading puede dar una pantalla de exito o una de fracaso, podemos crear la siguiente clase sellada:
```
sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val exception: Exception) : UiState<Nothing>()
}
```
Este proceso nos brinda mayor claridad y modularidad, facilitando aún más el manejo de errores y la lectura del código.

En nuestro caso lo implementamos de la siguiente manera:

### Navegación

### Decisiones

## Reflexiones

- ¿Por qué el estado no persiste al rotar? Relacionar con ciclo de vida, recreación de actividad y recomposición.
- ¿Por qué el ViewModel resuelve el problema de la Parte 1? Conecta con “única fuente de la verdad” y manejo del ciclo de vida.
- ¿Qué ventajas ofrece compartir un ViewModel entre destinos frente a pasar argumentos de navegación?
  
## Fotos del funcionamiento
