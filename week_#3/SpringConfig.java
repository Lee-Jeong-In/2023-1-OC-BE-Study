package GDSC.GDSCBackend;

import GDSC.GDSCBackend.repository.*;
import GDSC.GDSCBackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/* 객체지향의 장점 : 레고처럼 필요한 부분을 만들고, 원할 때 끼워서 어플리케이션을 조립하듯이 개발할 수 있다. */

@Configuration
public class SpringConfig {     // 스프링빈에 등록할 파일들을 모아서 등록할 수 있게끔 만들어 주는 파일이다.


    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


/*    private EntityManager em;      JPA 사용할 때

    @Autowired
    public SpringConfig(EntityManager em){
        this.em =em;
    }*/

//    private final DataSource dataSource;      Jdbc 사용할 때때

//    public  SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    @Bean       //내가 직접 스프링빈에 등록한다. + 다른 파일에 어노테이션을 못했을 때 직접 넣어 주는 방법이다.
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);          + Jdbc (쿼리까지 다 만든것)
        //return new JdbcTemplateMemberRepository(dataSource);  + Jdbc Template를 사용 / 쿼리는 메서드로 쓴다.
        //return new JpaMemberRepository(em);
    }
}
