package io.github.tanghuibo.sort;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * SortTestBase
 *
 * @author tanghuibo
 * @date 2022/3/7 10:15
 */
public abstract class SortTestBase {

    abstract public void sort(int[] dataList);


    public void check() {
        for (int i = 0; i < 100; i++) {
            check_();
        }
    }
    private void check_() {
        Random random = new Random();
        int dataListLength = 100;
        int[] dataList1 = new int[dataListLength];
        int[] dataList2 = new int[dataListLength];
        for (int i = 0; i < dataListLength; i++) {
            int data = random.nextInt(dataListLength);
            dataList1[i] = data;
            dataList2[i] = data;
        }

        sort(dataList1);
        Arrays.sort(dataList2);

        Assert.assertArrayEquals(dataList1, dataList2);

    }

    private String toResult(List<Integer> dataList) {
        StringBuilder sb = new StringBuilder();
        for (Integer data : dataList) {
            sb.append(data);
            sb.append(",");
        }
        return sb.toString();
    }
}
