package bet;

public class RGBA {
    static int MASK = 0xFF;
    public static void main (String[] args){

        int rgba_color =0x66CDAAFF;
        //총 4 byte (102) (205) (170) (255)
        //두개씩 짜개서 색 표현 2진법아니고 16진법아닌가?
        // 66
        //32비트 개당 4비트
        System.out.println(0xff);



        int red,green,blue,alpha;

//        alpha = (rgba_color & MASK) ;
//        blue =(rgba_color & (MASK << 8)) >>8 ;
//        green =(rgba_color & (MASK << 16)) >>16 ;
//        red = (rgba_color & (MASK << 24)) >>24 ;

          alpha = (rgba_color & MASK) ;
         blue =(rgba_color >> 8 &MASK)  ;
         green =(rgba_color >> 16 &MASK)  ;
         red = (rgba_color >> 24  &MASK)  ;;

        System.out.println("(R,G,B,A)="+red+" "+green+" "+blue+" "+alpha);

    }
}
