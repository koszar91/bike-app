## Miniprojekt-Bazy-Danych
Mini project for Databases lessons at AGH University

## Topic:
Console application allowing users to share their bicycle trainings and compare their results.

## Authors:
Paweł Hołowicki, Jakub Koźlak, Tomasz Koszarek




## Cel projektu
Stworzenie prostej aplikacji konsolowej/okienkowej służącej do zapisywania, udostępniania i porównywania swoich treningów kolarskich ze znajomymi.

## Technologia
* Java
* Hibernate
* Oracle Server

## Szczegóły projektu - główne feature’y aplikacji
autentykacja użytkowników
udostępnienie swojego treningu kolarskiego
dodawanie znajomych
oglądanie treningów innych użytkowników
tworzenie i oglądanie rankingów
porównywanie osiągów (np. średnich czasów na trasach)

## Wstępny model danych
* “Użytkownik”, który posiada swoje minimalne dane osobowe oraz wskazania do swoich znajomych (relacja n:n)
* “Rower” (relacja  użytkownikiem), parametry pojazdu
* “Trening” lub “przejazd” rozumiany jest jako zestaw danych postaci: data, godzina rozpoczęcia, godzina zakończenia, trasa, zdjęcie, kategoria (kolarstwo górskie lub szosowe        (hierarchia typów)
* “Trasa” rozróżniana przy pomocy opisu, posiada informacje o lokalizacji, długości, różnicy wysokości (relacja z treningiem)

## Wygląd aplikacji 
Użytkownikowi udostępniany jest ekran logowania/rejestracji, następnie ekran domowy pokazujący ostatnie przejazdy, średnie prędkości, kalendarz z zaznaczonymi datami przejazdów.
Do porównywania treningów z innymi służył będzie widok zawierający rankingi/statystyki, zarówno ogólne jak i np. miesięczne, segregowane kategorią lub płcią
