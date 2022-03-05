# DesignPattern_Study_FactoryMethod

### Notion Link
https://five-cosmos-fb9.notion.site/Factory-Method-360d13ac91c64d12baccc131874f8720

### **팩토리 메서드 패턴**

팩토리 메서드 패턴은 객체를 생성하기 위해 인터페이스를 정의하지만

어떤 클래스의 인스턴스를 생성할 지에 대한 결정은 서브클래스가 내리도록 할 때 유용하게 사용된다.

<aside>
💡 = 가상 생성자 (Virtual Constructor)

</aside>

팩토리 메서드 패턴 구현 방법

1. Creator를 추상 클래스로 정의하고, 팩토리 메소드는 abstract로 선언하는 방법
2. Creator가 구체 클래스이고, 팩토리 메소드의 기본 구현을 제공하는 방법.

팩토리 메소드의 인자를 통해 다양한 Product를 생성하게 된다.

1. 팩토리 메소드에 잘못된 인자가 들어올 경우 런타임 에러 처리에 대해 고민해야 한다.
2. Enum등을 사용할 수 있다.

---

**들어가기 앞서 `팩토리 패턴`이란?!**

- 클라이언트가 오브젝트의 생성 방법을 몰라도
- ***팩토리에 어떤 오브젝트를 만들지 요청을 하면 팩토리가 만들어 주는 것!***
    - 예.
        - 강아지, 고양이를 직접 생성하지 않고
        - 팩토리에 “강아지”, “고양이” 라고 전달하면 팩토리가 생성해서 준다.
- 이 때 오브젝트를 만드는 팩토리에 추가적인 요구사항을 처리하고 싶을 수 있다.
    - 이럴 때 팩토리 자체만으로 해결하기 어려우며
    - 팩토리 메서드 패턴을 이용할 수 있다.
    - 예
        - 강아지, 고양이를 팩토리를 통해 생성할 때
        - 팩토리에서 강아지, 고양이의 개체 수, 상태 값, 날개를 단 강아지 등과 같이 추가적인 요구사항 해결!

**`팩토리` 형태의 구조**

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1197a160-54be-4a14-8e49-c1840ef9dced/Untitled.png)

**`팩토리 메서드` 형태로 변경**

- 말 그대로 Factory의 Method를 이용해 Product를 반환해내는 것이라 생각하면 된다.
    - ex. createAnimal()

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/61924bc8-e7e2-47d4-90ad-ab8a0a0f868b/Untitled.png)

<aside>
💡 꼭 하나의 오브젝트 클래스와 팩토리 클래스가 1:1 매칭이 될 필요는 없다.
**이 패턴의 핵심은 오브젝트를 만들어내는 메소드가 상속이 되었는가?
오브젝트를 만드는 클래스 안에 팩토리 메소드가 있는가?**

</aside>

### 활용성

- 어떤 클래스가 자신을 생성해야 하는 객체의 클래스를 예측할 수 없을 때
- 생성할 객체를 기술하는 책임을 자신의 서브 클래스가 지정했으면 할 때
- 객체 생성의 책임을 몇 개의 보조 서브클래스 가운데 하나에게 위임하고, 어떤 서브클래스가 위임자인지에 대한 정보를 국소화 시키고 싶을 때

### 구조

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e9af34ff-5020-48ac-87ae-fb278cf9a003/Untitled.png)

### 참여자

**Product**

- 팩토리 메서드가 생성하는 객체의 인터페이스를 정의

**ConcreateProduct**

- Product 클래스에 정의된 인터페이스를 실제로 구현

**Creator**

- Product 타입의 객체를 반환하는 팩토리 메서드를 선언
- Creator 클래스는 팩토리 메서드를 기본적으로 구현하는데,
- 이 구현에서는 ConcreateProduct 객체를 반환
- 또한 Product 객체의 생성을 위해 팩토리 메서드를 호출

**ConcreateCreator**

- 팩토리 메서드를 재정의 하여 ConcreateProduct의 인스턴스를 반환

---

---

### `팩토리 패턴`을 이용한 예제

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/95a868d5-904c-47cc-8dc3-cc872e65471b/Untitled.png)

**ChampionFactory.java**

```java
package champion;

public class ChampionFactory {
    public Champion create(ChampionType type){
        switch(type){
            case ZINX:
                return new Zinx("징크스", "징크스 Q", "징크스 W", "징크스 E", "징크스 R", "징크스 기본 패시브", "징크스 전용 패시브");
            case ZILEAN:
                return new Zilean("질리언", "질리언 Q", "질리언 W", "질리언 E", "질리언 R", "질리언 기본 패시브", "질리언 전용 패시브");
            default:
                throw new IllegalStateException();
        }
    }
}
```

**Champion, Zinx, Zilean**

