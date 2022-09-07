package net.nickvhoy11.deathsaver.mixin;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.text.Text;


@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(at = @At("TAIL"),method = "onDeath")
    private void onDeath(DamageSource damageSource,CallbackInfo info) {
        String xpos = String.valueOf((int)(((ServerPlayerEntity)(Object)this).prevX));
        String ypos = String.valueOf((int)(((ServerPlayerEntity)(Object)this).prevY));
        String zpos = String.valueOf((int)(((ServerPlayerEntity)(Object)this).prevZ));
        //String player = ((ServerPlayerEntity)(Object)this)..toString();
        String finalStr ="["+xpos+","+ypos+","+zpos+"]";

        //LOGGER.info(finalStr);
        ((ServerPlayerEntity)(Object)this).getServer().getPlayerManager().broadcast(Text.literal(finalStr).formatted(Formatting.GREEN),false);
    }
}



