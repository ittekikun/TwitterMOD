package biz.itteki.twitter;
 
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
 
public class CommandTweet extends CommandBase {
 
	@Override
	public String getCommandName() {
		return "tw";
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
		
		String tw = func_82361_a(var1, var2, 0, true);

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
 
}