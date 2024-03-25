# Interfaces

**PT-BR**  
Este capítulo aborda o uso de interfaces em Java, abordando pontos como:
- como criar interfaces;
- como implementar interfaces;
- por que usar interfaces;
- inversão de controle e injeção de dependência;

***

**EN-US**  
This chapter covers the use of interfaces in Java, addressing points such as:
- how to create interfaces;
- how to implement interfaces;
- why use interfaces;
- inversion of control and dependency injection;


***

# Anotações / Notes

## Oque são interfaces? / What are interfaces?
**PT-BR**  
Interface é um tipo que define um conjunto de operações que uma classe deve implementar, ou seja, a interface establece um contrato que a classe deve cumprir.

**EN-US**  
Interface is a type that defines a set of operations that a class must implement, that is, the interface establishes a contract that the class must fulfill.

## Por que usar interfaces? / Why use interfaces?
**PT-BR**  
Basicamente, interfaces são usadas para criar sistemas com baixo acoplamento e com flexibilidade, usando inversão de controle e injeção de dependência.

**EN-US**  
Basically, interfaces are used to create systems with low coupling and flexibility, using inversion of control and dependency injection.

## Inversão de controle e injeção de dependência / Inversion of control and dependency injection
**PT-BR**  
- Inversão de controle: é um padrão de desenvolvimento que consiste em retirar da classe a responsabilidade de instanciar suas dependências.
- Injeção de dependência: é uma forma de realizar a inversão de controle, onde um componente externo instancia a dependencia que é então injetada na classe que a utiliza, podendo ser implementada de varias formas:
    - Construtor;
    - Classe de instanciação (builder/factory);
    - Container / Framework;

**EN-US**
- Inversion of control: is a development pattern that consists of removing from the class the responsibility of instantiating its dependencies.
- Dependency injection: is a way to perform inversion of control, where an external component instantiates the dependency that is then injected into the class that uses it, and can be implemented in several ways:
    - Constructor;
    - Instantiation class (builder/factory);
    - Container / Framework;


## Herdar vs Cumprir / Inherit vs Fulfill
**PT-BR**  
Aspectos em comum entre herança e interfaces:
- Relação de "é um";
- Generalização/especialização;
- Polimorfismo;

Diferença fundamental:
- Herança: reuso de implementação;
- Interface: contrato a ser cumprido;

Caso seja necessário implementar uma Interface porém também possibilitar o reuso de implementação, é possível utilizar uma classe abstrata que implementa a interface e então as classes que desejam reusar a implementação podem herdar da classe abstrata.


**EN-US**  
Common aspects between inheritance and interfaces:
- "is a" relationship;
- Generalization/specialization;
- Polymorphism;

Fundamental difference:
- Inheritance: reuse of implementation;
- Interface: contract to be fulfilled;

If it is necessary to implement an Interface but also allow the reuse of implementation, it is possible to use an abstract class that implements the interface and then the classes that want to reuse the implementation can inherit from the abstract class.

## Herança múltipla e o problema do diamante / Multiple inheritance and the diamond problem
**PT-BR**  
A herança múltipla pode gerar o
problema do diamante: uma
ambiguidade
causada
pela
existência do mesmo método em
mais de uma superclasse.

Por isso a herança múltipla não é permitida na maioria das linguagens, como Java.

Porém, o Java permite que uma classe implemente mais de uma interface, o que é uma forma de herança múltipla sem o problema do diamante.

**EN-US**  
Multiple inheritance can generate the
diamond problem: an
ambiguity
caused
by
the existence of the same method in
more than one superclass.

Therefore, multiple inheritance is not allowed in most languages, such as Java.

However, Java allows a class to implement more than one interface, which is a form of multiple inheritance without the diamond problem.

## Interface Comparable / Comparable Interface
**PT-BR**  
A interface Comparable é usada para definir uma ordem natural para objetos de uma classe, ou seja, é usada para definir como objetos de uma classe devem ser comparados entre si.

No exemplo a seguir, a classe Product implementa a interface Comparable, e o método compareTo é sobrescrito para comparar os preços dos produtos em ordem crescente.

**EN-US**  
The Comparable interface is used to define a natural order for objects of a class, that is, it is used to define how objects of a class should be compared to each other.

In the following example, the Product class implements the Comparable interface, and the compareTo method is overridden to compare the prices of the products in ascending order.

***

Exemplo / Example:

```java
public class Product implements Comparable<Product> {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getname() {
        return name;
    }

    public double getprice() {
        return price;
    }

    @Override
    public int compareTo(Product outro) {
        return Double.compare(price, outro.price);
    }
}
```

## Métodos default / Default methods
**PT-BR**  
A partir do Java 8, interfaces podem ter métodos concretos, ou seja, métodos que já possuem uma implementação padrão, que podem ser sobrescritos pelas classes que implementam a interface.

A intenção básica dos métodos default é prover implementações padrão para métodos que podem ser comuns a várias classes que implementam a interface, evitando:
- repetição da implementação do método;
- a necessidade de criar uma classe abstrata para prover a implementação padrão;

Outras vantagens são:
- Manter a retrocompatibilidade com as classes que já implementam a interface;
- Permitir que interfaces funcionais possam prover outras operações padrão reutilizáveis;

**EN-US**  
From Java 8, interfaces can have concrete methods, that is, methods that already have a default implementation, which can be overridden by the classes that implement the interface.

The basic intention of default methods is to provide default implementations for methods that can be common to several classes that implement the interface, avoiding:
- repetition of method implementation;
- the need to create an abstract class to provide the default implementation;

Other advantages are:
- Maintain backward compatibility with classes that already implement the interface;
- Allow functional interfaces to provide other reusable default operations;

***
Exemplo / Example:

```java
public interface InterestService {

	double getInterestRate();

	default double payment(double amount, int months) {
		if (months < 1) {
			throw new InvalidParameterException("Months must be greater than zero");
		}
		return amount * Math.pow(1.0 + getInterestRate() / 100.0, months);
	}
}
```