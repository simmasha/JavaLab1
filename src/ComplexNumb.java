 public class ComplexNumb {
    public int a, b;

    //конструктор
    public ComplexNumb(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public String getValues(){
        return "z=" + a + "+" + b + "i\n";
    }

     //сложение
    public void Addition(int a1, int b1, int a2, int b2) {
        int a = a1 + a2;
        int b = b1 + b2;
        if (b > 0) System.out.println("\nСумма введенных чисел: z=" + a + "+" + b + "i\n");
        else System.out.println("\nСумма введенных чисел: z=" + a + "+" + b + "i\n");
    }

    //умножение
    public void Multiply(int a1, int b1, int a2, int b2){
        int a = a1*a2 + b1*b2*(-1);
        int b = a1*b2 + b1*a2;
        if (b > 0) System.out.println("\nПроизведение введенных чисел: z=" + a + "+" + b + "i\n");
        else System.out.println("\nПроизведение введенных чисел: z=" + a + b + "i\n");
    }
    //тригонометрическая форма
    public void TrigonometricForm(){
        int z1 = (int) Math.abs(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
        int arg1 = (int) Math.atan(b/a);
        if (z1!=1) System.out.println("z=" + z1 + "(cos" + arg1 + "+i*sin" + arg1 + ")");
        else System.out.println("z=cos" + arg1 + "+i*sin" + arg1);

    }
}
