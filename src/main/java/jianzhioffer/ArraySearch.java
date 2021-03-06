package jianzhioffer;

/**
 * 二维数组中的查找
 * create y frank
 * on 2018/04/28
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class ArraySearch {
    /**
     * 二分查找法
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        try {
            //数组行数
            int row = array.length;
            //数组列数
            int column = array[0].length;
            for (int i = 0; i < row; i++) {
                if (array[i][0] <= target && array[i][column - 1] >= target) {
                    int start = 0;
                    int end = column - 1;
                    while (start <= end) {
                        int mid = (start + end) / 2;
                        if (array[i][mid] > target)
                            end = mid - 1;
                        if (array[i][mid] < target)
                            start = mid + 1;
                        if (array[i][mid] == target)
                            return true;
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 最优算法
     * 左下角查找发，大于往右查找，小于往上查找
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find2(int target, int[][] array) {
        //数组行数
        int row = array.length;
        //数组列数
        int column = array[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < column) {
            if (array[i][j] == target)
                return true;
            if (array[i][j] > target) {
                i--;
                continue;
            }
            if (array[i][j] < target) {
                j++;
                continue;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        ArraySearch arraySearch = new ArraySearch();
        System.out.println(arraySearch.Find2(8, a));
    }
}
