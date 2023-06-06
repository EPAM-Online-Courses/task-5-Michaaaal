package efs.task.collections.data;

import efs.task.collections.entity.Hero;
import efs.task.collections.entity.Town;

import java.util.List;
import java.util.Set;

public class DataProvider {

    public static final String DATA_SEPARATOR = ",";

    // TODO Utwórz listę miast na podstawie tablicy Data.baseTownsArray.
    //  Tablica zawiera String zawierający nazwę miasta oraz dwie klasy bohatera związane z tym miastem oddzielone przecinkami.
    //  Korzystając z funkcji split() oraz stałej DATA_SEPARATOR utwórz listę obiektów klasy efs.task.collections.entities.Town.
    //  Funkcja zwraca listę obiektów typu Town ze wszystkimi dziewięcioma podstawowymi miastami.
    public List<Town> getTownsList() {
        List<Town> towns = new ArrayList<>();


        for (String text : Data.baseTownsArray){
            String pola[]=text.split(DATA_SEPARATOR);
            List<String> heroesClasses= new ArrayList<>();
            heroesClasses.add(pola[1]);
            heroesClasses.add(pola[2]);
            towns.add(new Town(pola[0],heroesClasses));
        }

        return towns;
    }

    //TODO Analogicznie do getTownsList utwórz listę miast na podstawie tablicy Data.DLCTownsArray
    public List<Town> getDLCTownsList() {
        List<Town> dlcTowns = new ArrayList<>();

        for (String text : Data.dlcTownsArray){
            String pola[]=text.split(DATA_SEPARATOR);
            List<String> heroesClasses= new ArrayList<>();
            heroesClasses.add(pola[1]);
            heroesClasses.add(pola[2]);
            dlcTowns.add(new Town(pola[0],heroesClasses));
        }

        return dlcTowns;
    }

    //TODO Na podstawie tablicy Data.baseCharactersArray utworzyć listę bohaterów dostępnych w grze.
    // Tablica Data.baseCharactersArray zawiera oddzielone przecinkiem imie bohatera, klasę bohatera.
    // Korzystając z funkcji split() oraz DATA_SEPARATOR utwórz listę unikalnych obiektów efs.task.collections.entities.Hero.
    // UWAGA w Data.baseCharactersArray niektórzy bohaterowie powtarzają się, do porównania bohaterów używamy zarówno imie jak i jego klasę;
    public Set<Hero> getHeroesSet() {
        Set<Hero> baseHeroes = new HashSet<>();

        for (String text : Data.baseCharactersArray) {
            String[] pola = text.split(DATA_SEPARATOR);
            Hero hero = new Hero(pola[0].trim(), pola[1].trim());
            baseHeroes.add(hero);
        }

        return baseHeroes;
    }

    //TODO Analogicznie do getHeroesSet utwórz listę bohaterów na podstawie tablicy Data.DLCCharactersArray
    public Set<Hero> getDLCHeroesSet() {
        Set<Hero> dlcHeroes = new HashSet<>();

        for (var text : Data.dlcCharactersArray){
            String pola[]=text.split(DATA_SEPARATOR);
            dlcHeroes.add(new Hero(pola[0].trim(),pola[1].trim()));
        }
        return dlcHeroes;
    }
}
