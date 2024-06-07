package com.neuron.admin_server.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserRepoImpl {

  @PersistenceContext
  @Getter
  @Setter
  private EntityManager entityManager;

  public User getUser(String email,String password) {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<User> criteria = builder.createQuery(User.class);

    Root<User> root = criteria.from(User.class);
    List<Predicate> predicates = new ArrayList<>();

      predicates.add(builder.equal(root.get("email"), email));
      predicates.add(builder.equal(root.get("password"),password));
    
    criteria.where(builder.and(predicates.toArray(Predicate[]::new)));

   return 
        entityManager.createQuery(criteria).getResultList()
        .stream().findFirst().orElse(null);
  }

}
