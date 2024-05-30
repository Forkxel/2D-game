package entity;

import window.Screen;

import java.util.ArrayList;

public class MonsterPlacement {

    private final Screen screen;

    public MonsterPlacement(Screen screen) {
        this.screen = screen;
    }

    public ArrayList<Monster> addMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();

        Monster monster1 = new Monster(screen);
        monster1.setX(screen.getScaledTile()*37);
        monster1.setY(screen.getScaledTile()*43);
        monster1.setMaxX(screen.getScaledTile()*39);
        monster1.setMaxY(screen.getScaledTile()*47);
        monster1.setMinX(screen.getScaledTile()*32);
        monster1.setMinY(screen.getScaledTile()*41);
        monsters.add(monster1);

        Monster monster2 = new Monster(screen);
        monster2.setX(screen.getScaledTile()*42);
        monster2.setY(screen.getScaledTile()*19);
        monster2.setMaxX(screen.getScaledTile()*44);
        monster2.setMaxY(screen.getScaledTile()*17);
        monster2.setMinX(screen.getScaledTile()*39);
        monster2.setMinY(screen.getScaledTile()*11);
        monsters.add(monster2);

        Monster monster3 = new Monster(screen);
        monster3.setX(screen.getScaledTile()*41);
        monster3.setY(screen.getScaledTile()*20);
        monster3.setMaxX(screen.getScaledTile()*44);
        monster3.setMaxY(screen.getScaledTile()*22);
        monster3.setMinX(screen.getScaledTile()*39);
        monster3.setMinY(screen.getScaledTile()*17);
        monsters.add(monster3);

        Monster monster4 = new Monster(screen);
        monster4.setX(screen.getScaledTile()*36);
        monster4.setY(screen.getScaledTile()*19);
        monster4.setMaxX(screen.getScaledTile()*37);
        monster4.setMaxY(screen.getScaledTile()*22);
        monster4.setMinX(screen.getScaledTile()*35);
        monster4.setMinY(screen.getScaledTile()*17);
        monsters.add(monster4);

        Monster monster5 = new Monster(screen);
        monster5.setX(screen.getScaledTile()*20);
        monster5.setY(screen.getScaledTile()*16);
        monster5.setMaxX(screen.getScaledTile()*24);
        monster5.setMaxY(screen.getScaledTile()*19);
        monster5.setMinX(screen.getScaledTile()*16);
        monster5.setMinY(screen.getScaledTile()*9);
        monsters.add(monster5);

        Monster monster6 = new Monster(screen);
        monster6.setX(screen.getScaledTile()*28);
        monster6.setY(screen.getScaledTile()*11);
        monster6.setMaxX(screen.getScaledTile()*30);
        monster6.setMaxY(screen.getScaledTile()*19);
        monster6.setMinX(screen.getScaledTile()*25);
        monster6.setMinY(screen.getScaledTile()*9);
        monsters.add(monster6);

        Monster monster7 = new Monster(screen);
        monster7.setX(screen.getScaledTile()*18);
        monster7.setY(screen.getScaledTile()*16);
        monster7.setMaxX(screen.getScaledTile()*24);
        monster7.setMaxY(screen.getScaledTile()*19);
        monster7.setMinX(screen.getScaledTile()*16);
        monster7.setMinY(screen.getScaledTile()*9);
        monsters.add(monster7);

        Monster monster8 = new Monster(screen);
        monster8.setX(screen.getScaledTile()*26);
        monster8.setY(screen.getScaledTile()*11);
        monster8.setMaxX(screen.getScaledTile()*30);
        monster8.setMaxY(screen.getScaledTile()*19);
        monster8.setMinX(screen.getScaledTile()*25);
        monster8.setMinY(screen.getScaledTile()*9);
        monsters.add(monster8);

        Monster monster9 = new Monster(screen);
        monster9.setX(screen.getScaledTile()*15);
        monster9.setY(screen.getScaledTile()*3);
        monster9.setMaxX(screen.getScaledTile()*21);
        monster9.setMaxY(screen.getScaledTile()*6);
        monster9.setMinX(screen.getScaledTile()*11);
        monster9.setMinY(screen.getScaledTile()*2);
        monsters.add(monster9);

