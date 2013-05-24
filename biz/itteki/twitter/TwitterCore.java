package biz.itteki.twitter;
 
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
 
@Mod(modid = "TwitterMOD", name="TwitterMOD", version="1.5.2_1.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TwitterCore {
 
	@Mod.Instance("TwitterCore")
	public static TwitterCore instance;
 
	@Mod.ServerStarting
	public void serverStarting(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandTweet());
		event.registerServerCommand(new CommandTweet_Pic());
		
		event.registerServerCommand(new Test());
	}
	
	public static String consumerKey;
	
	public static String consumerSecret;
	
	public static String accessToken;
	
	public static String accessTokenSecret;
	
	
	@Mod.PreInit
	 public void preInit(FMLPreInitializationEvent event)
	 {
		 Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		 try
		{
			
	     config.load();
	     consumerKey = config.get("Key", "consumerKey", "xxxxxxxxxx").getString();
	     consumerSecret = config.get("Key", "consumerSecret", "xxxxxxxxxx").getString();
	     accessToken = config.get("Key", "accessToken", "xxxxxxxxxx").getString();
	     accessTokenSecret = config.get("Key", "accessTokenSecret", "xxxxxxxxxx").getString();

		 
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "TwitterMODConfigError");
		}
		finally
		{
			config.save();
		}
		 
		 
	 }
	
	@Mod.Init
	 public void Init(FMLPreInitializationEvent event)
	 {
		
	 }
	 
 
}