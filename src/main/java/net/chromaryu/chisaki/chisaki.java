package net.chromaryu.chisaki;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.chromaryu.chisaki.thread.clockNotifier;
import net.chromaryu.chisaki.thread.messageSender;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

/**
 * Created by IfritSystem on 2017/06/24.
 */

// くろま「よっ！、ここのソースの解説をするぜ！」
public class chisaki {
    public static Twitter twitter; // くろま「public static宣言にすることでクラスをまたいで使えるようになるぜ。staticをつけないと、いちいち橋渡しのメゾットを書かなければ行けない。」
    public static final messageSender ms = new messageSender();
    public static void main(String[] args) throws IOException {
        ms.start();
        ObjectMapper om = new ObjectMapper(); // くろま「Jsonを読むための準備みたいなもん。詳細はjsonReader.classを見てくれ。」
        jsonReader jr = om.readValue(new File("config.json"),jsonReader.class);
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setAsyncNumThreads(2)
                .setOAuthAccessToken(jr.getTwitter().get("accessToken")) //くろま「アクセストークンとかをここでセットすると、あとでTwitterFactoryに渡せるから便利だぜ」
                .setDebugEnabled(true)
                .setOAuthConsumerKey(jr.getTwitter().get("consumerKey"))
                .setOAuthAccessTokenSecret(jr.getTwitter().get("accessSecret"))
                .setOAuthConsumerSecret(jr.getTwitter().get("consumerSecret")).setGZIPEnabled(true);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance(); //くろま「これでTwitterクラスが宣言できたぜ。」
        Timer t = new Timer(true);

        t.scheduleAtFixedRate(new clockNotifier(),0,1000);
    }
}
