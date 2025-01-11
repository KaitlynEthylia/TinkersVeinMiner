package dev.ethy.tinkers_vein_miner;

import dev.ethy.tinkers_vein_miner.data.ModifierRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TinkersVeinMiner.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersVeinMiner {
    public static final String MODID = "tinkers_vein_miner";

	private static final ModifierDeferredRegister MODIFIERS =
		ModifierDeferredRegister.create(MODID);
	public static final StaticModifier<VeinMiningModifier> MODIFIER =
		MODIFIERS.register("veinmining", VeinMiningModifier::new);

    public TinkersVeinMiner() {
		IEventBus bus = Mod.EventBusSubscriber.Bus.MOD.bus().get();
		MODIFIERS.register(bus);
    }

	@SubscribeEvent
	static void gatherData(final GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		generator.addProvider(event.includeServer(), new ModifierRecipeProvider(generator.getPackOutput()));
	}
}
