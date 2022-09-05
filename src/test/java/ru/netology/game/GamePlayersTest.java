package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePlayersTest {

    private Game game = new Game();

    Player player1 = new Player(1, "Kate789", 12);
    Player player2 = new Player(45, "Igor3", 2);
    Player player3 = new Player(76, "Natasha10", 34);
    Player player4 = new Player(114, "SashaKirov", 7);
    Player player5 = new Player(7, "IrinaL", 29);
    Player player6 = new Player(32, "Zorro43", 29);

    @BeforeEach
    void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        game.register(player6);
    }

    @Test
    public void shouldFindAllRegisteredPlayers() {
        List<Player> expected = List.of(player1, player2, player3, player4, player5, player6);
        List<Player> actual = game.findAll();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionWithPlayer1() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Elena332", "Natasha10");
        });
    }

    @Test
    public void shouldThrowExceptionWithPlayer2() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
           game.round("IrinaL", "EvgenySam") ;
        });
    }

    @Test
    public void shouldThrowExceptionWithBothPlayers() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dinar3", "Agent007");
        });
    }

    @Test
    public void shouldWinTheFirstPlayer() {
        int expected = 1;
        int actual = game.round("Kate789", "SashaKirov");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinTheSecondPlayer() {
        int expected = 2;
        int actual = game.round("Igor3", "Natasha10");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqualInStrength() {
        int expected = 0;
        int actual = game.round("IrinaL", "Zorro43");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindPlayerByName() {
        Player expected = player4;
        Player actual = game.findByName("SashaKirov");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindPlayerByName() {
        Player expected = null;
        Player actual = game.findByName("Agent007");

        Assertions.assertEquals(expected, actual);
    }
}
