package com.fun.hearthstonekillcalculatorv20.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HZF on 2016/4/27.
 */
// 组合算法
// 本程序的思路是开一个数组，其下标表示1到m个数，数组元素的值为1表示其下标
// 代表的数被选中，为0则没选中。
// 首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。
// 然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为
// “01”组合，同时将其左边的所有“1”全部移动到数组的最左端。
// 当第一个“1”移动到数组的m-n的位置，即n个“1”全部移动到最右端时，就得
// 到了最后一个组合。
// 例如求5中选3的组合：
// 1 1 1 0 0   //1,2,3
// 1 1 0 1 0   //1,2,4
// 1 0 1 1 0   //1,3,4
// 0 1 1 1 0   //2,3,4
// 1 1 0 0 1   //1,2,5
// 1 0 1 0 1   //1,3,5
// 0 1 1 0 1   //2,3,5
// 1 0 0 1 1   //1,4,5
// 0 1 0 1 1   //2,4,5
// 0 0 1 1 1   //3,4,5
public class Combination {

    /**
     * 从n个数字中选择m个数字
     *
     * @param a
     * @param m
     * @return
     * @throws Exception
     */
    public static List combine(int[] a, int m) {
        int n = a.length;

        List result = new ArrayList();

        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            bs[i] = 0;
        }
        // 初始化
        for (int i = 0; i < m; i++) {
            bs[i] = 1;
        }
        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;
        // 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
        do {
            sum = 0;
            pos = 0;
            tempFlag = true;
            result.add(print(bs, a, m));

            for (int i = 0; i < n - 1; i++) {
                if (bs[i] == 1 && bs[i + 1] == 0) {
                    bs[i] = 0;
                    bs[i + 1] = 1;
                    pos = i;
                    break;
                }
            }
            // 将左边的1全部移动到数组的最左边

            for (int i = 0; i < pos; i++) {
                if (bs[i] == 1) {
                    sum++;
                }
            }
            for (int i = 0; i < pos; i++) {
                if (i < sum) {
                    bs[i] = 1;
                } else {
                    bs[i] = 0;
                }
            }

            // 检查是否所有的1都移动到了最右边
            for (int i = n - m; i < n; i++) {
                if (bs[i] == 0) {
                    tempFlag = false;
                    break;
                }
            }
            if (tempFlag == false) {
                flag = true;
            } else {
                flag = false;
            }

        } while (flag);
        result.add(print(bs, a, m));

        return result;
    }

    private static int[] print(int[] bs, int[] a, int m) {
        int[] result = new int[m];
        int pos = 0;
        for (int i = 0; i < bs.length; i++) {
            if (bs[i] == 1) {
                result[pos] = a[i];
                pos++;
            }
        }
        return result;
    }
}
