package com.example.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MealAdapter extends ArrayAdapter<MealType> {

    private Context mContext;
    private List<MealType> mealTypeList = new ArrayList<>();

    public MealAdapter(@NonNull Context context, @SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<MealType> list) {
        super(context, 0, list);
        mContext = context;
        mealTypeList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.simple_list_item, parent, false);

        MealType currentMealType = mealTypeList.get(position);

        TextView name = (TextView) listItem.findViewById(R.id.menuItem);
        name.setText(currentMealType.getmealType());

        return listItem;
    }

}
