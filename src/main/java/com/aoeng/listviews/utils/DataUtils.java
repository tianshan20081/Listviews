package com.aoeng.listviews.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sczhang on 15/5/11.
 */
public class DataUtils {
    public static List<String> initDatas() {
        List<String> datas = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            datas.add("name" + i);
        }
        return datas;
    }
}
