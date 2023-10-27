import java.util.Scanner;
public class Zadatak2 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Unesite n: ");
            int n= scanner.nextInt();
            System.out.println("Svi brojevi od 1 do n djeljivi sa sumom svojih cifara: ");
            for(int i=1;i<n;i++){
                if(i % sumaCifara(i)==0)
                    System.out.println(i);
            }
    }
    public static int sumaCifara(int n){
        int sum=0;
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}