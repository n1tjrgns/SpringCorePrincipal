package com.spring.principal.member;

import java.util.HashMap;
import java.util.Map;

//구현체1번
public class MemoryMemberRepository implements MemberRepository{

    //동시성 이슈가 있을 수 있으니 ConcurrentHashMap 사용하는게 좋다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
