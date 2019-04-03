package network;

import activation.ActivationFunction;
import neuron.InputNeuron;
import neuron.Neuron;
import neuron.StandardNeuron;
import neuron.link.NeuralLink;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultiLayerNetwork implements Network {
    private List<InputNeuron> inputLayer;

    private List<List<Neuron>> layers;

    /**
     *
     * @param function activation function
     * @param inputCount count of inputs
     * @param layersCount count of layers
     */
    public MultiLayerNetwork(ActivationFunction function, int inputCount, int ... layersCount) {

        inputLayer = new ArrayList<>(inputCount);

        layers = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < inputCount; i++) {
            InputNeuron neuron = new InputNeuron();
            neuron.setActivationFunction(function);
            inputLayer.add(neuron);
        }

        List<? extends Neuron> inputs = inputLayer;
        for (int count : layersCount) {
            layers.add(new ArrayList<Neuron>(count));

            for (int i=0; i<count; i++) {
                StandardNeuron neuron = new StandardNeuron();
                neuron.setActivationFunction(function);

                for (Neuron inputNeuron : inputs) {
                    NeuralLink link = new NeuralLink();
                    link.setWeight(random.nextDouble() - 0.5);

                    inputNeuron.addOutputLink(link);
                    link.setInputNeuron(inputNeuron);

                    neuron.addInputLink(link);
                    link.setOutputNeuron(neuron);
                }
                layers.get(layers.size() - 1).add(neuron);
            }
            inputs = layers.get(layers.size() - 1);
        }
    }

    @Override
    public double[] process(double[] inputValues) {
        if (inputValues.length != inputLayer.size()) {
            throw new IllegalArgumentException("Count of input values must be equals " + inputLayer.size());
        }
        List<Neuron> outputLayer = layers.get(layers.size() - 1);

        double[] result = new double[outputLayer.size()];

        for (int i=0; i<inputLayer.size(); i++) {
            inputLayer.get(i).setInputValue(inputValues[i]);
        }
        for (int i = 0; i < outputLayer.size(); i++) {
            Neuron neuron = outputLayer.get(i);
            result[i] = neuron.getOutputValue();
        }

        return result;
    }

    @Override
    public List<List<Neuron>> getLayers() {
        return layers;
    }
}
