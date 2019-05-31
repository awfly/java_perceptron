import activation.SigmoidFunction;
import edu.BackpropagationTeacher;
import edu.Teacher;
import network.MultiLayerNetwork;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MultiLayerNetwork network = new MultiLayerNetwork(SigmoidFunction.getInstance(), 5, 3, 1);

        double[][] inputs = new double[][]          {{1, 0, 0, 1, 1}, {0, 1, 1, 0, 0}};
        double[][] expectedOutputs = new double[][] {{0},    {1}};

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

        double[] res = network.process(new double[]{1, 0, 0, 1, 1});
//        System.out.println("Укрепленная обшивка - да\n" +
//                "Большая вместимость пассажиров - нет\n" +
//                "Большая грузоподъемность - нет\n" +
//                "Возможность установить вооружение - да\n" +
//                "Возможность развить сверхзвуковую скорость - да\n");
//        Thread.sleep(1000);
//        for(double out : res) {
//            Thread.sleep(1000);
//            printRes(out);
//        }
//        System.out.println();
//
//        res = network.process(new double[]{0, 1, 1, 0, 0});
//        Thread.sleep(1000);
//        System.out.println("Укрепленная обшивка - нет\n" +
//                "Большая вместимость пассажиров - да\n" +
//                "Большая грузоподъемность - да\n" +
//                "Возможность установить вооружение - нет\n" +
//                "Возможность развить сверхзвуковую скорость - нет\n");
//        for(double out : res) {
//            Thread.sleep(1000);
//            printRes(out);
//        }
//        System.out.println();
//
//        res = network.process(new double[]{1, 1, 1, 0, 1});
//        Thread.sleep(1000);
//        System.out.println("Укрепленная обшивка - да\n" +
//                "Большая вместимость пассажиров - да\n" +
//                "Большая грузоподъемность - да\n" +
//                "Возможность установить вооружение - нет\n" +
//                "Возможность развить сверхзвуковую скорость - нет\n");
//        for(double out : res) {
//            Thread.sleep(1000);
//            printRes(out);
//        }
//        System.out.println();

        res = network.process(new double[]{1, 0, 1, 1, 1});
        Thread.sleep(1000);
        System.out.println("Укрепленная обшивка - да\n" +
                "Большая вместимость пассажиров - нет\n" +
                "Большая грузоподъемность - да\n" +
                "Возможность установить вооружение - да\n" +
                "Возможность развить сверхзвуковую скорость - да\n");
        for(double out : res) {
            Thread.sleep(1000);
            printRes(out);
        }
        System.out.println();

    }

    private static void printRes(double res){
        if(Math.round(res) == 0) System.out.println("Значение = "+ res +"\nВоенный");
        else System.out.println("Значение = "+ res +"\nГражданский");
    }
}
