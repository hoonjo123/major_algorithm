package programmers;

public class samjinbob {
    public static void main(String[] args) {
        //n을 3진법으로 변환한다.
        //앞뒤로 뒤집고
        //10진법으로 표현한다.
//        int n = 45;
//        String str = "";
//
//        while( n != 0){
//            str = str + ( n % 3 );
//            n /= 3;
//        }
//
//        System.out.println(Integer.parseInt(str,3));
//        ----------강사님코드 -----------
        int n = 125;
        int answer = 0;
        String temp = "";

        while(n>0){
            temp += Integer.toString( n % 3);
            n /= 3;
        }
        int temp_length = temp.length()-1;
        for(int i = 0; i<temp.length(); i++){
            answer += Integer.parseInt(String.valueOf(temp.charAt(i))) * (int)Math.pow(3, temp_length);
            temp_length--;
        }
//        System.out.println(temp); //22111
        System.out.println(answer);
    }
}
