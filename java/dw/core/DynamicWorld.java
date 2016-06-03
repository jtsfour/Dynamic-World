package dw.core;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = DynamicWorld.MODID, version = DynamicWorld.VERSION)
public class DynamicWorld
{
    public static final String MODID = "dynamicworld";
    public static final String VERSION = "1.0";
    private static boolean client = false;
    
    @SidedProxy(clientSide = "dw.core.ClientProxy",serverSide = "dw.core.CommonProxy")
    public static CommonProxy proxy;
    
    @Mod.Instance("DynamicWorld")
    public static DynamicWorld instance;
    
    
    
   
   public static boolean isServerSide(){
	   return !client;
   }
   
   public static boolean isClientSide(){
	   return client;
   }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
    	if(event.getSide()==Side.CLIENT)client=true;
    	proxy.preInit();
        
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
    	proxy.postInit();
        
    }
}
