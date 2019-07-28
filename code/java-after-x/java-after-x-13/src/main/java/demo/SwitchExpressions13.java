package demo;

public class SwitchExpressions13 {

    public static void main(String[] args) {

        System.out.println(pollutionOfV4(Plastics.SPOON));

//        System.out.println(pollutionOf(null));
    }

    public static int pollutionOfV4(Plastics plastics) {

        return switch (plastics) {
            case SPOON -> 10;
            case STRAW, CUP -> 11;
//            case BOTTLE: {
//                // new hypenated keyword ..
// see: https://openjdk.java.net/jeps/8223002
////                break-with 42;
//            };
            case BOTTLE -> 42;
        };
    }

    enum Plastics {
        SPOON, STRAW, BOTTLE, CUP
    }



}
