package io.github.tanghuibo.sort;

import org.junit.Test;

/**
 * HeadSort
 *
 * @author tanghuibo
 * @date 2022/3/7 16:41
 */
public class HeadSort extends SortTestBase {

    @Override
    public void sort(int[] dataList) {
        buildHeap(dataList);
        for (int i = 0; i < dataList.length; i++) {
            swap(dataList, dataList.length - 1 - i, 0);
            sortWithTop(dataList, 0, dataList.length - i - 1);
        }

    }

    private void buildHeap(int[] dataList) {
        int i = (dataList.length & 1) == 1 ? (dataList.length - 2) : dataList.length - 1;
        while (i > 0) {
            sortWithTop(dataList,  (i - 1) / 2, dataList.length);
            i = i - 2;
        }
    }

    private void sortWithTop(int[] dataList, int topIndex, int maxLength) {
        int leftIndex = topIndex * 2 + 1;
        if(leftIndex >= maxLength) {
            return;
        }
        int rightIndex = leftIndex + 1;
        int maxIndex = topIndex;
        if(dataList[leftIndex] > dataList[maxIndex]) {
            maxIndex = leftIndex;
        }
        if(rightIndex < maxLength && dataList[rightIndex] > dataList[maxIndex]) {
            maxIndex = rightIndex;
        }
        if(maxIndex == topIndex) {
            return;
        }

        swap(dataList, topIndex, maxIndex);

        if(maxIndex == leftIndex) {
            sortWithTop(dataList, leftIndex, maxLength);
        }

        if(maxIndex == rightIndex) {
            sortWithTop(dataList, rightIndex, maxLength);
        }

    }

    @Test
    public void test() {
        check();
    }

}
