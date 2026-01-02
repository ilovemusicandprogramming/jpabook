package jpabook.jpashop.repository.order.query;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderQueryRepository {

    /**
     * repo 와 query 구분이유 : 관심사 분리
     * repo - 핵심 비지니스 로직 관련
     * query - 화면, 애플리케이션 의존(특정화면들에 fit 한)
     */

    private final EntityManager em;
}
