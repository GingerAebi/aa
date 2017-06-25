package io.github.gingeraebi.study1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by gingeraebi on 2017. 5. 28..
 */

public class CCAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<CryptoCurrencyInfo> ccInfos;

    public CCAdapter(Context context, ArrayList<CryptoCurrencyInfo> ccInfos) {
        this.context = context;
        this.ccInfos = ccInfos;
    }

    @Override
    public int getCount() {
        return ccInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return ccInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null) {
            LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
            row = layoutInflater.inflate(R.layout.row_cryptocurrency, parent, false);
        }

        TextView coinNameText = (TextView) row.findViewById(R.id.coinNameText);
        TextView priceText = (TextView) row.findViewById(R.id.priceText);
        TextView capText = (TextView) row.findViewById(R.id.capText);
        TextView volumeText = (TextView) row.findViewById(R.id.volumeText);

        CryptoCurrencyInfo ccInfo = ccInfos.get(position);

        double amount = Double.parseDouble(ccInfo.price);
        DecimalFormat formatter = new DecimalFormat("$#,###");


        String prettyPrice = formatter.format(amount);

        coinNameText.setText(ccInfo.ccName + "\n (" + ccInfo.ccNickName + ")");
        priceText.setText(prettyPrice + "\n " + ccInfo.rate);
        capText.setText(ccInfo.cap);
        volumeText.setText(ccInfo.volume);

        return row;
    }
}
