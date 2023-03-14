package group.twentysix.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
@Autowired
    private MongoTemplate mongoTemplate;
    public Payment createPayment(String cardNumber, String username) {
        Payment payment =   paymentRepository.insert(new Payment(cardNumber));


        mongoTemplate.update(User.class)
                .matching(Criteria.where("username").is(username))
                .apply(new Update().push("paymentIds").value(payment))
                .first();

        return payment;
    }
}
