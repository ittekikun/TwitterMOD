package biz.itteki.twitter;
 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
 
public class CommandTweet_Pic extends CommandBase {
 
	@Override
	public String getCommandName() {
		return "twp";
	}
 
	@Override
	public void processCommand(ICommandSender var1, String[] var2) 
	{
		String consumerKey = TwitterCore.consumerKey;
		String consumerSecret = TwitterCore.consumerSecret;
		String accessToken = TwitterCore.accessToken;
		String accessTokenSecret = TwitterCore.accessTokenSecret;
		
		TwitterFactory factory = new TwitterFactory();
		Twitter twitter = factory.getInstance();
		twitter.setOAuthConsumer(consumerKey,consumerSecret);
		twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
		
		String tw = func_82361_a(var1, var2, 1, true);

		final StatusUpdate status = new StatusUpdate(tw+ "　#TwitterMOD");
		status.media(new File(Minecraft.getMinecraft().getMinecraftDir(), "screenshots\\" + var2[0]));
		
		
		

		var1.sendChatToPlayer("画像と次の内容をツイートします。画像サイズによっては時間がかかることもありますのでご注意ください。" + "「" + tw + "」");
		try {
			twitter.updateStatus(status);
		} catch (TwitterException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
			var1.sendChatToPlayer("画像と次の内容のツイートに失敗しました。" + "「" + tw + "」");
		}
		
	
	}
 
}