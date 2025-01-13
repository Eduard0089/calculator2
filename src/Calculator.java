import java.util.Scanner;

public class Calculator {
    public static double Calculating(int firstElement, int secondElement, String [] s2_array) {
        double result1 = 0;
        if (s2_array[1].equals("+")) {
            result1 = firstElement + secondElement;
        } else if (s2_array[1].equals("-")) {
            result1 = firstElement - secondElement;
        } else if (s2_array[1].equals("/")) {
            result1 = (double) firstElement / secondElement;
        } else if (s2_array[1].equals("*")) {
            result1 = (double) firstElement * secondElement;
        }
        return result1;
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, NumberFormatException {

        Scanner scanner1 = new Scanner(System.in);
        String i = scanner1.nextLine();
        String[] s2_array = i.split(" ");
        double result1 = 0;
        int firstElement = 0;
        int secondElement = 0;

        try {


            if (s2_array[1].equals("+") || s2_array[1].equals("-") || s2_array[1].equals("/") || s2_array[1].equals("*")) {
            } else {
                throw new IllegalArgumentException();
            }
            try {

                firstElement = Integer.parseInt(s2_array[0]);
                secondElement = Integer.parseInt(s2_array[2]);
                result1 = Calculating(firstElement, secondElement, s2_array);
                System.out.println(result1);

            } catch (NumberFormatException e) {
                try {
                    int arabskoe1 = 0;
                    int arabskoe2 = 0;
                    RimskiyeCifry[] massivRimskihCifr = RimskiyeCifry.values();
                    for (int j = 0; j < 10; j++) {
                        if (massivRimskihCifr[j].toString().equals(s2_array[0])) {
                            arabskoe1 = massivRimskihCifr[j].arabNumber();
                        }

                        if (massivRimskihCifr[j].toString().equals(s2_array[2])) {
                            arabskoe2 = massivRimskihCifr[j].arabNumber();


                        }
                    }
                    if ((arabskoe1 != 0) && (arabskoe2 != 0)) {
                        result1 = Calculating(arabskoe1, arabskoe2, s2_array);
                        System.out.println(massivRimskihCifr[(int) result1 - 1]);
                    } else {
                        throw new NumberFormatException();
                    }

                } catch (ArrayIndexOutOfBoundsException a) {
                    System.out.println("Некорректный ввод данных, между числами и математическим символом должен быть пробел,  либо результат операции является отрицательным или дробным числом");
                }
                catch (NumberFormatException p) {
                    System.out.println("Операция возможна, только если введены два арабских либо два римских числа");
                }
            } catch (ArrayIndexOutOfBoundsException q) {
                System.out.println("Некорректный ввод данных, между числами и математическим символом должен быть пробел");
            }


        } catch (IllegalArgumentException g) {
            System.out.println("Это не арифметическая операция");
        }
        catch (ArrayIndexOutOfBoundsException w) {
            System.out.println("Между числами и математическим символом должен быть пробел");

        }

    }
}

