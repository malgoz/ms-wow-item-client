package pl.kinert.mswowitemclient.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kinert.mswowitemclient.jpa.model.ItemSubclass;

@Repository
public interface ItemSubclassRepository extends JpaRepository<ItemSubclass, Long> {
    ItemSubclass findByNameAndSubclassId(String name, long id);
}
