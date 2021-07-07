# JAVA_ADDA_2020
Repositorio para Java - Análisis y Diseño de Datos y Algoritmos - 2020 

# Contenidos

1. *Práctica 1º - Ejercicios Iterativos* 

    - Ejercicio 1 - Solución iterativa mediante while()
    - Ejercicio 2 - Solución iterativa mediante while()
    - Ejercicio 3 - Solución iterativa mediante while()

2. *Práctica 2º - Ejercicios iterativos, recursivos lineales y notación funcional* 

    - Ejercicio 1 - Solución iterativa mediante while(), recursiva final y funcional
    - Ejercicio 2 - Solución iterativa mediante while(), recursiva final y funcional
    - Ejercicio 3 - Solución iterativa mediante while(), recursiva no final, recursiva final y funcional

3. *Práctica 3º - Ejercicios recursivos no lineales*

    - Ejercicio 1 - Solución recursiva
    - Ejercicio 2 - Solución recursiva
    - Ejercicio 3 - Solución recursiva con memoria, sin memoria e iterativa
    - Ejercicio 4 - Solución recursiva con memoria, sin memoria e iterativa

4. *Práctica 4º - Ejercicios de árboles*

    - Ejercicio 1 - Solución recursiva
    - Ejercicio 2 - Solución recursiva
    - Ejercicio 3 - Solución recursiva
    - Ejercicio 4 - Solución recursiva
    - Ejercicio 5 - Solución recursiva
  
5. *Práctica 5º - Ejercicios sobre grafos*

    > Ejercicios 1 al 3, soluciones mediante la implementación de la librería de JGraphT

    - Ejercicio 1
    ~~~
    Una red social imaginaria y pequeña, se representa con un grafo en el que los vértices
    modelan a los miembros de la red y las aristas (sin etiqueta ni peso) modelan la
    amistad entre dos miembros. Desarrolle:

    a. Un método que devuelva un conjunto con aquellos miembros que no tengan
    ningún amigo, y otro método que devuelva un conjunto con aquellos
    miembros que tienen el mayor número de amigos. Muestre el grafo
    configurando su apariencia de forma que se resalten de un color los miembros
    que no tienen ningún amigo, y de otro color los que tienen el mayor número
    de amigos.

    b. Un método que, dados dos miembros, devuelva la lista más corta de amigos
    que hay desde un miembro a otro miembro. Muestre el grafo configurando su
    apariencia de forma que se resalte la lista más corta de amigos que hay desde
    un miembro a otro miembro.

    c. Determine cuántos grupos de miembros hay y cuál es su composición. 2
    miembros pertenecen al mismo grupo si están relacionados directamente entre
    sí o si existen algunos miembros intermedios que los relacionan. Muestre el
    grafo configurando su apariencia de forma que se coloree cada grupo de un
    color diferente.

    d. Se han diseñado unos cuestionarios a ser cumplimentados por los miembros
    de la red sobre las relaciones de amistad. Se desea enviar dichos cuestionarios
    a un conjunto seleccionado de miembros tales que: todas las relaciones de
    amistad estén representadas (una relación de amistad está representada por
    alguno de sus 2 miembros), se minimice el número de cuestionarios a enviar
    (es decir, el número de miembros seleccionados). Muestre el grafo
    configurando su apariencia de forma que se coloreen los miembros
    seleccionados.
    ~~~

    - Ejercicio 2
    ~~~
    En una academia se imparten una serie de grupos por parte de un conjunto de
    profesores. Cada profesor imparte varios grupos, y cada grupo es impartido por 2
    profesores. Para minimizar el tiempo en el que la academia estará abierta al público,
    se van a impartir grupos en paralelo de forma que se minimicen las franjas horarias
    con clases.

    a. Determine qué grupos deberían impartirse en paralelo y cuántas franjas
    horarias son necesarias, teniendo en cuenta que no se pueden poner en paralelo
    grupos impartidos por el mismo profesor.

    b. Muestre el problema como un grafo en el que los vértices son los grupos, y
    configure su apariencia de forma que se muestren los vértices coloreados en
    función de la franja horaria en la que se impartan.
    ~~~

    - Ejercicio 3
    ~~~
    Un plan de estudios está estructurado para que los alumnos no puedan matricularse
    libremente de las asignaturas que deseen. Existen asignaturas que deben haberse
    cursado (y aprobado) anteriormente para que un alumno se pueda matricular de una
    asignatura dada. Así, los prerrequisitos de una asignatura pueden ser 0 o más
    asignaturas.

    a. Implemente un método que devuelva una lista con todas las asignaturas en un
    orden que cumpla con los prerrequisitos indicados.

    b. Implemente un método que devuelva el conjunto de asignaturas que se pueden
    cursar sin tener ninguna aprobada previamente. Muestre el grafo configurando
    su apariencia de forma que se resalten dichas asignaturas.

    c. Implemente un método que, dado un conjunto de asignaturas que un alumno
    tiene aprobadas, devuelva un conjunto con las asignaturas que puede cursar el
    próximo año. Muestre el grafo configurando su apariencia de forma que se
    resalten las asignaturas de ambos conjuntos con 2 colores diferentes.
    ~~~

