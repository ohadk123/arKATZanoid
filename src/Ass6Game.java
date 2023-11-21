// 211541750 Ohad Katz
import java.util.ArrayList;
import java.util.List;

import biuoop.GUI;;

/**
 * Main class to run the game!
 * @author Ohad Katz (ohad43@gmail.com)
 * @version alpha1.0.0.a
 * @since 07/05/2023
 */
public class Ass6Game {
    /**
     * The main method - Starts and initializes the program.
     * @param args - No args necessary
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = levelFlowFromArgs(convertArgsToIntegers(args));
        GameFlow gameFlow = new GameFlow(new AnimationRunner(new GUI("arKATZanoid", GameLevel.WIDTH, GameLevel.HEIGHT)));
        gameFlow.runLevels(levels);
        gameFlow.getGUI().close();
    }

    private static List<LevelInformation> levelFlowFromArgs(List<Integer> argsIntegers) {
        LevelInformation[] levels = {new DirectHit(), new WideEasy(), new MidnightCity(), new JojoApprochesDio()};
        ArrayList<LevelInformation> levelsToRun = new ArrayList<>();

        // Choose levels to add based on numbers in list
        for (int levelNum : argsIntegers) {
            if (levelNum > levels.length) {
                continue;
            } else {
                levelsToRun.add(levels[levelNum - 1]);
            }
        }

        return levelsToRun;
    }

    private static List<Integer> convertArgsToIntegers(String[] args) {
        ArrayList<Integer> argsIntegers = new ArrayList<>();

        // Convert String array to int array, ignoring non-integers and non-positive numbers
        for (String string : args) {
            try {
                int argInt = Integer.parseInt(string);
                if (argInt <= 0) {
                    break;
                } else {
                    argsIntegers.add(argInt);
                }
            } catch (Exception e) {
                // It's okay
            }
        }

        return argsIntegers;
    }
}
