package edu;

import network.Network;

public interface Teacher {

    void training(Network network, double[] inputValues, double[] expectedOutputValues);

    void training(Network network, double[] inputValues, double[] expectedOutputValues, double learningRate);

}
