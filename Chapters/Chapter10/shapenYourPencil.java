class TestBox {
    Integer i;//Need to  be initialized to a value 
    int j;

    // TestBox(){
    //     i = 1;
    // }

    public static void main(String[] args) {
        TestBox t = new TestBox();
        t.go();
    }

    void go() {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}