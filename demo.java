import java.util.Scanner;

class demo {
    static {
        System.loadLibrary("demo");
    }

    private native int add(int a, int b);

    private native int sub(int a, int b);

    private native int mul(int a, int b);

    private native int div(int a, int b);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, ch;

        System.out.println("\nEnter value of a : ");
        a = sc.nextInt();
        System.out.println("\nEnter value of b : ");
        b = sc.nextInt();
        
        int c = add(a,b);
        System.out.println("Addition"+c);
    }

    //javac -h . demo.java
    // gcc -shared -o demo.dll -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" demo.c
    // java -classpath . -Djava.library.path=. demo


    // gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libdemo.so demo.c
    // java -classpath . -Djava.library.path=. demo

    //export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64 && javac -h . demo.java && gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libdemo.so demo.c && LD_LIBRARY_PATH=$PWD java -classpath . -Djava.library.path=. demo



}
