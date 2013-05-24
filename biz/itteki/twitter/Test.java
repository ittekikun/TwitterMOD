package biz.itteki.twitter;
 
import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.media.ImageUpload;
import twitter4j.media.ImageUploadFactory;
import twitter4j.media.MediaProvider;
 
public class Test extends CommandBase {
	
	
 
	@Override
	public String getCommandName() {
		return "test";
	}
	
	
 
	@Override
	public void processCommand(ICommandSender var1, String[] var2) 
	{
		if (var2.length < 1)
        {
			var1.sendChatToPlayer("&cコマンドの使い方が間違っています。");
        }
        else
        {
        	String consumerKey = TwitterCore.consumerKey;
        	String consumerSecret = TwitterCore.consumerSecret;
        	String accessToken = TwitterCore.accessToken;
        	String accessTokenSecret = TwitterCore.accessTokenSecret;
		
        	TwitterFactory factory = new TwitterFactory();
        	Twitter twitter = factory.getInstance();
        	twitter.setOAuthConsumer(consumerKey,consumerSecret);
        	twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
		
        	if ("t".equalsIgnoreCase(var2[0]))
        	{
        		String tw = func_82361_a(var1, var2, 1, true);

        		try {
        			var1.sendChatToPlayer("次の内容をツイートします。" + "「" + tw + "」");
        			twitter.updateStatus(tw + "　#TwitterMOD");
        		} catch (TwitterException e) {
        			// TODO 自動生成された catch ブロック
        			e.printStackTrace();
        			var1.sendChatToPlayer("次の内容のツイートに失敗しました。" + "「" + tw + "」");
        		}
        		finally {
				//var1.sendChatToPlayer("次の内容をツイートしました。" + "「" + var2[0] + "」");
				}
        	}
        	else if ("p".equalsIgnoreCase(var2[0]))
        	{
        		var1.sendChatToPlayer("テストB");
        		String tw = func_82361_a(var1, var2, 2, true);
        		
        		final StatusUpdate status = new StatusUpdate(tw+ "　#TwitterMOD");
        		status.media(new File(Minecraft.getMinecraft().getMinecraftDir(), "screenshots\\" + var2[1]));

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
	}
}