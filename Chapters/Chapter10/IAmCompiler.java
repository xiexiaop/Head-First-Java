class staticSuper {
    static {
        System.out.println("super static block");
    }

    staticSuper() {
        System.out.println("super constructor");
    }
}

class staticTest extends staticSuper {
    static int rand;

    static {
        rand = (int) (Math.random() * 6);
        System.out.println("static block " + rand);
    }

    staticTest() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("I'm in main");
        staticTest st = new staticTest();
    }
}
