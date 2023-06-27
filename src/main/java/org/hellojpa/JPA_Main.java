package org.hellojpa;

import javax.persistence.*;
import java.util.List;

public class JPA_Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 파일에 적혀 있는 "hello"를 parameter
        EntityManager em = emf.createEntityManager(); // 행동을 하는 일괄적인 단위(트랜잭션)마다 하나씩 생성해야 함

        EntityTransaction et = em.getTransaction(); // transaction 얻어오기
        et.begin(); // transaction 시작
            /*
        try {
            Member mem = new Member(); // Member.java에 저장되어 있음
            mem.setId(2);
            mem.setName("HelloB");
            em.persist(mem); // EntityManager에 저장

            et.commit(); // transaction 실행
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        회원 등록
        */

            /*
        try {
            Member foundMem = em.find(Member.class, 1L); // 찾아서 가져오기
            System.out.println("foundMem.id = " + foundMem.getId());
            System.out.println("foundMem.name = " + foundMem.getName());

            em.remove(foundMem); // 찾은 데이터 삭제

            foundMem.setName("HelloZ"); // transaction 시에 바뀐 값을 체크 >>> 바뀌었으면 수정 쿼리 보냄
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        회원 수정 및 삭제
        */
        try {
            List<org.hellojpa.Member> resultList = em.createQuery("select m from Member as m", org.hellojpa.Member.class)
                    .getResultList(); // Member 객체를 대상으로 쿼리 작성(dialect를 oracle로 바꾼다고 하더라도 그대로 적용) <> 테이블을 대상으로 쿼리를 쓸 경우 DB에 종속적인 설계

            for (org.hellojpa.Member member: resultList) {
                System.out.println("member.getName() = " + member.getName());
            }

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        /* 회원 정보 여러 개 조건에 따라 조회 >>> JPQL */

        emf.close(); // 어플리케이션 종료 시
    }
}
