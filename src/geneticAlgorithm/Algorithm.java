package geneticAlgorithm;

public class Algorithm {
    static double uniformRate = 0.5;
    static double mutationRate = 0.015; //0.015
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    // Evolve the population
    public static Population evolvePopulation(Population pop) {
        Population newPop = new Population(pop.size(), false);
        //Population newPop = new Population(pop.size());

        // Keep the best individual
        if (elitism) {
            newPop.saveIndividual(0, pop.getFittest());
        }
        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individual indiv1 = tournamentSelection(pop);
            Individual indiv2 = tournamentSelection(pop);
            Individual newIndiv = crossover(indiv1, indiv2);
            newPop.saveIndividual(i, newIndiv);
        }
        // Mutate population
        for (int i = elitismOffset; i < newPop.size(); i++) {
            mutate(newPop.getIndividual(i));
        }
        return newPop;
    }

    // Crossover individuals
    private static Individual crossover(Individual indiv1, Individual indiv2) {
        Individual newSol = new Individual();
        // Loop through genes
        for (int i = 0; i < indiv1.size(); i++) {
            // Crossover
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, indiv1.getGene(i));
            } else {
                newSol.setGene(i, indiv2.getGene(i));
            }
        }
        return newSol;
    }

    // Mutate an individual
    private static void mutate(Individual indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                // Create a random gene
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    // Select individuals for crossover
    private static Individual tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false);
        //Population tournament = new Population(tournamentSize);

        // For each place in the tournament, get a random individual
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveIndividual(i, pop.getIndividual(randomId));
        }
        // Get the fittest
        return tournament.getFittest();
    }
}