```java
package champion;

public abstract class Champion {
    private String name;

    private String qSkill;
    private String wSkill;
    private String eSkill;
    private String rSkill;

    private String defaultPassive;
    private String specialPassive;

    public Champion(String name, String q, String w, String e, String r, String defaultPassive, String specialPassive) {
        this.name = name;
        this.qSkill = q;
        this.wSkill = w;
        this.eSkill = e;
        this.rSkill = r;
        this.defaultPassive = defaultPassive;
        this.specialPassive = specialPassive;
    }
}
```

```java
package champion;

public class Zinx extends Champion{
    public Zinx(String name, String q, String w, String e, String r, String defaultPassive, String specialPassive) {
        super(name, q, w, e, r, defaultPassive, specialPassive);
    }
}
```

```java
package champion;

public class Zilean extends Champion{
    public Zilean(String name, String q, String w, String e, String r, String defaultPassive, String specialPassive) {
        super(name, q, w, e, r, defaultPassive, specialPassive);
    }
}
```

**Main.java**

```java
import champion.Champion;
import champion.ChampionFactory;
import champion.ChampionType;

public class Main {

    public static void main(String[] args) {

        ChampionFactory factory = new ChampionFactory();
        Champion zinx = factory.create(ChampionType.ZINX);
        Champion zilean = factory.create(ChampionType.ZILEAN);

        System.out.println("zinx : " + zinx.toString());
        System.out.println("zilean : " + zilean.toString());
    }
}
```

```java
zinx : Champion{name='징크스', qSkill='징크스 Q', wSkill='징크스 W', eSkill='징크스 E', rSkill='징크스 R', defaultPassive='징크스 기본 패시브', specialPassive='징크스 전용 패시브'}
zilean : Champion{name='질리언', qSkill='질리언 Q', wSkill='질리언 W', eSkill='질리언 E', rSkill='질리언 R', defaultPassive='질리언 기본 패시브', specialPassive='질리언 전용 패시브'}
```

---

---

### `팩토리 메서드 패턴`을 이용한 예제

- 팩토리 패턴과 다르게 팩토리를 인터페이스화 하고
- 이를 구현한 각 구현체 팩토리를 이용하여 객체를 생성해낸다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/94667bf9-2437-4be1-840f-793d8b77a3b4/Untitled.png)

**ChampionFactory.java**

```java
package champion;

public interface ChampionFactory {
    Champion create();
}
```

**ZinxChampionFactory.java, ZileanChampionFactory.java**

```java
package champion;

public class ZileanChampionFactory implements ChampionFactory {
    @Override
    public Champion create() {
        return new Zilean("질리언", "질리언 Q", "질리언 W", "질리언 E", "질리언 R", "질리언 기본 패시브", "질리언 전용 패시브");
    }
}
```

```java
package champion;

public class ZinxChampionFactory implements ChampionFactory{

    @Override
    public Champion create() {
        return new Zinx("징크스", "징크스 Q", "징크스 W", "징크스 E", "징크스 R", "징크스 기본 패시브", "징크스 전용 패시브");
    }
}
```

**Main.java**

```java
import champion.*;

public class Main {

    public static void main(String[] args) {

        ZinxChampionFactory zinxChampionFactory = new ZinxChampionFactory();
        Champion zinx = zinxChampionFactory.create();

        ZileanChampionFactory zileanChampionFactory = new ZileanChampionFactory();
        Champion zilean = zileanChampionFactory.create();

        System.out.println("zinx : " + zinx.toString());
        System.out.println("zilean : " + zilean.toString());
    }
}
```

```java
zinx : Champion{name='징크스', qSkill='징크스 Q', wSkill='징크스 W', eSkill='징크스 E', rSkill='징크스 R', defaultPassive='징크스 기본 패시브', specialPassive='징크스 전용 패시브'}
zilean : Champion{name='질리언', qSkill='질리언 Q', wSkill='질리언 W', eSkill='질리언 E', rSkill='질리언 R', defaultPassive='질리언 기본 패시브', specialPassive='질리언 전용 패시브'}
```

**조금 더 확장 ⇒ FactorySelector**

**ChampionFactorySelector.java**

```java
package champion;

public class ChampionFactorySelector {

    public static ChampionFactory get(ChampionType type) {
        switch (type){
            case ZINX:
                return new ZinxChampionFactory();
            case ZILEAN:
                return new ZileanChampionFactory();
            default:
                throw new IllegalStateException();
        }
    }
}
```

**Main.java**

```java
import champion.*;

public class Main {

    public static void main(String[] args) {

        ChampionFactory zinxFactory = ChampionFactorySelector.get(ChampionType.ZINX);
        Champion zinx = zinxFactory.create();

        ChampionFactory zileanFactory = ChampionFactorySelector.get(ChampionType.ZILEAN);
        Champion zilean = zileanFactory.create();

        System.out.println("zinx : " + zinx.toString());
        System.out.println("zilean : " + zilean.toString());
    }
}
```
