package io.github.tanghuibo.sort;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;

/**
 * SortTestBase
 *
 * @author tanghuibo
 * @date 2022/3/7 10:15
 */
public abstract class SortTestBase {

    abstract public void sort(int[] dataList);


    protected void swap(int[] dataList, int indexA, int indexB) {
        int temp = dataList[indexA];
        dataList[indexA] = dataList[indexB];
        dataList[indexB] = temp;
    }

    public void check() {
        for (int i = 0; i < 100; i++) {
            check_();
        }
    }
    private void check_() {
        Random random = new Random();
        int dataListLength = random.nextInt(100) + 10;
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

    public String toResult(int[] dataList) {
        StringBuilder sb = new StringBuilder();
        for (Integer data : dataList) {
            sb.append(data);
            sb.append(",");
        }
        return sb.toString();
    }
}
