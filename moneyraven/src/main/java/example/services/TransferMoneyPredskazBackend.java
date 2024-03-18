package example.services;

import example.dao.MoneyDao;
import example.model.Bank;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Transactional
public class TransferMoneyPredskazBackend implements TransferMoneyService {
    private final MoneyDao moneyDao;
    private final PredskazService predskazService;

    @Override
    public long transfer(String addresseeName, long amount) {
        Bank bank = moneyDao.findAll().get(0);

        if(bank.getTotalAmount()>amount && predskazService.willSurvive(addresseeName)){
            bank.credit(amount);
            return moneyDao.save(bank).getTotalAmount();
        }

        return -1;

    }
}
