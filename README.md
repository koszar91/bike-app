## Miniprojekt-Bazy-Danych
Mini project for Databases lessons at AGH University

## Topic:
Console application allowing users to share their bicycle trainings and compare their results.

## Authors:
Paweł Hołowicki, Jakub Koźlak, Tomasz Koszarek



## Cel projektu
Stworzenie prostej aplikacji okienkowej służącej do zapisywania, udostępniania i porównywania swoich treningów kolarskich ze znajomymi.

## Technologia
* Java
* JavaFX
* Lombok
* Hibernate
* Oracle Server

## Szczegóły projektu - główne feature’y aplikacji
autentykacja użytkowników
udostępnienie swojego treningu kolarskiego
dodawanie znajomych
oglądanie treningów innych użytkowników
dostęp do rankingów rankingów
porównywanie osiągów (np. średnich czasów na trasach)

## Model danych!

[schema](https://user-images.githubusercontent.com/72392522/119807540-83061680-bee3-11eb-9709-ad7029ef2bdd.jpg)

## Flow aplikacji:

1. Po uruchomieniu pojawia się ekran logowania i rejestracji.
Umożliwia on stworzenie konta (identyfikowanego nickiem) lub
zalogowanie się do już istniejącego.

![log](https://user-images.githubusercontent.com/72392522/119807065-10953680-bee3-11eb-9bda-69175f8a798b.jpg)

2. Ekran domowy pozwala na monitorowanie swoich ostatnich przejazdów
i dodanie nowego za pomocą formularza. Pozwala też na przekierowanie do
widoków Friends, Bike oraz Log out, za pomocą przycisków.
Możliwe jest też przejście do ekranu dedykowanego jednej trasie, przez kliknięcie na swój przejazd na tej trasie.

![home](https://user-images.githubusercontent.com/72392522/119807074-13902700-bee3-11eb-90aa-a741395e8934.jpg)

3. Ekran Friends pokazuje listę znajomych oraz listę ich ostatnich przejazdów.

![friends](https://user-images.githubusercontent.com/72392522/119807096-1ab73500-bee3-11eb-951b-9fe561d7c9d8.jpg)

4. Ekran Route umożliwia przeglądnięcie wszystkich przejazdów na wybranej trasie.
Pokazuje też, jaki jest najlepszy czas na tej trasie, czas aktualnego użytkownika,
różnicę, oraz miejsce, które zajmuje w rankingu tej trasy.

![route](https://user-images.githubusercontent.com/72392522/119807123-20ad1600-bee3-11eb-8994-6da13172be0f.jpg)

5. Bike View pokazuje informacje o aktualnym rowerze użytkownika.

![bike](https://user-images.githubusercontent.com/72392522/119807146-27d42400-bee3-11eb-8a8e-2cfea941ee75.jpg)

