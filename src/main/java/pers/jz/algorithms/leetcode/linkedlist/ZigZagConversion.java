package pers.jz.algorithms.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jemmy Zhang on 2020/2/18.
 */
public class ZigZagConversion {
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 0) {
                return "";
            }
            if (numRows == 1) {
                return s;
            }
            int minRows = Math.min(s.length(), numRows);
            List<Character>[] rows = new List[minRows];
            for (int i = 0; i < minRows; i++) {
                rows[i] = new ArrayList<Character>();
            }
            char[] rawArray = s.toCharArray();
            boolean downFlag = true;
            int rowIndex = 0;
            for (int i = 0; i < rawArray.length; i++) {
                List<Character> currentList = rows[rowIndex];
                currentList.add(rawArray[i]);
                if (rowIndex == 0) {
                    downFlag = true;
                } else if (rowIndex == minRows - 1) {
                    downFlag = false;
                }
                if (downFlag) {
                    rowIndex++;
                } else {
                    rowIndex--;
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < minRows; i++) {
                List<Character> current = rows[i];
                for (int j = 0; j < current.size(); j++)
                    builder.append(current.get(j));
            }
            return builder.toString();
        }
    }

    class Solution1 {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            char[] data = s.toCharArray();
            int length = 2 * numRows - 2;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j + i < data.length; j += length) {
                    builder.append(data[j + i]);
                    if (i != 0 && i != numRows - 1 && i + j + length - i * 2 < data.length) {
                        builder.append(data[i + j + length - i * 2]);
                    }
                }
            }
            return builder.toString();
        }
    }
}
