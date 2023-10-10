# Gherkin Reference

Gherkin utiliza un conjunto de `keywords` especiales para dar estructura y significado a las especificaciones ejecutables.

La mayoría de las líneas en un documento Gherkin comienzan con una de las `keywords`.

Los comentarios solo se permiten al comienzo de una nueva línea, en cualquier parte del archivo de funciones. Comienzan con cero o más espacios, seguidos de un signo de almohadilla (`#`) y algo de texto.

Se pueden utilizar espacios o tabulaciones para la sangría. El nivel de sangría recomendado es de **dos espacios**. Aquí hay un ejemplo:

```Gherkin
Feature: Guess the word

  # The first example has two steps
  Scenario: Maker starts a game
    When the Maker starts a game
    Then the Maker waits for a Breaker to join

  # The second example has three steps
  Scenario: Breaker joins a game
    Given the Maker has started a game with the word "silky"
    When the Breaker joins the Maker's game
    Then the Breaker must guess a word with 5 characters
```

La parte final (después del `keywords`) de cada paso se compara con un bloque de código, llamado `step definition`.

Tenga en cuenta que algunos `keywords` van seguidas de dos puntos (`:`) y otras no . Si agrega dos puntos después de una palabra clave que no debe ir seguida de una, se ignorarán sus pruebas.

## Keywords

Cada línea que no sea una línea en blanco debe comenzar con un `keywords` de Gherkin, seguida de cualquier texto que desee. Las únicas excepciones son las descripciones de forma libre colocadas debajo de las líneas `Example`/`Scenario`, `Background`, `Scenario Outline` y `Rule`.

Los `keywords` principales son:

- `Feature`
- `Rule` (a partir del Gherkin 6)
- `Example` (o `Scenario`)
- `Given`, `When`, `Then`, `And`, `But` para pasos (o `*`)
- `Background`
- `Scenario Outline` (o `Scenario Template`)
- `Examples`(o `Scenarios`)

También hay algunas `keywords` secundarias:

- `"""` (Cadenas de documentos)
- `|` (Tablas de datos)
- `@` (Etiquetas)
- `#` (Comentarios)

### Feature

El propósito del `Feature`  es proporcionar una descripción de alto nivel de una función de software y agrupar `Scenarios` relacionados.

La primera palabra clave principal en un documento Gherkin siempre debe ser `Feature`, seguida de una `:` y un texto breve que describa el `Feature`.

Puede agregar texto de forma libre debajo de `Feature` para agregar más descripción.

Solo puede tener un solo `Feature` en un archivo `.feature`.

### Rule

El keyword `Rule` (opcional) ha sido parte de Gherkin desde v6

El propósito del `Rule` es representar un `business rule` que debe implementarse. Proporciona información adicional para una función. Un `Rule` se utiliza para agrupar varios `Scenarios` que pertenecen a esta `business rule`. Un `Rule` debe contener uno o más escenarios que ilustren la regla en particular.

### Example

Este es un ejemplo concreto que ilustra un `business rule`. Consiste en una lista de `steps` .

El keyword `Scenario` es un sinónimo del keyword `Example`.

Los ejemplos siguen este mismo patrón:

- Describe un contexto inicial ( `Given` steps)
- Describe un evento ( `When` steps)
- Describe un resultado esperado ( `Then` steps)

### Steps

Cada step comienza con `Given`, `When`, `Then`, `And` o `But`.

Cucumber ejecuta cada Step en un scenario uno a la vez, en la secuencia en la que los ha escrito. Cuando Cucumber intenta ejecutar un step, busca un step definition coincidente para ejecutar.

### Given

Los steps `Given` se utiliza para describir el contexto inicial del sistema - la escena del `scenario`. Por lo general, es algo que sucedió en el pasado .

Cuando Cucumber ejecuta un step `Given`, configurará el sistema para que esté en un estado bien definido, como crear y configurar objetos o agregar datos a una base de datos de prueba.

El propósito del steps `Given` es **poner el sistema en un estado conocido** antes de que el usuario (o el sistema externo) comience a interactuar con el sistema (en los steps `When`). Evite hablar sobre la interacción del usuario en `Given`. Si estuviera creando casos de uso, `Given` serían sus condiciones previas.

Está bien tener varios steps `Given` (use `And` o `But` para el número 2 y hacia arriba para que sea más legible).

### When

