<details><summary>

# Generics

</summary>

## Introdução / Introduction
**PT-BR**  
Permitem que classes, interfaces e métodos possam ser parametrizados por tipos. Seus benefícios incluem:
- Reuso de código
- Type safety
- Performance

Um exemplo de uso de generics é a classe `ArrayList` que pode ser parametrizada por um tipo de objeto:
```java
ArrayList<String> list = new ArrayList<String>();
```

***

**EN-US**  
Allow classes, interfaces and methods to be parameterized by types. Its benefits include:
- Code reuse
- Type safety
- Performance

An example of using generics is the `ArrayList` class that can be parameterized by an object type:
```java
ArrayList<String> list = new ArrayList<String>();
```

***

Exemplo básico da sintaxe de generics com declaração de uma classe e sua instância / Basic example of generics syntax with class declaration and its instance:

```java
public class GenericsExample<T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}

public static void main(String[] args) {
    GenericsExample<Integer> integerBox = new GenericsExample<Integer>();
    GenericsExample<String> stringBox = new GenericsExample<String>();
    integerBox.set(new Integer(10));
    stringBox.set(new String("Hello World"));
}
```

Exemplo sem parametrizar a classe e sim o método / Example without parameterizing the class but the method:

```java
public class GenericsExample {
    public static <T> T getFirstElement(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}

// exemplo de uso / usage example
List<String> list = new ArrayList<>();
list.add("Hello");
list.add("World");
String first = GenericsExample.getFirstElement(list);
```

## Genéricos Delimitados / Bounded Generics
```java
public class GenericsExample<T extends Something> {
    private T t;
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }
}
```

Exemplo com Comparable / Example with Comparable:
```java
public class Product implements Comparable<Product> {
    private String name;
    private Double price;
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public int compareTo(Product other) {
        return price.compareTo(other.getPrice());
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
}

public class Calculation {
    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalStateException("List can't be null or empty");
        }
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}

// exemplo de uso / usage example
public class static main(String[] args) {
    List<Product> list = new ArrayList<>();
    list.add(new Product("TV", 900.00));
    list.add(new Product("Notebook", 1200.00));
    Product max = Calculation.max(list);
    System.out.println("Max: " + max.getName());
}
```

</details>



<details>  

<summary>  

# Coringas / Wildcards

</summary>

## Introdução / Introduction
**PT-BR**  
Coringas são representados pelo símbolo <?> e são recursos que fornecem flexibilidade ao lidar com tipos desconhecidos em contextos genéricos. Eles permitem que você escreva código que pode lidar com uma variedade de tipos sem a necessidade de especificar um tipo específico. Os coringas são frequentemente usados em métodos ou classes genéricas, onde a flexibilidade é necessária.

Os coringas podem ser usados para:

