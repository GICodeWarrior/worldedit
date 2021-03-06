package com.sk89q.worldedit.bukkit;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.LocalPlayer;
import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.PlayerNeededException;
import com.sk89q.worldedit.ServerInterface;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldVector;
import com.sk89q.worldedit.bags.BlockBag;

public class BukkitCommandSender extends LocalPlayer {
    private CommandSender sender;
    private WorldEditPlugin plugin;

    public BukkitCommandSender(WorldEditPlugin plugin, ServerInterface server, CommandSender sender) {
        super(server);
        this.plugin = plugin;
        this.sender = sender;
    }

    @Override
    public String getName() {
        return sender.getName();
    }

    @Override
    public void printRaw(String msg) {
        for (String part : msg.split("\n")) {
            sender.sendMessage(part);
        }
    }

    @Override
    public void print(String msg) {
        for (String part : msg.split("\n")) {
            sender.sendMessage("\u00A7d" + part);
        }
    }

    @Override
    public void printDebug(String msg) {
        for (String part : msg.split("\n")) {
            sender.sendMessage("\u00A77" + part);
        }
    }

    @Override
    public void printError(String msg) {
        for (String part : msg.split("\n")) {
            sender.sendMessage("\u00A7c" + part);
        }
    }

    @Override
    public String[] getGroups() {
        return new String[0];
    }

    @Override
    public boolean hasPermission(String perm) {
        if (!plugin.getLocalConfiguration().noOpPermissions && sender.isOp()) {
            return true;
        }

        return plugin.getPermissionsResolver().hasPermission(null, sender.getName(), perm);
    }

    @Override
    public boolean isPlayer() {
        return sender instanceof Player;
    }

    @Override
    public int getItemInHand() {
        throw new PlayerNeededException();
    }

    @Override
    public WorldVector getPosition() {
        throw new PlayerNeededException();
    }

    @Override
    public LocalWorld getWorld() {
        throw new PlayerNeededException();
    }

    @Override
    public double getPitch() {
        throw new PlayerNeededException();
    }

    @Override
    public double getYaw() {
        throw new PlayerNeededException();
    }

    @Override
    public void giveItem(int type, int amt) {
        throw new PlayerNeededException();
    }

    @Override
    public void setPosition(Vector pos, float pitch, float yaw) {
        throw new PlayerNeededException();
    }

    @Override
    public BlockBag getInventoryBlockBag() {
        throw new PlayerNeededException();
    }
}
