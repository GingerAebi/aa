package io.github.gingeraebi.study1;

/**
 * Created by gingeraebi on 2017. 5. 28..
 */

public class CryptoCurrencyInfo {
    public String logoImgUrl;
    public String ccName;
    public String ccNickName;
    public String price;
    public String rate;
    public String cap;
    public String volume;

    public CryptoCurrencyInfo(String logoImgUrl, String ccName, String ccNickName, String price, String rate, String cap, String volume) {
        this.logoImgUrl = logoImgUrl;
        this.ccName = ccName;
        this.ccNickName = ccNickName;
        this.price = price;
        this.rate = rate;
        this.cap = cap;
        this.volume = volume;
    }

    public CryptoCurrencyInfo(String ccName, String ccNickName, String price, String rate, String cap, String volume) {
        this.ccName = ccName;
        this.ccNickName = ccNickName;
        this.price = price;
        this.rate = rate;
        this.cap = cap;
        this.volume = volume;
    }
}
