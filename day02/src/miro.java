public class miro {
    public static void main(String[] args) {
        int[][] map = new int [20][20];

        int startX;
        int startY;
        int goalX;
        int goalY;

        do{
            startX = (int)(Math.random()*20);
            startY = (int)(Math.random()*20);
            goalX = (int)(Math.random()*20);
            goalY = (int)(Math.random()*20);
        }while(startX == goalX && startY == goalY);

        //출력
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {

            }
        }


        System.out.println(startX);
    }
}
