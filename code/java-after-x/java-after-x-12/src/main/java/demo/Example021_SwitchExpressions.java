package demo;

public class Example021_SwitchExpressions {

    public static void main(String[] args) {

        System.out.println(pollutionOf(Plastics.SPOON));

//        System.out.println(pollutionOf(null));
    }

    public static int pollutionOf(Plastics plastics) {

        int pollution = -1;

        switch (plastics) {
            case SPOON:
                pollution = 10;
                break;
            case STRAW:
                pollution = 11;
                break;
            case BOTTLE:
                pollution = 30;
                break;
            case CUP:
                pollution = 11;
                break;
        }

        return pollution;
    }

    enum Plastics {
        SPOON, STRAW, BOTTLE, CUP
    }


    public static int pollutionOfOrig(Plastics plastics) {

        int pollution = -1;

        switch (plastics) {
            case SPOON:
                pollution = 10;
                break;
            case STRAW:
                pollution = 11;
                break;
            case BOTTLE:
                pollution = 30;
                break;
            case CUP:
                pollution = 11;
                break;
        }

        return pollution;
    }

    public static int pollutionOfV1(Plastics plastics) {

        int pollution = switch (plastics) {
            case SPOON -> 10;
            case STRAW -> 11;
            case BOTTLE -> 30;
            case CUP -> 11;
        };

        return pollution;
    }

    public static int pollutionOfV2(Plastics plastics) {

        return switch (plastics) {
            case SPOON -> 10;
            case STRAW -> 11;
            case BOTTLE -> 30;
            case CUP -> 11;
        };
    }

    public static int pollutionOfV3(Plastics plastics) {

        return switch (plastics) {
            case SPOON -> 10;
            case STRAW, CUP -> 11;
            case BOTTLE -> 30;
        };
    }


    public static int pollutionOfV4(Plastics plastics) {

        return switch (plastics) {
            case SPOON -> 10;
            case STRAW, CUP -> 11;
            case BOTTLE -> {
                int pollution = 30;
                // some additional logic
                break pollution;
            }
        };
    }


    public static int pollutionOfV5(Plastics plastics) {

        return switch (plastics) {
            case SPOON:
                break 10;
            case STRAW, CUP:
                break 11;
            case BOTTLE:
                int pollution = 30;
                // some additional logic
                break pollution;
        };
    }
}
