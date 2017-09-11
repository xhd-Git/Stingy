package cf.reol.stingy.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.adapter.WheelAdapter;
import com.bigkoo.pickerview.listener.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cf.reol.stingy.R;
import cf.reol.stingy.widget.lib.WheelView;

/**
 * Created by reol on 2017/9/6.
 */

public class DTimePicker extends PopupWindow {
    private long mTime;
    private int mStep;

    private TextView btnCancel;
    private TextView tvTitle;
    private TextView btnConfirm;

    private WheelView dateWheel;
    private WheelView apmWheel;
    private WheelView hourWheel;
    private WheelView minuteWheel;

    private int mDateIndex = 0;
    private int mHourIndex = 0;
    private int mMinuteIndex = 0;

    private OnConfirmListener listener;

    public DTimePicker(Context context, long time, int step) {
        super(context);
        mStep = step;
        mTime = time;

        View view = View.inflate(context, R.layout.dpw_time_picker, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        view.setLayoutParams(params);
        setContentView(view);

        findView(view);
        initSelf(); // popup window 设置
        initView();
        setupData(context);
    }

    private void setupData(final Context context) {
        final Calendar c = Calendar.getInstance();
        c.setTimeInMillis(mTime);

        if (c.get(Calendar.MINUTE) > (60-mStep)){
            int d = (60 - c.get(Calendar.MINUTE))*60*1000;
            mTime = mTime + d;
            c.setTimeInMillis(mTime);
        }
        final int i = c.get(Calendar.MINUTE)%mStep == 0? (c.get(Calendar.MINUTE) / mStep): (c.get(Calendar.MINUTE) / mStep + 1);

        final int year = c.get(Calendar.YEAR);
        tvTitle.setText(String.valueOf(year));

        //=====日期数据装填=======
        final List<String> dayList = new ArrayList<>(365 * 5);
        StringBuilder builder = new StringBuilder();

        for (int y = year; y < year + 5; y++) {
            for (int month = 1; month < 13; month++) {
                int days = 31;
                switch (month) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        days = 31;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        days = 30;
                        break;
                    case 2:
                        if (y % 4 == 0 && y % 100 != 0) {
                            days = 29;
                        } else {
                            days = 28;
                        }
                        break;
                }
                for (int day = 1; day < days + 1; day++) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(y, month - 1, day, 0, 0, 0);
                    builder.delete(0, builder.length());
                    builder.append(month).append("月").append(day).append("日 ").append("星期");
                    switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                        case Calendar.MONDAY:
                            builder.append("一");
                            break;
                        case Calendar.TUESDAY:
                            builder.append("二");
                            break;
                        case Calendar.WEDNESDAY:
                            builder.append("三");
                            break;
                        case Calendar.THURSDAY:
                            builder.append("四");
                            break;
                        case Calendar.FRIDAY:
                            builder.append("五");
                            break;
                        case Calendar.SATURDAY:
                            builder.append("六");
                            break;
                        case Calendar.SUNDAY:
                            builder.append("日");
                            break;
                    }
                    dayList.add(builder.toString());
                }
            }
        }

        dateWheel.setAdapter(new WheelAdapter<String>() {
            @Override
            public int getItemsCount() {
                return dayList.size();
            }

            @Override
            public String getItem(int index) {
                return dayList.get(index);
            }

            @Override
            public int indexOf(String o) {
                return dayList.indexOf(o);
            }
        });
        dateWheel.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
