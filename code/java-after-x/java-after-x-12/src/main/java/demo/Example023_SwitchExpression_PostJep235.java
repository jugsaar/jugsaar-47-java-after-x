package demo;

public class Example023_SwitchExpression_PostJep235 {

    public static void main(String[] args) {

        String sizeText = "XL";

        var size = Size.valueOf(sizeText);

        int height = switch (size) {
            case S -> 11;
            case M -> 22;
            case L -> 33;
            case XL -> 44;
            case XXL -> 999;
        };

        System.out.printf("Height = %s%n", height);
    }

    enum Size {
        S, M, L, XL, XXL
    }

}

