package me.sakyce.censormod.block;

import me.sakyce.censormod.Censormod;
import me.sakyce.censormod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Censormod.MODID);

    public static final RegistryObject<Block> CENSOR_BLOCK = registerBlock(
            "censor_block", () -> new Block(
                    BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.AMETHYST)
            )
    );

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(
                block.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)
        ));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

/*
                                                 :^.
                                              .:~~^^.
                                            .:~~^^^^^.
                                          .:^~~^^^^^^^.
                                       .:^^~!~^^^^^^^^:.
                                     .:^^~~!~~^^^^^^^^::.
                                   .:^^^~!!~~~^^^^^^^^^::.
                                 .^^^^~~!!~~~~~~^^^^^^^:::.
                              .:^^^^~~~~~~~~~~~~~^^^^^^^^~~^^:::.
                            .:^^^^^~~~~~~~~~~~~~~~!77?JJJJYYYYYJJ??!~:.
        .:~~~.            .:^^^^^^~~~~~~~~~~~~~!??JJJJJJYYYYYYYYYYYYYYJ7^.
      .:^!77~:           :^^^^^^^~~~~~~~~~~~!7?JJJJJJJJJJJJJJJJJYYYYYYJJJ?~.
      ::^~^::.         .:^^^^^^^~~~~~~~~~^~7????JJJJJJYYJJJJJJJJJJJJJJJJJ?7!.
      ...:....       .:^^^^^^^^~~~~~~~~~^~!77??????JJJJJJJJJJJJJJJ???????77!^.
      ........      .:^^^^^^^^~~~~~~~~~^^!!77777?????????????????77777777!!~^:
       ....::^.    ::^^^^^^^^~~~!!!!!~~:^~!!!!77777777777777777777!!!!!!~~~^::
      .:^^~~^^^  .::^^^^^^^^~~~!!!!!!!~:^^~~~!!!!!!!!!!!!!!!!!!!!!!~~~~^^^::..
   .:^~!777~^::..:::::::^^^^^~~!!!!!~~~:.:^^~~~~~~~~~~~~~~~~~~~~~~~^^^:::....
  :~!7777!~^:..:^^^~!!777????JYYYYYYYYYY7..::^^^^^^^^^^^^^^^^^^^::::........
 :^~!77???77!!^::!~7&&@@@@@@@@@@@@@@@@@@@5.  ...:::::::::::.......       .
.:::^~~!!!!!!!~~^!~?55G#&@@@@@@@@@@@@@@@@@P!:.       ..              ...........
:^~~~~^^:::::::::^^!~7JP#@@@@@@@@@@@@@@@@@@#Y7!~^:.            ..:^~!777!!~^....:::::..
::^~~!!~~^:.... ..:^~7YG&@@@@@@@@@@@@@@@@@@@@BY?7777!!~~~~~~~!!777777777777!~.   ..::^^^^:.
..::::::::....^^:^^^~?5B@@@@@@@@@@@@@@@@@@@@@@@#PY?7777777777777777777777777!~.    ...:^^~^^:.
 ....:^^~~~~~^Y5?!^^~75B@@@@@@@@@@@@@@@@@@@@@@@@@@#G5J?7777777777777777777777!!:     ..::^~~^:.
  .::^^~~~^:::^~^^^~~~75#@@@@@@@@@@@@@@@@@@@@@@@@@@@@&#BP5J??77777777777777777!!^     ...:^~~^^.
   ..........:^^^^^~~~~?P&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&#BGP5YYJJ??????777777!^      ..:^~~^^:
        .7JJJ?~^^^^^~~~?G@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&##BGGPP55YYYJJ?7~      .::^^^^^:
        ~5GG5?~^^^^^~~75#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&##BBGGP5YJ!      ::^^^^^:
       .JPGPJ!^^^^^^~!?YPG#&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&##BBGP5Y!.    ::^^^^^:
       !5PP5?~^^^^^^~~!!?YPB&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&###BGGPY!.   .:^^^^^:
      .J5GPY7~^^^^^^~~~~7JPB&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&###BGGPY!.  ::^^^^^:.
      ~YPG5J7~^^^^^^~~!7JPB#&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&###BGY?!^^~~~^^::::.
      7YPP5J?~^^^^^^^~7J5G#&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&BY!^^^~~~^~~^:::...
     .7JJYYJ?!~^^^^^^~7JPB#&&&&&&&&&&&&&&&&&&&&&&&&@@@@@@@@@@@@@@@@@@@@@&&&&&&&G?~^^~~~^::~7!~^::..
     .~!!7???7!~^^^^~!?YPB###################&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&P!:^~!~~^:..^!!!~^::...
     .^^^~!7????7!!77?J5PGBBBBBBBBBBBBBBBB###############&&&&&&&&&&&&&&&&&&&&P!^:::::^~::^~!!~^::...
     .:::^~!7?JYYJJJJYY5PPGGGGGGGGGGGGGGGGGBBBBBBBBBBB############&&&&&&&&&&&&&GJ7!!777~:^~~~^:....:
      :^^^^~7?JY555YYY5555555555555PPPPPPPPPPPGGGGGGGGGBBBBBBBBB###############Y7!777!~^~!~^^:..^:..
      :^~^^~!7JY5PP555YYYYYYJJJJJJJJYYYYYYYYY55555PPPPPPPPGGGGGGBBBBBB#########B5?7!~^~!!~^^:..^^:..
       ^~~~~~!7JJY5YYJJJ???7777777777777777????JJJJJYYYYY5555PPPPPGGGGBBBBBBBBBBBG5?.:!7!^^:..:^:...
       .^~~~~~!7?JJJJ?77!!~~^^^^^^^^^^^^^^^^~~~~!!!!!777???JJJYYY55PPPPGGGGBBBBBBGGP7::^^::..:^:...
        .:^^^^~!!7777!!~^^:::::::::::::::::::::::::::^^^~~!!77??JJYYY55PPPGGGGGGGGGPPY:  ..:^^:...
           .:::::^^^^::::::::::...............::::::::::::^^~~!!7??JJYY55PPPPGGGPPP55Y~.:^!~^:...
              ...::::::....                      ...:::::::^^~~!!77??JJYY555PPPP555YYJ?~:.::....
                                                       ..:::^^^~!!77??JJYYYY555YYYJJ?7!~^.
                                                            ..:::^^~~!!77??JJJJJ??77!~~^.
                                                                ..:::::::^^^^^~^^^^^^:.
                                                                   ..:::::::::::....
 */