package controller;

import entity.BookEntity;
import entity.CategoryEntity;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import service.EntityService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showBooks(Model model){
        List<BookEntity> bookEntityList = EntityService.findAllBook();
        model.addAttribute("bookEntityList", bookEntityList);
        model.addAttribute("book", new BookEntity());
        setCategoryDropDownList(model);
        return "home";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchBook(@RequestParam(name = "searchInput") String searchInput, Model model){
        List<BookEntity> bookEntityList;
        if (searchInput.isEmpty())
            bookEntityList = EntityService.findAllBook();
        else
            bookEntityList = EntityService.findByNameContainingOrAuthorContaining(searchInput, searchInput);
        model.addAttribute(bookEntityList);
        model.addAttribute("book", new BookEntity());
        setCategoryDropDownList(model);
        return "home";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteBook(HttpServletResponse httpServletResponse, @RequestParam int id) throws IOException {
        EntityService.deleteBookById(id);
        return "redirect:/";
    }

    private void setCategoryDropDownList(Model model){
        List<CategoryEntity> categoryEntityList = EntityService.findAllCategory();
        if (!categoryEntityList.isEmpty()){
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for (CategoryEntity category : categoryEntityList)
                cateMap.put(category.getId(), category.getName());
            model.addAttribute("categoryList", cateMap);
        }
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateBook(HttpServletResponse httpServletResponse, @ModelAttribute BookEntity book, BindingResult resultBook) throws IOException {
        EntityService.updateBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String addBook(@ModelAttribute BookEntity book, BindingResult bookResult, BindingResult detailResult){
        EntityService.addBook(book, book.getBookDetails());
        return "redirect:/";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
