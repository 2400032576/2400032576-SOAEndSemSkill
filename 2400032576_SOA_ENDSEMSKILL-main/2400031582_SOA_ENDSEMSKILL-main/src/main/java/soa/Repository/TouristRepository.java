
package soa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soa.Entity.Tourists;

//@Repository
public interface TouristRepository
        extends JpaRepository<Tourists, Long> {
}
