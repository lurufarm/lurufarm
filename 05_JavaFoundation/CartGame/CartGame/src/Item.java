import java.util.ArrayList;
import java.util.LinkedList;

public class Item {
    private int itemNum;
    private Game currentGame;

    public Item(int luck)
    {
        itemNum = (int)(Math.random() * 70);
        itemNum += luck;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public Player target(Player player, Player[] players)
    {
        // 아이템의 타겟을 정하는 메서드
        int playerNum = 0;
        int targetNum = (int)(Math.random() * players.length);
        for (int i = 0; i < players.length; i++)
        {
            if(player == players[i])
                playerNum = i;
        }

        while(targetNum == playerNum)
        {
            targetNum = (int)(Math.random() * players.length);
        }
        return players[targetNum];
    }

    public Player targetWaterBalloon(Player player, Player[] players)
    {
        int playerNum = 0;
        for (int i = 0; i < players.length; i++)
        {
            if(player == players[i])
                playerNum = i;
        }

        // 나보다 밑 순위인 애들 번호 거르기
        ArrayList<Integer> targets = new ArrayList<>();

        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getCurrentRank(players) <= player.getCurrentRank(players) && i != playerNum)
                targets.add(i);
        }

        int targetNum = (int)(Math.random() * targets.size());

        return players[targets.get(targetNum)];
    }

    public Player targetBanana(Player player, Player[] players)
    {
        int playerNum = 0;
        for (int i = 0; i < players.length; i++)
        {
            if(player == players[i])
                playerNum = i;
        }
        // 나보다 윗 순위인 애들 번호 거르기
        ArrayList<Integer> targets = new ArrayList<>();

        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getCurrentRank(players) >= player.getCurrentRank(players) && i != playerNum)
                targets.add(i);
        }

        int targetNum = (int)(Math.random() * targets.size());

        return players[targets.get(targetNum)];
    }

    public void itemEffect(Player player)
    {
        if (itemNum < 40)
        {
            fail(player);
        }
        else
        {
            int rank = player.getCurrentRank(currentGame.getPlayers());
            int itemRand;

            if (rank == 1)
            {
                // 내가 현재 1위인 경우에는 부스터와 바나나만 출현
                itemRand = (int)(Math.random() * 2);
                if (itemRand == 0)
                {
                    // 부스터 출현
                    buster(player);
                }
                else
                {
                    // 바나나 출현
                    banana(player, currentGame.getPlayers());
                }
            }
            else if (rank == currentGame.getPlayers().length)
            {
                // 내가 꼴찌인 경우에는 부스터와 물풍선만 출현
                itemRand = (int)(Math.random() * 2);
                if (itemRand == 0)
                {
                    // 부스터 출현
                    buster(player);
                }
                else
                {
                    // 물풍선 출현
                    waterBalloon(player, currentGame.getPlayers());
                }
            }
            else
            {
                // 내가 중간 순위인 경우에는 부스터, 물풍선, 바나나가 출현
                itemRand = (int)(Math.random() * 3);
                if (itemRand == 0)
                {
                    // 부스터 출현
                    buster(player);
                }
                else if (itemRand == 1)
                {
                    // 물풍선 출현
                    waterBalloon(player, currentGame.getPlayers());
                }
                else if (itemRand == 2)
                {
                    // 바나나 출현
                    banana(player, currentGame.getPlayers());
                }
            }
        }
    }

    public void buster(Player player)
    {
        System.out.println("\n\u001B[32m🚀 " + player.getName() + "님의 3초간 속도 +30km! 🚗💨\u001B[0m");
        player.getCar().setChangeSpeed(30);
        // 3초 후 다시 속도 회복
        player.getCar().resetSpeed();
    }
    public void waterBalloon(Player player, Player[] players)
    {
        Player myTarget = targetWaterBalloon(player, players);
        System.out.println("\n\u001B[34m💦 " + player.getName() + "님이 " + myTarget.getName() + "님에게 물풍선을 던졌습니다! 🌊\u001B[0m");
        System.out.println("\u001B[34m" + myTarget.getName() + "님은 3초간 속도가 -20km 감소합니다! ⏳\u001B[0m");
        myTarget.getCar().setChangeSpeed(-20);
        // 3초 후 다시 속도 회복
        myTarget.getCar().resetSpeed();
    }
    public void banana(Player player, Player[] players)
    {
        Player myTarget = targetBanana(player, players);
//        System.out.println(player.getName() + "님의 타겟 " + myTarget.getName() + "의 속도 -20km!");
//        System.out.println(myTarget.getName() + "님이 " + player.getName() + "님이 바닥에 둔 바나나를 밟고 미끄러졌습니다!" + myTarget.getName() + "님은 3초간 속도가 줄어듭니다.");
        System.out.println("\n\u001B[33m🍌 " + player.getName() + "님의 바닥에 바나나가! " + myTarget.getName() + "님이 미끄러졌습니다! 🏃💨\u001B[0m");
        System.out.println("\u001B[33m" + myTarget.getName() + "님은 3초간 속도가 -20km 감소합니다! ⏳\u001B[0m");
        myTarget.getCar().setChangeSpeed(-20);
        // 3초 후 다시 속도 회복
        myTarget.getCar().resetSpeed();
    }
    public void fail(Player player)
    {
        if(player.isMainPlayer())
        {
            System.out.println("\n\u001B[31m💥 " + player.getName() + "님은 꽝입니다! 3초간 움직일 수 없습니다. 😱\u001B[0m");
        }
        player.getCar().setChangeSpeed(-30);
        // 3초 후 다시 속도 회복
        player.getCar().resetSpeed();
    }
}