package com.project.example.model.imdb.User_p;

import com.project.example.model.imdb.Rating_p.rating;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")

public class user {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(updatable = true , nullable = false , name = "user_name")
    private String user_name;

    @Column(updatable =true,  nullable = false, name = "password")
    private String password;

    @OneToMany( mappedBy="rating",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<rating> Rating;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updated_at;

    public void setRating(List<rating> rating) {
        Rating = rating;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

