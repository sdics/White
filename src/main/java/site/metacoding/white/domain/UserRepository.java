package site.metacoding.white.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그를 사용하게 해주는 어노테이션
@RequiredArgsConstructor
@Repository // IoC 등록
public class UserRepository {

  // DI
  private final EntityManager em;

  public User save(User user) {
    // Persistence Context에 영속화 시키기 -> 자동 flush (트랜잭션 종료시)
    log.debug("디버그 : " + user.getId());
    em.persist(user);
    log.debug("디버그 : " + user.getId()); // 영속화후 (DB와 동기화된다.)
    return user;
  }

  public User findByUsername(String username) {
    return em.createQuery("select u from User u where u.username=:username", User.class)
        .setParameter("username", username)
        .getSingleResult();
  }

  public User findById(Long id) {
    return em.createQuery("select u from User u where u.id=:id", User.class)
        .setParameter("id", id)
        .getSingleResult();
  }

}