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
