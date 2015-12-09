/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r22v4;

import battleship.interfaces.BattleshipsPlayer;
import tournament.player.PlayerFactory;

/**
 *
 * @author kaspe_000
 */
public class R22V4 implements PlayerFactory<BattleshipsPlayer> {

    public R22V4(){}
    
    
    @Override
    public BattleshipsPlayer getNewInstance()
    {
        return new Player();
    }

    @Override
    public String getID()
    {
        return "R22V4";
    }

    @Override
    public String getName()
    {
        return "V4";
    }
    
}
