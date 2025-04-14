import java.util.Scanner;

public final class Game {
    private Player[] players;
    private long time;
    private Scanner sc;
    int f = 0;

    public Game() {
        this.sc = new Scanner(System.in);
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void gameSetting() {
        System.out.println("=== \uD83C\uDFC1 카트라이더 레이스 시작! \uD83C\uDFC1 ===\n");
        System.out.println("\u001B[36m🎮 플레이어 닉네임을 입력하세요 \u001B[0m");
        System.out.print(">> ");
        String playerName = sc.nextLine();
        System.out.println("\n\u001B[32m✅ 닉네임 \"" + playerName + "\"으로 설정되었습니다!\u001B[0m");
        System.out.println("\n\u001B[33m👥 함께할 플레이어의 수를 입력하세요 (1-4): \u001B[0m");
        System.out.print(">> ");
        players = new Player[sc.nextInt()];
        System.out.println("\n\u001B[32m✅ 총 " + players.length + "명의 플레이어와 함께합니다!\u001B[0m");
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();

            if (i == 0) {
                players[i].setMainPlayer(true);
                players[i].setName(playerName);
            } else {
                players[i].setMainPlayer(false);
                players[i].setName(i + "");
            }
        }

        System.out.println("=== 🚗 카트 선택 화면 ===\n");
        System.out.println("\u001B[36m" + "1. Fast & Unlucky Car" + "\u001B[0m");
        System.out.println("   🏎️  빠르지만 운이 나쁨!");


        System.out.println("\u001B[32m" + "2. Balanced Car" + "\u001B[0m");
        System.out.println("   🚙  속도와 운이 균형 잡힌 카트!");

        System.out.println("\u001B[33m" + "3. Slow & Lucky Car" + "\u001B[0m");
        System.out.println("   🚗  느리지만 행운의 여신이 함께 합니다!");


        System.out.println("\u001B[35m" + "4. RANDOM Car" + "\u001B[0m");
        System.out.println("   🎲 어떤 카트가 나올지 알 수 없어요! 운에 맡겨보세요.");


        System.out.println("\n\u001B[34m=== 선택하세요 (1-4): ===\u001B[0m");
        int carNum = sc.nextInt();

        carSelect(players[0], carNum);
        for (int i = 1; i < players.length; i++) {
            carSelect(players[i], (int) (Math.random() * 4) + 1);
        }
    }

    public void carSelect(Player player, int carNum) {
        System.out.println("\n🚀 선택 결과:");
        switch (carNum) {
            case 1:
                player.setCar(new SpeedyCar());
                System.out.println("\u001B[36m🏎️ Fast & Unlucky Car 선택! 빠른 스피드를 기대하세요!\u001B[0m");
                break;
            case 2:
                player.setCar(new BalancedCar());
                System.out.println("\u001B[32m🚙 Balanced Car 선택! 안정적인 승리를 기대하세요!\u001B[0m");
                break;
            case 3:
                player.setCar(new SlowCar());
                System.out.println("\u001B[33m🚗 Slow & Lucky Car 선택! 행운이 당신 편입니다!\u001B[0m");
                break;
            case 4:
                player.setCar(new RandomCar());
                System.out.println("\u001B[35m🎲 RANDOM Car 선택! 기대하세요, 무엇이든 가능성은 무한합니다!\u001B[0m");
                break;
            default:
                System.out.println("\u001B[31m🚫 잘못된 입력입니다. 다시 시도해주세요!\u001B[0m");
                break;
        }
        System.out.println("\n\u001B[34m🎉 설정이 완료되었습니다! 레이스를 시작합니다! 🏎️\u001B[0m");
    }


    public void run() {
        String[] frames = {"|", "/", "-", "\\"};
        for (int i = 0; i < players.length; i++) {
            players[i].updatePosition(0.0016);
        }
        System.out.print("\r🏎️ 카트가 달리고 있습니다! " + frames[f++ % 4]);
    }

    public void stop() {
        System.out.println("\n\n\u001B[31m=== 🛑 레이스 일시 정지 ===\u001B[0m");
        for (int i = 0; i < players.length; i++) {
            if (!(players[i].isGoalIn))
                System.out.println(players[i].playerInfo(players));
        }

        System.out.println("\n\u001B[34m어떻게 하시겠습니까?\u001B[0m");
        System.out.println("\u001B[32m1️⃣ 계속 달린다 🚗💨\u001B[0m");
        System.out.println("\u001B[33m2️⃣ 아이템 먹기 🎁🍀\u001B[0m");
        System.out.print(">> ");
        int select = sc.nextInt();

        if (select == 1) {
            return;
        } else if (select == 2) {
            Item item = new Item(players[0].getCar().getLuck());
            item.setCurrentGame(this);
            item.itemEffect(players[0]);
        }
    }

    public void otherCharactersStop() {
        for (int i = 1; i < players.length; i++) {
            if(!(players[i].isGoalIn)) {
                int rand = (int) (Math.random() * 2);
                if (rand == 0)
                    continue;
                else if (rand == 1) {
                    Item item = new Item(players[i].getCar().getLuck());
                    item.setCurrentGame(this);
                    item.itemEffect(players[i]);
                }
            }
        }
    }

}
