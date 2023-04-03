package me.sakyce.censormod;

import me.sakyce.censormod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorshipProcedure {
    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        if (!isCensorBlockInRange( event.getPlayer() )) {
            return;
        }

        // event.getComponent();
        // new TextComponent(component.getContents())

        Component censoredMessage = new TextComponent( censorMessage(event.getComponent().getString()) );
        event.setComponent(censoredMessage);
    }

    public static String censorMessage(String text) {
        String regex = "[a-zA-Z]";
        String  subst = "\\#";

        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);

        return matcher.replaceAll(subst);
    }

    public static boolean isCensorBlockInRange(Player player) {
        LevelAccessor level = player.level;
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();

        for (int sx = -3; sx <= 6; sx++) {
            for (int sy = -3; sy <= 6; sy++) {
                for (int sz = -3; sz <= 6; sz++) {
                    BlockState blockState = level.getBlockState( new BlockPos(x+sx,y+sy,z+sz) );

                    if (blockState.getBlock() == ModBlocks.CENSOR_BLOCK.get()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

