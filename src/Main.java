import models.BasePlayer;
import models.Dice;
import models.Player;
import models.VirtualPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<VirtualPlayer> VPlayers = new ArrayList<>();
        VirtualPlayer Vplayer1 = new VirtualPlayer("Virtual player 1", "Oke, I'm lost");
        VPlayers.add(Vplayer1);
        VirtualPlayer Vplayer2 = new VirtualPlayer("Virtual player 2", "Nah, I'm lost");
        VPlayers.add(Vplayer2);
        VirtualPlayer Vplayer3 = new VirtualPlayer("Virtual player 3", "Oh no, I'm lost");
        VPlayers.add(Vplayer3);
        VirtualPlayer Vplayer4 = new VirtualPlayer("Virtual player 4", "No way, I'm lost");
        VPlayers.add(Vplayer4);

        List<Dice> dices = new ArrayList<>();
        for (int i = 1; i <= 4; ++ i) {
            dices.add(new Dice(i));
        }

        List<BasePlayer> players = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please input the number of players: ");
        int numPlayers = in.nextInt();
        for (int i = 1; i <= numPlayers; ++ i) {
            System.out.println("Please input the name of number " + i + " player: ");
            ///in.nextLine();
            String name = in.next();
            Player tmpPlayer = new Player(name);
            players.add(tmpPlayer);
        }

        for (int i = 1; i <= 4 - numPlayers; ++ i) {
            System.out.println("Adding virtual player: ");
            players.add(VPlayers.get(i - 1));
        }

        boolean condition = false;
        Random rand = new Random();
        while (condition == false) {
            int pos = -1;
            boolean check = false;
            while (!check) {
                for (int i = 0; i < players.size(); ++i) {
                    BasePlayer player = players.get(i);
                    System.out.println("This is turn of " + player.getName() + ": ");
                    System.out.println("Choose the dice");
                    int numRand = rand.nextInt(4);
                    Dice curDice = dices.get(numRand);
                    int point = curDice.roll();
                    System.out.println(player.getName() + "'s point in this turn is: " + Integer.toString(point));
                    System.out.println(player.getName() + "'s current point is: " + Integer.toString(player.getPoint() + point));
                    if (player.getPoint() + point < 21) {
                        player.addPoint(point);
                    } else if (player.getPoint() + point == 21) {
                        player.addPoint(point);
                        pos = i;
                        check = true;
                        break;
                    } else {
                        System.out.println(player.getName() + "'s point is more than 21 so it will be refreshed !");
                        player.setPoint(0);
                        break;
                    }
                }
            }

            if (pos == -1) continue;
            else {
                for (int i = 0; i < players.size(); ++ i) {
                    BasePlayer player = players.get(i);
                    System.out.println(player.toString());
                    if (i == pos) {
                        System.out.println(player.getName() + " are the winner !");
                    }
                    else {
                        System.out.println("You lose !");
                        if (player instanceof VirtualPlayer) {
                            ((VirtualPlayer) player).DefeatNotification();
                        }
                    }
                    System.out.println("----------------------------------------------------");
                }
                System.exit(0);
            }
        }
    }
}