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
* Hibernate
* Oracle Server

## Szczegóły projektu - główne feature’y aplikacji
autentykacja użytkowników
udostępnienie swojego treningu kolarskiego
dodawanie znajomych
oglądanie treningów innych użytkowników
dostęp do rankingów rankingów
porównywanie osiągów (np. średnich czasów na trasach)

## Model danych


## Flow aplikacji:

1. Po uruchomieniu pojawia się ekran logowania i rejestracji.
Umożliwia on stworzenie konta (identyfikowanego nickiem) lub
zalogowanie się do już istniejącego.

--screen--

2. Ekran domowy pozwala na monitorowanie swoich ostatnich przejazdów
i dodanie nowego za pomocą formularza. Pozwala też na przekierowanie do
widoków Friends, Bike oraz Log out, za pomocą przycisków.
Możliwe jest też przejście do ekranu dedykowanego jednej trasie, przez kliknięcie na swój przejazd na tej trasie.

--screen--

3. Ekran Friends pokazuje listę znajomych oraz listę ich ostatnich przejazdów.

--screen--

4. Ekran Route umożliwia przeglądnięcie wszystkich przejazdów na wybranej trasie.
Pokazuje też, jaki jest najlepszy czas na tej trasie, czas aktualnego użytkownika,
różnicę, oraz miejsce, które zajmuje w rankingu tej trasy.

--screen--

5. Bike View pokazuje informacje o aktualnym rowerze użytkownika.

--screen--

