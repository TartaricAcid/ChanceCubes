package chanceCubes.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import chanceCubes.CCubesCore;
import chanceCubes.client.gui.CCubesGuiHandler;

public class ItemCreativePendant extends Item
{
	public String itemNameID = "creative_Pendant";
	
	public ItemCreativePendant()
	{
		this.setUnlocalizedName(CCubesCore.MODID + "_" + itemNameID);
		this.setMaxStackSize(1);
		this.setCreativeTab(CCubesCore.modTab);
		this.setRegistryName(CCubesCore.MODID, this.itemNameID);
	}
	
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
		player.setActiveHand(hand);
        FMLNetworkHandler.openGui(player, CCubesCore.instance, CCubesGuiHandler.CREATIVE_PENDANT_ID, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
    }

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add("Right click to change the chance");
		list.add("of the inserted cubes.");
	}
}