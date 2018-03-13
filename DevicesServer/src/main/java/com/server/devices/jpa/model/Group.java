package com.server.devices.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    //region fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    private Group parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Group> childes;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<Device> devices;
    //endregion

    //region constructors
    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public Group(String name, Group parent) {
        this.name = name;
        this.parent = parent;
    }
    //endregion

    //region getters setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getParent() {
        return parent;
    }

    public void setParent(Group parent) {
        this.parent = parent;
    }

    public Set<Group> getChildes() {
        return childes;
    }

    public void setChildes(Set<Group> childes) {
        this.childes = childes;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }
    //endregion

    //region overrides
    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
    //endregion
}
