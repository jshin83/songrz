package edu.jenshin831.lab.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
        m.addAttribute("newAlbum", new Album());

        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "allAlbums";
    }

    @PostMapping("/albums")
    public String albumSubmit(@ModelAttribute Album newAlbum) {
        albumRepository.save(newAlbum);
        return "redirect:/albums";
    }

    @GetMapping("/oneAlbum/{id}")
    public String displayAlbumDetails(@PathVariable long id, Model m) {
        //get the album deets
        Album album = albumRepository.findById(id).get();
        m.addAttribute(album);
        //get songs from the album
        Iterable<Song> allSongs = album.getSongs();
        m.addAttribute("songs", allSongs);
        return "/albumDetails";
    }


}
