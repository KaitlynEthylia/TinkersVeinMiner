package dev.ethy.tinkers_vein_miner.mixin;

import com.illusivesoulworks.veinmining.common.veinmining.logic.VeinMiningLogic;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

import static dev.ethy.tinkers_vein_miner.TinkersVeinMiner.MODIFIER;

@Mixin(VeinMiningLogic.class)
public class VeinMiningLogicMixin {
	@ModifyVariable(
		remap = false,
		method = "veinMine(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)V",
		at = @At(
			args = "log=true",
			value = "INVOKE_ASSIGN",
			remap = true,
			target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getItemEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/item/ItemStack;)I",
			ordinal = 0
		)
	)
	private static int veinMine(
		int veiningLevel,
		@Local ItemStack stack
	) {
		if (veiningLevel == 0) {
			veiningLevel = ModifierUtil.getModifierLevel(stack, MODIFIER.getId());
		}
		return veiningLevel;
	}
}
