class MyEx extends Exception {
}

class ExTestDrive {
    static void doRisky(String t) throws MyEx {
        System.out.println("h");
        if ("yes".equals(t)) {
            throw new MyEx();
        }
        System.out.println("r");
    }

    public static void main(String[] args) {
        String test = "yes";
        try {
            System.out.println("t");
            doRisky(test);
            System.out.println("o");
        } catch (Exception e) {
            System.out.println("a");
        } finally {
            System.out.println("w");
        }

        System.out.println("s");
    }
}
