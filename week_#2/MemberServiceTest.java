package GDSC.GDSCBackend.service;

import GDSC.GDSCBackend.domain.Member;
import GDSC.GDSCBackend.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {       // Test코드는 메서드명을 한글로 적어도 된다.

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void beforeEach(){      //테스트가 독립적으로 실행 되어야 하기 때문에 같은 메모리의 레포지토리를 만든다.
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach          // 각 Test메서드가 끝난 이후에 호출되어서 각 테스트가 다른 테스트에 영향을 받지 않게 테스트케이스를 비워준다.
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given : 주어진것
        Member member = new Member();
        member.setName("hello");

        // when : 이것을 실행 했을 때
        Long saveId = memberService.join(member);

        // then : 나와야 하는 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*        try {
            memberService.join(member2);
            fail();
        } catch (IllegalAccessException e){
            assertThat(e,getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

        //then
    }*/


//    @Test
//    void findMembers() {
///    }

//    @Test
//    void findOne() {
//    }
    }
}