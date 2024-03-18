package example.model;

import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity
public class Bank {
    @Id long id;
    long totalAmount;

    public void credit(long amount){
        totalAmount -=amount;
    }
}
