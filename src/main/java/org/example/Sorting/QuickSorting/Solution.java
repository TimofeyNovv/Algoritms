package org.example.Sorting.QuickSorting;

/*
sort array
 */
public class Solution {
    int[] sortAr(int[] arr) {
        // Базовый случай: если массив пуст или содержит 1 элемент, он уже отсортирован
        if (arr.length < 2) {
            return arr;
        } else {
            int pivot = arr[0]; // Опорный элемент (можно выбрать лучше, но для простоты берём первый)

            // Подсчитываем количество элементов меньше и больше опорного
            int lessCount = 0;
            int greaterCount = 0;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] <= pivot) {
                    lessCount++;
                } else {
                    greaterCount++;
                }
            }

            // Создаём подмассивы нужного размера
            int[] less = new int[lessCount];
            int[] greater = new int[greaterCount];

            // Заполняем подмассивы
            int lessIndex = 0;
            int greaterIndex = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] <= pivot) {
                    less[lessIndex++] = arr[i];
                } else {
                    greater[greaterIndex++] = arr[i];
                }
            }

            // Рекурсивно сортируем подмассивы
            int[] sortedLess = sortAr(less);
            int[] sortedGreater = sortAr(greater);

            // Собираем результат: меньшие элементы + опорный + большие элементы
            int[] result = new int[arr.length];
            System.arraycopy(sortedLess, 0, result, 0, sortedLess.length);
            result[sortedLess.length] = pivot;
            System.arraycopy(sortedGreater, 0, result, sortedLess.length + 1, sortedGreater.length);

            return result;
        }
    }
}