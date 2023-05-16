package AuroraTech.Co.AuroraContent.Repository;

import AuroraTech.Co.AuroraContent.Model.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact,Integer> {
}
