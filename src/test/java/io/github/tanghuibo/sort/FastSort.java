package io.github.tanghuibo.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * FastSort
 *
 * @author tanghuibo
 * @date 2022/3/7 11:01
 */
public class FastSort extends SortTestBase {

    @Override
    public void sort(int[] dataList) {
        if(dataList.length < 2) {
            return;
        }
        if(dataList.length == 2) {
            if(dataList[1] < dataList[0]) {
                swap(dataList, 0, 1);
            }
            return;
        }
        int head = dataList[0];
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();
        for (int i = 1; i < dataList.length; i++) {
            int data = dataList[i];
            if(data < head) {
                leftArray.add(data);
            } else {
                rightArray.add(data);
            }
        }

        int[] leftList = toList(leftArray);
        int[] rightList = toList(rightArray);
        sort(leftList);
        sort(rightList);
        for (int i = 0; i < dataList.length; i++) {
            if(i < leftList.length) {
                dataList[i] = leftList[i];
            } else if(i == leftList.length) {
                dataList[i] = head;
            } else {
                dataList[i] = rightList[i - leftList.length - 1];
            }
        }

    }

    private int[] toList(List<Integer> dataList) {
        int[] resultList = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            resultList[i] = dataList.get(i);
        }
        return resultList;
    }

    @Test
    public void test() {
        check();
    }
}
