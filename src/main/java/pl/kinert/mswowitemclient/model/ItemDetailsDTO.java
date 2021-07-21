package pl.kinert.mswowitemclient.model;

public class ItemDetailsDTO {
    private WeaponDTO weapon;
    private ArmorDTO armor;
    private StatisticDTO[] stats;

    public WeaponDTO getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponDTO weapon) {
        this.weapon = weapon;
    }

    public ArmorDTO getArmor() {
        return armor;
    }

    public void setArmor(ArmorDTO armor) {
        this.armor = armor;
    }

    public StatisticDTO[] getStats() {
        return stats;
    }

    public void setStats(StatisticDTO[] stats) {
        this.stats = stats;
    }
}
