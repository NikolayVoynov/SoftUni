package com.example.music_db.web;

import com.example.music_db.model.view.AlbumViewModel;
import com.example.music_db.sec.CurrentUser;
import com.example.music_db.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping()
    public String index(Model model) {

        if (currentUser.getId() == null) {
            return "index";
        }

        List<AlbumViewModel> albums = albumService.findAllAlbumsOrderedByCopiesInDescOrder();

        model.addAttribute("albums", albums);
        model.addAttribute("totalSoldCopies",
                albums
                        .stream()
                        .map(albumViewModel -> albumViewModel.getCopies())
                        .reduce((a, b) -> a + b)
                        .orElse(0)
        );

        return "home";
    }
}
