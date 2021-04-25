package com.ly.po;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type",fetch=FetchType.EAGER)
    private List<Blog> blogs = new ArrayList<>();

    public Type(){

    }
}
