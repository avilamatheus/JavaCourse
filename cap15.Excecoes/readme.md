# Tratamento de Exceções / Exception Handling

**PT-BR**  
Este capítulo aborda o tratamento de exceções em Java, tais como:

- O que é uma exceção
- Estrutura try-catch e finally

***

**EN-US**  
This chapter covers exception handling in Java, such as:

- What is an exception
- try-catch and finally structure

***

# Anotações / Notes
## Bloco try-catch-finally / try-catch-finally block
**PT-BR**  
- O bloco try contém o código que representa a execução normal do trecho de código que PODE lançar uma exceção.
- O bloco catch contém o código a ser executado caso uma exceção seja lançada, devendo ser especificado o tipo de exceção que será tratada.
- Por fim, o bloco finally contém o código que será executado independente de uma exceção ser lançada ou não.

**EN-US**  
- The try block contains the code that represents the normal execution of the code that MAY throw an exception.
- The catch block contains the code to be executed if an exception is thrown, and the type of exception to be handled must be specified.
- Finally, the finally block contains the code that will be executed regardless of whether an exception is thrown or not.

```java
try {
    // código que pode lançar uma exceção
    // code that may throw an exception
} catch (ExceptionType e) {
    // código a ser executado caso uma exceção do tipo ExceptionType seja lançada
    // code to be executed if an exception of type ExceptionType is thrown
} finally {
    // código a ser executado independente de uma exceção ser lançada ou não
    // code to be executed regardless of whether an exception is thrown or not
}
```

## Palavra chave "throw" e "throws" / "throw" and "throws" keywords
**PT-BR**  
- A palavra chave `throw` é utilizada para lançar uma exceção manualmente, exemplo: `throw new ExceptionType("mensagem")`.
- A palavra chave `throws` é utilizada para indicar que um método pode lançar uma exceção, exemplo: `public void method() throws ExceptionType`.

***

**EN-US**
- The `throw` keyword is used to throw an exception manually, example: `throw new ExceptionType("message")`.
- The `throws` keyword is used to indicate that a method can throw an exception, example: `public void method() throws ExceptionType`.


## Exceções Personalizadas / Custom Exceptions
**PT-BR**  
- É possível criar exceções personalizadas, que estendem a classe `Exception` ou `RuntimeException`.
    - No caso de exceções que estendem `Exception`, é necessário tratar a exceção com `try-catch` ou utilizar a palavra chave `throws`.
    - No caso de exceções que estendem `RuntimeException`, não é necessário tratar a exceção com `try-catch` ou utilizar a palavra chave `throws`.
- A ideia de criar exceções personalizadas é para criar exceções que representem situações específicas do domínio do problema, facilitando a identificação e tratamento de erros.

**EN-US**  
- It is possible to create custom exceptions, which extend the `Exception` or `RuntimeException` class.
    - In the case of exceptions that extend `Exception`, it is necessary to handle the exception with `try-catch` or use the `throws` keyword.
    - In the case of exceptions that extend `RuntimeException`, it is not necessary to handle the exception with `try-catch` or use the `throws` keyword.
- The idea of creating custom exceptions is to create exceptions that represent specific situations in the problem domain, facilitating the identification and handling of errors.


***
Exemplo / Example :
```java
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

## Try-with-resources
**PT-BR**  
- O try-with-resources é uma estrutura que permite a utilização de recursos que devem ser fechados após o término do bloco try, como por exemplo, leitura de arquivos.

**EN-US**  
- The try-with-resources is a structure that allows the use of resources that must be closed after the end of the try block, such as reading files.

***
Exemplo sem try-with-resources / Example without try-with-resources:
```java
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("file.txt"));
    System.out.println(reader.readLine());
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (reader != null) {
            reader.close();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
Exemplo com try-with-resources / Example with try-with-resources:
```java
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    System.out.println(reader.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```


