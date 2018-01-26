package com.bonson.bfydapp.utils;

import android.text.TextUtils;
import android.view.View;

import com.bonson.bfydapp.model.bean.Heart;
import com.bonson.bfydapp.model.bean.Motion;
import com.bonson.bfydapp.model.bean.Sleep;
import com.bonson.bfydapp.view.index.Table;

public class TablesUtils {
    public static Table motion(Motion motion) {
        Table table = new Table();
        table.cell0_0.setValue1("全程里程");
        table.cell0_0.setValue2(motion.getFconsume() + "公里");
        table.cell0_0.setValue3(null);

        table.cell0_1.setValue1("全天步数");
        table.cell0_1.setValue2(motion.getFstepsNumber() + "步");
        table.cell0_1.setValue3(null);

        table.cell0_2.setValue1("全程消耗");
        table.cell0_2.setValue2(motion.getFdistance() + "千卡");
        table.cell0_2.setValue3(null);


        table.cell1_0.setValue1("行走里程");
        table.cell1_0.setValue2(motion.getFwalkingConsume() + "公里");
        table.cell1_0.setValue3(null);

        table.cell1_1.setValue1("行走时长");
        table.cell1_1.setValue2(motion.getFwalkingTimeLong() + "分");
        table.cell1_1.setValue3(null);

        table.cell1_2.setValue1("行走消耗");
        table.cell1_2.setValue2(motion.getFwalkingDistance() + "千卡");
        table.cell1_2.setValue3(null);


        table.cell2_0.setValue1("跑步里程");
        table.cell2_0.setValue2(motion.getFrunConsume() + "公里");
        table.cell2_0.setValue3(null);

        table.cell2_1.setValue1("跑步时长");
        table.cell2_1.setValue2(motion.getFrunTimeLong() + "分");
        table.cell2_1.setValue3(null);

        table.cell2_2.setValue1("跑步消耗");
        table.cell2_2.setValue2(motion.getFrunDistance() + "千卡");
        table.cell2_2.setValue3(null);
        return table;
    }

    private static String[] heart = {"--", "--", "--"};

    public static String[] parseHeart(String result) {
        if (TextUtils.isEmpty(result)) {
            return heart;
        }
        return heart;
    }

    public static Table sleep(Sleep sleep) {
        Table table = new Table();

        table.cell0_0.setValue1("睡眠时长");
        table.cell0_0.setValue2(sleep.getFyestreenSL());
        table.cell0_0.setValue3(null);

        table.cell0_1.setValue1("深睡时长");
        table.cell0_1.setValue2(sleep.getFdeepSleepLength());
        table.cell0_1.setValue3(null);

        table.cell0_2.setValue1("浅睡时长");
        table.cell0_2.setValue2(sleep.getFshallowSleepLength());
        table.cell0_2.setValue3(null);


        table.cell1_0.setValue1("入睡时间");
        table.cell1_0.setValue2(sleep.getFsleepTime());
        table.cell1_0.setValue3(null);

        table.cell1_1.setValue1("醒来时间");
        table.cell1_1.setValue2(sleep.getFwakeTime());
        table.cell1_1.setValue3(null);

        table.cell1_2.setValue1("清醒时长");
        table.cell1_2.setValue2(sleep.getFwakeLength());
        table.cell1_2.setValue3(null);

        table.cell2_0.setVisible(View.GONE);
        table.cell2_1.setVisible(View.GONE);
        table.cell2_2.setVisible(View.GONE);
        return table;
    }

    public static Table heart(Heart heart) {
        Table table = new Table();

        String[] value = parseHeart(heart.getFtestResult1());
        table.cell0_0.setValue1(value[0]);
        table.cell0_0.setValue2(value[1]);
        table.cell0_0.setValue3(value[2]);
        value = parseHeart(heart.getFtestResult2());
        table.cell0_1.setValue1(value[0]);
        table.cell0_1.setValue2(value[1]);
        table.cell0_1.setValue3(value[2]);
        value = parseHeart(heart.getFtestResult3());
        table.cell0_2.setValue1(value[0]);
        table.cell0_2.setValue2(value[1]);
        table.cell0_2.setValue3(value[2]);

        value = parseHeart(heart.getFtestResult4());
        table.cell1_0.setValue1(value[0]);
        table.cell1_0.setValue2(value[1]);
        table.cell0_0.setValue3(value[2]);
        value = parseHeart(heart.getFtestResult5());
        table.cell1_1.setValue1(value[0]);
        table.cell1_1.setValue2(value[1]);
        table.cell1_1.setValue3(value[2]);
        value = parseHeart(heart.getFtestResult6());
        table.cell1_2.setValue1(value[0]);
        table.cell1_2.setValue2(value[1]);
        table.cell1_2.setValue3(value[2]);


        table.cell2_0.setVisible(View.GONE);
        table.cell2_1.setVisible(View.GONE);
        table.cell2_2.setVisible(View.GONE);
        return table;
    }
}
