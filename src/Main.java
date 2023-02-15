import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Начало программы
 */
public class Main {
    /**
     * В методе main начинается работа программы. Здесь мы выбираем с чем мы хотим работать.
     * В консоль выводится соответствующий вопрос и доступные комманды.
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("##########################################################################");
            System.out.print("""
                    С чем вы хотите работать? Введите:
                    1 - для работы с комплексными числами
                    2 - для работы с матрицами
                    3 - завершить программу
                    """);

            int command;
            try {
                command = in.nextInt();}
            catch (InputMismatchException e) {
                System.out.println("Введена неверная команда");
                break;
            }

            if (command == 1) cmplxnmb();
            else if (command == 2) {
                System.out.println("""
                        Что будет элементами матрицы? Введите:
                        1, если элементы - действительные числа
                        2, если элементы - комплексные числа""");
                while (true) {
                    int command2;
                    try {
                        command2 = in.nextInt();}
                    catch (InputMismatchException ex) {
                        System.out.println("Введена неверная команда");
                        break;
                    }
                    if (command2 == 1) mtrx();
                    else if (command2 == 2) complexmtrx();
                    else if (command2 > 2){
                        System.out.println("Введена неверная команда");
                        break;
                    }
                }
            }
            else if (command == 3) break;
            else if (command > 3) {
                System.out.println("Введена неверная команда");
                break;
            }
        }
    }

    /**
    * Метод cmplxnmb запускается при желании пользователя работать с комплексными числами.
    * Вначале пользователю потребуется ввести два числа. Затем соответствующими командами он может сложить или перемножить числа,
    * вывести число в тригонометрической форме, а также изменить число.
    */
    public static void cmplxnmb(){

        Scanner in = new Scanner(System.in);
        System.out.println("Введите два комплексных числа в формате a b, " +
                "где a - действительная часть, b - мнимая часть:");
        double a1, b1, a2, b2;

        System.out.println("Введите первое число: ");
        try {
            a1 = in.nextDouble();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}
        try {
            b1 = in.nextDouble();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}

        System.out.println("Введите второе число: ");
        try {
            a2 = in.nextDouble();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}
        try {
            b2 = in.nextDouble();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}

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

            int command;
            try {
                command = in.nextInt();}
            catch (InputMismatchException e){
                System.out.println("Введена неверная команда");
                break;}

            if (command == 1) num1.addition(num2.a, num2.b);
            else if (command == 2) num1.multiply(num2.a, num2.b);
            else if (command == 3) {
                System.out.print("""
                        \nВведите:
                        1, если хотите вывести первое число в тригонометрической форме
                        2, если хотите вывести второе число в тригонометрической форме
                        """);

                int command2;
                try {
                    command2 = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Введена неверная команда");
                    break;
                }

                if (command2 == 1) {
                    System.out.println("\nПервое число в тригонометрической форме: ");
                    num1.trigonometricForm();
                } else if (command2 == 2) {
                    System.out.println("\nВторое число в тригонометрической форме: ");
                    num2.trigonometricForm();
                }
            }
            else if (command == 4) {
                System.out.print("""
                        Введите:
                        1, если хотите поменять первое число
                        2, если хотите поменять второе число
                        """);

                int command2;
                try {
                    command2 = in.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Введена неверная команда");
                    break;
                }

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
            }
            else if (command == 5) break;
            else{
                System.out.println("Введена неверная команда");
                break;}
        }
    }

    /**
    * Метод mtrx запускается при желании пользователя работать с матрицами, элементами которой являются действительные числа.
    * Вначале пользователю потребуется ввести две матрицы. Затем соответствующими командами он может сложить или перемножить матрицы,
    * транспонировать матрицу, а также изменить матрицу.
    */
    public static void mtrx() {
        Scanner in = new Scanner(System.in);
        int n1, m1, n2, m2;

        System.out.println("Введите размеры первой матрицы: ");
        try {n1 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;
        }
        try {m1 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;
        }

        System.out.println("Введите размеры второй матрицы: ");
        try {n2 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;
        }
        try {m2 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;
        }

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
            int command;
            try {
                command = in.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Введена неверная команда");
                break;
            }
            if (command == 1) {
                System.out.println("\nСумма веденных матриц:");
                mtrx1.addition(mtrx1.matrix, mtrx2.matrix, n2, m2);
            }
            else if (command == 2){
                System.out.println("""
                    \nВведите:
                    1, чтобы перемножить первую матрицу на вторую
                    2, чтобы перемножить вторую матрицу на первую
                    """);
                int command2;
                try {
                    command2 = in.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("Введена неверная команда");
                    break;
                }
                if (command2 == 1) {
                    System.out.println("\nПроизведение первой матрицы на вторую:");
                    mtrx1.multiply(mtrx1.matrix, mtrx2.matrix, n2, m2);
                }
                else if (command2 == 2) {
                    System.out.println("\nПроизведение второй матрицы на первую:");
                    mtrx2.multiply(mtrx2.matrix, mtrx1.matrix, n1, m1);
                }
                else if (command2 > 2){
                    System.out.println("Введена неверная команда");
                    break;
                }
            }
            else if (command == 3){
                System.out.println("""
                    \nВведите:
                    1, чтобы транспонировать первую матрицу
                    2, чтобы транспонировать вторую матрицу
                    """);
                int command2;
                try {
                    command2 = in.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("Введена неверная команда");
                    break;
                }
                if (command2 == 1) {
                    System.out.println("\nПервая матрица в транспонированном виде:");
                    mtrx1.transpose();
                }
                else if (command2 == 2) {
                    System.out.println("\nВторая матрица в транспонированном виде:");
                    mtrx2.transpose();
                }
                else if (command2 > 2){
                    System.out.println("Введена неверная команда");
                    break;
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

    /**
    * Метод complexmtrx запускается при желании пользователя работать с матрицами, элементами которой являются комплексные числа.
    * Вначале пользователю потребуется ввести две матрицы. Затем соответствующими командами он может сложить или перемножить матрицы,
    * транспонировать матрицу, а также изменить матрицу.
    */
    public static void complexmtrx(){
        Scanner in = new Scanner(System.in);
        int n1, m1, n2, m2;
        System.out.println("Введите размеры первой матрицы: ");
        try {
            n1 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}
        try {
            m1 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}

        System.out.println("Введите размеры второй матрицы: ");
        try {
            n2 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}
        try {
            m2 = in.nextInt();}
        catch (InputMismatchException e){
            System.out.println("ОШИБКА: нужно ввести число");
            return;}

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

            int command;
            try {
                command = in.nextInt();}
            catch (InputMismatchException e) {
                System.out.println("Введена неверная команда");
                break;}

            if (command == 1) {
                System.out.println("\nСумма веденных матриц:");
                mtrx1.addition(mtrx1.matrix, mtrx2.matrix, n2, m2);}
            else if (command == 2){
                System.out.println("""
                    \nВведите:
                    1, чтобы перемножить первую матрицу на вторую
                    2, чтобы перемножить вторую матрицу на первую
                    """);
                int command2;
                try {
                    command2 = in.nextInt();}
                catch (InputMismatchException ex) {
                    System.out.println("Введена неверная команда");
                    break;}

                if (command2 == 1) {
                    System.out.println("\nПроизведение первой матрицы на вторую:");
                    mtrx1.multiply(mtrx1.matrix, mtrx2.matrix, n2, m2);}
                else if (command2 == 2) {
                    System.out.println("\nПроизведение второй матрицы на первую:");
                    mtrx2.multiply(mtrx2.matrix, mtrx1.matrix, n1, m1);}
                else if (command2 > 2){
                    System.out.println("Введена неверная команда");
                    break;}
            }
            else if (command == 3){
                System.out.println("""
                    \nВведите:
                    1, чтобы транспонировать первую матрицу
                    2, чтобы транспонировать вторую матрицу
                    """);

                int command2;
                try {
                    command2 = in.nextInt();}
                catch (InputMismatchException ex) {
                    System.out.println("Введена неверная команда");
                    break;}

                if (command2 == 1){
                    System.out.println("\nПервая матрица в транспонированном виде:");
                    mtrx1.transpose();}
                else if (command2 == 2)  {
                    System.out.println("\nВторая матрица в транспонированном виде:");
                    mtrx2.transpose();}
                else if (command2 > 2){
                    System.out.println("Введена неверная команда");
                    break;}
            }
            else if (command == 4){
                System.out.print("""
                        Введите:
                        1, если хотите поменять первую матрицу
                        2, если хотите поменять вторую матрицу
                        """);
                int command2;
                try {
                    command2 = in.nextInt();}
                catch (InputMismatchException ex) {
                    System.out.println("Введена неверная команда");
                    break;}

                if (command2 == 1){
                    System.out.println("Введите размеры первой матрицы: ");
                    n1 = in.nextInt();
                    m1 = in.nextInt();
                    mtrx1 = new ComplexMatrix(n1, m1);
                    System.out.println("Введите значения для первой матрицы. Для каждого элемента введите 2 числа в формате a b, " +
                            "где a - действительная часть, b - мнимая часть: ");
                    mtrx1.fill();}
                else if (command2 == 2){
                    System.out.println("Введите значения для второй матрицы. Для каждого элемента введите 2 числа в формате a b, " +
                            "где a - действительная часть, b - мнимая часть:");
                    n2 = in.nextInt();
                    m2 = in.nextInt();
                    mtrx2 = new ComplexMatrix(n2, m2);
                    System.out.println("Введите значения для второй матрицы: ");
                    mtrx2.fill();}
                else if (command2 > 2){
                    System.out.println("Введена неверная команда");
                    break;}
            }
            else if (command == 5) break;
            else if (command > 5) {
                System.out.println("Введена неверная команда");
                break;}
        }
    }
}