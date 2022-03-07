package io.github.tanghuibo.sort;

import org.junit.Test;

/**
 * BubblingSort
 *
 * @author tanghuibo
 * @date 2022/3/7 10:35
 */
public class BubblingSort extends SortTestBase{
    @Override
    public void sort(int[] dataList) {
        for (int i = 0; i < dataList.length; i++) {
            for (int j = 1; j < dataList.length - i; j++) {
                if(dataList[j] < dataList[j - 1]) {
                    swap(dataList, j, j - 1);
                }
            }
        }
    }

    @Test
    public void test() {
        check();
    }
}
