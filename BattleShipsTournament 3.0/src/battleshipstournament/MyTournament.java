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
public class MyTournament
{
    public static void main(String[] args) throws Exception
    {

        //TODO: Path to your tournament directory (jar-files)
        String path = "C:\\Users\\kaspe_000\\Documents\\ai";
        Loader loader = new Loader(path);
        
        Collection<PlayerFactory<BattleshipsPlayer>> allAIs = new ArrayList<>();
        allAIs.addAll(loader.loadCategory("E", 50));
        allAIs.addAll(loader.loadCategory("G", 100));
        allAIs.addAll(loader.loadCategory("Y", 100));
        allAIs.addAll(loader.loadCategory("R", 100));
        allAIs.addAll(loader.loadCategory("R22V", 100));
        allAIs.addAll(loader.loadCategory("T", 100));
        allAIs.addAll(loader.loadCategory("O", 100));
        
        
        System.out.println("Start TOTAL WAR tournament:\n");
        Tournament.run(Battleships.getGameFactory(), allAIs);
        
        System.out.println("Goodbye!");
    }
}
