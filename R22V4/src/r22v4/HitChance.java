/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package r22v4;

import battleship.interfaces.Fleet;
import battleship.interfaces.Position;

/**
 *
 * @author kaspe_000
 */
public interface HitChance {
    
    public void assignValue();
    public void assignHit(Position pos);
    public Position nextHit(Fleet enemyShips, boolean target);
    public void assignHitValue(Position posS);
    public void print();    
    
}
