# Testo forma

Programa sukuria paprasta web-formą su klausimais bei atsakymų variantais

## Pradžia

Aplikacija paleidžiamas iš .jar failo
* [testing.jar](https://we.tl/t-rjhElvc5Nf) 
```
java -jar testing.jar
```

### Back-end
```
Java SE 11
Spring Boot 2.2.1
Maven 3.6.1
Lombok v1.18.10
H2
```
### Front-end
```
AngularJS
```
## Klasės/Ryšiai
Programoje yra trys POJO klasės - Question, Answer, Item.
* Question -> Answer (@OneToOne)
* Item: naudojama JSON objektų skaitymui

## Programos veikimas

Paleidus programą, atsidaro (http://localhost:8080/) web-forma, kurioje atvaizduojami iš file.json nuskaityti klausimai su atsakymų variantais:

```
	Bendras Testas

    Žalios spalvos bangos ilgis?
         o 300nm
         o 400nm
         o 500nm
    Kokios dalelės įeina į atomo branduolį?
         o elektronas
         o mezonas
         o bizonas
         o kojotas
    Kas suskaičiavo iki begalybės du kartus?
         o Klintas Eastwoodas
         o Alfa vyras
         o Vitalija Katunskytė 
```
Pasirinkus atsakymų variantus ir paspaudus mygtuką "Išsaugoti", rezultatai (klausimai su pasirinktais atsakymais) išsaugomi duomenų bazėje): 
QUESTION lentelės turinys:
```
select * from question;
QUESTION_ID  	QUESTION_BODY  					ANSWER_ID  
1		Žalios spalvos bangos ilgis?			2
3		Kokios dalelės įeina į atomo branduolį?		4
5		Kas suskaičiavo iki begalybės du kartus?	6
(3 rows, 15 ms)
```
ANSWER lentelės turinys:
```
select * from answer;
ANSWER_ID  	ANSWER_BODY  
2	400nm
4	elektronas
6	Alfa vyras
(3 rows, 10 ms)
```
## Papildoma info
* jei mygtukas "Išsaugoti" paspaudžiamas nepasirinkus atsakymų(atsakymo), duomenų bazėje prie klausimo atitinkamai įrašoma "atsakymas nepasirinktas".