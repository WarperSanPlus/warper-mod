package net.warpersan.warpermod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.warpersan.warpermod.WarperMod;

public class SpringGun extends Item {
    public SpringGun(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        /*Vec3d propulsion = GetPropulsion(user);
        Vec3d velocity = user.getVelocity();

        user.setVelocity(
                velocity.x + propulsion.x,
                propulsion.y,
                velocity.z + propulsion.z);
        user.getItemCooldownManager().set(this, 30);*/

        //return TypedActionResult.success(user.getStackInHand(hand));
        UseSpringGun(user, null, true);
        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        UseSpringGun(user, entity, false);
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity user = context.getPlayer();

        if (user != null) {
            UseSpringGun(user, null, false);
        }
        return super.useOnBlock(context);
    }

    private static final double power = 3;

    private Vec3d GetPropulsion(PlayerEntity user) {
        Vec3d rotation = user.getRotationVector();
        ItemStack stack = user.getStackInHand(user.getActiveHand());
        return rotation.multiply(-power);
    }

    private void UseSpringGun(PlayerEntity user, LivingEntity target, Boolean wasteTry) {
        if (user == null) {
            WarperMod.LOGGER.error("PlayerEntity user shouldn't be null.");
            return;
        }

        if (!wasteTry) {
            Vec3d propulsion = GetPropulsion(user);

            if (target != null) {
                target.addVelocity(propulsion.multiply(-1));
                propulsion = propulsion.multiply(0.5);
            }

            Vec3d velocity = user.getVelocity();

            user.setVelocity(
                    velocity.x + propulsion.x,
                    propulsion.y,
                    velocity.z + propulsion.z);
            user.playSound(SoundEvents.BLOCK_SLIME_BLOCK_FALL, 1, 1);
            user.getItemCooldownManager().set(this, 30);
        } else {
            user.getItemCooldownManager().set(this, 4);
        }

        user.getStackInHand(user.getActiveHand()).damage(1, user, (p) -> {
            // Damage
        });
    }
}