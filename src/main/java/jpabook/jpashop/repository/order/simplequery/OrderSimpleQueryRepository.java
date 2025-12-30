package jpabook.jpashop.repository.order.simplequery;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    /**
     * repo 는 가급적 entity 를 조회하는데만 사용하자(페치 조인정도까지만 허용)
     * 이렇케 api 스펙에 fit 한 경우는 따로 분리하자(화면에 의존적이기도 하고,
     * repo 에 있으면 용도가 애매해져서 유지보수가 힘들어질 수 있음 - 사람들이 사용할 수도 있고)
     */

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos() {
        return em.createQuery(
                "select new " +
                        "jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name," +
                        "o.orderDate, o.status, d.address)" +
                        " from Order o" +
                        " join o.member m" +
                        " join o.delivery d", OrderSimpleQueryDto.class
        ).getResultList();
    }
}
