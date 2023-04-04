package GDSC.GDSCBackend.domain;


public class Member {       // 고객의 정보(id, name)저장 + 회원 객체를 생성하는 부분
    private Long id;
    private String name;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
