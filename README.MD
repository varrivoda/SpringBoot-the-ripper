# ����� 1. ��������� �������.
��� ����� ������� ����� �������� "��������� �����" �� "���� ���������" � �������  ������-����. ����� ����� ������,������� ������ �������: ��� ������������ ��� ���������� ������� bank (id, total_amount), ��� ������� ������� � ����������� � ��������� �� ������. ��� �������� ���������� ��������� ��������� 
    insert into bank(..) values (0, 100500)
� ��� ��������� ����� �������� ������� (TransferMoneyService), ������ ��������� ������� �������� �� ������������� (PredskazService).

����������� � ������:
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

...���� ����� ��, ��� ������� �� ������� �������� ������.
��� ������ ����������.....(todo �������� ��� ������)

�� � ��,� ������� �� ������


*��� �������� ������� � ���������� ���� dependencyManagement �������, ����� target ������ 7.96��
*���� ������ � ���,��� �������� �������, �� ���� dependencyManagement ����� �� ��������, �� ���� � ���� ���� <parent...> � � ��� �� 

    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.1.9</version>

*����� ������������� ����� � ��� �� ���������,��� �� ������� ������ ����� target �� ���������, ������ ���� �� ���������� war ������ �� �����...