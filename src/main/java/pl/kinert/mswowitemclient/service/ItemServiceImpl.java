package pl.kinert.mswowitemclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import pl.kinert.mswowitemclient.client.ItemClient;
import pl.kinert.mswowitemclient.jpa.model.*;
import pl.kinert.mswowitemclient.jpa.repository.ArmorRepository;
import pl.kinert.mswowitemclient.jpa.repository.ItemRepository;
import pl.kinert.mswowitemclient.jpa.repository.StatisticRepository;
import pl.kinert.mswowitemclient.jpa.repository.WeaponRepository;
import pl.kinert.mswowitemclient.model.ItemDTO;
import pl.kinert.mswowitemclient.model.StatisticDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static pl.kinert.mswowitemclient.utils.Mapper.*;

@Service
public class ItemServiceImpl implements ItemService {

    @Value("${battlenet.base.url}")
    private String battlenetBaseUrl;

    @Value("${battlenet.namespace.locale.string}")
    private String battlenetNamespaceLocale;

    private final TokenService tokenService;

    private final ItemClassService itemClassService;

    private final ItemRepository itemRepository;

    private final WeaponRepository weaponRepository;

    private final ArmorRepository armorRepository;

    private final StatisticRepository statisticRepository;

    private final ItemClient itemClient;

    public ItemServiceImpl(TokenService tokenService,
                           ItemClassService itemClassService,
                           ItemRepository itemRepository,
                           WeaponRepository weaponRepository,
                           ArmorRepository armorRepository,
                           StatisticRepository statisticRepository,
                           ItemClient itemClient
                           ){
        this.tokenService = tokenService;
        this.itemClassService = itemClassService;
        this.itemRepository = itemRepository;
        this.armorRepository = armorRepository;
        this.weaponRepository = weaponRepository;
        this.statisticRepository = statisticRepository;
        this.itemClient = itemClient;
    }

    public ItemDTO getItemById(long id) throws URISyntaxException {
        ItemDTO item = itemClient.getItemById(id);
        mapAndSaveItem(item);
        return item;
    }

    @Transactional
    private void mapAndSaveItem(ItemDTO itemDTO) {
        ItemClass itemClass = itemClassService.getItemClassById(itemDTO.getItemClass().getId());
        ItemSubclass itemSubclass = itemClassService.getItemSubclassByName(itemDTO.getItemSubclass().getName(), itemDTO.getItemSubclass().getId());
        Item item = itemRepository.save(mapItem(itemDTO, itemClass, itemSubclass));
        if (itemDTO.getItemDetails().getWeapon() != null){
            mapAndSaveWeapon(itemDTO, item);
        }
        if (itemDTO.getItemDetails().getArmor() != null){
            mapAndSaveArmor(itemDTO, item);
        }
        if (itemDTO.getItemDetails().getStats() != null && itemDTO.getItemDetails().getStats().length > 0){
            mapAndSaveStatistics(itemDTO, item);
        }
    }

    private void mapAndSaveStatistics(ItemDTO itemDTO, Item item) {
        List<Statistic> statisticList = new ArrayList<>();
        for (StatisticDTO stat : itemDTO.getItemDetails().getStats()){
            Statistic statistic = mapStatistic(stat);
            statistic.setItem(item);
            statisticList.add(statistic);
        }
        statisticRepository.saveAll(statisticList);
    }

    private void mapAndSaveArmor(ItemDTO itemDTO, Item item) {
        Armor armor = mapArmor(itemDTO.getItemDetails().getArmor());
        armor.setItem(item);
        armorRepository.save(armor);
    }

    private void mapAndSaveWeapon(ItemDTO itemDTO, Item item) {
        Weapon weapon = mapWeapon(itemDTO.getItemDetails().getWeapon());
        weapon.setItem(item);
        weaponRepository.save(weapon);
    }
}
