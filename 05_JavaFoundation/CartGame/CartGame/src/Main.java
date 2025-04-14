import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.gameSetting();
        newGame.setTime(System.currentTimeMillis());
        Timer timer = new Timer();

        // 게임 실행 상태를 관리하는 플래그
        boolean[] isRunning = {true};  // 배열로 만드는 이유는 내부 클래스에서 수정 가능하게 하기 위함

        TimerTask runGame = new TimerTask() {
            @Override
            public void run() {
                if (isRunning[0]) {  // isRunning이 true일 때만 실행
                    newGame.run();
                    for (int i = 0; i < newGame.getPlayers().length; i++) {
                        if (newGame.getPlayers()[i].getLocation() >= 100.0) {
                            newGame.getPlayers()[i].isGoalIn = true;
                        }
                    }
                    if (newGame.getPlayers()[0].getLocation() >= 100.0) {
                        timer.cancel();
                        System.out.println();
                        System.out.println("=== 🏆 레이스 결과 발표! 🏆 ===");
                        for (int i = 0; i < newGame.getPlayers().length; i++) {
                            System.out.println(newGame.getPlayers()[i].playerInfo(newGame.getPlayers()));
                        }
                        System.out.println("\n🎉 모든 레이스가 종료되었습니다. 다음에 또 만나요!");
                    }
                }
            }
        };

        TimerTask stopGame = new TimerTask() {
            @Override
            public void run() {
                isRunning[0] = false;  // runGame 일시 중지
                newGame.stop();
                newGame.otherCharactersStop();

                // 3초 후에 다시 시작
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isRunning[0] = true;  // runGame 다시 시작
                    }
                }, 16);  // 3초 후 실행
            }
        };

        timer.scheduleAtFixedRate(runGame, 0, 16);
        timer.scheduleAtFixedRate(stopGame, 0, 8000);
    }
}