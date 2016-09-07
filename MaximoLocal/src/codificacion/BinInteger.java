/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codificacion;

import gaframework.*;
import java.util.Arrays;

/**
 *
 * @author Anuar
 */
public class BinInteger implements Codification<Boolean, Integer>{
    
    /* número de bits que ocupa cad codón, es decir cada número,
    para maximización de una función f:[0,1024] IN Z->R necesitamos un número
    de 11 bits */
    private final int numBits;
    private final int numNums;

    public BinInteger(int numBits, int numNums) {
        this.numBits = numBits;
        this.numNums = numNums;
    }
    private Integer pow(Integer a, Integer b){
        Integer result = a.intValue();
        for(int i = 1; i < b; i++){
            result *= a;
        }
        return result;
    }
    private Boolean[] integerToBinary(Integer number){
        final Boolean[] bits = new Boolean[numBits];
        for (int i = 0; i < numBits; i++) {
            bits[numBits - 1 - i] = (1 << i & number) != 0;
        }
        return bits;
    }
    private Integer binaryToInteger(Boolean[] bits){
        Integer number = 0;
        for (int i = 0; i < numBits; i++) {
            number += bits[numBits - 1 - i] ? pow(2,i) : 0;
        }
        return number;
    }
    @Override
    public Genotype<Boolean> encode(Phenotype<Integer> phenotype) {
        Genotype<Boolean> genotype = new Genotype(numNums * numBits);
        for (int i = 0; i < numNums; i++) { // numNums must == phenotype.size()
            Integer allele = phenotype.getAllele(i);
            Boolean[] codon = integerToBinary(allele);
            for (int j = 0; j < numBits; j++) {
                genotype.setGene(i + j, codon[j]);
            }
        }
        return genotype;
    }

    @Override
    public Phenotype<Integer> decode(Genotype<Boolean> genotype) {
        Phenotype<Integer> phenotype = new Phenotype(numNums);
        for(int i = 0; i < numNums; i++){
            Boolean[] bits = new Boolean[numBits];
            for(int j = 0; j < numBits ;j++){
                bits[j] = genotype.getGene(i);
            }
            Integer number = binaryToInteger(Arrays.copyOfRange(bits, i, i));
            phenotype.setAllele(i, number);
        }
        return phenotype;
    }

    @Override
    public Genotype<Boolean> newRandomGenotype() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
