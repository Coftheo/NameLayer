package vg.civcraft.mc.namelayer;

import java.util.UUID;

import vg.civcraft.mc.namelayer.config.NameConfigManager;
import vg.civcraft.mc.namelayer.database.AssociationList;

public class NameAPI {
	private static GroupManager groupManager;
	private static AssociationList associations;
	private static NameConfigManager configManager;
	
	public NameAPI(GroupManager man, AssociationList ass, NameConfigManager config){
		groupManager = man;
		associations =  ass;
		configManager = config;
	}
	/**
	 * Returns the UUID of the player on the given server.
	 * @param playerName The playername.
	 * @return Returns the UUID of the player.
	 */
	public static UUID getUUID(String playerName) {
		return associations.getUUID(playerName);
	}
	/**
	 * Gets the playername from a given server from their uuid.
	 * @param uuid.
	 * @return Returns the PlayerName from the UUID.
	 */
	public static String getCurrentName(UUID uuid) {
		return associations.getCurrentName(uuid);
	}
	/**
	 * @return Returns an instance of the GroupManager.
	 */
	public static GroupManager getGroupManager(){
		return groupManager;
	}
	/**
	 * @return Returns an instance of the AssociationList.
	 */
	public static AssociationList getAssociationList(){
		return associations;
	}
	/**
	 * @return Returns the NameConfigManager to allow other plugins to use annotations for their config options.
	 */
	public static NameConfigManager getNameConfigManager(){
		return configManager;
	}
}
