# Todo

## <p id="contents">Оглавление</p>

<ul>
<li><a href="#01">Описание проекта</a></li>
<li><a href="#02">Стек технологий</a></li>
<li><a href="#03">Требования к окружению</a></li>
<li><a href="#04">Сборка и запуск проекта</a>
    <ol type="1">
        <li><a href="#0401">Сборка проекта</a></li>
        <li><a href="#0402">Запуск проекта</a></li>
    </ol>
</li>
<li><a href="#05">Взаимодействие с приложением</a>
    <ol  type="1">
        <li><a href="#0501">Страница регистрации</a></li>
        <li><a href="#0502">Страница входа</a></li>
        <li><a href="#0503">Страница списка задач</a></li>
        <li><a href="#0504">Страница создания задачи</a></li>
        <li><a href="#0505">Страница с подробной информацией о задаче</a></li>
        <li><a href="#0506">Страница редактирования задачи</a></li>
        <li><a href="#0507">Редактирование профиля</a></li>
        <li><a href="#0508">Выход из приложения</a></li>
    </ol>
</li>
<li><a href="#contacts">Контакты</a></li>
</ul>

## <p id="01">Описание проекта</p>

Веб приложение для учета дел.

Функционал:

* Добавление дел, проставление отметок о выполнении, редактирование.
* Возможность отображения всех дел, новых или только невыполненных.

<p><a href="#contents">К оглавлению</a></p>

## <p id="02">Стек технологий</p>

- Java 17
- Spring Boot 2.7
- HTML 5, Thymeleaf, Bootstrap 4
- Hibernate 5.6, PostgreSQL 14
- JUnit 5, Mockito
- Maven 3.8

Инструменты:

- Javadoc, JaCoCo, Checkstyle

<p><a href="#contents">К оглавлению</a></p>

## <p id="03">Требования к окружению</p>

Java 17, Maven 3.8, PostgreSQL 14

<p><a href="#contents">К оглавлению</a></p>

## <p id="04">Сборка и запуск проекта</p>

### <p id="0401">1. Сборка проекта</p>

Команда для сборки в jar:
`mvn clean package -DskipTests`

<p><a href="#contents">К оглавлению</a></p>

### <p id="0402">2. Запуск проекта</p>

Перед запуском проекта необходимо создать базу данных todo
в PostgreSQL, команда для создания базы данных:
`create database todo;`
Средство миграции Liquibase автоматически создаст структуру
базы данных и наполнит ее предустановленными данными.
Команда для запуска приложения:
`mvn spring-boot:run`

<p><a href="#contents">К оглавлению</a></p>

## <p id="05">Взаимодействие с приложением</p>

Локальный доступ к приложению осуществляется через любой современный браузер
по адресу `http://localhost:8080`

### <p id="0501">1. Страница регистрации</p>

На странице регистрации пользователю необходимо заполнить поля:
Имя, электронная почта, дважды ввести пароль.

![alt text](img/todo_0_1.png)

При несоблюдении требований к данных формы, на странице регистрации
будут отражены замечания.

![alt text](img/todo_0_2.png)

<p><a href="#contents">К оглавлению</a></p>

### <p id="0502">2. Страница входа</p>

На странице входа необходимо указать адрес электронной почты и
ввести свой пароль.

![alt text](img/todo_0_3.png)

При неправильных учетных данных, об этом будет выведено
сообщение на странице входа.

![alt text](img/todo_0_4.png)

<p><a href="#contents">К оглавлению</a></p>

### <p id="0503">3. Страница списка задач</p>

На странице списка задач отображаются все задачи. При клике по названию задачи
происходит переход на страницу с подробной информацией о задаче.

![alt text](img/todo_1_1.png)

При переходе по ссылке 'Новые', в списке задач отображаются невыполненные задачи.

![alt text](img/todo_1_2.png)

При переходе по ссылке 'Выполнено', в списке задач отображаются выполненные задачи.

![alt text](img/todo_1_3.png)

<p><a href="#contents">К оглавлению</a></p>

### <p id="0504">4. Страница создания задачи</p>

На странице необходимо задать наименование задачи, подробное описание, статус, 
приоритет и выбрать одну или несколько категорий.
По умолчанию задача будет активна.

![alt text](img/todo_2.png)

<p><a href="#contents">К оглавлению</a></p>

### <p id="0505">5. Страница с подробной информацией о задаче</p>

На странице отображается подробное описание задачи, есть возможность перевести
задачу в выполненные (кнопка 'Выполнено'), перейти к редактированию задачи
(кнопка 'Отредактировать') и удалить задачу (кнопка 'Удалить').

![alt text](img/todo_3_1.png)

Если пользователь заходит не в свою задачу, раздел с действиями на странице
отсутствует.

![alt text](img/todo_3_2.png)

<p><a href="#contents">К оглавлению</a></p>

### <p id="0506">6. Страница редактирования задачи</p>

Страница аналогична странице по созданию задачи. 

![alt text](img/todo_4.png)

<p><a href="#contents">К оглавлению</a></p>

### <p id="0507">7. Редактирование профиля</p>

На странице редактирования профиля можно изменить: имя, пароль, 
установить временную зону пользователя, при регистрации временная
зона равна 'Europe/London'.

![alt text](img/todo_5_1.png)

Проверка новых значений данных пользователя происходит по правилам регистрации
и аналогичным выводом ошибок заполнения в соответствующие поля.

![alt text](img/todo_5_2.png)

<p><a href="#contents">К оглавлению</a></p>

### <p id="0508">8. Выход из приложения</p>

При нажатии в панели навигации на ссылку "Выход", происходит
выход пользователя из приложения с перенаправлением на страницу входа и
сообщением о том, что пользователь вышел. При выходе сессия в которой работал
пользователь удаляется.

![alt text](img/todo_6.png)

<p><a href="#contents">К оглавлению</a></p>

## <p id="contacts">Контакты</p>

[![alt-text](https://img.shields.io/badge/-telegram-grey?style=flat&logo=telegram&logoColor=white)](https://t.me/T_AlexME)
&nbsp;&nbsp;
[![alt-text](https://img.shields.io/badge/@%20email-005FED?style=flat&logo=mail&logoColor=white)](mailto:amemelyanov@yandex.ru)
&nbsp;&nbsp;

<p><a href="#contents">К оглавлению</a></p>