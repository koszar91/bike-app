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
* SceneBuilder
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


## Struktura kodu

Struktura kodu oparta jest na architekturze Model-View-Controller.
Widoki wyświetlane w oknie aplikacji są zdefiniowane w plikach fxml.
Do każdego widoku podporządkowana jest klasa będąca kontrolerem, odpowiedzialna za wypelnianie widoku danymi.
Pośredniczy też ona przy interakcji użytkownika z danymi.
Działanie to jest zrealizowane jest dzięki bibliotece JavaFX.
Klasy kontrolerów pobierają dane z Bazy Danych pośrednio. Jest za to odpowiedzialna klasa DBService,
zawierająca statyczne metody umożliwiające kontakt z bazą danych, takie jak dodawanie i wyciąganie obiektów z bazy.
Funkcje te realizowane są dzięki bibliotece Hibernate, oferującej wygodne API o dużych mozliwościach.

Klasy modelu, posiadające wiele właściwości z getterami i setterami mają zmniejszoną objętość dzięki bibliotece Lombok.
Pozwala ona na korzystanie z getterów, setteróe, konstruktorów bezargumentowych itp. bez pisania ich kodu.
Udostępnia ona dekoratory, które można przypisać klasom i ich atrybutom. Zwiększa to czytelność kodu.

W projekcie zawarliśmy klasą pomocniczą DataAdder, posiadającą jedną metodę add(). W tej metodzie zahardcode'owane są przykładowe dane,
którymi można wypełnić bazę danych. Jest to przydatne podczas korzystania z opcji create-drop, udostępnionej przez Hibernate'a,
polegającej na każdorazowym usunięciu i stworzeniu bazy danych przy uruchamianiu aplikacji.
Pozwala to na swobodne zmiany w modelu podczas tworzenia aplikacji.

## Sczegóły pracy biblioteki Hibernate na przykładach z kodu

Zapytania do bazy danych w naszym projekcie nie są tworzone bezpośrenio, a przy użyciu dialektu HQL (Hibernate Query Language).
Przypomina on język zapytań SQL, w którym encjami nie są tabele, a klasy modelu, stworzone po stronie Javy.
Zapytania przy użyciu HQL są wykonywane po otwarciu "sesji" i przed jej zamknięciem.
Sesja odpowiada za persystencję danych, dzięki czemu Hibernate przy przykładowym zapytaniu typu select wywołuje je, a wyciągnięte dane
są instancjonowane w obiekty Javy, należące do klas modelu.

Przykładowa metoda klasy DBService: getRidesOnRoute(Route route)

![getRides](https://user-images.githubusercontent.com/72392522/120906589-0ef20e00-c65b-11eb-9773-898cc15e2289.jpg)

Powyższy kod odpowiedzialny jest za pozyskanie z bazy danych wszystich przejazdów na podanej trasie.
Zapytanie do bazy danych napisane jest w języku HQL. Dzięki Hibernate'owej sesji dane są instancjonowane na obiekty Javy i agregowane w liście.

Inny przykład stanowi metoda getFriendsOfUser(User user):

![getFriends](https://user-images.githubusercontent.com/72392522/120906658-92abfa80-c65b-11eb-988e-b48399ec158a.jpg)

Jest ona odpowiedzialna za pozyskanie listy użytkowników będących znajomymi dla danego użytkownika.
Od strony modelu danych, w taką operacją zaangażowane są dwie tabele: tabela użytkoniwków (APPUSER)
oraz tabela ISFRIENDTO zawierająca informację o relacji znajomości (Many to many).
Wykonanie takiej operacji w języku SQL wymagałoby połączenia tabel dwoma joinami, natomiast przy użyciu HQL'a nie jest to konieczne.
Opracje joinowania są wykonywane przez Hibernate'a, który po pobraniu danych o użytkowniku (który w modelu Javovym posiada listę znajomych) wypełnia instancję obiektu na podstawie wszystkich zależnosći, zatem wypełnia również jego listę znajomych,
instancjonując ich jako obiekty zawarte w liście. Jest to znaczne ułatwienie, gwarantujące nie tylko wygodę ale również odpowiedni poziom abstrakcji, zwalniając programistę z konieczności hardcode'owania zapytań.
Uzyskanie listy znajomych na podstawie jednego obiektu wyciągniętego z bazy danych musi odbyć się 'wewnątrz sesji'.


## Baza Danych, z której korzysta aplikacja

Serwerem bazy danych SQL, z kótego korzystamy jest Oracle. Baza znajduje się w budynku uczelni, dostęp do niej odbywa się poprzez VPN.
W polączniu z tworzeniem i usuwaniem bazy przy starcie aplikacji umożliwia to korzystanie z projektu z innych maszyn niż nasze.
Przykładowe dane tworzone są we wspomniajej klasie DataAdder, której metoda add(); wywołana jest w klasie w metodzie main().
Zatem aby skorzystać z naszej aplikacji wystarczy tylko skompilować kod źródłowy i uruchomić plik wykonywalny.