6. *Práctica 6º - Ejercicios Programación Lineal y Algoritmos Genéticos*

    > Ejercicios 1 al 3, soluciones mediante programación lineal y algoritmos genéticos
    > Ejercicio 4, solución mediante programación lineal
    > Ejercicio 5, solución mediante algoritmos genéticos

    - Ejercicio 1
    ~~~
    Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
    de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
    afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
    rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
    todos los grupos deben tener el mismo número de alumnos, maximizando la
    afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
    permitido asignar un alumno a un grupo para el que presente afinidad 0.
    ~~~

    - Ejercicio 2
    ~~~
    Un bufete de abogados cuenta con un equipo de n personas que deben analizar m
    casos relacionados entre sí (m>=n), y deben terminar dicho análisis global lo antes
    posible para lo que trabajarán en paralelo. Cada caso será analizado por un único
    abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
    horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
    tiempo puede diferir para cada caso en función de qué abogado realice el análisis).
    Determine cuál es la mejor asignación de casos a abogados para conseguir el
    objetivo indicado (terminar de analizar todos los casos lo antes posible).
    ~~~

    - Ejercicio 3
    ~~~
    Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
    de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
    desea diseñar un lote con una selección de dichos productos que cubran un
    conjunto de funcionalidades deseadas entre todos productos seleccionados al
    menor precio.
    ~~~

    - Ejercicio 4
    ~~~
    Dado un conjunto de enteros determinar si puede particionarse en tres
    subconjuntos de manera que la suma de elementos en los tres subconjuntos sea la
    misma, y que el tamaño de uno de ellos sea lo menor posible.
    ~~~

    - Ejercicio 5
    ~~~
    Se tiene un grafo cuyos vértices son Ciudades y sus aristas son Carreteras, y un
    predicado sobre carreteras. Se desea saber cuál es el camino cerrado más corto
    que pase por todos los vértices del grafo una sola vez y que contiene al menos una
    arista que cumple el predicado.
    ~~~

7. *Práctica 7º - Ejercicios Programación Dinámica y A**

    > Ejercicios 1 al 4, soluciones por programación dinámica y A*

    - Ejercicio 1
    ~~~
    Una academia de inglés tiene n alumnos a ser repartidos en m grupos (n múltiplo
    de m). Cada grupo tiene distinto horario y profesor. De cada alumno se conoce la
    afinidad que tiene para pertenecer a cada uno de los grupos (valor entero en el
    rango [0,5]). Se desea conocer el reparto de alumnos en grupos, de forma que
    todos los grupos deben tener el mismo número de alumnos, maximizando la
    afinidad total conseguida para todos los alumnos, y teniendo en cuenta que no está
    permitido asignar un alumno a un grupo para el que presente afinidad 0.
    ~~~

    - Ejercicio 2
    ~~~
    Un bufete de abogados cuenta con un equipo de n personas que deben analizar m
    casos relacionados entre sí (m>=n), y deben terminar dicho análisis global lo antes
    posible para lo que trabajarán en paralelo. Cada caso será analizado por un único
    abogado, y cada abogado puede analizar varios casos. Se conoce el tiempo (en
    horas) que se estima que tarda cada abogado en analizar cada caso concreto (dicho
    tiempo puede diferir para cada caso en función de qué abogado realice el análisis).
    Determine cuál es la mejor asignación de casos a abogados para conseguir el
    objetivo indicado (terminar de analizar todos los casos lo antes posible).
    ~~~

    - Ejercicio 3
    ~~~
    Se tienen n productos, cada uno de los cuales tiene un precio y presenta una serie
    de funcionalidades (el mismo producto puede tener más de una funcionalidad). Se
    desea diseñar un lote con una selección de dichos productos que cubran un
    conjunto de funcionalidades deseadas entre todos productos seleccionados al
    menor precio.
    ~~~

    - Ejercicio 4
    ~~~
    Dado un conjunto de enteros determinar si puede particionarse en tres
    subconjuntos de manera que la suma de elementos en los tres subconjuntos sea la
    misma, y que el tamaño de uno de ellos sea lo menor posible.
    ~~~

8. *Práctica 8º - Programación dinámica*

    > Resolver el problema por programación dinámica, modelando el problema cómo un grafo virtual.

    - Ejercicio 1 - Algoritmo Floyd
    ~~~
    Dado un conjunto de ciudades conectadas por carreteras, de las que conocemos su
    longitud, encontrar el camino más corto posible entre dos ciudades dadas.
    ~~~
