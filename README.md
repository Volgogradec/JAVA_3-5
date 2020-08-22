## Задача №1 - "Менеджер Товаров"

На основании проекта из лекции необходимо реализовать менеджер товаров, который умеет:

1. Добавлять товары в репозиторий
1. Искать товары (репозиторий должен отдать все товары, а менеджер уже потом по ним ищет*)

Примечание*: это не самый эффективный способ. Когда мы будем проходить базы данных, поговорим, что это лучше делать там (ещё лучше - воспользоваться специализированным решением).

Что нужно сделать:
1. Разработайте базовый класс `Product`, содержащий `id`, название, стоимость
1. Разработать два унаследованных от `Product` класса: `Book` (с полями название* и автор) и `Smartphone` (с полями название* и производитель)
1. Разработайте репозиторий, позволяющий сохранять `Product`'ы, получать все сохранённые `Product`'ы и удалять по `id`
1. Разработайте менеджера, который умеет добавлять `Product`'ы в репозиторий и осуществлять поиск по ним 

Примечание*: надеемся, вы догадались, что название итак уже есть в классе `Product`

#### Как осуществлять поиск

У менеджера должен быть метод `searchBy(String text)`, который возвращает массив найденных товаров 

```java
public class ProductManager {
  // добавьте необходимые поля, конструкторы и методы

  public Product[] searchBy(String text) {
    // ваш код
  }

  public boolean matches(Product product, String search) {
    // ваш код
  }
}
```

Менеджер при переборе всех продуктов, хранящихся в репозитории, должен для каждого продукта вызывать собственный метод `matches`, который проверяет, соответствует ли продукт поисковому запросу.

Проверку соответствия проводится с помощью `instanceof` - для книги по полям название и автор, для смартфона по полям название и производитель.

Пример того, как это можно сделать:

```java
if (product instanceof Book) {
    Book book = (Book) product;
    if (book.getName().equalsIgnoreCase(search)) {
      return true;
    }  
    if (book.getAuthor().equalsIgnoreCase(search)) {
      return true;
    }  
    return false;
}
```

Q: Откуда взять информацию о методе `equalsIgnoreCase`?

A: Вам нужно посмотреть [документацию на класс `String`](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#method.summary)* (ведь `book.getName()` возвращает объект класса `String`) и подобрать необходимые методы (на ваше усмотрение). Это очень важно: знать какие классы есть в стандартной библиотеки и какие методы они предоставляют! 

Примечание*: воспринимайте пока `CharSequence` как `String`.

<details>
  <summary>Подсказка</summary>
  
```java
public class ProductManager {
  // добавьте необходимые поля, конструкторы и методы

  public Product[] searcyBy(String text) {
    Product[] result = new Product[0];
    for (Product product: repository.findAll()) {
      if (matches(product, text)) {
        Product[] tmp = new Product[result.length + 1];
        // используйте System.arraycopy, чтобы скопировать всё из result в tmp
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }

  public boolean matches(Product product, String search) {
    // ваш код
  }
}
```
</details>

Требования к проекту:
1. Создайте ветку (не делайте ДЗ в `master`!)
1. Подключите плагин Surefire так, чтобы сборка падала в случае отсутсвия тестов
1. Подключите плагин JaCoCo в режиме генерации отчётов (обрушать сборку по покрытию не нужно)
1. Реализуйте нужные классы и методы
1. Напишите автотесты на метод поиска (только на метод поиска в менеджере), добившись 100% покрытия по branch'ам* (вспомните, что мы говорили про тестирование методов, возвращающих набор значений)
1. Подключите CI на базе Github Actions и выложите всё на Github

Примечание*: использовать Mockito или нет, мы оставляем на ваше усмотрение.

Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код в ветке (в `master` должен быть только `pom.xml`).