Los steps `When` se utilizan para describir un evento o una *acción*. Puede ser una persona que interactúa con el sistema o puede ser un evento desencadenado por otro sistema.

Se recomienda encarecidamente que solo tenga un step `When` por Scenario. Si se siente obligado a agregar más, generalmente es una señal de que debe dividir el Scenario en varios Scenarios.

### Then

Los steps `Then` se utilizan para describir un resultado o resultado *esperado*.

El *step definition* de un step `Then`  debe usar un *assertion* para comparar el resultado *actual* (lo que el sistema realmente hace) con el resultado *expected* (lo que el *step* dice que se supone que debe hacer el sistema).

Un resultado debe estar en una salida **observable**. Es decir, algo que sale del sistema (informe, interfaz de usuario, mensaje), y no un comportamiento profundamente enterrado dentro del sistema (como un registro en una base de datos).

### And, But

`And` y `But` permite que se tenga una estructura más fluida al momento de redactar, Ejemplo:

```Gherkin
Example: Multiple Givens
  Given one thing
  And another thing
  And yet another thing
  When I open my eyes
  Then I should see something
  But I shouldn't see something else
```

### *

Gherkin también admite el uso de un *asterisk* (`*`) en lugar de cualquiera de los *step keywords* normales. Esto puede ser útil cuando tiene algunos steps que son efectivamente una *lista de cosas*, por lo que puede expresarlo más como viñetas a lo contrario del lenguaje natural de `And`, podría no leerse tan elegantemente.

```Gherkin
Scenario: All done
  Given I am out shopping
  * I have eggs
  * I have milk
  * I have butter
  When I check my list
  Then I don't need anything
```

### Background

Ocasionalmente, se encontrará repitiendo los mismos steps `Given` en todos los escenarios de un archivo `Feature`, esto es una indicación de que esos steps no son esenciales para describir los *Scenarios*; son detalles incidentales. Puede mover dichos steps `Given` agrupándolos en una sección `Background`.

Un `Background` le permite agregar algo de contexto a los *Scenarios* que le siguen. Puede contener uno o más steps `Given`, que se ejecutan antes de *cada* Scenario, pero después de cualquier *Before hooks*.

Un `Background` se coloca antes del primer `Scenario`/`Example`, al mismo nivel de sangría.

Por ejemplo:

```Gherkin
Feature: Multiple site support
  Only blog owners can post to a blog, except administrators,
  who can post to all blogs.

  Background:
    Given a global administrator named "Greg"
    And a blog named "Greg's anti-tax rants"
    And a customer named "Dr. Bill"
    And a blog named "Expensive Therapy" owned by "Dr. Bill"

  Scenario: Dr. Bill posts to his own blog
    Given I am logged in as Dr. Bill
    When I try to post to "Expensive Therapy"
    Then I should see "Your article was published."

  Scenario: Dr. Bill tries to post to somebody else's blog, and fails
    Given I am logged in as Dr. Bill
    When I try to post to "Greg's anti-tax rants"
    Then I should see "Hey! That's not your blog!"

  Scenario: Greg posts to a client's blog
    Given I am logged in as Greg
    When I try to post to "Expensive Therapy"
    Then I should see "Your article was published."
```

Solo puede tener un conjunto de steps `Background` por `Feature` o `Rule`. Si necesita diferentes steps `Background` para diferentes escenarios, considere dividir su conjunto de *Scenarios* en más `Rule` o más `Feature`.

### Scenario Outline

El *keyword* `Scenario Outline` se puede utilizar para ejecutar el misma `Scenario` varias veces, con diferentes combinaciones de valores, se usa mediante una plantilla con `< >` - parámetros delimitados.

El *keyword* `Scenario Template` es un sinónimo del keyword `Scenario Outline`.

```Gherkin
Scenario Outline: eating
  Given there are <start> cucumbers
  When I eat <eat> cucumbers
  Then I should have <left> cucumbers

  Examples:
    | start | eat | left |
    |    12 |   5 |    7 |
    |    20 |   5 |   15 |
```

```Gherkin
Feature: Learn data tableScenario outline: Cucumber Data Table
  Given Table with example
    | FirstName  | <FirstName>  |
    | MiddleName | <MiddleName> |
    | LastName   | <LastName>   |
  Examples: 
    | FirstName | MiddleName | LastName |
    | Priyank   | B          | Shah     |
    | Mansi     | P          | Shah     |
```

