/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion;

import gaframework.*;

/**
 *
 * @author Anuar
 */
public class MaxFun implements FitnessFunction<Integer> {

    @Override
    public double evaluate(Phenotype<Integer> p) {
        int x = p.getAllele(0).intValue();
        return x * (1024 - x);
    }

}
