package com.drugstore.utils;

/**
 * @author 卢明德
 * @className STRisINT
 * @create 2022/12/8-19:19
 * @description 判断字符串是否是数字
 */
public class STRisINT {
    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {

            try {
                Double.parseDouble(str);
                return true;

            } catch (NumberFormatException ex) {

                try {
                    Float.parseFloat(str);
                    return true;
                } catch (NumberFormatException exx) {
                    return false;
                }
            }
        }
    }
}
