package com.hero.witchery_rewitched.block.glyph;

import com.hero.witchery_rewitched.WitcheryRewitched;
import com.hero.witchery_rewitched.api.rituals.AbstractRitual;
import com.hero.witchery_rewitched.block.INamedContainerExtraData;
import com.hero.witchery_rewitched.block.plants.grassper.GrassperTileEntity;
import com.hero.witchery_rewitched.crafting.recipe.ModRecipes;
import com.hero.witchery_rewitched.crafting.recipe.RitualRecipe;
import com.hero.witchery_rewitched.init.ModItems;
import com.hero.witchery_rewitched.init.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class GoldGlyphTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerExtraData, IInventory {
    public final static int GATHER_TIME = WitcheryRewitched.DEBUG ? 1 : 20;
    private boolean gathering = false;
    private UUID caster = null;
    private List<List<Item>> gatherQueue = new ArrayList<>();
    private List<RitualRecipe> ritualQueue = new ArrayList<>();
    private List<AbstractRitual> activeRituals = new ArrayList<>();


    public ArrayList<ItemStack> items = new ArrayList<>();

    public GoldGlyphTileEntity(){
        super(ModTileEntities.GOLD_GLYPH.get());
    }

    @Override
    public void encodeExtraData(PacketBuffer buffer) {

    }

    public void startGather(PlayerEntity player){
        gathering = true;
        caster = player.getUUID();
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("tileentity.witcheryrewtiched.goldglyph");
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return null;
    }

    @Override
    public void tick() {
        if(level == null || level.isClientSide)
            return;

        if(activeRituals.size() > 0 && gathering)
            gathering = false;

        // this.ritual should be null if the ritual is finished
        if(!gathering && activeRituals.size() != 0){
            for(int i = 0; i < activeRituals.size(); i++){
                if(!activeRituals.get(i).active){
                    activeRituals.remove(i);
                }
            }
            for (AbstractRitual activeRitual : activeRituals) {
                activeRitual.tick();
            }
        }

        if(gathering && gatherQueue.size() == 0) {
            findRitual();
        }
        if(gathering && level.getGameTime() % GATHER_TIME == 0){
            gathering = gather();
        }
        if(!gathering && ritualQueue.size() > 0 && gatherQueue.size() > 0 && gatherQueue.get(0).size() == 0){
            //check for valid recipe and altar power here
            gathering = false;
            gatherQueue.remove(0);
            RitualRecipe rec = ritualQueue.remove(0);
            AbstractRitual ritual = rec.getRitual().createRite(worldPosition, level, caster, rec.getIngredientItems().contains(ModItems.CHARGED_ATTUNED_STONE.get()));
            if(ritual.checkStartConditions(items))
            {
                ritual.start(items);
                activeRituals.add(ritual);
                items.clear();
                caster = null;
            }
            else {
                spitItems(rec, new ArrayList<>());
                items.clear();
                caster = null;
            }
        }
        else if(!gathering && ritualQueue.size() > 0 && gatherQueue.size() > 0){
            RitualRecipe rec = ritualQueue.remove(0);
            spitItems(rec, gatherQueue.get(0));
            gatherQueue.remove(0);
            items.clear();
            caster = null;
        }
    }

    private boolean findRitual(){
        AtomicBoolean flag = new AtomicBoolean(false);
        VoxelShape area = VoxelShapes.box(worldPosition.getX() - 3, worldPosition.getY() - 3, worldPosition.getZ() -3, worldPosition.getX() + 3, worldPosition.getY() + 3, worldPosition.getZ() +3);
        List<ItemStack> itemEntities = level.getEntities(EntityType.ITEM, area.bounds(), (item) ->  true).stream().map(ItemEntity::getItem).collect(Collectors.toList());
        List<ItemStack> itemStacks = new ArrayList<>();
        for(int x = -3;  x < 4; x++){
            for(int z = -3; z < 4; z++){
                BlockPos pos = getBlockPos().offset(x, 0, z);
                TileEntity te = level.getBlockEntity(pos);
                if( te instanceof GrassperTileEntity && ((GrassperTileEntity)te).getItem(0) != ItemStack.EMPTY){
                    itemStacks.add(((GrassperTileEntity)te).getItem(0));
                }
            }
        }
        List<ItemStack> items = new ArrayList<>();
        items.addAll(itemEntities);
        items.addAll(itemStacks);
        level.getRecipeManager().getAllRecipesFor(ModRecipes.Types.RITUAL).forEach(recipe -> {
            if (recipe.matches(new IInventory() {
                @Override
                public void clearContent() {

                }

                @Override
                public int getContainerSize() {
                    return items.size();
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public ItemStack getItem(int index) {
                    return items.get(index);
                }
                @Override
                public ItemStack removeItem(int index, int count) {
                    return null;
                }
                @Override
                public ItemStack removeItemNoUpdate(int index) {
                    return null;
                }
                @Override
                public void setItem(int index, ItemStack stack) {
                }
                @Override
                public void setChanged() {

                }
                @Override
                public boolean stillValid(PlayerEntity player) {
                    return false;
                }
            }, level)) {
                List<Item> gatherList = new ArrayList<>(recipe.getIngredientItems());
                gatherQueue.add(gatherList);
                ritualQueue.add(recipe);
                flag.set(true);
            }
        });
        return flag.get();
    }


    private boolean gather(){
        VoxelShape area = VoxelShapes.box(worldPosition.getX() - 3, worldPosition.getY() - 3, worldPosition.getZ() -3, worldPosition.getX() + 3, worldPosition.getY() + 3, worldPosition.getZ() +3);
        assert level != null;
        ItemEntity entity = level.getEntities(EntityType.ITEM, area.bounds(), (item) -> gatherQueue.size() > 0 && gatherQueue.get(0).contains(item.getItem().getItem())).stream().findFirst().orElse(null);
        if(entity != null ){
            insert(new ItemStack(entity.getItem().getItem()));
            if(entity.getItem().hasTag()){
                items.add(entity.getItem().copy());
            }
            gatherQueue.get(0).remove(entity.getItem().getItem());
            ((ServerWorld)level).playSound(null, getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), SoundEvents.ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, .5f, .3f);
            ((ServerWorld)level).sendParticles(ParticleTypes.POOF, entity.getX(), entity.getY() +.3, entity.getZ(), 5,0,0,0, .01);
            entity.getItem().setCount(entity.getItem().getCount()-1);
            return true;
        }
        for(int x = -3; x < 4; x++){
            for(int z = -3; z < 4; z++){
                BlockPos pos = getBlockPos().offset(x, 0, z);
                TileEntity te = level.getBlockEntity(pos);
                if( te instanceof GrassperTileEntity){
                    GrassperTileEntity gte = (GrassperTileEntity) te;
                    if(gatherQueue.size() > 0 && gatherQueue.get(0).contains(gte.getItem(0).getItem())){
                        gatherQueue.get(0).remove(gte.getItem(0).getItem());
                        gte.removeItem(0, 1);

                        ((ServerWorld)level).playSound(null, te.getBlockPos().getX(), te.getBlockPos().getY(), te.getBlockPos().getZ(), SoundEvents.ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, .5f, .3f);
                        ((ServerWorld)level).sendParticles(ParticleTypes.POOF, te.getBlockPos().getX() + .5, te.getBlockPos().getY() +.6, te.getBlockPos().getZ()+ .5, 5,0,0,0, .01);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void spitItems(RitualRecipe recipe, List<Item> list){
        List<ItemStack> rec = recipe.getIngredientItems().stream().map(ItemStack::new).collect(Collectors.toList());
        for(int i = 0; i < rec.size(); i++){
            if(rec.get(i) != ItemStack.EMPTY && !list.contains(rec.get(i).getItem())){
                InventoryHelper.dropItemStack(level, getBlockPos().getX() + .5,getBlockPos().getY() + .5, getBlockPos().getZ() + .5, rec.get(i));
                rec.set(i, ItemStack.EMPTY);
                ((ServerWorld)level).playSound(null, getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), SoundEvents.FIRE_EXTINGUISH, SoundCategory.BLOCKS, .3f, .3f);
            }
        }
    }

    private void insert(ItemStack stack){
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == ItemStack.EMPTY) {
                items.set(i, stack);
                return;
            }
        }
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        return compound;
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return items.get(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        ItemStack stack = items.get(index);
        items.set(index, ItemStack.EMPTY);
        return stack;
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        items.set(index, stack);
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return false;
    }

    @Override
    public void clearContent() {
        items.clear();
    }


}
