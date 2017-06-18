package io.github.gingeraebi.study3;

import io.realm.RealmObject;

/**
 * Created by gingeraebi on 2017. 6. 18..
 */

public class Content extends RealmObject{
    public String title;
    public String contents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