        Monster monster10 = new Monster(screen);
        monster10.setX(screen.getScaledTile()*4);
        monster10.setY(screen.getScaledTile()*7);
        monster10.setMaxX(screen.getScaledTile()*5);
        monster10.setMaxY(screen.getScaledTile()*12);
        monster10.setMinX(screen.getScaledTile()*3);
        monster10.setMinY(screen.getScaledTile()*3);
        monsters.add(monster10);

        Monster monster11 = new Monster(screen);
        monster11.setX(screen.getScaledTile()*9);
        monster11.setY(screen.getScaledTile()*38);
        monster11.setMaxX(screen.getScaledTile()*7);
        monster11.setMaxY(screen.getScaledTile()*42);
        monster11.setMinX(screen.getScaledTile()*3);
        monster11.setMinY(screen.getScaledTile()*36);
        monsters.add(monster11);

        Monster monster12 = new Monster(screen);
        monster12.setX(screen.getScaledTile()*36);
        monster12.setY(screen.getScaledTile()*14);
        monster12.setMaxX(screen.getScaledTile()*37);
        monster12.setMaxY(screen.getScaledTile()*16);
        monster12.setMinX(screen.getScaledTile()*35);
        monster12.setMinY(screen.getScaledTile()*11);
        monsters.add(monster12);

        Monster monster13 = new Monster(screen);
        monster13.setX(screen.getScaledTile()*10);
        monster13.setY(screen.getScaledTile()*35);
        monster13.setMaxX(screen.getScaledTile()*11);
        monster13.setMaxY(screen.getScaledTile()*37);
        monster13.setMinX(screen.getScaledTile()*7);
        monster13.setMinY(screen.getScaledTile()*34);
        monsters.add(monster13);

        Monster monster14 = new Monster(screen);
        monster14.setX(screen.getScaledTile()*12);
        monster14.setY(screen.getScaledTile()*40);
        monster14.setMaxX(screen.getScaledTile()*17);
        monster14.setMaxY(screen.getScaledTile()*43);
        monster14.setMinX(screen.getScaledTile()*12);
        monster14.setMinY(screen.getScaledTile()*36);
        monsters.add(monster14);

        Monster monster15 = new Monster(screen);
        monster15.setX(screen.getScaledTile()*9);
        monster15.setY(screen.getScaledTile()*40);
        monster15.setMaxX(screen.getScaledTile()*12);
        monster15.setMaxY(screen.getScaledTile()*41);
        monster15.setMinX(screen.getScaledTile()*6);
        monster15.setMinY(screen.getScaledTile()*38);
        monsters.add(monster15);

        Monster monster16 = new Monster(screen);
        monster16.setX(screen.getScaledTile()*42);
        monster16.setY(screen.getScaledTile()*5);
        monster16.setMaxX(screen.getScaledTile()*42);
        monster16.setMaxY(screen.getScaledTile()*7);
        monster16.setMinX(screen.getScaledTile()*39);
        monster16.setMinY(screen.getScaledTile()*3);
        monsters.add(monster16);

        Monster monster17 = new Monster(screen);
        monster17.setX(screen.getScaledTile()*42);
        monster17.setY(screen.getScaledTile()*6);
        monster17.setMaxX(screen.getScaledTile()*45);
        monster17.setMaxY(screen.getScaledTile()*7);
        monster17.setMinX(screen.getScaledTile()*43);
        monster17.setMinY(screen.getScaledTile()*3);
        monsters.add(monster17);

        Monster monster18 = new Monster(screen);
        monster18.setX(screen.getScaledTile()*45);
        monster18.setY(screen.getScaledTile()*27);
        monster18.setMaxX(screen.getScaledTile()*48);
        monster18.setMaxY(screen.getScaledTile()*30);
        monster18.setMinX(screen.getScaledTile()*40);
        monster18.setMinY(screen.getScaledTile()*24);
        monsters.add(monster18);

