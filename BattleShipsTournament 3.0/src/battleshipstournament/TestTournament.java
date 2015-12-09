package battleshipstournament;

import battleship.implementations.Battleships;
import battleship.interfaces.BattleshipsPlayer;
import java.util.ArrayList;
import java.util.Collection;
import tournament.Tournament;
import tournament.impl.simpleui.TextTournamentUI;
import tournament.player.PlayerFactory;



/**
 *
 * @author Tobias Grundtvig
 */
public class TestTournament
{
    public static void main(String[] args) throws Exception
    {
        //Turn of Player IO
        TextTournamentUI.turnOffIO();
        //TODO: Path to your tournament directory (jar-files)
        String path = "C:/Users/kaspe_000/Documents/ai";
        Loader loader = new Loader(path);
        
        Collection<PlayerFactory<BattleshipsPlayer>> allAIs = new ArrayList<>();
        Collection<PlayerFactory<BattleshipsPlayer>> examples = loader.loadCategory("E", 50);
        Collection<PlayerFactory<BattleshipsPlayer>> green = loader.loadCategory("G", 100);
        Collection<PlayerFactory<BattleshipsPlayer>> yellow = loader.loadCategory("Y", 100);
        Collection<PlayerFactory<BattleshipsPlayer>> red = loader.loadCategory("R", 100);
        Collection<PlayerFactory<BattleshipsPlayer>> test = loader.loadCategory("T", 100);
        allAIs.addAll(test);
        allAIs.addAll(examples);
        allAIs.addAll(green);
        allAIs.addAll(yellow);
        allAIs.addAll(red);
        green.addAll(examples);
        yellow.addAll(examples);
        red.addAll(examples);
        
        System.out.println("This should never be printed!");
  
        System.out.println("Start GREEN tournament:\n");
        Tournament.run(Battleships.getGameFactory(), green);
        
        System.out.println("Start YELLOW tournament:\n");
        Tournament.run(Battleships.getGameFactory(), yellow);
        
        System.out.println("Start RED tournament:\n");
        Tournament.run(Battleships.getGameFactory(), red);
        
        System.out.println("Start TOTAL WAR tournament:\n");
        Tournament.run(Battleships.getGameFactory(), allAIs);
        
        TextTournamentUI.turnOnIO();
        
        System.out.println("Goodbye!");
    }
}
