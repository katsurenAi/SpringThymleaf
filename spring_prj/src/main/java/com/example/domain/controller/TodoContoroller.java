package com.example.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.domain.entity.TodoEntity;
import com.example.domain.service.TodoService;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.domain.dto.TodoForm;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
=======

>>>>>>> parent of e80dc3e (更新処理の追加とメソッド名・変数名の変更)
@Controller
@RequestMapping("diary")
public class TodoContoroller {
    @Autowired
    TodoService todoService;
    
    //やることリスト全取得
    @GetMapping("summary")
    public String summary(Model model) {
      Iterable<TodoEntity> diarys = todoService.getAll();
      model.addAttribute("diarys", diarys);
      return "summary";    

    }
    //やることリストの行を削除する
    @PostMapping("delete")
    public String delete(@RequestParam int id) {
      todoService.delete(id);
    return "redirect:/diary/summary";
    }
  
    //やることリストの新規登録
    @PostMapping("add")
    public String add(@RequestParam String newdiary) {
      todoService.add(newdiary);
    return "redirect:/diary/summary";
    }

    //やることリストの詳細画面を表示（入力文字あり）
   @GetMapping("edit")
   String edit(Model model, TodoForm todoForm) {
    TodoEntity diary = todoService.findById(todoForm.getId());
    model.addAttribute("editdiary", diary);
    return "edit";
   }

    //やることリストのUPDATE
<<<<<<< HEAD
    @PostMapping("update")
    public Object update(@RequestBody MultiValueMap<Integer,String> multiValueMap) {
      TodoForm todoForm = new TodoForm(Integer.valueOf(multiValueMap.toSingleValueMap().get("id").toString()),
      multiValueMap.toSingleValueMap().get("bodytext").toString());
      todoService.save(todoForm);
      return "redirect:/todo/summary";
    }
=======
>>>>>>> parent of e80dc3e (更新処理の追加とメソッド名・変数名の変更)






    
    //降順
    @PostMapping("desc")
    public String desc(Model model) {
      Iterable<TodoEntity> diarys = todoService.desc();
      model.addAttribute("diarys", diarys);
      return "summary";   
    }
    //昇順
    @PostMapping("asc")
    public String asc(Model model) {
      Iterable<TodoEntity> diarys = todoService.asc();
      model.addAttribute("diarys", diarys);
      return "summary";   
    }

}

