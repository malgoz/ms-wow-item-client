package pl.kinert.mswowitemclient.utils;

import pl.kinert.mswowitemclient.jpa.model.*;
import pl.kinert.mswowitemclient.model.*;

public class Mapper {

    public static ItemClass mapItemClass(BaseItemDTO itemDTO){
        ItemClass itemClass = new ItemClass();
        itemClass.setId(itemDTO.getId());
        itemClass.setName(itemDTO.getName());
        return itemClass;
    }

    public static ItemSubclass mapItemSubclass(BaseItemDTO itemDTO, ItemClass itemClass){
        ItemSubclass itemSubclass = new ItemSubclass();
        itemSubclass.setName(itemDTO.getName());
        itemSubclass.setItemClass(itemClass);
        itemSubclass.setSubclassId(itemDTO.getId());
        return itemSubclass;
    }

    public static Item mapItem(ItemDTO itemDTO, ItemClass itemClass, ItemSubclass itemSubclass){
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setName(itemDTO.getName());
        item.setInventoryType(itemDTO.getInventoryType().getName());
        item.setLevel(itemDTO.getLevel());
        item.setPurchasePrice(itemDTO.getPurchasePrice());
        item.setSellPrice(itemDTO.getSellPrice());
        item.setQuality(itemDTO.getQuality().getName());
        item.setRequiredLevel(itemDTO.getRequiredLevel());
        item.setItemClass(itemClass);
        item.setItemSubclass(itemSubclass);
        return item;
    }

    public static Armor mapArmor(ArmorDTO armorDTO){
        Armor armor = new Armor();
        armor.setValue(armorDTO.getValue());
        return armor;
    }

    public static Weapon mapWeapon(WeaponDTO weaponDTO){
        Weapon weapon = new Weapon();
        weapon.setAttackSpeed(weaponDTO.getAttackSpeed().getValue());
        weapon.setAttackSpeedTxt(weaponDTO.getAttackSpeed().getDisplayString());
        weapon.setDps(weaponDTO.getDps().getValue());
        weapon.setDpsTxt(weaponDTO.getDps().getDisplayString());
        weapon.setMaxDamageValue(weaponDTO.getDamage().getMaxValue());
        weapon.setMinDamageValue(weaponDTO.getDamage().getMinValue());
        weapon.setDamageClass(weaponDTO.getDamage().getDamageClass().getName());
        return weapon;
    }

    public static Statistic mapStatistic(StatisticDTO statisticDTO){
        Statistic statistic = new Statistic();
        statistic.setType(statisticDTO.getType().getName());
        statistic.setValue(statisticDTO.getValue());
        return statistic;
    }
}
