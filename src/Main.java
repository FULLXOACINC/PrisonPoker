import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int sizeOfUserStrategy = 12;
    private static final int sizeOfUserFirstStrategy = 7;
    private static List<Integer> strategyArray = new ArrayList<Integer>();
    private static List<Integer> firstPlayerChooseSet;

    private static int firstPlayerCash ;
    private static int secondPlayerCash ;

    public static void main(String[] args) {
        strategyArray = createStrategyArray();
        firstPlayerChooseSet = createStrategy();
        Integer firstPlayerChoose;
        Integer secondPlayerChoose;
        for(int i=0;i<100;i++) {
            firstPlayerCash = 0;
            secondPlayerCash = 0;

            for (int index = 0; index < 120; index++) {
                secondPlayerChoose = createFirstPlayerStrategy();
                firstPlayerChoose = createSecondPlayerStrategy();
                if ((firstPlayerChoose + secondPlayerChoose) % 2 == 0) {
                    firstPlayerCash -= firstPlayerChoose + secondPlayerChoose;
                    secondPlayerCash += firstPlayerChoose + secondPlayerChoose;
                } else {
                    firstPlayerCash += firstPlayerChoose + secondPlayerChoose;
                    secondPlayerCash -= firstPlayerChoose + secondPlayerChoose;
                }


            }

            System.out.println("first= " + firstPlayerCash);
        }
    }

    private static List<Integer> createStrategy() {
        List strategySet = new ArrayList<Integer>();
        for (int index = 0; index < sizeOfUserFirstStrategy; index++)
            strategySet.add(strategyArray.get(0));
        for (int index = 0; index < sizeOfUserStrategy - sizeOfUserFirstStrategy; index++)
            strategySet.add(strategyArray.get(1));
        return strategySet;
    }

    private static List<Integer> createStrategyArray() {
        List array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        return array;
    }

    private static Integer createFirstPlayerStrategy() {
       return strategyArray.get((new Random()).nextInt(strategyArray.size()));
    }

    private static Integer createSecondPlayerStrategy() {
        return firstPlayerChooseSet.get((new Random()).nextInt(firstPlayerChooseSet.size()));

    }
}
