# Retrofit
Retrofit je visoko nivojska knjižnica, ki jo je razvil Square. Uporablja se za poenostavljeno pisanje API klicev za REST API-je.

## Zakaj?
Ko pišemo uporabniški vmesnik, se nam pogosto zgodi, da zraven njega potrebujemo še strežnik. Razlogov za to je lahko več, npr. kompleksnejši izračuni, ki jih želimo izvesti na strežniku, uporaba podatkovne baze itd.
Če smo se odločili strežnik narediti po REST arhiterkturi, potem nam Retrofit ponuja enostaven, berljiv način za integracijo našega API-ja.

## Prednosti
- enostavnost uporabe; če poznamo REST arhitekturo, je uporaba knjižnice zelo enostavna.
- berljivost in preglednsot kode; pri večjih projektih se nam večkrat zgodi, da se zgubimo in ne vemo več, kje se kliče kaj. Pri retrofit-u pa imamo zelo pregledno definirano, kaj se kliče pri posamezni funkciji in kateri parametri sodijo kam.
- možnost dobre modularnosti; sistem lahko razdelimo na manjše dele, ki med seboj niso odvisni, kar omogoča ločevanje odgovornosti (vsak modul je npr. odgovoren zgolj za eno skupino endpointov), in ponovno uporabo kode.
- asinhrono izvajanje zahtevkov
- varnost tipov; definiramo, v kateri tip se nam podatki pretvorijo. Tako lahko napake, ki bi jih sicer ugotovili v času zagona, ugotovimo že v času prevajanja.

## Slabosti
- omejenost; z retrofitom lahko "out of the box" delamo zgolj z REST arhitekruro. To pomeni, da ga ne moremo uporabljati za npr. SOAP protokol ali za WebSockets.
- odvisnost od zunanjih knjižnic; če uporabljamo retrofit, to pomeni, da bomo morali uporabljati tudi nekatere druge knjižnice, kot je npr. Gson za pretvorbo podatkov. To pomeni, da bomo morali upravljati več odvisnosti v našem projektu.

## Licenca
Retrofit uporablja licenco Apache 2.0. To pomeni, da je odprtokoden projekt, kateremu lahko kdorkoli prispeva. 

## Število uporabnikov
Na githubu ima projekt več kot 42 tisoč zvezdic in 12 tisoč repozitorijev, ki so odvisni od njega.

## Vzdrževanje projekta
Projekt ima na githubu 172 razvijalcev in več kot 7000 forkov. Projekt je aktiven, zadnji commiti so bili narejeni včeraj (18.12.2023).
