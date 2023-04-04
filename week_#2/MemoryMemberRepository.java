package GDSC.GDSCBackend.repository;

import GDSC.GDSCBackend.domain.Member;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {       // MemberRepository에 작성된 메서드를 필요에 맞게 재정의
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save() {
        return save();
    }

    @Override
    public Member save( Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }
    public void clearStore() {
        store.clear();
    }
}

