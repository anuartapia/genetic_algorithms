/*
 * To change this license header, choose License Headers in Integerroject Integerroperties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maximolocal;

import ag.Simple;
import codificacion.BinInteger;
import funcion.MaxFun;
import gaframework.*;
import operador.cruza.OnePointCrossover;
import operador.mutacion.UniformMutation;
import operador.seleccion.RouletteSelection;
import terminacion.NumGeneraciones;

/**
 *
 * @author Anuar
 */
public class MaximoLocal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numBits = 10;
        int numNums = 1;
        int seed_cod = 10; //?
        Codification<Boolean, Integer> cod = new BinInteger(numBits, numNums, seed_cod);
        double prob_cro = 0.3;
        int seed_cro = 10;
        Corrector<Boolean> cor = null;
        CrossoverOp<Boolean> cro = new OnePointCrossover(prob_cro, seed_cro);
        double prob_muo = 0.01;
        int seed_muo = 10;
        MutationOp<Boolean> muo = new UniformMutation(prob_muo, seed_muo);
        int seed = 10;
        int numInd = 30;
        SelectionOp<Boolean, Integer> seo = new RouletteSelection(seed, numInd);
        FitnessFunction<Integer> fun = new MaxFun();
        ObjectiveFunction<Boolean, Integer> objFun = null;
        int numGen = 1000;
        TerminationCondition<Boolean, Integer> ter = new NumGeneraciones(numGen);
        int popSize = 1000;
        Simple ag = new Simple(cod,
                cor,
                cro,
                muo,
                seo,
                fun,
                objFun,
                ter,
                popSize);
        ag.run();
    }
}