        Monster monster19 = new Monster(screen);
        monster19.setX(screen.getScaledTile()*45);
        monster19.setY(screen.getScaledTile()*34);
        monster19.setMaxX(screen.getScaledTile()*48);
        monster19.setMaxY(screen.getScaledTile()*36);
        monster19.setMinX(screen.getScaledTile()*40);
        monster19.setMinY(screen.getScaledTile()*31);
        monsters.add(monster19);

        Monster monster20 = new Monster(screen);
        monster20.setX(screen.getScaledTile()*36);
        monster20.setY(screen.getScaledTile()*27);
        monster20.setMaxX(screen.getScaledTile()*39);
        monster20.setMaxY(screen.getScaledTile()*30);
        monster20.setMinX(screen.getScaledTile()*34);
        monster20.setMinY(screen.getScaledTile()*24);
        monsters.add(monster20);

        Monster monster21 = new Monster(screen);
        monster21.setX(screen.getScaledTile()*36);
        monster21.setY(screen.getScaledTile()*34);
        monster21.setMaxX(screen.getScaledTile()*39);
        monster21.setMaxY(screen.getScaledTile()*36);
        monster21.setMinX(screen.getScaledTile()*34);
        monster21.setMinY(screen.getScaledTile()*31);
        monsters.add(monster21);

        Monster monster22 = new Monster(screen);
        monster22.setX(screen.getScaledTile()*4);
        monster22.setY(screen.getScaledTile()*29);
        monster22.setMaxX(screen.getScaledTile()*7);
        monster22.setMaxY(screen.getScaledTile()*32);
        monster22.setMinX(screen.getScaledTile()*2);
        monster22.setMinY(screen.getScaledTile()*26);
        monsters.add(monster22);

        Monster monster23 = new Monster(screen);
        monster23.setX(screen.getScaledTile()*9);
        monster23.setY(screen.getScaledTile()*29);
        monster23.setMaxX(screen.getScaledTile()*10);
        monster23.setMaxY(screen.getScaledTile()*33);
        monster23.setMinX(screen.getScaledTile()*8);
        monster23.setMinY(screen.getScaledTile()*26);
        monsters.add(monster23);

        Monster monster24 = new Monster(screen);
        monster24.setX(screen.getScaledTile()*15);
        monster24.setY(screen.getScaledTile()*29);
        monster24.setMaxX(screen.getScaledTile()*17);
        monster24.setMaxY(screen.getScaledTile()*32);
        monster24.setMinX(screen.getScaledTile()*11);
        monster24.setMinY(screen.getScaledTile()*26);
        monsters.add(monster24);

        Monster monster25 = new Monster(screen);
        monster25.setX(screen.getScaledTile()*31);
        monster25.setY(screen.getScaledTile()*18);
        monster25.setMaxX(screen.getScaledTile()*33);
        monster25.setMaxY(screen.getScaledTile()*23);
        monster25.setMinX(screen.getScaledTile()*30);
        monster25.setMinY(screen.getScaledTile()*14);
        monsters.add(monster25);

        Monster monster26 = new Monster(screen);
        monster26.setX(screen.getScaledTile()*25);
        monster26.setY(screen.getScaledTile()*5);
        monster26.setMaxX(screen.getScaledTile()*27);
        monster26.setMaxY(screen.getScaledTile()*7);
        monster26.setMinX(screen.getScaledTile()*21);
        monster26.setMinY(screen.getScaledTile()*3);
        monsters.add(monster26);

        Monster monster27 = new Monster(screen);
        monster27.setX(screen.getScaledTile()*26);
        monster27.setY(screen.getScaledTile()*36);
        monster27.setMaxX(screen.getScaledTile()*33);
        monster27.setMaxY(screen.getScaledTile()*38);
        monster27.setMinX(screen.getScaledTile()*21);
        monster27.setMinY(screen.getScaledTile()*33);
        monsters.add(monster27);

        return monsters;
    }
}
