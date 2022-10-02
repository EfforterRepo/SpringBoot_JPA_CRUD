package com.crud.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
@Data란 아래의 4가지를 합친 것
1. @Getter/@Setter
2. @ToString
3. @EqualsAndHashCode 
   - equals, hashCode를 자동으로 생성해준다.
   - equals : 두 객체의 내용이 같은지 동등성(equality)을 비교하는 연산자
   - hashCode : 두 객체가 같은 객체인지, 동일성(identity)을 비교하는 연산자
4. @RequredArgsConstructor
   - final이 붙은 필드를 모아서 생성자를 자동으로 생성해준다.
   - final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어준다.
      -> @NonNull은 자동으로 null 체크해주고, 해당 변수가 null일경우 NullPointerException 예외 처리
   - 무슨뜻인지 잘 모르겠음..
   -> 비교해서 볼 생성자 @AllArgsConstructor, @@NoArgsConstructor
*/
@Data

/*
@Entity -> JPA 어노테이션
데이터베이스의 테이블과 일대일로 매칭되는 개체 단위이며,
Entity 객체의 인스턴스 하나가 테이블에서 하나의 레코드 값을 의미한다.
객체의 인스턴스를 구분하기 위한 유일한 키값을 가지는데
이것은 테이블 상의 Primary Key 와 같은 의미를 가지며
@Id 어노테이션으로 표기 된다.
참고자료 https://www.icatpark.com/entry/JPA-%EA%B8%B0%EB%B3%B8-Annotation-%EC%A0%95%EB%A6%AC
*/
@Entity

/*
@Builder -> Builder pattern이라고 함.
객체를 정의하고 그 객체를 생성할 때 보통 생성자를 통해 생성하는 것을 생각한다.
하지만 생성자를 통해 객체를 생성하는데 몇 가지 단점이 있어
객체를 생성하는 별도 builder를 두는 방법이 있다. 이를빌더 패턴이라고 한다.
전: Bag bag = new Bag("name", 1000, "memo", "abc", "what", "is", "it", "?");
후: Bag bag = Bag.builder()
	.name("name")
    .money(1000)
	.memo("memo")
	.letter("This is the letter")
	.box("This is the box")
	.build();
 */
@Builder

/*
@AllArgsConstructor
모든 필드 값을 파라미터로 받는 생성자를 만듬.
*/
@AllArgsConstructor

/*
@NoArgsConstructor
기본 생성자를 만듬.
*/
@NoArgsConstructor
public class User_table {

	@Id
	private int memberID;
	private String loginID;
	private String password;
	private String name;
	private LocalDateTime reg_day;

}
/*
위의 문장은
1. 모든 생성자, 기본생성자, @RequredArgsConstructor 생성자를 만듬
2. Entity로 레코드값 5개를 만듬. @Id = Primary Key는 MEMBER_ID로 지정함.
3. Get/Set을 만듬.

*/

