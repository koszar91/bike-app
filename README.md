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
Autentykacja użytkowników

Udostępnienie swoich przejazdów kolarskich

Dodawanie znajomych oraz przeglądanie ich przejazdów

Porównywanie się na trasach

## Model danych

[schema](https://user-images.githubusercontent.com/72392522/119807540-83061680-bee3-11eb-9709-ad7029ef2bdd.jpg)

## Flow aplikacji:

1. Po uruchomieniu pojawia się ekran logowania i rejestracji.
Umożliwia on stworzenie konta (identyfikowanego nickiem) lub
zalogowanie się do już istniejącego. Przy próbie zalogowania się na nieistniejące konto
lub zarejestrowania istniejącego już konta, aplikacja wyświetli komunikat o tym, że jest to niemożliwe.

![log](https://user-images.githubusercontent.com/72392522/119807065-10953680-bee3-11eb-9bda-69175f8a798b.jpg)

2. Ekran domowy pozwala na monitorowanie swoich ostatnich przejazdów
i dodanie nowego za pomocą formularza.
Pozwala też na przekierowanie dowidoków Friends, Bike oraz Log out, za pomocą przycisków.
Możliwe jest też przejście do ekranu dedykowanego jednej trasie, przez kliknięcie na swój przejazd na tej trasie.

![home](https://user-images.githubusercontent.com/72392522/120905544-13b2c400-c653-11eb-943d-917ddae536b7.jpg)

3. Ekran Friends pokazuje listę znajomych oraz listę ich ostatnich przejazdów.

![friends](https://user-images.githubusercontent.com/72392522/120905669-faf6de00-c653-11eb-8d19-89ff1fde2973.jpg)

4. Ekran Route umożliwia przeglądnięcie wszystkich przejazdów na wybranej trasie.
Pokazuje też, jaki jest najlepszy czas na tej trasie, czas aktualnego użytkownika,
różnicę, oraz miejsce, które zajmuje w rankingu tej trasy.
Po kliknięciu w trasę przejechaną przez innego użykownika możliwe jest dodanie go do znajomych, poprzez odblokowanie przycisku Add Friend.

![route](https://user-images.githubusercontent.com/72392522/120906147-52e31400-c657-11eb-97ea-997963bc872d.jpg)

5. Bike View pokazuje informacje o aktualnym rowerze użytkownika oraz umożliwia ich zmianę.

![bike](https://user-images.githubusercontent.com/72392522/120906184-a0f81780-c657-11eb-9bc9-61ca57da7bee.jpg)


## TODO:
1. opis struktury kodu
2. zrzut bazy
3. analiza sposobu, w jaki hibernate wykonuje zapytania do bazy i co z tego wyciągamy
