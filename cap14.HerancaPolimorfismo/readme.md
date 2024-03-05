# Herança e Polimorfismo / Inheritance and Polymorphism
**PT-BR**  
Este capítulo aborda os conceitos de herança e polimorfismo em Java, como:

- Herança
- Upcasting e Downcasting
- Sobreposição, super e @Override
- Classes e métodos "final"
- Polimorfismo
- Classes e métodos "abstract"

***

**EN-US**  
This chapter covers the concepts of inheritance and polymorphism in Java, such as:

- Inheritance
- Upcasting and Downcasting
- Overriding, super and @Override
- "final" classes and methods
- Polymorphism
- "abstract" classes and methods

***

# Anotações / Notes

## Herança / Inheritance
**PT-BR**  
É um tipo de associação que permite que uma classe herde atributos e métodos de outra classe. A classe que herda é chamada de subclasse e a classe que é herdada é chamada de superclasse. Suas vantagens são o reuso de código e o polimorfismo.

***

**EN-US**  
It is a type of association that allows a class to inherit attributes and methods from another class. The class that inherits is called a subclass and the class that is inherited is called a superclass. Its advantages are code reuse and polymorphism.

***

Sintaxe / Syntax:
```java
class B extends A {
  // ...
}
```

## Upcasting & Downcasting

**PT-BR**  
- Upcasting: conversão de um objeto de uma subclasse para uma superclasse.
- Downcasting: conversão de um objeto de uma superclasse para uma subclasse.

***
**EN-US**  
- Upcasting: conversion of an object from a subclass to a superclass.
- Downcasting: conversion of an object from a superclass to a subclass.

***
Exemplo / Example:
```java
Account acc = new Account(1001, "Alex", 0.0);
BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
// UPCASTING
		
Account acc1 = bacc;
Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
// DOWNCASTING
		
BusinessAccount acc4 = (BusinessAccount)acc2;
acc4.loan(100.0);
		
// BusinessAccount acc5 = (BusinessAccount)acc3;
if (acc3 instanceof BusinessAccount) {
	BusinessAccount acc5 = (BusinessAccount)acc3;
	acc5.loan(200.0);
	System.out.println("Loan!");
}
		
if (acc3 instanceof SavingsAccount) {
	SavingsAccount acc5 = (SavingsAccount)acc3;
	acc5.updateBalance();
	System.out.println("Update!");
}
```

## Sobreposição, super e @Override / Overriding, super and @Override

**PT-BR**  
- Sobreposição: é a reescrita de um método de uma superclasse na subclasse.
- super: é uma palavra-chave que se refere a um método ou construtor da superclasse.
- @Override: é uma anotação que indica que um método sobrescreve um método da superclasse. é opcional, mas é uma boa prática.

***

**EN-US**  
- Overriding: is the rewriting of a method from a superclass in the subclass.
- super: is a keyword that refers to a method or constructor of the superclass.
- @Override: is an annotation that indicates that a method overrides a method of the superclass. it is optional, but it is a good practice.

## Classes e métodos "final" / "final" classes and methods
**PT-BR**  
Final é uma palavra-chave que pode ser aplicada a classes, métodos e variáveis. 
  - final class: não pode ser herdada, exemplo:
    ```java
    final class SavingsAccount extends Account {
      // ...
    }
    ```
  - final method: não pode ser sobreposto, exemplo:
    ```java
    public final void withdraw(double amount) {
      // ...
    }
    ```
  - final variable: não pode ser alterada, exemplo:
    ```java
    private final double INTEREST_RATE = 0.01;
    ```

Por que usar final?
  - Segurança: dependendo das regras do negócio, às vezes é desejável garantir que uma classe não seja herdada, ou que um método não seja sobreposto.
    - Geralmente convém acrescentar final em métodos sobrepostos, pois sobreposições múltiplas podem ser uma porta de entrada para inconsistências
  - Performance: atributos de tipo de uma classe final são analisados de forma mais rápida em tempo de execução. Um exemplo disso é a classe String.

***

**EN-US**  
Final is a keyword that can be applied to classes, methods, and variables.
  - final class: cannot be inherited, example:
    ```java
    final class SavingsAccount extends Account {
      // ...
    }
    ```
  - final method: cannot be overridden, example:
    ```java
    public final void withdraw(double amount) {
      // ...
    }
    ```
  - final variable: cannot be changed, example:
    ```java
    private final double INTEREST_RATE = 0.01;
    ```
Why use final?
  - Security: depending on business rules, it is sometimes desirable to ensure that a class is not inherited, or that a method is not overridden.
    - It is generally advisable to add final to overridden methods, as multiple overrides can be a gateway to inconsistencies
  - Performance: type attributes of a final class are analyzed more quickly at runtime. An example of this is the String class.


## Introdução ao Polimorfismo / Introduction to Polymorphism
**PT-BR**  
Em Programação Orientada a Objetos, polimorfismo é recurso que
permite que variáveis de um mesmo tipo mais genérico possam
apontar para objetos de tipos específicos diferentes, tendo assim
comportamentos diferentes conforme cada tipo específico.

Exemplo:
```java
Account x = new Account(1020, "Alex", 1000.0);
Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);

x.withdraw(50.0);
y.withdraw(50.0);
```

A associação do tipo específico com o tipo genérico é feita em tempo de execução (upcasting). O compilador não sabe para qual tipo específico a chamada do método
Withdraw está sendo feita (ele só sabe que são duas variáveis tipo Account).

***
**EN-US**  
In Object Oriented Programming, polymorphism is a feature that allows variables of the same more generic type to point to objects of different specific types, thus having different behaviors according to each specific type.

Example:
```java
Account x = new Account(1020, "Alex", 1000.0);
Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);

x.withdraw(50.0);
y.withdraw(50.0);
```

The association of the specific type with the generic type is done at runtime (upcasting). The compiler does not know for which specific type the call to the method
Withdraw is being made (it only knows that there are two variables of type Account).

## Classes e métodos "abstract" / "abstract" classes and methods
**PT-BR**  
- abstract class: é uma classe que não pode ser instanciada, ou seja, não pode ser criado um objeto a partir dela. Pode conter métodos abstratos e métodos concretos.
  - métodos abstratos: são métodos que não possuem implementação, ou seja, não possuem corpo. Eles são declarados com a palavra-chave "abstract".
  - métodos concretos: são métodos que possuem implementação, ou seja, possuem corpo. Eles são declarados sem a palavra-chave "abstract".

**EN-US**  
- abstract class: is a class that cannot be instantiated, that is, an object cannot be created from it. It can contain abstract methods and concrete methods.
  - abstract methods: are methods that have no implementation, that is, they have no body. They are declared with the "abstract" keyword.
  - concrete methods: are methods that have implementation, that is, they have a body. They are declared without the "abstract" keyword.