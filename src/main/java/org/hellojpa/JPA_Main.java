package org.hellojpa;

import org.hellojpa.entities.Address;
import org.hellojpa.entities.Favorite_Foods;
import org.hellojpa.entities.Member;
import org.hellojpa.entities.MemberDTO.MemberDTO;
import org.hellojpa.entities.Team;
import org.hellojpa.entities.items.Movie;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

public class JPA_Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml 파일에 적혀 있는 "hello"를 parameter
        EntityManager em = emf.createEntityManager(); // 행동을 하는 일괄적인 단위(트랜잭션)마다 하나씩 생성해야 함

        EntityTransaction et = em.getTransaction(); // transaction 얻어오기
        et.begin(); // transaction 시작

        /*
        try {
            org.hellojpa.entities.Member mem = new org.hellojpa.entities.Member(); // Member.java에 저장되어 있음
            mem.setId(0);
            mem.setName("HelloB");
            em.persist(mem); // EntityManager에 저장

            et.commit(); // transaction 실행
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        // 회원 등록
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
        /*
        try {
            Member mem = new org.hellojpa.entities.Member(); // Member.java에 저장되어 있음
            mem.setName("HelloB");
            em.persist(mem); // EntityManager에 저장

            List<Member> resultList = em.createQuery("select m from Member as m", Member.class)
                    .getResultList(); // Member 객체를 대상으로 쿼리 작성(dialect를 oracle로 바꾼다고 하더라도 그대로 적용) <> 테이블을 대상으로 쿼리를 쓸 경우 DB에 종속적인 설계

            for (Member member: resultList) {
                System.out.println("\nmember ID & NAME = " + member.getId() + member.getName());
            }

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        */
        /*
        try {
            Team team = new Team();
            team.setName("Hanwha Eagles");
            em.persist(team);

            Member member = new Member();
            member.setName("konu");
            member.setTeam(team);
            em.persist(member);

            Member foundM = em.find(Member.class, member.getId());
            System.out.println("foundM's team Name : " + foundM.getTeam().getName());
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        */
        /*
        try {
            Movie movie = new Movie();
            movie.setActor("john lennon");
            movie.setDirector("hong sangsoo");

            em.persist(movie);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        */
        /*
        try {
            Member member = new Member();
            member.setName("dog");
            em.persist(member);

            em.flush();
            em.clear();

            Member foundM = em.getReference(Member.class, member.getId());
            System.out.println("foundM.getClass() = " + foundM.getClass());
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(foundM));
            System.out.println("foundM.getName() = " + foundM.getName());
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(foundM));
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        */
        /*
        try {
            Team team = new Team();
            team.setName("Hanhwa Eagles");

            Member member1 = new Member();
            member1.setName("roh shihwan");
            member1.setTeam(team);

            Member member2 = new Member();
            member2.setName("moon dongjoo");
            member2.setTeam(team);

            em.persist(team);
            em.persist(member1);
            em.persist(member2);

            em.flush();
            em.clear();

            Member foundM = em.find(Member.class, member1.getId());
            System.out.println("====================");
            System.out.println("Team Class = " + foundM.getTeam().getClass());
            System.out.println("Team Name = " + foundM.getTeam().getName());
            System.out.println("====================");
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        */
        /*
        try {
            Member member = new Member();
            member.setName("konu");

            member.getFavoriteFoods().add("americano");
            member.getFavoriteFoods().add("cigarette");

            member.getAddressHistory().add(new Address("seoul", "dokmak-ro", "111101"));
            member.getAddressHistory().add(new Address("pusan", "sazik-dong", "111101"));

            em.persist(member);
            em.flush();
            em.clear();

            // 삭제 쿼리 -> CascadeType.ALL처럼 멤버만 삭제해도 favorite_food & address 테이블에서도 일치하는 row가 삭제된다.
            // em.createQuery("delete from Member where 'MEMBER_ID' = '1'", Member.class);

            System.out.println("=========================");
            Member foundM = em.find(Member.class, member.getId());
            System.out.println("=========================");

            Set<String> tmp = foundM.getFavoriteFoods();
            System.out.println(tmp);

            Set<String> newFF = new HashSet<>();
            newFF.add("햄버거");
            newFF.add("토스트");
            foundM.setFavoriteFoods(newFF);

            tmp = foundM.getFavoriteFoods();
            System.out.println(tmp);

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        */
        /*
        try {
            Member member = new Member();
            member.setName("konu");

            member.setAddress(new Address("seoul", "dokmak-ro", "111101"));
            member.setWork_address(new Address("seoul", "baekbeom-ro", "111202"));
            member.addFoods(new Favorite_Foods("chicken"));
            member.addFoods(new Favorite_Foods("pizza"));

            em.persist(member);
            em.flush();
            em.clear();

            Member foundM = em.find(Member.class, member.getId());
            List<Favorite_Foods> foods = foundM.getFavorite_foods();
            System.out.println("member foods");
            for (Favorite_Foods food : foods)
                System.out.println(food.getFoodName());

            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }
        */

        // MEMBER_ID로 참조하니까 DB에서 저장한 대로 불러와야 한다.
        List<BigInteger> members_id = em.createNativeQuery("SELECT MEMBER_ID FROM MEMBER").getResultList();
        for (BigInteger id : members_id)
            System.out.println(id);

        // 참조 형식으로 엔티티의 일부 필드를 select할 수 있다.
        TypedQuery<String> query1 = em.createQuery("select m.name from Member m", String.class);
        List<String> query1_list = query1.getResultList();
        for (String string : query1_list)
            System.out.println(string);

        // Member 엔티티로 들여올 수도 있을 뿐더러, 리스트로 전환한 후에 멤버 중 일부를 수정하고 commit()하면 DB에 update 쿼리가 나간다.
        TypedQuery<Member> query2 = em.createQuery("select m from Member m", Member.class);
        List<Member> query2_list = query2.getResultList();
        for (Member member : query2_list)
            System.out.println(member.getId() + " : " + member.getName());
        Member member = query2_list.get(0);
        member.setName("holiday");

        // 파라미터 바인딩을 통해 쿼리를 작성할 수 있으며, chaining도 가능하다.
        Member member1 = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", "holiday")
                .getSingleResult();
        member1.setName("konu");

        // 엔티티의 일부 여러 column을 조회할 때 -> case 1 (Object type)
        Object obj = em.createQuery("select m.name, m.team from Member m").getResultList().get(0);
        Object[] obj_list = (Object[])obj;
        System.out.println("name : " + obj_list[0]);
        Team tmp_team = (Team)obj_list[1];
        System.out.println("team : " + tmp_team.getName());

        // 엔티티의 일부 여러 column을 조회할 때 -> case 2 (Class type)
        List<MemberDTO> resultList = em.createQuery("select new org.hellojpa.entities.MemberDTO.MemberDTO(m.name, m.id)" +
                        "from Member m", MemberDTO.class)
                .getResultList();

        MemberDTO memberDTO = resultList.get(0);

        System.out.println("name = " + memberDTO.getName());
        System.out.println("id = " + memberDTO.getId());

        // custom function을 활용해서 조회할 때
        List<String> list = em.createQuery("select function('group_concat', m. name)" +
                        "from Member m", String.class)
                .getResultList();
        for (String str : list)
            System.out.println("name : " + str);

        try {
            et.commit();
        } catch (Exception e) {
            et.rollback();
        } finally {
            em.close();
        }

        emf.close(); // 어플리케이션 종료 시
    }
}
