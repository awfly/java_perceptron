import activation.SigmoidFunction;
import edu.BackpropagationTeacher;
import edu.Teacher;
import network.MultiLayerNetwork;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MultiLayerNetwork network = new MultiLayerNetwork(SigmoidFunction.getInstance(), 2, 3, 1);

        double[][] inputs = new double[][]          {{1, 1}, {0, 1}, {1, 0}, {0, 0}};
        double[][] expectedOutputs = new double[][] {{0},    {1},    {1},    {0}}; //XOR

        Teacher teacher = new BackpropagationTeacher();

        int count = 0;

        while (true) {
            for (int i = 0; i< inputs.length; i++) {
                teacher.training(network, inputs[i], expectedOutputs[i], 1.4);
            }

            if (count++ > 2000) {
                break;
            }
        }

        double[] res = network.process(new double[]{1, 0});
        System.out.println("1, 0");
        Thread.sleep(1000);
        for(double out : res) {
            Thread.sleep(1000);
            System.out.println(out);
        }
        System.out.println();

        res = network.process(new double[]{0, 1});
        Thread.sleep(1000);
        System.out.println("0, 1");
        for(double out : res) {
            Thread.sleep(1000);
            System.out.println(out);
        }
        System.out.println();

        res = network.process(new double[]{1, 1});
        System.out.println("1, 1");
        Thread.sleep(1000);
        for(double out : res) {
            Thread.sleep(1000);
            System.out.println(out);
        }
        System.out.println();

        res = network.process(new double[]{0, 0});
        System.out.println("0, 0");
        Thread.sleep(1000);
        for(double out : res) {
            Thread.sleep(1000);
            System.out.println(out);
        }
    }
}
