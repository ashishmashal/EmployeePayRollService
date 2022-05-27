=======================UC1.(Ability to create a payroll service database)=====================================

mysql> create databases payroll_services;

mysql> create database payroll_services;
Query OK, 1 row affected (0.01 sec)


mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| payroll_services   |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.02 sec)


mysql> use payroll_services;
Database changed


mysql> select database();
+------------------+
| database()       |
+------------------+
| payroll_services |
+------------------+
1 row in set (0.00 sec)


=========UC2(Ability to create a employee payroll table in the payroll service database to manage employee payrolls)=========

mysql> CREATE TABLE employee_payroll(id INT unsigned NOT NULL AUTO_INCREMENT,name VARCHAR(150) NOT NULL,salary DOUBLE NOT NULL,start_date DATE NOT NULL,PRIMARY KEY(id));
Query OK, 0 rows affected (0.04 sec)

+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int unsigned | NO   | PRI | NULL    | auto_increment |
| name       | varchar(150) | NO   |     | NULL    |                |
| salary     | double       | NO   |     | NULL    |                |
| start_date | date         | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
4 rows in set (0.01 sec)


=========== UC3(Ability to create employee payroll data in the payroll service database as part of CRUD Operation) ==========

mysql> insert into employee_payroll(name,salary,start_date)VALUES('Bill',1000000.00,'2010-10-30'),('Tersia',200000.00,'2019-11-13'),('Charlie',300000.00,'2020-05-21');
Query OK, 3 rows affected (0.03 sec)
Records: 3  Duplicates: 0  Warnings: 0



============= UC4(Ability to retrieve all the employee payroll data that is added to payroll service database) =============

mysql> select * from employee_payroll;
+----+---------+---------+------------+
| id | name    | salary  | start_date |
+----+---------+---------+------------+
|  1 | Bill    | 1000000 | 2010-10-30 |
|  2 | Tersia  |  200000 | 2019-11-13 |
|  3 | Charlie |  300000 | 2020-05-21 |
+----+---------+---------+------------+
3 rows in set (0.00 sec)

======================= UC5(Ability to retrieve salary data for a particular employee as well as all
employees who have joined in a particular data range from the payroll service database) ======================

mysql> select salary from employee_payroll where name ='Bill';
+---------+
| salary  |
+---------+
| 1000000 |
+---------+
1 row in set (0.01 sec)

mysql> select * from employee_payroll where start_date between cast('2010-10-30' AS
DATE) and DATE(NOW());
+----+---------+---------+------------+
| id | name    | salary  | start_date |
+----+---------+---------+------------+
|  1 | Bill    | 1000000 | 2010-10-30 |
|  2 | Tersia  |  200000 | 2019-11-13 |
|  3 | Charlie |  300000 | 2020-05-21 |
+----+---------+---------+------------+
3 rows in set (0.00 sec)

mysql> select * from employee_payroll where start_date between cast('2019-11-13' AS
DATE) and DATE(NOW());
+----+---------+--------+------------+
| id | name    | salary | start_date |
+----+---------+--------+------------+
|  2 | Tersia  | 200000 | 2019-11-13 |
|  3 | Charlie | 300000 | 2020-05-21 |
+----+---------+--------+------------+
2 rows in set (0.00 sec)


============================================= UC6(Ability to add Gender to Employee Payroll Table and Update the Rows to
 reflect the correct Employee Gender) ==================================================================================

mysql> alter table employee_payroll ADD gender char(1) AFTER name;
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc employee_payroll;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int unsigned | NO   | PRI | NULL    | auto_increment |
| name       | varchar(150) | NO   |     | NULL    |                |
| gender     | char(1)      | YES  |     | NULL    |                |
| salary     | double       | NO   |     | NULL    |                |
| start_date | date         | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)

mysql> update employee_payroll set gender = 'M' where name = 'Bill' or name ='Charlie';
Query OK, 2 rows affected (0.02 sec)
Rows matched: 2  Changed: 2  Warnings: 0

mysql> select * from employee_payroll;
+----+---------+--------+---------+------------+
| id | name    | gender | salary  | start_date |
+----+---------+--------+---------+------------+
|  1 | Bill    | M      | 1000000 | 2010-10-30 |
|  2 | Tersia  | NULL   |  200000 | 2019-11-13 |
|  3 | Charlie | M      |  300000 | 2020-05-21 |
+----+---------+--------+---------+------------+
3 rows in set (0.00 sec)


mysql> alter table employee_payroll modify gender CHAR(1) NOT NULL;
Query OK, 0 rows affected (0.08 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> desc employee_payroll;
+------------+--------------+------+-----+---------+----------------+
| Field      | Type         | Null | Key | Default | Extra          |
+------------+--------------+------+-----+---------+----------------+
| id         | int unsigned | NO   | PRI | NULL    | auto_increment |
| name       | varchar(150) | NO   |     | NULL    |                |
| gender     | char(1)      | NO   |     | NULL    |                |
| salary     | double       | NO   |     | NULL    |                |
| start_date | date         | NO   |     | NULL    |                |
+------------+--------------+------+-----+---------+----------------+
5 rows in set (0.01 sec)


================ UC7(Ability to find sum, average, min, max and number of male and female employees) ===================


mysql> select AVG(salary) from employee_payroll;
+-------------+
| AVG(salary) |
+-------------+
|      500000 |
+-------------+
1 row in set (0.00 sec)

mysql> select AVG(salary) from employee_payroll where gender ='M' GROUP BY gender;
+-------------+
| AVG(salary) |
+-------------+
|      650000 |
+-------------+
1 row in set (0.00 sec)

mysql> select AVG(salary) from employee_payroll GROUP BY gender;
+-------------+
| AVG(salary) |
+-------------+
|      650000 |
|      200000 |
+-------------+
2 rows in set (0.00 sec)

mysql> select gender,AVG(salary) from employee_payroll GROUP BY gender;
+--------+-------------+
| gender | AVG(salary) |
+--------+-------------+
| M      |      650000 |
| F      |      200000 |
+--------+-------------+
2 rows in set (0.00 sec)

mysql> select gender,SUM(salary) from employee_payroll GROUP BY gender;
+--------+-------------+
| gender | SUM(salary) |
+--------+-------------+
| M      |     1300000 |
| F      |      200000 |
+--------+-------------+
2 rows in set (0.00 sec)

mysql> select gender,SUM(salary) Sum_Of_Salary from employee_payroll GROUP BY gender
;
+--------+---------------+
| gender | Sum_Of_Salary |
+--------+---------------+
| M      |       1300000 |
| F      |        200000 |
+--------+---------------+
2 rows in set (0.00 sec)


