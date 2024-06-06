package raisetech.student.management.data;

import lombok.Getter;
import lombok.Setter;

/**
 * 受講生情報
 */
@Getter
@Setter
public class Student {

  private int id;
  private String fullname;
  private String furigana;
  private String nickname;
  private String mail;
  private String address;
  private int age;
  private Gender gender; //Javaでenum型を取り扱う場合、別途定義する必要がある
}
