package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if(inputArray == null) {
            return new int[]{};
        }
        for(int i = inputArray.length - 1; i > 0; i--) {
            int tmp = inputArray[i];
            inputArray[i] = inputArray[i - 1];
            inputArray[i - 1] = tmp;
        }
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if(inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if(inputArray.length == 1) {
            return inputArray[0];
        }
        int max1 = 0;
        int max2 = 0;
        int min1 = 0;
        int min2 = 0;

        for(int x : inputArray) {
            if(x > max1) {
                max2 = max1;
                max1 = x;
            }
            else if(x > max2) {
                max2 = x;
            }

            if(x < min1) {
                min2 = min1;
                min1 = x;
            }
            else if(x < min2) {
                min2 = x;
            }
        }

        return Math.max(max1 * max2, min1 * min2);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if(input == null || input.length() == 0) {
            return 0;
        }
        int cnt = 0;
        for(char c : input.toUpperCase().toCharArray()) {
            if(c == 'A' || c == 'B') {
                cnt++;
            }
        }

        return cnt * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if(input == null) {
            return false;
        }
        for(int l = 0, r = input.length() - 1; l < r; l++, r--) {
            if(input.charAt(l) != input.charAt(r)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if(input == null || input.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int cnt = 1;
        for(int i = 1; i < input.length(); i++) {
            if(input.charAt(i) != input.charAt(i - 1)) {
                result.append(input.charAt(i - 1));
                result.append(cnt);
                cnt = 0;
            }
            cnt++;
        }
        result.append(input.charAt(input.length() - 1));
        result.append(cnt);
        return result.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if(one == null || two == null || one.length() == 0 || two.length() == 0 || one.length() != two.length()) {
            return false;
        }
        int[] cnt = new int[256];
        for(int i = 0; i < 256; i++) {
            cnt[i] = 0;
        }

        for(char c : one.toCharArray()) {
            cnt[c]++;
        }
        for(char c : two.toCharArray()) {
            cnt[c]--;
        }

        for(int i = 0; i < 256; i++) {
            if(cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        int[] cnt = new int[256];
        for(int i = 0; i < 256; i++) {
            cnt[i] = 0;
        }

        for(char c : s.toCharArray()) {
            cnt[c]++;
        }

        for(int i = 0; i < 256; i++) {
            if(cnt[i] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null || m.length == 0) {
            return new int[][]{{}, {}};
        }
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < i && j < m[i].length; j++) {
                int tmp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = tmp;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if(inputStrings == null) {
            return "";
        }
        if(separator == null) {
            separator = ' ';
        }
        StringBuilder result = new StringBuilder();
        for(String s : inputStrings) {
            result.append(s);
            result.append(separator);
        }
        if(result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if(inputStrings == null || prefix == null) {
            return 0;
        }
        int result = 0;

        for(String s : inputStrings) {
            boolean match = true;
            for(int i = 0; i < prefix.length(); i++) {
                if(s.charAt(i) != prefix.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if(match) {
                result++;
            }
        }

        return result;
    }
}
