package geneticAlgorithm;

public class Population {
    Individual[] individuals;

    // Constructor to create a population
    public Population(int populationSize, boolean initialise) {
        // Initialize the array to hold individuals
        individuals = new Individual[populationSize];
        if (initialise) {
            // Loop for creating individuals
            for (int i = 0; i < size(); i++) {
                Individual newInd = new Individual();
                newInd.genIndividual();
                saveIndividual(i, newInd);
            }
        }
    }

    // Getter to retrieve an individual at specified index
    public Individual getIndividual(int index) {
        return individuals[index];
    }

    // Method to retrieve the fittest individual in the population
    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find the fittest one
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    // Method to get the size of the population
    public int size() {
        return individuals.length;
    }

    // Method to save an individual into the population at specified index
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
}
