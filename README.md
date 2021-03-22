# FactoryNews

Zadatak je napraviti Android aplikaciju koja se sastoj od dva screena koristeći MVP arhitekturu.
Na prvom screenu treba dohvatiti podatke s:
https://newsapi.org
te ih parsirati i prikazati kao što je vidljivo u dizajnu.
Kandidat može koristiti REST lib po izboru kao i način parsiranja. Podatke koje
dobije potrebno je spremiti lokalno. Ukoliko lokalni podaci ne postoje ili su stariji
od 5 minuta tada je potrebno napraviti request, ukoliko postoje i nisu stariji od 5
min tada je potrebno njih prikazati.

Ukoliko dođe do pogreške prilikom
slanja/primanje requesta prikazati
pop-up. Prilikom dohvaćanja podataka
prikazati loader.
Klikom na item iz liste otvoriti drugi
screen i u njemu prikazati single vijesti u
view pageru držeći se redoslijeda. View
pager treba predstavljati listu, u kojoj se
nalaze svi singlovi.

### Preview
![alt text](readme/plavatvornica-preview.gif)
