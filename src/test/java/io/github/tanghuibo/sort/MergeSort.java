package io.github.tanghuibo.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * MergeSort
 *
 * @author tanghuibo
 * @date 2022/3/7 11:15
 */
public class MergeSort extends SortTestBase {
    @Override
    public void sort(int[] dataList) {
        if(dataList.length < 2) {
            return;
        }
        if(dataList.length == 2) {
            if(dataList[1] < dataList[0]) {
                int temp = dataList[1];
                dataList[1] = dataList[0];
                dataList[0] = temp;
            }
            return;
        }
        int splitIndex = dataList.length / 2;
        int[] leftList = Arrays.copyOfRange(dataList, 0, splitIndex);
        int[] rightList = Arrays.copyOfRange(dataList, splitIndex, dataList.length);
        sort(leftList);
        sort(rightList);
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < dataList.length; i++) {
            if(leftIndex >= leftList.length) {
                dataList[i] = rightList[rightIndex];
                rightIndex++;
                continue;
            }

            if(rightIndex >= rightList.length) {
                dataList[i] = leftList[leftIndex];
                leftIndex++;
                continue;
            }

            if(leftList[leftIndex] < rightList[rightIndex]) {
                dataList[i] = leftList[leftIndex];
                leftIndex++;
                continue;
            }

            dataList[i] = rightList[rightIndex];
            rightIndex++;
        }
    }

    @Test
    public void test() {
        check();
    }
}
