package com.nghinv.beddingsellintroduce.controller;

import com.nghinv.beddingsellintroduce.common.Dto.Todo.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping("/")
    public String index2() {
        return "/todo/index";
    }

    @GetMapping("/index")
    public String index() {
        return "/member/index";
    }


    /*
       @RequestParam dùng để đánh dấu một biến là request param trong request gửi lên server.
       Nó sẽ gán dữ liệu của param-name tương ứng vào biến
    */
    @GetMapping("/listTodo")
    public String listTodo(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        // Trả về đối tượng todoList.
        // Nếu người dùng gửi lên param limit thì trả về sublist của todoList

        model.addAttribute("todoList", todoList);
        if (limit != null) {
            if (todoList.size() > 2) {
                model.addAttribute("todoList", todoList.subList(0, limit));
            }
        }


        // Trả về template "listTodo.html"
        return "/todo/listTodo";
    }

    // Sử dụng tạm List để chứa danh sách công việc
    // Thay cho Database.
    // Chỉ dùng cách này khi DEMO ^^
    List<Todo> todoList = new CopyOnWriteArrayList<>();

    // Đường dẫn lúc này là: /api/v1/addTodo và method GET
    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String addTodoGet(Model model) {
        model.addAttribute("todo", new Todo());
        return "/todo/addTodo";
    }

    /*
    @ModelAttribute đánh dấu đối tượng Todo được gửi lên bởi Form Request
     */
    // Đường dẫn lúc này là: /api/v1/addTodo và method POST
    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String addTodoPost(@ModelAttribute Todo todo, Model model) {
        todoList.add(todo);
        model.addAttribute("succeess", "Add Successed");
        return "/todo/success";  // Trả về trang thành công success.html
    }
}
