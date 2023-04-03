/**
 * Класс комплексных чисел
  */
public class ComplexNumb {
    public double a, b;

    /**
     * Конструктор класса
     * @param a - действительная часть
     * @param b - мнимая часть
     */
    public ComplexNumb(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumb(double a){
        this.a = a;
        b = 0;
    }

    /**
     * вывод комплексного числа
     * @return возвращает строку z=a+bi
     */
    public String getValues(){
        return "z=" + a + "+" + b + "i\n";
    }

    /**
     * Сложение двух комплексных чисел
     * @param a2 - действительная часть второго числа
     * @param b2 - мнимая часть второго числа
     */
    public void addition(double a2, double b2) {
        double a = this.a + a2;
        double b = this.b + b2;
        if (b > 0) System.out.println("\nСумма введенных чисел: z=" + a + "+" + b + "i\n");
        else System.out.println("\nСумма введенных чисел: z=" + a + "+" + b + "i\n");
    }

    /**
     * Умножение двух комплексных чисел
     * @param a2 - действительная часть второго числа
     * @param b2 - мнимая часть второго числа
     */
    public void multiply(double a2, double b2){
        double a = this.a*a2 + this.b*b2*(-1);
        double b = this.a*b2 + this.b*a2;
        if (b > 0) System.out.println("\nПроизведение введенных чисел: z=" + a + "+" + b + "i\n");
        else System.out.println("\nПроизведение введенных чисел: z=" + a + b + "i\n");
    }

    /**
     * Вывод числа в тригонометрической форме
     */
    public void trigonometricForm(){
        if (a==0 && b==0){
            System.out.println("Невозможно вывести это число в тригонометрической форме, " +
                    "так как для него неопределен аргумент");
            return;}
        int z = (int) Math.abs(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
        String fi = "";
        if (a==0 && b>0) fi = fi + "pi/2";
        else if (a==0 && b<0) fi = fi + "-pi/2";
        else if (a>0 && b==0) fi = fi + "0";
        else if (a<0 && b==0) fi = fi + "pi";
        else {
            String arg = "arctg";
            if (b%a == 0 && b/a>0) arg = arg + (int) b/a;
            else if (b%a == 0 && b/a<0) arg = arg + (int) (b/a)*(-1);
            else arg = arg +  b+ "/" + a;

            if (a > 0 && b > 0) fi += arg;
            else if (a > 0 && b < 0) fi = fi + "-" + arg;
            else if (a < 0 && b > 0) fi = fi + "pi-" + arg;
            else if (a < 0 && b < 0) fi = fi + "-pi" + "+" + arg;
        }
        if (z!=1) System.out.println("z=" + z + "(cos" + "(" + fi + ")" + "+i*sin" + "(" + fi + ")" + ")");
        else System.out.println("z=cos" + "(" + fi + ")" + "+i*sin" + "(" + fi + ")");

    }
}
