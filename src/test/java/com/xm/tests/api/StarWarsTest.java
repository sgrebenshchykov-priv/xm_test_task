package com.xm.tests.api;

import com.xm.api.SwapiApi;
import com.xm.api.pojo.films.Film;
import com.xm.api.pojo.people.People;
import com.xm.api.pojo.starships.Starship;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.xm.enums.StarshipsTypes.STARFIGHTER;

public class StarWarsTest {

    private SwapiApi api = new SwapiApi();

    @Test
    void starWarsTest() {
        String filmTitle = "A New Hope";
        Film film = api.getFilms().stream()
                .filter(flm -> filmTitle.equals(flm.getTitle()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no film with title '%s'", filmTitle)));

        String charName = "Biggs Darklighter";
        People character = film.getCharacters().stream()
                .map(link -> api.getPeople(link))
                .filter(chr -> charName.equals(chr.getName()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("There is no people with name '%s'", charName)));

        Starship starship = character.getStarships().stream()
                .map(link -> api.getStarship(link))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no starships"));

        List<String> pilots = starship.getPilots().stream().map(link -> api.getPeople(link).getName()).collect(Collectors.toList());

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(starship.getStarship_class())
                    .as("Starship class is incorrect")
                    .isEqualTo(STARFIGHTER.getValue());
            softly.assertThat(pilots)
                    .as("Pilot is not in a list")
                    .contains("Luke Skywalker");
        });
    }
}
