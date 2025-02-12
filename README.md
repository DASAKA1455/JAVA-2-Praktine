## JAVA. 2 praktinė užduotis. GeoLocation

Sukurta programa, kuri saugo geografines koordinates ir apskaičiuoja atstumą pagal nurodymus. 

1. Naudojami 2 privatūs kintamieji `double lat` ir` double lon `vietovės geografinėms koordinatėms (platumai ir ilgumai) saugoti. 
2. Privatus kintamasis `int numLocations` skirtas programoje klasės GeoLocation objektų (vietovių) skaičiui saugoti.
3. Klasė papildyta trimis konstruktoriais:
3.1. Be parametrų, naudojamas atsitiktinių koordinačių priskyrimui ir numLocations padidinimu vienu vienetu. Koordinatės suapvalintos 6 ženklų po kablelio tikslumu.
3.2. Konstruktoriumi su dvejais parametrais. Klasės nariams` lat` ir `lon` parametrais perduotų reikšmių priskyrimui, `numLocations `padidinimu vienetu. 
3.3. Kopijavimo konstruktoriumi, kuris nukopijuoja jam perduotas koordinates ir prideda prie kiekvienos koordinatės atsitiktinį skaičių iš intervalo, kuris leidžia sugeneruoti atsitiktines koordinates netoli parametru perduotos vietovės.

5. Klasė papildyta `void print() `metodu, kuris atspausdina `[lat,lon]` reikšmes.

6. Klasė papildyta iš išorės pasiekiamu metodu double distance, kuris paskaičiuoja atstumą kilometrais (vieno ženklo po kablelio tikslumu). Atstumo skaičiavimui naudojama Haversino formulė.


### Rezultatas ###
Pirmo ir trečio taško koordinatės skiriasi dėl atsitiktinumo, antras atstumas − labai didelis, o trečias atstumas − labai mažas.:

[-38.0, 163.0] _- atsitiktinis, kiekvieną kartą skiriasi._
[54.683333, 25.283333]
[54.629841, 25.218182]
Number of locations: 4
From Vilnius to Kaunas: 92.7
From Vilnius to random location: 16354.0  _- atsitiktinis, kiekvieną kartą skiriasi._
From Vilnius to random neighbour: 7.3 _- atsitiktinis, kiekvieną kartą skiriasi._
