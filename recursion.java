public class recursion {
    public static void main(String[] args) {
        factorial(5);

    }
    static int factorial(int num){
        if (num == 1 || num == 0){
            return 1;
        }
        return num * factorial(num - 1);
    }

    static int fibonacci(int num){
        if (num == 0){
            return 0;
        }
        if (num == 1){
            return 1;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}