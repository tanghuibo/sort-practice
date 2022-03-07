package io.github.tanghuibo.sort;

import org.junit.Test;

/**
 * ChooseSort
 *
 * @author tanghuibo
 * @date 2022/3/7 10:50
 */
public class ChooseSort extends SortTestBase {
    @Override
    public void sort(int[] dataList) {
        for (int i = 0; i < dataList.length; i++) {
            int maxIndex = 0;
            for (int j = 1; j < dataList.length - i; j++) {
                if(dataList[j] > dataList[maxIndex]) {
                    maxIndex = j;
                }
            }
            if(maxIndex != dataList.length - i - 1) {
                swap(dataList, maxIndex, dataList.length - i - 1);
            }
        }
    }

    @Test
    public void test() {
        check();
    }
}
