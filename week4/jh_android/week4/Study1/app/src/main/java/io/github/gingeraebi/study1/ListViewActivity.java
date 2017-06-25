package io.github.gingeraebi.study1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView = (ListView) findViewById(R.id.listview);

        ArrayList<CryptoCurrencyInfo> ccInfos = new ArrayList<>();
        ccInfos.add(new CryptoCurrencyInfo("BitCoin", "BTC", "100000", "3%", "10B", "10M"));
        ccInfos.add(new CryptoCurrencyInfo("Etherium", "ETC", "130000", "13%", "1B", "9M"));
        ccInfos.add(new CryptoCurrencyInfo("Ripple", "XPL", "340000", "3.4%", "5B", "6M"));
        ccInfos.add(new CryptoCurrencyInfo("NEM", "XEM", "90000", "-5%", "13B", "119M"));

        CCAdapter ccAdapter = new CCAdapter(this, ccInfos);
        listView.setAdapter(ccAdapter);

    }
}
