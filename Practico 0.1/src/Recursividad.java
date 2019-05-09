public class Recursividad {

    int factorial(int value) {
        int p=0;

        if (value == 0) {
            p = 1;
        }
        if (value == 1) {
            p = 1;
        }

        if (value > 1) {
            p = value * factorial(value - 1);
        }
        return p;
    }

    double pow(double value, int pow) {
        double p=0;
        if (pow == 0) {
            p = 1;
        }
        if (pow > 0) {
            p = value * pow(value, pow - 1);
        }
        return p;
    }

    int sumN(int n) {
        int p=0;
        if (n == 0) {
            p = 0;
        } else {
            p = n * sumN(n - 1);
        }
        return p;
    }

    public static void main(String[] args){

    }


}