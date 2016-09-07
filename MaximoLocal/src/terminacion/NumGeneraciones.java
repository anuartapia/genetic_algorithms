/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminacion;

import gaframework.*;

/**
 *
 * @author Anuar
 */
public class NumGeneraciones implements TerminationCondition<Boolean, Integer> {

    private int numGen;

    public NumGeneraciones(int numGen) {
        this.numGen = numGen;
    }

    @Override
    public boolean conditionReached(Population<Boolean, Integer> p) {
        return p.getGeneration() >= numGen;
    }
}
