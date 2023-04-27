import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Kneed = 1;
        int Qneed = 1;
        int Rneed = 2;
        int Bneed = 2;
        int KNneed = 2;
        int Pneed = 8;

        int Khave = sc.nextInt();
        int Qhave = sc.nextInt();
        int Rhave = sc.nextInt();
        int Bhave = sc.nextInt();
        int KNhave = sc.nextInt();
        int Phave = sc.nextInt();

        System.out.println(Kneed-Khave);
        System.out.println(Qneed-Qhave);
        System.out.println(Rneed-Rhave);
        System.out.println(Bneed-Bhave);
        System.out.println(KNneed-KNhave);
        System.out.println(Pneed-Phave);
        sc.close();
    }
}