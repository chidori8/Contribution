package services;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.deposit.business.services.BankService;
import ru.deposit.data.dto.BankDTO;
import ru.deposit.data.entity.Bank;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {config.TestConfig.class})
public class BankServiceTest {

    @Autowired
    private BankService bankService;

    @Autowired
    private Flyway flyway;

    @Before
    public void init() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void createTest() {
//        bankService.createBank(new BankDTO(12345, "BANK1"));
//        "hibernate_sequence"
    }
}
