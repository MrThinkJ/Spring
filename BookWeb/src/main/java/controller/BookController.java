package controller;

import entity.BookEntity;
import entity.CategoryEntity;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.EntityService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    private void setCategoryDropDownList(Model model) {
        List<CategoryEntity> categoryEntityList = EntityService.findAllCategory();
        if (!categoryEntityList.isEmpty()) {
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for (CategoryEntity category : categoryEntityList)
                cateMap.put(category.getId(), category.getName());
            model.addAttribute("categoryList", cateMap);
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable int id,
                                 Model model,
                                 RedirectAttributes redirectAttributes){
        setCategoryDropDownList(model);
        if (model.containsAttribute("book"))
            return "update";
        if (EntityService.findById(id) == null){
            redirectAttributes.addFlashAttribute("error", "Can't find book with id "+id);
            return "redirect:/";
        }
        BookEntity book = EntityService.findById(id).get(0);
        model.addAttribute("book", book);
        return "update";
    }

    @RequestMapping(value = "/process-update", method = RequestMethod.POST)
    public String updateBook(@Valid @ModelAttribute("book") BookEntity book,
                             BindingResult resultBook,
                             RedirectAttributes redirectAttributes) throws IOException {
        if (resultBook.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.book", resultBook);
            redirectAttributes.addFlashAttribute("book", book);
            return "redirect:/update/"+book.getId();
        }
        EntityService.updateBook(book);
        return "redirect:/";
    }

    @GetMapping(path = "/add")
    public String showAddForm(Model model){
        if (!model.containsAttribute("book"))
            model.addAttribute("book", new BookEntity());
        setCategoryDropDownList(model);
        return "add";
    }

    @RequestMapping(value = "/process-add", method = RequestMethod.POST)
    public String addBook(@Valid @ModelAttribute("book") BookEntity book,
                          BindingResult bookResult,
                          RedirectAttributes redirectAttributes,
                          Model model){
        System.out.println(book.getBookDetails().toString());
        if (bookResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.book", bookResult);
            redirectAttributes.addFlashAttribute("book", book);
            return "redirect:/add";
        }
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
