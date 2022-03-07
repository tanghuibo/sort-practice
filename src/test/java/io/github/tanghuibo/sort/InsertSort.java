package io.github.tanghuibo.sort;

import org.junit.Test;

/**
 * InsertSort
 *
 * @author tanghuibo
 * @date 2022/3/7 10:56
 */
public class InsertSort extends SortTestBase {
    @Override
    public void sort(int[] dataList) {
        for (int i = 1; i < dataList.length; i++) {
            for (int j = i; j > 0; j--) {
                if(dataList[j] >= dataList[j - 1]) {
                    break;
                }
                swap(dataList, j, j - 1);
            }
        }
    }

    @Test
    public void test() {
        check();
    }
}
