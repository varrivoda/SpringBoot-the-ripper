package example.controller;

import example.dao.MoneyDao;
import example.services.TransferMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IronBankController {
    private final TransferMoneyService transferMoney;
    private final MoneyDao moneyDao;

    @GetMapping("/credit")
    public String credit(@RequestParam String name, @RequestParam long amount){
        long resultDeposit =transferMoney.transfer(name, amount);
        if(resultDeposit == -1){
            return "rejected \n You won't survive this winter";
        }
        return String.format("Accepted\nCurrent deposit: %s", resultDeposit);
    }
}
