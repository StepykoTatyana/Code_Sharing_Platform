package com.example.Code_Sharing_Platform.CascadeTAsk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class PersonService {

    private final PersonRepository repository;
    private final PlatformTransactionManager trManager;

    @Autowired
    public PersonService(PersonRepository repository,
                         PlatformTransactionManager transactionManager) {
        this.repository = repository;
        this.trManager = transactionManager;
    }
    @Transactional
    public void doTransaction() {
        TransactionDefinition trDefinition = new DefaultTransactionDefinition();
        TransactionStatus trStatus = trManager.getTransaction(trDefinition);

        try {
            var person = new Persons();
            person.setName("Mike");
            repository.save(person); // insert
            person.setName("Bob");
            repository.save(person); // update
            trManager.commit(trStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
            trManager.rollback(trStatus);
        }
    }
}

interface PersonRepository extends CrudRepository<Persons, Long> {

}