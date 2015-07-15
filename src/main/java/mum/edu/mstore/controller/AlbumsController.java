package mum.edu.mstore.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import mum.edu.mstore.domain.Album;
import mum.edu.mstore.service.AlbumService;
import mum.edu.mstore.service.CategoryService;
import mum.edu.mstore.utils.SpringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/secure/admin")
public class AlbumsController {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public String listAllAlbum(Model model) {
        model.addAttribute("albums", this.albumService.findAll());
        return "admin/albums";
    }

    @RequestMapping(value = "/album/add", method = RequestMethod.GET)
    public String albumAddForm(Model model) {
        model.addAttribute("album", new Album());
        model.addAttribute("categories", this.categoryService.findAll());
        return "admin/addalbum";
    }

    @RequestMapping(value = "/album/add", method = RequestMethod.POST)
    public String onSaveAlbumAddForm(@ModelAttribute @Valid Album album,
            BindingResult result, RedirectAttributes attributes, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (result.hasErrors()) {
            model.addAttribute("categories", this.categoryService.findAll());
            return "admin/addalbum";
        }
        if (!album.getImage().isEmpty()) {
            this.uploadImage(album.getImage(), request, response);
        }
        this.albumService.add(album);
        attributes.addFlashAttribute("successMsg",
                "New Album added successfully.");
        return "redirect:/secure/admin/albums";
    }

    @RequestMapping(value = "/album/edit/{id}", method = RequestMethod.GET)
    public String albumEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("categories", this.categoryService.findAll());
        Album album = this.albumService.findOne(id);
        model.addAttribute("album", album);
        model.addAttribute("image", album.getName() + ".jpg");
        return "admin/addalbum";
    }

    @RequestMapping(value = "/album/edit/{id}", method = RequestMethod.POST)
    public String onSaveAlbumEditForm(@ModelAttribute @Valid Album album,
            BindingResult result, RedirectAttributes attributes, Model model,
            HttpServletRequest request, HttpServletResponse response) {
        if (result.hasErrors()) {
            model.addAttribute("categories", this.categoryService.findAll());
            return "admin/addalbum";
        }
        if (!album.getImage().isEmpty()) {
            this.uploadImage(album.getImage(), request, response);
        }
        System.out.println(album.getId());
        this.albumService.update(album);
        attributes.addFlashAttribute("successMsg",
                "Album edited successfully.");
        return "redirect:/secure/admin/albums";
    }

    @RequestMapping(value = "/album/delete/{id}", method = RequestMethod.GET)
    public String onDeleteForm(@PathVariable Long id,
            RedirectAttributes attributes) {
        this.albumService.deleteAlbum(id);
        attributes.addFlashAttribute("successMsg",
                "Album deleted successfully.");
        return "redirect:/secure/admin/albums";
    }

    private void uploadImage(MultipartFile uploadFile, HttpServletRequest request,
            HttpServletResponse response) {
        System.out.println(uploadFile.getName());
        String rootDirectory = request.getSession().getServletContext()
                .getRealPath("/");
        System.out.println("root directory: " + rootDirectory);
        if (!uploadFile.isEmpty()) {
            try {
                uploadFile.transferTo(
                        new File(rootDirectory + "/resources/images/album/"
                                + request.getParameter("name") + ".jpg"));
                System.out.println("Image uploaded");
            } catch (IOException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("file is empty");
        }
    }

}
