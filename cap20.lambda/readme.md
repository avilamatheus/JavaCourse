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

## Sintaxe / Syntax:

```java
public interface Predicate<T> {
	boolean test(T t);
}
```


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


<details>  

<summary>  

# Consumer

</summary>

## Sintaxe / Syntax:

```java
public interface Consumer<T> {
	void accept(T t);
}
```


## Exemplos de implementação do Consumer / Consumer implementation examples:

1 - Implementação da interface Consumer / Consumer interface implementation:
```java
public class PriceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}
}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list.forEach(new PriceUpdate());

		list.forEach(System.out::println);
}
```

***

2 - Reference method com método estático / Reference method with static method:
```java

public class Product {

	/// ... 

	public static void staticPriceUpdate(Product p) {
		p.setPrice(p.getPrice() * 1.1);
	}

}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list.forEach(Product::staticPriceUpdate);

		list.forEach(System.out::println);
}
```

***

3 - Reference method com método não estático / Reference method with non-static method:
```java
public class Product {

	/// ... 

	public void nonStaticPriceUpdate() {
		price = price * 1.1;
	}

}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));

		list.forEach(Product::nonStaticPriceUpdate);

		list.forEach(System.out::println);
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

		double factor = 1.1;
		Consumer<Product> cons = p -> p.setPrice(p.getPrice() * factor);

		list.forEach(cons);

		list.forEach(System.out::println);
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

		double factor = 1.1;
		list.forEach(p -> p.setPrice(p.getPrice() * factor));

		list.forEach(System.out::println);
}
```

</details>

<details>  

<summary>  

# Function

</summary>

## Sintaxe / Syntax:

```java
public interface Function<T, R> {
	R apply(T t);
}
```


## Exemplos de implementação da Function / Function implementation examples:

1 - Implementação da interface Function / Function interface implementation:
```java
public class UpperCaseName implements Function<Product, String> {

	@Override
	public String apply(Product p) {
		return p.getName().toUpperCase();
	}
}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));


		// A função "map" é uma função que aplica uma função a cada elemento de uma stream.
		// list.stream() - converte a lista para stream
		// .collect(Collectors.toList()) - converte a stream para lista

		// The "map" function applies a function to each element of a stream.
		// list.stream() - converts the list to a stream
		// .collect(Collectors.toList()) - converts the stream to a list
		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());

		names.forEach(System.out::println);
}
```

***

2 - Reference method com método estático / Reference method with static method:
```java
public class Product {

	/// ... 

	public static String staticUpperCaseName(Product p) {
		return p.getName().toUpperCase();
	}

}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));


		List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

		names.forEach(System.out::println);
}
```

***

3 - Reference method com método não estático / Reference method with non-static method:
```java
public class Product {

	/// ... 

	public String nonStaticUpperCaseName() {
		return name.toUpperCase();
	}

}

public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));


		List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

		names.forEach(System.out::println);
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

		Function<Product, String> func = p -> p.getName().toUpperCase();

		List<String> names = list.stream().map(func).collect(Collectors.toList());

		names.forEach(System.out::println);
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

		List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

		names.forEach(System.out::println);
}
```




</details>