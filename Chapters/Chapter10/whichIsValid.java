// Can be compiled successfully
class Foo {
    static int x;

    void go() {
        System.out.println(x);
    }
}

// 静态方法中不可以使用非静态变量
// class Foo2 {
// int x;

// static void go() {
// System.out.println(x);
// }
// }

// 变量x未在默认构造器中初始化
// class Foo3 {
// final int x;
// void go() {
// System.out.println(x);
// }
// }

// Can be compiled successfully
class Foo4 {
    static final int x = 12;

    void go() {
        System.out.println(x);
    }
}

// Can be compiled successfully
class Foo5 {
    static final int x = 12;

    void go(final int x) {
        System.out.println(x);
    }
}

// Can be compiled successfully
class Foo6 {
    int x = 12;

    static void go(final int x) {
        System.out.println(x);
    }
}
