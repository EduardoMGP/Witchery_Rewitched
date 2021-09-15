package com.hero.witchery_rewitched.api.rituals;

import com.hero.witchery_rewitched.api.Util.WorldUtils;
import com.hero.witchery_rewitched.block.altar.AltarTileEntity;
import com.hero.witchery_rewitched.block.distillery.DistilleryTileEntity;
import com.hero.witchery_rewitched.block.glyph.GlyphBlock;
import com.hero.witchery_rewitched.init.ModBlocks;
import com.hero.witchery_rewitched.init.ModItems;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.*;

public class AbstractRitual extends ForgeRegistryEntry<AbstractRitual> {
    public static final Map<Integer, String[]> circleShapes = new HashMap<>();

    private final List<Pair<Integer, GlyphBlock>> CIRCLES = new ArrayList<>(3);
    private final List<EntityType<?>> REQUIRED_ENTITIES = new ArrayList<>();

    public final BlockPos pos;
    public final World world;
    public final UUID caster;
    public final UUID target;
    public boolean active = false;
    private final int startPower;
    private final int powerPerTick;
    private final boolean requiresAltar;
    private BlockPos altar;
    private final boolean stone;


    static{
        circleShapes.put(1, new String[]{
                "  000  ",
                " 0   0 ",
                "0     0",
                "0  x  0",
                "0     0",
                " 0   0 ",
                "  000  "});
        circleShapes.put(2, new String[]{
                "   00000   ",
                "  0     0  ",
                " 0       0 ",
                "0         0",
                "0         0",
                "0    x    0",
                "0         0",
                "0         0",
                " 0       0 ",
                "  0     0  ",
                "   OO0O0   "});
        circleShapes.put(3, new String[]{
                "    0000000    ",
                "   0       0   ",
                "  0         0  ",
                " 0           0 ",
                "0             0",
                "0             0",
                "0             0",
                "0      x      0",
                "0             0",
                "0             0",
                "0             0",
                " 0           0 ",
                "  0         0  ",
                "   0       0   ",
                "    0000000    ",});

    }

    public AbstractRitual(BlockPos pos, World world, UUID caster, @Nullable UUID target,List<Pair<Integer, GlyphBlock>> circles, List<EntityType<?>> requiredEntities, int startPower,int powerPerTick, boolean stone){
        this.CIRCLES.addAll(validateCircleInput(circles));
        this.REQUIRED_ENTITIES.addAll(requiredEntities);
        this.world = world;
        this.pos = pos;
        this.caster = caster;
        this.target = target;
        this.powerPerTick = powerPerTick;
        this.startPower = startPower;
        this.requiresAltar = startPower > 0 || powerPerTick > 0;
        this.stone = stone;
    }

    public AbstractRitual createRite(BlockPos pos, World world, UUID caster, boolean stone){
        return new AbstractRitual( null, null, null, null, null, null,0,0, false);
    }

    private List<Pair<Integer, GlyphBlock>> validateCircleInput(List<Pair<Integer, GlyphBlock>> circles){
        List<Integer> used = new ArrayList<>();
        List<Pair<Integer, GlyphBlock>> def = new ArrayList<>();
        def.add(new Pair<>(1, (GlyphBlock) ModBlocks.RITUAL_GLYPH.get()));
        for (Pair<Integer, GlyphBlock> circle : circles) {
            if (used.contains(circle.getFirst())) {
                return def;
            } else {
                used.add(circle.getFirst());
            }
        }
        if(circles.size() < 1)
            return def;

        return circles;
    }

    // I swear to god hero if you don't override this I will have a stroke, you actually have to super it
    public void tick(){
        if((requiresAltar && powerPerTick > 0) && !getAltar().takePower(powerPerTick))
            active = false;
    }

    // Check if required entities are within the area, time, weather
    public boolean checkStartConditions(List<ItemStack> items){
        if(!checkForCircles())
            return false;
        else if( requiresAltar && !findAltar())
            return false;
        else if(requiresAltar && (getAltar() == null || !getAltar().takePower(startPower)))
            return false;
        return true;
    }

    public boolean findAltar(){
        altar = AltarTileEntity.findFirstAltar(pos, world);
        return altar != null;
    }

    private AltarTileEntity getAltar(){
        TileEntity te = world.getBlockEntity(altar);
        if( te instanceof AltarTileEntity){
            return (AltarTileEntity) te;
        }
        return null;
    }

    public boolean checkForCircles(){
        for(Pair<Integer, GlyphBlock> pair : CIRCLES){
            Integer num = pair.getFirst();
            GlyphBlock block = pair.getSecond();
            String[] circle = circleShapes.get(num);
            for(int i = 0; i < circle[0].length(); i++){
                for(int x = 0; x < circle[0].length(); x++){
                    int posX = i - circle[0].length()/2;
                    int posZ = x - circle[0].length()/2;
                    if(circle[i].charAt(x) == '0' &&!world.getBlockState(pos.offset(posX,0,posZ)).is(block)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void start(ArrayList<ItemStack> items){
        this.active = true;
        if(stone){
            InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.ATTUNED_STONE.get()));
        }
    }

    public String getName(){
        return "Invalid Ritual";
    }
    public String getRequirements(){
        return "Invalid Ritual";
    }
    public String getDescription(){
        return "Invalid Ritual";
    }

    public int getStartPower(){
        return startPower;
    }
    public int getPowerperSecond(){
        return powerPerTick / 20;
    }

    public List<Pair<Integer, GlyphBlock>> getCircles() {
        return CIRCLES;
    }
}
