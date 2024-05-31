package tests;

import entity.Entity;
import entity.Monster;
import entity.Player;
import map.Collision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import window.Keyboard;
import window.Screen;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {

    private Screen screen;
    private Collision collision;

    @BeforeEach
    void setUp() {
        screen = new Screen();
        collision = new Collision(screen);
    }

    @Test
    public void testCollisionMonster() {
        Player player = new Player(screen, new Keyboard());
        player.setX(50);
        player.setY(80);
        player.setDirection("down");
        player.setBounds(new Rectangle(0, 0, 30, 30));

        Monster monster = new Monster(screen);
        monster.setX(50);
        monster.setY(80);
        monster.setBounds(new Rectangle(0, 0, 30, 30));

        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(monster);

        boolean hit = collision.collisionMonster(player, monsters);

        assertTrue(hit);
        assertTrue(player.isCollision());
    }
}