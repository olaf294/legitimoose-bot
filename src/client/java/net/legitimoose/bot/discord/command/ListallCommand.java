package net.legitimoose.bot.discord.command;

// TODO: remove useless imports
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.context.CommandContextBuilder;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.legitimoose.bot.LegitimooseBotClient;
import net.legitimoose.bot.Scraper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.legitimoose.bot.LegitimooseBotClient.scraper;
import static net.legitimoose.bot.LegitimooseBot.LOGGER;

public class ListallCommand implements Command {
    final SlashCommandInteractionEvent event;
    final boolean raw;

    public ListCommand(SlashCommandInteractionEvent event, boolean raw) {
        this.event = event;
        this.raw   = raw;
    }

    @Override
    public void onCommandReceived() {
        if (raw) {
            // Get /glist all and output
            Minecraft.getInstance().player.connection.sendCommand("glist all");
            try {
              TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
              LOGGER.error(e.getMessage());
            }
            event.reply(LegitimooseBotClient.lastMessage.trim()).queue();
        } else {
             // Get /listall and output
            Minecraft.getInstance().player.connection.sendCommand("listall");
            try {
              TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
              LOGGER.error(e.getMessage());
            }
            event.reply(LegitimooseBotClient.lastMessage.trim()).queue();
          }
    }
}
