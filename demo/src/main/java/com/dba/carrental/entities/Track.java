package com.dba.carrental.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Entity
@Table(name = "tracks")
public class Track {
    @Id
    @GeneratedValue(generator = "tracks")
    @TableGenerator(name = "tracks", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="tracks",
            initialValue=1, allocationSize=1)
    private long TrackId;

    private String Name;
    @OneToMany
    @JoinColumn(name = "AlbumId")
    private Album album;

    @OneToMany
    @JoinColumn(name = "MediaTypeId")
    private MediaType mediaTypel;

    @OneToMany
    @JoinColumn(name = "GenreId")
    private Genre genre;

    @Column(name = "Composer")
    private String composer;

    @Column(name = "Miliseconds")
    private Integer miliSeconds;

    @Column(name = "Bytes")
    private Integer bytes;

    @Column(name = "UnitPrice")
    private Integer unitPrice;

    @OneToMany(mappedBy = "track", fetch = FetchType.LAZY)
    private List<Track> tracks;
}
