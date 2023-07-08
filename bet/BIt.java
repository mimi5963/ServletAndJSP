package bet;

public class BIt {

    public static void main(String[] args){

//        System.out.println("Binary to Decimal");
//
//        System.out.println(to_decimal("00000110"));
//        System.out.println(to_decimal("00010110"));
//        System.out.println(to_decimal("10010100"));
//
//        int i = to_decimal("00000101");
//        int j = to_decimal("01000110");
//
//        print_binary(i);
//        print_binary(j);
//        print_binary(i&j);
//
//        print_binary(127);
//        print_binary(-127);
//        print_binary(~127+1);
//        print_binary(12);
//        print_binary(-12);
//        print_binary(~12+1);

        print_binary((long)0xffffffff);
        System.out.println(0xffffffff);
    }

    private static void print_binary(long x) {
        long mask = (long)Math.pow(2,63);
        String result="";

        while(mask != 0){
            if((mask&x)==mask) result+='1';
            else result+='0';
            mask =mask>>1;
        }

        System.out.println("Decimal i "+x+" binary ="+result);


    }

    private static int to_decimal(String s) {
        int result=0;
        int bit = s.length();
        for(int i=s.length()-1;i>=0;i--){
            result += ((s.charAt(i)-'0') * Math.pow(2,7-i));
        }


        return result;
    }



}
