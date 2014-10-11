package vg.civcraft.mc.command.commands;

import java.util.List;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import vg.civcraft.mc.NameAPI;
import vg.civcraft.mc.command.PlayerCommand;

public class ListGroups extends PlayerCommand {

	public ListGroups(String name) {
		super(name);
		setDescription("This command is used to list groups.");
		setUsage("/groupslist <page>");
		setIdentifier("groupslist");
		setArguments(1,1);
	}

	@Override
	public boolean execute(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)){
			sender.sendMessage("Nope.");
			return true;
		}
		Player p = (Player) sender;
		UUID uuid = NameAPI.getUUID(p.getName());
		List<String> groups = gm.getAllGroupNames(uuid);
		
		int pages = groups.size() / 10;
		String names = ChatColor.GREEN + "";
		int start = 0;
		try {
			start = Integer.parseInt(args[1]);
		} catch(NumberFormatException e){
			p.sendMessage(ChatColor.RED + "The page must be an integer.");
			return true;
		}
		names += "Page " + start + " of " + pages + ".\n"
				+ "Groups are as follows: \n";
		for (int x = (start-1) * 10, z = 1; x < groups.size() && z <= 10; x++, z++){
			names += groups.get(x) + "\n";
		}
		p.sendMessage(names);
		return true;
	}

}
