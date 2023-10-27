import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite prirodni broj n: ");
        int broj = scanner.nextInt();
        for (int i = 1; i <= broj; i++)
            if (DjeljivSaSumomSvojihCifara(i))
                System.out.println(i);
    }

    public static boolean DjeljivSaSumomSvojihCifara (int n) {
        int suma = SumaCifara(n);
        return n % suma == 0;
    }

    public static int SumaCifara (int n) {
        int suma = 0;
        while (n > 0) {
            suma += (n % 10);
            n /= 10;
        }
        return suma;
    }
}