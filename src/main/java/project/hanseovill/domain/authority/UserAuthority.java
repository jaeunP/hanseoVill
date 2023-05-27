//package project.hanseovill.domain.authority;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import project.hanseovill.domain.User;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//
//@Getter
//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "user_authority")
//public class UserAuthority implements Serializable {
//
//    @Id
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "user_id")
//    private User userId;
//
//    @Id
//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "authority_name")
//    private Authority authorityName;
//
//    private String role;
//
//}
