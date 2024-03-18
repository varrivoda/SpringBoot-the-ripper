package example.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class PredskazServiceNameBased implements PredskazService {
    @Override
    public boolean willSurvive(String name) {
        return !name.contains("Stark") && ThreadLocalRandom.current().nextBoolean();
    }

}