//                tvTitle.setText(String.valueOf(year + index/365));
                Calendar e = Calendar.getInstance();
                e.set(2017,0,1,0,0,0);
                long ce = e.getTimeInMillis() + index*24L*3600L*1000L;
                e.setTimeInMillis(ce);
                tvTitle.setText(String.valueOf(e.get(Calendar.YEAR)));
                Log.d("asdfg", "DTimePicker: onItemSelected--------------->" + index + " / "+ ce);
                Log.d("asdfg","===============>(DTimePicker.java:168)");


                //// FIXME: 2017/9/6 闰年问题
                if (index < c.get(Calendar.DAY_OF_YEAR) - 1){
//                    dateWheel.setCurrentItem(c.get(Calendar.DAY_OF_YEAR) - 1);
                    dateWheel.smoothScroll(c.get(Calendar.DAY_OF_YEAR) - 1 - index);
                }
                if (index == c.get(Calendar.DAY_OF_YEAR) - 1){
                    hourWheel.setCurrentItem(c.get(Calendar.HOUR_OF_DAY));
                    minuteWheel.setCurrentItem(i);
                }
                mDateIndex = index;
            }
        });
        dateWheel.setCurrentItem(c.get(Calendar.DAY_OF_YEAR) - 1);

        final List<String> hourList = new ArrayList<>(24);
        for (int hour = 0; hour < 24; hour++){
            hourList.add(String.valueOf(hour));
        }
        hourWheel.setAdapter(new WheelAdapter<String>() {
            @Override
            public int getItemsCount() {
                return hourList.size();
            }

            @Override
            public String getItem(int index) {
                return hourList.get(index);
            }

            @Override
            public int indexOf(String o) {
                return hourList.indexOf(o);
            }
        });
        hourWheel.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
//                mHourIndex = Integer.getInteger(hourList.get(index));
                if (mDateIndex == c.get(Calendar.DAY_OF_YEAR) - 1){
                    if (index < c.get(Calendar.HOUR_OF_DAY)){
                        hourWheel.smoothScroll(c.get(Calendar.HOUR_OF_DAY) - index);
                    }
                }
                mHourIndex = index;
            }
        });
        hourWheel.setCurrentItem(c.get(Calendar.HOUR_OF_DAY));

        final List<String> minuteList = new ArrayList<>();
        for (int min = 0; min < 60; min += mStep){
            minuteList.add(String.valueOf(min));
        }

        minuteWheel.setAdapter(new WheelAdapter<String>() {
            @Override
            public int getItemsCount() {
                return minuteList.size();
            }

            @Override
            public String getItem(int index) {
                return minuteList.get(index);
            }

            @Override
            public int indexOf(String o) {
                return minuteList.indexOf(o);
            }
        });
        minuteWheel.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
//                mMinuteIndex = Integer.getInteger(minuteList.get(index));
                if (mDateIndex == c.get(Calendar.DAY_OF_YEAR) - 1){
                    if (index < c.get(Calendar.MINUTE)/mStep + 1){
                        minuteWheel.smoothScroll(i - index);
                    }
                }
                mMinuteIndex = index * mStep;
            }
        });

        minuteWheel.setCurrentItem(i);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar result = Calendar.getInstance();
                result.set(year,0,1,0,0,0);

                long dayMillis = mDateIndex * 24 * 3600;
                int hourMillis = mHourIndex * 3600 ;
                int minMillis = mMinuteIndex * 60;
                long resultMillis = result.getTimeInMillis() + (dayMillis + hourMillis + minMillis) * 1000;
                result.setTimeInMillis(resultMillis);

                listener.confirmed(resultMillis);

                DTimePicker.this.dismiss();
            }
        });
    }

    private void initView() {
        dateWheel.setCyclic(false);
        apmWheel.setCyclic(false);
        hourWheel.setCyclic(false);
        minuteWheel.setCyclic(false);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DTimePicker.this.dismiss();
            }
        });
    }

    private void initSelf() {
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setBackgroundDrawable(new ColorDrawable(Color.alpha(255)));
        this.setAnimationStyle(R.style.timepopwindow_anim_style);
    }

    private void findView(View view) {
        btnCancel = view.findViewById(R.id.dpw_timePicker_cancel);
        tvTitle = view.findViewById(R.id.dpw_timePicker_title);
        btnConfirm = view.findViewById(R.id.dpw_timePicker_confirm);

        dateWheel = view.findViewById(R.id.dpw_timePicker_date);
        apmWheel = view.findViewById(R.id.dpw_timePicker_apm);
        hourWheel = view.findViewById(R.id.dpw_timePicker_hour);
        minuteWheel = view.findViewById(R.id.dpw_timePicker_minute);
    }

    public void setOnConfirmListener(OnConfirmListener onConfirmListener){
        this.listener = onConfirmListener;
    }

    interface OnConfirmListener{
        void confirmed(long resultTimeStamp);
    }
}
