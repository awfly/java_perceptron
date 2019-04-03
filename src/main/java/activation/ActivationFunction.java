package activation;


public interface ActivationFunction {

    double process(double value);

    double derivative(double value);

}