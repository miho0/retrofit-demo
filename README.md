## Zakaj?
Retrofit je visoko nivojska knjižnica, ki je zgrajena na podlagi OkHttp. Je pa precej bolj specializirana. Za razliko od OkHttp, kjer lahko skonfiguriramo marsikatere klice,
je Retrofit namenjen zgolj RESTful API klicem. Je torej odlična izbira, če želimo v našo aplikacijo integrirati RESTful API.

## Prednosti
- enostavnost uporabe; če poznamo REST arhitekturo, je uporaba knjižnice zelo enostavna.
- berljivost in preglednsot kode; pri večjih projektih se nam večkrat zgodi, da se zgubimo in ne vemo več, kje se kliče kaj. Pri retrofit-u pa imamo zelo pregledno definirano, kaj se kliče pri posamezni funkciji in kateri parametri sodijo kam.
- možnost dobre modularnosti; sistem lahko razdelimo na manjše dele, ki med seboj niso odvisni, kar omogoča ločevanje odgovornosti (vsak modul je npr. odgovoren zgolj za eno skupino endpointov), in ponovno uporabo kode.
- obdelovanje napak; retrofit bo v različnih primerih vrgel različne napake (npr. napaka avtentikacije (401), not found (404). Na različne tipe napak se lahko nato ustrezno odzovemo.
- varnost tipov; definiramo, v kateri tip se nam podatki pretvorijo. Tako lahko napake, ki bi jih sicer ugotovili v času zagona, ugotovimo že v času prevajanja.

## Slabosti
- omejenost; z retrofitom lahko "out of the box" delamo zgolj z REST arhitekruro. To pomeni, da ga ne moremo uporabljati za npr. SOAP protokol ali za WebSockets.
- odvisnost od zunanjih knjižnic; če uporabljamo retrofit, to pomeni, da bomo morali uporabljati tudi nekatere druge knjižnice, kot je npr. Gson za pretvorbo podatkov. To pomeni, da bomo morali upravljati več odvisnosti v našem projektu.

## Licenca
Retrofit uporablja licenco Apache 2.0. To pomeni, da je odprtokoden projekt, kateremu lahko kdorkoli prispeva. 

## Število uporabnikov
Na githubu ima projekt več kot 42 tisoč zvezdic in 12 tisoč repozitorijev, ki so odvisni od njega.

## Vzdrževanje projekta
Retrofit je razvilo podjetje square. Projekt ima na githubu 172 razvijalcev in več kot 7000 forkov. Projekt je aktiven, zadnji commiti so bili narejeni včeraj (18.12.2023).
