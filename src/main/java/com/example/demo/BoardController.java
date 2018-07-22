package com.example.demo;

import com.example.demo.dao.BoardDao;
import com.example.demo.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardDao boardDao;

    @RequestMapping("/write")
    public ModelAndView boardWrite(@ModelAttribute Board board) {
        return new ModelAndView("board/write");
    }


    @RequestMapping(value="/write", method = RequestMethod.POST)
    public String boardCreate(Board board) {
        //TODO set user id
        board.setAuth(0);

//        return "redirect:/"+boardDao.save(board).getId();
        boardDao.save(board);
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String boardList(Model model) {
        List<Board> boards = boardDao.findAll();
        model.addAttribute("boards", boards);

        return "board/list";
    }

    @RequestMapping(path="/{id}")
    public String boardShow(Model model, @PathVariable int id) {
        Board board = boardDao.getOne(id);
        model.addAttribute("board", board);

        return "board/show";
    }
}
