package net.nickvhoy11.deathsaver.mixin;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static net.nickvhoy11.deathsaver.DeathSaver.LOGGER;


@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin {

    @Inject(at = @At("HEAD"),method = "onDeath")
    private void onDeath(DamageSource damageSource,CallbackInfo info) {
        LOGGER.info(String.valueOf(((ServerPlayerEntity)(Object)this).getPos()));
    }
}


