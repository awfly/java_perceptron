package neuron;

import activation.ActivationFunction;
import neuron.link.NeuralLink;

import java.util.List;

public interface Neuron {

    double getOutputValue();
    double getDerivativeValue();

    void setActivationFunction(ActivationFunction activationFunction);
    ActivationFunction getActivationFunction();

    void addInputLink(NeuralLink neuralLink);
    void addOutputLink(NeuralLink neuralLink);

    List<NeuralLink> getInputLinks();
    List<NeuralLink> getOutputLinks();

    void reset();

}
