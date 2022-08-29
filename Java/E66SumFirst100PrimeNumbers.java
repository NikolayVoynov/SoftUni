package Basic1;

public class E66SumFirst100PrimeNumbers {
    public static void main(String[] args) {

        int sum = 0;
        int primeNums = 0;
        int currentNum = 0;

        while (primeNums < 100) {

            if (currentNum > 0 && currentNum != 1) {
                if (currentNum == 2) {
                    sum += currentNum;
                    primeNums++;

                } else if (currentNum % 2 != 0) {
                    if (isPrime(currentNum)) {
                        primeNums++;
                        sum += currentNum;
                    }
                }
            }

            currentNum++;
        }

        System.out.println(sum);
    }

    private static boolean isPrime(int currentNum) {
        for (int i = 3; i * i <= currentNum; i += 2) {
            if (currentNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
