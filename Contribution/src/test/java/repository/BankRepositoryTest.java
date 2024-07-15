package repository;

import org.checkerframework.checker.units.qual.A;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ru.deposit.data.entity.Bank;
import ru.deposit.data.repository.BankRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {config.TestConfig.class})
public class BankRepositoryTest {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private Flyway flyway;

    @Before
    public void init() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void saveTest() {
//       Bank bank = Bank.builder()
//                .id(0L)
//                .name("BANK1")
//                .bank_id_code(12345)
//                .build();
//       bankRepository.save(bank);

    }
}
