<details>  

<summary>  

# Expressões Lambda / Lambda Expressions

</summary>

**PT-BR**  
Expressões lambda são funções anônimas que podem ser tratadas como objetos e passadas como argumentos para métodos ou retornadas por métodos, implementando interfaces funcionais.

**EN-US**  
Lambda expressions are anonymous functions that can be treated as objects and passed as arguments to methods or returned by methods, implementing functional interfaces.

***
Exemplo / Example:
```java
public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		Comparator<Product> comp1 = (p1, p2) -> {
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};

        Comparator<Product> comp2 = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

		list.sort(comp1);
        list.sort(comp2);

        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

		for (Product p : list) {
			System.out.println(p);
		}
	}
```

</details>

<details>  

<summary>  

# Interfaces Funcionais / Functional Interfaces

</summary>

**PT-BR**  
Uma interface funcional é uma interface que possui exatamente um método abstrato, sendo suas implementações tratadas como expressões lambda.
Alguns exemplos são Predicate, Consumer, Function e Supplier.

**EN-US**
A functional interface is an interface that has exactly one abstract method, with its implementations treated as lambda expressions.
Some examples are Predicate, Consumer, Function and Supplier.
</details>

<details>  

<summary>  

# Predicate

</summary>

## Exemplos de implementação de Predicate / Predicate implementation examples:  

1- Implementação da interface Predicate / Predicate interface implementation:
```java
public class ProductPredicate implements Predicate<Product> {

	@Override
	public boolean test(Product p) {
		return p.getPrice() >= 100.0;
	}
}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list.removeIf(new ProductPredicate());

		for (Product p : list) {
			System.out.println(p);
		}
}
```

***

2 - Reference method com método estático / Reference method with static method:
```java
public class Product {

	/// ... 

	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100.0;
	}

}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list.removeIf(Product::staticProductPredicate);

		for (Product p : list) {
			System.out.println(p);
		}
}
```

***

3 - Reference method com método não estático / Reference method with non-static method:
```java
public class Product {

	/// ... 

	public boolean nonStaticProductPredicate() {
		return price >= 100.0;
	}

}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list.removeIf(Product::nonStaticProductPredicate);

		for (Product p : list) {
			System.out.println(p);
		}
}
```

***

4 - Expressão lambda declarada / Declared lambda expression:
```java
public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		double min = 100.0;
		Predicate<Product> pred = p -> p.getPrice() >= min;

		list.removeIf(pred);

		for (Product p : list) {
			System.out.println(p);
		}
}
```

***

5 - Expressão lambda inline / Inline lambda expression:
```java
public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		double min = 100.0;
		list.removeIf(p -> p.getPrice() >= min);

		for (Product p : list) {
			System.out.println(p);
		}
}
```




</details>