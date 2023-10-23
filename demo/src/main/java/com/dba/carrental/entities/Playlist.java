package com.dba.carrental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "playlis")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Playlist {
    @Id
    @GeneratedValue(generator = "playlists")
    @TableGenerator(name = "playlists", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="Playlists",
            initialValue=1, allocationSize=1)
    @OneToOne(mappedBy = "playlistId", fetch = FetchType.LAZY)
    private Integer PlayListId;
    private String Name;


}
