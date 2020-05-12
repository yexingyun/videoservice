package com.imooc.utils;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class TextUtils {
    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

    /**
     * {@hide}
     */
    public static String nullIfEmpty(@Nullable String str) {
        return isEmpty(str) ? null : str;
    }

    /**
     * {@hide}
     */
    public static String emptyIfNull(@Nullable String str) {
        return str == null ? "" : str;
    }


    /**
     * {@hide}
     */
    public static int length(@Nullable String s) {
        return isEmpty(s) ? 0 : s.length();
    }

}