- Parâmetros de método:
```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

- Variáveis Locais
```java
List<?> list = new ArrayList<>();
```

- Retorno de método
```java
public List<?> getList() {
    return new ArrayList<>();
}
```

Porém, uma limitação importante, é que não podemos adicionar dados a uma coleção de tipo coringa, exemplo:
```java
List<?> list = new ArrayList<>();
list.add("Hello"); // erro de compilação
```

***

**EN-US**  
Wildcards are represented by the symbol <?> and are features that provide flexibility when dealing with unknown types in generic contexts. They allow you to write code that can handle a variety of types without the need to specify a specific type. Wildcards are often used in generic methods or classes, where flexibility is required.

Wildcards can be used for:

- Method parameters:
```java
public void printList(List<?> list) {
    for (Object obj : list) {
        System.out.println(obj);
    }
}
```

- Local variables
```java
List<?> list = new ArrayList<>();
```

- Method return
```java
public List<?> getList() {
    return new ArrayList<>();
}
```

However, an important limitation is that we cannot add data to a wildcard type collection, example:
```java
List<?> list = new ArrayList<>();
list.add("Hello"); // compilation error
```

***

## Coringas Delimitados / Bounded Wildcards
**PT-BR**  
Coringas delimitados são coringas que têm um limite. Eles são representados por <? extends T> e <? super T>, onde T é uma classe ou interface. Eles são usados para fornecer flexibilidade ao lidar com tipos desconhecidos em contextos genéricos. 

No caso de <? extends T>, o coringa é T ou qualquer subtipo de T, sendo um coringa covariante, que não permite adicionar elementos à coleção, mas permite a leitura de elementos.

No caso de <? super T>, o coringa é T ou qualquer superclasse de T, sendo um coringa contravariante, que permite adicionar elementos à coleção, mas não permite a leitura de elementos.

***

**EN-US**  
Bounded wildcards are wildcards that have a limit. They are represented by <? extends T> and <? super T>, where T is a class or interface. They are used to provide flexibility when dealing with unknown types in generic contexts.

In the case of <? extends T>, the wildcard is T or any subtype of T, being a covariant wildcard, which does not allow adding elements to the collection, but allows reading elements.

In the case of <? super T>, the wildcard is T or any superclass of T, being a contravariant wildcard, which allows adding elements to the collection, but does not allow reading elements.

*** 
Exemplo envolvendo coringas delimitados / Example involving bounded wildcards:

```java
public class Main {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();
        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for (Number number : source) {
            destiny.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
```
</details>


<details>  

<summary>  

# hashCode & equals

</summary>

**PT-BR**  
São operações da classe Object utilizadas para comparar se um objeto é igual a outro.

- **hashCode**: É rápido, porém não é 100% confiável, existe uma pequena chance de ocorrer um falso positivo.

- **equals**: É mais lento, porém é 100% confiável.

Tipos comuns (String, Date, Integer, etc) já possuem implementações de hashCode e equals. Classes personalizadas precisam sobrescrever esses métodos.

*** 
**EN-US**  
They are operations of the Object class used to compare if an object is equal to another.

- **hashCode**: It is fast, but it is not 100% reliable, there is a small chance of a false positive.

- **equals**: It is slower, but it is 100% reliable.

Common types (String, Date, Integer, etc) already have implementations of hashCode and equals. Custom classes need to override these methods.

***

## Regra de ouro do hashCode / Golden rule of hashCode
**PT-BR**  
Se o hashCode de dois objetos for diferente, então os dois objetos são diferentes. Se o hashCode de dois objetos for igual, então os dois objetos **muito provavelmente** são iguais.

**EN-US**  
If the hashCode of two objects is different, then the two objects are different. If the hashCode of two objects is the same, then the two objects are **very likely** to be the same.

</details>

<details>  

<summary>  

# Set <T>

</summary>


**PT-BR**  
Representa um conjunto de elementos (Similar ao da Algebra). Algumas características:

- Não permite elementos duplicados
- Elementos não possuem posição
- Acesso, inserção e remoção de elementos são rápidos
- Oferece operações eficientes de conjuntos (união, interseção, diferença)
- Principais implementações:
    - **HashSet** - mais rápido (operações O(1)) e não ordenado
    - **TreeSet** - mais lento (operações O(log(n))) e ordenado pelo compareTo do objeto (ou Comparator), ou seja, a classe do objeto precisa implementar Comparable.
    - **LinkedHashSet** - velocidade intermediária e mantém a ordem de inserção.

Alguns métodos importantes:

- **add(obj)**, **remove(obj**), **contains(obj)**
    - São baseados em equals e hashCode
    - Se equals e hashCode não estiverem implementados pela classe de obj, é usada comparação de ponteiros.
- **clear()**: remove todos os elementos
- **size()**: retorna a quantidade de elementos
- **removeIf(predicate)**: remove elementos que atendem a um predicado
- **addAll(other) - união**: adiciona no conjunto os elementos de outro conjunto, sem repetição.
- **retainAll(other) - interseção**: remove do conjunto os elementos não contidos em outro conjunto.
- **removeAll(other) - diferença**: remove do conjunto os elementos contidos em outro conjunto.

***
**EN-US**  
Represents a set of elements (Similar to Algebra). Some characteristics:

- Does not allow duplicate elements
- Elements do not have position
- Access, insertion and removal of elements are fast
- Offers efficient set operations (union, intersection, difference)
- Main implementations:
    - **HashSet** - faster (operations O(1)) and unordered
    - **TreeSet** - slower (operations O(log(n))) and ordered by the object's compareTo (or Comparator), that is, the object's class needs to implement Comparable.
    - **LinkedHashSet** - intermediate speed and maintains insertion order.

Some important methods:

- **add(obj)**, **remove(obj**), **contains(obj)**
    - Are based on equals and hashCode
    - If equals and hashCode are not implemented by the obj class, pointer comparison is used.
- **clear()**: removes all elements
- **size()**: returns the number of elements
- **removeIf(predicate)**: removes elements that meet a predicate
- **addAll(other) - union**: adds to the set the elements of another set, without repetition.
- **retainAll(other) - intersection**: removes from the set the elements not contained in another set.
- **removeAll(other) - difference**: removes from the set the elements contained in another set.
 
</details>



<details>  

<summary>  

# Map <K,V>

</summary>

**PT-BR**  
É uma coleção de pares chave/valor. Algumas características:
- Não permite chaves duplicadas (sobrescreve o valor antigo)
- Os elementos são indexados pelo objeto chave (ou seja, não possuem posição)
- Acesso, inserção e remoção de elementos são rápidos
- Uso comum: cookies, local storage, qualquer modelo de dados chave-valor

Principais implementações:
- **HashMap** - mais rápido (operações O(1)) e não ordenado
- **TreeMap** - mais lento (operações O(log(n))) e ordenado pelo compareTo do objeto (ou Comparator)
- **LinkedHashMap** - velocidade intermediária e mantém a ordem de inserção.

Métodos importantes:
- put(key, value), remove(key), containsKey(key), get(key)
    - Baseados em equals e hashCode
    - Se equals e hashCode não estiverem implementados, é usada comparação de ponteiros.
- clear(), size()
- keySet(): retorna um Set<K> com as chaves
- values(): retorna uma Collection<V> com os valores

***
**EN-US**  
It is a collection of key/value pairs. Some characteristics:
- Does not allow duplicate keys (overwrites the old value)
- Elements are indexed by the key object (that is, they do not have position)
- Access, insertion and removal of elements are fast
- Common use: cookies, local storage, any key-value data model

Main implementations:
- **HashMap** - faster (operations O(1)) and unordered
- **TreeMap** - slower (operations O(log(n))) and ordered by the object's compareTo (or Comparator)
- **LinkedHashMap** - intermediate speed and maintains insertion order.

</details>