package io.github.gingeraebi.study3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class WriteContentActivity extends AppCompatActivity {
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Realm.init(this);

        realm = Realm.getDefaultInstance();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEdit = (EditText)findViewById(R.id.titleEdit);
                EditText contentsEdit = (EditText)findViewById(R.id.contentsEdit);

                realm.beginTransaction();

                Content content = realm.createObject(Content.class);
                content.setTitle(titleEdit.getText().toString());
                content.setContents(contentsEdit.getText().toString());

                realm.commitTransaction();

                finish();
            }
        });
    }
}
