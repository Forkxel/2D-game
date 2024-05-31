package tests;

import entity.Player;
import object.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import window.Keyboard;
import window.Screen;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

  private Screen screen;
  private Item[] items;
  private Player player;

  @BeforeEach
  void setUp() {
    screen = new Screen();
    player = new Player(screen, new Keyboard());
    items = new Item[9];
    screen.setItems(items);
  }

  @Test
  void testInteractKey(){
    Key key = new Key();
    key.setName("key");
    items[0] = key;

    player.interact(0);

    assertTrue(player.getKeys().contains(key));
    assertNull(screen.getItems()[0]);
  }

  @Test
  void testInteractDoors(){
    Key redKey = new Key();
    redKey.setColor("red");
    player.getKeys().add(redKey);

    Doors redDoors = new Doors();
    redDoors.setName("doors");
    redDoors.setColor("red");
    items[1] = redDoors;

    player.interact(1);

    assertNull(screen.getItems()[1]);
  }

  @Test
  void testInteractChest(){
    Key yellowKey = new Key();
    yellowKey.setColor("yellow");
    player.getKeys().add(yellowKey);

    Chest chest = new Chest();
    chest.setName("chest");
    items[2] = chest;

    player.interact(2);

    assertTrue(player.isWin());
  }

  @Test
  void testInteractPotion(){
    Potion potion = new Potion();
    potion.setName("potion");
    items[3] = potion;

    player.setHit(1);
    player.setLife(1);

    player.interact(3);

    assertEquals(player.getMaxLife(), player.getLife());
    assertEquals(0, player.getHit());
    assertNull(screen.getItems()[3]);
  }
}