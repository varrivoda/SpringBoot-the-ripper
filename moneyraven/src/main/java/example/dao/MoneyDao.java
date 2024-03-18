package example.dao;

import example.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyDao extends JpaRepository<Bank, String> {
}
