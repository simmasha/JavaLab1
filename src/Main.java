import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("##########################################################################");
            System.out.println("""
                    С чем вы хотите работать? Введите:
                    1 - для работы с комплексными числами
                    2 - для работы с матрицами
                    3 - завершить программу
                    """);
            int command = in.nextInt();
            if (command == 1) CmplxNmb();
            else if (command == 2) {
                System.out.println("""
                        Что будет элементами матрицы? Введите:
                        1, если элементы - действительные числа
                        2, если элементы - комплексные числа""");
                int command2 = in.nextInt();
                if (command2 == 1) Mtrx();
                else if (command2 == 2) ComplexMtrx();
            }
            else if (command == 3) break;

        }
    }

    public static void CmplxNmb(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите два комплексных числа в формате a b, " +
                "где a - действительная часть, b - мнимая часть:");
        System.out.println("Введите первое число: ");
        int a1 = in.nextInt();
        int b1 = in.nextInt();
        System.out.println("Введите второе число: ");
        int a2 = in.nextInt();
        int b2 = in.nextInt();

        ComplexNumb num1 = new ComplexNumb(a1, b1);
        ComplexNumb num2 = new ComplexNumb(a2, b2);

        while (true) {
            System.out.println("##########################################################################");
            System.out.println("\nВведенные числа:\n" + num1.getValues() + num2.getValues());
            System.out.println("""
                    Доступные команды:
                    1 - сложить введенные числа
                    2 - перемножить введенные числа
                    3 - вывести число в тригонометрической форме
                    4 - поменять число
                    5 - выход""");
            int command = in.nextInt();
            if (command == 1) num1.Addition(num1.a, num1.b, num2.a, num2.b);
            else if (command == 2) num1.Multiply(num1.a, num1.b, num2.a, num2.b);
            else if (command == 3) {
                System.out.print("""
                        \nВведите:
                        1, если хотите вывести первое число в тригонометрической форме
                        2, если хотите вывести второе число в тригонометрической форме
                        """);
                int command2 = in.nextInt();
                if (command2 == 1) {
                    System.out.println("\nПервое число в тригонометрической форме: ");
                    num1.TrigonometricForm();
                } else if (command2 == 2) {
                    System.out.println("\nВторое число в тригонометрической форме: ");
                    num2.TrigonometricForm();
                }
            } else if (command == 4) {
                System.out.print("""
                        Введите:
                        1, если хотите поменять первое число
                        2, если хотите поменять второе число
                        """);
                int command2 = in.nextInt();
                if (command2 == 1) {
                    System.out.println("Введите комплексное число в формате a b, " +
                            "где a - действительная часть, b - мнимая часть:");
                    a1 = in.nextInt();
                    b1 = in.nextInt();
                    num1 = new ComplexNumb(a1, b1);
                } else if (command2 == 2) {
                    System.out.println("Введите комплексное число в формате a b, " +
                            "где a - действительная часть, b - мнимая часть:");
                    a2 = in.nextInt();
                    b2 = in.nextInt();
                    num2 = new ComplexNumb(a2, b2);
                }
            } else if (command == 5) {
                break;
            }


        }
    }

    public static void Mtrx() {
        Scanner in = new Scanner(System.in);
        int n1, m1, n2, m2;
        System.out.println("Введите размеры первой матрицы: ");
        n1 = in.nextInt();
        m1 = in.nextInt();
        System.out.println("Введите размеры второй матрицы: ");
        n2 = in.nextInt();
        m2 = in.nextInt();
        Matrix mtrx1 = new Matrix(n1, m1);
        Matrix mtrx2 = new Matrix(n2, m2);
        System.out.println("Введите значения для первой матрицы: ");
        mtrx1.fill();
        System.out.println("Введите значения для второй матрицы: ");
        mtrx2.fill();

        while (true){
            System.out.println("##########################################################################");
            System.out.println("Введенные матрицы:\nПервая матрица:");
            mtrx1.print(mtrx1.matrix, n1, m1);
            System.out.println("Вторая матрица:");
            mtrx2.print(mtrx2.matrix, n2, m2);

            System.out.println("""
                    \nДоступные команды:
                    1 - сложить введенные матрицы
                    2 - перемножить введенные матрицы
                    3 - транспонировать матрицу
                    4 - поменять матрицу
                    5 - выход""");
            int command = in.nextInt();
            if (command == 1) {
                System.out.println("\nСумма веденных матриц:");
                mtrx1.Addition(mtrx1.matrix, mtrx2.matrix);
            }
            else if (command == 2){
                System.out.println("""
                    \nВведите:
                    1, чтобы перемножить первую матрицу на вторую
                    2, чтобы перемножить вторую матрицу на первую
                    """);
                int command2 = in.nextInt();
                if (command2 == 1) {
                    System.out.println("\nПроизведение первой матрицы на вторую:");
                    mtrx1.Multiply(mtrx1.matrix, mtrx2.matrix, n1, m1, m2);
                }
                else if (command2 == 2) {
                    System.out.println("\nПроизведение второй матрицы на первую:");
                    mtrx2.Multiply(mtrx2.matrix, mtrx1.matrix, n2, m2, m1);
                }
            }
            else if (command == 3){
                System.out.println("""
                    \nВведите:
                    1, чтобы транспонировать первую матрицу
                    2, чтобы транспонировать вторую матрицу
                    """);
                int command2 = in.nextInt();
                if (command2 == 1) {
                    System.out.println("\nПервая матрица в транспонированном виде:");
                    mtrx1.Transpose();
                }
                else if (command2 == 2) {
                    System.out.println("\nВторая матрица в транспонированном виде:");
                    mtrx2.Transpose();
                }
            }
            else if (command == 4){
                System.out.print("""
                        Введите:
                        1, если хотите поменять первую матрицу
                        2, если хотите поменять вторую матрицу
                        """);
                int command2 = in.nextInt();
                if (command2 == 1){
                    System.out.println("Введите размеры первой матрицы: ");
                    n1 = in.nextInt();
                    m1 = in.nextInt();
                    mtrx1 = new Matrix(n1, m1);
                    System.out.println("Введите значения для первой матрицы: ");
                    mtrx1.fill();
                }
                else if (command2 == 2){
                    System.out.println("Введите размеры второй матрицы: ");
                    n2 = in.nextInt();
                    m2 = in.nextInt();
                    mtrx2 = new Matrix(n2, m2);
                    System.out.println("Введите значения для второй матрицы: ");
                    mtrx2.fill();
                }
            }
            else if (command == 5) break;
        }
    }

    public static void ComplexMtrx(){
        Scanner in = new Scanner(System.in);
        int n1, m1, n2, m2;
        System.out.println("Введите размеры первой матрицы: ");
        n1 = in.nextInt();
        m1 = in.nextInt();
        System.out.println("Введите размеры второй матрицы: ");
        n2 = in.nextInt();
        m2 = in.nextInt();
        ComplexMatrix mtrx1 = new ComplexMatrix(n1, m1);
        ComplexMatrix mtrx2 = new ComplexMatrix(n2, m2);
        System.out.println("Введите значения для первой матрицы. Для каждого элемента введите 2 числа в формате a b, " +
                "где a - действительная часть, b - мнимая часть: ");
        mtrx1.fill();
        System.out.println("Введите значения для второй матрицы. Для каждого элемента введите 2 числа в формате a b, " +
                "где a - действительная часть, b - мнимая часть:");
        mtrx2.fill();

        while (true){
            System.out.println("##########################################################################");
            System.out.println("Введенные матрицы:\nПервая матрица:");
            mtrx1.print(mtrx1.matrix, n1, m1);
            System.out.println("Вторая матрица:");
            mtrx2.print(mtrx2.matrix, n2, m2);

            System.out.println("""
                    \nДоступные команды:
                    1 - сложить введенные матрицы
                    2 - перемножить введенные матрицы
                    3 - транспонировать матрицу
                    4 - поменять матрицу
                    5 - выход""");
            int command = in.nextInt();
            if (command == 1) {
                System.out.println("\nСумма веденных матриц:");
                mtrx1.Addition(mtrx1.matrix, mtrx2.matrix);
            }
            else if (command == 2){
                System.out.println("""
                    \nВведите:
                    1, чтобы перемножить первую матрицу на вторую
                    2, чтобы перемножить вторую матрицу на первую
                    """);
                int command2 = in.nextInt();
                if (command2 == 1) {
                    System.out.println("\nПроизведение первой матрицы на вторую:");
                    mtrx1.Multiply(mtrx1.matrix, mtrx2.matrix, n1, m1, m2);
                }
                else if (command2 == 2) {
                    System.out.println("\nПроизведение второй матрицы на первую:");
                    mtrx2.Multiply(mtrx2.matrix, mtrx1.matrix, n2, m2, m1);
                }
            }
            else if (command == 3){
                System.out.println("""
                    \nВведите:
                    1, чтобы транспонировать первую матрицу
                    2, чтобы транспонировать вторую матрицу
                    """);
                int command2 = in.nextInt();
                if (command2 == 1){
                    System.out.println("\nПервая матрица в транспонированном виде:");
                    mtrx1.Transpose();
                }
                else if (command2 == 2)  {
                    System.out.println("\nВторая матрица в транспонированном виде:");
                    mtrx2.Transpose();
                }
            }
            else if (command == 4){
                System.out.print("""
                        Введите:
                        1, если хотите поменять первую матрицу
                        2, если хотите поменять вторую матрицу
                        """);
                int command2 = in.nextInt();
                if (command2 == 1){
                    System.out.println("Введите размеры первой матрицы: ");
                    n1 = in.nextInt();
                    m1 = in.nextInt();
                    mtrx1 = new ComplexMatrix(n1, m1);
                    System.out.println("Введите значения для первой матрицы. Для каждого элемента введите 2 числа в формате a b, " +
                            "где a - действительная часть, b - мнимая часть: ");
                    mtrx1.fill();
                }
                else if (command2 == 2){
                    System.out.println("Введите значения для второй матрицы. Для каждого элемента введите 2 числа в формате a b, " +
                            "где a - действительная часть, b - мнимая часть:");
                    n2 = in.nextInt();
                    m2 = in.nextInt();
                    mtrx2 = new ComplexMatrix(n2, m2);
                    System.out.println("Введите значения для второй матрицы: ");
                    mtrx2.fill();
                }
            }
            else if (command == 5) break;
        }
    }
}