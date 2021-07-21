package pl.kinert.mswowitemclient.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kinert.mswowitemclient.jpa.model.Statistic;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {

}
