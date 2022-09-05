package ru.netology.game;

import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();
    private String name;

    public List<Player> findAll() {
        return players;
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if(findByName(playerName1) == null || findByName(playerName2) == null) {
            throw new NotRegisteredException(
                    "Player with name: "+ name + "not registered"
            );
        }
        int points = player1.getStrength() - player2.getStrength();
        if (points > 0) {
            return 1;
        } else if (points < 0) {
            return 2;
        } else {
            return 0;
        }

    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;
            }
        }
        return null;
    }
}
