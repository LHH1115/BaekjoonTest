public class Main {
    // 셀프넘버를 찾을 범위를 지정
    private static final int SIZE = 10000;
    // 셀프넘버를 체크하기 위한 배열
    private static boolean[] flags = new boolean[SIZE+1];
    
    // n의 각 자리수와 n 자신을 더한 값을 반환하는 함수
    private static int d(int n) {
        int result = n;
        char[] digits = String.valueOf(n).toCharArray();
        for( int i=0; i<digits.length; i++ ) {
            result += digits[i] - '0';
        }
        return result;
    }
    
    public static void main(String args[]) {
        int temp;
        // 1부터 SIZE까지의 숫자에 대해 반복
        for(int i=1; i<=SIZE; i++) {
            // 셀프넘버이면 출력
            if( !flags[i] ) System.out.println(i);
            // i의 생성자를 구하고, 범위 내에 있는 경우 체크
            temp = d(i);
            if( temp <= SIZE ) flags[temp] = true;
        }
    }
}