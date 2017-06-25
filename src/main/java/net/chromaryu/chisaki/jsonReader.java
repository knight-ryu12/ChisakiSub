package net.chromaryu.chisaki;
import java.util.HashMap;
/**
 * Created by IfritSystem on 2017/06/24.
 */
public class jsonReader { //イルーナ「ここは見たまんまよ。」
    private HashMap<String,String> twitter,mysql,aes,apiai;

    public HashMap<String, String> getApiai() {
        return apiai;
    }

    public void setApiai(HashMap<String, String> apiai) {
        this.apiai = apiai;
    }

    public HashMap<String, String> getTwitter() {
        return twitter;
    }

    public HashMap<String, String> getMysql() {
        return mysql;
    }
    public HashMap<String,String> getAes(){return aes;}
    public void setTwitter(HashMap<String, String> twitter) {

        this.twitter = twitter;
    }

    public void setMysql(HashMap<String, String> mysql) {
        this.mysql = mysql;
    }
    public void setAes(HashMap<String,String> aes) {
        this.aes = aes;
    }
    @Override
    public String toString() {
        return "config{"+twitter.toString()+","+mysql.toString()+"}";
    }
}
