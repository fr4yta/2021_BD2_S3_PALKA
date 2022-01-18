<template>
  <div class="container">
    <h1 class="text-center">AQUAPOLSL – POMOC</h1>
    <p class="text-center">Jak poruszać się po aplikacji?</p>
    <router-link to="/">
      <p class="text-center">Powrót do strony głównej</p>
    </router-link>

    <h2>I. Zakup biletu</h2>
    <p>Wybieramy odpowiedni bilet (Ulgowy lub Normalny), następnie klikamy w napis "Kup teraz". Po jego naciśnięciu na
      ekranie pojawi nam się ikona z pomyślnym dokonaniem zakupu.</p>
    <img src="@/assets/help/1.png" alt="Help" class="img-fluid d-block mx-auto">

    <h2>II. Sprawdzenie informacji o aquaparku</h2>
    <p>W celu sprawdzenie informacji o danej atrakcji w aquaparku należy kliknąć na nazwę danej atrakcji, następnie
      wyświetli nam się okno z informacją o niej.</p>
    <img src="@/assets/help/2.png" alt="Help" class="img-fluid d-block mx-auto">

    <h2>III. Zmiana hasła klienta</h2>
    <p>1. Wybieramy na stronie głównej "Panel klienta".</p>
    <img src="@/assets/help/1.png" alt="Help" class="img-fluid d-block mx-auto">
    <p>2. Po wyświetleniu panelu przechodzimy do zakładki "Zmień hasło". Po podaniu odpowiednich danych ("Stare hasło",
      "Nowe hasło" , "Powtórz nowe hasło") naciskamy napis "Zmień hasło".</p>
    <img src="@/assets/help/3.png" alt="Help" class="img-fluid d-block mx-auto">

    <h2>IV. Sprawdzenie listy użytkowników</h2>
    <p>1. Wybieramy na stronie głównej na przycisk "Panel Admina".</p>
    <img src="@/assets/help/1.png" alt="Help" class="img-fluid d-block mx-auto">
    <p>2. Po wyświetleniu panelu przechodzimy do zakładki "Użytkownicy". Zawiera ona nazwy użytkowników, przypisany
      e-mail dla użytkownika oraz stan jego obecnej aktywności na stronie.</p>
    <img src="@/assets/help/4.png" alt="Help" class="img-fluid d-block mx-auto">

    <h2>V. Modyfikacja cennika/listy ofert</h2>
    <p>1. Wybieramy na stronie głównej na przycisk "Panel Admina".</p>
    <img src="@/assets/help/1.png" alt="Help" class="img-fluid d-block mx-auto">
    <p>2. Po wyświetleniu panelu przechodzimy do zakładki "Cenniki / listy ofert", a w niej wybieramy pozycję "Dodaj".
      Następnie pojawia nam się możliwość dodania nowej pozycji do cennika oraz obecnie dostępnych ofert. W celu dodania
      pozycji należy przypisać dla niej odpowiednia cenę oraz wybrać typu biletu z listy. Po naciśnięciu napisu "Dodaj"
      pozycja zostaje dodana do oferty.</p>
    <img src="@/assets/help/5.png" alt="Help" class="img-fluid d-block mx-auto">

    <h2>VI. Wyświetlanie cenników</h2>
    <p>1. Wybieramy na stronie głównej na napis "Panel Admina", następnie po wyświetleniu panelu przechodzimy do
      zakładki "Cenniki / listy ofert", a w niej wybieramy pozycję "Cenniki". Zawiera ona nazwę danego cennika oraz
      przedział czasowy w którym obowiązuje.</p>
    <img src="@/assets/help/6.png" alt="Help" class="img-fluid d-block mx-auto">

    <h2>VII. Utworzenie konta klienta</h2>
    <p>1. Wybieramy na stronie głównej na napis "Logowanie".</p>
    <img src="@/assets/help/1.png" alt="Help" class="img-fluid d-block mx-auto">
    <p>2. Następnie na ekranie po wyświetleniu ekranu logowania, klikamy na napis "Zarejestruj się!"</p>
    <img src="@/assets/help/7.png" alt="Help" class="img-fluid d-block mx-auto">
    <p>3. Pojawia nam ekran rejestracji użytkownika, w którym należy podać: nazwę użytkownika, e-mail, hasło. Operacje
      rejestracji potwierdzamy kliknięciem napisu "ZAJERESTRUJ SIĘ".</p>
    <img src="@/assets/help/8.png" alt="Help" class="img-fluid d-block mx-auto">

    <h2>VIII. Logowanie</h2>
    <p>1. Wybieramy na stronie głównej na napis "Logowanie".</p>
    <img src="@/assets/help/1.png" alt="Help" class="img-fluid d-block mx-auto">
    <p>2. Następnie na ekranie po wyświetleniu ekranu logowania, możemy się zalogować wpisując odpowiednie dane oraz
      naciśnięciu napisu "ZALOGUJ SIĘ". W przypadku podania nieprawidłowych danych lub pozostawienia pola pustego
      zostaniemy poinformowani odpowiednim komunikatem o błędzie.</p>
    <img src="@/assets/help/7.png" alt="Help" class="img-fluid d-block mx-auto">
    <img src="@/assets/help/9.png" alt="Help" class="img-fluid d-block mx-auto">
  </div>
</template>

<script>
export default {
  name: 'Help'
}
</script>

<style scoped>
h2 {
  margin-top: 100px;
}

.container {
  margin-bottom: 100px;
}

img {
  margin-bottom: 50px;
  width: 50%;
}
</style>