package com.scosm.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @OneToMany
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private List<Address> address;

    @Email
    @NotNull
    private String email;

    @NotNull
    @Length(min = 10)
    private String telephone;

    @NotNull
    private String password;

    private Boolean status;

    private Boolean newsletter;

    private LocalDate dateAdded;

    @OneToMany
    //@JoinColumn(name = "product_id", referencedColumnName = "id")
    private Set<Product> wishList;

    @OneToMany
   //@JoinColumn(name = "product_id", referencedColumnName = "id")
    private List<Product> cart;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //TODO private List<Order> orders;


}
