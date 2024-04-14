public class Test {
    private void printCorrect()
    {
        System.out.print(".");
    }

    private void printError()
    {
        System.out.print("X");
    }

    private static void testPWD()
    {

    }



    public static void main(String[] argv)
    {
        switch(argv[1])
        {
            case "pwd":
                testPWD();
                break;
        }
        System.err.println();
    }
}
