# Часть 1. Настройка проекта.
Для целей доклада пишем прототип "железного банка" из "игры престолов" с помощью  спринг-бута. Пишем очень быстро,поэтому ничего лишнего: для демонстрации нам достаточно таблицы bank (id, total_amount), это сводная таблица с отделениями и остатками на счетах. При поднятии приложения создается отделение 
    insert into bank(..) values (0, 100500)
и это отделение может выдавать кредиты (TransferMoneyService), логика одобрения кредита основана на предсказаниях (PredskazService).

зависимости у автора:
	compile 'org.springframework.boot:spring-boot-starter-actuator'
	compile 'org.springframework.cloud:spring-cloud-starter-feign'
	compile 'org.springframework.boot:spring-boot-starter-data-jpa'
	compile 'org.springframework.boot:spring-boot-starter-data-rest'
	compile 'org.springframework.data:spring-data-rest-hal-browser'
	compile 'org.springframework.boot:spring-boot-starter-web'
	compile 'org.flywaydb:flyway-core'
	runtime 'com.h2database:h2'
	compileOnly 'org.springframework.boot:spring-boot-configuration-processor'
	compileOnly 'org.projectlombok:lombok'
	testCompile 'org.springframework.boot:spring-boot-starter-test' 

...чёто много их, это наверно на будущее развитие лекции.
Для начала достаточно.....(todo отрезать все лишнее)

ну и да,у менявсе на мавене


*при созлании проекта я прописывал блок dependencyManagement вручную, папка target весила 7.96кб
*тема лекции о том,как работает стартер, то есть dependencyManagement будет из стартера, то есть в Поме есть <parent...> и у нас он 

    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.9</version>

*после подтягиварния всего и вся из стартеров,как ни старнно размер папки target не изменился, видимо пока не сгенерирую war ничего не пойму...



# Часть2, собственно доклад.
Программисты не любят думатьо зависимостях,
откроем пом
у нашего пома есть родитель-спринг-бут
у котокорого есть родитель Спринг-бут-депенденсис
у которгого огромный блок dependencyManagement
при помощи этогоблока указываются версии
иесли мы укажем зависимость без версии,то мавен смотрит в перенте этот блок, где прописаны версии
в этом блоке проприсано около 500 зависимостей,которые согласованы друг с другом

проблема в том,что в нашей компании есть свой parent.pom, как нам быть если мы хотим использовать его.еслимы хотим исподьщлвать Спринг? множественногонаследованиея ведь нет.

Для этоговнашем блоке dependencyManagement можно прописать импорт на так наз "bom"
подробнее см доклад "Maven vs Gradle"

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>io.spring.platform</groupId>
                <artifactId>platform-bom</artifactId>
                <version>Brussels-SR2</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

это сейчас модно,писать свои Бомы, особенно в крупных компаниях

    //в Градле это делается так:
    dependencyManagement {
        imports {
            mavenBom 'org.springframework.cloud:scpring-cloud-dependencies:Daltson.RELEASE'
        }
    }

Теперь непосредственно о зависимостях конкретнонашего приложения:
допустим, нам надо чтобы оно отвечало по http, имело пожддержку БД и JPA
Раньше это было так: "мне надоработать с БД" - и начинается: transactionalManager, SpringTX, Hibernate-entityManager -core  ит.д.. Потом, "нам нужен Спринг" - значит нужет СпрингORM...

Для одной простой strob надо былодумать о 3-5 зависимостях.
Теперь за нас об этом думает Стартер.

Идея стартера такая (кроме всего прочего), что он агрегирует те зависимости, которые нужны длятого "мира",откуда он пришел. Если это Стартер-security, то мы не думаем о том, какие нужны зависимости для security, астартер уже сагрегировал всеэти зависимости. Тоже для data-jpa и всегопрочего. Таким образом,у нас Пом выглядит в 3-5 зависимости - точто нужно, плюс например база данных.

