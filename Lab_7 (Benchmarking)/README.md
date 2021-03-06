# Лабораторная работа №7
## Сравнение скорости методов определения, является ли строка числом (проверка исключения / посимвольно / с помощью регулярного выражения)

###### Приложение, использующая набор билиотек для тестирования Java Microbenchmark Harness, позволяющее узнать что быстрее - выявление числа из строки через выброс исключения, посимвольное выявление или с помощью регулярного выражения

### Полученный результат сравнения скорости (5 итераций на разогрев, 5 рабочих итераций)
![](https://github.com/beryanow/java_optimization_labs/blob/master/Lab_7%20(Benchmarking)/screenshots/result.png?raw=true)

### Вывод
Использование исключения заметно влияет на скорость работы метода, происходит ~ семикратное замедление по сравнению с посимвольным распознаванием, самый медленный способ - используя регулярное выражение. 

# Task #7
## String number reveal speedtest comparison (exception check / character by character / using regular expression)

###### Application that uses Java Microbenchmark Harness benchmarking frameworks and shows speed comparison between using exceptions as a method of reveal, processing every string character and using regular expression

### Result (5 warmup iterations, 5 working iterations)
![](https://github.com/beryanow/java_optimization_labs/blob/master/Lab_7%20(Benchmarking)/screenshots/result.png?raw=true)

### Conclusion
Exception usage radically influences method processing speed, ~ sevenfold slowdown occurs comparing to simple character by character method, the slowest one is using regular expression.
