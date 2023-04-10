package GDSC.GDSCBackend.repository;

import GDSC.GDSCBackend.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

/* Jpa를 더 쉽게 만들어 주는 Spring Jpa 이다. */
public interface SpringDataJapMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    // spring bean에 구현체를 만들어준다.
    @Override
    Optional<Member> findByName(String name);
}
