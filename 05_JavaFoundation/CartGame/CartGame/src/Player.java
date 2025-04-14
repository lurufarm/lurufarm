import java.text.DecimalFormat;

public class Player {
    private String name ; // 플레이어 이름
    private double location = 0 ; // 내 위치(이동거리) 속도와 시간을 곱해서 내위치에 더해주는 메서드  ,, 만약에 위치가 100이 되었을 때 추후에
    private Car car ;// 내 차 정보 다른 클래스에서 받아오고
    private boolean isMainPlayer;  // player = true , otherPlayer = false  플레이어랑 다른 플레이어를 구별?
    public boolean isGoalIn = false;


    public Player(){

    }

    Player(String name, double location,Car car,boolean isMainPlayer){
        this.name = name;
        this.location = location;
        this.car = car;
        this.isMainPlayer = isMainPlayer;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLocation() {
        return location;
    }

    public void setLocation(double location) {
        this.location = location;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isMainPlayer() {
        return isMainPlayer;
    }

    public void setMainPlayer(boolean mainPlayer) {
        isMainPlayer = mainPlayer;
    }

    // 위치 업데이트 메소드 ( 현재 내 위치 += 속도 x 시간 )
    public void updatePosition(double time){  //
        if(car != null) {
            double speed = car.getFinalSpeed(); // 자동차 속도 가져오기
            // 속도가 음수일 경우 0으로 처리
            if (speed < 0) {
                speed = 0;
            }
            // 위치 업데이트
            this.location += speed * time;
            // 위치를 소수점 2자리로 제한
            DecimalFormat df = new DecimalFormat("#.##");
            this.location = Double.parseDouble(df.format(this.location));
        }else{
            System.out.println("자동차 정보가 없어요. 위치를 업데이트 할 수 없습니다.");
        }
    };
    // 자신의 현재순위 보여줄 수 있는 메서드
    public int getCurrentRank(Player[] players){
        int rank = 1;
        for(int i = 0; i<players.length; i++){
            Player other = players[i]; // player 객체 개별적으로 참조
            if(other != this && other.getLocation() > this.location){ // 나와 다른 플레이어들과 비교
                rank++;
            }
        }
        return rank;
    }

    public String playerInfo(Player[] players){
        int rank = getCurrentRank(players); // 현재 순위 계산
        String playerType = isMainPlayer ? "나" : "다른 플레이어";

        // DecimalFormat을 사용하여 위치를 소수점 2자리로 포맷
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedLocation = df.format(location);

        return "\u001B[36m🎮 플레이어 이름: \u001B[0m" + name + "\n" +
                "\u001B[33m🚗 선택한 카트: \u001B[0m" + car.getName() + "\n" +
                "\u001B[34m📍 현재 위치: \u001B[0m" + location + "m\n" +
                "\u001B[32m🏆 현재 순위: \u001B[0m" + rank + "위\n";
    }

};

