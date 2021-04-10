package lesson1;

public class Main {
    public static void main(String[] args) {

        JumpAndRun [] members = {
                new Human(1, 100, "Человек"),
                new Cat(2, 1000, "Кот"),
                new Robot(3, 10000, "Робот"),
        };

        Obstacles [] obstacles = {
                new RunningTrack(100),
                new Wall(2),
                new RunningTrack(150),
                new Wall(1),
        };
        for(JumpAndRun member : members){
            System.out.println("Забег начинает " + member);
            boolean winner = true;
            for (Obstacles obstacle : obstacles){
                System.out.println(member + " пытается преодолеть " + obstacle);
                if (obstacle.toJump(member.goMaxHeight()) || obstacle.toRun(member.goMaxLength())){
                    System.out.println(member + " успешно преодолел " + obstacle);
                } else { winner = false;
                    System.out.println(member + " не смог преодолеть препятствие.");
                    break;
                }
            }
            if (winner){
                System.out.println(member + " успешно прошел дистанцию!");
            } else {
                System.out.println(member + " проиграл!");
            }
        }
    }
}

