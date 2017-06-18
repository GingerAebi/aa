package io.github.gingeraebi.study3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView2 = (TextView) findViewById(R.id.textView2);

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WriteContentActivity.class);
                startActivity(intent);
            }
        });

        Realm realm = Realm.getDefaultInstance();

        RealmQuery<Content> realmQuery = realm.where(Content.class);

        RealmResults<Content> realmResults = realmQuery.findAll();

        if(realmResults.size() > 0) {
            Content content = (Content) realmResults.get(0);

            textView.setText(content.getTitle());
            textView2.setText(content.getContents());
        }

    }



}
