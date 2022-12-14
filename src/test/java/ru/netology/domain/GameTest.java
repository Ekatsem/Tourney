package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testWhenFirstStronger(){
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 40);
        Player player2 = new Player(2, "Anna", 30);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Ivan", "Anna");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenSecondStronger(){
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 20);
        Player player2 = new Player(2, "Anna", 30);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Ivan", "Anna");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenSameStrength(){
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 30);
        Player player2 = new Player(2, "Anna", 30);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Ivan", "Anna");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testWhenFirstUnregistered(){
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 40);
        Player player2 = new Player(2, "Anna", 30);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Anna"));
    }
    @Test
    public void testWhenSecondUnregistered(){
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 40);
        Player player2 = new Player(2, "Anna", 30);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Anna"));
    }
    @Test
    public void testWhenNoOneRegistered(){
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 40);
        Player player2 = new Player(2, "Anna", 30);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ivan", "Anna"));
    }

}