```Gherkin
Scenario Outline: User tries to signup with improper combination of password
  Given the user has browsed to the signup page
  When the user tries to signup entering the following details
    | email           |  william@xyz.com   |
    | password        | <Password>         |
    | confirmPassword | <ConfirmPassword>  |
  Then an error message "<validation>" should be shown above the "password" field
  Examples:
    | Password    | ConfirmPassword  | validation                         |
    | 234567569   | 234567569        | This password is entirely numeric  |
    | 123456789   | 123456789        | This password is too common.       |
    | abcde       | abcde            | This password is too short.        |
```

```Gherkin
Feature: Login Test
  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigate to Login Page
    And User enters "<username>" and "<password>"
    Then Message displayed Login Successfully
    Examples:
      | Username | Password |
      | Employee_1 | Welc@345 |
      | Employee_2 | Test@542 |
```

### Examples

Un `Scenario Outline` debe contener una o más secciones `Examples` (o `Scenarios`). Estos steps se interpretan como una plantilla que nunca se ejecuta directamente. En su lugar, el `Scenario Outline` ejecuta una vez cada fila de la sección `Examples` (sin contar la primera fila de encabezado).

Los steps pueden usar `< >` parámetros delimitados que hacen referencia a encabezados en la tabla de `Examples`. Cucumber reemplazará estos parámetros con valores de la tabla antes de intentar hacer coincidir el step con un *step definition*.

## Step Arguments

En algunos casos, es posible que desee pasar más datos a un paso de los que caben en una sola línea. Para ello Gherkin tiene `Doc Strings` y `Data Tables`.

### Doc Strings

`Doc Strings` son útiles para pasar un texto más grande a un *step definition*.

El texto debe estar compensado por delimitadores que consisten en tres comillas dobles en líneas propias:

```Gherkin
Given a blog post named "Random" with Markdown body
  """
  Some Title, Eh?
  ===============
  Here is the first paragraph of my blog post. Lorem ipsum dolor sit amet,
  consectetur adipiscing elit.
  """
```

### Data Tables

`Data Tables` son útiles para pasar una lista de valores a un *step definition*:

```Gherkin
Given the following users exist:
  | name   | email              | twitter         |
  | Aslak  | aslak@cucumber.io  | @aslak_hellesoy |
  | Julien | julien@cucumber.io | @jbpros         |
  | Matt   | matt@cucumber.io   | @mattwynne      |
```

```Gherkin
Scenario: Correct non-zero number of books found by author
  Given I have the following books in the store
    | title                                | author      |
    | The Devil in the White City          | Erik Larson |
    | The Lion, the Witch and the Wardrobe | C.S. Lewis  |
    | In the Garden of Beasts              | Erik Larson |
  When I search for books by author Erik Larson
  Then I find 2 books
```

```Gherkin
Feature: Learn data tableScenario: Cucumber Data Table
  Given Table with two rows and multiple columns
    | columnA | columnB | columnC | columnD |
    | value1  | value2  | value3  | value4  |
    | value5  | value6  | value7  | value8  |
  And Table with only two rows and two columns
    | username | admin    |
    | password | admin123 |
  And Table with multiple rows and one column
    | columnNameG |
    | row1        |
    | row2        |
    | row3        |
```

```Gherkin
Feature: New user registration.
  Given I am on a new user registration page
  When I enter valid data on the page
    | Fields                 | Values              |
    | First Name             | Tom                 |
    | Last Name              | Kenny               |
    | Email Address          | someone@someone.com |
    | Re-enter Email Address | someone@someone.com |
    | Password               | Password1           |
    | Birthdate              | 01                  |
  Then the user registration should be successful.
```

```Gherkin
Scenario: login with valid credentials
  Given a user has been created with the following details:
    | email          | username  | password |
    | user@email.com | user      | password |
  And the user has browsed to the login page
  When the user enters the following details in the login form:
    | email          | username  | password |
    | user@email.com | user      | password |
  And the user logs in
  Then the user should be redirected to the homepage
```

```Gherkin
  Given the user has browsed to the signup page
  When the user tries to signup entering the following details
      | email           | william@xyz.com    |
      | password        | 234567569          |
      | confirmPassword | 234567569          |
  Then an error message "This password is entirely numeric" should be shown above the "password" field
```
